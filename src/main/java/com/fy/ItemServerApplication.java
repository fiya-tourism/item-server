package com.fy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan(value = "com.fy.item.mapper")
@EnableEurekaClient  //用来注册该服务
@SpringBootApplication
public class ItemServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServerApplication.class, args);
	}

}
