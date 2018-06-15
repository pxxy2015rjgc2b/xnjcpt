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
<title>远程控制</title>
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
						<span>远程控制</span>
					</div>
					<div style="width: 800px; margin: 0 auto;">
						<textarea id="terminal" rows="20" cols="125" style="background-color:  black; color: white;"></textarea>
						<button class="btn btn-default" style="float: right;" onclick="cleanContent();">清空</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$('#terminal').val("$：");
	</script>
	<script type="text/javascript" src="<%=basePath %>js/control/sendCommand.js"></script>
</body>
</html>