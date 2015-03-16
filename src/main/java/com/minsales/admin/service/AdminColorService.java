package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.Color;

public interface AdminColorService {

	//query
	public List<Color> query(Color color);
	//add
	public int add(Color color);
	//delete
	public int delete(Color color);
	//update
	public int update(Color color);
	
	
}
