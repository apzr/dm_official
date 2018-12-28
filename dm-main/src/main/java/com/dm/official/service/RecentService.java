package com.dm.official.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dm.official.entity.Recent;


public interface RecentService {
	public Recent getDetail(Integer id);

	public List<Recent> top(int limit);

	public Page<Recent> page(int pageNumber, int pageSize);
}