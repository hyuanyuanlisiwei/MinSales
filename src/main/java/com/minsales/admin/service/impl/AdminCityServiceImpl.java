package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.City;
import com.minsales.admin.dao.AdminCityDao;
import com.minsales.admin.service.AdminCityService;

@Service("adminCityService")
public class AdminCityServiceImpl implements AdminCityService {

	@Autowired
	private AdminCityDao adminCityDao;
	
	
	@Override
	public List<City> query(City city) {
		// TODO Auto-generated method stub
		return this.adminCityDao.query(city);
	}

	@Override
	public int add(City city) {
		// TODO Auto-generated method stub
		return this.adminCityDao.add(city);
	}

	@Override
	public int delete(City city) {
		// TODO Auto-generated method stub
		return this.adminCityDao.delete(city);
	}

	@Override
	public int update(City city) {
		// TODO Auto-generated method stub
		return this.adminCityDao.update(city);
	}

	@Override
	public int queryCount(City city) {
		// TODO Auto-generated method stub
		return this.adminCityDao.queryCount(city);
	}

	@Override
	public List<City> queryAll(City city) {
		// TODO Auto-generated method stub
		return this.adminCityDao.queryAll(city);
	}
}
