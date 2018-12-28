package com.dm.official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dm.official.entity.Classic;
import com.dm.official.repository.ClassicRepository;
import com.dm.official.service.BaseService;
import com.dm.official.service.ClassicService;

@Service
public class ClassicServiceImpl extends BaseService implements ClassicService {

	@Autowired
	ClassicRepository repository;

	@Override
	public Classic getDetail(Integer id) {
		return repository.getClassic(id);
	}

	@Override
	public List<Classic> top(int limit) {
		return repository.top(limit);
	}
	
	@Override
	public Page<Classic> page(int pageNumber, int pageSize) {
		PageRequest request = this.buildPageRequest(pageNumber, pageSize);
		Page<Classic> classics = repository.findAll(request);
		return classics;
	}

	/**
	 * 构建PageRequest
	 * 
	 * @param pageNumber
	 * @param pagzSize
	 * @return
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
		return new PageRequest(pageNumber - 1, pagzSize, null);
	}

}