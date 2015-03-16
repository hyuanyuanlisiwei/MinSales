package com.minsales.admin.service;

import org.springframework.stereotype.Service;

import com.minsales.admin.bean.Admin;

public interface AdminLoginService {

	public Admin isExist(Admin admin);
	
}
