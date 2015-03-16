package com.minsales.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minsales.admin.bean.City;
import com.minsales.admin.bean.Province;
import com.minsales.admin.service.AdminCityService;
import com.minsales.admin.service.AdminProvinceService;
import com.minsales.base.BaseController;
import com.minsales.base.ExecuteResult;
import com.minsales.base.Pagination;
import com.minsales.base.ResultCode;

@Controller
@RequestMapping("/AdminCityController")
public class AdminCityController extends BaseController {

	@Autowired
	public AdminCityService adminCityService;
	@Autowired
	public AdminProvinceService adminProvinceService;
	
	//query all province
	@RequestMapping("/fillCombobox.do")
	@ResponseBody
	public List<Province> queryAll()
	{
		List<Province> list=this.adminProvinceService.queryAll();
		
		Province p=new Province();
		p.setId(0);
		p.setName("全部...");
		list.add(0, p);
		
		return list;
	}
	
	
	//query
	@RequestMapping("/query.do")
	public String query(City city,ModelMap map)
	{
		//pagination;
		Pagination pagination=new Pagination(city.getPage(),city.getRows());
		city.setFrom(pagination.getFormIndex());
		city.setSize(pagination.getSize());
		
		//total;
		int total=this.adminCityService.queryCount(city);
		System.out.println("total:"+total);
		//rows;
		List<City> rows=this.adminCityService.query(city);
		System.out.println("rows:"+rows);
		//return total and rows;
		map.put("total",total);
		map.put("rows",rows);
		
		
		return "json";
	}
	
	//insert
	@RequestMapping("/add.do")
	@ResponseBody
	public ExecuteResult<String> add(City city) {
		// 1,prepare result
		ExecuteResult<String> result = new ExecuteResult<String>();
		// 2,execute add
		int count = this.adminCityService.add(city);
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
	public ExecuteResult<String> delete(City city)
	{
		//1,prepare result
		ExecuteResult<String> result=new ExecuteResult<String>();
		//2,execute delete
		int count=this.adminCityService.delete(city);
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
	public ExecuteResult<String> update(City city) {
		// 1,prepare result
		ExecuteResult<String> result = new ExecuteResult<String>();
		// 2,execute delete
		int count = this.adminCityService.update(city);
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
