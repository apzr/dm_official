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
	public List<Scope> getScope() {
		return repository.getScope();
	}

	@Override
	public Scope getScopeList(Integer id) {
		return repository.getScopeList(id);
	}
	
	@Override
	public List<Scope> top(int limit) {
		return repository.top(limit);
	}
}