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
<link rel="stylesheet" href="<%=basePath%>css/confirm_style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>
	<div class="wrapper">
		<!--导航条放在下面-->
		<s:action name="skip_intoNavbar" namespace="/skip"
			executeResult="true"></s:action>
		<div class="manage">
			<!--侧边栏放在下面-->
			<s:action name="skip_skipIntoManagerSlider" namespace="/skip"
				executeResult="true"></s:action>
			<div class="show_box" id="userVue">
				<div class="show_content">
					<div class="show_title">
						<span>用户管理</span>
					</div>
					<div class="operation_button">
						<button class="btn btn-primary add_button" onclick="add_user()" type="submit">
							<i class="fa fa-trash-o" aria-hidden="true"></i> 新建用户
						</button>
						<button class="btn btn-danger delete_button" onclick="delete_user()" type="submit">
							<i class="fa fa-trash-o" aria-hidden="true"></i> 删除用户
						</button>
						<div class="search_cloud">
							<input class="search_input" type="text" placeholder="请输入搜索内容" />
							<a class="search_button"><img
								src="<%=basePath%>img/search.png" /></a>
						</div>
					</div>
					<div class="show_content1">
						<table class="table table-striped table-bordered cloudList_tabel">
							<thead>
								<tr id="table_trTh">
									<th style="text-align: center;"><input
										name="delete_checkAll" onclick="allcheck()" id="checkAll"
										type="checkbox" /></th>
									<th>用户名</th>
									<th>用户姓名</th>
									<th>用户邮箱</th>
									<th>手机号码</th>
									<th>用户角色</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr v-for="user in users">
									<td style="text-align: center;"><input name="delete_check"
										:id="user.user_id" onclick="cancle_all()" type="checkbox" /></td>
									<td style="display: none;"><a :id="user.user_id"></a></td>
									<td>{{ user.user_username }}</td>
									<td>{{ user.user_name }}</td>
									<td>{{ user.user_email }}</td>
									<td>{{ user.user_phone }}</td>
									<td v-if="user.user_role==0">普通用户</td>
									<td v-if="user.user_role==1">管理员</td>
									<td v-if="user.user_status==1"><a class="chang_status"
										:id="user.user_id" onClick="cloSure(this)">封禁</a></td>
									<td v-if="user.user_status==0"><a class="chang_status"
										:id="user.user_id" onClick="openSure(this)">解禁</a></td>
								</tr>
							</tbody>
						</table>
						<div class="page-footer">
							<div class="page_info" style="text-align: center;">
								&nbsp;&nbsp;&nbsp;&nbsp; <a onclick="firstPage()"><i
									class="fa fa-angle-double-left">首页</i></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="prePage()"><i class="fa fa-angle-left"></i>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="nextPage()">下一页<i class="fa fa-angle-right"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="lastPage()">尾页<i class="fa fa-angle-double-right"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="text" style="width: 50px;text-indent: 10px" id="goInput" />&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="goPage()">GO</a>
							</div>
							<div class="footer_info">
								<span>当前第{{ currPage }}页</span><span>共{{
									totalPage }}页</span><span>共{{ totalCount }}条记录</span>
							</div>
							<p class='page-infomation'></p>
					</div>
					</div>

				</div>
			</div>
		</div>

	</div>
	<script src="<%=basePath%>js/toastr.js"></script>
	<script src="<%=basePath%>js/user/userList.js"></script>
</body>
</html>