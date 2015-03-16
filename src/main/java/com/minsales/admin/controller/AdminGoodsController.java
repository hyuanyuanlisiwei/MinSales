package com.minsales.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minsales.admin.bean.Category;
import com.minsales.admin.bean.Goods;
import com.minsales.admin.bean.Goods;
import com.minsales.admin.service.AdminCategoryService;
import com.minsales.admin.service.AdminGoodsService;
import com.minsales.base.BaseController;
import com.minsales.base.ExecuteResult;
import com.minsales.base.Pagination;
import com.minsales.base.ResultCode;

import java.util.*;
@Controller
@RequestMapping("/AdminGoodsController")
public class AdminGoodsController extends BaseController {

	@Autowired
	private AdminGoodsService adminGoodsService;
	
	@Autowired
	private AdminCategoryService adminCategoryService;
	
	
	//查询所有的分类;
	@RequestMapping("/queryAllCategory.do")
	@ResponseBody
	public List<Category> queryAllCategory()
	{
		Category category=new Category();
		List<Category> list=this.adminCategoryService.query(category);
		//第一项;
		category.setName("全部...");
		list.add(0,category);
		return list;
	}
	
	//查询商品
	@RequestMapping("/query.do")
	public String query(ModelMap map,Goods goods)
	{
		//prepare pagiantion data;
		Pagination pagination=new Pagination(goods.getPage(),goods.getRows());
		goods.setFrom(pagination.getFormIndex());
		goods.setSize(pagination.getSize());
		//exexute query;
		List<Goods> rows=this.adminGoodsService.query(goods);
		int total=this.adminGoodsService.queryCount(goods);
		//return json;
		map.put("total",total);
		map.put("rows", rows);
		
		return "json";
	}
	
	//insert
		@RequestMapping("/add.do")
		@ResponseBody
		public ExecuteResult<String> add(Goods goods) {
			// 1,prepare result
			ExecuteResult<String> result = new ExecuteResult<String>();
			// 2,execute add
			int count = this.adminGoodsService.add(goods);
			// 3,get result;
			result.setInfo("添加了" + count + "行");
			if (count > 0) {
				result.setCode(ResultCode.SUCCESS.code);
				result.setMsg("添加成功");

			} else {
				result.setCode(ResultCode.FAIL.code);
				result.setMsg("添加失败");
			}
			return result;
		}
		
		@RequestMapping("/delete.do")
		@ResponseBody
		public ExecuteResult<String> delete(Goods goods)
		{
			//1,prepare result
			ExecuteResult<String> result=new ExecuteResult<String>();
			//2,execute delete
			int count=this.adminGoodsService.delete(goods);
			//3,get result
			result.setInfo("删了"+count+"行!");
			if(count>0)
			{
				result.setCode(ResultCode.SUCCESS.code);
				result.setMsg("删除成功!");
			}else
			{
				result.setCode(ResultCode.FAIL.code);
				result.setMsg("删除失败!");
			}
			return result;
		}
		
		@RequestMapping("/update.do")
		@ResponseBody
		public ExecuteResult<String> update(Goods goods) {
			// 1,prepare result
			ExecuteResult<String> result = new ExecuteResult<String>();
			// 2,execute delete
			int count = this.adminGoodsService.update(goods);
			// 3,get result;
			result.setInfo("修改了" + count + "行");
			if (count > 0) {
				result.setCode(ResultCode.SUCCESS.code);
				result.setMsg("修改成功");

			} else {
				result.setCode(ResultCode.FAIL.code);
				result.setMsg("修改失败");
			}

			return result;
		}
}
