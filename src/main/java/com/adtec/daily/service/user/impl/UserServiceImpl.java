package com.adtec.daily.service.user.impl;

import com.adtec.daily.bean.user.*;
import com.adtec.daily.dao.user.UserDepartmentMapper;
import com.adtec.daily.dao.user.UserMapper;
import com.adtec.daily.dao.user.UserProjectMapper;
import com.adtec.daily.dao.user.UserRoleMapper;
import com.adtec.daily.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version V1.0
 * @Description: 用户信息实现类
 * @author: 张琪
 * @date: 2018/4/8
 * @Copyright:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserProjectMapper userProjectMapper;
    @Autowired
    UserDepartmentMapper userDepartmentMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    /**
     * 查询所有用户信息
     */
    @Override
    public List<User> getAll(String roleType) {
        return userMapper.selectAllUser(roleType);
    }

    /**
     * 检验邮箱是否可用
     */
    @Override
    public boolean userCheck(String email) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        long count = userMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 用户保存
     */
    @Override
    public void saveUser(User user) {
        userMapper.insertSelective(user);
        UserDepartment userDepartment = new UserDepartment();
        userDepartment.setDeptId(user.getDeptId());
        userDepartment.setUserId(user.getUserId());
        userDepartmentMapper.insertSelective(userDepartment);
    }

    /**
     * 按照用户id查询用户
     */
    @Override
    public User getUser(String id, String roleType) {
        User user = userMapper.selectByUserId(id, roleType);
        return user;
    }

    /**
     * 按照用户姓名查询用户
     */
    @Override
    public List<User> getUserInfoByUserName(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameLike("%" + userName + "%");
        List<User> list = userMapper.selectByExample(example);
        return list;
    }

    /**
     * 用户登录查询
     */
    @Override
    public List<User> getLoginUser(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        //criteria.andUserIdEqualTo(user.getUserName());
        criteria.andEmailEqualTo(user.getEmail());
        List<User> list = userMapper.selectByExample(example);
        return list;
    }

    /**
     * 用户更新
     */
    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 通过userId获取用户
     *
     * @param userId
     */
    public User getByUserId(String userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 用户删除
     */
    @Override
    public void deleteUser(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除用户
     */
    @Override
    public void deleteBatch(List<String> ids) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andUserIdIn(ids);
        userMapper.deleteByExample(example);
    }

    /**
     * 日报列表查询
     */
    @Override
    public List<User> getUserInfoList(UserExample example) {
        List<User> userList = userMapper.selectByExample(example);
        return userList;
    }

    /**
     * 根据项目id及公司id查询项目下所有用户
     */
    @Override
    public List<User> getAllUserByProjectIdAndCompanyId(int projectId, int companyId, String roleType) {
        List<User> list = userMapper.selectAllUserByProjectIdAndCompanyId(projectId, companyId, roleType);
        return list;
    }

    /**
     * 根据用户id删除项目成员和项目角色
     *
     * @param userId
     * @return
     */
    @Override
    public void deleteByUserId(String userId, Integer userRoleId) {
        UserProjectExample example = new UserProjectExample();
        UserProjectExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        userProjectMapper.deleteByExample(example);
        //删除项目角色
        userRoleMapper.deleteByPrimaryKey(userRoleId);
    }

    /**
     * 添加项目成员
     */
    @Override
    public void projectUserSave(UserProject userProject) {
        userProjectMapper.insertSelective(userProject);
    }

    /**
     * 查询公司角色为项目经理，新增项目信息时下拉显示项目经理
     */
    @Override
    public List<User> queryUserByRoleIdForProjectUser(int roleId, String roleType) {
        List<User> list = userMapper.selectUserByRoleIdForProjectUser(roleId, roleType);
        return list;
    }

}
