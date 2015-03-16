package com.minsales.base;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {

	//web的三个关键对象
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	
	//日志controller
	protected Logger logger=LoggerFactory.getLogger("controller");
	
	
	/**
	 * 1)放置在方法的形参上：表示引用Model中的数据
	 * 2)放置在方法上面：表示请求该类的每个Action前都会首先执行它，也可以将一些准备数据的操作放置在该方法里面。 
	 * @param request
	 * @param response
	 * @param session
	 */
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		this.request = request;
		this.response = response;
		this.session = session;
		
	}

	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
}
