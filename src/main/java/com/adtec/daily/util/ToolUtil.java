package com.adtec.daily.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by guofan on 2018/3/6.
 */
public class ToolUtil {
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String PATTERN_HH_MM_SS = "HH:mm:ss";

    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String PATTERN_YYYYMMDD = "yyyyMMdd";

    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 计算两个日期相差几天
     *
     * @return
     */
    public static BigDecimal getDays(Date startDate, Date endDate) {

        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        BigDecimal startTime = BigDecimal.valueOf(fromCalendar.getTime().getTime());
        BigDecimal endTime = BigDecimal.valueOf(toCalendar.getTime().getTime());
        BigDecimal days = (endTime.subtract(startTime)).divide(BigDecimal.valueOf(1000 * 60 * 60 * 24));
        return days;
    }

    /**
     * 计算相差几年
     *
     * @param object
     * @return
     */
    public static Date getYear(Object object) {
        int i = (int) object;
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -i);
        date = calendar.getTime();
        return date;
    }

    /**
     * 日期增加 几天
     *
     * @param d
     * @param day
     * @return
     * @author: pengn 2016-12-16
     */
    public static Date getDateAddDay(Date d, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + day);
        return calendar.getTime();
    }

    /**
     * 日期减少 几天
     *
     * @param d
     * @param day
     * @return
     * @author: pengn 2016-12-16
     */
    public static Date getDateSubtractDay(Date d, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - day);
        return calendar.getTime();
    }

    public static Timestamp getTimestamp() {
        Timestamp tp = new Timestamp(System.currentTimeMillis());
        return tp;
    }

    /**
     * 创建时间格式化 +时分秒
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date formateDate(String date, String pattern) {
        Date fmDate = new Date();
        // 创建时间
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            fmDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fmDate;
    }

    /**
     * 创建时间格式化-不带时分秒
     *
     * @param dateFormat
     * @return
     */
    public static Date formateYYYYMMDD(String dateFormat) {
        Date fmDate = new Date();
        // 创建时间
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYY_MM_DD);
        try {
            fmDate = sdf.parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fmDate;
    }

    /**
     * 时间格式化 - 返回str
     *
     * @param date
     * @return
     */
    public static String formateYYYYMMDD(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYYMMDD);
        String str = sdf.format(date);
        return str;
    }

    public static String doubRecFormateDateString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_YYYY_MM_DD);
        String str = sdf.format(date);
        return str;
    }


    public static String dateFormateString(Date date, String formate) {
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        String str = sdf.format(date);
        return str;
    }
    /**
     * date to string
     *
     * @return String
     */
    public static String dateToString(Date d, String pattern) {
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        if (d == null) {
            String d1 = "";
            return d1;
        }
        String d1 = f.format(d);
        return d1;
    }

    /**
     * date to string
     * format yyyy-MM-dd
     * @return String
     */

    public static String dateToString(Date d) {
        String dString = "";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        if (d != null && StringUtils.isNotEmpty(d.toString())) {
            dString = f.format(d);
        }

        return dString;
    }
    /**
     * string to date
     *
     * @return
     */
    public static Date stringToDate(String str, String pattern) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            SimpleDateFormat f = new SimpleDateFormat(pattern);
            Date d = f.parse(str);
            // System.out.print(d);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getFormatTime(Timestamp timestamp) {
        String outStr = "";
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (timestamp != null) {
                outStr = fmt.format(timestamp);
            } else {
                outStr = fmt.format(getTimestamp());
            }
            return outStr;
        } catch (Exception e) {
            e.printStackTrace();
            return outStr;
        }
    }

    /**
     * 计算加班时间
     *
     * @param bigDecimal 加班实际时间
     * @return
     */
    public static BigDecimal getOverWorkTime(BigDecimal bigDecimal) {
        //0.5为最小单位，不满0.5的不要；不满1的记为0.5。使用ROUND_HALF_DOWN有点问题，这里硬写
        DecimalFormat oneMit = new DecimalFormat("0.0");
        String overWorkTimeOneMitFirst = oneMit.format(bigDecimal).split("\\.")[0];
        String overWorkTimeOneMitSecond = oneMit.format(bigDecimal).split("\\.")[1];
        BigDecimal mixOverWorkTime = new BigDecimal("0.5");
        BigDecimal overWorkTimeOneMitFirstDouble = new BigDecimal(overWorkTimeOneMitFirst);
        if (overWorkTimeOneMitFirst.compareTo("0") == 0) {
            if (overWorkTimeOneMitSecond.compareTo("5") >= 0) {
                return mixOverWorkTime;
            }
        } else if(overWorkTimeOneMitFirst.compareTo("0") > 0) {
            if (overWorkTimeOneMitSecond.compareTo("5") >= 0) {
                return overWorkTimeOneMitFirstDouble.add(mixOverWorkTime);
            } else {
                return overWorkTimeOneMitFirstDouble;
            }
        }
        return new BigDecimal("");
    }

}
