package com.adtec.daily.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version V1.0
 * @Description: 日期公共类
 * @author: 胡浪
 * @date: 2018/3/12
 * @Copyright:
 */
public class DateUtil {

    /**
     * 日期转为星期
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE",Locale.CHINESE);
        String week = sdf.format(date);
        return week;
    }

    /**
     * String转Date型 yyyy-MM-dd
     *
     * @param Str
     * @return
     */
    public static Date StrToDate(String Str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        Date ddate = null;
        try {
            ddate = sdf.parse(Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ddate;
    }

    /**
     * String转Date型 HH:mm:ss
     *
     * @param Str
     * @return
     */
    public static Date StrToTime(String Str) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setLenient(false);
        Date ddate = null;
        try {
            ddate = sdf.parse(Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ddate;
    }

    public static String getHourTime() {
        Date today=new Date();
        SimpleDateFormat f=new SimpleDateFormat("HH:mm:ss");
        String time = f.format(today);
        return time;
    }

    /**
     * 获取某个日期所在月份每天的日期
     * @param date
     * @return
     */
    public static List getDayListOfMonth(Date date) {
        List<String> list = new ArrayList();
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(date);
        int year = aCalendar.get(Calendar.YEAR);//年份
        int month = aCalendar.get(Calendar.MONTH) + 1;//月份
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String monthStr = "";
            String dayStr = "";
            if(month<10){
                monthStr = "0" + month;
            }else{
                monthStr = String.valueOf(month);
            }
            if(i<10){
                dayStr = "0" + i;
            }else{
                dayStr = String.valueOf(i);
            }

            String aDate = String.valueOf(year)+"-"+monthStr+"-"+dayStr;
            list.add(aDate);
        }
        return list;
    }

    /**
     * 获取日期段中每天的日期
     * @param startDate
     * @param endDate
     * @return
     */
    public static List getDayListOfDateSegment(String startDate,String endDate) {
        List<String> list = new ArrayList();
        list.add(startDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calBegin  = Calendar.getInstance();
            calBegin .setTime(sdf.parse(startDate));
            Calendar calEnd  = Calendar.getInstance();
            calEnd .setTime(sdf.parse(endDate));
            while (calEnd.after(calBegin))  {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                calBegin.add(Calendar.DAY_OF_MONTH, 1);
                System.out.println("日期:"+sdf.format(calBegin.getTime()));
                list.add(sdf.format(calBegin.getTime()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 校验工作日，周末，节假日
     * @param date 需要校验的日期
     * @return String 0-工作日，1-周末，2-节假日
     */
    public static String checkHoliday(Date date){
        SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd");
        String dateStr = f.format(date);
        Map<String,Object> m = new HashMap<>();
        m.put("date",dateStr);
        String str = HttpClientUtil.sendPost("http://api.goseek.cn/Tools/holiday", m);
        JsonMapper json = new JsonMapper();
        Map<String,Object> map = json.fromJson(str, Map.class);
        return map.get("data").toString();
    }

    public static void main(String[] args) {
        getDayListOfDateSegment("2018-07-20","2018-08-20");
    }
}
