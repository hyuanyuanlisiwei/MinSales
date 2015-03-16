package com.minsales.base;

public class ExecuteResult<T> {

	//返回码;
	private int code=0;
	//返回数据;
	private T info=null;
	//返回的附加信息;
	private String msg=null;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
