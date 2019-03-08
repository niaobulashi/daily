package com.adtec.daily.service.demand;

import com.adtec.daily.bean.demand.DemandDetail;

import java.util.List;

/**
 * @version V1.0
 * @Description: 需求详情信息接口类
 * @author: 胡浪
 * @date: 2018/4/13
 * @Copyright:
 */
public interface DemandDetailService {

    /**
     * 查询所有项目信息
     */
    List<DemandDetail> getDemandDetail(DemandDetail demandDetail);
}
