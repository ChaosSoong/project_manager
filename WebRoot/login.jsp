<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>大学生创新实验管理平台</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.STYLE3 {
	font-size: 12px;
	color: #adc9d9;
}
-->
</style>
<script type="text/javascript">
function checkAndSubmit(){
	var userType = document.loginForm.loginType.value;
	if(userType == null || ""==userType){
		alert("请选择登录类型");
		return;
	}
	var username = document.loginForm.username.value;
	if(username == null || "" == username){
		alert("用户名不能为空");
		return;
	}
	var password = document.loginForm.password.value;
	if(password == null || ""==password){
		alert("密码不能为空");
		return;
	}
	document.loginForm.submit();
}
</script>
	</head>

	<body>
		<form action="<%=basePath %>/admin/admin_login.do" id="loginForm" method="post" name="loginForm">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td bgcolor="#1075b1">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="608" background="<%=basePath %>/sys_images/login_03.gif">
						<table width="847" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="318" background="<%=basePath %>/sys_images/login_04.gif">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td height="84">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="381" height="84"
												background="<%=basePath %>/sys_images/login_06.gif">
												&nbsp;
											</td>
											<td width="162" valign="middle"
												background="<%=basePath %>/sys_images/login_07.gif">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="44" height="24" valign="bottom">
															<div align="right">
																<span class="STYLE3">用户</span>
															</div>
														</td>
														<td width="10" valign="bottom">
															&nbsp;
														</td>
														<td height="24" colspan="2" valign="bottom">
															<div align="left">
																<input type="text" name="username" id="textfield"
																	style="width: 100px; height: 17px; background-color: #87adbf; border: solid 1px #153966; font-size: 12px; color: #283439;">
															</div>
														</td>
													</tr>
													<tr>
														<td height="24" valign="bottom">
															<div align="right">
																<span class="STYLE3">密码</span>
															</div>
														</td>
														<td width="10" valign="bottom">
															&nbsp;
														</td>
														<td height="24" colspan="2" valign="bottom">
															<input type="password" name="password" id="textfield2"
																style="width: 100px; height: 17px; background-color: #87adbf; border: solid 1px #153966; font-size: 12px; color: #283439;">
														</td>
													</tr>
													<tr>
														<td height="24" valign="bottom">
															<div align="right">
																<span class="STYLE3">类型</span>
															</div>
														</td>
														<td width="10" valign="bottom">
															&nbsp;
														</td>
														<td width="52" height="24" valign="bottom" colspan="2">
															<select name="loginType" id="loginType">
																<option value=""></option>
																<option value="0">
																	超级管理员
																</option>
																<option value="1">
																	系统管理员
																</option>
																<option value="2">
																	普通用户
																</option>
															</select>
														</td>
													</tr>
													<tr></tr>
												</table>
											</td>
											<td width="26">
												<img src="<%=basePath %>/sys_images/login_08.gif" width="26" height="84">
											</td>
											<td width="67" background="<%=basePath %>/sys_images/login_09.gif">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td height="25">
															<div align="center">
																<img src="<%=basePath %>/sys_images/dl.gif" width="57" height="20"  onclick="checkAndSubmit()">
															</div>
														</td>
													</tr>
													<tr>
														<td height="25">
															<div align="center">
																<img src="<%=basePath %>/sys_images/cz.gif" width="57" height="20">
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="211" background="<%=basePath %>/sys_images/login_10.gif">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="206" background="<%=basePath %>/sys_images/login_11.gif">
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td bgcolor="#152753">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
