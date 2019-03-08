package com.adtec.daily.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class HttpClientUtil {
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url 发送请求的URL
     * @param map 发送请求的参数
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url,Map<String,Object> map) {
        StringBuffer buffer = new StringBuffer();
        BufferedReader in = null;
        try {
            String tmpS= "";
            if(url.indexOf("?")>-1){
                tmpS="&";
            }else{
                tmpS="?";
            }
            boolean isFrist=true;
            for(String str:map.keySet()){
                if(isFrist){
                    url+=tmpS+str+"="+map.get(str).toString();
                    isFrist=false;
                }else{
                    url+="&"+str+"="+map.get(str).toString();
                }
            }
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            //URLConnection connection = realUrl.openConnection();
            HttpURLConnection httpUrlConn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            //connection.setRequestProperty("accept", "*/*");
            //connection.setRequestProperty("connection", "Keep-Alive");
            //connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpUrlConn.setRequestMethod("GET");
            // 建立实际的连接
            httpUrlConn.connect();
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return buffer.toString();
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @param map 请求参数
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String,Object> map) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            String param = "";
            boolean isFrist=true;
            for(String str:map.keySet()){
                if(isFrist){
                    param+=str+"="+map.get(str).toString();
                    isFrist=false;
                }else{
                    param+="&"+str+"="+map.get(str).toString();
                }
            }
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
