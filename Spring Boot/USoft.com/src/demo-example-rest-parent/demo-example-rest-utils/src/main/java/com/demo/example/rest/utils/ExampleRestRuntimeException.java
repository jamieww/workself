package com.demo.example.rest.utils;

import com.demo.exception.utils.BaseRuntimeException;

/**
 * Example公用异常
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class ExampleRestRuntimeException extends BaseRuntimeException {

	/**
	 * Example公用异常
	 *
	 * @param errorMessage 错误信息
	 */
	public ExampleRestRuntimeException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Example公用异常
	 *
	 * @param errorCode    错误号
	 * @param errorMessage 错误信息
	 */
	public ExampleRestRuntimeException(int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
