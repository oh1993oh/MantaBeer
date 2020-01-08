<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sid = null;
	if (session.getAttribute("sid") != null) {
		sid = (String) session.getAttribute("sid");
	}

	int[] roomnum = {6, 6, 2, 1, 1, 1};
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>


<script type="text/javascript">
		window.onload = function() {
		    document.getElementById('reservation').onclick = function() {
		        document.getElementById('reservation').submit();
		        return false;
		    };
		};
		
		
		</script>
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
<link rel="stylesheet" href="css/Rev.css">
<!--  송진섭 -->

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">





</head>
<body class="goto-here">
<body onload="checkSession(<%=sid%>)">
	
	<jsp:include page="/configuration/top.jsp" flush="false" />

	<div class="hero-wrap hero-bread"
		style="background-image: url('./images/beer_images/예약후보1.jpg');">
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index.html">Home</a></span> <span>Blog</span>
					</p>
					<h1 class="mb-0 bread">reservation</h1>
				</div>
			</div>
		</div>
	</div>


	<div class="bg-image"
		style="background-image: url(./img/background03.jpg)"></div>

	<!-- /Backgound Image -->


	<!-- container -->

	<div class="container">

		<!-- row -->


		<!-- 	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<link rel="stylesheet"
			href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		<div>
			일자: <input type="text" id="datepicker">
		</div>
 -->	<section class="section_sestion" style="position: relative;left: 50px;">
		<section class="body_sestion">
			<div id="table-section">

				<!-- 테이블 형 예약  -->



				<!-- /reservation form -->


				<!-- opening time -->
				<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
				<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
				<link rel="stylesheet"
					href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
				<div style="float: left;width: 100%; ">
					<div class="reservation_img">
						<img src="./images/beer_images/예약 밑단3.jpg" style="width: 602px;height: 745px;">
					</div>
				
					<div class="datepiker_article">
					
						<div class="date_pi">
								<h3 style="text-align: center;">예약 일자</h3>
								<div class="datepiker">
									<input type="text" id="datepicker">
								</div>
						</div>
					</div>


				</div>

		</section>

				<!-- /row -->
		<section class="time_section">
				<div  style="height: 400px;width: 100%;">
					<div class="container-time">
						<h3 style="text-align: center;font-size: 34px;position: relative;top: 30px;left: 13px;width: 100%;">
							예약 시간</h3>

					 <div class="part_content">
						<div class="group-1">
							<span class="time-in" value="오후 6시">오후6시</span> <span
								class="time-in" value="오후 7시">오후7시</span> <span class="time-in"
								value="오후 8시">오후8시 </span>
						</div>
						<div class="group-2">
							<span class="time-in" value="오후 9시">오후9시</span> <span
								class="time-in" value="오후 10시">오후10시 </span><span
								class="time-in" value="오후 11시">오후11시</span> <span
								class="time-in" value="오후 12시">오후12시</span>

						</div>
						<div class="group-3">
							<span class="time-in" value="새벽 1시">새벽1시</span> <span
								class="time-in" value="새벽 2시">새벽2시 </span><span class="time-in"
								value="새벽 3시">새벽3시</span>
						</div>
						</div>
					</div>

				</div>
				
		</section>



		<!--  후보군 1 -->
		<!-- 
		<section>
		
		<div>
		
		<h1>방</h1>
		
		<img src="./images/print/방염장식물평면도.pdf_page_1.jpg">
		
			 <div class="container-time">
				

				<div class="group-1">
					<input type="button" id="rnum-1" class="room-in" value="1인실"> <input
						type="button" id="rnum-2" class="room-in" value="2인실"> <input
						type="button" id="rnum-3" class="room-in" value="4인실">
				</div>
				<div c>
					<input type="button" id="rnum-4" class="room-in" value="6인실"> <input
						type="button" id="rnum-5" class="room-in" value="8인실"> <input
						type="button" id="rnum-6" class="room-in" value="특실1"> <input
						type="button" id="rnum-7" class="room-in" value="특실2">
				</div>


			</div> 
		</div>	
		</section> -->
		<section id="scroll_menu">
			

		</section>


		<section id="room_dsize" style="clear: both;">

			<div class="cont">

				<div class="room_sec">

					<span class="click"></span>

					<h1 class="blind"></h1>
					<div class="container-time-room">
						<h1 style="position: relative; left: -475px;"></h1>
						<img src="./images/print/이미지 후보 2.jpg" class="img"
							style="position: inherit;">
						<!-- style은 더보기 취소했을때 씀 -->
						<div class="container-time-text">


							<div class="area_group_1">
								<div class="hidden"></div>
								<span id="rnum-11" class="room-in" value="1인실">1인실</span> <span
									id="rnum-22" class="room-in" value="2인실">2인실</span> <span
									id="rnum-33" class="room-in" value="4인실">4인실</span>
							</div>
							<div class="area_group_2">
								<span id="rnum-44" class="room-in" value="6인실">6인실</span> <span
									id="rnum-55" class="room-in" value="8인실">8인실 </span> <span
									id="rnum-66" class="room-in" value="특실1">특실1</span> <span
									id="rnum-77" class="room-in" value="특실2">특실2</span>
							</div>


						</div>

					</div>
				</div>
			</div>
			<div class="notis_area">
			  <div class="text_area">
				<h3 class="text-h">요청사항</h3>
				<textarea class="text_r" rows="23" cols="30"
					style="width: 454px;height: 300px;position: relative;"></textarea>
					</div>
			</div>
			<div class="result-area">
			<form action="Reservation_write_pro.me" id="reservation" style="width: 100%;margin: 7px;height: 90%;">
				<div class="result_h">
				
					<h3> 결과 확인</h3>
				</div>
				<table style="width: 92%;height: 80%;position: relative;left: 25px;">
					<tr>

						<td class="result_td"><p class="result_p">일자</p>
						<div class="result_input">
						 <input type="text" name="date_in" id="datepicker-info">
						 </div></td>
					</tr>
					<tr>
						<td class="result_td"><p class="result_p">시간</p> 
						<div class="result_input">
						<input type="text" name="time_in" id="date">
						</div></td>
					</tr>
					<tr>
					
						<td class="result_td"><p class="result_p">방</p>
						<div class="result_input">
						<input type="text" name="room_in" id="room">
						</div></td>
					</tr>
					<tr>
						<td class="result_td"><p class="result_p">요청사항</p>
						<div class="result_input">
						<input type="text" name="notice_in" id="notice">
						</div></td>
					</tr>

				</table>
				<section>
					<input type="submit" id="reser_click" value="다음" />
				</section>

			</form>
			</div>
		</section>
		<section style="height: 100px;">
		
		</section>

	</section>



	</div>










	<!-- <section>
			<div class="container-time">
				<h1>인원수</h1>

				<div class="group-1">
					<input type="button" class="person-in" value="1인"> <input
						type="button" class="person-in" value="2인"> <input
						type="button" class="person-in" value="4인">
				</div>
				<div class="group-2">
					<input type="button" class="person-in" value="6인"> <input
						type="button" class="person-in" value="8인"> <input
						type="button" class="person-in" value="특1"> <input
						type="button" class="person-in" value="특2">
				</div>


			</div>

		</section> -->
	<!-- <section>
			<div class="container-time">
				<h1>상품</h1>

				<div class="group-1">

					<div class="price-in" value="10000">
							<input type="checkbox" class="check_box">
						 	<label class="check_box">맥주 1</label>
						 <span class="img">
						 	 <img src="" width=""height="" alt="">
						 </span>
						<div class="none" id="b-info">
							<p>
								<span>가격</span>10,000
							</p>		
							<div class="num-atr">
								수량:<input type="text"  style="width: 20px; height: 25px;"> 
								<span class="num_up_down1">
									 <input type="button"alt="수량 증가" style="width: 23px; height: 12px;">
								</span> 
								<span class="num_up_down2"> 
									<input type="button" alt="수량 감소" style="width: 23px; height: 12px;">
								</span>
							</div>
						</div>
					</div>
					
					<div class="price-in" value="20000">
							<input type="checkbox" class="check_box">
						 	<label class="check_box">맥주 2</label>
						 <span class="img">
						 	 <img src="" width=""height="" alt="">
						 </span>
						<div class="none" id="b-info">
							<p>
								<span>가격</span>20,000
							</p>		
							<div class="num-atr">
								수량:<input type="text"  style="width: 20px; height: 25px;"> 
								<span class="num_up_down1">
									 <input type="button"alt="수량 증가" style="width: 23px; height: 12px;">
								</span> 
								<span class="num_up_down2"> 
									<input type="button" alt="수량 감소" style="width: 23px; height: 12px;">
								</span>
							</div>
						</div>
					</div>
					
					<div class="price-in" value="40000">
							<input type="checkbox" class="check_box">
						 	<label class="check_box">맥주 3</label>
						 <span class="img">
						 	 <img src="" width=""height="" alt="">
						 </span>
						<div class="none" id="b-info">
							<p>
								<span>가격</span>40,000
							</p>		
							<div class="num-atr">
								수량:<input type="text"  style="width: 20px; height: 25px;"> 
								<span class="num_up_down1">
									 <input type="button"alt="수량 증가" style="width: 23px; height: 12px;">
								</span> 
								<span class="num_up_down2"> 
									<input type="button" alt="수량 감소" style="width: 23px; height: 12px;">
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="group-2">
					<div class="price-in" value="80000">
							<input type="checkbox" class="check_box">
						 	<label class="check_box">맥주 4</label>
						 <span class="img">
						 	 <img src="" width=""height="" alt="">
						 </span>
						<div class="none" id="b-info">
							<p>
								<span>가격</span>80,000
							</p>		
							<div class="num-atr">
								수량:<input type="text"  style="width: 20px; height: 25px;"> 
								<span class="num_up_down1">
									 <input type="button"alt="수량 증가" style="width: 23px; height: 12px;">
								</span> 
								<span class="num_up_down2"> 
									<input type="button" alt="수량 감소" style="width: 23px; height: 12px;">
								</span>
							</div>
						</div>
					</div>
					
					<div class="price-in" value="100000">
							<input type="checkbox" class="check_box">
						 	<label class="check_box">맥주 5</label>
						 <span class="img">
						 	 <img src="" width=""height="" alt="">
						 </span>
						<div class="none" id="b-info">
							<p>
								<span>가격</span>100,000
							</p>		
							<div class="num-atr">
								수량:<input type="text"  style="width: 20px; height: 25px;"> 
								<span class="num_up_down1">
									 <input type="button"alt="수량 증가" style="width: 23px; height: 12px;">
								</span> 
								<span class="num_up_down2"> 
									<input type="button" alt="수량 감소" style="width: 23px; height: 12px;">
								</span>
							</div>
						</div>
					</div>
					
					<div class="price-in" value="200000">
							<input type="checkbox" class="check_box">
						 	<label class="check_box">맥주 6</label>
						 <span class="img">
						 	 <img src="" width=""height="" alt="">
						 </span>
						<div class="none" id="b-info">
							<p>
								<span>가격</span>200,000
							</p>		
							<div class="num-atr">
								수량:<input type="text"  style="width: 20px; height: 25px;"> 
								<span class="num_up_down1">
									 <input type="button"alt="수량 증가" style="width: 23px; height: 12px;">
								</span> 
								<span class="num_up_down2"> 
									<input type="button" alt="수량 감소" style="width: 23px; height: 12px;">
								</span>
							</div>
						</div>
					</div>
					
					<div class="price-in" value="400000">
							<input type="checkbox" class="check_box">
						 	<label class="check_box">맥주 7</label>
						 <span class="img">
						 	 <img src="" width=""height="" alt="">
						 </span>
						<div class="none" id="b-info">
							<p>
								<span>가격</span>400,000
							</p>		
							<div class="num-atr">
								수량:<input type="text"  style="width: 20px; height: 25px;"> 
								<span class="num_up_down1">
									 <input type="button"alt="수량 증가" style="width: 23px; height: 12px;">
								</span> 
								<span class="num_up_down2"> 
									<input type="button" alt="수량 감소" style="width: 23px; height: 12px;">
								</span>
							</div>
						</div>
					</div>
				</div>


			</div>

		</section> -->






	<!-- /container -->


	<jsp:include page="/configuration/footer.jsp" flush="false" />

	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>
	<!-- /Reservation -->


	<!-- loader -->








	<script src="./js/Time.js"></script>
	<script src="../js/jquery-3.4.1.js"></script>
	<!--  -->
	<script src="js/jquery.min.js"></script>
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
</html>