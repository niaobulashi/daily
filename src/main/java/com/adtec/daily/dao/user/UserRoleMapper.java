package com.adtec.daily.dao.user;

import com.adtec.daily.bean.user.UserRole;
import com.adtec.daily.bean.user.UserRoleExample;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserRoleMapper {
    long countByExample(UserRoleExample example);

    int deleteByExample(UserRoleExample example);

    @Delete({
        "delete from t_user_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_user_role (id, user_id, ",
        "role_id, create_time, ",
        "create_user_id, update_time, ",
        "update_user_id, remark1, ",
        "remark2, remark3)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, ",
        "#{roleId,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createUserId,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updateUserId,jdbcType=VARCHAR}, #{remark1,jdbcType=VARCHAR}, ",
        "#{remark2,jdbcType=VARCHAR}, #{remark3,jdbcType=VARCHAR})"
    })
    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    @Select({
        "select",
        "id, user_id, role_id, create_time, create_user_id, update_time, update_user_id, ",
        "remark1, remark2, remark3",
        "from t_user_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.adtec.daily.dao.user.UserRoleMapper.BaseResultMap")
    UserRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByPrimaryKeySelective(UserRole record);

    @Update({
        "update t_user_role",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "role_id = #{roleId,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "remark1 = #{remark1,jdbcType=VARCHAR},",
          "remark2 = #{remark2,jdbcType=VARCHAR},",
          "remark3 = #{remark3,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserRole record);
}