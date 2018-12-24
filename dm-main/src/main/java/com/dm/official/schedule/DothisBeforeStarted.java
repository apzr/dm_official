package com.dm.official.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dm.official.persistences.SpringBootJdbc;


/**
 * 
 * Springboot使用CommandLineRunner进行项目启动后执行，例如初始化数据加载
 * PostConstruct是指在实例化bean的时候预先执行的方法
 * CommandLineRunner是指在项目启动后执行的方法
 *
 * @author stay
 *
 */
@Component
public class DothisBeforeStarted implements CommandLineRunner {

	@Autowired
	SpringBootJdbc dao;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("DothisBeforeStarted");
	}
}
