package com.demo.example.rest.utils;

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
	 * @throws ExampleRestRuntimeException
	 */
	public static void notNull(Object object, String message) throws ExampleRestRuntimeException {
		if (object == null) {
			throw new ExampleRestRuntimeException(-1, message);
		}
	}

	/**
	 * 是否有值
	 *
	 * @param text    文本
	 * @param message 错误消息
	 * @throws ExampleRestRuntimeException
	 */
	public static void hasText(String text, String message) throws ExampleRestRuntimeException {
		if (StringUtils.isBlank(text)) {
			throw new ExampleRestRuntimeException(-1, message);
		}
	}

	/**
	 * 表达式是否正确
	 *
	 * @param expression 表达式
	 * @param message    错误消息
	 * @throws ExampleRestRuntimeException
	 */
	public static void isTrue(boolean expression, String message) throws ExampleRestRuntimeException {
		if (!expression) {
			throw new ExampleRestRuntimeException(-1, message);
		}
	}
}
