package com.adtec.daily.dao.daily;

import com.adtec.daily.bean.daily.Daily;
import com.adtec.daily.bean.daily.DailyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DailyMapper {
    int countByExample(DailyExample example);

    int deleteByExample(DailyExample example);

    int deleteByPrimaryKey(String dailyId);

    int insert(Daily record);

    int insertSelective(Daily record);

    List<Daily> selectByExample(DailyExample example);

    Daily selectByPrimaryKey(String dailyId);

    int updateByExampleSelective(@Param("record") Daily record, @Param("example") DailyExample example);

    int updateByExample(@Param("record") Daily record, @Param("example") DailyExample example);

    int updateByPrimaryKeySelective(Daily record);

    int updateByPrimaryKey(Daily record);

    // 日报列表查询
    List<Daily> selectDailyListByUserId(Daily record);

    // 根据用户id及日报日期查询日报明细列表
    List<Daily> selectDailyListByUserIdAndDailyDate(@Param("userId") String userId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    // 首页：按天统计用户的上班时长、加班时长。userId用户编号，
    List<Daily> selectWorkTimeAtYear(@Param("userId") String userId);

    // 首页：按天统计用户的上班时长、加班时长。userId用户编号，
    List<Daily> selectWorkTimeAtMonth(@Param("userId") String userId, @Param("yearMonth") String yearMonth);


}