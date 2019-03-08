package com.adtec.daily.service.user;

import com.adtec.daily.bean.user.Privilege;
import com.adtec.daily.bean.user.RolePrivilege;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Description: 角色菜单接口类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright:
 */
public interface RolePrivilegeService {

    /**
     * 保存角色权限信息
     *
     * @param rolePrivilege
     */
    void savePrivilege(RolePrivilege rolePrivilege);

    /**
     * 删除角色所有权限信息
     *
     * @param roleId
     */
    void deleteById(Integer roleId);

    /**
     * 按照角色id查询权限
     *
     * @param roleId
     * @return
     */
    List<RolePrivilege> getPrivilegesByRoleId(Integer roleId);

    /**
     * 按照用户id查询用户权限列表
     *
     * @param userId
     * @return
     */
    List<Privilege> getPrivilegesByUserId(String userId);

    /**
     * 按照用户id查询菜单列表
     *
     * @param userId
     * @return
     */
    Map<Privilege, List<Privilege>> selectMenusByUserId(String userId);
}
