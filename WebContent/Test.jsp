<%@page import="vo.BeerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		BeerBean beerBean = (BeerBean)request.getAttribute("beerBean");
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
</head>
<body>
	<canvas id="myChart" width="500" height="500"></canvas>
	<script>
		var ctx = document.getElementById('myChart').getContext('2d');
		var data = {

			labels : [ '바디감', '목넘김', '청량감', '단맛', '향', '쓴맛' ],
			datasets : [ {
				"label" : "매니저 평가",
				data : [<%=beerBean.getBeer_body()%>,<%=beerBean.getBeer_Thirsty()%>,<%=beerBean.getBeer_Refreshing()%>,
				<%=beerBean.getBeer_sweetness()%>,<%=beerBean.getBeer_flavor()%>,<%=beerBean.getBeer_bitter()%>],
				"fill" : true,
				"backgroundColor" : "rgba(255, 99, 132, 0.2)",
				"borderColor" : "rgb(255, 99, 132)",
				"pointBackgroundColor" : "rgb(255, 99, 132)",
				"pointBorderColor" : "#fff",
				"pointHoverBackgroundColor" : "#fff",
				"pointHoverBorderColor" : "rgb(255, 99, 132)"
			} ]
		}
		var options = {
			responsive : false,
			scale : {
				angleLines : {
					display : false
				},
				ticks : {
					suggestedMin : 0,
					suggestedMax : 6
				}
			}
		};

		var myRadarChart = new Chart(ctx, {
			type : 'radar',
			data : data,
			options : options
		});
	</script>
</body>
</html>