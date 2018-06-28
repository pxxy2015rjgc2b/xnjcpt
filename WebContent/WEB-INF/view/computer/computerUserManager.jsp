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
<link rel="stylesheet" href="<%=basePath%>css/alarm/cloudList.css" />
<style type="text/css">
	.pageOperation:hover{
		cursor: pointer;
	}
</style>
<title>云主机申请管理</title>
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
			<div class="show_box" id="computerManangerVue">
				<div class="show_content">
					<div class="show_title">
						<span>云主机申请管理</span>
					</div>
					<div class="operation_button">
						<div class="search_cloud">
							<input class="search_input" id="searchContentSort" type="text"
								placeholder="可搜索用户账号、用户名、ip地址" oninput="changeQuery()"/> <a class="search_button"><img
								src="<%=basePath%>img/search.png" /></a>
						</div>
					</div>
					<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
						<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
					</div>
					<div id="showTable" style="margin-top: 20px; display:none;">
						<table class="table table-hover" style="text-align: center;">
							<thead>
								<tr>
									<td>用户名</td>
									<td>用户账号</td>
									<td>主机ip</td>
									<td style="width:170px;"><select id="computer_status" onchange="changeQuery()" class="form-control" style="width: 150px;">
										<option value="">主机状态</option>
										<option value="use">已安装客户端</option>
										<option value="noUse">未安装客户端</option>
									</select></td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody>
								<template v-for="computer in computerManangerVO.list">
									<tr>
										<td>{{ computer.computer_user }}</td>
										<td>{{ computer.computer_username }}</td>
										<td>{{ computer.computer_ip }}</td>
										<td>
											<template v-if="computer.computer_status == 'noUse'">
												未安装客户端
											</template>
											<template v-else>
												已安装客户端
											</template>
										</td>
										<td>
											<button :id="computer.computer_id" class="btn btn-danger" onclick="deleteComputer(this)">删除</button>
										</td>
									</tr>
								</template>
							</tbody>
						</table>
					</div>
					<div class="page-footer" style="margin-top: 40px;">
							<div class="page_info" style="text-align: center;">
								&nbsp;&nbsp;&nbsp;&nbsp; <a onclick="skipToIndexPage()"><i
									class="fa fa-angle-double-left">首页</i></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="skipToPrimaryPage()"><i class="fa fa-angle-left"></i>上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="skipToNextPage()">下一页<i class="fa fa-angle-right"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<a onclick="lastPage()">尾页<i
									class="fa fa-angle-double-right"></i></a>&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="text" style="width: 50px; text-indent: 10px" id="skipPage" />&nbsp;&nbsp;&nbsp;&nbsp;
								<a  onclick="skipToArbitrarilyPage()">GO</a>
							</div>
							<div class="footer_info" style="text-align: center;">
								<span>当前第{{ computerManangerVO.currPage }}页</span><span>共{{ computerManangerVO.totalPage }}页</span>
							</div>
							<p class='page-infomation'></p>
						</div>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath %>js/computer/showComputerManager.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/computer/managerComputer.js"></script>
</body>
</html>