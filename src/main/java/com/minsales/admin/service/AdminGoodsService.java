package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.Goods;

public interface AdminGoodsService {

	
	public List<Goods> queryByCategoryId(Goods goods);
	//rows
	public List<Goods> query(Goods goods);
	//total;
	public int queryCount(Goods goods);
	//update;
	public int update(Goods goods);
	//insert;
	public int add(Goods goods);
	//delete
	public int delete(Goods goods);
}
