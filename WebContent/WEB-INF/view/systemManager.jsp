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
<script type="text/javascript"
	src="<%=basePath%>js/monitor/fomaterData.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="side_navBox">
		<div class="side_navTitle">后台管理</div>
		<ul class="side_nav">
			<li><a href="/xnjcpt/skip/skip_intoUser">用户管理</a></li>
			<li><a href="/xnjcpt/skip/skip_intoApply">云主机申请管理</a></li>
		</ul>
	</div>
	<script type="text/javascript">
	</script>

</body>
</html>