package com.demo.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * Demo Rest 服务
 * @author wangcanyi
 * @date 2018/3/28
 */
@SpringBootApplication(
		scanBasePackages = {"com.demo.example"},
		exclude = {
				MongoAutoConfiguration.class,
				MongoDataAutoConfiguration.class,
				MongoRepositoriesAutoConfiguration.class
		})
public class ExampleRestServiceStart {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ExampleRestServiceStart.class);
	}
}
