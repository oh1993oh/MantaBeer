<%@page import="vo.ShopBean"%>
<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%
	ArrayList<ShopBean> productList = (ArrayList) request.getAttribute("productList");
	String labelsStr = "";
	String dataStr = "";
	for (ShopBean p : productList) {
		String name = p.getProduct_name();
		int idx = name.indexOf("(");

		if (idx > -1) {
			name = name.substring(0, idx);

		}

		labelsStr = labelsStr + "'";
		labelsStr = labelsStr + name;
		labelsStr = labelsStr + "', ";

		dataStr = dataStr + p.getProduct_Quantity();
		dataStr = dataStr + ", ";
	}

	String test = "'qqq', '목넘김', '청량감', '단맛', '향', 'ㄱ맛', 'ㄱㄱㄱ','1', '2', '3', '1', '1', '1'";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 관리 목록</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/aos.css">

<link rel="stylesheet" href="css/ionicons.min.css">

<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">


<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">
<!-- 송진섭이 추가 한것  -->
<link rel="stylesheet" href="css/treade.css">
<!--  -->
</head>


<body class="goto-here">
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>

	<jsp:include page="/configuration/top.jsp" flush="false" />
	<!-- END nav -->

	<jsp:include page="/configuration/managebanner.jsp" flush="false" />





	<!-- END top 손대면 안됨! -->
	<section class="container">
		<!--  카테고리 인클루드 -->
		<jsp:include page="/configuration/managerpage.jsp" flush="false" />

		<div class="label_content"
			style="text-align: center; font-size: 40px; font-weight: bold; color: black;">
		</div>
		<div style="height: 100px;text-align: center;font-size: 32px;font-weight: bold;color: black;">
			재고 관리 
		</div>
		<br>

		<div class="table_list">
			<table border="1">
				<tr style="height: 34px;">
					<td rowspan="<%=productList.size() + 2%>>">
						<canvas id="myChart" width="1000" height="<%=(productList.size() + 2)*50 %>>"></canvas>
					</td>
					<td>첫줄</td>
				</tr>


				<%
					for (ShopBean prodcut : productList) {
				%>
				<tr>
					<td><input type="button" value="재고관리"
						onclick="Inventory_Management(<%=prodcut.getProduct_num()%>)"
						style="position: relative; height: 28px; outline: 0; border: 0; border-right: 3px solid white; background: black; color: white; width: 77px;">
					</td>

				</tr>
				<%
					}
				%>



				<tr style="height: 53px;">
					<td>막줄</td>
				</tr>
			</table>

			<script>
				
				
				
				var ctx = document.getElementById('myChart').getContext('2d');
				var data = {

					labels : [ <%=labelsStr%> ],

					datasets : [ {
						"label" : "재고",
						barPercentage : 0.5,
						barThickness : 2,
						maxBarThickness : 8,
						minBarLength : 2,
						data : [<%=dataStr%>]
					} ]
				}
				var options = {
					responsive : false,
					scales : {
						yAxes: [{
							barPercentage: 0.5,
						    gridLines: {
						    display: false
						    }
						}],
						xAxes: [{
							gridLines: {
							    zeroLineColor: "black",
							    zeroLineWidth: 2
						   	},
						    ticks: {
							    min: 0,
							    max: 15000,
							    stepSize: 1000
						    },
						    scaleLabel: {
							    display: true,
							    labelString: "'병'단위"
						    }
						}]
					}
				};

				var myBarChart = new Chart(ctx, {
					type : 'horizontalBar',
					data : data,
					options : options
				});
			</script>



		</div>


	</section>
	<section style="height: 200px;"></section>

	<!-- 푸터 들어가는곳 손대면 안됨! -->
	<jsp:include page="/configuration/footer.jsp" flush="false" />




	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<script src="js/jquery.min.js"></script>
	<!--송진섭  -->
	<script src="js/btn.js"></script>
	<script src="js/jquery-3.4.1.js"></script>
	<!--  -->


	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>
	<script>
		function Inventory_Management(pNum){
			alert(pNum);
		}
	</script>
</body>