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
	.updateStatus,.pageOperation{
		cursor: pointer;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>警报通知</title>
</head>
<body>
	<div class="wrapper">
		<!--导航条放在下面-->
		<s:action name="skip_intoNavbar" namespace="/skip"
			executeResult="true"></s:action>
		<div class="manage" style="margin-top: 90px;">
			<!--侧边栏放在下面-->
			<div class="" id="show_box">
				<div class="show_content" id="allContent">
					<div class="show_title">
						<span>警报通知</span>
					</div>
					<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
						<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
					</div>
					<div id="showContent" style="margin-top: 20px;">
						<table class="table table-hover" style="text-align: center;">
							<thead>
								<tr>
									<td>通知内容</td>
									<td>通知时间</td>
									<td>通知状态</td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody>
								<template v-for="alarmMessage in alarmMessagePageVO.list">
									<tr>
										<td>{{ alarmMessage.message_info }}</td>
										<td>{{ alarmMessage.message_gmt_create }}</td>
										<td class="updateStatus">
											<template v-if="alarmMessage.message_status=='0'">
												<img src="<%=basePath %>img/envelope.png" :id="alarmMessage.message_id" onclick="updateStatus(this)"/>
											</template>
											<template v-else>
												<img src="<%=basePath %>img/openEnvelope.png"/>
											</template>
										</td>
										<td><button class="btn btn-danger" :id="alarmMessage.message_id" onclick="deleteMessage(this)">删除</button></td>
									</tr>
								</template>
							</tbody>
						</table>
					</div>
					<div id="bottomPage" style="padding: 20px;">
						<span>当前页数:<span id="currPage">{{ alarmMessagePageVO.currPage
								}}</span></span> <span>共:<span id="totalPage">{{
								alarmMessagePageVO.totalPage }}</span>页
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
	<script type="text/javascript" src="<%=basePath %>js/alarmMessage/alarmMessage.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/alarmMessage/managerMessage.js"></script>
</body>
</html>