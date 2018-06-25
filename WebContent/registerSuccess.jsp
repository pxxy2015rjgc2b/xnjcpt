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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- Bootstrap -->
<link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>/css/navbar/font-awesome.css" rel="stylesheet">
<link href="<%=basePath%>/css/bootstrap-theme.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>/css/animations.css">
<!-- siimple style -->
<link href="<%=basePath%>/css/style.css" rel="stylesheet">
<title>激活成功</title>
</head>
<body>
	<div class="cloud floating">
		<img src="<%=basePath%>/img/cloud.png" alt="Scoop Themes">
	</div>

	<div class="cloud pos1 fliped floating">
		<img src="<%=basePath%>/img/cloud.png" alt="Scoop Themes">
	</div>

	<div class="cloud pos2 floating">
		<img src="<%=basePath%>/img/cloud.png" alt="Scoop Themes">
	</div>

	<div class="cloud pos3 fliped floating">
		<img src="<%=basePath%>/img/cloud.png" alt="Scoop Themes">
	</div>


	<div id="wrapper">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12 col-lg-12">
					<img src="<%=basePath%>/img/logoRegister.png"
						alt="Scoop Themes Logo"> <br /> <br />
					<h2 class="subtitle">您已经激活用户，请返回注册界面完成注册</h2>
					<br />

						<div class="form-group">
<!-- 							<input type="email" class="form-control" name="EMAIL"
								id="exampleInputEmail1" placeholder="请输入您的问题"> -->
						</div>
						<a href="<%=basePath %>index.jsp"><input type="submit" name="subscribe" value="前去登陆"
							class="btn btn-theme"></a>
					<br />
				</div>
				<div class="col-sm-12 align-center">
					<ul class="social-network social-circle">
	<!-- 						<li><a href="#" class="icoFacebook" title="Facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="icoTwitter" title="Twitter"><i
									class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="icoGit" title="Github"><i
									class="fa fa-github"></i></a></li>
							<li><a href="#" class="icoLinkedin" title="Linkedin"><i
									class="fa fa-linkedin"></i></a></li> -->
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<p class="copyright">Copyright @ 2018-2019 PingXiangXueYuan All
						Right Reserve 萍乡学院版权所有</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>