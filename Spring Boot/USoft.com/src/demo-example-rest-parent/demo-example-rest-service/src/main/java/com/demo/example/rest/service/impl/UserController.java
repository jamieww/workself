package com.demo.example.rest.service.impl;

import com.demo.example.rest.api.entity.RespHeader;
import com.demo.example.rest.api.protobuf.GetUserInfoReq;
import com.demo.example.rest.api.protobuf.GetUserInfoResp;
import com.demo.example.rest.api.protobuf.InsertUserInfoReq;
import com.demo.example.rest.api.protobuf.InsertUserInfoResp;
import com.demo.example.rest.domain.UserDomain;
import com.demo.example.rest.utils.ExampleRestRuntimeException;
import com.demo.example.rest.utils.RespUtil;
import com.demo.protobuf.utils.ProtoBufUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Resource
	private UserDomain userDomain;

	@GetMapping(value = "/api/user/get")
	public String getUserInfo(GetUserInfoReq.Builder req) {
		GetUserInfoResp.Builder builder = GetUserInfoResp.newBuilder();
		builder.setRespHeader(RespHeader.newBuilder());
		try {
			builder = userDomain.getUserInfo(req.build());
			LOGGER.info("获取用户信息[UserController.getUserInfo]正常，参数：{}", ProtoBufUtil.toJSONHasTryCatch(req.build()));
		} catch (ExampleRestRuntimeException e) {
			LOGGER.warn("获取用户信息[UserController.getUserInfo]告警，参数：{}", ProtoBufUtil.toJSONHasTryCatch(req), e);
			RespHeader respHeader = RespUtil.getRespHeader(e.getErrorCode(), e.getErrorMessage());
			builder.setRespHeader(respHeader);
		} catch (Exception e) {
			LOGGER.error("获取用户信息[UserController.getUserInfo]异常，参数：{}", ProtoBufUtil.toJSONHasTryCatch(req), e);
			RespHeader respHeader = RespUtil.getRespHeader(ExampleRestRuntimeException.ERROR_CODE_100, e.getMessage());
			builder.setRespHeader(respHeader);
		}
		return ProtoBufUtil.toJSONHasTryCatch(builder.build());
	}

	@PostMapping(value = "/api/user/insert")
	public String insertUserInfo(@RequestBody String json) {
		InsertUserInfoResp.Builder builder = InsertUserInfoResp.newBuilder();
		try {
			InsertUserInfoReq.Builder req = ProtoBufUtil.toProtoBuf(InsertUserInfoReq.newBuilder(), json);
			builder = userDomain.insertUserInfo(req.build());
			builder.setRespHeader(RespHeader.newBuilder());
			LOGGER.info("新增用户信息[UserController.insertUserInfo]正常，参数：{}", ProtoBufUtil.toJSONHasTryCatch(req.build()));
		} catch (ExampleRestRuntimeException e) {
			LOGGER.warn("新增用户信息[UserController.insertUserInfo]告警，参数：{}", json, e);
			RespHeader respHeader = RespUtil.getRespHeader(e.getErrorCode(), e.getErrorMessage());
			builder.setRespHeader(respHeader);
		} catch (Exception e) {
			LOGGER.error("新增用户信息[UserController.insertUserInfo]异常，参数：{}", json, e);
			RespHeader respHeader = RespUtil.getRespHeader(ExampleRestRuntimeException.ERROR_CODE_100, e.getMessage());
			builder.setRespHeader(respHeader);
		}
		return ProtoBufUtil.toJSONHasTryCatch(builder.build());
	}
}
