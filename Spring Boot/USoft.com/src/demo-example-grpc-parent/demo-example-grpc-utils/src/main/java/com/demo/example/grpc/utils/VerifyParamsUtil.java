package com.demo.example.grpc.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 参数校验
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class VerifyParamsUtil {

	/**
	 * 对象是否为空
	 *
	 * @param object  对象
	 * @param message 错误消息
	 * @throws ExampleRuntimeException
	 */
	public static void notNull(Object object, String message) throws ExampleRuntimeException {
		if (object == null) {
			throw new ExampleRuntimeException(-1, message);
		}
	}

	/**
	 * 是否有值
	 *
	 * @param text    文本
	 * @param message 错误消息
	 * @throws ExampleRuntimeException
	 */
	public static void hasText(String text, String message) throws ExampleRuntimeException {
		if (StringUtils.isBlank(text)) {
			throw new ExampleRuntimeException(-1, message);
		}
	}

	/**
	 * 表达式是否正确
	 *
	 * @param expression 表达式
	 * @param message    错误消息
	 * @throws ExampleRuntimeException
	 */
	public static void isTrue(boolean expression, String message) throws ExampleRuntimeException {
		if (!expression) {
			throw new ExampleRuntimeException(-1, message);
		}
	}
}
