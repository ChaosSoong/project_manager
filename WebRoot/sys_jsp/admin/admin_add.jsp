<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>
<!DOCTYPE html>
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
	<script type="text/javascript">
		function checkAndSubmit(){
			var username = document.mainform.username.value;
			if(username == null || "" == username){
				alert("用户名不能为空");
				return;
			}
			var password = document.mainform.password.value;
			if(password == null || "" == password){
				alert("密码不能为空");
				return;
			}
			var cpassword = document.mainform.cpassword.value;
			if(cpassword == null || "" == cpassword) {
				alert("确认密码不能为空");
				return;
			}
			if(password != cpassword) {
				alert("密码和确认密码不一致");
				return;
			}
			document.mainform.submit();
		}
	</script>
  </head>
  
  <body id="page">
  <h2>当前位置：添加用户</h2>
  <form action="admin/admin_add.do" method="post" name="mainform">
    <table id="normalT">
    	<tr>
    		<td>用&nbsp;户&nbsp;名：</td>
    		<td>
    			<input type="text" name="username" required/>*(用户名不能包含中文)
    		</td>
    	</tr>
    	<tr>
    		<td>用户编号：</td>
    		<td>
    			<input type="text" name="power" required/>
    		</td>
    	</tr>
    	<tr>
    		<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
    		<td>
    			<input type="password" name="password" required/>*
    		</td>
    	</tr>
    	<tr>
    		<td>确认密码：</td>
    		<td>
    			<input type="password" name="cpassword" required/>*
    		</td>
    	</tr>
    	<tr>
    		<td>用户类型：</td>
    		<td>
    		<%if(request.getSession().getAttribute("type").equals("0")){%>
    			<input type="radio" name="userType" value="1">系统管理员
    		<%} %>
    			<input type="radio" name="userType" value="2" checked="checked">普通用户
    		</td>
    	</tr>
    	<tr>
    		<td>真实姓名：</td>
    		<td>
    			<input type="text" name="name" />
    		</td>
    	</tr>
    	<tr>
    		<td>性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    		<td>
    			<input type="radio" name="gender" value="男" checked="checked"/>男
    			<input type="radio" name="gender" value="女"/>女
    		</td>
    	</tr>
    	<tr>
    		<td>联系地址：</td>
    		<td>
    			<input type="text" name="address" size="90" />
    		</td>
    	</tr>
    	<tr>
    		<td>联系电话：</td>
    		<td>
    			<input type="text" name="phone" />
    		</td>
    	</tr>
    	<tr>
    		<td>联系邮件：</td>
    		<td>
    			<input type="text" name="email" size="50"/>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2">
    			<input type="button" value="提交" onclick="checkAndSubmit()"/>
    		</td>
    	</tr>
    </table>
    </form>
  </body>
</html>
