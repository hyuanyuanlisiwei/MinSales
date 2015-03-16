package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.Province;
import com.minsales.admin.dao.AdminProvinceDao;
import com.minsales.admin.service.AdminLoginService;
import com.minsales.admin.service.AdminProvinceService;

@Service("adminProvinceService")
public class AdminProvinceServiceImpl implements AdminProvinceService {

	@Autowired
	private AdminProvinceDao adminProviceDao;

	@Override
	public List<Province> query(Province province) {
		// TODO Auto-generated method stub
		return this.adminProviceDao.query(province);
	}

	@Override
	public int add(Province pro) {
		// TODO Auto-generated method stub
		return this.adminProviceDao.add(pro);
	}

	@Override
	public int update(Province pro) {
		// TODO Auto-generated method stub
		return this.adminProviceDao.update(pro);
	}

	@Override
	public int delete(Province pro) {
		// TODO Auto-generated method stub
		return this.adminProviceDao.delete(pro);
	}

	@Override
	public List<Province> queryAll() {
		// TODO Auto-generated method stub
		return this.adminProviceDao.queryAll();
	}
	
	

}
