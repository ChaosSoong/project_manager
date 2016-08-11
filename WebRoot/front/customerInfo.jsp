<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/front/style.css" media="screen" />
<script>
function checkAndSubmit(){
	var realname = document.regform.realname.value;
	if(realname == null || realname == ""){
		alert("真实姓名不能为空");
		return;
	}
	var idno = document.regform.idNo.value;
	if(idno == null || "" == idno){
		alert("身份证号不能为空");
		return;
	}
	var phone = document.regform.phone.value;
	if(phone == null || "" == phone){
		alert("联系电话不能为空");
		return;
	}
	document.regform.submit();
}
</script>
</head>
<body>
<h2>当前位置：我的信息(可以进行相应的修改)</h2>
<hr />
<form action="<%=basePath %>/base/base.do?ACT_ID=customerMdyCommit&type=1" method="post" name="regform">
<center>
	<table>
		<tr>
			<td>用户名：</td>
			<td>
				${result.username }
				<input type="hidden" name="username" value="${result.username }"/>
			</td>
		</tr>
		<tr>
			<td>真实姓名：</td>
			<td>
				<input type="text" name="realname" value="${result.realname }"/>*
			</td>
		</tr>
		<tr>
			<td>身份证：</td>
			<td>
				<input type="text" name="idNo" value="${result.idNo }"/>*
			</td>
		</tr>
		<tr>
			<td>联系电话：</td>
			<td>
				<input type="text" name="phone" value="${result.phone }"/>*
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input  type="button" value="修改" onclick="checkAndSubmit()"/>
			</td>
		</tr>
	</table>
	</center>
</form>
</body>
</html>
