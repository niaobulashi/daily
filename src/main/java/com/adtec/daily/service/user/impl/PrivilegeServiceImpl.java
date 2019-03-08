package com.adtec.daily.service.user.impl;

import com.adtec.daily.bean.user.Privilege;
import com.adtec.daily.dao.user.PrivilegeMapper;
import com.adtec.daily.service.user.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Description: 菜单权限实现类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright:
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	@Autowired
    PrivilegeMapper privilegeMapper;

	/**
	 * 查询所有权限信息
	 */
    @Override
	public List<Privilege> getAll() {
		return privilegeMapper.selectByExample(null);
	}

}
