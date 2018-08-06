package com.demo.example.grpc.utils;

import com.demo.example.grpc.api.entity.ResponseHeader;

/**
 * 响应工具类
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class ResponseUtil {

	/**
	 * 获取自定义响应头
	 *
	 * @param code 返回码
	 * @param msg  返回消息
	 * @return
	 */
	public static ResponseHeader getResponseHeader(int code, String msg) {
		ResponseHeader.Builder builder = ResponseHeader.newBuilder();
		builder.setCode(code);
		builder.setMsg(msg);
		return builder.build();
	}

}
