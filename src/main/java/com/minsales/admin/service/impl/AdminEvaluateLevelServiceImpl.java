package com.minsales.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsales.admin.bean.EvaluateLevel;
import com.minsales.admin.dao.AdminEvaluateLevelDao;
import com.minsales.admin.service.AdminEvaluateLevalService;

@Service("adminEvaluateLevelService")
public class AdminEvaluateLevelServiceImpl implements AdminEvaluateLevalService {

	@Autowired
	private AdminEvaluateLevelDao adminEvaluateLevelDao;
	
	
	@Override
	public List<EvaluateLevel> query(EvaluateLevel evalateLevel) {
		// TODO Auto-generated method stub
		return this.adminEvaluateLevelDao.query(evalateLevel);
	}

	@Override
	public int add(EvaluateLevel evalateLevel) {
		// TODO Auto-generated method stub
		return this.adminEvaluateLevelDao.add(evalateLevel);
	}

	@Override
	public int delete(EvaluateLevel evalateLevel) {
		// TODO Auto-generated method stub
		return this.adminEvaluateLevelDao.delete(evalateLevel);
	}

	@Override
	public int update(EvaluateLevel evalateLevel) {
		// TODO Auto-generated method stub
		return this.adminEvaluateLevelDao.update(evalateLevel);
	}
}
