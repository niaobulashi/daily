package com.adtec.daily.dao.user;

import java.util.List;

import com.adtec.daily.bean.user.UserFeedBack;
import com.adtec.daily.bean.user.UserFeedBackExample;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserFeedBackMapper {
    long countByExample(UserFeedBackExample example);

    int deleteByExample(UserFeedBackExample example);

    @Delete({
            "delete from t_user_feedback",
            "where fd_id = #{fdId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer fdId);

    @Insert({
            "insert into t_user_feedback (fd_id, fb_type, ",
            "fb_info, fb_user, ",
            "fb_email, session_id, ",
            "create_date, result_flag, ",
            "remark1, remark2, ",
            "remark3)",
            "values (#{fdId,jdbcType=INTEGER}, #{fbType,jdbcType=VARCHAR}, ",
            "#{fbInfo,jdbcType=VARCHAR}, #{fbUser,jdbcType=VARCHAR}, ",
            "#{fbEmail,jdbcType=VARCHAR}, #{sessionId,jdbcType=VARCHAR}, ",
            "#{createDate,jdbcType=TIMESTAMP}, #{resultFlag,jdbcType=VARCHAR}, ",
            "#{remark1,jdbcType=VARCHAR}, #{remark2,jdbcType=VARCHAR}, ",
            "#{remark3,jdbcType=VARCHAR})"
    })
    int insert(UserFeedBack record);

    int insertSelective(UserFeedBack record);

    List<UserFeedBack> selectByExample(UserFeedBackExample example);

    @Select({
            "select",
            "fd_id, fb_type, fb_info, fb_user, fb_email, session_id, create_date, result_flag, ",
            "remark1, remark2, remark3",
            "from t_user_feedback",
            "where fd_id = #{fdId,jdbcType=INTEGER}"
    })
    @ResultMap("com.adtec.daily.dao.user.UserFeedBackMapper.BaseResultMap")
    UserFeedBack selectByPrimaryKey(Integer fdId);

    int updateByExampleSelective(@Param("record") UserFeedBack record, @Param("example") UserFeedBackExample example);

    int updateByExample(@Param("record") UserFeedBack record, @Param("example") UserFeedBackExample example);

    int updateByPrimaryKeySelective(UserFeedBack record);

    @Update({
            "update t_user_feedback",
            "set fb_type = #{fbType,jdbcType=VARCHAR},",
            "fb_info = #{fbInfo,jdbcType=VARCHAR},",
            "fb_user = #{fbUser,jdbcType=VARCHAR},",
            "fb_email = #{fbEmail,jdbcType=VARCHAR},",
            "session_id = #{sessionId,jdbcType=VARCHAR},",
            "create_date = #{createDate,jdbcType=TIMESTAMP},",
            "result_flag = #{resultFlag,jdbcType=VARCHAR},",
            "remark1 = #{remark1,jdbcType=VARCHAR},",
            "remark2 = #{remark2,jdbcType=VARCHAR},",
            "remark3 = #{remark3,jdbcType=VARCHAR}",
            "where fd_id = #{fdId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserFeedBack record);

    // 查询意见反馈
    UserFeedBack selectBySessionIdAndfbIdMax(String fbUser);

    //查询反馈列表
    List<UserFeedBack> selectFeedBackList(@Param("fbType")String fbType, @Param("resultFlag")String resultFlag, @Param("feedbackDateStart")String feedbackDateStart, @Param("feedbackDateEnd")String feedbackDateEnd);

    //更新结果状态
    void updateResultFlagById(@Param("fdId")int fdId, @Param("resultFlag")String resultFlag);
}