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
		var proName = document.mainform.proName.value;
		if(proName == null || proName == ""){
			alert("项目名称不能为空");
			return;
		}
		var proId = document.mainform.proId.value;
		if(proId == null || proId == ""){
			alert("项目编码不能为空");
			return;
		}
		var proLevel = document.mainform.proLevel.value;
		if(proLevel == null || proLevel == ""){
			alert("项目级别不能为空");
			return;
		}
		var startDate = document.mainform.startDate.value;
		if(startDate == null || startDate == ""){
			alert("开始日期不能为空");
			return;
		}
		var endDate = document.mainform.endDate.value;
		if(endDate == null || endDate == ""){
			alert("结束日期不能为空");
			return;
		}
		document.mainform.submit();
	}
	</script>
  </head>
  
  <body id="page">
  <h2>=当前位置：申报项目</h2>
  
   <form action="pro/pro_add.do" name="mainform" enctype="multipart/form-data" method="post">
   <input type="hidden" name="isPost" value="N">
   <input type="hidden" name="proYear" value="<%=year %>"/>
   <input type="hidden" name="proMonth" value="<%=month %>"/>
   <input type="hidden" name="proDay" value="<%=day %>"/>
   	 <table id="normalT">
	   	<tr>
	    	<td>项目名称：</td>
	    	<td>
	    		<input type="text" name="proName" required size="100"/>*
	    	</td>
	    </tr> 
	    <tr>
	    <!-- 	<td>项目类型：</td>
	    	<td>
	    	
	    		<input type="radio" name="proType" value="纵向项目" checked="checked">纵向项目
	    		<input type="radio" name="proType" value="横向项目">横向项目
	    		 -->
	    	</td>
	    </tr>
	    <tr>
	    	<td>项目编码：</td>
	    	<td>
	    		<input type="text" name="proId" required/>*
	    	</td>
	    </tr> 
	    <!--  <tr>
	    	<td>项目类别：</td>
	    	<td>
	    		<input type="radio" name="proCategory" value="科技服务" checked="checked">科技服务
	    		<input type="radio" name="proCategory" value="横向项目">委托开发
	    	</td>
	    </tr> --> 
	     <tr>
	    	<td>学生姓名：</td>
	    	<td>
	    		<input type="text" name="proName" required size="100"/>
	    	
	    	</td>
	    </tr>
	     <tr>
	    	<td>学生学号：</td>
	    	<td>
	    		<input type="text" name="proName" required size="100"/>
	    	</td>
	    </tr>
	     <tr>
	    	<td>项目来源：</td>
	    	<td>
	    		<input type="text" name="proOri" size="100"/>
	    	</td>
	    </tr>  
	     <tr>
	    	<td>发起单位：</td>
	    	<td>
	    		<input type="text" name="company" size="100"/>
	    	</td>
	    </tr> 
	     <tr>
	    	<td>开始日期：</td>
	    	<td>
	    		<input type="text" name="startDate" onfocus="showCalendar(this); style="background-color: #EAEAEA"/>
	    	</td>
	    </tr> 
	     <tr>
	    	<td>结束日期：</td>
	    	<td>
	    		<input type="text" name="endDate" onfocus="showCalendar(this); style="background-color: #EAEAEA"/>
	    	</td>
	    </tr> 
	     <tr>
	    	<td>参与性质：</td>
	    	<td>
	    		<input type="radio" name="joinType" value="负责" checked="checked">负责
	    		<input type="radio" name="joinType" value="参与">参与
	    	</td>
	    </tr>
	    <tr>
	    	<td>申请学生：</td>
	    	<td>
	    		<input type="text" style="background-color: #EAEAEA" name="postUsername" readonly="readonly" required value="${userName }"/>
	    	</td>
	    </tr>
	    
	   
	    <tr>
	    	<td>创新项目信息：</td>
	    	<td>
	    		<textarea rows="8" cols="80" name="lixiangInfo"></textarea>
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
	   			<input type="button" value="提交" onclick="checkSubmit()">
	   		</td>
	   	</tr>
   	</table>
   	</form>
  </body>
</html>
