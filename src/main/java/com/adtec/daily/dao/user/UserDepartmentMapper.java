package com.adtec.daily.dao.user;

import com.adtec.daily.bean.user.UserDepartment;
import com.adtec.daily.bean.user.UserDepartmentExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDepartmentMapper {
    long countByExample(UserDepartmentExample example);

    int deleteByExample(UserDepartmentExample example);

    @Delete({
            "delete from t_user_department",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into t_user_department (id, user_id, ",
            "dept_id, user_level, ",
            "create_time, create_user_id, ",
            "update_time, update_user_id, ",
            "remark1, remark2, ",
            "remark3)",
            "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, ",
            "#{deptId,jdbcType=INTEGER}, #{userLevel,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{createUserId,jdbcType=VARCHAR}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{updateUserId,jdbcType=VARCHAR}, ",
            "#{remark1,jdbcType=VARCHAR}, #{remark2,jdbcType=VARCHAR}, ",
            "#{remark3,jdbcType=VARCHAR})"
    })
    int insert(UserDepartment record);

    int insertSelective(UserDepartment record);

    List<UserDepartment> selectByExample(UserDepartmentExample example);

    @Select({
            "select",
            "id, user_id, dept_id, user_level, create_time, create_user_id, update_time, ",
            "update_user_id, remark1, remark2, remark3",
            "from t_user_department",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.adtec.daily.dao.user.UserDepartmentMapper.BaseResultMap")
    UserDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDepartment record, @Param("example") UserDepartmentExample example);

    int updateByExample(@Param("record") UserDepartment record, @Param("example") UserDepartmentExample example);

    int updateByPrimaryKeySelective(UserDepartment record);

    @Update({
            "update t_user_department",
            "set user_id = #{userId,jdbcType=VARCHAR},",
            "dept_id = #{deptId,jdbcType=INTEGER},",
            "user_level = #{userLevel,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_user_id = #{createUserId,jdbcType=VARCHAR},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "remark1 = #{remark1,jdbcType=VARCHAR},",
            "remark2 = #{remark2,jdbcType=VARCHAR},",
            "remark3 = #{remark3,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserDepartment record);
}