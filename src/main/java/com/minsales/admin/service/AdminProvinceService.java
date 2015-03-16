package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.Province;

public interface AdminProvinceService {

	//query All
	public List<Province> queryAll();
	//查询
	public List<Province> query(Province province);
	//增加
	public int add(Province pro);
	//修改
	public int update(Province pro);
	//删除
	public int delete(Province pro);
	
}
