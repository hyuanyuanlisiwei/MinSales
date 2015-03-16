package com.minsales.client.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minsales.base.*;

import java.util.*;

import com.minsales.client.bean.*;
import com.minsales.client.service.ClientIndexService;

@Controller
@RequestMapping("/ClientIndexController")
public class ClientIndexController extends BaseController{

	@Autowired
	private ClientIndexService clientIndexService;
	
	//查询所有的公告;
	@RequestMapping("/queryAllNotice.do")
	public String queryAllNotice(ModelMap map)
	{
		List<ClientIndexBean> rows=this.clientIndexService.queryAllNotice();
		
		map.put("total",rows.size());
		map.put("rows",rows);
		
		return "json";
	}

	// 查询所有的分类;
	@RequestMapping("/queryAllCategory.do")
	public String queryAllCategory(ModelMap map) {
		List<ClientIndexBean> rows = this.clientIndexService.queryAllCategory();
		
		map.put("total", rows.size());
		map.put("rows", rows);

		return "json";
	}
	
	//查询所有商品;
	@RequestMapping("/queryAllGoods.do")
	public String queryAllGoods(ModelMap map,ClientIndexBean bean)
	{
		//get type
		String queryType=bean.getQueryType();
		//result param
		int total=0;
		List<ClientIndexBean> rows=null;
		
		//page
		Pagination pagination=new Pagination(bean.getPage(),bean.getRows());
		bean.setFrom(pagination.getFormIndex());
		bean.setSize(pagination.getPageSize());
		
		if("categoryId".equals(queryType))//按分类id查询;
		{
			total=this.clientIndexService.queryAllGoodsCountByCategoryId(bean);
			rows=this.clientIndexService.queryAllGoodsByCategoryId(bean);
			
		}else if("categoryName".equals(queryType))//按分类名称查询;
		{
			total=this.clientIndexService.queryAllGoodsCountByCategoryName(bean);
			rows=this.clientIndexService.queryAllGoodsByCategoryName(bean);
		}else//默认按照goodsName查询;
		{
			total=this.clientIndexService.queryAllGoodsCountByGoodsName(bean);
			rows=this.clientIndexService.queryAllGoodsByGoodsName(bean);
		}
		//return total and rows;
		map.put("total",total);
		map.put("rows",rows);
		
		return "json";
	}
	
	//进入详情页面;
	@RequestMapping("/detail.do")
	public String detail(ClientIndexBean bean,ModelMap map)
	{
		//得到goodsId;
		
		
		
		//查询出该商品的所有信息;
		
		
		
		//
		
		return "client/detail";
	}
}
