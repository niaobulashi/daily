package com.adtec.daily.dao.progress;

import com.adtec.daily.bean.progress.ProgressTrack;
import com.adtec.daily.bean.progress.ProgressTrackExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProgressTrackMapper {
    long countByExample(ProgressTrackExample example);

    int deleteByExample(ProgressTrackExample example);

    @Delete({
            "delete from t_progress_track",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into t_progress_track (id, demand_id, ",
            "work_type, demand_percent, ",
            "create_time, create_user_id, ",
            "update_time, update_user_id, ",
            "remark1, remark2, ",
            "remark3)",
            "values (#{id,jdbcType=INTEGER}, #{demandId,jdbcType=VARCHAR}, ",
            "#{workType,jdbcType=VARCHAR}, #{demandPercent,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{createUserId,jdbcType=VARCHAR}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{updateUserId,jdbcType=VARCHAR}, ",
            "#{remark1,jdbcType=VARCHAR}, #{remark2,jdbcType=VARCHAR}, ",
            "#{remark3,jdbcType=VARCHAR})"
    })
    int insert(ProgressTrack record);

    int insertSelective(ProgressTrack record);

    List<ProgressTrack> selectByExample(ProgressTrackExample example);

    @Select({
            "select",
            "id, demand_id, work_type, demand_percent, create_time, create_user_id, update_time, ",
            "update_user_id, remark1, remark2, remark3",
            "from t_progress_track",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.adtec.daily.dao.progress.ProgressTrackMapper.BaseResultMap")
    ProgressTrack selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProgressTrack record, @Param("example") ProgressTrackExample example);

    int updateByExample(@Param("record") ProgressTrack record, @Param("example") ProgressTrackExample example);

    int updateByPrimaryKeySelective(ProgressTrack record);

    @Update({
            "update t_progress_track",
            "set demand_id = #{demandId,jdbcType=VARCHAR},",
            "work_type = #{workType,jdbcType=VARCHAR},",
            "demand_percent = #{demandPercent,jdbcType=VARCHAR},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "create_user_id = #{createUserId,jdbcType=VARCHAR},",
            "update_time = #{updateTime,jdbcType=TIMESTAMP},",
            "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
            "remark1 = #{remark1,jdbcType=VARCHAR},",
            "remark2 = #{remark2,jdbcType=VARCHAR},",
            "remark3 = #{remark3,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProgressTrack record);
}