<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
		var file = document.mainform.attach.value;
		if(file == null || file == ""){
			alert("请选择文件");
			return;
		}
		document.mainform.submit();
	}
	</script>
  </head>
  
  <body id="page">
  <h2>当前位置：常用资料上传</h2>
  
   <form action="file/file_upload.do" name="mainform" enctype="multipart/form-data" method="post">
   	 <table id="normalT">
   	 <tr>
   	 <td>
   		<input name="attach" type="file" />
   		<input name="area" type="hidden" value="normal"/>
   		<input type="button" value="上传" onclick="checkSubmit()">
   		</td>
   		</tr>
   	</table>
   	</form>
  </body>
</html>
