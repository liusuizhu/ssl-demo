package com.liusuizhu.page.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.liusuizhu.page.util.JsonUtil;

import java.io.Serializable;

/**
 * 响应返回的json体
 * @author John Liu
 */
@JsonInclude(value = Include.NON_NULL)
public class ResponseResult implements Serializable {
	private static final long serialVersionUID = 1L;
    private int status;
	private String msg;
	private Object data;

	private ResponseResult(int status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	private ResponseResult(int status) {
		this(status, null, null);
	}

	private ResponseResult(int status, String msg) {
		this(status, msg, null);
	}

	private ResponseResult(int status, Object data) {
		this(status, null, data);
	}

	@JsonIgnore
	// 使之不在json序列化结果当中
	public boolean isSuccess() {
		return this.status == ResponseCode.SUCCESS.getCode();
	}

	public int getStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public String getMsg() {
		return msg;
	}

	public static ResponseResult createBySuccess() {
		return new ResponseResult(ResponseCode.SUCCESS.getCode());
	}

	public static ResponseResult createBySuccess(String msg) {
		return new ResponseResult(ResponseCode.SUCCESS.getCode(), msg);
	}

	public static ResponseResult createBySuccess(Object data) {
		return new ResponseResult(ResponseCode.SUCCESS.getCode(), data);
	}

	public static ResponseResult createBySuccess(String msg, Object data) {
		return new ResponseResult(ResponseCode.SUCCESS.getCode(), msg, data);
	}

	/**
	 * 分页数据
	 * @param pageInfo
	 * @return
	 */
	public static ResponseResult createBySuccessPage(PageInfo pageInfo) {
		return new ResponseResult(ResponseCode.SUCCESS.getCode(),
				ResponseCode.SUCCESS.getDesc(), pageInfo);
	}
	
	/**
	 * 成功后返回默认msg
	 * 
	 * @return
	 */
	public static ResponseResult createBySuccessMsg() {
		return new ResponseResult(ResponseCode.SUCCESS.getCode(),
				ResponseCode.SUCCESS.getDesc());
	}

	/**
	 * 成功后返回默认msg
	 * 
	 * @return
	 */
	public static ResponseResult createBySuccessMsg(Object data) {
		return new ResponseResult(ResponseCode.SUCCESS.getCode(),
				ResponseCode.SUCCESS.getDesc(), data);
	}

	public static ResponseResult createByError() {
		return new ResponseResult(ResponseCode.ERROR.getCode(),
				ResponseCode.ERROR.getDesc());
	}

	public static ResponseResult createByError(String errorMessage) {
		return new ResponseResult(ResponseCode.ERROR.getCode(), errorMessage);
	}

	public static ResponseResult createByError(ResponseCode responseCode) {
		return new ResponseResult(responseCode.getCode(),
				responseCode.getDesc());
	}

	public static ResponseResult createByError(int errorCode,
			String errorMessage) {
		return new ResponseResult(errorCode, errorMessage);
	}

	@Override
	public String toString() {
		return JsonUtil.obj2String(this);
	}
}
