package com.adtec.daily.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    /**
     * excel导出时计算字符串占用几行
     * @param str 内容
     * @param num 每行的字数
     * @return
     */
    public static int stringRowNum(String str,int num){
        double a = Math.ceil((double)str.length()/(double)num);
        return (int)a;
    }

    /**
     * excel导出时计算字符串转换为字节占用几行
     * @param str 内容
     * @param num 每行的字数
     * @return
     */
    public static int stringByteRowNum(String str,int num) {
        double a = 0;
        try {
             a = Math.ceil((double)str.getBytes("GBK").length/(double)num);

        }catch (Exception e){
            e.getStackTrace();
        }
        return (int)a;
    }

    /**
     * excel导出时计算日报内容占用几行
     * @param str 内容
     * @param num 每行的字数
     * @return
     */
    public static int dailyRowNum(String str,int num){
        if(StringUtils.isNotEmpty(str)){
            String[] strs = str.split("&#10;");
            int sum = 0;
            for(int i=0;i<strs.length;i++){
                sum = sum + StringUtil.stringByteRowNum(strs[i],num);
            }
            return sum;
        }else{
            return 0;
        }

    }

    /**
     * excel导出时计算日报内容的序号
     * @param str 内容
     * @return
     */
    public static int dailyNo(String str){
        if(StringUtils.isNotEmpty(str)){
            return Integer.valueOf(str.substring(str.lastIndexOf("&#10;")+5,str.lastIndexOf("&#10;")+6));
        }else{
            return 0;
        }

    }
}
