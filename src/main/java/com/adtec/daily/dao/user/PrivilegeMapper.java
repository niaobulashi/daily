package com.adtec.daily.dao.user;

import com.adtec.daily.bean.user.Privilege;
import com.adtec.daily.bean.user.PrivilegeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivilegeMapper {
    int countByExample(PrivilegeExample example);

    int deleteByExample(PrivilegeExample example);

    int deleteByPrimaryKey(Integer privilegeId);

    int insert(Privilege record);

    int insertSelective(Privilege record);

    List<Privilege> selectByExample(PrivilegeExample example);

    Privilege selectByPrimaryKey(Integer privilegeId);

    int updateByExampleSelective(@Param("record") Privilege record, @Param("example") PrivilegeExample example);

    int updateByExample(@Param("record") Privilege record, @Param("example") PrivilegeExample example);

    int updateByPrimaryKeySelective(Privilege record);

    int updateByPrimaryKey(Privilege record);

    List<Privilege> selectPrivilegesByUserId(@Param("userId") String userId);

    List<Privilege> selectMenusByUserId(@Param("userId") String userId);
}