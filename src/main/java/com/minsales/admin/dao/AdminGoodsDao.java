package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.minsales.admin.bean.*;
@Repository("adminGoodsDao")
public interface AdminGoodsDao {

	public List<Goods> queryByCategoryId(Goods goods);
	
	//分页 当前页的数据rows;
	public List<Goods> query(Goods goods);
	//分页 total
	public int queryCount(Goods goods);
	
	public int add(Goods goods);
	//add imgaddress;
	public int addImgAddress(Goods goods);
	
	public int delete(Goods goods);
	public int update(Goods goods);
	
}
