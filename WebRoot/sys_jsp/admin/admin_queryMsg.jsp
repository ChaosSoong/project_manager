<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
		function toPage(pageNum){
			var uName = document.getElementById("username").value;
			var url = "admin/admin_query.do?curPage="+pageNum;
			self.location.href = encodeURI(url);
		}
		function toModify(url) {
			openWin(url,'mdy',500,500,0);
		}
	</script>
	</head>

	<body id="page">
		<h2>
			当前位置：查看站内信
		</h2>
		<form id="searchForm" name="searchForm" action="admin/admin_queryMsg.do" method="post">
			<select name="isRead">
				<option value="N" selected="selected">未读</option>
				<option value="Y">已读</option>
				<option value="">全部</option>
			</select>
			<input name="Submit" type="submit" class="bt" value="查看" />
		</form>
		<c:choose>
		<c:when test="${empty result}">
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>
					标题
				</th>
				<th>
					内容
				</th>
				<th>
					来自
				</th>
				<th>
					发送时间
				</th>
				<th>
					是否已读
				</th>
				<th>
					附件下载
				</th>
				<th>
					执行操作
				</th>
			</tr>
			<c:forEach items="${result}" var="user">
			<tr>
				<td>
					${user.title }
				</td>
				<td>
					${user.content }
				</td>
				<td>
					${user.fromUser }
				</td>
				<td>
					${user.postDate }
				</td>
				<td>
				<c:if test="${user.isRead == 'Y'}">
					已读
				</c:if>
				<c:if test="${user.isRead == 'N'}">
					未读
				</c:if>
				</td>
				<td>
					<a style="cursor: pointer;" onclick="actionDo('<%=basePath%>/file/file_download.do?id=${user.fileId}')" />${user.fileId }</a>
				</td>
				<td>
					<a style="cursor: pointer;" onclick="actionDel('<%=basePath%>/admin/admin_delMsg.do?id=${user.id}')" />删除</a>
					<c:if test="${user.isRead == 'N'}">
					/
					<a style="cursor: pointer;" onclick="actionDo('<%=basePath%>/admin/admin_doReadMsg.do?id=${user.id}')" />标记已读</a>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
		</c:otherwise>
		</c:choose>
		<div>
			${pageInfo }
		</div>
	</body>
</html>
