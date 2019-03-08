package com.adtec.daily.dao.system;

import com.adtec.daily.bean.system.TCalendar;
import com.adtec.daily.bean.system.TCalendarExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TCalendarMapper {
    long countByExample(TCalendarExample example);

    int deleteByExample(TCalendarExample example);

    @Delete({
            "delete from t_calendar",
            "where d_date = #{dDate,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String dDate);

    @Insert({
            "insert into t_calendar (d_date, c_type, ",
            "c_typename, c_yearname, ",
            "c_nonglicn, c_nongli, ",
            "c_animals_year, c_throttle, ",
            "c_weekcn, c_week1, ",
            "c_week2, c_week3, ",
            "c_daynum, c_weeknum, ",
            "c_suit, c_avoid, c_desc)",
            "values (#{dDate,jdbcType=VARCHAR}, #{cType,jdbcType=VARCHAR}, ",
            "#{cTypename,jdbcType=VARCHAR}, #{cYearname,jdbcType=VARCHAR}, ",
            "#{cNonglicn,jdbcType=VARCHAR}, #{cNongli,jdbcType=VARCHAR}, ",
            "#{cAnimalsYear,jdbcType=VARCHAR}, #{cThrottle,jdbcType=VARCHAR}, ",
            "#{cWeekcn,jdbcType=VARCHAR}, #{cWeek1,jdbcType=VARCHAR}, ",
            "#{cWeek2,jdbcType=VARCHAR}, #{cWeek3,jdbcType=VARCHAR}, ",
            "#{cDaynum,jdbcType=VARCHAR}, #{cWeeknum,jdbcType=VARCHAR}, ",
            "#{cSuit,jdbcType=VARCHAR}, #{cAvoid,jdbcType=VARCHAR}, #{cDesc,jdbcType=VARCHAR})"
    })
    int insert(TCalendar record);

    int insertSelective(TCalendar record);

    List<TCalendar> selectByExample(TCalendarExample example);

    @Select({
            "select",
            "d_date, c_type, c_typename, c_yearname, c_nonglicn, c_nongli, c_animals_year, ",
            "c_throttle, c_weekcn, c_week1, c_week2, c_week3, c_daynum, c_weeknum, c_suit, ",
            "c_avoid, c_desc",
            "from t_calendar",
            "where d_date = #{dDate,jdbcType=VARCHAR}"
    })
    @ResultMap("com.adtec.daily.dao.system.TCalendarMapper.BaseResultMap")
    TCalendar selectByPrimaryKey(String dDate);

    int updateByExampleSelective(@Param("record") TCalendar record, @Param("example") TCalendarExample example);

    int updateByExample(@Param("record") TCalendar record, @Param("example") TCalendarExample example);

    int updateByPrimaryKeySelective(TCalendar record);

    @Update({
            "update t_calendar",
            "set c_type = #{cType,jdbcType=VARCHAR},",
            "c_typename = #{cTypename,jdbcType=VARCHAR},",
            "c_yearname = #{cYearname,jdbcType=VARCHAR},",
            "c_nonglicn = #{cNonglicn,jdbcType=VARCHAR},",
            "c_nongli = #{cNongli,jdbcType=VARCHAR},",
            "c_animals_year = #{cAnimalsYear,jdbcType=VARCHAR},",
            "c_throttle = #{cThrottle,jdbcType=VARCHAR},",
            "c_weekcn = #{cWeekcn,jdbcType=VARCHAR},",
            "c_week1 = #{cWeek1,jdbcType=VARCHAR},",
            "c_week2 = #{cWeek2,jdbcType=VARCHAR},",
            "c_week3 = #{cWeek3,jdbcType=VARCHAR},",
            "c_daynum = #{cDaynum,jdbcType=VARCHAR},",
            "c_weeknum = #{cWeeknum,jdbcType=VARCHAR},",
            "c_suit = #{cSuit,jdbcType=VARCHAR},",
            "c_avoid = #{cAvoid,jdbcType=VARCHAR},",
            "c_desc = #{cDesc,jdbcType=VARCHAR}",
            "where d_date = #{dDate,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TCalendar record);
}