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
<style type="text/css">
.pageOperation {
	cursor: pointer;
}
</style>
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
				<div class="show_content" id="show_content">
					<div class="show_title">
						<span>主机管理</span>
					</div>
					<div id="searchContent">
						<button class="btn btn-primary" onclick="createComputer()">
							<i class="fa fa-plus"></i>申请主机
						</button>
						<input oninput="changeQuery()" id="searchContentSort"
							style="width: 250px; float: right;" type="text"
							class="form-control" placeholder="请输入搜索内容">
					</div>
					<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
						<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
					</div>
					<div id="showContent" style="margin-top: 20px; display: none;">
						<table class="table table-hover" style="text-align: center;">
							<thead>
								<tr>
									<td>ip地址</td>
									<td>cpu型号</td>
									<td>硬盘大小</td>
									<td>内存大小</td>
									<td>状态</td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody>
								<template v-for="computer in computerVO.list">
								<tr>
									<template v-if="computer.computer_status ==  '1'">
									<td><span class="pageOperation" style="color: blue;"
										onclick="intoMonitor(this,'1')" :id="computer.computer_id">{{
											computer.computer_ip }}</span></td>
									<td>{{ computer.computer_cpu_model }}</td>
									<td>{{ computer.computer_disk_size }}</td>
									<td>{{ computer.computer_memory_size }}KB</td>
									</template>
									<template v-else>
									<td><span class="pageOperation" style="color: blue;"
										onclick="intoMonitor(this,'0')" :id="computer.computer_id">{{
											computer.computer_ip }}</span></td>
									<td>暂无</td>
									<td>暂无</td>
									<td>暂无</td>
									</template>
									<td><template v-if="computer.computer_status ==  '0'">未安装客户端</template>
										<template v-else>已安装客户端</template></td>
									<td><button class="btn btn-danger"
											onclick="deleteComputer(this)" :id="computer.computer_id">删除</button></td>
								</tr>
								</template>
							</tbody>
						</table>
					</div>
					<div id="bottomPage" style="padding: 20px;">
						<span>当前页数:<span id="currPage">1</span></span> <span>共:<span
							id="totalPage">1</span>页
						</span> <span onclick="skipToIndexPage()" id="indexPage"
							class="pageOperation">首页</span> <span
							onclick="skipToPrimaryPage()" id="previousPage"
							class="pageOperation">上一页</span> <span onclick="skipToNextPage()"
							id="nextPage" class="pageOperation">下一页</span> <span
							onclick="skipToLastPage()" id="lastPage" class="pageOperation">末页</span>
						<span> <input id="skipPage" type="text"
							style="text-align: center; width: 60px; height: 30px;"
							class="queryInput">
							<button onclick="skipToArbitrarilyPage()" class="btn btn-default"
								style="height: 30px; vertical-align: middle; margin-bottom: 3px;">跳转</button>
						</span>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript"
			src="<%=basePath%>js/computer/createComputer.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/computer/showComputer.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/computer/managerComputer.js"></script>
</body>
</html>