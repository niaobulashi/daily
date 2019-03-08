package com.adtec.daily.service.daily;

import com.adtec.daily.bean.daily.OverWork;
import com.adtec.daily.bean.daily.OverWorkExample;

import java.util.List;

/**
 * @version V1.0
 * @Description: 加班时间处理接口
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
public interface OverWorkService {

    /**
     * 查询所有加班数据
     *
     * @param example
     * @return
     */
    List<OverWork> getAll(OverWorkExample example);

    /**
     * 加班数据保存
     *
     * @param overWork
     */
    void saveOverWork(OverWork overWork);

    /**
     * 更新加班数据
     *
     * @param overWork
     */
    void updateByDailyId(OverWork overWork);

    /**
     * 根据用户id及上班日期查询加班明细列表
     *
     * @param id
     * @param userId
     * @param approvalStatus
     * @param startDate
     * @param endDate
     * @return
     */
    List<OverWork> selectOverWorkDetailListByUserIdAndWorkDate(int id,String userId, String approvalStatus,String startDate, String endDate);

    /**
     * 根据用户id及上班日期查询加班总时长
     *
     * @param userId
     * @param startDate
     * @param endDate
     * @return
     */
    OverWork selectOverWorkByUserIdAndWorkDate(String userId, String startDate, String endDate);

    /**
     * 按照主键id查询加班信息
     *
     * @param id
     * @return
     */
    OverWork getOverWork(int id);

    /**
     * 更新加班信息
     *
     * @param overWork
     */
    void updateOverWork(OverWork overWork);

    /**
     * 更新加班信息
     *
     * @param overWork
     */
    void updateOverWorkByDailyId(OverWork overWork, OverWorkExample example);
}
