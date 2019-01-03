package com.dm.official.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dm.official.entity.Scope;


public interface ScopeService {
	public Scope getDetail(Integer id);

	public List<Scope> top(int limit);

	public Page<Scope> page(int pageNumber, int pageSize);
}