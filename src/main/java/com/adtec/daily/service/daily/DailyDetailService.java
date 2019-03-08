package com.adtec.daily.service.daily;

import com.adtec.daily.bean.daily.DailyDetail;

import java.util.List;

/**
 * @version V1.0
 * @Description: 日报详情内容接口类
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
public interface DailyDetailService {

    /**
     * 查询日报详细列表
     */
    List<DailyDetail> getDailyList(DailyDetail record);

    /**
     * 保存日报详情
     *
     */
    void saveDailyDetail(DailyDetail dailyDetail);

    /**
     * 删除日报详情
     */
    void deleteDailyDetail(String id);

    /**
     * 根据主键查询日报内容
     */
    DailyDetail getDailyDetailInfo(String dailyDetailId);

    /**
     * 根据主键修改日报内容信息
     */
    void updateDailyDetail(DailyDetail dailyDetail);

    /**
     * 查询某用户的未完成日报任务
     */
    List<DailyDetail> getDailyDetailUnDone(String userId);

    /**
     * 日报信息
     */
    List<DailyDetail> getDailyDetailByUserId(String userId, String preFinishDate, String completeProgress);

    /**
     * 点击修改，查询日报具体信息
     */
    DailyDetail getDailyDetailByDailyDetailId(String dailyDetailId);
}
