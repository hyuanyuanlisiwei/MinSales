package com.minsales.base;

public enum ResultCode {

	//成功;
	SUCCESS(200),
	//失败;
	FAIL(300);
	
	
	public final int code;
	
	ResultCode(int code)
	{
		this.code=code;
	}
	
}
