package com.dm.official.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dm.official.entity.Counsel;


public interface CounselService {
    public Counsel getDetail(Integer id);

    public Counsel save(Counsel counsel);
    
	public List<Counsel> top(int limit);

	public Page<Counsel> page(int pageNumber, int pageSize);
}