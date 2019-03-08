package com.adtec.daily.dao.user;

import com.adtec.daily.bean.user.User;
import com.adtec.daily.bean.user.UserExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    @Delete({
            "delete from t_user",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
            "insert into t_user (user_id, user_name, ",
            "password, gender, ",
            "email, identity_no, ",
            "mobile, create_time, ",
            "create_user_id, update_time, ",
            "update_user_id, remark1, ",
            "remark2, remark3)",
            "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR}, #{gender,jdbcType=VARCHAR}, ",
            "#{email,jdbcType=VARCHAR}, #{identityNo,jdbcType=VARCHAR}, ",
            "#{mobile,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
            "#{createUserId,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
            "#{updateUserId,jdbcType=VARCHAR}, #{remark1,jdbcType=VARCHAR}, ",
            "#{remark2,jdbcType=VARCHAR}, #{remark3,jdbcType=VARCHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    @Select({
            "select",
            "user_id, user_name, password, gender, email, identity_no, mobile, create_time, ",
            "create_user_id, update_time, update_user_id, remark1, remark2, remark3",
            "from t_user",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @ResultMap("com.adtec.daily.dao.user.UserMapper.BaseResultMap")
    User selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    @Update({
            "update t_user",
            "set user_name = #{userName,jdbcType=VARCHAR},",
            "password = #{password,jdbcType=VARCHAR},",
            "gender = #{gender,jdbcType=VARCHAR},",
            "email = #{email,jdbcType=VARCHAR},",
            "identity_no = #{identityNo,jdbcType=VARCHAR},",
            "mobile = #{mobile,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_user_id = #{createUserId,jdbcType=VARCHAR},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "remark1 = #{remark1,jdbcType=VARCHAR},",
            "remark2 = #{remark2,jdbcType=VARCHAR},",
            "remark3 = #{remark3,jdbcType=VARCHAR}",
            "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);

    // 联合表根据ID查询具体需求信息
    User selectByUserId(@Param("userId") String userId, @Param("roleType") String roleType);

    // 查询用户的基本信息带角色信息
    List<User> selectAllUser(String roleType);

    // 根据项目ID及公司ID查询项目下成员列表
    List<User> selectAllUserByProjectIdAndCompanyId(@Param("projectId") int projectId, @Param("companyId") int companyId, @Param("roleType") String roleType);

    // 查询公司角色为项目经理，新增项目信息时下拉显示项目经理
    List<User> selectUserByRoleIdForProjectUser(@Param("roleId") int roleId, @Param("roleType") String roleType);
}