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
		function toModify(url) {
			openWin(url,'mdy',500,500,0);
		}
		function checkAndSubmit(){
			var startDate = document.searchForm.startDate.value;
			if(startDate == null || ""==startDate) {
				alert("请输入预定时间");
				return;
			}
			var days = document.searchForm.days.value;
			if(days == null ||""==days) {
				alert("清填写入住天数");
				return;
			}
			document.searchForm.submit();
		}
	</script>
	</head>

	<body id="page">
		<h2> 
			当前位置：我的预订
		</h2>
		<c:choose>
		<c:when test="${empty result}">
		当前没有预订信息！
		</c:when>
		<c:otherwise>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>
					房间号
				</th>
				<th>
					房间级别
				</th>
				<th>
					房间价格
				</th>
				<th>
					是否特价
				</th>
				<th>
					开始时间(PM)
				</th>
				<th>
					结束时间(AM)
				</th>
				<th>
					执行操作
				</th>
			</tr>
			<c:forEach items="${result}" var="user">
			<tr>
				<td>
					${user.roomId }
				</td>
				<td>
					${user.roomLevel }
				</td>
				<td>
					${user.roomCount }
				</td>
				<td>
					${user.isSpecialPrice }
				</td>
				<td>
					${user.startDate }
				</td>
				<td>
					${user.endDate }
				</td>
				<td>
					<a style="cursor:pointer;" onclick="actionDo('<%=basePath%>/base/base.do?ACT_ID=customerCancelBook&id=${user.id}')" />取消预定</a> 
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
