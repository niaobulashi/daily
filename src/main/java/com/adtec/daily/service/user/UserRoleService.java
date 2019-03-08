package com.adtec.daily.service.user;


import com.adtec.daily.bean.user.UserRole;
import com.adtec.daily.bean.user.UserRoleExample;

import java.util.List;


/**
 * @version V1.0
 * @Description: 用户角色接口类
 * @author: 张琪
 * @date: 2018/4/19
 * @Copyright:
 */
public interface UserRoleService {

    /**
     * 保存用户角色信息
     *
     * @param userRole
     */
    void saveUserRole(UserRole userRole);

    /**
     * 用户角色信息更新
     *
     * @param userRole
     */
    void updateUserRole(UserRole userRole);

    /**
     * 删除用户的部门角色信息
     *
     * @param userRoleId
     */
    void deleteUserRole(Integer userRoleId);

    /**
     * 查询用户角色信息表
     *
     * @param example
     * @return
     */
    List<UserRole> selectUserRole(UserRoleExample example);

    /**
     * 根据条件删除用户的部门角色信息
     *
     * @param example
     */
    void deleteUserRoleByExample(UserRoleExample example);
}
