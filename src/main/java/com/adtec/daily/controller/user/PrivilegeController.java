package com.adtec.daily.controller.user;

import com.adtec.daily.bean.common.Msg;
import com.adtec.daily.bean.user.Privilege;
import com.adtec.daily.service.user.PrivilegeService;
import com.adtec.daily.service.user.RolePrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version V1.0
 * @Description: 权限相关类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright:
 */
@Controller
public class PrivilegeController {


    @Autowired
    PrivilegeService privilegeService;
    @Autowired
    RolePrivilegeService rolePrivilegeService;

    /**
     * 获取权限列表。
     *
     * @return
     */
    @RequestMapping("/privilege/getPrivileges")
    @ResponseBody
    public Msg getPrivileges() {
        List<Privilege> pros = privilegeService.getAll();
        return Msg.success().add("resultList", pros);
    }


}
