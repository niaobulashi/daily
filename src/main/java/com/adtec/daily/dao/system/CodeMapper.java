package com.adtec.daily.dao.system;

import com.adtec.daily.bean.system.Code;
import com.adtec.daily.bean.system.CodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CodeMapper {
    long countByExample(CodeExample example);

    int deleteByExample(CodeExample example);

    @Delete({
            "delete from t_code",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into t_code (id, kind_code, ",
            "kind_name, code, ",
            "name, parent_code, ",
            "delete_flag, display_sort, ",
            "create_time, create_user_id, ",
            "update_time, update_user_id, ",
            "remark1, remark2, ",
            "remark3)",
            "values (#{id,jdbcType=INTEGER}, #{kindCode,jdbcType=VARCHAR}, ",
            "#{kindName,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, ",
            "#{name,jdbcType=VARCHAR}, #{parentCode,jdbcType=VARCHAR}, ",
            "#{deleteFlag,jdbcType=VARCHAR}, #{displaySort,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{createUserId,jdbcType=VARCHAR}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{updateUserId,jdbcType=VARCHAR}, ",
            "#{remark1,jdbcType=VARCHAR}, #{remark2,jdbcType=VARCHAR}, ",
            "#{remark3,jdbcType=VARCHAR})"
    })
    int insert(Code record);

    int insertSelective(Code record);

    List<Code> selectByExample(CodeExample example);

    @Select({
            "select",
            "id, kind_code, kind_name, code, name, parent_code, delete_flag, display_sort, ",
            "create_time, create_user_id, update_time, update_user_id, remark1, remark2, ",
            "remark3",
            "from t_code",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.adtec.daily.dao.system.CodeMapper.BaseResultMap")
    Code selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Code record, @Param("example") CodeExample example);

    int updateByExample(@Param("record") Code record, @Param("example") CodeExample example);

    int updateByPrimaryKeySelective(Code record);

    @Update({
            "update t_code",
            "set kind_code = #{kindCode,jdbcType=VARCHAR},",
            "kind_name = #{kindName,jdbcType=VARCHAR},",
            "code = #{code,jdbcType=VARCHAR},",
            "name = #{name,jdbcType=VARCHAR},",
            "parent_code = #{parentCode,jdbcType=VARCHAR},",
            "delete_flag = #{deleteFlag,jdbcType=VARCHAR},",
            "display_sort = #{displaySort,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_user_id = #{createUserId,jdbcType=VARCHAR},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "remark1 = #{remark1,jdbcType=VARCHAR},",
            "remark2 = #{remark2,jdbcType=VARCHAR},",
            "remark3 = #{remark3,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Code record);
}