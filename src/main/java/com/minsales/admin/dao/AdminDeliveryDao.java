package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;
import com.minsales.admin.bean.*;
import java.util.*;

@Repository("adminDeliveryDao")
public interface AdminDeliveryDao {

	//查询
	public List<Delivery> query(Delivery delivery);
	//增加
	public int add(Delivery delivery);
	//修改
	public int update(Delivery delivery);
	//删除
	public int delete(Delivery delivery);
	
}
