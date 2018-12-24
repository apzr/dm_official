package com.dm.official.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dm.official.persistences.BaseService;
import com.dm.official.persistences.SpringBootJdbc;

@Service
@Qualifier("jobService")
public class JobService extends BaseService {
	
	@Autowired
	SpringBootJdbc dao;
	
	public  Boolean makeJob(String topic, String value) {
		return false;
				
	}

}
