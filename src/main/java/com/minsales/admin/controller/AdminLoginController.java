package com.minsales.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsales.admin.bean.Admin;
import com.minsales.base.BaseController;

@Controller
@RequestMapping("/AdminLoginController")
public class AdminLoginController extends BaseController{

	
	
	//重定向到登陆页;
	@RequestMapping("/login.do")
	public String login()
	{
		return "admin/login";
	}
	
	//登陆验证;
	@RequestMapping("/index.do")
	public String index(Admin admin,ModelMap map)
	{
		
		map.put("result", 0);
		
		return "json";
		
	}
	
	//首页;
	@RequestMapping("/newInfo.do")
	public String newInfo()
	{
		return "admin/index";
	}
	
	
	
}
