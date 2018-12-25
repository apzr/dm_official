package com.dm.official.ctrl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.official.entity.Detail; 
import com.dm.official.service.DetailService;

@RestController
public class DetailController {
	@Autowired
	DetailService service;

	@RequestMapping("/detail/{id}")
	public Detail getDetail(@PathVariable("id") Integer id) {
		return service.getDetail(id);
	}

	/**
	 * 按时间顺序查询某类型的前若干条数据
	 * 
	 * @param limit
	 * @param type
	 * @return
	 */
	public List<Detail> top(int limit, String type) {
		return service.top(limit, type);
	}
}