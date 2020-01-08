<%@page import="vo.TradeBean"%>
<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%
	ArrayList<TradeBean> getdepositdetailList = (ArrayList) request.getAttribute("getdepositdetailList");
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

	<div class="hero-wrap hero-bread"
		style="background-image: url('images/bg_1.jpg');">
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<p class="breadcrumbs">
<<<<<<< HEAD
						<span class="mr-2"><a href="BeerMain.me">Home</a></span> <span>About
=======
						<span class="mr-2"><a href="index.html">Home</a></span> <span>About
>>>>>>> branch 'master' of https://github.com/oh1993oh/MantaBeer.git
							us</span>
					</p>
					<h1 class="mb-0 bread">제품 상세 페이지</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- END top 손대면 안됨! -->
	<section class="container">
		<!--  카테고리 인클루드 -->
		<jsp:include page="/configuration/managerpage.jsp" flush="false" />
		
		
		<br style="clear: both;">
		<div class="table_list" style="position: relative;left: 68px; top: 30px;">
			<div class="ul_list" style="width: 1028px;height: 45px;border-top: 1px solid gray;border-left: 1px solid gray;">
				<ul style="list-style: none;">
					<li style="float: left;width: 107px;height: 45px;padding: 10px 0;border-right: 1px solid gray;">주문 일자</li>
					<li style="float: left;width: 149px;padding: 10px 0;border-right: 1px solid gray;text-align: center;">
						이름
					</li>
					<li style="float: left;width: 95px;padding: 10px 0;border-right: 1px solid gray;text-align: center;">
						갯수
					</li>
					<li style="float: left;width: 120px;padding: 10px 0;border-right: 1px solid gray;text-align: center;">
						금액
					</li>
					<li style="float: left;width: 95px;padding: 10px 0;border-right: 1px solid gray;text-align: center;">
						할인율
					</li>
					<li style="float: left;width: 421px;padding: 10px 0;border-right: 1px solid gray;text-align: center;">
						배송지
					</li>
				</ul>
			</div>
			<%
				for (TradeBean tb : getdepositdetailList) {
			%>
			<div  style="clear: both;" class="table_rable">

					<div class="td_admin" style="float: left;width: 148px;border-left: 1px solid gray;
												 border-top: 1px solid gray;border-bottom: 1px solid gray;position: relative;top: -2px;margin: px;">
						<span><%=tb.getTrade_date()%></span>
					</div>
					<div class="td_admin" style="float: left;width: 149px;border-left: 1px solid gray;
												 border-top: 1px solid gray;border-bottom: 1px solid gray;position: relative;top: -2px;left: -1px;">
						<span><%=tb.getProduct_name()%></span>
					</div>
					<div class="td_admin" style="float: left;width: 95px;position: relative;top: -2px; text-align:right;
											     left: -1px;border-left: 1px solid gray;border-top: 1px solid gray;border-bottom: 1px solid gray;">
						<span  class="td_quantity"><%=tb.getTrade_quantity()%></span><span>개</span>
					</div>
					<div class="td_price" style="float: left;width: 120px;position: relative;top: -2px; text-align:right;
											     left: -1px;border-left: 1px solid gray;border-top: 1px solid gray;border-bottom: 1px solid gray;">
						<span class="td_price1" ><%=tb.getTotalprice()%></span><span>원</span>
					</div>
					<div class="td_admin"
						style="float: left;width: 95px;position: relative;top: -2px;left: -1px; text-align:right;
							   border-left: 1px solid gray;border-top: 1px solid gray;border-bottom: 1px solid gray;">
						<span class="td_persent">
						 <%=tb.getTrade_sale()%>
						</span><span>%</span>
					</div>	
					<div class="td_admin" style="float: left;width: 422px;position: relative;top: -2px;
												 left: -1px;border: 1px solid gray;">
						<span><%=tb.getAdress()%></span>
					</div>


				<%
					}
				%>
			</div>
		</div>



	</section>

	<section style="clear: both; position: relative; top: 100px;">


		<div class="container">
			<div class="row justify-content-end">
				
				<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>주문 합계</h3>
						<p class="d-flex">
							<span>제품가격</span> <span class="price1"></span>
						</p>
						<p class="d-flex">
							<span>배&nbsp;&nbsp;송&nbsp;&nbsp;료</span> <span class = "delivery">5000 원</span>
						</p>
						<p class="d-flex">
							<span>할인금액</span> <span class = "discount"></span>
						</p>
						<hr>
						<p class="d-flex">
							<span>총액</span> <span class="total-price">$17.60</span>
						</p>
					</div>
				</div>
			</div>

		</div>


	</section>



	<section  class="bottom" style="height: 200px;"></section>

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
	<script type="text/javascript">
		$(document).ready(function() {
			
			var size=$('.table_rable').size();
			var totalprice=0
			var totalproduct= 0
			var totalsale=0
			for(var i=0; i<size; i++) {
				var	price=Number($('.td_price1').eq(i).text());
			    totalproduct = totalproduct+price//물품 총 액
			    var sale =Number($('.td_persent').eq(i).text());
			    var quantity =Number($('.td_quantity').eq(i).text());
			    
				var rowsale = price-( price*(sale/1000) )
			  	totalsale = totalsale+rowsale
				
			
			  
			


			  	
				var  total =  price-( price*sale )//할인액
			  	
				
				totalprice = totalprice+total //할인 총액
			   // alert(totalprice)
			   
			}
				
			
			var total = 0;
			var quantity = 0;
			var persent = 0;
			$('.td_price1').each(function(index, item) {
				var price = Number(item.textContent);
				
				total = total + price
				
			});
			$('.td_quantity').each(function(index,q){
				var quan = Number(q.textContent);
				quantity = quantity + quan
				//alert(quantity);
			});
			$('.td_persent').each(function(index,q){
				var per = Number(q.textContent);
				//alert(per);
				//persent = per + quan
				//alert(quantity);
			});
			
			$('.price1').html(totalproduct +"원");
			$('.total-price').html(totalprice+5000 +"원");
			$('.discount').html(totalsale +"원");
			discount
			//td_persent
		});
	</script>


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