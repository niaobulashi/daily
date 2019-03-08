package com.adtec.daily.service.system.impl;

import com.adtec.daily.bean.system.TCalendar;
import com.adtec.daily.dao.system.TCalendarMapper;
import com.adtec.daily.service.system.CalendarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import net.sf.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version V1.0
 * @Description: 类名
 * @author: 胡浪
 * @date: 2018/9/28
 * @Copyright:
 */
@Service
public class CalendarServiceImpl implements CalendarService {

    private Logger logger = LoggerFactory.getLogger(CalendarServiceImpl.class);

    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    //配置您申请的KEY
    public static final String APPKEY ="37057";
    //密钥
    public static final String SIGN = "ca019eba94260a1098520e138a914e62";
    //报文格式
    public static final String FORMAT = "json";
    //
    public static final String APP = "life.workday";
    //
    public static final String INFO = "1";

    @Autowired
    private TCalendarMapper calendarMapper;

    @Override
    public void saveCalendar(TCalendar calendar) throws Exception {
        logger.error("saveCalendar-start");
        try {
            //循环获取未来的日期便利
            Date date = new Date();
            java.util.Calendar cal = java.util.Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            //默认从20170101开始，获取2017至2018两年间的数据
            cal.set(2019, 00, 00);
            for (int i = 1; i < 366; i++) {
                cal.add(java.util.Calendar.DATE, 1);
                String day = sdf.format(cal.getTime());
                //
                logger.info("日期：" + day);
                //获取日期详情

                getRequest2("day");
                //根据日期和日期类型查询数据库中是否存在
                /*TCalendar calendar2 = calendarMapper.selectByPrimaryKey(day);
                if (calendar2 == null) {
                    System.out.println("终于找到你了！，出来吧：" + day);
                }*/
            }

            logger.error("saveCalendar-end");
        } catch (Exception e) {
            logger.error("saveCalendar-error");
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    //1.获取当天的详细信息
    public static void getRequest1(String dateStr){
        TCalendar cal = new TCalendar();
        String result =null;
        String url ="http://api.k780.com/";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("app", APP);//您申请的appKey
        params.put("appkey", APPKEY);//您申请的appKey
        params.put("sign", SIGN);//您申请的appKey
        params.put("format", FORMAT);//您申请的appKey
        params.put("date", dateStr);//指定日期,格式为YYYYMMDD,如月份和日期小于10,则取个位,如:20120101
        try {
            result = net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getString("success").equals("1")){
                System.out.println(object.get("result"));

                if (object.get("result") != null) {
                    JSONObject resultDate = (JSONObject)object.get("result");
                    System.out.println(resultDate.getString("date").replace("-",""));
                    System.out.println(resultDate.getString("workmk"));
                    System.out.println(resultDate.getString("worknm"));
                    System.out.println(resultDate.getString("week_1"));
                    System.out.println(resultDate.getString("week_2"));
                    System.out.println(resultDate.getString("week_3"));
                    System.out.println(resultDate.getString("week_4"));
                    System.out.println(resultDate.getString("remark"));

                    //先查询是否存在
                    /*TCalendarExample example = new TCalendarExample();
                    TCalendarExample.Criteria cri = example.createCriteria();
                    cri.andDDateEqualTo(resultDate.getString("date").replace("-",""));
                    List<TCalendar> calendarList = calendarMapper.selectByExample(example);
                    if (calendarList.size() == 0 || calendarList == null) {
                        //存入数据库
                        *//*cal.setdDate(resultDate.getString("date").replace("-",""));
                        cal.setcWorkmk(resultDate.getString("workmk"));
                        cal.setcWorknm(resultDate.getString("worknm"));
                        cal.setcWeekNum(resultDate.getString("week_1"));
                        cal.setcWeekName(resultDate.getString("week_2"));
                        cal.setcWeekWeek(resultDate.getString("week_3"));
                        cal.setcWeekEnglish(resultDate.getString("week_4"));
                        cal.setcDesc(resultDate.getString("remark"));

                        //保存日期信息
                        calendarMapper.insertSelective(cal);*//*
                    }*/
                }

            } else {
                System.out.println(object.get("success") + ":" + object.get("msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //1.获取当天的详细信息
    public void getRequest2(String dateStr){
        TCalendar cal = new TCalendar();
        String result =null;
        String url ="http://tool.bitefu.net/jiari/";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("info", INFO);//您申请的appKey
        params.put("d", dateStr);//指定日期,格式为YYYYMMDD,如月份和日期小于10,则取个位,如:20120101
        try {
            result = net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getString("status").equals("1")){

                //根据日期和日期类型查询数据库中是否存在
                TCalendar calendar = calendarMapper.selectByPrimaryKey(dateStr);
                //若存在
                if (calendar != null) {
                    //判断接口返回的日期类型和数据中保存的是否一致，若不一致，则更新
                    if (calendar.getcType().equals(object.get("type"))) {
                        //说明国家法定节假日有变化，之前存入的数据，需要变更
                        cal.setdDate(dateStr);
                        cal.setcType(object.getString("type"));
                        cal.setcTypename(object.getString("typename"));
                        cal.setcYearname(object.getString("yearname"));
                        cal.setcNonglicn(object.getString("nonglicn"));
                        cal.setcNongli(object.getString("nongli"));
                        cal.setcAnimalsYear(object.getString("shengxiao"));
                        cal.setcThrottle(object.getString("jieqi"));
                        cal.setcWeekcn(object.getString("weekcn"));
                        cal.setcWeek1(object.getString("week1"));
                        cal.setcWeek2(object.getString("week2"));
                        cal.setcWeek3(object.getString("week3"));
                        cal.setcDaynum(object.getString("daynum"));
                        cal.setcWeeknum(object.getString("weeknum"));
                        if (object.has("avoid")) {
                            cal.setcAvoid(object.getString("avoid"));
                        }
                        if (object.has("suit")) {
                            cal.setcSuit(object.getString("suit"));
                        }

                        calendarMapper.updateByPrimaryKeySelective(cal);
                    }

                    //若为空，则直接新增日期
                } else {

                    cal.setdDate(dateStr);
                    cal.setcType(object.getString("type"));
                    cal.setcTypename(object.getString("typename"));
                    cal.setcYearname(object.getString("yearname"));
                    cal.setcNonglicn(object.getString("nonglicn"));
                    cal.setcNongli(object.getString("nongli"));
                    cal.setcAnimalsYear(object.getString("shengxiao"));
                    cal.setcThrottle(object.getString("jieqi"));
                    cal.setcWeekcn(object.getString("weekcn"));
                    cal.setcWeek1(object.getString("week1"));
                    cal.setcWeek2(object.getString("week2"));
                    cal.setcWeek3(object.getString("week3"));
                    cal.setcDaynum(object.getString("daynum"));
                    cal.setcWeeknum(object.getString("weeknum"));
                    if (object.has("avoid")) {
                        cal.setcAvoid(object.getString("avoid"));
                    }
                    if (object.has("suit")) {
                        cal.setcSuit(object.getString("suit"));
                    }

                    calendarMapper.insertSelective(cal);
                }

            } else {
                System.out.println(object.get("success") + ":" + object.get("msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void getDay(String dateStr, String numStr) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(Integer.parseInt(dateStr.substring(0,4)), Integer.parseInt(dateStr.substring(4,6))-1, Integer.parseInt(dateStr.substring(6,8)));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (int i = 1; i < Integer.parseInt(numStr) +1; i++) {
            cal.add(java.util.Calendar.DATE, -1);
            String day = sdf.format(cal.getTime());
            System.out.println("日期：" + day);
        }
    }


    public static void main(String[] args) {
        //循环获取未来的日期便利
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(2019, 00, 00);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        for (int i = 1; i < 366; i++) {
            cal.add(java.util.Calendar.DATE, 1);
            String day = sdf.format(cal.getTime());
            System.out.println("日期：" + day);
            System.out.println("数量：" + i);
        }
    }

}
