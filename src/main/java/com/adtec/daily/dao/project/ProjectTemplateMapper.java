package com.adtec.daily.dao.project;

import com.adtec.daily.bean.project.ProjectTemplate;
import com.adtec.daily.bean.project.ProjectTemplateExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProjectTemplateMapper {
    long countByExample(ProjectTemplateExample example);

    int deleteByExample(ProjectTemplateExample example);

    @Delete({
        "delete from t_project_template",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_project_template (id, project_id, ",
        "template_file_name, template_type, ",
        "create_time, create_user_id, ",
        "update_time, update_user_id, ",
        "remark1, remark2, ",
        "remark3)",
        "values (#{id,jdbcType=INTEGER}, #{projectId,jdbcType=INTEGER}, ",
        "#{templateFileName,jdbcType=VARCHAR}, #{templateType,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createUserId,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{updateUserId,jdbcType=VARCHAR}, ",
        "#{remark1,jdbcType=VARCHAR}, #{remark2,jdbcType=VARCHAR}, ",
        "#{remark3,jdbcType=VARCHAR})"
    })
    int insert(ProjectTemplate record);

    int insertSelective(ProjectTemplate record);

    List<ProjectTemplate> selectByExample(ProjectTemplateExample example);

    @ResultMap("com.adtec.daily.db.mapper.project.ProjectTemplateMapper.BaseResultMap")
    ProjectTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectTemplate record, @Param("example") ProjectTemplateExample example);

    int updateByExample(@Param("record") ProjectTemplate record, @Param("example") ProjectTemplateExample example);

    int updateByPrimaryKeySelective(ProjectTemplate record);

    @Update({
        "update t_project_template",
        "set project_id = #{projectId,jdbcType=INTEGER},",
          "template_file_name = #{templateFileName,jdbcType=VARCHAR},",
          "template_type = #{templateType,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "remark1 = #{remark1,jdbcType=VARCHAR},",
          "remark2 = #{remark2,jdbcType=VARCHAR},",
          "remark3 = #{remark3,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProjectTemplate record);
}