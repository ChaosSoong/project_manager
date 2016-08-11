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
	</script>
	</head>

	<body id="page">
		<h2> 
			当前位置：创新项目统计
		</h2>
		<form id="searchForm" name="searchForm" action="pro/pro_report.do" method="post">
			年度：
			<select name="year">
				<option value="2012">2012</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
			</select>
			类型：
			<select name="proType">
				<option value="">全部</option>
				<option value="纵向项目">纵向项目</option>
				<option value="横向项目">横向项目</option>
			</select>
			<!--
			月度：
			<select name="month">
				<option value="">全部</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			--><br/>
			<input name="Submit" type="submit" class="bt" value="查询" />
		</form>
		<form>
			<c:choose>
				<c:when test="${empty result}">
				</c:when>
				<c:otherwise>
					<div id="chartcontainer2">
						正在准备数据......
					<script type="text/javascript">
						var myData = new Array(["1月", ${result.month1}], ["2月", ${result.month2}], ["3月", ${result.month3}], ["4月", ${result.month4}], ["5月", ${result.month5}],["6月", ${result.month6}],["7月", ${result.month7}],["8月", ${result.month8}],["9月", ${result.month9}],["10月", ${result.month10}],["11月", ${result.month11}],["12月", ${result.month12}]);
						var myChart = new JSChart('chartcontainer2', 'bar');
						myChart.setDataArray(myData);
						myChart.setTitle("统计");
						myChart.setAxisNameX("月份");
						myChart.setAxisNameY("");
						myChart.draw();
					</script>
					</div>
					<br/>
					<input type="button" class="bt" value="打印" onclick="window.print()"/>
				</c:otherwise>
			</c:choose>
		</form>
	</body>
</html>
