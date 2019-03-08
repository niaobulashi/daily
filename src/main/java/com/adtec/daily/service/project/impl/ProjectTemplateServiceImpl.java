package com.adtec.daily.service.project.impl;

import com.adtec.daily.bean.project.ProjectTemplate;
import com.adtec.daily.bean.project.ProjectTemplateExample;
import com.adtec.daily.dao.project.ProjectTemplateMapper;
import com.adtec.daily.service.project.ProjectTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTemplateServiceImpl implements ProjectTemplateService {

    @Autowired
    ProjectTemplateMapper projectTemplateMapper;

    /**
     * 查询项目信息
     */
    public List<ProjectTemplate> selectByExample(ProjectTemplateExample example) {
        List<ProjectTemplate> list =  projectTemplateMapper.selectByExample(example);
        return list;
    }

    /**
     * 项目模板保存
     */
    @Override
    public void save(ProjectTemplate projectTemplate) {
        projectTemplateMapper.insertSelective(projectTemplate);
    }
}
