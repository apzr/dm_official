package com.dm.official.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dm.official.entity.About;


public interface AboutService {
    public About getDetail(Integer id);

	public List<About> top(int limit);

	public Page<About> page(int pageNumber, int pageSize);
}