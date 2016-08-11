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
	</script>
  </head>
  
  <body id="page">
  <h2>=当前位置：项目详情</h2>
  
   <form action="pro/pro_add.do" name="mainform" enctype="multipart/form-data" method="post">
   	 <table id="normalT">
	   	<tr>
	    	<td>项目名称：</td>
	    	<td>
	    		${result.proName }
	    	</td>
	    </tr> 
	
	    <tr>
	    	<td>项目编码：</td>
	    	<td>
	    		${result.proId }
	    	</td>
	    </tr> 
	   
	     <tr>
	    	<td>项目姓名：</td>
	    	<td>
	    		${result.proLevel }
	    	</td>
	    </tr>
	     <tr>
	    	<td>项目学号：</td>
	    	<td>
	    		${result.proOri }
	    	</td>
	    </tr>  
	     <tr>
	    	<td>发起单位：</td>
	    	<td>
	    		${result.company }
	    	</td>
	    </tr> 
	     <tr>
	    	<td>开始日期：</td>
	    	<td>
	    		${result.startDate }
	    	</td>
	    </tr> 
	     <tr>
	    	<td>结束日期：</td>
	    	<td>
	    		${result.endDate }
	    	</td>
	    </tr> 
	     <tr>
	    	<td>参与性质：</td>
	    	<td>
	    		${result.joinType }
	    	</td>
	    </tr>
	    <tr>
	    	<td>申请用户：</td>
	    	<td>
	    		${result.postUsername }
	    	</td>
	    </tr>
	    	<td>创新项目信息：</td>
	    	<td>
	    		<textarea rows="8" cols="80" name="lixiangInfo" readonly="readonly" style="background-color: #EAEAEA">${result.lixiangInfo }</textarea>
	    	</td>
	    </tr>
	   	 <tr>
	   	 	<td>相关资料下载</td>
	   	 	<td>
	   	 		<a style="cursor: pointer;" onclick="actionDo('<%=basePath%>/file/file_download.do?id=${result.fileId}')" />${result.fileId }</a>
	   		</td>
	   	</tr>
	   	<tr>
	   		<td colspan="2">
	   			<input type="button" value="关闭" onclick="window.close();">
	   			<input type="button" value="打印" onclick="window.print();">
	   		</td>
	   	</tr>
   	</table>
   	</form>
  </body>
</html>
