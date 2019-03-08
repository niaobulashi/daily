package com.adtec.daily.controller.project;

import com.adtec.daily.bean.common.Msg;
import com.adtec.daily.bean.project.Department;
import com.adtec.daily.service.project.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version V1.0
 * @Description: 部门信息
 * @author: 胡浪
 * @date: 2018/4/9
 * @Copyright:
 */
@Controller
public class DepartmentController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private DepartmentService departmentService;

    /**
     * 返回所有的部门信息
     */
    @RequestMapping("/department/getDepartment")
    @ResponseBody
    public Msg getDepts(){
        //查出的所有部门信息
        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts", list);
    }

    /**
     * 返回所属公司的所有部门信息
     */
    @RequestMapping(value = "/department/getDepartmentsByCompanyId",method = RequestMethod.POST)
    @ResponseBody
    public Msg getDepartmentsByCompanyId(Integer companyId){
        //查出所属公司的所有部门信息
        List<Department> list = departmentService.getDepartmentsByCompanyId(companyId);
        return Msg.success().add("depts", list);
    }
}
