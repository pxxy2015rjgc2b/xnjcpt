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
<title>Insert title here</title>


<!-- 所有页面共用js -->
<script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/login/loginInterceptor.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap-select.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/icheck.js"></script>
<script type="text/javascript" src="<%=basePath%>js/Input_Select.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-confirm.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.bootstrap.wizard.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.datetimepicker.full.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.multi-select.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/klorofil-common.js"></script>
<script type="text/javascript" src="<%=basePath %>js/toastr.js"></script>
<script type="text/javascript" src="<%=basePath %>js/vue.js"></script>
<!-- 所有页面共用css -->
<link rel="stylesheet" href="<%=basePath %>css/bootstrap-select.min.css">
<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath %>css/jquery-confirm.css">
<link rel="stylesheet" href="<%=basePath %>css/jquery.datetimepicker.css">
<link rel="stylesheet" href="<%=basePath %>css/multi-select.css">
<link rel="stylesheet" href="<%=basePath %>css/toastr.css">
<link rel="stylesheet" href="<%=basePath %>css/chartist-custom.css">
<link rel="stylesheet" href="<%=basePath %>css/navbar/font-awesome.min.css">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<%-- <link rel="stylesheet" href="<%=basePath%>css/main.css"> --%>
<!-- 暂时不知道需不需要 -->
<%-- <link rel="stylesheet" href="<%=basePath%>css/style.css"> --%>
<!-- 暂时不知道需不需要 -->
<!-- 导航专用js -->
<!-- 导航专用css -->
<link rel="stylesheet" href="<%=basePath %>css/navbar/header2.css" />
</head>
<body>
	<div class="header_box">
		<div class="header_left">
			<img class="logo" src="<%=basePath %>img/logo.png">
			<span style="color: white; font-size:26px; vertical-align:middle;"">云栖性能监测平台</span>
		</div>
		<div class="header_center">
			<a>云主机</a> <a>个人信息</a> <a>后台管理</a>
		</div>
		<div class="header_right">
			<a><img class="search" align="absmiddle" src="<%=basePath %>img/search.png" /> <img
				class="user" src="<%=basePath %>img/user.png" align="absmiddle" /></a>
		</div>

	</div>
</body>
</html>