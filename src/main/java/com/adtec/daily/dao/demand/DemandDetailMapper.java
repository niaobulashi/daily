package com.adtec.daily.dao.demand;

import com.adtec.daily.bean.demand.DemandDetail;
import com.adtec.daily.bean.demand.DemandDetailExample;
import com.adtec.daily.bean.demand.DemandDetailKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemandDetailMapper {
    int countByExample(DemandDetailExample example);

    int deleteByExample(DemandDetailExample example);

    int deleteByPrimaryKey(DemandDetailKey key);

    int insert(DemandDetail record);

    int insertSelective(DemandDetail record);

    List<DemandDetail> selectByExample(DemandDetailExample example);

    DemandDetail selectByPrimaryKey(DemandDetailKey key);

    int updateByExampleSelective(@Param("record") DemandDetail record, @Param("example") DemandDetailExample example);

    int updateByExample(@Param("record") DemandDetail record, @Param("example") DemandDetailExample example);

    int updateByPrimaryKeySelective(DemandDetail record);

    int updateByPrimaryKey(DemandDetail record);

    //联合表t_demand_track查询具体需求信息
    List<DemandDetail> selectByDemandId(DemandDetail record);
}