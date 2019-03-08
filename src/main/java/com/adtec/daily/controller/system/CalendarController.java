package com.adtec.daily.controller.system;

import com.adtec.daily.bean.common.Message;
import com.adtec.daily.bean.system.TCalendar;
import com.adtec.daily.service.system.CalendarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @version V1.0
 * @Description: 万年历接口
 * @author: 胡浪
 * @date: 2018/9/28
 * @Copyright:
 */
@Controller
public class CalendarController {

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Resource
    private CalendarService calendarService;

    /**
     * 新增日历
     */
    @ResponseBody
    @RequestMapping(value = "/system/addCalendar", method = RequestMethod.POST)
    public Message addCalendar() throws Exception {
        try {
            TCalendar calendar = new TCalendar();

            calendarService.saveCalendar(calendar);

            return null;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Message.fail();
        }
    }

    public static void main(String[] args) {
        //循环获取未来的日期便利
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        for (int i = 1; i < 100; i++) {
            cal.add(Calendar.DATE, 1);
            System.out.println(i);
            System.out.println("日期：" + sdf.format(cal.getTime()));
        }

//        System.out.println(isValidDate("201800023"));\

    }


    //校验日期是否有效
    private static boolean isValidDate(String strValue ) {
        int d = Integer.parseInt(strValue.substring(6, 8));
        int m = Integer.parseInt(strValue.substring(4, 6));
        int y = Integer.parseInt(strValue.substring(0, 4));
        if (d < 1 || m < 1 || m > 12) return false;
        if (m == 2) {
            if (isLeapYear(y)) return d <= 29;
            else return d <= 28;
        } else if (m == 4 || m == 6 || m == 9 || m == 11)
            return d <= 30;
        else
            return d <= 31;

    }
    private static boolean isLeapYear(int y) {//判断是否为闰年
        return y % 4 == 0 && (y % 400 == 0 || y % 100 != 0);
    }

    //判断是否是整形，可以有负号，不能有小数点，且不能已零开头
    public static boolean isNumber1(String str) {
        boolean flag = false;
        String s = str.replaceAll("-","");
        if (s.matches("^\\d+$$")) {
            if (s.matches("^0\\d*$")) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return flag;
    }

}
