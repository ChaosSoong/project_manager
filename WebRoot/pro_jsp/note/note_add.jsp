<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Admin Add</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function checkSubmit() {
			var username = document.mainform.title.value;
			if(username == null || "" == username){
				alert("标题不能为空");
				return;
			}
			document.mainform.submit();
		}
	</script>
  </head>
  
  <body id="page">
  <h2>当前位置：添加通知公告</h2>
  <form action="note/note_add.do" method="post" name="mainform">
    <table id="normalT">
    	<tr>
    		<td>公告标题：</td>
    		<td>
    			<input type="text" name="title" required size="100"/>
    		</td>
    	</tr>  	
    	<tr>
    		<td>公告内容：</td>
    		<td>
    			<textarea rows="5" cols="100" name="content"></textarea>
    		</td>
    	</tr>  
    	<tr>
    		<td colspan="2">
    			<input type="button" value="提交" onclick="checkSubmit()"/>
    		</td>
    	</tr>
    </table>
    </form>
  </body>
</html>
