package com.adtec.daily.dao.project;

import com.adtec.daily.bean.project.Project;
import com.adtec.daily.bean.project.ProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    int countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    List<Project> selectAllProject();

    Project selectInfoByPrimaryKey(Integer id);

    Project selectByUserId(String userId);

    // 根据员工查看项目信息
    List<Project> selectProjectByUser(String userId);

    // 根据添加的日报信息获取项目下班时间
    Project selectProjectByDailyId(String dailyId);

}