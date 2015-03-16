package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;

import com.minsales.admin.bean.*;

import java.util.*;
@Repository("adminCountyDao")
public interface AdminCountyDao {

	//根据city_id查询所有的县
	public List<County> queryAll(County county);
	//分页查询所需要的total;
	public int queryCount(County county);
	//分页查询的rows;
	public List<County> query(County county);
	//insert;
	public int add(County county);
	//delete;
	public int delete(County county);
	//update;
	public int update(County county);
	
	
}
