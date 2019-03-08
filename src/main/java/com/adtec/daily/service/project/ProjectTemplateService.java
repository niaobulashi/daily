package com.adtec.daily.service.project;

import com.adtec.daily.bean.project.ProjectTemplate;
import com.adtec.daily.bean.project.ProjectTemplateExample;

import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
public interface ProjectTemplateService {
    /**
     *  查询项目模板信息
     *
     * @param example
     * @return
     */
    List<ProjectTemplate> selectByExample(ProjectTemplateExample example);

    /**
     * 项目模板保存
     *
     * @param projectTemplate
     */
    void save(ProjectTemplate projectTemplate);
}
