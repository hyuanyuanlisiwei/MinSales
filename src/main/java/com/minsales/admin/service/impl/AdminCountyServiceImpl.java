package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.County;
import com.minsales.admin.dao.AdminCountyDao;
import com.minsales.admin.service.AdminCountyService;

@Service("adminCountyService")
public class AdminCountyServiceImpl implements AdminCountyService {

	@Autowired
	private AdminCountyDao adminCountyDao;
	
	@Override
	public List<County> queryAll(County county) {
		// TODO Auto-generated method stub
		return this.adminCountyDao.query(county);
	}

	@Override
	public int queryCount(County county) {
		// TODO Auto-generated method stub
		return this.adminCountyDao.queryCount(county);
	}

	@Override
	public List<County> query(County county) {
		// TODO Auto-generated method stub
		return this.adminCountyDao.query(county);
	}

	@Override
	public int add(County county) {
		// TODO Auto-generated method stub
		return this.adminCountyDao.add(county);
	}

	@Override
	public int delete(County county) {
		// TODO Auto-generated method stub
		return this.adminCountyDao.delete(county);
	}

	@Override
	public int update(County county) {
		// TODO Auto-generated method stub
		return this.adminCountyDao.update(county);
	}
}
