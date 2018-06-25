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
<title>性能监测</title>
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
							<span>性能监测</span>
						</div>
						<label>选择展示时间区间：</label>
						<button class="btn btn-default" onclick="today()">今日</button>
						<button class="btn btn-default" style="margin-left: 20px;"
							onclick="sevenDay()">七日内</button>
					</div>
					<div id="cpu">
						<h3>CPU相关性能</h3>
						<hr>
						<div style="height: 400px; width: 100%">
							<div style="float: left;">
								<div id="userLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="cpuUser" style="width: 500px; height: 400px; display:none;"></div>
							</div>
							<div style="float: right;">
								<div id="systemLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="cpuSystem" style="width: 500px; height: 400px; display:none;"></div>
							</div>
						</div>
						<div style="height: 400px; width: 100%">
							<div style="float: left;">
								<div id="idleLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="cpuIdle" style="width: 500px; height: 400px; display:none;"></div>
							</div>
							<div style="float: right">
								<div id="ioWaitLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="cpuIowait" style="width: 500px; height: 400px; display:none;"></div>
							</div>
						</div>
					</div>
					<!-- 内存相关性能 -->
					<div id="memory">
						<h3>内存相关性能</h3>
						<hr>
						<div style="height: 400px; width: 100%">
							<div style="float: left;">
								<div id="memoryLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="memoryState" style="width: 500px; height: 400px; display:none;"></div>
							</div>
						</div>
					</div>
					<!-- 网络相关性能  -->
					<div id="net">
						<h3>网络相关性能</h3>
						<hr>
						<div style="height: 400px; width: 100%">
							<div style="float: left;">
								<div id="outLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="OutBandwidth"
									style="width: 500px; height: 400px; display: none;"></div>
							</div>
							<div style="float: right;">
								<div id="inLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="InBandwidth" style="width: 500px; height: 400px; display:none;"></div>
							</div>
						</div>
						<div style="height: 400px; width: 100%">
							<div style="float: left;">
								<div id="outPackageLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="OutPackage" style="width: 500px; height: 400px; display:none;"></div>
							</div>
							<div style="float: right;">
								<div id="inPackageLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="InPackage" style="width: 500px; height: 400px; display:none;"></div>
							</div>
						</div>
						<div style="height: 400px; width: 100%">
							<div style="float: left;">
								<div id="tcpLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="TcpNumber" style="width: 500px; height: 400px; display:none;"></div>
							</div>
							<div style="float: right;">
								<div id="trafficLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="OutTraffic" style="width: 500px; height: 400px; display:none;"></div>
							</div>
						</div>
					</div>
					<!--磁盘相关性能-->
					<div>
						<h3>磁盘相关性能</h3>
						<hr>
						<div style="height: 400px; width: 100%">
							<div style="float: left;">
								<div id="diskLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="DiskSize" style="width: 500px; height: 400px; display:none;"></div>
							</div>
							<div style="float: right;">
								<div id="ioLoading" style="margin: 150px auto; width: 45px;">
									<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i>
								</div>
								<div id="IoUtil" style="width: 500px; height: 400px; display:none;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=basePath%>js/monitor/CpuUserInfor.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/CpuSystemInfor.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/CpuIdleInfor.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/CpuIowaitInfor.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/MemoryStateInfor.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/OutBandwidth.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/InBandwidth.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/OutPackage.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/InPackage.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/OutTraffic.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/TcpNumber.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/DiskSize.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/monitor/IoUtil.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/monitor/loadingData.js"></script>
</body>
</html>