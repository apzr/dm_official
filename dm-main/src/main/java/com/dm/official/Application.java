package com.dm.official;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableConfigurationProperties({KFKConfig.class})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//启动入口:run as java application
		SpringApplication.run(Application.class, args);
	}

}