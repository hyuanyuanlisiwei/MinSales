package com.minsales.client.service;

import java.util.List;

import com.minsales.client.bean.ClientIndexBean;

public interface ClientIndexService {

	// 查询所有的公告;
	public List<ClientIndexBean> queryAllNotice();

	// 查询所有的分类;
	public List<ClientIndexBean> queryAllCategory();
	
	//查询所有的商品;
	public List<ClientIndexBean> queryAllGoodsByCategoryId(ClientIndexBean bean);
	public List<ClientIndexBean> queryAllGoodsByCategoryName(ClientIndexBean bean);
	public List<ClientIndexBean> queryAllGoodsByGoodsName(ClientIndexBean bean);

	//查询所有的商品;
	public int queryAllGoodsCountByCategoryId(ClientIndexBean bean);
	public int queryAllGoodsCountByCategoryName(ClientIndexBean bean);
	public int queryAllGoodsCountByGoodsName(ClientIndexBean bean);

}
