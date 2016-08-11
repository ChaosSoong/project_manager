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
			var url = "meet/meet_query.do?curPage="+pageNum;
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
		<form id="searchForm" name="searchForm" action="meet/meet_query.do" method="post">
			是否已经发布：
			<select name="isPost">
				<option value="">全部</option>
				<option value="Y">已发布</option>
				<option value="N">未发布</option>
			</select>
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
				<th>
					是否发布
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
				<td>
					${user.isPost }
				</td>
				<td>
					<a style="cursor: pointer;" onclick="actionDel('<%=basePath%>/meet/meet_del.do?id=${user.id}')" />删除</a>
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
