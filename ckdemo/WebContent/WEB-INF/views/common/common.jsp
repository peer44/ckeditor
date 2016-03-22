<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<c:set var="base" value="<%=basePath%>" scope="application"></c:set>

<!-- 引入jquery -->
<script type="text/javascript" src="${base }/assets/js/jquery.min.js"></script>

<!-- 引入ckeditor.js和ckfinder.js -->
<script type="text/javascript" src="${base }/assets/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${base }/assets/ckfinder/ckfinder.js"></script>

