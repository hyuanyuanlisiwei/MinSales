package com.minsales.admin.service;

import java.util.List;

import com.minsales.admin.bean.Notice;

public interface AdminNoticeService {

	//query All
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
