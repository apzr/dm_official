/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.dm.official.persistences;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2013-05-15
 */
@Service
public abstract class BaseService {

	/**
	 * 日志对象
	 */
	protected Logger LOGGER = LoggerFactory.getLogger(getClass());


}
