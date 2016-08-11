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
			当前位置：查询可预定房间 
		</h2>
		<form id="searchForm" name="searchForm" action="<%=basePath%>/base/base.do?ACT_ID=customerQueryRoom" method="post">
			房间级别：
			<select name="roomLevel">
					<option value=""></option>
    				<option value="普通房">普通房</option>
    				<option value="标准房">标准房</option>
    				<option value="豪华房">豪华房</option>
    				<option value="总统套房">总统套房</option>
    		</select>
    		是否特价:
    		<select name="isSpecialPrice">
    				<option value=""></option>
    				<option value="N">否</option>
    				<option value="y">是</option>
    		</select>
    		预定时间:
    		<input type="text" name="startDate" size="10" readonly="readonly" onfocus="showCalendar(this)" value="${startDate }">
    		入住天数:
    		<input type="text" name="days" size="2" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" value="${days }">
    		<br/>
			<input name="Submit" type="button" class="bt" value="查询" onclick="checkAndSubmit()" />
		</form>
		<c:choose>
		<c:when test="${empty result}">
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
				<%if(request.getSession().getAttribute("frontUsername") == null) {%>
					请先登录后再预定
				<%} else { %>
					<a style="cursor:pointer;" onclick="actionDo('<%=basePath%>/base/base.do?ACT_ID=customerRoomBook&startDate=${startDate }&endDate=${endDate }&days=${days }&id=${user.id}')" />预定</a> 
				<% }%>
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
