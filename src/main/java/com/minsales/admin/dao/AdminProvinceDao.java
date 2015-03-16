package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;
import com.minsales.admin.bean.*;
import java.util.*;

@Repository("adminProvinceDao")
public interface AdminProvinceDao {

	//queryAll;
	public List<Province> queryAll();
	//查询
	public List<Province> query(Province pro);
	//增加
	public int add(Province pro);
	//修改
	public int update(Province pro);
	//删除
	public int delete(Province pro);
	
}
