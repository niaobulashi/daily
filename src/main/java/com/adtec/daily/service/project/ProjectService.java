package com.adtec.daily.service.project;

import com.adtec.daily.bean.project.Project;
import com.adtec.daily.bean.project.ProjectExample;

import java.util.List;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
public interface ProjectService {

    /**
     * 管理员查询所有项目信息
     *
     * @return
     */
    List<Project> getAll();

    /**
     * 根据员工查询所属项目信息
     *
     * @param userId
     * @return
     */
    List<Project> getProjectByUser(String userId);

    /**
     * 项目保存
     *
     * @param project
     */
    void saveProject(Project project);

    /**
     * 检验项目编号是否可用
     * @param projectCode
     * @return true：代表当前姓名可用   fasle：不可用
     */
    boolean checkProject(String projectCode);

    /**
     * 按照主键id查询项目信息
     *
     * @param id
     * @return
     */
    Project getProject(int id);

    /**
     * 项目更新
     *
     * @param project
     */
    void updateProject(Project project);

    /**
     * 项目删除
     *
     * @param id
     */
    void deleteProject(Integer id);

    /**
     * 登陆带出项目信息
     *
     * @param userId
     * @return
     */
    Project selectByUserId(String userId);

    /**
     * 根据添加的日报信息获取项目下班时间
     *
     * @param dailyId
     * @return
     */
    Project getProjectByDailyId(String dailyId);

    /**
     *  查询项目信息
     *
     * @param example
     * @return
     */
    List<Project> selectByExample(ProjectExample example);
}
