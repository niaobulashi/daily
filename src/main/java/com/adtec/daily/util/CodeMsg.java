package com.adtec.daily.util;

public enum CodeMsg {
	
	SUCCESS("100", "处理成功！"),
    FAIL("200", "处理失败！"),
    IS_EXIST("110", "数据已存在！"),
    INTERVAL_LT_FIVE("100001", "间隔小于5分钟，请稍后重新提交");
	
	private final String value;
	private final String label;
	private CodeMsg(String value, String label){
		this.value = value;
		this.label = label;
	}
	
	/**
	 * 获取键
	 * @return
	 */
	public String getValue(){
		return value;
	}
	
	/**
	 * 获取值
	 * @return
	 */
	public String getLabel(){
		return label;
	}
	
	/**
	 * 根据键取值
	 * @param value
	 * @return
	 */
	public static CodeMsg find(String value){
		if(value == null){
			return null;
		}
		for(CodeMsg s: values()){
			if(s.value.equals(value)){
				return s;
			}
		}
		return null;
	}
}
