package com.adtec.daily.service.demand;

import com.adtec.daily.vo.DemandTrackVo;

import java.util.List;

/**
 * @version V1.0
 * @Description: 需求信息接口类
 * @author: 王林柱
 * @date: 2018-8-9 14:10:58
 * @Copyright:
 */
public interface DemandTrackService {

    /**
     * 查询所有需求信息
     */
    List<DemandTrackVo> getDemandTrackList(DemandTrackVo demandTrack);

    /**
     * 自定义语句查询需求
     */
    List<DemandTrackVo> getDemandTrackListBySql(DemandTrackVo demandTrack);

    /**
     * 新增需求
     */
    int addDemandTrack(DemandTrackVo demandTrack);

    /**
     * 删除需求
     */
    int delDemandTrack(DemandTrackVo demandTrack);

    /**
     * 修改需求
     */
    int updateDemandTrack(DemandTrackVo demandTrack);

    /**
     * 查询需求详情
     */
    DemandTrackVo queryDemandTrack(DemandTrackVo demandTrack);
}
