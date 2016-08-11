<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/sys_jsp/base.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>admin query</title>

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
			var url = "note/note_query.do?curPage="+pageNum;
			self.location.href = encodeURI(url);
		}
		function toModify(url) {
			openWin(url,'mdy',500,500,0);
		}
	</script>
	</head>

	<body id="page">
		<h2> 
			当前位置：查询通知公告 
		</h2>
		<form id="searchForm" name="searchForm" action="note/note_query.do" method="post">
			<input name="Submit" type="submit" class="bt" value="查询" />
		</form>
		<c:choose>
		<c:when test="${empty result }">
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>
					标题
				</th>
				<th width="50%">
					内容
				</th>
				<th>
					发布日期
				</th>
				<th>
					执行操作
				</th>
			</tr>
			<c:forEach items="${result}" var="user">
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
				<td>
					<a style="cursor: hand" onclick="actionDel('<%=basePath%>/note/note_del.do?id=${user.id}')" />删除</a>
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
