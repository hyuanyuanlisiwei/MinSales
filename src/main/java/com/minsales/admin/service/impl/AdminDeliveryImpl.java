package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.Delivery;
import com.minsales.admin.dao.AdminDeliveryDao;
import com.minsales.admin.service.AdminDeliveryService;

@Service("adminDeliveryService")
public class AdminDeliveryImpl implements AdminDeliveryService {

	@Autowired
	private AdminDeliveryDao adminDeliveryDao;
	
	
	@Override
	public List<Delivery> query(Delivery delivery) {
		// TODO Auto-generated method stub
		return this.adminDeliveryDao.query(delivery);
	}

	@Override
	public int add(Delivery delivery) {
		// TODO Auto-generated method stub
		return this.adminDeliveryDao.add(delivery);
	}

	@Override
	public int delete(Delivery delivery) {
		// TODO Auto-generated method stub
		return this.adminDeliveryDao.delete(delivery);
	}

	@Override
	public int update(Delivery delivery) {
		// TODO Auto-generated method stub
		return this.adminDeliveryDao.update(delivery);
	}
}
