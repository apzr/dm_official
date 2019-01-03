package com.dm.official.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dm.official.entity.Partner;
import com.dm.official.repository.PartnerRepository;
import com.dm.official.service.BaseService;
import com.dm.official.service.PartnerService;

@Service
public class PartnerServiceImpl extends BaseService implements PartnerService {

	@Autowired
	PartnerRepository repository;

	@Override
	public Partner getDetail(Integer id) {
		return repository.getPartner(id);
	}

	@Override
	public List<Partner> top(int limit) {
		return repository.top(limit);
	}
	
	@Override
	public Page<Partner> page(int pageNumber, int pageSize) {
		PageRequest request = this.buildPageRequest(pageNumber, pageSize);
		Page<Partner> partners = repository.findAll(request);
		return partners;
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