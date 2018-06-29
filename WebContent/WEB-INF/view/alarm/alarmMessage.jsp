<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="background:#f5f5f5;">
<head>
<link rel="stylesheet" href="<%=basePath%>css/alarm/cloudList.css" />
<style type="text/css">
.updateStatus, .pageOperation {
	cursor: pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>警报通知</title>
</head>
<body style="background:#f5f5f5;">
	<div class="wrapper" style="background:#f5f5f5;">
		<s:action name="skip_intoNavbar" namespace="/skip"
			executeResult="true"></s:action>
		<div class="manage alarm_manage">
			<div class="show_alarmListBox">
				<div class="show_content alarm_showContent">
					<div class="show_title" style="marign-top:20px;">
						<span>警报通知</span>
					</div>
					<div class="show_content1" >
						<ul id="selectable">
						      <li style="background:#f5f5f5;"><span style="margin-left:10px;">通知内容</span><i style="margin-right: 70px;">通知时间</i></li>
							  <li onclick="updateStatus(this)" v-for="alarmMessage in alarmMessagePageVO.list"><a class="alarm_a">{{ alarmMessage.message_info }}<i
									class="fa fa-times " aria-hidden="true" :id="alarmMessage.message_id" onclick="deleteMessage(this)"></i>
									<h5 v-if="alarmMessage.message_status=='0'" class="word word_warn">未读</h5>
									<h5 v-if="alarmMessage.message_status=='1'" class="word word_success">已读</h5>
									 <i style="margin-right: 10px;">{{ alarmMessage.message_gmt_create }}</i></a>
							  </li>
						</ul>

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
								<span>当前第{{ alarmMessagePageVO.currPage }}页</span><span>共{{ alarmMessagePageVO.totalPage }}页</span>
							</div>
							<p class='page-infomation'></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=basePath%>js/alarmMessage/alarmMessage.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/alarmMessage/managerMessage.js"></script>
</body>
</html>