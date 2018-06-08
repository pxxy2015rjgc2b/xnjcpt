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
<link rel="stylesheet" href="<%=basePath%>css/alarm/cloudList.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主机管理</title>
</head>
<body>
	<div class="wrapper">
		<!--导航条放在下面-->
		<s:action name="skip_intoNavbar" namespace="/skip"
			executeResult="true"></s:action>
		<div class="manage">
			<!--侧边栏放在下面-->
			<s:action name="skip_intoSlider" namespace="/skip"
				executeResult="true"></s:action>
			<div class="show_box">
				<div class="show_content">
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>