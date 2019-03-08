package com.adtec.daily.service.user.impl;

import com.adtec.daily.bean.user.Role;
import com.adtec.daily.bean.user.RoleExample;
import com.adtec.daily.dao.user.RoleMapper;
import com.adtec.daily.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Description: 用户角色实现类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright:
 */
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
    RoleMapper roleMapper;

	/**
	 * 查询所有角色信息
	 */
    @Override
	public List<Role> getAll(RoleExample example) {
		return roleMapper.selectByExample(example);
	}

	/**
	 * 检验角色名是否可用
	 */
    @Override
	public boolean roleCheck(String roleName) {
		RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		criteria.andRoleNameEqualTo(roleName);
		long count = roleMapper.countByExample(example);
		return count == 0;
	}

	/**
	 * 角色保存
	 */
    @Override
	public void saveRole(Role role) {
		roleMapper.insertSelective(role);
	}

	/**
	 * 按照用户id查询用户
	 */
    @Override
	public Role getRole(Integer id) {
		Role tUser = roleMapper.selectByPrimaryKey(id);
		return tUser;
	}

	/**
	 * 角色更新
	 */
    @Override
	public void updateRole(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
	}

	/**
	 * 角色删除
	 */
    @Override
	public void deleteRole(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
	}

    /**
     * 批量删除角色
     */
    @Override
	public void deleteBatch(List<Integer> ids) {
        RoleExample example = new RoleExample();
		RoleExample.Criteria criteria = example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andRoleIdIn(ids);
        roleMapper.deleteByExample(example);
	}

	/**
	 * 查询所有特定类型的角色信息
	 */
    @Override
	public List<Role> getSpecificRoles(String roleType) {
		return roleMapper.selectByRoleType(roleType);
	}
}
