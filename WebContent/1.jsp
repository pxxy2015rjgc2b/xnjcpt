
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
<title>注册</title>
<link rel="stylesheet" href="<%=basePath %>css/register/register.css" />
<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=basePath %>css/navbar/font-awesome.min.css" />
</head>
<body>
<i class="fa fa-circle-o-notch fa-spin fa-3x fa-fw"></i>
</body>
</html>