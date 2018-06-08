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
<title>首页</title>
<link rel="stylesheet" href="<%=basePath%>css/index/index.css" />
<link rel="stylesheet" href="<%=basePath%>css/index/footer.css" />
<link rel="stylesheet" href="<%=basePath%>css/index/header.css" />
</head>
<body>
<div class="wrapper">
			<div class="header_box">
				<div class="header_content">
					<div class="header_left">
						<img class="logo" src="<%=basePath %>img/logo.png">
						<span>云栖</span>
					</div>
					<div class="header_right">
						<img class="search" src="<%=basePath %>img/search.png" />
						<a>注册</a>
						<img class="user" src="<%=basePath %>img/user.png" />
					</div>
					<div>
						<ul class="user_info">
							<img src="<%=basePath %>img/triangle.png" />
							<li><span>用户名</span></li>
							<li><span>账户信息</span></li>
							<li><span>退出</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="center_box">
				<div class="center_content">
					<div class="center_word">
					    <div >“云栖”应用云平台</div>
				     	<div>的性能监控与应用管理系统</div>
				     	<div class="enter_button"><a>立即监测</a></div>
				  	</div>
				  	<form id="login_box" class="login_box">
				  		<div class="login_content">
				  		  <div class="login_title">登陆</div>
				  		  <input class="usename" type="text" placeholder="邮箱/用户名" name="user.user_username"/>
				  	      <input class="password" type="password" placeholder="登录密码" name="user.user_password"/>
				 		  <div class="login_button">登录</div>
				 		  <a>免费注册</a>
				 		  <a>忘记密码</a>
				 		</div>
				  	</form>
				</div>
			</div>
			<div class="footer">
				<div class="footer_content">
				  <span>Copyright @ 2018-2019 PingXiangXueYuan All Right Reserve</span>
			      <span>萍乡学院版权所有</span>
			    </div>
			</div>
		</div>
</body>
</html>