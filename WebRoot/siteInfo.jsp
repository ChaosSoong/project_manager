<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'base.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath%>/sys_style/style.css" rel="stylesheet" type="text/css" />
  </head>
<body id="page">
<h2>最新创新项目研讨</h2>
<c:choose>
<c:when test="${empty indexMeeting }">
			暂时没有创新项目信息
		</c:when>
		<c:otherwise>
<marquee style="font-size: 20px" onmouseover="this.stop()" onmouseout="this.start()" direction="left" behavior="scroll" bgcolor="yellow">${indexMeeting.title } ${indexMeeting.remark }  会议时间：${indexMeeting.beginDate }  ${indexMeeting.beginHour } : ${indexMeeting.beginMiniute }  会议地点：${indexMeeting.address }</marquee> 
<br/><br/>
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><a href="<%=basePath%>/meet/meet_queryPost.do?isPost=Y">所有创新项目信息</a>
<br/><br/>
</c:otherwise>
</c:choose>
<h2>通知/公告(只显示最新5条)</h2>
<c:choose>
		<c:when test="${empty indexNote }">
			暂时没有公告
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th width="30%">
					标题
				</th>
				<th width="50%">
					内容
				</th>
				<th>
					发布日期
				</th>
			</tr>
			<c:forEach items="${indexNote}" var="user">
			<tr>
				<td>
				<input type="hidden" name="id" value="${user.id }">
					${user.title}
				</td>
				<td>
					${user.content }
				</td>
				<td>
					${user.postDate }
				</td>
			</tr>
			</c:forEach>
		</table>
		</c:otherwise>
		</c:choose>
<br/>
<h2>常用资料下载</h2>
<c:choose>
		<c:when test="${empty indexNormalDownload }">
			暂时没有可用下载资料
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>
					文件名
				</th>
				<th>
					文件类型
				</th>
				<th>
					上传日期
				</th>
				<th>
					执行操作
				</th>
			</tr>
			<c:forEach items="${indexNormalDownload}" var="user">
			<tr>
				<td>
				<input type="hidden" name="id" value="${user.id }">
					${user.name}
				</td>
				<td>
					${user.type }
				</td>
				<td>
					${user.date }
				</td>
				<td>
				<c:if test="${uType == '1'}">
					<a style="cursor: hand" onclick="actionDel('<%=basePath%>/file/file_del.do?id=${user.id}')" />删除</a>
					/
				</c:if>
					<a style="cursor: hand" onclick="actionDo('<%=basePath%>/file/file_download.do?id=${user.id}')" />下载</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</c:otherwise>
		</c:choose>
</html>
