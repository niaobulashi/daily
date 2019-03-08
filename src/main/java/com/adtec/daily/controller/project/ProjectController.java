package com.adtec.daily.controller.project;

import com.adtec.daily.bean.common.Message;
import com.adtec.daily.bean.common.Msg;
import com.adtec.daily.bean.project.Project;
import com.adtec.daily.bean.project.ProjectExample;
import com.adtec.daily.bean.project.ProjectTemplate;
import com.adtec.daily.bean.user.*;
import com.adtec.daily.service.project.ProjectService;
import com.adtec.daily.service.project.ProjectTemplateService;
import com.adtec.daily.service.user.UserProjectService;
import com.adtec.daily.service.user.UserRoleService;
import com.adtec.daily.service.user.UserService;
import com.adtec.daily.util.Constants;
import com.adtec.daily.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * 处理项目CRUD请求
 */
@Controller
public class ProjectController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserProjectService userProjectService;
    @Autowired
    ProjectTemplateService projectTemplateService;

    /**
     * 项目更新方法
     *
     * @param project
     * @return
     */
    @RequestMapping(value = "/project/updateProjectInfo", method = RequestMethod.POST)
    @ResponseBody
    public Msg updateProject(@Valid Project project, BindingResult result) {
        //查询是否存在
        project.setUpdateTime(new Date());
        project.setUpdateUserId(project.getUserId());
        project.setWorkStartTime(DateUtil.StrToTime(project.getWorkStartTimeStr()));
        project.setMorningEndTime(DateUtil.StrToTime(project.getMorningEndTimeStr()));
        project.setAfterStartTime(DateUtil.StrToTime(project.getAfterStartTimeStr()));
        project.setWorkEndTime(DateUtil.StrToTime(project.getWorkEndTimeStr()));
        project.setOverworkStartTime(DateUtil.StrToTime(project.getOverworkStartTimeStr()));
        projectService.updateProject(project);
        return Msg.success();
    }

    /**
     * 根据id查询项目
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/project/getProjectById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getProject(@PathVariable("id") Integer id) {
        Project project = projectService.getProject(id);
        return Msg.success().add("id", project);
    }

    /**
     * 检查项目编号是否可用
     *
     * @param projectCode
     * @return
     */
    @ResponseBody
    @RequestMapping("/project/checkProject")
    public Msg checkProject(@RequestParam("projectCode") String projectCode) {
        //数据库项目名重复校验
        boolean b = projectService.checkProject(projectCode);
        if (b) {
            return Msg.success();
        } else {
            return Msg.fail().add("va_msg", "项目编号不可用");
        }
    }

    /**
     * 项目保存
     *
     * @return
     */
    @RequestMapping(value = "/project/addProject", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveProject(@Valid Project project, BindingResult result) {
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
            //查询是否存在
            ProjectExample projectExample = new ProjectExample();
            ProjectExample.Criteria cri = projectExample.createCriteria();
            cri.andProjectCodeEqualTo(project.getProjectCode());
            cri.andProjectNameEqualTo(project.getProjectName());
            List<Project> projectList = projectService.selectByExample(projectExample);
            if (projectList.size() > 0) {
                return Msg.dateExist();
            }
            project.setCreateTime(new Date());
            project.setWorkStartTime(DateUtil.StrToTime(project.getWorkStartTimeStr()));
            project.setMorningEndTime(DateUtil.StrToTime(project.getMorningEndTimeStr()));
            project.setAfterStartTime(DateUtil.StrToTime(project.getAfterStartTimeStr()));
            project.setWorkEndTime(DateUtil.StrToTime(project.getWorkEndTimeStr()));
            project.setOverworkStartTime(DateUtil.StrToTime(project.getOverworkStartTimeStr()));
            projectService.saveProject(project);

            //查询出项目ID
            List<Project> projectList2 = projectService.selectByExample(projectExample);

            //添加用户项目关联信息
            UserProject userProject = new UserProject();
            userProject.setUserId(project.getProjectUserId());
            userProject.setProjectId(projectList2.get(0).getId());
            userService.projectUserSave(userProject);

            // 第二次添加项目信息，就无需变更用户角色表信息
            UserRoleExample userRoleExample = new UserRoleExample();
            UserRoleExample.Criteria cri1 = userRoleExample.createCriteria();
            cri1.andUserIdEqualTo(project.getProjectUserId());
            cri1.andRoleIdEqualTo(Integer.parseInt(Constants.ROLE_ID_PROJECT_BOSS));
            List<UserRole> userRoleList = userRoleService.selectUserRole(userRoleExample);
            if (userRoleList.size() == 0) {
                //添加成员的项目角色，默认为项目经理ROLE_ID_PROJECT_BOSS='5'
                UserRole userRole = new UserRole();
                userRole.setUserId(project.getProjectUserId());
                userRole.setRoleId(Integer.parseInt(Constants.ROLE_ID_PROJECT_BOSS));
                userRole.setCreateTime(new Date());
                userRoleService.saveUserRole(userRole);
            }

            //添加项目模板
            ProjectTemplate projectTemplate = new ProjectTemplate();
            projectTemplate.setProjectId(projectList2.get(0).getId());
            projectTemplate.setTemplateType(Constants.PERSONAL_WEEKLY);
            projectTemplate.setTemplateFileName(Constants.ADTEC_WEEKLY);
            projectTemplate.setCreateTime(new Date());
            projectTemplateService.save(projectTemplate);

            return Msg.success();
        }
    }

    /**
     * 管理员查询所有项目信息
     *
     * @param pn
     * @return
     */
    @RequestMapping("/project/getProjectInfo")
    @ResponseBody
    public Msg getProsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Project> pros = projectService.getAll();
        PageInfo page = new PageInfo(pros, 5);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 员工查询所属项目信息
     *
     * @return
     */
    @RequestMapping("/project/getProjectByUser")
    @ResponseBody
    public Message getProjectByUser(User user) {
        PageHelper.startPage(user.getPage(), user.getLimit());
        // 根据用户编号查询判断角色信息
        // 1.管理端查询所有项目信息
        // 根据
        List<Project> pros = projectService.getProjectByUser(user.getUserId());
        return Message.success().add(pros);
    }

    /**
     * 查询项目列表下拉框
     *
     * @return
     */
    @RequestMapping(value = "/project/getProjectNameList", method = RequestMethod.POST)
    @ResponseBody
    public Msg getPros(String userId) {
        List<Project> list = projectService.getProjectByUser(userId);
        return Msg.success().add("pros", list);
    }

    /**
     * 根据项目id查询项目成员
     *
     * @param user
     * @return
     */
    @RequestMapping("/project/getProjectUserByProjectId")
    @ResponseBody
    public Message getProjectUserByProjectId(User user) {
        PageHelper.startPage(user.getPage(), user.getLimit());
        int companyId = 0;
        List<User> users = userService.getAllUserByProjectIdAndCompanyId(user.getProjectId(), companyId, user.getRoleType());
        return Message.success().add(users);
    }

    /**
     * 删除项目成员
     *
     * @param userId
     * @param userRoleId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "project/deleteProjectUser/{id}/{userRoleId}", method = RequestMethod.DELETE)
    public Msg updateUser(@PathVariable("id") String userId, @PathVariable("userRoleId") Integer userRoleId) {

        userService.deleteByUserId(userId, userRoleId);

        return Msg.success();
    }

    /**
     * 添加项目成员
     *
     * @param ids
     * @param projectId
     * @param roleIds
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/project/projectUserSave", method = RequestMethod.GET)
    public List<Project> projectUserSave(String ids, int projectId, String roleIds) {

        String[] save_ids = ids.split("-");
        String[] roleIdArr = roleIds.split("-");
        List<Project> resultList = new ArrayList<Project>();
        int i = 0;
        //组装id的集合
        for (String userId : save_ids) {
            //查询员工有无项目
            List<Project> projects = projectService.getProjectByUser(userId);
            if (projects != null && projects.size() > 0) {
                return projects;
            }
        }
        //员工没有项目，则进行保存
        for (String userId : save_ids) {
            //添加成员
            UserProject userProject = new UserProject();
            userProject.setUserId(userId);
            userProject.setProjectId(projectId);
            userService.projectUserSave(userProject);
            //添加成员的项目角色
            Integer roleId = Integer.parseInt(roleIdArr[i]);
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRole.setCreateTime(new Date());
            userRoleService.saveUserRole(userRole);
            i = i + 1;
        }
        return resultList;
    }

    /**
     * 删除项目信息
     * 需要删除：t_user_role.role_id='5'、t_project、t_user_project
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "project/delProjectInfo", method = RequestMethod.POST)
    public Msg delProjectInfo(String proId, String userId) {

        //1.删除t_user_role表，若该经理有多个项目，不删此数据；若只有一个项目，则删此数据
        ProjectExample projectExample = new ProjectExample();
        ProjectExample.Criteria cri1 = projectExample.createCriteria();
        cri1.andProjectUserIdEqualTo(userId);
        List<Project> projectList = projectService.selectByExample(projectExample);
        if (projectList.size() == 1) {
            UserRoleExample userRoleExample = new UserRoleExample();
            UserRoleExample.Criteria cri2 = userRoleExample.createCriteria();
            cri2.andUserIdEqualTo(userId);
            cri2.andRoleIdEqualTo(Integer.parseInt(Constants.ROLE_ID_PROJECT_BOSS));
            userRoleService.deleteUserRoleByExample(userRoleExample);
        }
        //2.删除t_project表
        projectService.deleteProject(Integer.parseInt(proId));
        //3.删除t_user_project表
        UserProjectExample userProjectExample = new UserProjectExample();
        UserProjectExample.Criteria cri3 = userProjectExample.createCriteria();
        cri3.andProjectIdEqualTo(Integer.parseInt(proId));
        userProjectService.deleteUserProjectByExample(userProjectExample);

        return Msg.success();
    }
}
