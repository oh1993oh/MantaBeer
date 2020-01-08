<%@page import="java.util.ArrayList"%>
<%@page import="vo.ShopBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<ShopBean> bestList = (ArrayList) request.getAttribute("bestList");
	ArrayList<ShopBean> saleList = (ArrayList) request.getAttribute("saleList");
	ArrayList<ShopBean> newList = (ArrayList) request.getAttribute("newList");
	int cnt = 0;
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>★WorldBeerShop★ - Welcome to WorldBeerShop ~~ ♥</title>
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
<style type="text/css">
#category {
	/*     margin-top: 50px; */
	
}

.slider-item {
	background-position: 50% 25% !important;
}

.p1 {
	color: black;
	font-weight: bold;
	font-size: 20px;
}
</style>
</head>
<body class="goto-here">

	<jsp:include page="/configuration/top.jsp" flush="false" />




	<section id="home-section" class="hero">
		<div class="home-slider owl-carousel">
			<div class="slider-item"
				style="background-image: url(images/beer_bg/bg_10.jpg);">
				<div class="overlay"></div>
				<div class="container">
					<div
						class="row slider-text justify-content-center align-items-center"
						data-scrollax-parent="true">

						<div class="col-md-12 ftco-animate text-center">
							<h1 class="mb-2">MANTA BEER</h1>
							<h2 class="subheading mb-4">Love Your Life</h2>
							<p>
								<a href="Main.shop" class="btn btn-primary">Get Some Beer!</a>
							</p>
						</div>

					</div>
				</div>
			</div>

			<div class="slider-item"
				style="background-image: url(images/test7.png);">
				<div class="overlay"></div>
				<div class="container">
					<div
						class="row slider-text justify-content-center align-items-center"
						data-scrollax-parent="true">

						<div class="col-sm-12 ftco-animate text-center">
							<h1 class="mb-2">FITZ 20% sale!!</h1>
							<h2 class="subheading mb-4">슈퍼클리어 피츠</h2>
							<p>
								<a href="Detail.shop?product_num=40" class="btn btn-primary">Get
									Some Beer!</a>
							</p>
						</div>

					</div>
				</div>
			</div>
			
			<div class="slider-item"
				style="background-image: url(images/bg_9.jpg);">
				<div class="overlay"></div>
				<div class="container">
					<div
						class="row slider-text justify-content-center align-items-center"
						data-scrollax-parent="true">

						<div class="col-sm-12 ftco-animate text-center">
							<h1 class="mb-2">terra beer! &nbsp;</h1>
							<h2 class="subheading mb-4">terra beer!&nbsp;</h2>
							<p>
								<a href="Detail.shop?product_num=75" class="btn btn-primary">Get
									Some Beer!</a>
							</p>
						</div>

					</div>
				</div>
			</div>
		</div>
	</section>


	<section class="ftco-section ftco-category ftco-no-pt" id="category">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-6 order-md-last align-items-stretch d-flex">

							<div
								class="category-wrap-2 ftco-animate img align-self-stretch d-flex"
								style="background-image: url(images/beer_category/shop_img.gif);">
								<div class="text text-center">
									<h2>MANTA BEER</h2>
									<!-- <p>Protect the health of every home</p> -->
									<p>
										<a href="Main.shop" class="btn btn-primary">Shop now</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div
								class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
								style="background-image: url(images/beer_category/Ale.png);"
								onclick="location.href='Main.shop?category=에일'">
								<div class="text px-3 py-1">
									<h2 class="mb-0" style="color: white;">>보러가기</h2>
								</div>
							</div>
							<div
								class="category-wrap ftco-animate img d-flex align-items-end"
								style="background-image: url(images/beer_category/Larger.png);"
								onclick="location.href='Main.shop?category=라거'">
								<div class="text px-3 py-1">
									<h2 class="mb-0" style="color: white;">>보러가기</h2>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div
						class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
						style="background-image: url(images/beer_category/Stout.png);"
						onclick="location.href='Main.shop?category=스타우트'">
						<div class="text px-3 py-1">
							<h2 class="mb-0" style="color: white;">>보러가기</h2>
						</div>

					</div>
					<div class="category-wrap ftco-animate img d-flex align-items-end"
						style="background-image: url(images/beer_category/Weizenbier.png);"
						onclick="location.href='Main.shop?category=바이젠'">
						<div class="text px-3 py-1">
							<h2 class="mb-0" style="color: white;">>보러가기</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center mb-3 pb-3">
				<div class="col-md-12 heading-section text-center ftco-animate">
					<span class="subheading">Recommended products</span>
					<h2 class="mb-4">추천 상품</h2>
				</div>
			</div>
		</div>


		<div class="container">
			<div class="btn_new">
				<button type="button" value="back" onclick="back_best()"
					style="position: relative; top: 303px; left: -170px; outline: 0; border: 0; background: white;">
					<img src="./images/arrow/좌.png"
						style="WIDTH: 110px; height: 148px; background-color: white;">
				</button>
				<button type="button" value="next" onclick="next_best()"
					style="position: relative; top: 303px; left: 1041px; outline: 0; border: 0; background: white;">
					<img src="./images/arrow/우.png"
						style="WIDTH: 110px; height: 148px; background-color: white;">
				</button>
			</div>
			<h1>베스트</h1>
			<div class="row bestdev bestdev0">
				<%
					cnt = 0;
					for (ShopBean bb : bestList) {
						int sale = bb.getProduct_sale();
						int price = bb.getProduct_price();
						cnt++;
				%>


				<div class="col-md-6 col-lg-3 ftco-animate">
					<div class="product">
						<a href="Detail.shop?product_num=<%=bb.getProduct_num()%>"
							class="img-prod"> <img class="img-fluid"
							src="images/beer/<%=bb.getProduct_num()%>_product.jpg"
							alt="Colorlib Template"> <%
 	if (sale > 0) {
 %> <span class="status"><%=sale%>% SALE!</span> <%
 	}
 %>

							<div class="overlay"></div>
						</a>
						<div class="text py-3 pb-4 px-3 text-center">
							<h3>
								<a href="Detail.shop?product_num=<%=bb.getProduct_num()%>"><%=bb.getProduct_name()%></a>
								<br> <br> [
								<%=bb.getProduct_origin()%>
								]<br>
								<%=bb.getProduct_category()%>
							</h3>
							<div class="d-flex">
								<div class="pricing">
									<p class="price">
										<%
											if (sale > 0) {
										%>
										<span class="mr-2 price-dc"><%=price%>원</span><br> <span
											class="price-sale"><%=(price - (int) ((double) price * (double) sale / 100))%>원</span>
										<%
											} else {
										%>
										<br> <span class="price-sale"><%=price%>원</span>
										<%
											}
										%>
									</p>
								</div>
							</div>
							<div class="bottom-area d-flex px-3">
								<div class="m-auto d-flex">
									<a
										href="Trade_onCart.shop?product_num=<%=bb.getProduct_num()%>&from=Main.shop"
										class="buy-now d-flex justify-content-center align-items-center mx-1">
										<span><i class="ion-ios-cart"></i></span>

									</a> <span>장바구니</span>
								</div>
							</div>
						</div>
					</div>
				</div>


				<%
					if (cnt % 4 == 0) {
				%>

			</div>

			<%
				if (cnt != bestList.size()) {
			%>

			<div class="row bestdev bestdev<%=cnt / 4%>">
				<!-- 								style="display:none" -->
				<%
					}
				%>

				<%
					}
					}
					if (cnt % 4 != 0) {
				%>
			</div>
			<%
				}
			%>
		</div>



		<div class="container">
			<div class="btn_new">
				<button type="button" value="back" onclick="back_new()"
					style="position: relative; top: 303px; left: -170px; outline: 0; border: 0; background: white;">
					<img src="./images/arrow/좌.png"
						style="WIDTH: 110px; height: 148px; background-color: white;">
				</button>
				<button type="button" value="next" onclick="next_new()"
					style="position: relative; top: 303px; left: 1041px; outline: 0; border: 0; background: white;">
					<img src="./images/arrow/우.png"
						style="WIDTH: 110px; height: 148px; background-color: white;">
				</button>
			</div>
			<div class="subject_text">
				<h1>신상품</h1>
			</div>
			<div class="row newdev newdev0">
				<%
					cnt = 0;
					for (ShopBean nb : newList) {
						int sale = nb.getProduct_sale();
						int price = nb.getProduct_price();
						cnt++;
				%>


				<div class="col-md-6 col-lg-3 ftco-animate">
					<div class="product">
						<a href="Detail.shop?product_num=<%=nb.getProduct_num()%>"
							class="img-prod"> <img class="img-fluid"
							src="images/beer/<%=nb.getProduct_num()%>_product.jpg"
							alt="Colorlib Template"> <%
 	if (sale > 0) {
 %> <span class="status"><%=sale%>% SALE!</span> <%
 	}
 %>

							<div class="overlay"></div>
						</a>
						<div class="text py-3 pb-4 px-3 text-center">
							<h3>
								<a href="Detail.shop?product_num=<%=nb.getProduct_num()%>"><%=nb.getProduct_name()%></a>
								<br> <br> [
								<%=nb.getProduct_origin()%>
								]<br>
								<%=nb.getProduct_category()%>
							</h3>
							<div class="d-flex">
								<div class="pricing">
									<p class="price">
										<%
											if (sale > 0) {
										%>
										<span class="mr-2 price-dc"><%=price%>원</span><br> <span
											class="price-sale"><%=(price - (int) ((double) price * (double) sale / 100))%>원</span>
										<%
											} else {
										%>
										<br> <span class="price-sale"><%=price%>원</span>
										<%
											}
										%>
									</p>
								</div>
							</div>
							<div class="bottom-area d-flex px-3">
								<div class="m-auto d-flex">
									<a
										href="Trade_onCart.shop?product_num=<%=nb.getProduct_num()%>&from=Main.shop"
										class="buy-now d-flex justify-content-center align-items-center mx-1">
										<span><i class="ion-ios-cart"></i></span>

									</a> <span>장바구니</span>
								</div>
							</div>
						</div>
					</div>
				</div>


				<%
					if (cnt % 4 == 0) {
				%>

			</div>

			<%
				if (cnt != newList.size()) {
			%>

			<div class="row newdev newdev<%=cnt / 4%>">
				<%
					}
				%>

				<%
					}
					}
					if (cnt % 4 != 0) {
				%>
			</div>
			<%
				}
			%>
		</div>



		<div class="container">
		<div class="btn_new">
				<button type="button" value="back" onclick="back_sale()"style="position: relative;top: 303px;left: -170px;outline: 0;border: 0;background: white;">
						<img src="./images/arrow/좌.png" style="WIDTH: 110px;height: 148px;background-color: white;">	
				 </button>
				<button type="button" value="next" onclick="next_sale()" style="position: relative;top: 303px;left: 1041px;outline: 0;border: 0;background: white;">
						<img src="./images/arrow/우.png" style="WIDTH: 110px;height: 148px;background-color: white;">	
				</button>
			</div>
			<h1>할인전</h1>
			<div class="row saledev saledev0">
				<%
					cnt = 0;
					for (ShopBean sb : saleList) {
						int sale = sb.getProduct_sale();
						int price = sb.getProduct_price();
						cnt++;
				%>


				<div class="col-md-6 col-lg-3 ftco-animate">
					<div class="product">
						<a href="Detail.shop?product_num=<%=sb.getProduct_num()%>"
							class="img-prod"> <img class="img-fluid"
							src="images/beer/<%=sb.getProduct_num()%>_product.jpg"
							alt="Colorlib Template"> <%
 	if (sale > 0) {
 %> <span class="status"><%=sale%>% SALE!</span> <%
 	}
 %>

							<div class="overlay"></div>
						</a>
						<div class="text py-3 pb-4 px-3 text-center">
							<h3>
								<a href="Detail.shop?product_num=<%=sb.getProduct_num()%>"><%=sb.getProduct_name()%></a>
								<br> <br> [
								<%=sb.getProduct_origin()%>
								]<br>
								<%=sb.getProduct_category()%>
							</h3>
							<div class="d-flex">
								<div class="pricing">
									<p class="price">
										<%
											if (sale > 0) {
										%>
										<span class="mr-2 price-dc"><%=price%>원</span><br> <span
											class="price-sale"><%=(price - (int) ((double) price * (double) sale / 100))%>원</span>
										<%
											} else {
										%>
										<br> <span class="price-sale"><%=price%>원</span>
										<%
											}
										%>
									</p>
								</div>
							</div>
							<div class="bottom-area d-flex px-3">
								<div class="m-auto d-flex">
									<a
										href="Trade_onCart.shop?product_num=<%=sb.getProduct_num()%>&from=Main.shop"
										class="buy-now d-flex justify-content-center align-items-center mx-1">
										<span><i class="ion-ios-cart"></i></span>

									</a> <span>장바구니</span>
								</div>
							</div>
						</div>
					</div>
				</div>


				<%
					if (cnt % 4 == 0) {
				%>

			</div>

			<%
				if (cnt != saleList.size()) {
			%>

			<div class="row saledev saledev<%=cnt / 4%>">
				<%
					}
				%>

				<%
					}
					}
					if (cnt % 4 != 0) {
				%>
			</div>
			<%
				}
			%>
		</div>
	</section>

	<section class="ftco-section">
		<div class="container">
			<div class="row no-gutters ftco-services">
				<div
					class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
					<div class="media block-6 services mb-md-0 mb-4">
						<div
							class="icon bg-color-1 active d-flex justify-content-center align-items-center mb-2">
							<span class="flaticon-shipped"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">빠른 배송</h3>
							<span>전국 36시간 배송 보장</span>
						</div>
					</div>
				</div>
				<div
					class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
					<div class="media block-6 services mb-md-0 mb-4">
						<div
							class="icon bg-color-2 d-flex justify-content-center align-items-center mb-2">
							<span class="flaticon-diet"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">세계 맥주</h3>
							<span>국내 인터넷 판매 최다 품목 취급</span>
						</div>
					</div>
				</div>
				<div
					class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
					<div class="media block-6 services mb-md-0 mb-4">
						<div
							class="icon bg-color-3 d-flex justify-content-center align-items-center mb-2">
							<span class="flaticon-award"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">환경성적표지(EPD)</h3>
							<span>한국 최초 EPD획득</span>
						</div>
					</div>
				</div>
				<div
					class="col-md-3 text-center d-flex align-self-stretch ftco-animate">
					<div class="media block-6 services mb-md-0 mb-4">
						<div
							class="icon bg-color-4 d-flex justify-content-center align-items-center mb-2">
							<span class="flaticon-customer-service"></span>
						</div>
						<div class="media-body">
							<h3 class="heading">ARS 상담서비스</h3>
							<span>고객 상담센터 24시간 운영</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section img"
		style="background-image: url(images/bg_8.png);">
		<div class="container">
			<div class="row justify-content-end">
				<div
					class="col-md-6 heading-section ftco-animate deal-of-the-day ftco-animate">
					<span class="p1">국내 최대 맥주할인전</span>
					<h2 class="mb-4">주류 블랙프라이데이</h2>
					<p class="p1">BEERSHOP에서 고객님들의 사랑에 보답하겠습니다</p>
					<h3 class="p1">
						<a href="#">Blackfridays In MANTA BEER</a>
					</h3>
					<span class="p1"><a href="#" class="p1">최대 20% 할인</a></span>
					<div id="timer" class="d-flex mt-5">
						<div class="time" id="days"></div>
						<div class="time pl-3" id="hours"></div>
						<div class="time pl-3" id="minutes"></div>
						<div class="time pl-3" id="seconds"></div>
					</div>
				</div>
			</div>
		</div>
	</section>



	<hr>

	<section class="ftco-section ftco-partner">
		<div class="container">
			<div class="row">
				<div class="col-sm ftco-animate">
					<a href="#" class="partner"><img src="images/partner-1.png"
						class="img-fluid" alt="Colorlib Template"></a>
				</div>
				<div class="col-sm ftco-animate">
					<a href="#" class="partner"><img src="images/partner-2.png"
						class="img-fluid" alt="Colorlib Template"></a>
				</div>
				<div class="col-sm ftco-animate">
					<a href="#" class="partner"><img src="images/partner-3.png"
						class="img-fluid" alt="Colorlib Template"></a>
				</div>
				<div class="col-sm ftco-animate">
					<a href="#" class="partner"><img src="images/partner-4.png"
						class="img-fluid" alt="Colorlib Template"></a>
				</div>
				<div class="col-sm ftco-animate">
					<a href="#" class="partner"><img src="images/partner-5.png"
						class="img-fluid" alt="Colorlib Template"></a>
				</div>
			</div>
		</div>
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

	sadf
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

	<script src="./js/jquery-3.4.1.js"></script>
	<script type="text/javascript">
		var bestdevlen = $('.bestdev').length;
		var bestdevsel = 0;
		var newdevlen = $('.newdev').length;
		var newdevsel = 0;
		var saledevlen = $('.saledev').length;
		var saledevsel = 0;
		$(document).ready(function() {
			$('.bestdev').hide();
			$('.bestdev0').show();
			$('.newdev').hide();
			$('.newdev0').show();
			$('.saledev').hide();
			$('.saledev0').show();
		});

		function back_best() {
			bestdevsel = bestdevsel - 1;
			if (bestdevsel == -1) {
				bestdevsel = bestdevlen - 1;
			}
			$('.bestdev').hide();
			$('.bestdev' + bestdevsel).show();

		}

		function next_best() {
			bestdevsel = bestdevsel + 1;
			if (bestdevlen == bestdevsel) {
				bestdevsel = 0;
			}
			$('.bestdev').hide();
			$('.bestdev' + bestdevsel).show();
		}

		function back_new() {
			newdevsel = newdevsel - 1;
			if (newdevsel == -1) {
				newdevsel = newdevlen - 1;
			}
			$('.newdev').hide();
			$('.newdev' + newdevsel).show();

		}

		function next_new() {
			newdevsel = newdevsel + 1;
			if (newdevlen == newdevsel) {
				newdevsel = 0;
			}
			$('.newdev').hide();
			$('.newdev' + newdevsel).show();
		}

		function back_sale() {
			saledevsel = saledevsel - 1;
			if (saledevsel == -1) {
				saledevsel = saledevlen - 1;
			}
			$('.saledev').hide();
			$('.saledev' + saledevsel).show();

		}

		function next_sale() {
			saledevsel = saledevsel + 1;
			if (saledevlen == saledevsel) {
				saledevsel = 0;
			}
			$('.saledev').hide();
			$('.saledev' + saledevsel).show();
		}
	</script>

</body>
</html>