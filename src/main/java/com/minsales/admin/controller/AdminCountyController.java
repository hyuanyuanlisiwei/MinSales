package com.minsales.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minsales.admin.bean.City;
import com.minsales.admin.bean.County;
import com.minsales.admin.bean.Province;
import com.minsales.admin.service.AdminCityService;
import com.minsales.admin.service.AdminCountyService;
import com.minsales.admin.service.AdminProvinceService;
import com.minsales.base.BaseController;
import com.minsales.base.ExecuteResult;
import com.minsales.base.Pagination;
import com.minsales.base.ResultCode;

import java.util.*;
@Controller
@RequestMapping("/AdminCountyController")
public class AdminCountyController extends BaseController {

	@Autowired
	private AdminCountyService adminCountyService;
	@Autowired
	private AdminCityService adminCityService;
	@Autowired
	private AdminProvinceService adminProvinceService;
	
	
	
	//get all province initial
	@RequestMapping("/queryAllProvince.do")
	@ResponseBody
	public List<Province> queryAllProvince()
	{
		List<Province> list=this.adminProvinceService.queryAll();
		Province p=new Province();
		p.setId(0);
		p.setName("全部...");
		list.add(0, p);
		return list;
	}
	
	//query all city by provinceId;
	@RequestMapping("/queryAllCityByProvince.do")
	@ResponseBody
	public List<City> queryAllCityByProvince(int id)
	{
		City city=new City();
		city.setParentId(id);
		List<City> list=this.adminCityService.queryAll(city);
		City c=new City();
		c.setId(0);
		c.setName("全部...");
		list.add(0, c);
		return list;
	}
	
	
	//datagrid pagination :total,rows;
	@RequestMapping("/query.do")
	public String query(County county,ModelMap map)
	{
		//total;
		int total=this.adminCountyService.queryCount(county);
		//rows
		Pagination pagination=new Pagination(county.getPage(),county.getRows());
		//current page data;
		county.setFrom(pagination.getFormIndex());
		county.setSize(pagination.getSize());
		
		List<County> rows=this.adminCountyService.query(county);
		//return data;
		map.put("total", total);
		map.put("rows", rows);
		
		return "json";
	}
	
	// insert
	@RequestMapping("/add.do")
	@ResponseBody
	public ExecuteResult<String> add(County c) {
		// 1,prepare result
		ExecuteResult<String> result = new ExecuteResult<String>();
		// 2,execute add
		int count = this.adminCountyService.add(c);
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
	public ExecuteResult<String> delete(County county) {
		// 1,prepare result
		ExecuteResult<String> result = new ExecuteResult<String>();
		// 2,execute delete
		int count = this.adminCountyService.delete(county);
		// 3,get result
		result.setInfo("删了" + count + "行!");
		if (count > 0) {
			result.setCode(ResultCode.SUCCESS.code);
			result.setMsg("删除成功!");
		} else {
			result.setCode(ResultCode.FAIL.code);
			result.setMsg("删除失败!");
		}
		return result;
	}

	@RequestMapping("/update.do")
	@ResponseBody
	public ExecuteResult<String> update(County county) {
		// 1,prepare result
		ExecuteResult<String> result = new ExecuteResult<String>();
		// 2,execute delete
		int count = this.adminCountyService.update(county);
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
