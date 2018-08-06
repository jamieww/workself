package com.demo.example.grpc.service.impl;

import com.demo.example.grpc.api.entity.UserInfo;
import com.demo.example.grpc.api.protobuf.*;
import com.demo.example.grpc.DefaultTest;
import com.demo.protobuf.utils.ProtoBufUtil;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * Created by zhanyanjun on 2018/6/1.
 */
public class EGUserServiceTest extends DefaultTest {

	IEGUserServiceGrpc.IEGUserServiceBlockingStub iegUserServiceBlockingStub = IEGUserServiceGrpc.newBlockingStub(this.grpcChannel);

	@Test
	public void getUserInfo() {
		GetUserInfoRequest.Builder request = GetUserInfoRequest.newBuilder();
		request.setUserCode("111111");
		GetUserInfoResponse response = iegUserServiceBlockingStub.getUserInfo(request.build());
		Assert.isTrue(response.getResponseHeader().getCode() == 0, response.getResponseHeader().getMsg());
		System.out.println("------返回结果--------");
		System.out.println(ProtoBufUtil.toJSONHasTryCatch(response));
	}

	@Test
	public void insertUserInfo() {
		InsertUserInfoRequest.Builder request = InsertUserInfoRequest.newBuilder();
		UserInfo.Builder userInfo = UserInfo.newBuilder();
		userInfo.setCode("333336");
		userInfo.setName("mmm");
		userInfo.setAge(11);
		userInfo.setAmount(1.22);
		userInfo.setGender(1);
		userInfo.setBirthday("2018-07-10 20:20:20");
		request.setUserInfo(userInfo);
		InsertUserInfoResponse response = iegUserServiceBlockingStub.insertUserInfo(request.build());
		Assert.isTrue(response.getResponseHeader().getCode() == 0, response.getResponseHeader().getMsg());
		System.out.println("------返回结果--------");
		System.out.println(ProtoBufUtil.toJSONHasTryCatch(response));
	}
}
