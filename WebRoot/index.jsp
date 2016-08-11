<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="sys_jsp/base.jsp" %>
<%@ page import="com.sys.web.left.tree.*" %>
<html>
<head>
<%
	String tp = (String)request.getSession().getAttribute("type");
	String navInfo = NavTree.genNav(tp,"0");
	String sysTitle = NavTree.genTitile();
	request.setAttribute("navInfo",navInfo);
	request.setAttribute("sysTitle",sysTitle);
	String emailName1 = (String)request.getSession().getAttribute("defaultMail");
 %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<title>管理界面</title>
<!--
<link href="sys_style/style.css" rel="stylesheet" type="text/css" />
-->
<script type="text/javascript" src="sys_style/js.js"></script>
	
</head>

<body id="index">
<h1>
	大学生创新实验管理平台
</h1>
<div id="userInfo">
欢迎您 <%=request.getSession().getAttribute("userName") %> |
<a style="color: white" href="admin/admin_logout.do">注销</a>
</div>
<ul id="globalNav">
	<h2>管理菜单</h2>
	${navInfo }
</ul>
<iframe id="mainFrame" name="mainFrame" frameborder="0" width="100%" height="100%" src="siteInfo.jsp"></iframe>
</body>
</html>
