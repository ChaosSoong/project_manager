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
	var realname = document.regform.oldPwd.value;
	if(realname == null || realname == ""){
		alert("原始密码不能为空");
		return;
	}
	var idno = document.regform.newPwd.value;
	if(idno == null || "" == idno){
		alert("新密码不能为空");
		return;
	}
	var phone = document.regform.cnewPwd.value;
	if(phone == null || "" == phone){
		alert("确认密码不能为空");
		return;
	}
	if(idno != phone)  {
		alert("新密码和确认密码不一致");
		return;
	}
	
	
	document.regform.submit();
}
</script>
</head>
<body>
<h2>当前位置：修改密码</h2>
<hr />
<form action="<%=basePath %>/base/base.do?ACT_ID=customerPwdMdy&actionMethod=mdyPwd" method="post" name="regform">
<center>
	<table>
		<tr>
			<td>用户名：</td>
			<td>
				${result.username }
				<input type="hidden" name="username" value="${result.username }"/>
				<input type="hidden" name="id" value="${result.id }"/>
			</td>
		</tr>
		<tr>
			<td>原密码：</td>
			<td>
				<input type="password" name="oldPwd"/>*
			</td>
		</tr>
		<tr>
			<td>新密码：</td>
			<td>
				<input type="password" name="newPwd"/>*
			</td>
		</tr>
		<tr>
			<td>确认新密码：</td>
			<td>
				<input type="password" name="cnewPwd"/>*
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
