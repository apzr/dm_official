package com.dm.official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dm.official.entity.Counsel;
import com.dm.official.repository.CounselRepository;
import com.dm.official.service.BaseService;
import com.dm.official.service.CounselService;

@Service
public class CounselServiceImpl extends BaseService implements CounselService {

	@Autowired
	CounselRepository repository;

	@Override
	public Counsel getDetail(Integer id) {
		return repository.getAbout(id);
	}

	@Override
	public List<Counsel> top(int limit) {
		return repository.top(limit);
	}
	
	@Override
	public Page<Counsel> page(int pageNumber, int pageSize) {
		PageRequest request = this.buildPageRequest(pageNumber, pageSize);
		Page<Counsel> counsel = repository.findAll(request);
		return counsel;
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

	@Override
	public Counsel save(Counsel counsel) {
		return repository.save(counsel);
	}

}