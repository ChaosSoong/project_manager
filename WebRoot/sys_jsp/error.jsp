<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'base.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>/sys_style/styles.css" rel="stylesheet" type="text/css" />
  </head>
  <body id="page">
  	<h2>系统信息</h2>
  	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <th><p>操作失败！</p>
    <p>失败原因：${errorMsg }</p>
    <p>
      <input name="Submit" type="button" class="bt" value="返回" onclick="history.go(-1);"/>
    </p></th>
  </tr>
  </body>
</html>
