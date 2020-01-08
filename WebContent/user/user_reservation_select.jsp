<%@page import="vo.ReservationBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.TradeBean"%>
<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
UserBean user = (UserBean) request.getAttribute("user_id");
ArrayList<ReservationBean> list= (ArrayList)request.getAttribute("reservationList");

%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>

<!--지워도 되는것  -->

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
	<jsp:include page="/configuration/top.jsp" flush="false"/>
	<!-- END nav -->

	<jsp:include page="/configuration/mypageBenner.jsp" flush="false"/>
	<!-- END top 손대면 안됨! -->
	<section class="container" >
		<!--  카테고리 인클루드 -->
		<jsp:include page="/configuration/mypage_left.jsp" flush="false"/>
		<div style="float: left;">
		<div class="label_content" style="  text-align: center; font-size: 40px; font-weight: bold; color: black;">
			<p style="clear: both;"> 예약 확인</p>
		
		
		</div>
		
		
		<br>
		<div class="table_list">
			<div class="ul_list" style="clear: both; position: relative;left: 19px;border: 1px solid gray;height: 30px; width: 868px;">
				<ul style="list-style: none;">
					<li style="float: left;width: 100px;border-right: 1px solid gray;">예약 일자</li>
					<li style="float: left;width: 110px;text-align: center;border-right: 1px solid gray;">예약 시간</li>
					<li style="float: left;width: 113px;text-align: center;border-right: 1px solid gray;">방 크기 </li>
					<li style="float: left;width: 408px;text-align: center;border-right: 1px solid gray;">요정사항</li>
					<li style="float: left;width: 85px;padding: 0px 0px;text-align: center;">예약 취소</li>
				</ul>
			</div>
			<%
				for (ReservationBean rebean : list) {
			%>
			<div  style="clear: both;">
				<div class="admin_tr" style="clear: both;">
					
					<div class="td_admin" style="text-align:center; position:relative; float: left;left: 20px;top: 10px;border: 1px solid gray;width: 142px;">
						<span ><%=rebean.getReservation_date()%></span>
					</div>
					<div class="td_admin" style="text-align: center; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 107px;">
						<span><%=rebean.getReservation_time()%></span> 
					</div>
					<div class="td_admin" style="text-align: center; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 114px;">
						<span ><%=rebean.getReservation_room()%></span>
					</div>
					<div class="td_admin" style="text-align: center; position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 408px;">
						<span><%=rebean.getReservation_notice()%></span>
					</div>
					<div class="td_admin" style="position: relative;float: left;left: 20px;top: 10px;border-top: 1px solid gray;border-right: 1px solid gray;border-bottom: 1px solid gray;width: 96px;">
						<span>
						<input type="button" class="reseult_btn" value="예약취소" onclick="location.href='Reservation_delete.me?r_num=<%=rebean.getReservation_num() %>'" style="position: relative;height: 28px;outline: 0;border: 0;border-right: 3px solid white;background: black;color: white;width: 99px;">
						<input type="hidden" vlaue="<%=rebean.getReservation_user_num()%>">
					</div>

				</div>

				<%
					}
				%>
			</div>
		</div>
		</div>

	</section>
	<%-- <div class="container">
		<div class="letfno1">
			<jsp:include page="/configuration/mypage_left.jsp" flush="false"/>
		</div>


		<div class="order_range">
			<div class="top_main">
				<p>☆ 주문확인 페이지☆</p>
			</div>
			<form action="UserupdatePro.me" method="post">
				<div class="order_comtain">
					<div class="order_table">
						<ul class="order_tr">
							<li class="order_td">주문일자</li>
							<li class="order_td">주문번호</li>
							<li class="order_td">제품이름</li>
							<li class="order_td">수량      </li>
							<li class="order_td">금액      </li>
							<li class="order_td">처리상태</li>
						</ul>
						<div class="order_div">
						<ul class="order_content_ul">
							<%

							
							for(int i=0; i<list.size(); i++ ){%>
								<div class="order_Contents"><%=list.get(i).getTrade_state_date()%></div>
								<div class="order_Contents"><a href="#"><%=list.get(i).getTrade_classification()%></a></div>
								<div class="order_Contents"><%=list.get(i).getProduct_name() %> </div>
								<div class="order_Contents"><%=list.get(i).getTrade_quantity() %> </div>
								<div class="order_Contents"><%=list.get(i).getProduct_price() %> </div>
								<div class="order_Contents"><input type="button" value="입금대기" class="result_btn"></div>
							<%	
							}
							%>


						</ul>
						</div>

					</div>
				</div>
				<div class="mypage">
					<input type="reset" value="재입력하기" class="btn_bottom"> <input
						type="button" value="정보수정하기"
						onclick="location.href='Userupdateform.me'" class="btn_bottom">
					<input type="button" value="탈퇴하기"
						onclick="location.href='UserDeleteForm.me'" class="btn_bottom">
					<input type="button" value="홈으로 이동하기 "
						onclick="location.href='BeerMain.me'" class="btn_bottom">

				</div>


			</form>


		</div>



	</div> --%>

	<section style="float: left; height: 100px;">
	</section>
	<jsp:include page="/configuration/footer.jsp" flush="false"/>

	
	
	
	

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
			$(document).ready(function() {
						$(document).on("click",".result_btn",function(event) {
								
							/* $(this).attr('readonly'); */
						});
				});
			
			</script>
</body>
</html>