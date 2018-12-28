package com.dm.official.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dm.official.entity.News;


public interface NewsService {
	public News getDetail(Integer id);

	public List<News> top(int limit);

	public Page<News> page(int pageNumber, int pageSize);

}