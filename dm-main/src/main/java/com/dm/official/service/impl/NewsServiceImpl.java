package com.dm.official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dm.official.entity.News;
import com.dm.official.repository.NewsRepository;
import com.dm.official.service.BaseService;
import com.dm.official.service.NewsService;

@Service
public class NewsServiceImpl extends BaseService implements NewsService {

	@Autowired
	NewsRepository repository;

	@Override
	public News getDetail(Integer id) {
		return repository.getNews(id);
	}

	@Override
	public List<News> top(int limit) {

		return repository.top(limit);
	}

	@Override
	public Page<News> page(int pageNumber, int pageSize) {
		PageRequest request = this.buildPageRequest(pageNumber, pageSize);
		Page<News> newss = repository.findAll(request);
		return newss;
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