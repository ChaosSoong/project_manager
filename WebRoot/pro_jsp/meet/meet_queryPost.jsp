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
			var url = "meet/meet_queryPost.do?curPage="+pageNum;
			self.location.href = encodeURI(url);
		}
		function toModify(url) {
			openWin(url,'mdy',500,500,0);
		}
	</script>
	</head>

	<body id="page">
		<h2> 
			当前位置：查看会议信息
		</h2>
		<form id="searchForm" name="searchForm" action="meet/meet_queryPost.do" method="post">
			<input name="isPost" value="Y" type="hidden">
			<input name="Submit" type="submit" class="bt" value="查询" />
		</form>
		<c:choose>
		<c:when test="${empty result }">
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th width="30%">
					标题
				</th>
				<th>
					摘要
				</th>
				<th>
					会议日期
				</th>
				<th>
					会议地点
				</th>
				<th>
					提供人
				</th>
				<th>
					提供时间
				</th>
			</tr>
			<c:forEach items="${result}" var="user">
			<tr>
				<td>
				<input type="hidden" name="id" value="${user.id }">
					${user.title}
				</td>
				<td>
					${user.remark }
				</td>
				<td>
					${user.beginDate }&nbsp; ${user.beginHour } : ${user.beginMiniute } 
				</td>
				<td>
					${user.address }
				</td>
				<td>
					${user.postUser }
				</td>
				<td>
					${user.postDate }
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
