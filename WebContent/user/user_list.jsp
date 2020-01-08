<%@page import="vo.TradeBean"%>
<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%
	ArrayList<TradeBean> tblist = (ArrayList) request.getAttribute("getdepositservice");
	String state = "";
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

	<jsp:include page="/configuration/top.jsp" flush="false" />
	<!-- END nav -->

	<jsp:include page="/configuration/managebanner.jsp" flush="false" />
	
	
	
	
	
	<!-- END top 손대면 안됨! -->
	<section class="container">
		<!--  카테고리 인클루드 -->
		<jsp:include page="/configuration/managerpage.jsp" flush="false" />
		
		
		
		<div class="label_content" style="text-align: center; font-size: 40px; font-weight: bold; color: black;">
		</div>
		<div style="height: 100px;text-align: center;font-size: 32px;font-weight: bold;color: black;">
			결제 관리 
		</div>
		<br>
		<div class="table_list">
			<div class="ul_list" style="clear: both; position: relative;left: 19px;border: 1px solid gray;height: 30px;">
				<ul style="list-style: none;">
					<li style="float: left;width: 100px;border-right: 1px solid gray;">주문 일자</li>
					<li style="float: left;width: 110px;text-align: center;border-right: 1px solid gray;">주문 번호</li>
					<li style="float: left;width: 183px;text-align: center;border-right: 1px solid gray;">제품이름 </li>
					<li style="float: left;width: 96px;text-align: center;border-right: 1px solid gray;">금액</li>
					<li style="float: left;width: 420px;text-align: center;border-right: 1px solid gray;">배송지 </li>
					<li style="float: left;width: 159px;padding: 0px 0px;text-align: center;">배송</li>
				</ul>
			</div>
			<%
				for (TradeBean tb : tblist) {
					if(tb.getTrade_state().equals("deposit_completed")){
						state = "입금완료";
					}else if(tb.getTrade_state().equals("delivery_completed")){
						state = "배송도착";
					}else if(tb.getTrade_state().equals("deal_completed")){
						state = "거래완료";
					}
			%>
			<div  style="clear: both;">
				<div class="admin_tr" style="clear: both;">
					
					<div class="td_admin" style="text-align:center; position:relative; float: left;left: 20px;top: 10px;border: 1px solid gray;width: 142px;">
						<span ><%=tb.getTrade_date()%></span>
					</div>
					<div class="td_admin" style="text-align: center; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 107px;">
						<a href="user_detaillist.me?trade_classification=<%=tb.getTrade_classification()%>" style="color: green;" > <%=tb.getTrade_classification()%></a>
					</div>
					<div class="td_admin" style="position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 184px;">
						<span ><%=tb.getProduct_name()%></span>
					</div>
					<div class="td_admin" style="text-align: right; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 96px;">
						<span><%=tb.getTotalprice()%></span><span>&nbsp;원</span>
					</div>
					<div class="td_admin" style="position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 420px;">
						<span ><%=tb.getAdress()%></span>
					</div>
					<div class="td_admin" style="position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 159px;">
						<%
						if(state.equals("입금완료")){
						%>	
						
						<span><input type="button" value="배송시작" onclick = "postProduct(<%=tb.getTrade_classification() %>)" style="position: relative;height: 28px;outline: 0;border: 0;border-right: 3px solid white;background: black;color: white;width: 77px;">
							  <input type="button" value="배송취소" style="position: relative;height: 28px;outline: 0;border: 0;background: black;color: white;width: 77px;"></span>
						
						
						<%
						}
						%>
					</div>

				</div>

				<%
					}
				%>
			</div>
		</div>
		

	</section>
	<section style="height: 200px;">
	
	</section>
	
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
	<script type="text/javascript">
		function postProduct(num){
			location.href='stateChange.me?classification='+num+'&state=delivery_completed';
		}
			
	</script>
</body>