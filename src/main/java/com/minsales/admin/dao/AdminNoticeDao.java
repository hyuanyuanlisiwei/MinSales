package com.minsales.admin.dao;

import org.springframework.stereotype.Repository;
import com.minsales.admin.bean.*;
import java.util.*;

@Repository("adminNoticeDao")
public interface AdminNoticeDao {

	//queryAll;
	public List<Notice> queryAll();
	//查询
	public List<Notice> query(Notice notice);
	//增加
	public int add(Notice notice);
	//修改
	public int update(Notice notice);
	//删除
	public int delete(Notice notice);
	
}
