package com.minsales.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsales.base.BaseController;

/**
 * 基础管理模块的定首页controller;
 * @author hyy
 *
 */
@Controller
@RequestMapping("/AdminPrimaryController")
public class AdminPrimaryController extends BaseController{

	
	// 省份首页
	@RequestMapping("/delivery.do")
	public String delivery() {
		
		return "admin/delivery";
	}
	
	
	//省份首页
	@RequestMapping("/province.do")
	public String province()
	{
		return "admin/province";
	}
	
	//市区首页
	@RequestMapping("/city.do")
	public String city()
	{
		return "admin/city";
	}
	
	// 县级首页
	@RequestMapping("/county.do")
	public String county() {
		return "admin/county";
	}
	
	// 县级首页
	@RequestMapping("/color.do")
	public String color() {
		return "admin/color";
	}
	// 县级首页
	@RequestMapping("/evaluateLevel.do")
	public String evaluateLevel() {
		return "admin/evaluateLevel";
	}
	
	// 今日公告首页
	@RequestMapping("/notice.do")
	public String notice() {
	
		return "admin/notice";

	}
	
	
	//商品分类管理
	@RequestMapping("/category.do")
	public String category()
	{
		return "admin/category";
	}
	
	//商品分类管理
	@RequestMapping("/goods.do")
	public String goods()
	{
		return "admin/goods";
	}

	// 商品图片管理
	@RequestMapping("/image.do")
	public String image() {
		return "admin/image";
	}
}
