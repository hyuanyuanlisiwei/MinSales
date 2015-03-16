package com.minsales.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.dao.AdminLoginDao;
import com.minsales.admin.service.AdminLoginService;

@Service("adminLoginService")
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminLoginDao adminLoginDao;
	
	@Override
	public Admin isExist(Admin admin) {
		// TODO Auto-generated method stub
		return this.adminLoginDao.query(admin);
	}

}
