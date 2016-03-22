package com.gwc.cktest.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CkfinderInterceepter implements HandlerInterceptor {
	private static final Log logger = LogFactory.getLog(CkfinderInterceepter.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		logger.info("==========走到了 afterCompletion() 方法");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		logger.info("==========走到了 postHandle() 方法");
	}
	// 返回值，表示我们是否需要将当前的请求拦截下来
	// 如果返回false，请求将被终止，如果为true，请求将被放行
	// Object arg2
	
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		logger.info("==========走到了 preHandle() 方法");
		return false;
	}

}
