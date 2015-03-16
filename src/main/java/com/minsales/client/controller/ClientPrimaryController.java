package com.minsales.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minsales.base.BaseController;


@Controller
@RequestMapping("/ClientPrimaryController")
public class ClientPrimaryController extends BaseController{

	
	// 省份首页
	@RequestMapping("/index.do")
	public String delivery() {
		
		return "client/index";
	}
	
	
	
}
