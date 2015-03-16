package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.Delivery;

public interface AdminDeliveryService {

	//query
	public List<Delivery> query(Delivery delivery);
	//add
	public int add(Delivery delivery);
	//delete
	public int delete(Delivery delivery);
	//update
	public int update(Delivery delivery);
	
	
}
