package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;

import com.minsales.admin.bean.City;

import java.util.*;
@Repository("adminCityDao")
public interface AdminCityDao {

	//queryAll
	public List<City> queryAll(City city);
	//queryCount;
	public int queryCount(City city);
	//query;
	public List<City> query(City city);
	//insert;
	public int add(City city);
	//delete;
	public int delete(City city);
	//update;
	public int update(City city);
	
	
}
