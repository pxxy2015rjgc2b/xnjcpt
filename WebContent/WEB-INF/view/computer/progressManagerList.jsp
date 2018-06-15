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
	.pageOperation{
		cursor: pointer;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>进程管理</title>
</head>
<body>
	<div class="wrapper">
		<!--导航条放在下面-->
		<s:action name="skip_intoNavbar" namespace="/skip"
			executeResult="true"></s:action>
		<div class="manage">
			<!--侧边栏放在下面-->
			<s:action name="skip_intoSilderForComputer" namespace="/skip"
				executeResult="true"></s:action>
			<div class="show_box">
				<div class="show_content" id="allContent">
					<div class="show_title">
						<span>进程管理</span>
					</div>
					<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
						<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
					</div>
					<div id="showContent" style="margin-top: 20px;">
						<table class="table table-hover" style="text-align: center;">
							<tr>
								<td>pid</td>
								<td>进程名</td>
								<td>操作</td>
							</tr>
							<template v-for="progress in progressPageVO.list">
								<tr>
									<td>{{ progress.progress_pid }}</td>
									<td>{{ progress.progress_name }}</td>
									<td><button class="btn btn-danger" :id=" progress.progress_pid" onclick="clossProgress(this)">关闭</button></td>
								</tr>
							</template>
						</table>
					</div>
					<div id="bottomPage" style="padding: 20px;">
						<span>当前页数:<span id="currPage">{{ progressPageVO.currPage }}</span></span> <span>共:<span
							id="totalPage">{{ progressPageVO.totalPage }}</span>页
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
	<script type="text/javascript" src="<%=basePath %>js/progress/showProgress.js"></script>
</body>
</html>