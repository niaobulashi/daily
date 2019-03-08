package com.adtec.daily.service.daily;

import com.adtec.daily.bean.daily.Daily;
import com.adtec.daily.bean.daily.DailyExample;
import com.adtec.daily.bean.user.User;

import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Description: 日报接口类
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
public interface DailyService {

    /**
     * 日报列表查询
     *
     * @param record
     * @return
     * @throws Exception
     */
    List<Daily> getDailyList(Daily record);

    /**
     * 日报保存
     *
     * @param daily
     * @throws Exception
     */
    void saveDaily(Daily daily);

    /**
     * 条件查询日报信息
     *
     * @param example
     * @return
     * @throws Exception
     */
    List<Daily> getDailyAllList(DailyExample example);

    /**
     * 导出个人日报
     *
     * @param users 用户信息
     * @param startDate 日报开始日期
     * @param endDate   日报结束日期
     * @return reportList
     * @throws Exception
     */
    List<Map<String, Object>> dailyExport(List<User> users, String startDate, String endDate);

    /**
     * 导出个人周报
     *
     * @param users 用户信息
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return sheetMap
     * @throws Exception
     */
    List<Map<String, Object>> caitcWeeklyExport(List<User> users, String startDate, String endDate);

    /**
     * 导出项目周报
     *
     * @param users 用户信息
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return thisWeekList
     * @throws Exception
     */
    Map<String, Object> caitcProjectWeeklyExport(List<User> users, String startDate, String endDate);

    /**
     * 根据日报数据生成周报数据
     *
     * @param key 日报数据key
     * @param weeklyData 日报数据Map
     * @param weekly 日报数据
     * @param lineNumberArray 行数数组（日报内容，问题及计划所占行数）
     * @throws Exception
     */
    void dailyToWeekly(String key, Map<String,Daily> weeklyData, Daily weekly, int[] lineNumberArray);

    /**
     * 根据日报数据生成项目周报数据
     *
     * @param weekly 日报数据
     * @param lineNumberArray 行数数组（日报内容，问题及计划所占行数）
     * @throws Exception
     */
    void dailyToProjectWeekly(Daily weekly, int[] lineNumberArray);

    /**
     * 首页：按天统计用户的上班时长、加班时长
     * @param userId
     * @return
     */
    List<Daily> getWorkTimeAtYear(String userId);

    /**
     * 首页：按天统计用户的上班时长、加班时长
     * @param userId
     * @return
     */
    List<Daily> getWorkTimeAtMonth(String userId, String yearMonth);

    /**
     * 导出个人周报
     *
     * @param users 用户信息
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return sheetMap
     * @throws Exception
     */
    List<Map<String, Object>> adtecWeeklyExport(List<User> users, String startDate, String endDate);
}
