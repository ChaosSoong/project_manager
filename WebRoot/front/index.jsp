<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
 <script type="text/javascript" src="<%=basePath%>/front/front_js/calendar.js" charset="utf-8"></script>
 <script type="text/javascript" src="<%=basePath%>/front/front_js/public.js" charset="utf-8"></script>
 <script type="text/javascript">
 	function quickQuery(){
 		var startDate = document.quickForm.startDate.value;
			if(startDate == null || ""==startDate) {
				alert("请输入预定时间");
				return;
			}
			var days = document.quickForm.days.value;
			if(days == null ||""==days) {
				alert("清填写入住天数");
				return;
			}
			document.quickForm.submit();
 	}
 </script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/front/style.css" media="screen" />
</head>
<body>
<div id="wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1>XX教务管理系统</h1>
		</div>
		<div id="banner"><img src="<%=basePath %>/front/images/img01.jpg" width="667" height="118" alt="" /></div>
	</div>
	<div id="menu" class="container">
		<ul>
			<li class="active"><a href="<%=basePath %>/front/welcome.jsp" target="mainFrame">首页</a></li>
			<li><a href="<%=basePath %>/base/base.do?ACT_ID=noteManager&actionMethod=frontQuery" target="mainFrame">公告</a></li>
			<li><a href="<%=basePath %>/base/base.do?ACT_ID=frontFileQuery" target="mainFrame">公共下载</a></li>
			<li><a href="<%=basePath %>/base/base.do?ACT_ID=BBS&actionMethod=gotoBBS" target="mainFrame">论坛</a></li>
			<li><a href="<%=basePath %>" target="_blank">后台管理</a></li>
		</ul>
	</div>
	<div id="page" class="container">
	
		<div id="content">
				<iframe id="mainFrame" name="mainFrame" frameborder="0" width="100%" height="100%" src="<%=basePath %>/front/welcome.jsp"></iframe>
		</div>
		<div id="sidebar">
			<ul>
				<li>
				<%if(request.getSession().getAttribute("frontUsername") == null) {%>
						<h2>用户登录</h2>
						<form action="<%=basePath %>/base/base.do?ACT_ID=customerLogin" method="post">
							<p>用户类型：
								<select name="frontUserType">
									<option value="3">学生</option>
									<option value="2">教师</option>
									<option value="1">管理员</option>
								</select>
							</p>
							<p>帐&nbsp;&nbsp;&nbsp;&nbsp;号: <input type="text" name="username" required/></p>
							<p>密&nbsp;&nbsp;&nbsp;&nbsp;码: <input type="password" name="password" required/></p>
							<p>
								<input type="submit" value="登录"/>
							</p>
						</form>
					</li>
					<%}else { %>
						<h2>个人信息</h2>
						<p>您的帐户：<%=request.getSession().getAttribute("frontUsername") %></p>
						<p>
							您的类型：
							<%if(request.getSession().getAttribute("frontUserType").equals("3")){ %>
								学生
							<%} else if(request.getSession().getAttribute("frontUserType").equals("2")) {%>
								教师
							<%}else if(request.getSession().getAttribute("frontUserType").equals("1")) {%>
								管理员
							<% }%>
						</p>
						<p>
							<%if(request.getSession().getAttribute("frontUserType").equals("3")) {%> 
								<a href="<%=basePath %>/base/base.do?ACT_ID=customerPwdMdy&actionMethod=findUser" target="mainFrame">修改密码</a>
							<%} %>
							<a href="<%=basePath %>/base/base.do?ACT_ID=customerLogoff">退出</a>
						</p>
					<%} %>
				<li>
					<h2>公告</h2>
					<ul>
						<li>
							>>>>>>>>>>>>>>>>>>>>>>>>>>><a target="mainFrame" href="<%=basePath %>/base/base.do?ACT_ID=noteManager&actionMethod=frontQuery">更多...</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="clearfix">&nbsp;</div>
		<div id="footer-bar" class="two-cols">
			<div class="col1">
				<h2>欢迎您的到来</h2>
			</div>
			<div class="col2">
				<!--<ul>
					<li><a href="#">Faucibus non sit amet elit nulla</a></li>
					<li><a href="#">Consectetur adipiscing elit integer</a></li>
					<li><a href="#">Placerat dui sed posuere molestie</a></li>
					<li><a href="#">Urna sapien porta purus vel</a></li>
				</ul>
			--></div>
			<div class="clearfix">&nbsp;</div>
		</div>
	</div>
</div>
<div id="footer" class="container">
	<p>copy right 2012</p>
</div>
</body>
</html>
