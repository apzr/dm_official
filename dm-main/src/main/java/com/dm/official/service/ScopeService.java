package com.dm.official.service;

import java.util.List;

import com.dm.official.entity.Scope;


public interface ScopeService {
	public List<Scope> getScope();

	public Scope getScopeList(Integer id);
	
	public List<Scope> top(int limit);
}