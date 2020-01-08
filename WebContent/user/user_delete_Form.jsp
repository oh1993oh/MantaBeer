<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserBean user = (UserBean) request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
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


	<jsp:include page="/configuration/mypageBenner.jsp" flush="false"/>
	<!-- END top 손대면 안됨! -->

<div class="container">
	<div class="letfno1">
		<jsp:include page="/configuration/mypage_left.jsp" flush="false"/>



	</div>

	<div class="letfno2">
      <div class="top_main">
		<p>☆ 회원 탈퇴 ☆</p>
	  </div>
		<form action="UserdeletePro.me" method="post" style="width: 450px;">
			<div class="mypage"><label class="name_w">◆ 아이디</label> 
			<input type="text" name="user_id" class="id" value=<%=user.getUser_id()%> readonly><br>
			<!-- <input type="button" value="ID중복확인" class="dup"><br> -->
			</div>
			<div class="mypage">
			<label class="name_w">◆ 비밀번호 :</label>
			 <input type="password" name="user_pass"><br>
			</div>
			<div class="mypage">
			<label class="name_w">◆ 성명 :</label>
			 <input type="text" name="user_name" value=<%=user.getUser_name()%> readonly><br> 
			</div>
			<div class="mypage">
				<input type="submit" class="btn_bottom" value="탈퇴 완료 하기">
				<input type="reset" class="btn_bottom" value="재입력하기" >
			</div>
			 
			  
		</form>


	</div>



</div>

















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