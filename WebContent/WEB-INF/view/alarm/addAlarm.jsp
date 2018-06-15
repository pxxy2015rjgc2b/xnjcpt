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
			<div class="show_box">
				<div class="show_content alarmList">
					<div>
						<h3>设置警报</h3>
					</div>
					<div id="searchContent">
						<button class="btn btn-primary" onclick="createAlarm()">
							<i class="fa fa-plus"></i>添加警报
						</button>
						<input style="width: 250px; float: right;" type="text"
							class="form-control" placeholder="请输入搜索内容">
					</div>
					<div id="loadingLayer" style="margin: 0 auto; width: 45px;">
						<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
					</div>
					<div id="showContent" style="margin-top: 20px;">
						<table class="table table-hover alarmList_table" style="text-align: center;">
							<thead>
								<tr>
							        <th><input type="checkbox" style="text-align: center;" name="checkAll"/></th>
									<th>主机ip</th>
									<th>警报类型</th>
									<th>警报阈值</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<tr v-for="alarm in alarms">
                                  <td><input type="checkbox" style="text-align: center;" name="delete_check"/></td>
                                  <td style="display:none;" :id="alarm.alarm_id"></td>
                                  <td>{{ alarm.alarm_computer }}</td>
                                  <td>{{ alarm.alarm_type }}</td>
                                  <td>{{ alarm.alarm_threshold_value }}</td>
                                  <td><i class="fa fa-pencil-square-o" onclick="edit_alarm()" style="margin-left: 7px;" aria-hidden="true"></i></td>
                                 </tr>
							</tbody>
						</table>
					</div>
					<div id="bottomPage" style="padding: 20px;">
						<span>当前页数:<span id="currPage">{{ currPage }}</span></span> <span>共:<span
							id="totalPage">{{ totalPage }}</span>页
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
		src="<%=basePath%>js/alarm/addAlarm.js"></script>
</body>
</html>