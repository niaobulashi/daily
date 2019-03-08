package com.adtec.daily.controller.user;

import com.adtec.daily.bean.common.Message;
import com.adtec.daily.bean.common.Msg;
import com.adtec.daily.bean.project.Company;
import com.adtec.daily.bean.project.Department;
import com.adtec.daily.bean.project.Project;
import com.adtec.daily.bean.user.Privilege;
import com.adtec.daily.bean.user.User;
import com.adtec.daily.bean.user.UserRole;
import com.adtec.daily.service.project.CompanyService;
import com.adtec.daily.service.project.DepartmentService;
import com.adtec.daily.service.project.ProjectService;
import com.adtec.daily.service.user.RolePrivilegeService;
import com.adtec.daily.service.user.UserRoleService;
import com.adtec.daily.service.user.UserService;
import com.adtec.daily.util.Constants;
import com.adtec.daily.util.RSACoder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * @version V1.0
 * @Description: 用户管理
 * @author: 张琪
 * @date: 2018/4/8
 */
@Controller
public class UserController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    // 公钥地址
    private String publicKeyPath;
    // 私钥地址
    private String privateKeyPath;

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    RolePrivilegeService rolePrivilegeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    CompanyService companyService;


    /**
     * 检查邮箱是否可用
     *
     * @param email
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/userCheck")
    public Msg userCheck(@RequestParam("email") String email) {

        //数据库邮箱重复校验
        boolean b = userService.userCheck(email);
        if (b) {
            return Msg.success();
        } else {
            return Msg.fail().add("va_msg", "邮箱不可用");
        }
    }

    /**
     * 员工保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     * @return
     */
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveUser(@Valid User user, BindingResult result,@RequestParam Integer roleId) throws Exception{
        String publicKey = (String) getPublicKey().getExtend().get("publicKey");
        if (result.hasErrors()) {
            //校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            user.setUserId("USER" + String.valueOf(System.currentTimeMillis()));
            user.setCreateTime(new Date());
            byte[] bytes = RSACoder.encryptByPublicKey(user.getPassword(), publicKey);
            String encryPassword =  RSACoder.encryptBASE64(bytes);
            user.setPassword(encryPassword);
            userService.saveUser(user);
            UserRole userRole = new UserRole();
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(roleId);
            userRole.setCreateTime(new Date());
            userRoleService.saveUserRole(userRole);
            return Msg.success();
        }

    }

    /**
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     *
     * @param ids
     * @param userRoleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/delete/{ids}/{userRoleId}", method = RequestMethod.DELETE)
    public Msg updateUser(@PathVariable("ids") String ids,@PathVariable("userRoleId") Integer userRoleId) {
        //删除用户
        userService.deleteUser(ids);
        //删除用户对应的部门角色
        userRoleService.deleteUserRole(userRoleId);

        return Msg.success();
    }


    /**
     * 用户更新方法
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/update/{userId}/{userRoleId}", method = RequestMethod.PUT)
    public Msg updateUser(User user, Integer roleId , HttpServletRequest request) {
        System.out.println("请求体中的值：" + request.getParameter("userId"));
        user.setUpdateTime(new Date());
        userService.updateUser(user);
        if (user.getRoleId() != null) {
            UserRole userRole = new UserRole();
            userRole.setId(user.getUserRoleId());
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(roleId);
            userRole.setUpdateTime(new Date());
            userRoleService.updateUserRole(userRole);
        }
        return Msg.success();
    }

    /**
     * 根据id查询员工
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/selectUserById", method = RequestMethod.POST)
    public Msg getUser( String id,String roleType) {
        User user = userService.getUser(id,roleType);
        return Msg.success().add("user", user);
    }


    /**
     * 导入jackson包。
     *
     * @param
     * @return
     */
    @RequestMapping("/user/getUsers")
    @ResponseBody
    public Message getUserWithJson(User user) {
        PageHelper.startPage(user.getPage(), user.getLimit());
        List<User> pros = userService.getAll(user.getRoleType());
        return Message.success().add(pros);
    }

    /**
     * 根据id查询用户，并分页
     *
     * @param user
     * @return
     */
    @RequestMapping("/user/getUserInfoByUserName")
    @ResponseBody
    public Message getUserInfoByUserName(User user) {
        PageHelper.startPage(user.getPage(), user.getLimit());
        List<User> pros = userService.getUserInfoByUserName(user.getUserName());
        return Message.success().add(pros);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Msg getLoginUser(HttpServletRequest request, User user, @RequestParam(value = "encrypted") String encrypted)throws Exception {


        String privateKey = getPrivateKey();
        byte[] decodedData = RSACoder.decryptByPrivateKey(encrypted, privateKey);
        //输入密码
        String outputStr = new String(decodedData);

        logger.info("输入密码为："+outputStr);

        /*String publicKey = (String) getPublicKey().getExtend().get("publicKey");
        byte[] bytes1 = RSACoder.encryptByPublicKey(outputStr, publicKey);
        String encryPassword =  RSACoder.encryptBASE64(bytes1);
        logger.info("加密后的密文：" + encryPassword);*/

        List<User> list = userService.getLoginUser(user);
        if (list != null && list.size()>0){
            String password = list.get(0).getPassword();
            byte[] bytes = RSACoder.decryptByPrivateKey(password,privateKey);
            //用户的密码
            String passwordLogin = new String(bytes);
            logger.info("用户的密码为："+passwordLogin);
            if (passwordLogin.equals(outputStr) ) {
                User resultUser = list.get(0);
                String userId = resultUser.getUserId();
                List<Privilege> privileges = rolePrivilegeService.getPrivilegesByUserId(userId);
                List privilegeList = new ArrayList<String>();
                for (Privilege privilege : privileges) {
                    privilegeList.add(privilege.getPrivilegeId());
                }
                resultUser.setPrivilegeList(privilegeList);
                request.getSession().setAttribute("user", resultUser);
                Project project = projectService.selectByUserId(userId);
                request.getSession().setAttribute("project", project);
                Department department = departmentService.selectByUserId(userId);
                request.getSession().setAttribute("department", department);
                Map<Privilege, List<Privilege>> menus = rolePrivilegeService.selectMenusByUserId(userId);
                request.getSession().setAttribute("menus", menus);
                return Msg.success();
            }else{
                return Msg.fail();
            }
        }
        return Msg.fail();
    }

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/userExit", method = RequestMethod.POST)
    @ResponseBody
    public Msg userExit(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return Msg.fail();
        } else {
            request.getSession().removeAttribute("user");
            request.getSession().removeAttribute("project");
            request.getSession().removeAttribute("department");
            return Msg.success();
        }
    }

    /**
     * 用户修改密码
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/updatePasswprd", method = RequestMethod.POST)
    public Msg updatePasswprd(User user, HttpServletRequest request) throws Exception{
        User userInfo = userService.getByUserId(user.getUserId());
        //用户的密码解密
        String privateKey = getPrivateKey();
        byte[] decodedData = RSACoder.decryptByPrivateKey(userInfo.getPassword(), privateKey);
        String outputStr = new String(decodedData);
        if(outputStr.equals(user.getOldPassword())){
            //获取公钥加密
            String publicKey = (String) getPublicKey().getExtend().get("publicKey");
            byte[] bytes = RSACoder.encryptByPublicKey(user.getPassword(), publicKey);
            String encryPassword =  RSACoder.encryptBASE64(bytes);
            user.setPassword(encryPassword);
            userService.updateUser(user);
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    /**
     * 查询公司角色为项目经理，新增项目信息时下拉显示项目经理
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/queryUserByRoleIdForProjectUser", method = RequestMethod.POST)
    public Msg queryUserByRoleIdForProjectUser() {
        List<User> list = userService.queryUserByRoleIdForProjectUser(Integer.parseInt(Constants.ROLE_ID_COMPANY_LEADER), Constants.ROLE_TYPE_DEPARTMENT);
        return Msg.success().add("pros", list);
    }
    /**
     * 获取公钥
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/getPublicKey")
    public Msg getPublicKey() throws Exception {
        File resPath = new File(this.getClass().getResource("/").getPath());
        logger.info("resPath:" + resPath);
        publicKeyPath = resPath + ResourceBundle.getBundle("config").getString("publicKeyPath");
        logger.info("publicKeyPath:" + publicKeyPath);
        char[] bytes = new char[1024];
        // 获取公钥
        FileReader b1 = new FileReader(publicKeyPath);
        b1.read(bytes);
        b1.close();
        String publicKey = new String(bytes);
        publicKey = publicKey.trim();
        return Msg.success().add("publicKey", publicKey);
    }

    /**
     * 获取私钥
     *
     * @return
     */
    public String getPrivateKey() throws Exception {
        File resPath = new File(this.getClass().getResource("/").getPath());
        privateKeyPath = resPath + ResourceBundle.getBundle("config").getString("privateKeyPath");
        char[] bytes = new char[1024];
        // 获取私钥
        FileReader b1 = new FileReader(privateKeyPath);
        b1.read(bytes);
        b1.close();
        String privateKey = new String(bytes);
        privateKey = privateKey.trim();
        return privateKey;
    }

    /**
     * 查询当前用户所属项目下的所有用户
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/getProjectUserList", method = RequestMethod.POST)
    public Message getProjectUserList(HttpServletRequest request, HttpServletResponse response) {
        Project project = (Project)request.getSession().getAttribute("project");
        Department department = (Department)request.getSession().getAttribute("department");
        Company company =  companyService.selectByDeptId(department.getDeptId());
        //TUser user = (TUser)request.getSession().getAttribute("user");
        List<User> users = userService.getAllUserByProjectIdAndCompanyId(project.getId(),company.getCompanyId(), Constants.ROLE_TYPE_PROJECT);
        return Message.success().add(users);
    }
}
