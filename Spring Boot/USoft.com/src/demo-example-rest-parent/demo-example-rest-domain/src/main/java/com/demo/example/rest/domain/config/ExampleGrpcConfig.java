package com.demo.example.rest.domain.config;

import com.demo.example.grpc.api.protobuf.IEGUserServiceGrpc;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Example GRPC Client 连接配置
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
@Configuration
public class ExampleGrpcConfig {

	/**
	 * 接口连接超时时间,单位毫秒
	 */
	public final static CallOptions.Key<Integer> CO_KEY_CONNECTION_TIMEOUT = CallOptions.Key.of("COKey_ConnectionTimeout", 0);
	@Value("${example.grpc.host}")
	private String exampleGrpcHost;
	@Value("${example.grpc.port}")
	private int exampleGrpcPort;

	@Bean(name = "exampleManagedChannel")
	public ManagedChannel getExampleManagedChannel() {
		return ManagedChannelBuilder.forAddress(exampleGrpcHost, exampleGrpcPort).usePlaintext().build();
	}


	@Bean(name = "exampleEGUserSBS")
	public IEGUserServiceGrpc.IEGUserServiceBlockingStub getExampleEGUserServiceBlockingStub(ManagedChannel exampleManagedChannel) {
		IEGUserServiceGrpc.IEGUserServiceBlockingStub egUserServiceBlockingStub =
				IEGUserServiceGrpc.newBlockingStub(exampleManagedChannel).withOption(CO_KEY_CONNECTION_TIMEOUT, 5000);
		return egUserServiceBlockingStub;
	}

	@Bean(name = "exampleEGUserSFS")
	public IEGUserServiceGrpc.IEGUserServiceFutureStub getExampleEGUserServiceFutureStub(ManagedChannel exampleManagedChannel) {
		IEGUserServiceGrpc.IEGUserServiceFutureStub egUserServiceFutureStub =
				IEGUserServiceGrpc.newFutureStub(exampleManagedChannel).withOption(CO_KEY_CONNECTION_TIMEOUT, 5000);
		return egUserServiceFutureStub;
	}
}
