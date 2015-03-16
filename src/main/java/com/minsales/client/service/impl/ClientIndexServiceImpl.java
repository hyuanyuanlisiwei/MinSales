package com.minsales.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.client.bean.ClientIndexBean;
import com.minsales.client.service.ClientIndexService;
import com.minsales.client.dao.*;
@Service("clientIndexSerivce")
public class ClientIndexServiceImpl implements ClientIndexService {

	@Autowired
	private ClientIndexDao clientIndexDao;
	
	
	@Override
	public List<ClientIndexBean> queryAllNotice() {
		// TODO Auto-generated method stub
		return this.clientIndexDao.queryAllNotice();
	}

	@Override
	public List<ClientIndexBean> queryAllCategory() {
		// TODO Auto-generated method stub
		return this.clientIndexDao.queryAllCategory();
	}

	@Override
	public List<ClientIndexBean> queryAllGoodsByCategoryId(ClientIndexBean bean) {
		// TODO Auto-generated method stub
		return this.clientIndexDao.queryAllGoodsByCategoryId(bean);
	}

	@Override
	public List<ClientIndexBean> queryAllGoodsByCategoryName(
			ClientIndexBean bean) {
		// TODO Auto-generated method stub
		return this.clientIndexDao.queryAllGoodsByCategoryName(bean);
	}

	@Override
	public List<ClientIndexBean> queryAllGoodsByGoodsName(ClientIndexBean bean) {
		// TODO Auto-generated method stub
		return this.clientIndexDao.queryAllGoodsByGoodsName(bean);
	}

	@Override
	public int queryAllGoodsCountByCategoryId(ClientIndexBean bean) {
		// TODO Auto-generated method stub
		return this.clientIndexDao.queryAllGoodsCountByCategoryId(bean);
	}

	@Override
	public int queryAllGoodsCountByCategoryName(ClientIndexBean bean) {
		// TODO Auto-generated method stub
		return this.clientIndexDao.queryAllGoodsCountByCategoryName(bean);
	}

	@Override
	public int queryAllGoodsCountByGoodsName(ClientIndexBean bean) {
		// TODO Auto-generated method stub
		return this.clientIndexDao.queryAllGoodsCountByGoodsName(bean);
	}

}
