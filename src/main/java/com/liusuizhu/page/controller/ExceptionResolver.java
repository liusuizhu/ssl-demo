package com.liusuizhu.page.controller;

import com.liusuizhu.page.common.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @author John Liu
 */
@RestControllerAdvice
public class ExceptionResolver {
	private static Logger log = LoggerFactory.getLogger(ExceptionResolver.class);

	@ExceptionHandler(Exception.class)
	public ResponseResult resolverException(Exception e) {
		log.error("异常原因：{}", e.getMessage(), e);
		return ResponseResult.createByError();
	}
}
