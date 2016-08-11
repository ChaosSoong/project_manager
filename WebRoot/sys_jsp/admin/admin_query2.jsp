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
			当前位置：查询用户
		</h2>
		<form id="searchForm" name="searchForm" action="admin/admin_query2.do" method="post">
			用户名：
			<input name="username" type="text" value="${username }" />
			<input name="Submit" type="submit" class="bt" value="查询" />
		</form>
		<c:choose>
		<c:when test="${empty result}">
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>
					用户名
				</th>
				<th>
					用户编码
				</th>
				<th>
					真实姓名
				</th>
				<th>
					类型
				</th>
				<th>
					性别
				</th>
				<th>
					联系方式
				</th>
				<th>
					创建时间
				</th>
				<th>
					执行操作
				</th>
			</tr>
			<c:forEach items="${result}" var="user">
			<tr>
				<td>
					${user.username }
				</td>
				<td>
					${user.power }
				</td>
				<td>
					${user.name }
				</td>
				<td>
				<c:if test="${user.userType == '1'}">
					系统管理员
				</c:if>
				<c:if test="${user.userType == '2'}">
					普通用户
				</c:if>
				</td>
				<td>
					${user.gender }
				</td>
				<td>
					电话：${user.phone } / 地址：${user.address } / 邮箱：${user.email }
				</td>
				<td>
					${user.createTime }
				</td>
				<td>
					<a style="cursor: hand" onclick="actionDel('<%=basePath%>/admin/admin_del.do?username=${user.username}')" />删除</a>/
					<a style="cursor: hand" onclick="openWin('<%=basePath%>/admin/admin_modify.do?username=${user.username}','',800,600,1)" />修改</a>
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
