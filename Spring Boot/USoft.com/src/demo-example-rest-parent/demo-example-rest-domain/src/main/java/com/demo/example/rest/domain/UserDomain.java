package com.demo.example.rest.domain;

import com.demo.example.grpc.api.protobuf.*;
import com.demo.example.rest.api.entity.UserInfo;
import com.demo.example.rest.api.protobuf.GetUserInfoReq;
import com.demo.example.rest.api.protobuf.GetUserInfoResp;
import com.demo.example.rest.api.protobuf.InsertUserInfoReq;
import com.demo.example.rest.api.protobuf.InsertUserInfoResp;
import com.demo.example.rest.utils.ExampleRestRuntimeException;
import com.demo.example.rest.utils.VerifyParamsUtil;
import com.demo.protobuf.utils.ProtoBufUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 **/
@Service
public class UserDomain {
	@Autowired
	private IEGUserServiceGrpc.IEGUserServiceBlockingStub exampleEGUserSBS;

	/**
	 * 获取用户信息-restAPI /api/user/get, method:get, type:kv
	 *
	 * @param req
	 * @return
	 * @throws InvalidProtocolBufferException
	 */
	public GetUserInfoResp.Builder getUserInfo(GetUserInfoReq req) throws InvalidProtocolBufferException {
		VerifyParamsUtil.hasText(req.getUserCode(), "用户编号不能为空");
		GetUserInfoRequest.Builder builder = GetUserInfoRequest.newBuilder();
		builder.setUserCode(req.getUserCode());
		GetUserInfoResponse response = exampleEGUserSBS.getUserInfo(builder.build());
		if (response.getResponseHeader().getCode() != 0) {
			throw new ExampleRestRuntimeException(response.getResponseHeader().getMsg());
		}
		UserInfo.Builder userInfo = ProtoBufUtil.toProtoBuf(UserInfo.newBuilder(), response.getUserInfo());
		GetUserInfoResp.Builder resp = GetUserInfoResp.newBuilder();
		resp.setUserInfo(userInfo);
		return resp;
	}

	/**
	 * 新增用户信息-restAPI /api/user/insert, method:post, type:json
	 *
	 * @param req
	 * @return
	 * @throws InvalidProtocolBufferException
	 */
	public InsertUserInfoResp.Builder insertUserInfo(InsertUserInfoReq req) throws InvalidProtocolBufferException {
		com.demo.example.grpc.api.entity.UserInfo.Builder userInfo = ProtoBufUtil.toProtoBuf(com.demo.example.grpc.api.entity.UserInfo.newBuilder(), req.getUserInfo());
		InsertUserInfoRequest.Builder builder = InsertUserInfoRequest.newBuilder();
		builder.setUserInfo(userInfo);
		InsertUserInfoResponse response = exampleEGUserSBS.insertUserInfo(builder.build());
		if (response.getResponseHeader().getCode() != 0) {
			throw new ExampleRestRuntimeException(response.getResponseHeader().getMsg());
		}
		return InsertUserInfoResp.newBuilder();
	}
}
