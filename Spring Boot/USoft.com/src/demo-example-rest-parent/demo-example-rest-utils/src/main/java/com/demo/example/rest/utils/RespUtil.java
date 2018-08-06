package com.demo.example.rest.utils;

import com.demo.example.rest.api.entity.RespHeader;

/**
 * 响应工具类
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class RespUtil {

	/**
	 * 获取自定义响应头
	 *
	 * @param code 返回码
	 * @param msg  返回消息
	 * @return
	 */
	public static RespHeader getRespHeader(int code, String msg) {
		RespHeader.Builder builder = RespHeader.newBuilder();
		builder.setCode(code);
		builder.setMsg(msg);
		return builder.build();
	}

}
