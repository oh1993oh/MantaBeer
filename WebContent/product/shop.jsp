<%@page import="vo.ShopBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.PageInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%
   ArrayList<ShopBean> articleList = (ArrayList) request.getAttribute("articleList");
   PageInfo pageinfo = (PageInfo) request.getAttribute("pageInfo");
   int nowPage = pageinfo.getPage();
   int maxPage = pageinfo.getMaxPage();
   int startPage = pageinfo.getStartPage();
   int endPage = pageinfo.getEndPage();
   int listCount = pageinfo.getListCount();
   
   String category = request.getParameter("category");
   String origin = request.getParameter("origin");
   
   String extraHref = "";
   
   if(category != null){
      extraHref = extraHref + "&category="+category;
   }else if(origin != null){
      extraHref = extraHref + "&origin="+origin;
   }
   
//    session.setAttribute("user_id", "first");
   
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

<style type="text/css">
.scrollax-performance, .scrollax-performance *, .scrollax-performance *:before,
   .scrollax-performance *:after {
   pointer-events: none !important;
   -webkit-animation-play-state: paused !important;
   animation-play-state: paused !important;
}

;
.menu a {
   cursor: pointer;
}

.menu .hide {
   display: none;
}
</style>

<script type="text/javascript" charset="UTF-8"
   src="https://maps.googleapis.com/maps-api-v3/api/js/38/10/intl/ko_ALL/common.js"></script>
<script type="text/javascript" charset="UTF-8"
   src="https://maps.googleapis.com/maps-api-v3/api/js/38/10/intl/ko_ALL/util.js"></script>
</head>
<script type="text/javascript">
   $(document).ready(function() {
      $(".menu>a").click(function() {
         var submenu = $(this).next("ul");

         // submenu 가 화면상에 보일때는 위로 보드랍게 접고 아니면 아래로 보드랍게 펼치기
         if (submenu.is(":visible")) {
            submenu.slideUp();
         } else {
            submenu.slideDown();
         }
      }).mouseover(function() {
         $(this).next("ul").slideDown();
      });
   });
</script>

</head>
<body class="goto-here">


   <jsp:include page="/configuration/top.jsp" flush="false"/>
   <!-- END nav -->
   <div class="hero-wrap hero-bread"
      style="background-image: url('images/beer_bg/shop_bg.jpg');">
      <div class="container">
         <div
            class="row no-gutters slider-text align-items-center justify-content-center">
            <div class="col-md-9 ftco-animate text-center">
               <p class="breadcrumbs">
                  <span>MANTA BEER</span>
               </p>
               <h1 class="mb-0 bread">상품 목록</h1>
            </div>
         </div>
      </div>
   </div>


   <!--    상품목록 -->

   <section class="ftco-section">
      <div class="container">
          <div class="row justify-content-center">
            <div class="col-md-10 mb-5 text-center">
                <ul class="product-category">
                   <li><a href="#" class="active">맥주타입</a></li>
                   <li><a href="Main.shop?category=에일">에일맥주</a></li>
                   <li><a href="Main.shop?category=라거">라거맥주</a></li>
                   <li><a href="Main.shop?category=스타우트">스타우트맥주</a></li>
                   <li><a href="Main.shop?category=바이젠">밀맥주</a></li>
                </ul>
             </div>
             <div class="col-md-10 mb-5 text-center">
                <ul class="product-category"  style="top: -23px;position: relative;right: 34px;">
                   <li><a href="#" class="active">세계맥주</a></li>
                   <li><a onclick="click_asia()" style="cursor:pointer">아시아</a></li>
                   <li><a onclick="click_europe()" style="cursor:pointer">유럽</a></li>
                   <li><a onclick="click_america()" style="cursor:pointer">아메리카</a></li>
                   <li><a onclick="click_etc()" style="cursor:pointer">기타국가</a></li>
                </ul>
             </div>
             <div class="col-md-10 mb-5 text-center asia_menu">
                <ul class="product-category">
                   <li style="position: relative; top: -65px; left: -55px;"><a href='Main.shop?origin=대한민국'>한국</a></li>
                  <li style="position: relative; top: -65px; left: -55px;"><a href='Main.shop?origin=일본'>일본</a></li>
                  <li style="position: relative; top: -65px; left: -55px;"><a href='Main.shop?origin=중국'>중국</a></li>
                </ul>
             </div>
             <div class="col-md-10 mb-5 text-center europe_menu">
                <ul class="product-category">
                   <li style="position: relative; top: -65px; left: 110px;"><a href='Main.shop?origin=체코'>체코</a></li>
                  <li style="position: relative; top: -65px; left: 110px;"><a href='Main.shop?origin=리투아니아'>리투아니아</a></li>
                  <li style="position: relative; top: -65px;left: 110px;"><a href='Main.shop?origin=네덜란드'>네덜란드</a></li>
                  <li style="position: relative; top:-65px;left: 110px;"><a href='Main.shop?origin=벨기에'>벨기에</a></li>
                  <li style="position: relative; top:-65px;left: 110px;"><a href='Main.shop?origin=독일'>독일</a></li>
                  <li style="position: relative; top: -65px;left: 110px;"><a href='Main.shop?origin=스웨덴'>스웨덴</a></li>
                </ul>
             </div>
             <div class="col-md-10 mb-5 text-center america_menu">
                <ul class="product-category">
                   <li style="position: relative; top: -65px;left: -86px;"><a href='Main.shop?origin=미국'>미국</a></li>
                  <li style="position: relative; top: -65px;left: -86px;"><a href='Main.shop?origin=캐나다'>캐나다</a></li>
                </ul>
             </div>
             <div class="col-md-10 mb-5 text-center etc_menu">
                <ul class="product-category">
                   <li style="position: relative; top: -65px;left: -120px;"><a href='Main.shop?origin=기타국가'>기타국가</a></li>
                </ul>
             </div>
             
             
             
          </div>
      
      
      
      
<!--          <div class="row justify-content-center"> -->
<!--             <div class="col-md-10 mb-5 text-center"> -->
<!--                <ul class="product-category"> -->
<!--                   <li class="menu"><a href="Main.shop" class="active">종합</a></li> -->
<!--                   <li class="menu"><a href="#" class="active">아시아</a> -->
<!--                      <ul class="hide"> -->
<!--                         <li><a href='Main.shop?origin=대한민국'>한국</a></li> -->
<!--                         <li><a href='Main.shop?origin=일본'>일본</a></li> -->
<!--                         <li><a href='Main.shop?origin=중국'>중국</a></li> -->
<!--                      </ul></li> -->
<!--                   <li class="menu"><a href="#" class="active">유럽</a> -->
<!--                      <ul class="hide"> -->
<!--                         <li><a href='Main.shop?origin=체코'>체코</a></li> -->
<!--                         <li><a href='Main.shop?origin=리투아니아'>리투아니아</a></li> -->
<!--                         <li><a href='Main.shop?origin=네덜란드'>네덜란드</a></li> -->
<!--                         <li><a href='Main.shop?origin=벨기에'>벨기에</a></li> -->
<!--                         <li><a href='Main.shop?origin=독일'>독일</a></li> -->
<!--                         <li><a href='Main.shop?origin=스웨덴'>스웨덴</a></li> -->
<!--                      </ul></li> -->
<!--                   <li class="menu"><a href="#" class="active">아메리카</a> -->
<!--                      <ul class="hide"> -->
<!--                         <li><a href='Main.shop?origin=미국'>미국</a></li> -->
<!--                         <li><a href='Main.shop?origin=캐나다'>캐나다</a></li> -->
<!--                      </ul></li> -->
<!--                   <li class="menu"><a href="#" class="active">기타국가</a> -->
<!--                      <ul class="hide"> -->
<!--                         <li><a href='Main.shop?origin=기타국가'>기타국가</a></li> -->
<!--                      </ul></li> -->
                     
<!--                   라거맥주/ -->
<!--                   페일맥주/ -->
<!--                   바이젠맥주/ -->
<!--                   필스너맥주/ -->
<!--                   에일맥주/ -->
<!--                   브라운에일맥주/ -->
<!--                   스트롱에일맥주/ -->
<!--                   아메리칸엠버에일맥주/ -->
<!--                   인디아페일에일맥주/ -->
<!--                   페일에일맥주/ -->
<!--                   발포주/ -->
<!--                   둔켈맥주/ -->
<!--                   포터맥주/ -->
<!--                   스타우트맥주 -->
<!--                </ul> -->
<!--             </div> -->
<!--          </div> -->

         <!--          캘린더형상품 -->
         <div class="row">
            <%
               for (ShopBean bean : articleList) {
                  int price = bean.getProduct_price();
                  int sale = bean.getProduct_sale();
            %>
            <div class="col-md-6 col-lg-3 ftco-animate">
               <div class="product">
                  <a href="Detail.shop?product_num=<%=bean.getProduct_num()%>&page=<%=nowPage%>" class="img-prod">
                  <img class="img-fluid"
                     src="images/beer/<%=bean.getProduct_num() %>_product.jpg" alt="Colorlib Template"> 
                     
                     <% 
                        if(sale>0){
                     %>
                           <span class="status"><%= sale%>% SALE!</span>
                     <%
                        }
                     %>
   
                  <div class="overlay"></div> </a>
                  <div class="text py-3 pb-4 px-3 text-center">
                     <h3>
                        <a href="Detail.shop?product_num=<%=bean.getProduct_num()%>&page=<%=nowPage%>"><%=bean.getProduct_name()%></a>
                        <br><br>
                        [ <%=bean.getProduct_origin()%> ]<br>
                        <%=bean.getProduct_category()%>
                     </h3>
                     <div class="d-flex">
                        <div class="pricing">
                           <p class="price">
                              <% 
                                 if(sale>0){
                              %>
                                    <span class="mr-2 price-dc"><%=price%>원</span><br>
                                    <span class="price-sale"><%=(price-(int)((double)price*(double)sale/100))%>원</span>
                              <%
                                 } else {
                              %>
                                    <br>
                                    <span class="price-sale"><%=price%>원</span>
                              <%
                                 }
                              %>
                           </p>
                        </div>
                     </div>
                     <div class="bottom-area d-flex px-3">
                        <div class="m-auto d-flex">
                           <a href="Trade_onCart.shop?product_num=<%=bean.getProduct_num()%>&from=Main.shop&page=<%=nowPage %>"
                              class="buy-now d-flex justify-content-center align-items-center mx-1">
                              <span><i class="ion-ios-cart"></i></span>
                              
                           </a>
                           <span>장바구니</span>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <%
               }
            %>
         </div>
         <div class="row mt-5">
            <div class="col text-center">
               <div class="block-27">
                  <ul>
                     <%
                        if (nowPage <= 1) {
                     %>
                     <li><a>&lt;</a></li>
                     <%
                        } else {
                     %>
                     <li><a href="Main.shop?page=<%=nowPage - 1%><%=extraHref%>">&lt;</a></li>
                     <%
                        }
                     %>


                     <%
                        for (int a = startPage; a <= endPage; a++) {
                           if (a == nowPage) {
                     %>
                     <li class="active"><span><%=a%></span></li>
                     <%
                        } else {
                     %>
                     <li><a href="Main.shop?page=<%=a%><%=extraHref%>"><%=a%> </a></li>
                     <%
                        }
                     %>
                     <%
                        }
                     %>

                     <%
                        if (nowPage >= maxPage) {
                     %>
                     <li><a>&gt;</a></li>
                     <%
                        } else {
                     %>
                     <li><a href="Main.shop?page=<%=nowPage + 1%><%=extraHref%>">&gt;</a></li>
                     <%
                        }
                     %>

                  </ul>
               </div>
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
   <script type="text/javascript">
      $(document).ready(function() {
         $('.asia_menu').hide();
         $('.europe_menu').hide();
         $('.america_menu').hide();
         $('.etc_menu').hide();
      });   
      
      function click_asia(){
         $('.asia_menu').show();
         $('.europe_menu').hide();
         $('.america_menu').hide();
         $('.etc_menu').hide();
      }
      
      function click_europe(){
         $('.asia_menu').hide();
         $('.europe_menu').show();
         $('.america_menu').hide();
         $('.etc_menu').hide();
      }
      
      function click_america(){
         $('.asia_menu').hide();
         $('.europe_menu').hide();
         $('.america_menu').show();
         $('.etc_menu').hide();
      }
      
      function click_etc(){
         $('.asia_menu').hide();
         $('.europe_menu').hide();
         $('.america_menu').hide();
         $('.etc_menu').show();
      }
      
      

      
   </script>
   

</body>
</html>