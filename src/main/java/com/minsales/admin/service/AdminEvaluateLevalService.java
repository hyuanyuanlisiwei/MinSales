package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.EvaluateLevel;

public interface AdminEvaluateLevalService {

	//query
	public List<EvaluateLevel> query(EvaluateLevel evalateLevel);
	//add
	public int add(EvaluateLevel evalateLevel);
	//delete
	public int delete(EvaluateLevel evalateLevel);
	//update
	public int update(EvaluateLevel evalateLevel);
	
	
}
