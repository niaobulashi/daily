package com.adtec.daily.dao.daily;

import com.adtec.daily.bean.daily.OverWork;
import com.adtec.daily.bean.daily.OverWorkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OverWorkMapper {
    int countByExample(OverWorkExample example);

    int deleteByExample(OverWorkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OverWork record);

    int insertSelective(OverWork record);

    List<OverWork> selectByExample(OverWorkExample example);

    OverWork selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OverWork record, @Param("example") OverWorkExample example);

    int updateByExample(@Param("record") OverWork record, @Param("example") OverWorkExample example);

    int updateByPrimaryKeySelective(OverWork record);

    int updateByPrimaryKey(OverWork record);

    //根据用户id及上班日期查询加班明细列表
    List<OverWork> selectOverWorkDetailListByUserIdAndWorkDate(@Param("id") int id,@Param("userId") String userId, @Param("approvalStatus") String approvalStatus, @Param("startDate") String startDate, @Param("endDate") String endDate);

    //根据用户id及上班日期查询加班总时长
    OverWork selectOverWorkByUserIdAndWorkDate(@Param("userId") String userId, @Param("startDate") String startDate, @Param("endDate") String endDate);

    //根据加班id查询加班信息
    OverWork selectInfoByPrimaryKey(Integer id);
}