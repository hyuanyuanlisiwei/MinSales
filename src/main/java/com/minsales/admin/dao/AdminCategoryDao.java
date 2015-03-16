package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;
import com.minsales.admin.bean.*;
import java.util.*;

@Repository("adminCategoryDao")
public interface AdminCategoryDao {

	//查询
	public List<Category> query(Category category);
	//增加
	public int add(Category category);
	//修改
	public int update(Category category);
	//删除
	public int delete(Category category);
	
}
