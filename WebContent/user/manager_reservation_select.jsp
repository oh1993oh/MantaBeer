<%@page import="vo.ReservationBean"%>
<%@page import="vo.TradeBean"%>
<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%
	ArrayList<ReservationBean> tblist = (ArrayList) request.getAttribute("managerreservationList");
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
			예약 관리
		</div>
		
		<br>
		<div class="table_list">
			<div class="ul_list" style="width: 1025px; clear: both; position: relative;left: 19px;border: 1px solid gray;height: 30px;">
				<ul style="list-style: none;">
					<li style="float: left;width: 100px;border-right: 1px solid gray;">예약 유저</li>
					<li style="float: left;width: 161px;text-align: center;border-right: 1px solid gray;">예약 일자</li>
					<li style="float: left;width: 131px;text-align: center;border-right: 1px solid gray;">예약 시간 </li>
					<li style="float: left;width: 96px;text-align: center;border-right: 1px solid gray;">방 크기</li>
					<li style="float: left;width: 420px;text-align: center;border-right: 1px solid gray;">요청 사항 </li>
					<li style="float: left;width: 73px;padding: 0px 0px;text-align: center;">예약 취소</li>
				</ul>
			</div>
			<%
				for (ReservationBean rebean : tblist) {
			%>
			<div  style="clear: both;">
				<div class="admin_tr" style="clear: both;">
					
					<div class="td_admin" style="text-align:center; position:relative; float: left;left: 20px;top: 10px;border: 1px solid gray;width: 142px;">
						<span ><%=rebean.getReservation_user_name()%></span>
					</div>
					<div class="td_admin" style="text-align: center; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 161px;">
						<%=rebean.getReservation_date() %>
					</div>
					<div class="td_admin" style="text-align: center; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 131px;">
						<%=rebean.getReservation_time() %>
					</div>
					<div class="td_admin" style="text-align: right; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 96px;">
						<%=rebean.getReservation_room() %>
					</div>
					<div class="td_admin" style="text-align: center; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 420px;">
						<%=rebean.getReservation_notice() %>
					</div>
					<div class="td_admin" style="position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 75px;">
						<span><input type="button" value="예약 취소" onclick="location.href='manager_Reservation_delete.me?r_num=<%=rebean.getReservation_num() %>&u_num=<%=rebean.getReservation_user_num() %>'" style="position: relative;height: 28px;outline: 0;border: 0;border-right: 3px solid white;background: black;color: white;width: 77px;">
					</div>

				</div>

				<%
					}
				%>
			</div>
		</div>
		

	</section>
	<section style="height: 200px; clear: both;">
	
	</section>
	
	<!-- 푸터 들어가는곳 손대면 안됨! -->
	<footer class="ftco-footer ftco-section" style="clear: both;">
		<div class="container">
			<div class="row">
				<div class="mouse">
					<a href="#" class="mouse-icon">
						<div class="mouse-wheel">
							<span class="ion-ios-arrow-up"></span>
						</div>
					</a>
				</div>
			</div>
			<div class="row mb-5">
				<div class="col-md">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Vegefoods</h2>
						<p>Far far away, behind the word mountains, far from the
							countries Vokalia and Consonantia.</p>
						<ul
							class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
							<li class="ftco-animate"><a href="#"><span
									class="icon-twitter"></span></a></li>
							<li class="ftco-animate"><a href="#"><span
									class="icon-facebook"></span></a></li>
							<li class="ftco-animate"><a href="#"><span
									class="icon-instagram"></span></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md">
					<div class="ftco-footer-widget mb-4 ml-md-5">
						<h2 class="ftco-heading-2">Menu</h2>
						<ul class="list-unstyled">
							<li><a href="#" class="py-2 d-block">Shop</a></li>
							<li><a href="#" class="py-2 d-block">About</a></li>
							<li><a href="#" class="py-2 d-block">Journal</a></li>
							<li><a href="#" class="py-2 d-block">Contact Us</a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-4">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Help</h2>
						<div class="d-flex">
							<ul class="list-unstyled mr-l-5 pr-l-3 mr-4">
								<li><a href="#" class="py-2 d-block">Shipping
										Information</a></li>
								<li><a href="#" class="py-2 d-block">Returns &amp;
										Exchange</a></li>
								<li><a href="#" class="py-2 d-block">Terms &amp;
										Conditions</a></li>
								<li><a href="#" class="py-2 d-block">Privacy Policy</a></li>
							</ul>
							<ul class="list-unstyled">
								<li><a href="#" class="py-2 d-block">FAQs</a></li>
								<li><a href="#" class="py-2 d-block">Contact</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Have a Questions?</h2>
						<div class="block-23 mb-3">
							<ul>
								<li><span class="icon icon-map-marker"></span><span
									class="text">203 Fake St. Mountain View, San Francisco,
										California, USA</span></li>
								<li><a href="#"><span class="icon icon-phone"></span><span
										class="text">+2 392 3929 210</span></a></li>
								<li><a href="#"><span class="icon icon-envelope"></span><span
										class="text">info@yourdomain.com</span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 text-center">

					<p>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>
							document.write(new Date().getFullYear());
						</script>
						All rights reserved | This template is made with <i
							class="icon-heart color-danger" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>
				</div>
			</div>
		</div>
	</footer>



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
</body>