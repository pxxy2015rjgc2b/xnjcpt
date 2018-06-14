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
<link rel="stylesheet" href="<%=basePath%>css/slider/sideNav.css" />
<script type="text/javascript"
	src="<%=basePath%>js/monitor/fomaterData.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="side_navBox">
		<div class="side_navTitle">主机监控</div>
		<ul class="side_nav">
			<li><a href="<%=basePath%>skip/skip_intoMonitor" id="monitor_a">性能监测</a></li>
			<li><a href="<%=basePath%>skip/skip_intoProgress"
				id="progress_a">进程管理</a></li>
			<li><a href="<%=basePath%>skip/skip_intoControl" id="control_a">远程控制</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			var id = getId();
			document.getElementById("monitor_a").href = document
					.getElementById("monitor_a").href
					+ "?computer_id=" + id;
			document.getElementById("progress_a").href = document
					.getElementById("progress_a").href
					+ "?computer_id=" + id;
			document.getElementById("control_a").href = document
					.getElementById("control_a").href
					+ "?computer_id=" + id;
		})
	</script>

</body>
</html>