package com.adtec.daily.bean.common;

import com.adtec.daily.util.CodeMsg;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回的类
 *
 * 
 */
public class Msg {

	//状态码   100-成功    200-失败    110-数据已存在
	private String code;
	//提示信息
	private String msg;
	
	//用户要返回给浏览器的数据
	private Map<String, Object> extend = new HashMap<>();

	//100-成功
	public static Msg success(){
		Msg result = new Msg();
		result.setCode(CodeMsg.SUCCESS.getValue());
		result.setMsg(CodeMsg.SUCCESS.getLabel());
		return result;
	}

    //200-失败
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(CodeMsg.FAIL.getValue());
		result.setMsg(CodeMsg.FAIL.getLabel());
		return result;
	}

    //110-数据已存在
	public static Msg dateExist(){
        Msg result = new Msg();
        result.setCode(CodeMsg.IS_EXIST.getValue());
        result.setMsg(CodeMsg.IS_EXIST.getLabel());
        return result;
    }

    //100001-间隔小于5分钟，请稍后重新提交
    public static Msg intervalLsFive() {
        Msg result = new Msg();
        result.setCode(CodeMsg.INTERVAL_LT_FIVE.getValue());
        result.setMsg(CodeMsg.INTERVAL_LT_FIVE.getLabel());
        return result;
    }
	
	public Msg add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
