package com.adtec.daily.service.project.impl;

import com.adtec.daily.bean.project.Project;
import com.adtec.daily.bean.project.ProjectExample;
import com.adtec.daily.bean.project.ProjectExample.Criteria;
import com.adtec.daily.dao.project.ProjectMapper;
import com.adtec.daily.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    /**
     * 管理员查询所有项目信息
     *
     * @return
     */
    @Override
    public List<Project> getAll() {
        return projectMapper.selectAllProject();
    }

    /**
     * 根据员工查询所属项目信息
     */
    @Override
    public List<Project> getProjectByUser(String userId) {
        return projectMapper.selectProjectByUser(userId);
    }

    /**
     * 项目保存
     */
    @Override
    public void saveProject(Project project) {
        projectMapper.insertSelective(project);
    }

    /**
     * 检验项目编号是否可用
     */
    @Override
    public boolean checkProject(String projectCode) {
        ProjectExample example = new ProjectExample();
        Criteria criteria = example.createCriteria();
        criteria.andProjectCodeEqualTo(projectCode);
        long count = projectMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 按照主键id查询项目信息
     */
    @Override
    public Project getProject(int id) {
        Project project = projectMapper.selectInfoByPrimaryKey(id);
        return project;
    }

    /**
     * 项目更新
     */
    @Override
    public void updateProject(Project project) {
        projectMapper.updateByPrimaryKeySelective(project);
    }

    /**
     * 项目删除
     */
    @Override
    public void deleteProject(Integer id) {
        projectMapper.deleteByPrimaryKey(id);
    }

    /**
     * 登陆带出项目信息
     */
    @Override
    public Project selectByUserId(String userId) {
        Project project = projectMapper.selectByUserId(userId);
        return  project;
    }

    /**
     * 根据添加的日报信息获取项目下班时间
     */
    @Override
    public Project getProjectByDailyId(String dailyId) {
        Project project = projectMapper.selectProjectByDailyId(dailyId);
        return  project;
    }

    /**
     * 查询项目信息
     */
    public List<Project> selectByExample(ProjectExample example) {
        List<Project> list =  projectMapper.selectByExample(example);
        return list;
    }
}
