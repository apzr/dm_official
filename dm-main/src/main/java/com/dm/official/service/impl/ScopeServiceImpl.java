package com.dm.official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dm.official.entity.Scope;
import com.dm.official.repository.ScopeRepository;
import com.dm.official.service.BaseService;
import com.dm.official.service.ScopeService;

@Service
public class ScopeServiceImpl extends BaseService implements ScopeService {

	@Autowired
	ScopeRepository repository;

	@Override
	public Scope getDetail(Integer id) {
		return repository.getScope(id);
	}

	@Override
	public List<Scope> top(int limit) {
		return repository.top(limit);
	}
	
	@Override
	public Page<Scope> page(int pageNumber, int pageSize) {
		PageRequest request = this.buildPageRequest(pageNumber, pageSize);
		Page<Scope> scopes = repository.findAll(request);
		return scopes;
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