package com.adtec.daily.service.user.impl;

import com.adtec.daily.bean.user.UserProjectExample;
import com.adtec.daily.dao.user.UserProjectMapper;
import com.adtec.daily.service.user.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/28
 * @Copyright:
 */
@Service
public class UserProjectServiceImpl implements UserProjectService{

    @Autowired
    UserProjectMapper userProjectMapper;

    /**
     * 根据条件删除用户项目关联表
     */
    @Override
    public void deleteUserProjectByExample(UserProjectExample example){
        userProjectMapper.deleteByExample(example);
    }
}
