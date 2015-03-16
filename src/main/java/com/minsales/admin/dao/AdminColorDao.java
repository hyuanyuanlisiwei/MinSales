package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;
import com.minsales.admin.bean.*;
import java.util.*;

@Repository("adminColorDao")
public interface AdminColorDao {

	//查询
	public List<Color> query(Color color);
	//增加
	public int add(Color color);
	//修改
	public int update(Color color);
	//删除
	public int delete(Color color);
	
}
