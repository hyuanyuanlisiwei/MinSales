package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;

import com.minsales.admin.bean.Admin;

@Repository("adminLoginDao")
public interface AdminLoginDao {

	//登录验证;
	public Admin query(Admin admin);
	
}
