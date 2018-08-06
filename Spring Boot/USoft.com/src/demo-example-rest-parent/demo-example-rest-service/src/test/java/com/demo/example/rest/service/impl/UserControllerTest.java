package com.demo.example.rest.service.impl;

import com.demo.example.rest.DefaultTest;
import com.demo.example.rest.api.entity.UserInfo;
import com.demo.example.rest.api.protobuf.InsertUserInfoReq;
import com.demo.protobuf.utils.ProtoBufUtil;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * @author: wangcanyi
 * @date: 2018-08-01 14:45
 **/
public class UserControllerTest extends DefaultTest {

	@Test
	public void getUserInfo() throws IOException {
		String url = baseUrl + "/api/user/get";
		url += "?userCode=111111";
		// 创建get方式请求对象
		HttpGet httpGet = new HttpGet(url);
		// 通过请求对象获取响应对象
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 判断网络连接状态码是否正常
		Assert.isTrue(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK, "HTTP 返回码不为 200");
		// 获取结果实体
		String result = EntityUtils.toString(response.getEntity(),"UTF-8");
		// 释放链接
		response.close();
		System.out.println("------返回结果--------");
		System.out.println(result);
	}

	@Test
	public void insertUserInfo() throws IOException {
		String url = baseUrl + "/api/user/insert";
		UserInfo.Builder userInfo = UserInfo.newBuilder();
		userInfo.setCode("555557");
		userInfo.setName("555Name");
		InsertUserInfoReq.Builder builder = InsertUserInfoReq.newBuilder();
		builder.setUserInfo(userInfo);
		HttpPost httpPost = new HttpPost(url);
		StringEntity stringEntity = new StringEntity(ProtoBufUtil.toJSON(builder), ContentType.APPLICATION_JSON);
		stringEntity.setContentEncoding("UTF-8");
		httpPost.setEntity(stringEntity);// 通过请求对象获取响应对象
		CloseableHttpResponse response = httpClient.execute(httpPost);
		// 判断网络连接状态码是否正常
		Assert.isTrue(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK, "HTTP 返回码不为 200");
		// 获取结果实体
		String result = EntityUtils.toString(response.getEntity());
		// 释放链接
		response.close();
		System.out.println("------返回结果--------");
		System.out.println(result);

	}
}
