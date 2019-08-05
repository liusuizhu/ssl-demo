package com.liusuizhu.page.common;

/**
 * 响应返回的json体中的状态码和消息内容
 * @author John Liu
 */
public enum ResponseCode {

    SUCCESS(200,"成功"),
    
    ERROR(0, "系统繁忙，请稍后重试!"),

    SIGN_ERROR(-1, "sign错误!"),

	PARAM_IS_NULL(1, "参数不为空!");
    
    private final int code;
    private final String desc;


    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }


	public int getCode() {
		return code;
	}


	public String getDesc() {
		return desc;
	}


}
