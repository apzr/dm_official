package com.dm.official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dm.official.entity.About;
import com.dm.official.entity.Classic;
import com.dm.official.repository.AboutRepository;
import com.dm.official.service.AboutService;
import com.dm.official.service.BaseService;

@Service
public class AboutServiceImpl extends BaseService implements AboutService {

	@Autowired
	AboutRepository repository;

	@Override
	public About getDetail(Integer id) {
		return repository.getAbout(id);
	}

	@Override
	public List<About> top(int limit) {
		return repository.top(limit);
	}
	
	@Override
	public Page<About> page(int pageNumber, int pageSize) {
		PageRequest request = this.buildPageRequest(pageNumber, pageSize);
		Page<About> classics = repository.findAll(request);
		return classics;
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