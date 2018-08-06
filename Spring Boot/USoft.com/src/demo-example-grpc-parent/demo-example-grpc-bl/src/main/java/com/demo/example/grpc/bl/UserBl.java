package com.demo.example.grpc.bl;

import com.demo.example.grpc.api.entity.UserInfo;
import com.demo.example.grpc.api.protobuf.*;
import com.demo.example.grpc.dal.entity.User;
import com.demo.example.grpc.dal.mapper.UserMapper;
import com.demo.example.grpc.utils.ExampleRuntimeException;
import com.demo.example.grpc.utils.VerifyParamsUtil;
import com.demo.protobuf.utils.ProtoBufUtil;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户领域 业务逻辑层
 *
 * @author: wangcanyi
 * @date: 2018-07-27 10:44
 **/
@Service
public class UserBl {
	@Autowired
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	private UserMapper userMapper;
	@Autowired
	private IEGUserServiceGrpc.IEGUserServiceBlockingStub exampleEGUserServiceBlockingStub;

	/**
	 * 获取用户信息
	 *
	 * @param request
	 * @return
	 */
	public GetUserInfoResponse.Builder getUserInfo(GetUserInfoRequest request) throws InvalidProtocolBufferException {
		GetUserInfoResponse.Builder response = GetUserInfoResponse.newBuilder();
		VerifyParamsUtil.hasText(request.getUserCode(), "用户编号不能为空");
		User user = userMapper.findByUserCode(request.getUserCode());
		if (user == null) {
			return GetUserInfoResponse.newBuilder();
		}
		UserInfo.Builder uiBuilder = UserInfo.newBuilder();
		uiBuilder = ProtoBufUtil.toProtoBuf(uiBuilder, user);
		response.setUserInfo(uiBuilder);
		return response;
	}

	/**
	 * 新增用户信息
	 *
	 * @param request
	 * @return
	 */
	@Transactional(rollbackFor = Exception.class)
	public InsertUserInfoResponse.Builder insertUserInfo(InsertUserInfoRequest request) throws InvalidProtocolBufferException {
		VerifyParamsUtil.hasText(request.getUserInfo().getCode(), "用户编号不能为空");
		User user = ProtoBufUtil.toBean(request.getUserInfo(), User.class);
		if (user == null) {
			throw new ExampleRuntimeException("用户信息为空");
		}
		userMapper.insertSelective(user);
		return InsertUserInfoResponse.newBuilder();
	}
}
