package com.adtec.daily.controller.user;

import com.adtec.daily.bean.common.Message;
import com.adtec.daily.bean.common.Msg;
import com.adtec.daily.bean.user.Role;
import com.adtec.daily.bean.user.RoleExample;
import com.adtec.daily.service.user.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

/**
 * @version V1.0
 * @Description: 角色管理
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright:
 */
@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 检查角色名是否可用
     *
     * @param roleName
     * @return
     */
    @ResponseBody
    @RequestMapping("/role/roleCheck")
    public Msg userCheck(@RequestParam("roleName") String roleName) {
        //先判断角色名是否是合法的表达式;
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,10})";
        if (!roleName.matches(regx)) {
            return Msg.fail().add("va_msg", "角色名必须是6-16位数字和字母的组合或者2-10位中文");
        }

        //数据库角色名重复校验
        boolean b = roleService.roleCheck(roleName);
        if (b) {
            return Msg.success();
        } else {
            return Msg.fail().add("va_msg", "角色名不可用");
        }
    }

    /**
     * 角色保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     * @return
     */
    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveRole(@Valid Role role, BindingResult result) {
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
            role.setCreateTime(new Date());
            roleService.saveRole(role);
            return Msg.success();
        }

    }

    /**
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/delete/{ids}", method = RequestMethod.DELETE)
    public Msg updateRole(@PathVariable("ids") String ids) {
        //批量删除
        if (ids.contains("-")) {
            List<Integer> del_ids = new ArrayList<Integer>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            roleService.deleteBatch(del_ids);
        } else {
            roleService.deleteRole(Integer.parseInt(ids));
        }
        return Msg.success();
    }


    /**
     * 角色更新方法
     *
     * @param role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/role/update/{roleId}", method = RequestMethod.PUT)
    public Msg updateUser(Role role, HttpServletRequest request) {
        System.out.println("请求体中的值：" + request.getParameter("roleId"));
        role.setUpdateTime(new Date());
        roleService.updateRole(role);
        return Msg.success();
    }

    /**
     * 根据id查询角色
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/role/getRoleById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getUser(@PathVariable("id") Integer id) {
        Role role = roleService.getRole(id);
        return Msg.success().add("role", role);
    }


    /**
     * 导入jackson包。
     *
     * @param
     * @return
     */
    @RequestMapping("/role/getRoles")
    @ResponseBody
    public Message getRoleWithJson(int page, int limit) {
        PageHelper.startPage(page, limit);
        RoleExample example = new RoleExample();
        example.setOrderByClause("create_time asc");
        List<Role> pros = roleService.getAll(example);
        return Message.success().add(pros);
    }

    /**
     * 获取指定类型角色信息。
     *
     * @param roleType
     * @return
     */
    @RequestMapping("/role/getSpecificRoles")
    @ResponseBody
    public Message getSpecificRoles(String roleType) {
        List<Role> roleList = roleService.getSpecificRoles(roleType);
        return Message.success().add(roleList);
    }

}
