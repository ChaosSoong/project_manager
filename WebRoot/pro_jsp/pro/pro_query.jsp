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
			var url = "pro/pro_query.do?curPage="+pageNum;
			self.location.href = encodeURI(url);
		}
	</script>
	</head>

	<body id="page">
		<h2>
			当前位置：查询项目信息
		</h2>
		<form id="searchForm" name="searchForm" action="pro/pro_query.do" method="post">
			项目名称：
			<input name="proName" type="text" />
			<input name="area" type="hidden" value="project" />
			<%if("1".equals((String)request.getSession().getAttribute("type"))) {%>
				用户名:<input name="postUsername" type="text" />
				是否通过审核：
				<select name="isPost">
					<option value="">全部</option>
					<option value="Y">是</option>
					<option value="N">否</option>
				</select>
			<%}else if("2".equals((String)request.getSession().getAttribute("type"))){ %>
				<input name="isPost" type="hidden" value="Y" />
				<input name="postUsername" type="hidden" value="${userName }" />
			<%} %>
			<input name="Submit" type="submit" class="bt" value="查询" />
		</form>
		<c:choose>
		<c:when test="${empty result}">
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>
					项目名称
				</th>
				<th>
					项目编码
				</th>
				<th>
					申报日期
				</th>
				<th>
					开始时间
				</th>
				<th>
					结束时间
				</th>
				<th>
					相关资料下载
				</th>
				<th>
					执行操作
				</th>
			</tr>
			<c:forEach items="${result}" var="user">
			<tr>
				<td>
				<input type="hidden" name="id" value="${user.id }">
					${user.proName}
				</td>
				<td>
					${user.proId }
				</td>
				<td>
					${user.postDate }
				</td>
				<td>
					${user.startDate }
				</td>
				<td>
					${user.endDate }
				</td>
				<td>
					<a style="cursor: pointer;" onclick="actionDo('<%=basePath%>/file/file_download.do?id=${user.fileId}')" />${user.fileId }</a>
				</td>
				<td>
				
					<a style="cursor: pointer;" onclick="openWin('<%=basePath%>/pro/pro_detail.do?id=${user.id}&fileId=${user.fileId }','',800,800,1)" />详细</a>
					/
					<a style="cursor: pointer;" onclick="openWin('<%=basePath%>/pro/pro_mdy.do?id=${user.id}&fileId=${user.fileId }','',800,600,1)" />修改</a>
					<%if("1".equals((String)request.getSession().getAttribute("type"))) {%>
					/
					<a style="cursor: pointer;" onclick="actionDel('<%=basePath%>/pro/pro_del.do?id=${user.id}&fileId=${user.fileId }')" />删除</a>
					<c:if test="${user.isPost == 'N'}">
					/
					<a style="cursor: pointer;" onclick="actionDo('<%=basePath%>/pro/pro_post.do?id=${user.id}&fileId=${user.fileId }')" />通过审核</a>
					</c:if>
					<%} %>
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
