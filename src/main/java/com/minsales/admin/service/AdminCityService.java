package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.City;

public interface AdminCityService {

	public List<City> queryAll(City city);
 	
	//queryCount;
	public int queryCount(City city);
	
	// query;
	public List<City> query(City city);

	// insert;
	public int add(City city);

	// delete;
	public int delete(City city);

	// update;
	public int update(City city);
	
}
