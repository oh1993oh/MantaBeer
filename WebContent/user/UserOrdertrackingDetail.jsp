<%@page import="java.util.ArrayList"%>
<%@page import="vo.TradeBean"%>
<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserBean user = (UserBean) request.getAttribute("user_id");
	ArrayList<TradeBean> list = (ArrayList) request.getAttribute("usergetdepositdetailList");
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
	<jsp:include page="/configuration/top.jsp" flush="false" />
	<!-- END nav -->


	<jsp:include page="/configuration/mypageBenner.jsp" flush="false"/>
	<!-- END top 손대면 안됨! -->
	
	
	
	
	<section class="container" style="height: 500px;">
		<!--  카테고리 인클루드 -->
		<jsp:include page="/configuration/mypage_left.jsp" flush="false" />
		<div style="float: right;width: 70%;">
			<div class="label_content"
				style="text-align: center; font-size: 40px; font-weight: bold; color: black;">
				<p style="clear: both; width: 270px; position: relative;left: 32px;top: 15px;">주문 상세 내역</p>


			</div>
		
		<div>
			<div style="position: relative;right: 31px;width: 555px; border: 1px solid gray;">
				<div style="float: left;width: 100px; height: 25px; border-bottom: 1px solid gray; border-right: 1px solid gray;">주문자</div>
				<div style="position: relative;width: 454px;left: 100px;border-bottom: 1px solid gray;height: 25px;"><span id="name_in" style="clear: both;"></span></div>
				<div style="float: left;width: 100px; height: 25px; border-bottom: 1px solid gray; border-right: 1px solid gray;">주문번호</div>
				<div style="position: relative;width: 454px;left: 100px;border-bottom: 1px solid gray;height: 25px;"><span id="classification_in" style="clear: both;"></span></div>
				<div style="float: left;width: 100px; height: 25px; border-right: 1px solid gray;">주소</div>
				<div style="position: relative;width: 454px;left: 100px;"><span id="Adress_in" style="clear: both;"></span></div>
			</div>
		</div>	




			<br>
			<div class="table_list">
				<div class="ul_list"
					style="clear: both; position: relative; left: -30px; border: 1px solid gray; height: 30px; width: 567px;">
					<ul style="list-style: none;">
						<li
							style="float: left;width: 85px;position: relative;right: 20px;border-right: 1px solid gray;">주문
							일자</li>
						
						<li
							style="float: left;width: 138px;text-align: center;border-right: 1px solid gray;">제품이름
						</li>
						<li
							style="float: left;width: 75px;text-align: center;border-right: 1px solid gray;">갯수
						</li>
						<li
							style="float: left; width: 110px; text-align: center; border-right: 1px solid gray;">할인
						</li>
						<li
							style="float: left; width: 117px; text-align: center;">금액</li>
					</ul>
				</div>
				<%
					for (TradeBean tb : list) {
				%>
				<div style="clear: both;" class="table_rable">

					<div class="td_admin"
						style="float: left;width: 106px;border-left: 1px solid gray;border-top: 1px solid gray;border-bottom: 1px solid gray;position: relative;top: 5px;right: 30px;">
						<span><%=tb.getTrade_date()%></span>
					</div>
					<div class="td_admin"
						style="float: left;width: 158px;border-left: 1px solid gray;border-top: 1px solid gray;border-bottom: 1px solid gray;position: relative;top: 5px;right: 30px;">
						<span><%=tb.getProduct_name()%></span>
					</div>
					<div class="td_admin"
						style="float: left;width: 74px;position: relative;top: 5px;right: 30px;text-align: right;border-left: 1px solid gray;border-top: 1px solid gray;border-bottom: 1px solid gray;">
						<span class="td_quantity"><%=tb.getTrade_quantity()%></span><span>개</span>
					</div>
					<div class="td_admin"
						style="float: left;width: 110px;position: relative;top: 5px;right: 30px;text-align: right;border-left: 1px solid gray;border-top: 1px solid gray;border-bottom: 1px solid gray;">
						<span class="td_persent"> <%=tb.getTrade_sale()%>
						</span><span>%</span>
					</div>
					<div class="td_price"
						style="float: left; width: 120px; position: relative; top: 5px;right: 30px;text-align: right;  border: 1px solid gray;">
						<span class="td_price1"><%=tb.getTotalprice()%></span><span>원</span>
					</div>
					<input type="hidden" class="name" value='<%=tb.getUser_name()%>'>
					<input type="hidden" class="classification"
						value='<%=tb.getTrade_classification()%>'> <input
						type="hidden" class="Adress" value='<%=tb.getAdress()%>'>


					<%
						}
					%>
				</div>



			</div>

		</div>
	</section>
	
	<section style="height: 100px;">
	
	</section>



	<jsp:include page="/configuration/footer.jsp" flush="false" />

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>



	<!--  -->
	
			
			
	</script>
	<script src="js/jquery.min.js"></script>
	<!--송진섭  -->
	<script src="js/btn.js"></script>
	<script src="js/jquery-3.4.1.js"></script>
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
							 	$(this).val("입금확인완료"); 
							/* $(this).attr('readonly'); */
						});
				});
			
			</script>
	<script type="text/javascript">
		$(document).ready(function() {
	
			
			var size=$('.table_rable').size();
			var totalprice=0
			var totalproduct= 0
			var totalsale=0
			var name=0
			var classification=0
			var Adress=0
			for(var i=0; i<size; i++) {
				var	price=Number($('.td_price1').eq(i).text());
			    totalproduct = totalproduct+price//물품 총 액
			    var sale =Number($('.td_persent').eq(i).text());
			    var quantity =Number($('.td_quantity').eq(i).text());
			   
			    
				var rowsale = price-( price*(sale/1000) )
			  	totalsale = totalsale+rowsale
				
			  	
				name = $('.name').eq(i).val();
				classification=$('.classification').eq(i).val();
				Adress=$('.Adress').eq(i).val();
				
				
				
			
			  
			


			  	
				var  total =  price-( price*sale )//할인액
			  	
				
				totalprice = totalprice+total //할인 총액
				
				}
			$('#name_in').html(name);
			$('#classification_in').html(classification);
			$('#Adress_in').html(Adress);
			
			});
		
		
			
			/* $('.classification_in').innerHTML(classification);
			$('.Adress_in').innerHTML(Adress); */
			</script>
			
			
</body>
</html>