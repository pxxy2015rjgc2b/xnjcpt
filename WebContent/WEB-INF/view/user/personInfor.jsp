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
<link rel="stylesheet" href="<%=basePath%>css/user/user-info.css" />
<link rel="stylesheet" href="<%=basePath%>css/confirm_style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body>
	<div class="wrapper">
		<!--导航条放在下面-->
		<s:action name="skip_intoNavbar" namespace="/skip"
			executeResult="true"></s:action>
		<div class="manage">
			<!--侧边栏放在下面-->
			<div class="show_box" id="user_info">
				<div class="show_content">
				<div class="uesr_infoTitle">帐户信息</div>
						<div class="panel panel-default uesr_info">
							<div class="panel-body">
								<ul >
									<li><label>账号昵称：</label><span>{{ userInfo.user_name }}</span></li>
									<li><label>用户姓名：</label><span class="user_name">{{ userInfo.user_username }}</span><div class="edit_nameBox"><input name="user_username" type="text" /> <a class="user_nameSave" onclick="editName_ajax()">保存</a><a class="user_nameCancle" onclick="user_nameCancle()">取消</a></div><i class="fa fa-pencil editName" onclick="editName()" aria-hidden="true"></i></li>
									<li><label>用户密码：</label><span>{{ userInfo.user_password }}</span><i class="fa fa-pencil editName" onclick="editPassword()" aria-hidden="true"></i></li>
									<li><label>邮箱地址：</label><span>{{ userInfo.user_email }}</span></li>
									<li><label>手机号码：</label><span class="user_photo">{{ userInfo.user_phone }}</span><div class="edit_photoBox"><input name="user_photo" type="text" class="editPhoto_input"/><a onclick="editPhoto_ajax()" class="user_photoSave">保存</a><a class="user_photoCancle" onclick="user_photoCancle()">取消</a></div><i class="fa fa-pencil editPhoto"  onclick="editPhoto()" aria-hidden="true"></i></li>
									<li><label>用户状态：</label><span>{{ userInfo.user_status }}</span></li>
									<li><label>用户角色：</label><span>{{ userInfo.user_role }}</span></li>
								</ul>
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=basePath %>/js/toastr.js"></script>
	<script src="<%=basePath %>/js/user/user-info.js"></script>
	
</body>
</html>