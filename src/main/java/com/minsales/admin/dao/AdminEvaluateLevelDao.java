package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;
import com.minsales.admin.bean.*;
import java.util.*;

@Repository("adminEvaluateLevelDao")
public interface AdminEvaluateLevelDao {

	//查询
	public List<EvaluateLevel> query(EvaluateLevel evalateLevel);
	//增加
	public int add(EvaluateLevel evalateLevel);
	//修改
	public int update(EvaluateLevel evalateLevel);
	//删除
	public int delete(EvaluateLevel evalateLevel);
	
}
