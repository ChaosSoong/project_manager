<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>

<!DOCTYPE html>
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
		var title = document.mainform.title.value;
		if(title == null || title == ""){
			alert("题目不能为空");
			return;
		}
		var author = document.mainform.author.value;
		if(author == null || author == ""){
			alert("所有作者不能为空");
			return;
		}
		var company = document.mainform.company.value;
		if(company == null || company == ""){
			alert("所有单位不能为空");
			return;
		}
		var juan = document.mainform.juan.value;
		if(juan == null || juan == ""){
			alert("卷不能为空");
			return;
		}
		var qi = document.mainform.qi.value;
		if(qi == null || qi == ""){
			alert("期不能为空");
			return;
		}
		document.mainform.submit();
	}
	</script>
  </head>
  
  <body id="page">
  <h2>=当前位置：添加论文信息</h2>
  
   <form action="thesis/thesis_add.do" name="mainform" enctype="multipart/form-data" method="post">
   	 <table id="normalT">
	   	<tr>
	    	<td>论文题目：</td>
	    	<td>
	    		<input type="text" name="title" required size="100"/>*
	    	</td>
	    </tr> 
	    <tr>
	    	<td>所有学生：</td>
	    	<td>
	    		<input type="text" style="background-color: #EAEAEA" name="username" readonly="readonly" required value="${userName }"/>
	    	</td>
	    </tr>
	    <tr>
	    	<td>所有作者：</td>
	    	<td>
	    		<input type="text" name="author" required/>*
	    	</td>
	    </tr>    
	    <tr>
	    	<td>所有学校：</td>
	    	<td>
	    		<input type="text" name="company" required size="100"/>*
	    	</td>
	    </tr>
	     <tr>
	    	<td>年：</td>
	    	<td>
	    		<input type="text" style="background-color: #EAEAEA" name="postYear" required value="<%=year %>" readonly="readonly"/>
	    		<input type="hidden" name="postMonth" required value="<%=month %>"/>
	    		<input type="hidden" name="postDay" required value="<%=day %>"/>
	    	</td>
	    </tr>
	    <tr>
	    	<td>月：</td>
	    	<td>
	    		<input type="text" name="juan" required/>*
	    	</td>
	    </tr>
	     <tr>
	    	<td>日：</td>
	    	<td>
	    		<input type="text" name="qi" required/>*
	    	</td>
	    </tr>      	
	   	 <tr>
	   	 	<td>
	   			<input name="attach" type="file" />
	   			<input name="area" type="hidden" value="normal"/>
	   		</td>
	   	</tr>
	   	<tr>
	   		<td colspan="2">
	   			<input type="button" value="上传" onclick="checkSubmit()">
	   		</td>
	   	</tr>
   	</table>
   	</form>
  </body>
</html>
