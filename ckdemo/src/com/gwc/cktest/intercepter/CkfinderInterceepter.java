package com.gwc.cktest.intercepter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
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
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView model)
			throws Exception {
		logger.info("==========走到了 postHandle() 方法");
	}
	// 返回值，表示我们是否需要将当前的请求拦截下来
	// 如果返回false，请求将被终止，如果为true，请求将被放行
	// Object arg2 表示的是被拦截的请求的目标对象

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		logger.info("==========走到了 preHandle() 方法"+"==========");
		// request.getRequestDispatcher("/WEB-INF/views/error/noaccess.jsp").forward(request,
		// response);
		HttpSession session = request.getSession();
		//logger.info("========sessionId:"+session.getId());
		Enumeration<?> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			logger.info("==========session中的属性有:" + sessionName + ":"+session.getAttribute(sessionName)+"==========");
		}
		String user = (String) session.getAttribute("CKFinder_UserRole");
		if (StringUtils.isNotEmpty(user)) {
			//if(user.equals("admin")){
				//logger.info("==========user为"+user+"放行==========");
				return true;
			//}
		}
		//logger.info("==========user为"+user+"进行拦截==========");
		logger.info("==========session中没有CKFinder_UserRole进行拦截==========");
		return false;
	}

}
