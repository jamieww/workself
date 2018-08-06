package com.demo.example.grpc.utils;

import com.demo.exception.utils.BaseRuntimeException;

/**
 * Example公用异常
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class ExampleRuntimeException extends BaseRuntimeException {

	/**
	 * Example公用异常
	 *
	 * @param errorMessage 错误信息
	 */
	public ExampleRuntimeException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Example公用异常
	 *
	 * @param errorCode    错误号
	 * @param errorMessage 错误信息
	 */
	public ExampleRuntimeException(int errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}
}
