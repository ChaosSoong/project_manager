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
			var beginDate = document.mainform.beginDate.value;
			if(beginDate == null || "" == beginDate){
				alert("日期不能为空");
				return;
			}
			var beginHour = document.mainform.beginHour.value;
			if(beginHour == null || "" == beginHour){
				alert("小时不能为空");
				return;
			}
			var beginMiniute = document.mainform.beginMiniute.value;
			if(beginMiniute == null || "" == beginMiniute){
				alert("分钟不能为空");
				return;
			}
			document.mainform.submit();
		}
	</script>
  </head>
  
  <body id="page">
  <h2>当前位置：提供会议信息</h2>
  <form action="meet/meet_add.do" method="post" name="mainform">
    <table id="normalT">
    	<tr>
    		<td>会议标题：</td>
    		<td>
    			<input type="text" name="title" required size="100"/>*
    		</td>
    	</tr>  	
    	<tr>
    		<td>会议摘要：</td>
    		<td>
    			<textarea rows="5" cols="100" name="remark"></textarea>
    		</td>
    	</tr>
    	<tr>
    		<td>会议时间：</td>
    		<td>
    			日期：<input type="text" readonly="readonly" size="16" name="beginDate" onfocus="showCalendar(this)">*
    			<input type="text" name="beginHour" value="09" size="2" maxlength="2" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" required>时*
    			<input type="text" name="beginMiniute" value="00" size="2" maxlength="2" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" required>分*
    		</td>
    	</tr>    
    	<tr>
    		<td>会议地点：</td>
    		<td>
    			<input type="text" name="address" required size="100"/>
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
