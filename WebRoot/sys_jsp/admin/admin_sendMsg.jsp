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
			var title = document.mainform.title.value;
			if(title == null || "" == title){
				alert("信息标题不能为空");
				return;
			}
			document.mainform.submit();
		}
	</script>
  </head>
  
  <body id="page">
  <h2>当前位置：添加用户</h2>
  <form action="admin/admin_sendMsg.do" method="post" name="mainform" enctype="multipart/form-data">
    <table id="normalT">
    	<tr>
    		<td>信息标题：</td>
    		<td>
    			<input type="text" name="title" required size="100"/>*
    		</td>
    	</tr>
    	<tr>
    		<td>信息内容：</td>
    		<td>
    			<textarea rows="5" cols="80" name="content"></textarea>
    		</td>
    	</tr>
    	<tr>
    		<td>相关附件：</td>
	   	 	<td>
	   			<input name="attach" type="file" />
	   			<input name="area" type="hidden" value="normal"/>
	   		</td>
	   	</tr>
    	<tr>
    		<td colspan="2">
    			<input type="button" value="发送" onclick="checkAndSubmit()"/>
    		</td>
    	</tr>
    </table>
    </form>
  </body>
</html>
