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
<title>数据库性能</title>
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
				<div class="show_content">
					<!-- CPU相关性能 -->
					<div id="head">
						<div class="show_title">
							<span>数据库数据指标</span>
						</div>
						<label>选择展示时间区间：</label>
						<button class="btn btn-default" onclick="today()">今日</button>
						<button class="btn btn-default" style="margin-left: 20px;"
							onclick="sevenDay()">七日内</button>
					</div>
					<div id="cpu">
						<hr>
						<div style="height: 400px; width: 100%">
							<div style="float: left;">
								<div id="dps" style="width: 500px; height: 400px;"></div>
							</div>
							<div style="float: right;">
								<div id="tps" style="width: 500px; height: 400px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="<%=basePath %>js/monitor/fomaterData.js"></script>
<script type="text/javascript" src="<%=basePath %>js/monitor/loadingMysqlData.js"></script>
</body>
</html>