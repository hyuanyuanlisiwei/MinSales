package com.minsales.base;
import java.util.*;
public class Pagination {

	//默认页面大小
	private final static int PAGE_SIZE=3;
	
	//传入的当前页;
	private int nowPage;
	//每页显示的条数；
	private int pageSize;
	
	
	//总页数;
	private int total;
	//当前页显示的数据;
	List rows;
	
	//查询数据库所需的条件;
	private int formIndex;//开始索引
	private int size;//当前页显示的条数;
	
	
	public Pagination(Integer nowPage,Integer pageSize)
	{
		//注意 datagrid reload nowPage=0
		if(nowPage==0)
		{
			this.nowPage=1;
		}else
		{
			this.nowPage=nowPage;
		}
		if(pageSize==0)
		{
			pageSize=PAGE_SIZE;
		}else
		{
			this.pageSize=pageSize;
		}
		//计算开始的记录数和结束的记录数;
		this.formIndex=(this.nowPage-1)*this.pageSize;
		this.size=this.pageSize;
	}
	//------------------------------------


	public int getNowPage() {
		return nowPage;
	}


	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public List getRows() {
		return rows;
	}


	public void setRows(List rows) {
		this.rows = rows;
	}


	public int getFormIndex() {
		return formIndex;
	}


	public void setFormIndex(int formIndex) {
		this.formIndex = formIndex;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
}
