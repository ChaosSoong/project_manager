<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'base.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>/sys_style/styles.css" rel="stylesheet" type="text/css" />
  </head>
<body id="page">
<h2>系统信息</h2>
<form name="mainform" />
<input type="hidden" name="forwardLocation" value="${forwardLocation }"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <c:choose>
	  	<c:when test="${empty forwardLocation }">
	  	<tr>
		    <th>
		    	<p>操作成功！</p>
		    	<p>
		     	 <input name="Submit" type="button" class="bt" value="返回" onclick="history.go(-1);"/>
		    	</p>
		    </th>
	  </tr>
	  	</c:when>
	  	<c:otherwise>
	  		<script type="text/javascript">
	  			alert("操作成功");
	  			window.location.href=document.mainform.forwardLocation.value;
	  		</script>
	  	</c:otherwise>
	  </c:choose>	
	</table>
</form>
</body>
</html>
