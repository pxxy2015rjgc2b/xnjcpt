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
				<div class="show_content computerList">
					<div>
						<h3>主机管理</h3>
					</div>
					<div id="searchContent">
					    <button class="btn btn-primary add_button" type="submit" onclick="add_computer()"><i class="fa fa-plus" aria-hidden="true"> </i> 添加主机</button>
						<button class="btn btn-danger delete_button" type="submit" onclick="delete_computer()"><i class="fa fa-trash-o" aria-hidden="true"></i> 删除主机</button>
						<div class="search_cloud">
							<input class="search_input" type="text" placeholder="搜索云主机名或IP地址" />
							<a class="search_button" onclick="iquery_computerList()"><img src="<%=basePath %>img/search.png"/></a>
						</div>
					</div>
					<div id="showContent" style="margin-top: 20px;">
						<table class="table table-hover computerList_table" style="text-align: center;">
							<thead>
								<tr>
							        <th><input type="checkbox" style="text-align: center;" onclick="allcheck()" id="checkAll" name="checkAll"/></th>
									<th>IP地址</th>
									<th>CPU型号</th>
									<th>硬盘大小</th>
									<th>内存大小</th>
									<th>状态</th>
									
								</tr>
							</thead>
							<tbody>
							<tr v-for="computer in computers" >
                                  <td><input type="checkbox" :id="computer.computer_id" name="delete_check" onclick="cancle_all()"/></td>
                                  <td style="display:none;" class="computer_id" :id="computer.computer_id"></td>
                                  <td>{{ computer.computer_ip }}</td>
                                  <td>{{ computer.cpu_model}}</td>
                                  <td>{{ computer.disk_size }}</td>
                                  <td>{{ computer.memory_size }}</td>
                                  <td>{{ computer.computer_threshold_value }}</td>
                                  
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
		src="<%=basePath%>js/computer/addComputer.js"></script>
</body>
</html>