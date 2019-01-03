package com.dm.official.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dm.official.entity.Partner;


public interface PartnerService {
	public Partner getDetail(Integer id);

	public List<Partner> top(int limit);

	public Page<Partner> page(int pageNumber, int pageSize);

}