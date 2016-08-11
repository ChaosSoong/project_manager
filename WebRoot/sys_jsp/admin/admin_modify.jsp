<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin_add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body id="page">
  <h2>当前位置：修改信息</h2>
  <form action="admin/admin_update.do" method="post">
    <table id="normalT">
    	<tr>
    		<td>用&nbsp;户&nbsp;名：</td>
    		<td>
    			${result.username }
    			<input type="hidden" name="username" value="${result.username }"/>
    		</td>
    	</tr>
    	<tr>
    		<td>用户编码：</td>
    		<td>
    			${result.power}
    		</td>
    	</tr>
    	<tr>
    		<td>用户类型：</td>
    		<td>
    			普通用户
    			<input type="hidden" name="userType" value="2">
    		</td>
    	</tr>
    	<tr>
    		<td>真实姓名：</td>
    		<td>
    			<input type="text" name="name" value="${result.name }"/>
    		</td>
    	</tr>
    	<tr>
    		<td>性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    		<td>
    			${result.gender }
    			<input type="hidden" name="gender" value="${result.gender }">
    		</td>
    	</tr>
    	<tr>
    		<td>联系地址：</td>
    		<td>
    			<input type="text" name="address" size="90" value="${result.address }"/>
    		</td>
    	</tr>
    	<tr>
    		<td>联系电话：</td>
    		<td>
    			<input type="text" name="phone" value="${result.phone }" />
    		</td>
    	</tr>
    	<tr>
    		<td>联系邮件：</td>
    		<td>
    			<input type="text" name="email" size="50" value="${result.email }"/>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2">
    			<input type="submit" value="提交修改" />
    		</td>
    	</tr>
    </table>
    </form>
  </body>
</html>
