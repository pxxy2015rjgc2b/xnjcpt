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
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath%>css/alarm/List.css" />
		<link rel="stylesheet" href="<%=basePath%>css/confirm_style.css" />
		
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
					<div class="show_content">
					<div class="show_title">
						<span>设置警报</span>
					</div>
					<div class="operation_button">
						<button class="btn btn-primary add_button" type="submit" onclick="add_alarm()"><i class="fa fa-plus" aria-hidden="true"> </i> 添加警报</button>
						<button class="btn btn-danger delete_button" type="submit"><i class="fa fa-trash-o" aria-hidden="true"></i> 删除警报</button>
						<div class="search_cloud">
							<input class="search_input" type="text" placeholder="搜索云主机名或IP地址" />
						</div>
					</div>
					<div class="show_content1">
						<table class="table cloudList_tabel">
							<thead>
								<tr>
									<th style="text-align: center;"><input type="checkbox"/></th>
									<th>主机IP</th>
									<th>警报类型</th>
									<th>警报阈值</th>
									<th>警报状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td style="text-align: center;"><input  type="checkbox"/></td>
									<td><a href="overview.html" style="font-size: 14px;">ins-8c0bgo5k（u672au547du540d）</a> </td>
									<td>139.199.82.120 </td>
									<td>2 GB </td>
									<td>4 GB</td>
									<td><i class="fa fa-pencil-square-o" onclick="edit_alarm()" style="margin-left: 7px;" aria-hidden="true"></i></td>
								</tr>
							</tbody>
						</table>
						<div class="pagination">
							<nav aria-label="Page navigation">
								<ul class="pagination pagination-sm">
									<li>
										<a href="#" aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
									<li class="active">
										<a href="#">1</a>
									</li>
									<li>
										<a href="#">2</a>
									</li>
									<li>
										<a href="#">3</a>
									</li>
									<li>
										<a href="#">4</a>
									</li>
									<li>
										<a href="#">5</a>
									</li>
									<li>
										<a href="#" aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
					</div>
			</div>
		</div>
		<script type="text/javascript" src="<%=basePath%>js/alarm/addAlarm.js" ></script>
	</body>

</html>