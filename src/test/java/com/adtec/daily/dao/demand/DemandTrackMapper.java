package com.adtec.daily.dao.demand;

import com.adtec.daily.bean.demand.DemandTrack;
import com.adtec.daily.bean.demand.DemandTrackExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface DemandTrackMapper {
    long countByExample(DemandTrackExample example);

    int deleteByExample(DemandTrackExample example);

    @Delete({
        "delete from t_demand_track",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_demand_track (id, project_id, ",
        "demand_id, demand_departmant, ",
        "demand_maker, demand_date, ",
        "demand_auditor, demand_system, ",
        "demand_module, demand_progress, ",
        "version_num, demand_respo_id, ",
        "demand_name, demand_des, ",
        "demand_stat, lead_date, ",
        "planned_finish_date, actual_finish_date, ",
        "planned_online_date, actual_online_date, ",
        "priority, workload, ",
        "workload_confirm, settlement_situation, ",
        "create_time, create_user_id, ",
        "update_time, update_user_id, ",
        "remark1, remark2, ",
        "remark3)",
        "values (#{id,jdbcType=INTEGER}, #{projectId,jdbcType=VARCHAR}, ",
        "#{demandId,jdbcType=VARCHAR}, #{demandDepartmant,jdbcType=VARCHAR}, ",
        "#{demandMaker,jdbcType=VARCHAR}, #{demandDate,jdbcType=DATE}, ",
        "#{demandAuditor,jdbcType=VARCHAR}, #{demandSystem,jdbcType=VARCHAR}, ",
        "#{demandModule,jdbcType=VARCHAR}, #{demandProgress,jdbcType=VARCHAR}, ",
        "#{versionNum,jdbcType=VARCHAR}, #{demandRespoId,jdbcType=VARCHAR}, ",
        "#{demandName,jdbcType=VARCHAR}, #{demandDes,jdbcType=VARCHAR}, ",
        "#{demandStat,jdbcType=VARCHAR}, #{leadDate,jdbcType=DATE}, ",
        "#{plannedFinishDate,jdbcType=DATE}, #{actualFinishDate,jdbcType=DATE}, ",
        "#{plannedOnlineDate,jdbcType=DATE}, #{actualOnlineDate,jdbcType=DATE}, ",
        "#{priority,jdbcType=VARCHAR}, #{workload,jdbcType=VARCHAR}, ",
        "#{workloadConfirm,jdbcType=VARCHAR}, #{settlementSituation,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{createUserId,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{updateUserId,jdbcType=VARCHAR}, ",
        "#{remark1,jdbcType=VARCHAR}, #{remark2,jdbcType=VARCHAR}, ",
        "#{remark3,jdbcType=VARCHAR})"
    })
    int insert(DemandTrack record);

    int insertSelective(DemandTrack record);

    List<DemandTrack> selectByExample(DemandTrackExample example);

    @Select({
        "select",
        "id, project_id, demand_id, demand_departmant, demand_maker, demand_date, demand_auditor, ",
        "demand_system, demand_module, demand_progress, version_num, demand_respo_id, ",
        "demand_name, demand_des, demand_stat, lead_date, planned_finish_date, actual_finish_date, ",
        "planned_online_date, actual_online_date, priority, workload, workload_confirm, ",
        "settlement_situation, create_time, create_user_id, update_time, update_user_id, ",
        "remark1, remark2, remark3",
        "from t_demand_track",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.adtec.daily.dao.demand.DemandTrackMapper.BaseResultMap")
    DemandTrack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DemandTrack record, @Param("example") DemandTrackExample example);

    int updateByExample(@Param("record") DemandTrack record, @Param("example") DemandTrackExample example);

    int updateByPrimaryKeySelective(DemandTrack record);

    @Update({
        "update t_demand_track",
        "set project_id = #{projectId,jdbcType=VARCHAR},",
          "demand_id = #{demandId,jdbcType=VARCHAR},",
          "demand_departmant = #{demandDepartmant,jdbcType=VARCHAR},",
          "demand_maker = #{demandMaker,jdbcType=VARCHAR},",
          "demand_date = #{demandDate,jdbcType=DATE},",
          "demand_auditor = #{demandAuditor,jdbcType=VARCHAR},",
          "demand_system = #{demandSystem,jdbcType=VARCHAR},",
          "demand_module = #{demandModule,jdbcType=VARCHAR},",
          "demand_progress = #{demandProgress,jdbcType=VARCHAR},",
          "version_num = #{versionNum,jdbcType=VARCHAR},",
          "demand_respo_id = #{demandRespoId,jdbcType=VARCHAR},",
          "demand_name = #{demandName,jdbcType=VARCHAR},",
          "demand_des = #{demandDes,jdbcType=VARCHAR},",
          "demand_stat = #{demandStat,jdbcType=VARCHAR},",
          "lead_date = #{leadDate,jdbcType=DATE},",
          "planned_finish_date = #{plannedFinishDate,jdbcType=DATE},",
          "actual_finish_date = #{actualFinishDate,jdbcType=DATE},",
          "planned_online_date = #{plannedOnlineDate,jdbcType=DATE},",
          "actual_online_date = #{actualOnlineDate,jdbcType=DATE},",
          "priority = #{priority,jdbcType=VARCHAR},",
          "workload = #{workload,jdbcType=VARCHAR},",
          "workload_confirm = #{workloadConfirm,jdbcType=VARCHAR},",
          "settlement_situation = #{settlementSituation,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "remark1 = #{remark1,jdbcType=VARCHAR},",
          "remark2 = #{remark2,jdbcType=VARCHAR},",
          "remark3 = #{remark3,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(DemandTrack record);
}