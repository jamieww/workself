package com.demo.example.grpc.service.impl;

import com.demo.example.grpc.api.entity.ResponseHeader;
import com.demo.example.grpc.api.protobuf.*;
import com.demo.example.grpc.bl.UserBl;
import com.demo.example.grpc.utils.ExampleRuntimeException;
import com.demo.example.grpc.utils.ResponseUtil;
import com.demo.protobuf.utils.ProtoBufUtil;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
@GRpcService
public class EgUserServiceImpl extends IEGUserServiceGrpc.IEGUserServiceImplBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(EgUserServiceImpl.class);

	@Resource
	private UserBl userBL;

	@Override
	public void getUserInfo(GetUserInfoRequest request, StreamObserver<GetUserInfoResponse> responseObserver) {
		GetUserInfoResponse.Builder builder = GetUserInfoResponse.newBuilder();
		try {
			builder = userBL.getUserInfo(request);
			LOGGER.info("获取用户信息[EGUserServiceImpl.getUserInfo]正常，参数：{}", ProtoBufUtil.toJSONHasTryCatch(request));
		} catch (ExampleRuntimeException e) {
			LOGGER.warn("获取用户信息[EGUserServiceImpl.getUserInfo]告警，参数：{}", ProtoBufUtil.toJSONHasTryCatch(request), e);
			ResponseHeader responseHeader = ResponseUtil.getResponseHeader(e.getErrorCode(), e.getErrorMessage());
			builder.setResponseHeader(responseHeader);
		} catch (Exception e) {
			LOGGER.error("获取用户信息[EGUserServiceImpl.getUserInfo]异常，参数：{}", ProtoBufUtil.toJSONHasTryCatch(request), e);
			ResponseHeader responseHeader = ResponseUtil.getResponseHeader(ExampleRuntimeException.ERROR_CODE_100, e.getMessage());
			builder.setResponseHeader(responseHeader);
		}
		responseObserver.onNext(builder.build());
		responseObserver.onCompleted();
	}

	@Override
	public void insertUserInfo(InsertUserInfoRequest request, StreamObserver<InsertUserInfoResponse> responseObserver) {
		InsertUserInfoResponse.Builder builder = InsertUserInfoResponse.newBuilder();
		try {
			builder = userBL.insertUserInfo(request);
			LOGGER.info("新增用户信息[EGUserServiceImpl.insertUserInfo]正常，参数：{}", ProtoBufUtil.toJSONHasTryCatch(request));
		} catch (ExampleRuntimeException e) {
			LOGGER.warn("新增用户信息[EGUserServiceImpl.insertUserInfo]告警，参数：{}", ProtoBufUtil.toJSONHasTryCatch(request), e);
			ResponseHeader responseHeader = ResponseUtil.getResponseHeader(e.getErrorCode(), e.getErrorMessage());
			builder.setResponseHeader(responseHeader);
		} catch (Exception e) {
			LOGGER.error("新增用户信息[EGUserServiceImpl.insertUserInfo]异常，参数：{}", ProtoBufUtil.toJSONHasTryCatch(request), e);
			ResponseHeader responseHeader = ResponseUtil.getResponseHeader(ExampleRuntimeException.ERROR_CODE_100, e.getMessage());
			builder.setResponseHeader(responseHeader);
		}
		responseObserver.onNext(builder.build());
		responseObserver.onCompleted();
	}
}
