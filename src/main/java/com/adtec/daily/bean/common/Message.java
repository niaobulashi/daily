package com.adtec.daily.bean.common;

import com.adtec.daily.util.CodeMsg;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Description:
 * @author: HeXin
 * @date: 2018/8/6
 * @Copyright:
 */
public class Message {
    //状态码   100-成功    200-失败    110-数据已存在
    private String code;
    //提示信息
    private String msg;

    private int pages;

    private int total;

    //用户要返回给浏览器的数据
    private List data = new ArrayList<>();

    //用户要返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<>();

    //100-成功
    public static Message success(){
        Message result = new Message();
        result.setCode(CodeMsg.SUCCESS.getValue());
        result.setMsg(CodeMsg.SUCCESS.getLabel());
        return result;
    }

    //200-失败
    public static Message fail(){
        Message result = new Message();
        result.setCode(CodeMsg.FAIL.getValue());
        result.setMsg(CodeMsg.FAIL.getLabel());
        return result;
    }

    //200-失败
    public static Message fail(String msg){
        Message result = new Message();
        result.setCode(CodeMsg.FAIL.getValue());
        result.setMsg(msg);
        return result;
    }

    //110-数据已存在
    public static Message dateExist(){
        Message result = new Message();
        result.setCode(CodeMsg.IS_EXIST.getValue());
        result.setMsg(CodeMsg.IS_EXIST.getLabel());
        return result;
    }

    //100001-间隔小于5分钟，请稍后重新提交
    public static Message intervalLsFive() {
        Message result = new Message();
        result.setCode(CodeMsg.INTERVAL_LT_FIVE.getValue());
        result.setMsg(CodeMsg.INTERVAL_LT_FIVE.getLabel());
        return result;
    }

    public Message add(List result){
        PageInfo pageInfo = new PageInfo(result);
        this.setData(result);
        this.setTotal((int)pageInfo.getTotal());
        this.setPages(Integer.valueOf(pageInfo.getPages()));
        return this;
    }

    public Message addExtend(String key,Object value){
        this.getExtend().put(key, value);
        return this;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
