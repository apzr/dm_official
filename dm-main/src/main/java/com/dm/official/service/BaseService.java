package com.dm.official.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service基类
 * 
 * @author apr
 * @version 2017-05-15
 */
@Service
public abstract class BaseService {

	/**
	 * 日志对象
	 */
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());


}
