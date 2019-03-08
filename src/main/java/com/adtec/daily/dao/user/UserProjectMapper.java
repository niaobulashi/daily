package com.adtec.daily.dao.user;

import com.adtec.daily.bean.user.UserProject;
import com.adtec.daily.bean.user.UserProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserProjectMapper {
    int countByExample(UserProjectExample example);

    int deleteByExample(UserProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserProject record);

    int insertSelective(UserProject record);

    List<UserProject> selectByExample(UserProjectExample example);

    UserProject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserProject record, @Param("example") UserProjectExample example);

    int updateByExample(@Param("record") UserProject record, @Param("example") UserProjectExample example);

    int updateByPrimaryKeySelective(UserProject record);

    int updateByPrimaryKey(UserProject record);
}