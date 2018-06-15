<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/slider/sideNav.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="side_navBox">
		<div class="side_navTitle">主机管理</div>
		<ul class="side_nav">
			<li><a href="process_management.html">进程管理</a></li>
			<li><a href="teleControl.html">远程控制</a></li>
		</ul>
	</div>
</body>
</html>