package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.Admin;
import com.minsales.admin.bean.Notice;
import com.minsales.admin.dao.AdminNoticeDao;
import com.minsales.admin.service.AdminLoginService;
import com.minsales.admin.service.AdminNoticeService;

@Service("adminNoticeService")
public class AdminNoticeServiceImpl implements AdminNoticeService {

	@Autowired
	private AdminNoticeDao adminProvinceDao;

	@Override
	public List<Notice> query(Notice notice) {
		// TODO Auto-generated method stub
		return this.adminProvinceDao.query(notice);
	}

	@Override
	public int add(Notice notice) {
		// TODO Auto-generated method stub
		return this.adminProvinceDao.add(notice);
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return this.adminProvinceDao.update(notice);
	}

	@Override
	public int delete(Notice notice) {
		// TODO Auto-generated method stub
		return this.adminProvinceDao.delete(notice);
	}

	@Override
	public List<Notice> queryAll() {
		// TODO Auto-generated method stub
		return this.adminProvinceDao.queryAll();
	}
	
	

}
