package com.demo.example.grpc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangcanyi
 * @description 产品库GRPC服务
 * @date 2018/3/28
 */
@EnableTransactionManagement
@SpringBootApplication(
		scanBasePackages = {"com.demo.example"},
		exclude = {
				MongoAutoConfiguration.class,
				MongoDataAutoConfiguration.class,
				MongoRepositoriesAutoConfiguration.class
		})
@MapperScan("com.demo.example.grpc.dal.mapper")
public class ExampleGrpcServiceStart {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExampleGrpcServiceStart.class);
	}
}
