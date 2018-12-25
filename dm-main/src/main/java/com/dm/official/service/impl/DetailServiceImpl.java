package com.dm.official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.official.entity.Detail;
import com.dm.official.repository.DetailRepository;
import com.dm.official.service.DetailService;

@Service
public class DetailServiceImpl implements DetailService {

	@Autowired
	DetailRepository repository;

	@Override
	public Detail getDetail(Integer id) {
		// 有两种方式：
		// 1.调用crudRepository的接口
		//   return repository.findOne(id);
		// 2.调用我们自己写的接口
		return repository.getDetail(id);
	}

	@Override
	public List<Detail> top(int limit, String type) {
		return repository.top(limit, type);
	}

}