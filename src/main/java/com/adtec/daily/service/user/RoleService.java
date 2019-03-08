package com.adtec.daily.service.user;

import com.adtec.daily.bean.user.Role;
import com.adtec.daily.bean.user.RoleExample;

import java.util.List;

/**
 * @version V1.0
 * @Description: 用户角色接口类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright:
 */
public interface RoleService {

    /**
     * 查询所有角色信息
     *
     * @param example
     * @return
     */
    List<Role> getAll(RoleExample example);

    /**
     * 检验角色名是否可用
     *
     * @param roleName
     * @return  true：代表当前姓名可用   fasle：不可用
     */
    boolean roleCheck(String roleName);

    /**
     * 角色保存
     *
     * @param role 角色信息
     */
    void saveRole(Role role);

    /**
     * 按照用户id查询用户
     *
     * @param id
     * @return
     */
    Role getRole(Integer id);

    /**
     * 角色更新
     *
     * @param role
     */
    void updateRole(Role role);

    /**
     * 角色删除
     *
     * @param id
     */
    void deleteRole(Integer id);

    /**
     * 批量删除角色
     *
     * @param ids
     */
    void deleteBatch(List<Integer> ids);

    /**
     * 查询所有特定类型的角色信息
     *
     * @param roleType
     * @return
     */
    List<Role> getSpecificRoles(String roleType);
}
