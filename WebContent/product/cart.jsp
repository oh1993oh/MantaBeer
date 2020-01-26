<%@page import="vo.TradeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<TradeBean> cartList = (ArrayList) request.getAttribute("cartList");
	String trade_num_list="";	
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
</head>
<body class="goto-here">


	
	
	


	<jsp:include page="/configuration/top.jsp" flush="false"/>
	<!-- END nav -->

	<div class="hero-wrap hero-bread"
      style="background-image: url(http://hhr.fhj.mybluehost.me/thebeercart/wp-content/uploads/2018/04/the-beer-cart-3793.jpg);">
      <div class="container">
         <div
            class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
               <p class="breadcrumbs">
                  <span>MANTA BEER</span>
               </p>
               <h1 class="mb-0 bread">카트</h1>
            </div>
         </div>
      </div>
   </div>

	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th>제품이름</th>
									<th>가격</th>
									<th>수량</th>
									<th>총계</th>
								</tr>
							</thead>
							<tbody>
								<%
									int j = -1;
									for (TradeBean tradeBean : cartList) {
										j++;
										String t_num = Integer.toString(tradeBean.getTrade_num());
								%>
								<tr class="text-center trade_<%= t_num%>">
									<td class="product-remove"><a onclick="cart_remove(<%= tradeBean.getTrade_num()%>)"><span
											class="ion-ios-close"></span></a>
									<input type = "hidden" name ="trade_num" value ="<%= t_num%>"/>
											</td>

									<td class="image-prod"><div class="img" style="background-image: url(images/beer/<%=tradeBean.getProduct_product_num() %>_product.jpg);"></div></td>

									<td class="product-name">
										<h3><%=tradeBean.getProduct_name()%></h3>										
									</td>

									<td class="price">
<!-- 									할인적용된가격 -->
										<span class ="pFinal_price<%= j%>"></span>원<br>
										<div style="text-decoration:line-through;">
										<span class ="product_price<%= j%>" ><%=tradeBean.getProduct_price() %></span>원
										</div>
										<span class ="product_sale<%= j%>"><%=tradeBean.getTrade_sale() %></span>%</td>

									<td class="quantity">
										<div class="input-group mb-3">
											<input type="text" name="quantity"
												class="quantity form-control input-number" value="<%=tradeBean.getTrade_quantity() %>" min="1"
												max="100">
										</div>
									</td>

									<td class="total<%= j%>">$4.90</td>
								</tr>
								<!-- END TR-->
								<%
									}
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row justify-content-end">
				<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>배송시 요구사항</h3>
						<p>기사님께 전달하실 말씀</p>
						<form action="#" class="info">
							<div class="form-group">
								<label for="">입력란</label> <input type="text"
									class="form-control text-left px-3 trade_notice" placeholder="">
							</div>
						</form>
					</div>
				</div>
				<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
					<div class="cart-total mb-3">
						<h3>장바구니 합계</h3>
						<p class="d-flex">
							<span>제품가격</span> <span class = "subtotal">$20.60</span>
						</p>
						<p class="d-flex">
							<span>배&nbsp;&nbsp;송&nbsp;&nbsp;료</span> <span class = "delivery">$0.00</span>
						</p>
						<p class="d-flex">
							<span>할인금액</span> <span class = "discount"></span>
						</p>
						<hr>
						<p class="d-flex">
							<span>총액</span> <span class = "total-price">$17.60</span>
						</p>
					</div>
					<p>
						
						
						
						
						<a href="#" class="btn btn-primary py-3 px-4" onclick ="toCheckOut();">상품 주문</a>
					</p>
				</div>
			</div>
		</div>
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
	<script src="../js/jquery-3.4.1.js"></script>
	
	<script>
		$(document).ready(function() {


			
			var quantity = 0;
			$('.quantity-right-plus').click(function(e) {

				// Stop acting like a button
				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('#quantity').val());

				// If is not undefined

				$('#quantity').val(quantity + 1);

				// Increment

			});

			$('.quantity-left-minus').click(function(e) {
				// Stop acting like a button
				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('#quantity').val());

				// If is not undefined

				// Increment
				if (quantity > 0) {
					$('#quantity').val(quantity - 1);
				}
			});

		});
		
		
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			cart_refresh();
			$('.input-number').keyup(function(){
				cart_refresh();

			});
		});	
		
		function cart_refresh(){
			var quantity = document.getElementsByName("quantity");
			var total_discount = 0;
			var subtotal = 0;
			for(var i = 0; i < quantity.length; i++){
	
				var price = $('.product_price'+i).text();
				var sale = $('.product_sale'+i).text();
				var discount = price * sale / 100;
				var pFinal_price=(price - discount);
				
				$('.pFinal_price'+i).html(pFinal_price);
				$('.total'+i).html((pFinal_price*quantity[i].value)+'원');
				
				subtotal = subtotal + (price*quantity[i].value);
				total_discount = total_discount+(discount*quantity[i].value);
				

			}
			$('.subtotal').html(subtotal+'원');
			$('.delivery').html('5000원');
			$('.discount').html(total_discount+'원');
			$('.total-price').html(subtotal+5000-total_discount+'원');
		}
		
		function cart_remove(trade_num){

			
			
			$(function()
        	{
			
				$.ajax({
		            url: 'Cart_remove.shop',
		            data: {
		            	trade_num: trade_num
		            },
		            dataType : 'json'
		        });
			
        	});
			$('.trade_'+trade_num).remove();
		}
		
	 	function toCheckOut(){
			var quantity = document.getElementsByName("quantity");
			var quantity_src = 'quantity='+quantity[0].value;
			var trade_notice = $('.trade_notice').val();
			if(trade_notice == ""){
				trade_notice="전달사항 없음.";
			}
			for(var i = 1; i < quantity.length; i++){
				quantity_src = quantity_src +','+ quantity[i].value;
			}
		
			var trade_num = document.getElementsByName("trade_num");
			var trade_num_src = trade_num[0].value;
			for(var i = 1; i < trade_num.length; i++){
				trade_num_src = trade_num_src +','+ trade_num[i].value;
			}
			


			src = 'Cart_toCheckOut.shop?'+quantity_src+'&trade_num='+trade_num_src+'&trade_notice='+trade_notice;
	
 			location.href=src;

		}
	</script>

	

</body>
</html>