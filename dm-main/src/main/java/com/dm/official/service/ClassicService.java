package com.dm.official.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dm.official.entity.Classic;


public interface ClassicService {
    public Classic getDetail(Integer id);

	public List<Classic> top(int limit);

	public Page<Classic> page(int pageNumber, int pageSize);
}