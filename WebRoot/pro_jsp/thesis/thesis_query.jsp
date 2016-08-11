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
		function toModify(url) {
			openWin(url,'mdy',500,500,0);
		}
		function toPage(pageNum){
			var url = "thesis/thesis_query.do?curPage="+pageNum;
			self.location.href = encodeURI(url);
		}
	</script>
	</head>

	<body id="page">
		<h2>
			当前位置：查询论文信息
		</h2>
		<form id="searchForm" name="searchForm" action="thesis/thesis_query.do" method="post">
			题目：
			<input name="title" type="text" />
			<input name="area" type="hidden" value="thesis" />
			<input name="username" type="hidden" value="${userName }" />
			<input name="Submit" type="submit" class="bt" value="查询" />
		</form>
		<c:choose>
		<c:when test="${empty result}">
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>
					题目
				</th>
				<th>
					所有人/所有单位
				</th>
				<th>
					年/卷/期
				</th>
				<th>
					论文下载
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
					${user.author } / ${user.company }
				</td>
				<td>
					${user.postYear } / ${user.juan } / ${user.qi }
				</td>
				<td>
					<a style="cursor: pointer;" onclick="actionDo('<%=basePath%>/file/file_download.do?id=${user.fileId}')" />${user.fileId }</a>
				</td>
				<td>
					<a style="cursor: pointer;" onclick="actionDel('<%=basePath%>/thesis/thesis_del.do?id=${user.id}&fileId=${user.fileId }')" />删除</a>
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
