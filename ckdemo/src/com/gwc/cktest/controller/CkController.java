package com.gwc.cktest.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gwc.cktest.intercepter.CkfinderInterceepter;

@Controller
public class CkController {
	private static final Log logger = LogFactory.getLog(CkfinderInterceepter.class);

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView ckIndex(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "Hello CKEditor");
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/admin.html", method = RequestMethod.POST)
	@ResponseBody
	public String ckAdmin(HttpServletRequest request, String userId) {
		logger.info("==========" + userId + "登陆了" + "==========");
		/*
		 * String path =
		 * request.getSession().getServletContext().getRealPath("/WEB-INF");
		 * path += "/ckfinder.xml";
		 */
		// 让浏览服务器可用，直接通过url也可用
		HttpSession session=request.getSession();
		if (userId.equals("admin")) {
			session.setAttribute("CKFinder_UserRole", "admin");
		} else {
			session.setAttribute("CKFinder_UserRole", "user");
		}
		logger.info("========sessionId:"+session.getId());
		// 将路径设置为自己的
		// CkFinderUtil.setUserDir(path, userId);
		logger.info("==========" + "session 设置成功" + "==========");
		Enumeration<?> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			logger.info("==========存在的session有：" + sessionName + ":"+session.getAttribute(sessionName)+"==========");
		}
		return "session 设置成功";

	}

	@RequestMapping(value = "/logout.html", method = RequestMethod.POST)
	@ResponseBody
	public String ckLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Enumeration<?> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String sessionName = (String) e.nextElement();
			logger.info("==========存在的session有：" + sessionName + ":"+session.getAttribute(sessionName)+"==========");
			session.removeAttribute(sessionName);
		}
		logger.info("==========" + "session 移除成功" + "==========");
		return "session 移除成功";
	}
}
