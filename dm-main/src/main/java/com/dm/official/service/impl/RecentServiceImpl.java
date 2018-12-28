package com.dm.official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dm.official.entity.Recent;
import com.dm.official.repository.RecentRepository;
import com.dm.official.service.BaseService;
import com.dm.official.service.RecentService;

@Service
public class RecentServiceImpl extends BaseService implements RecentService {

	@Autowired
	RecentRepository repository;

	@Override
	public Recent getDetail(Integer id) {
		return repository.getRecent(id);
	}

	@Override
	public List<Recent> top(int limit) {

		return repository.top(limit);
	}
	
	@Override
	public Page<Recent> page(int pageNumber, int pageSize) {
		PageRequest request = this.buildPageRequest(pageNumber, pageSize);
		Page<Recent> recents = repository.findAll(request);
		return recents;
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