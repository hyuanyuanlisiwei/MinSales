package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.City;
import com.minsales.admin.bean.County;

public interface AdminCountyService {

	// 根据city_id查询所有的县
	public List<County> queryAll(County county);

	// 分页查询所需要的total;
	public int queryCount(County county);

	// 分页查询的rows;
	public List<County> query(County county);

	// insert;
	public int add(County county);

	// delete;
	public int delete(County county);

	// update;
	public int update(County county);
	
}
