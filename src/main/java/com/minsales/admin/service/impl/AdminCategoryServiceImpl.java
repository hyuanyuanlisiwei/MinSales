package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.Category;
import com.minsales.admin.dao.AdminCategoryDao;
import com.minsales.admin.service.AdminCategoryService;

@Service("adminCategoryService")
public class AdminCategoryServiceImpl implements AdminCategoryService {

	@Autowired
	private AdminCategoryDao adminCategoryDao;
	
	
	@Override
	public List<Category> query(Category category) {
		// TODO Auto-generated method stub
		return this.adminCategoryDao.query(category);
	}

	@Override
	public int add(Category category) {
		// TODO Auto-generated method stub
		return this.adminCategoryDao.add(category);
	}

	@Override
	public int delete(Category category) {
		// TODO Auto-generated method stub
		return this.adminCategoryDao.delete(category);
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return this.adminCategoryDao.update(category);
	}
}
