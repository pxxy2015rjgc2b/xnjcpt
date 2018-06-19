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
<link rel="stylesheet" href="<%=basePath%>css/alarm/List.css" />
<link rel="stylesheet" href="<%=basePath%>css/confirm_style.css" />
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
					    <button class="btn btn-primary add_button" type="submit" onclick="add_alarm()"><i class="fa fa-plus" aria-hidden="true"> </i> 添加警报</button>
						<button class="btn btn-danger delete_button" type="submit" onclick="delete_alarm()"><i class="fa fa-trash-o" aria-hidden="true"></i> 删除警报</button>
						<div class="search_cloud">
							<input class="search_input" type="text" placeholder="搜索云主机名或IP地址" />
							<a class="search_button" onclick="iquery_alarmList()"><img src="<%=basePath %>img/search.png"/></a>
						</div>
					</div>
					<div id="showContent" style="margin-top: 20px;">
						<table class="table table-hover alarmList_table" style="text-align: center;">
							<thead>
								<tr>
							        <th><input type="checkbox" style="text-align: center;" onclick="allcheck()" id="checkAll" name="checkAll"/></th>
									<th>主机ip</th>
									<th>警报类型</th>
									<th>警报阈值</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<tr v-for="alarm in alarms" >
                                  <td><input type="checkbox" :id="alarm.alarm_id" name="delete_check" onclick="cancle_all()"/></td>
                                  <td style="display:none;" class="alarm_id" :id="alarm.alarm_id"></td>
                                  <td>{{ alarm.alarm_computer }}</td>
                                  <td>{{ alarm.alarm_type }}</td>
                                  <td>{{ alarm.alarm_threshold_value }}</td>
                                  <td class="this_td"><i class="fa fa-pencil-square-o edit_alarm"  style="margin-left: 7px;" aria-hidden="true"></i></td>
                                 </tr>
							</tbody>
						</table>
					</div>
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
							<div style="width: 100px;height: 70px;margin: 0px auto;text-align: center;">
								<span>当前第{{ currPage }}页</span><br> <span>共{{
									totalPage }}页</span><br> <span>共{{ totalCount }}条记录</span><br>
							</div>
							<p class='page-infomation'></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/alarm/addAlarm.js"></script>
</body>
</html>