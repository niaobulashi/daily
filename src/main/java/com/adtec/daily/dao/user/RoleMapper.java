package com.adtec.daily.dao.user;

import com.adtec.daily.bean.user.Role;
import com.adtec.daily.bean.user.RoleExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    @Delete({
            "delete from t_role",
            "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer roleId);

    @Insert({
            "insert into t_role (role_id, role_name, ",
            "role_type, description, ",
            "create_time, create_user_id, ",
            "update_time, update_user_id, ",
            "remark1, remark2, ",
            "remark3)",
            "values (#{roleId,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
            "#{roleType,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{createUserId,jdbcType=VARCHAR}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{updateUserId,jdbcType=VARCHAR}, ",
            "#{remark1,jdbcType=VARCHAR}, #{remark2,jdbcType=VARCHAR}, ",
            "#{remark3,jdbcType=VARCHAR})"
    })
    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    @Select({
            "select",
            "role_id, role_name, role_type, description, create_time, create_user_id, update_time, ",
            "update_user_id, remark1, remark2, remark3",
            "from t_role",
            "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    @ResultMap("com.adtec.daily.dao.user.RoleMapper.BaseResultMap")
    Role selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    @Update({
            "update t_role",
            "set role_name = #{roleName,jdbcType=VARCHAR},",
            "role_type = #{roleType,jdbcType=VARCHAR},",
            "description = #{description,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_user_id = #{createUserId,jdbcType=VARCHAR},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "remark1 = #{remark1,jdbcType=VARCHAR},",
            "remark2 = #{remark2,jdbcType=VARCHAR},",
            "remark3 = #{remark3,jdbcType=VARCHAR}",
            "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Role record);

    List<Role> selectByRoleType(String roleType);
}