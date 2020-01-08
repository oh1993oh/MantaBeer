<%@page import="svc.ShopService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String user_id = null;
	int cartQuantity = 0;
	if (session.getAttribute("user_id") != null) {
		user_id = (String) session.getAttribute("user_id");
		ShopService shopService = new ShopService();
		cartQuantity = shopService.getCartQuantity(user_id);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="py-1 bg-primary">
		<div class="container">
			<div
				class="row no-gutters d-flex align-items-start align-items-center px-md-0">
				<div class="col-lg-12 d-block">
					<div class="row d-flex">
						<div class="col-md pr-4 d-flex topper align-items-center">
							<div
								class="icon mr-2 d-flex justify-content-center align-items-center">
								<span class="icon-phone2"></span>
							</div>
							<span class="text">[02-1111-7612]</span>
						</div>
						<div class="col-md pr-4 d-flex topper align-items-center">
							<div
								class="icon mr-2 d-flex justify-content-center align-items-center">
								<span class="icon-paper-plane"></span>
							</div>
							<span class="text">[Manta@gmail.com]</span>
						</div>
						<div
							class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
							<span class="text">[ <%
							 	if (user_id == null) {
								 %> <a href="LoginForm.me" style="color: white;">로그인</a> | <a href="UserJoinForm.me" style="color: white;">회원가입</a>
								<%
							 	} else {
								 	%> <%=user_id%>| <a href="LogoutPro.me" style="color: white;">Logout</a> <%
								 	if (user_id.equals("admin")) {
									 %> | <a href="User_list.me" style="color: white;">Admin Page</a> <%
								 	}else{
									 %> | <a href="UserlnfoFrom.me" style="color: white;">My Page</a>
									<%
								 	}
							 	}
								 %> ]
							</span>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>



	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="BeerMain.me">MANTA BEER</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a href="BeerMain.me"
						class="nav-link">Home</a></li>
					<li class="nav-item"><a href="Main.shop" class="nav-link">Shop</a></li>
					<li class="nav-item"><a href="event.jsp" class="nav-link">Event</a></li>
					<li class="nav-item"><a href="BlogList.bl" class="nav-link">Blog</a></li>
					<li class="nav-item"><a href="Reservation_write.me?" class="nav-link">Reservation</a></li>
					<li class="nav-item cta cta-colored"><a href="Cart.shop"
						class="nav-link"><span class="icon-shopping_cart"></span>[<%=cartQuantity%>]</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->
</body>
</html>