<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date date = new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(date);
String year = String.valueOf(cal.get(cal.YEAR));
String month = String.valueOf(cal.get(cal.MONTH)+1);
String day = String.valueOf(cal.get(cal.DATE));
String time = year + "-" + month + "-" + day;
request.getSession().setAttribute("s_currentTime", time);
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'base.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%	
		request.getSession().setAttribute("styleType","0");
		String type = (String)request.getSession().getAttribute("styleType");
		if("0".equals(type)){

	 %>
	 <link href="<%=basePath%>/sys_style/style.css" rel="stylesheet" type="text/css" />
	 <%} else{ %>
	 <link href="<%=basePath%>/sys_style/styles.css" rel="stylesheet" type="text/css" />
	 <%} %>
	 
	 <script type="text/javascript" src="<%=basePath%>/sys_js/calendar.js"></script>
 	 <script type="text/javascript" src="<%=basePath%>/sys_js/public.js" charset="utf-8"></script>
 	 <script type="text/javascript" src="<%=basePath%>/sys_js/jscharts.js"></script>
  </head>
</html>
