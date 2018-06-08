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
	<div class="wrapper">
		<div class="register_logo">
			<img align="top" src="<%=basePath %>img/logo_blue.png" /><span>云栖</span>
		</div>
		<div class="register_box">
			<div class="email_title">
				<i class="fa fa-envelope-o fa-3x" aria-hidden="true"></i> <span>使用邮箱注册</span>
				<div class="title_right">
					<span>已有账户？</span> <a>立即登陆</a>
				</div>
			</div>
			<div class="register_content">
				<input type="text" placeholder="邮箱地址" /> <input type="password"
					placeholder="密码" /> <input type="password" placeholder="确认密码" /> <input
					type="text" placeholder="验证码" style="width: 200px;" />
				<div class="identify_code">获取验证码</div>
				<div class="register_button">注册</div>
			</div>
		</div>
		<div class="reg_footer">Copyright @ 2018-2019 PingXiangXueYuan
			All Right Reserve 萍乡学院版权所有</div>
	</div>
</body>
</html>