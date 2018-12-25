package com.dm.official.service;

import java.util.List;

import com.dm.official.entity.Detail;


public interface DetailService {
    public Detail getDetail(Integer id);

	public List<Detail> top(int limit, String type);
}