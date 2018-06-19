
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
<link rel="stylesheet" href="<%=basePath %>css/toastr.css" />
<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath %>css/navbar/font-awesome.min.css" />
<link rel="stylesheet" href="<%=basePath %>css/register/register.css" />
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
					<span>已有账户？</span> <a href="index.jsp">立即登陆</a>
				</div>
			</div>
			<form id="register" class="register_content">
					<input  class="register_input"  type="text" placeholder="用户名" name="user_username" />
					<input class="register_input"  type="text" placeholder="用户性名" name="user_name" />
					<input class="register_input"  type="text" placeholder="用户手机号码" name="user_phone" />
					<input class="register_input" type="password" placeholder="密码" name="user_password" />
					<input class="register_input" type="password" placeholder="确认密码" name="user_confirmPassword"/>
					<input class="register_input" type="text" placeholder="邮箱地址" name="user_email" />
					<div class="register_button">注册</div>
				</form>
				<div class="font_hintBox">
					<span class="form_spanSucessCheck" name="user_usernameHint">第一位是字母，只有由数字与字母组成，6位</span>
					<span class="form_spanSucessCheck" name="user_nameHint">不能为空</span>
					<span class="form_spanSucessCheck" name="user_phoneHint">手机号码格式不正确</span>
					<span class="form_spanSucessCheck" name="user_passwordHint">密码大于2位小于12位</span>
					<span class="form_spanSucessCheck" name="user_confirmPasswordHint">二次输入不一致</span>
					<span class="form_spanSucessCheck" name="user_emailHint">正确格式为123442@qq.com</span>
					<span class="show_emailA"><a>邮箱格式正确，请点击发送激活链接</a></span>

				</div>
		</div>
		<div class="reg_footer">Copyright @ 2018-2019 PingXiangXueYuan
			All Right Reserve 萍乡学院版权所有</div>
	</div>
	<script type="text/javascript" src="<%=basePath %>/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>/js/toastr.js" ></script>
	<script type="text/javascript" src="<%=basePath %>js/user/register.js"></script>
</body>
</html>