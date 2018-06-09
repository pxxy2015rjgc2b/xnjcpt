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
<title>设置警报</title>
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
			<div class="show_box" id="show_box">
				<div class="show_content">
					<div>
						<h3>设置警报</h3>
					</div>
					<div id="searchContent">
						<button class="btn btn-primary" onclick="createAlarm()">
							<i class="fa fa-plus"></i>添加警报
						</button>
						<input oninput="changeQuery()" id="searchContentSort" style="width: 250px; float: right;" type="text"
							class="form-control" placeholder="请输入搜索内容">
					</div>
					<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
						<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
					</div>
					<div id="showContent" style="margin-top: 20px; display: none;">
						<table class="table table-hover" style="text-align: center;">
							<thead>
								<tr>
									<td>主机ip</td>
									<td><select onchange="changeQuery()" id="searchType" class="form-control"
										style="width: 200px; margin: 0 auto;">
											<option value="">警报类型</option>
											<option value="CPU利用率">CPU利用率</option>
											<option value="内存利用率">内存利用率</option>
											<option value="出带宽">出带宽</option>
											<option value="入带宽">入带宽</option>
											<option value="出包量">出包量</option>
											<option value="入包量">入包量</option>
									</select></td>
									<td>警报阈值</td>
									<td>警报状态</td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody>
								<template v-for="alarm in alarmVO.list">
								<tr>
									<td>{{ alarm.computer_ip }}</td>
									<td>{{ alarm.alarm_type }}</td>
									<td>{{ alarm.alarm_value }}</td>
									<td><template v-if="alarm.alarm_state == '0'">未启用</template>
										<template v-else>启用中</template></td>
									<td><button onclick="updateAlarm(this)" style="margin-right: 10px;"
											:id="alarm.alarm_id" class="btn btn-primary">修改</button>
										<button onclick="deleteAlarm(this)" :id="alarm.alarm_id" class="btn btn-danger">删除</button></td>
								</tr>
								</template>
							</tbody>
						</table>
					</div>
					<div id="bottomPage" style="padding: 20px;">
						<span>当前页数:<span id="currPage">{{ alarmVO.currPage
								}}</span></span> <span>共:<span id="totalPage">{{
								alarmVO.totalPage }}</span>页
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
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/alarm/createAlarm.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/alarm/showAlarm.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/alarm/managerAlarm.js"></script>
</body>
</html>