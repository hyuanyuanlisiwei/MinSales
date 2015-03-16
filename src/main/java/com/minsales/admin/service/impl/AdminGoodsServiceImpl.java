package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.Goods;
import com.minsales.admin.dao.AdminGoodsDao;
import com.minsales.admin.service.AdminGoodsService;

@Service("adminGoodsService")
public class AdminGoodsServiceImpl implements AdminGoodsService {

	@Autowired
	private AdminGoodsDao adminGoodsDao;
	
	
	@Override
	public List<Goods> query(Goods goods) {
		// TODO Auto-generated method stub
		return this.adminGoodsDao.query(goods);
	}

	@Override
	public int queryCount(Goods goods) {
		// TODO Auto-generated method stub
		return this.adminGoodsDao.queryCount(goods);
	}

	@Override
	public int update(Goods goods) {
		// TODO Auto-generated method stub
		return this.adminGoodsDao.update(goods);
	}

	//这里要添加事务处理;
	@Override
	public int add(Goods goods) {
		// TODO Auto-generated method stub
		       //add img
		this.adminGoodsDao.add(goods);
		return this.adminGoodsDao.addImgAddress(goods);
	}

	@Override
	public int delete(Goods goods) {
		// TODO Auto-generated method stub
		return this.adminGoodsDao.delete(goods);
	}

	@Override
	public List<Goods> queryByCategoryId(Goods goods) {
		// TODO Auto-generated method stub
		return this.adminGoodsDao.queryByCategoryId(goods);
	}
}
