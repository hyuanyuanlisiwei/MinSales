package com.minsales.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.minsales.admin.bean.Province;
import com.minsales.admin.service.AdminProvinceService;
import com.minsales.base.BaseController;
import com.minsales.base.ExecuteResult;
import com.minsales.base.Pagination;
import com.minsales.base.ResultCode;

import java.util.*;


@Controller
@RequestMapping("/AdminProvinceController")
public class AdminProvinceController extends BaseController{

	
	@Autowired
	private AdminProvinceService adminProvinceService;
	
	@RequestMapping("/query.do")
	public String query(ModelMap map,Province province)
	{
		//页面设置;
		Pagination pagination=new Pagination(province.getPage(),province.getRows());
		
		List<Province> list=this.adminProvinceService.query(province);
		
		//返回的总数;
		map.put("total", list.size());
		//返回当前页的数据;
		int from=pagination.getFormIndex();
		int to=pagination.getSize()+from;
		
		if(list.size()<to)
		{
			to=list.size();
		}
		
		List<Province> rows=null;
		rows=list.subList(from, to);
		
		map.put("rows", rows);
		
		return "json";
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public ExecuteResult<String> delete(Province province)
	{
		//1,prepare result
		ExecuteResult<String> result=new ExecuteResult<String>();
		//2,execute delete
		int count=this.adminProvinceService.delete(province);
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
	
	@RequestMapping("/add.do")
	@ResponseBody
	public ExecuteResult<String> add(Province province)
	{
		//1,prepare result
		ExecuteResult<String> result=new ExecuteResult<String>();
		//2,execute add
		int count=this.adminProvinceService.add(province);
		//3,get result;
		result.setInfo("添加了"+count+"行");
		if(count>0)
		{
			result.setCode(ResultCode.SUCCESS.code);
			result.setMsg("添加成功");
			
		}else
		{
			result.setCode(ResultCode.FAIL.code);
			result.setMsg("添加失败");
		}
		return result;
	}
	
	
	@RequestMapping("/update.do")
	@ResponseBody
	public ExecuteResult<String> update(Province province)
	{
		//1,prepare result;
		ExecuteResult<String> result=new ExecuteResult<String>();
		//2,execute update;
		int count=this.adminProvinceService.update(province);
		//3,get result;
		result.setInfo("修改了"+count+"行");
		if(count>0)
		{
			result.setCode(ResultCode.SUCCESS.code);
			result.setMsg("修改成功");
			
		}else
		{
			result.setCode(ResultCode.FAIL.code);
			result.setMsg("修改失败");
		}
		
		return result;
	}
}
