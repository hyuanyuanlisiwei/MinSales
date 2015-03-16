package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.Color;
import com.minsales.admin.dao.AdminColorDao;
import com.minsales.admin.service.AdminColorService;

@Service("adminColorService")
public class AdminColorServiceImpl implements AdminColorService {

	@Autowired
	private AdminColorDao adminColorDao;
	
	
	@Override
	public List<Color> query(Color color) {
		// TODO Auto-generated method stub
		return this.adminColorDao.query(color);
	}

	@Override
	public int add(Color color) {
		// TODO Auto-generated method stub
		return this.adminColorDao.add(color);
	}

	@Override
	public int delete(Color color) {
		// TODO Auto-generated method stub
		return this.adminColorDao.delete(color);
	}

	@Override
	public int update(Color color) {
		// TODO Auto-generated method stub
		return this.adminColorDao.update(color);
	}
}
