package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.Category;

public interface AdminCategoryService {

	//query
	public List<Category> query(Category category);
	//add
	public int add(Category category);
	//delete
	public int delete(Category category);
	//update
	public int update(Category category);
	
	
}
