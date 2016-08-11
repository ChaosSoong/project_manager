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
  <h2>=当前位置：修改项目</h2>
  
   <form action="pro/pro_mdyCommit.do" name="mainform" enctype="multipart/form-data" method="post">
   <input type="hidden" name="isPost" value="${result.isPost }">
   <input type="hidden" name="id" value="${result.id }">
   <input type="hidden" name="proYear" value="${result.proYear }"/>
   <input type="hidden" name="proMonth" value="${result.proMonth }"/>
   <input type="hidden" name="proDay" value="${result.proDay }"/>
   <input type="hidden" name="fileId" value="${result.fileId }"/>
   	 <table id="normalT">
	   	<tr>
	    	<td>项目名称：</td>
	    	<td>
	    		<input type="text" name="proName" required size="100" value="${result.proName }"/>*
	    	</td>
	    </tr> 
	    <tr>
	    	<td>项目类型：</td>
	    	<td>
	    		${result.proType }
	    		<input type="hidden" name="proType" value="${result.proType }"/>
	    	</td>
	    </tr>
	    <tr>
	    	<td>项目编码：</td>
	    	<td>
	    		<input type="text" name="proId" required value="${result.proId }"/>*
	    	</td>
	    </tr> 
	     <tr>
	    	<td>项目类别：</td>
	    	<td>
	    		${result.proCategory }
	    		<input type="hidden" name="proCategory" value="${result.proCategory }" />
	    	</td>
	    </tr> 
	     <tr>
	    	<td>项目级别：</td>
	    	<td>
	    		<input type="text" name="proLevel" required value="${result.proLevel }"/>*
	    	</td>
	    </tr>
	     <tr>
	    	<td>项目来源：</td>
	    	<td>
	    		<input type="text" name="proOri" size="100" value="${result.proOri }"/>
	    	</td>
	    </tr>  
	     <tr>
	    	<td>委托单位：</td>
	    	<td>
	    		<input type="text" name="company" size="100" value="${result.company }"/>
	    	</td>
	    </tr> 
	     <tr>
	    	<td>开始日期：</td>
	    	<td>
	    		<input type="text" name="startDate" onfocus="showCalendar(this);" readonly="readonly" style="background-color: #EAEAEA" value="${result.startDate }"/>
	    	</td>
	    </tr> 
	     <tr>
	    	<td>结束日期：</td>
	    	<td>
	    		<input type="text" name="endDate" onfocus="showCalendar(this);" readonly="readonly" style="background-color: #EAEAEA" value="${result.endDate }"/>
	    	</td>
	    </tr> 
	     <tr>
	    	<td>参与性质：</td>
	    	<td>
	    		${result.joinType }
	    		<input type="hidden" name="joinType" value="${result.joinType }">
	    	</td>
	    </tr>
	    <tr>
	    	<td>申请用户：</td>
	    	<td>
	    		${result.postUsername }
	    		<input type="hidden" name="postUsername" value="${result.postUsername }">
	    	</td>
	    </tr>
	    <tr>
	    	<td>项目经费：</td>
	    	<td>
	    		<input type="text" name="proPrice" required onkeyup="this.value=this.value.replace(/[^\d]/g,'')" value="${result.proPrice }"/>*
	    	</td>
	    </tr>    
	    <tr>
	    	<td>到帐经费：</td>
	    	<td>
	    		<input type="text" name="alreadyPrice" required onkeyup="this.value=this.value.replace(/[^\d]/g,'')" value="${result.alreadyPrice }"/>*
	    	</td>
	    </tr>
	    <tr>
	    	<td>立项信息：</td>
	    	<td>
	    		<textarea rows="8" cols="80" name="lixiangInfo">${result.lixiangInfo }</textarea>
	    	</td>
	    </tr>
	   	 <tr>
	   	 	<td>资料上传</td>
	   	 	<td>
	   			<input name="attach" type="file" />
	   			<input name="area" type="hidden" value="normal"/>
	   		</td>
	   	</tr>
	   	<tr>
	   		<td colspan="2">
	   			<input type="button" value="提交" onclick="checkSubmit()">
	   			<input type="button" value="关闭" onclick="window.close()">
	   		</td>
	   	</tr>
   	</table>
   	</form>
  </body>
</html>
