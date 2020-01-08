<%@page import="sun.security.util.Length"%>
<%@page import="vo.ReViewBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="vo.BeerBean"%>
<%@page import="dao.BeerDAO"%>
<%@page import="static db.jdbcUtil.*"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="vo.ShopBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>


<%
   String nowPage = (String) request.getAttribute("page");
   ShopBean bean = (ShopBean) request.getAttribute("shopBean");
   int product_num = Integer.parseInt(request.getParameter("product_num"));
   BeerBean beerBean = (BeerBean) request.getAttribute("beerBean");
   ArrayList<ReViewBean> reviewList = (ArrayList) request.getAttribute("reviewList");
   //송진섭 추가
   ReViewBean rebean = (ReViewBean) request.getAttribute("ReViewBean");
   int price = bean.getProduct_price();
   int sale = bean.getProduct_sale();
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
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);
</style>
<script src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
   $(document).ready(function() {
      $('#taste').click(function name() {
         $(this).next().toggle('slow');
      });
   });
</script>
</head>
<body class="goto-here">
   <jsp:include page="/configuration/top.jsp" flush="false" />
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
               <h1 class="mb-0 bread">맥주</h1>
            </div>
         </div>
      </div>
   </div>

   <section class="ftco-section">
      <div class="container">
         <div class="row">
            <div class="col-lg-6 mb-5 ftco-animate">
               <a href="images/beer/<%=product_num%>_product.jpg"
                  class="image-popup"><img
                  src="images/beer/<%=product_num%>_product.jpg" class="img-fluid"
                  alt="Colorlib Template"></a>
            </div>

            <div class="col-lg-6 product-details pl-md-5 ftco-animate">
               <h3 style="font-family: 굴림; font-weight: bold;"><%=bean.getProduct_name()%></h3>
               <hr class="subject">
               <div class="review_content">
                  <p class="text-left">
                     <a href="#" class="mr-3" style="color: #000;"> <span
                        style="color: black; font-family: 굴림; font-weight: bold;">
                           간략소개<br> &nbsp;&nbsp;<%=bean.getProduct_review()%></span></a>
                  </p>
               </div>
               <hr class="subject">
               <p class="text-left mr-4">
                  <%=bean.getStar()%>
                  <%
                     for (int i = 1; i <= bean.getStar(); i++) {
                  %>
                  <a href="#"><span class="ion-ios-star"></span></a>
                  <%
                     }
                     if ((int) (bean.getStar() * 10) % 10 != 0) {
                  %><a href="#"><span class="ion-ios-star-half"></span></a>
                  <%
                     }
                  %>
               </p>

               <div class="rating d-flex">
                  <p class="text-left mr-4">
                     <a href="#" class="mr-2" style="color: #000;"> <span
                        style="color: black; font-weight: bold;"> 도수 &nbsp;&nbsp;<%=bean.getProduct_alcohol()%>°C
                     </span></a>
                  </p>
                  <p class="text-left">
                     <a href="#" class="mr-2" style="color: #000;"> <span
                        style="color: black; font-weight: bold;"> 분류 &nbsp;&nbsp;<%=bean.getProduct_category()%></span></a>
                  </p>
               </div>
               <div>
                  <script type="text/javascript"
                     src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.min.js"></script>
                  <script type="text/javascript"
                     src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
                  <canvas id="myChart" width="500" height="300"></canvas>
                  <script>
      var ctx = document.getElementById('myChart').getContext('2d');
      var data = {

         labels : [ '바디감', '목넘김', '청량감', '단맛', '향', '쓴맛' ],
         datasets : [ {
            "label" : "매니저 평가",
            data : [<%=beerBean.getBeer_body()%>,<%=beerBean.getBeer_Thirsty()%>,<%=beerBean.getBeer_Refreshing()%>,
            <%=beerBean.getBeer_sweetness()%>,<%=beerBean.getBeer_flavor()%>,<%=beerBean.getBeer_bitter()%>],
            "fill" : true,
            "backgroundColor" : "rgba(255, 99, 132, 0.2)",
            "borderColor" : "rgb(255, 99, 132)",
            "pointBackgroundColor" : "rgb(255, 99, 132)",
            "pointBorderColor" : "#fff",
            "pointHoverBackgroundColor" : "#fff",
            "pointHoverBorderColor" : "rgb(255, 99, 132)"
         } ]
      }
      var options = {
         responsive : false,
         scale : {
            angleLines : {
               display : false
            },
            ticks : {
               max: 5,
                min: 0,
                stepSize: 1.0
            }
         }
      };

      var myRadarChart = new Chart(ctx, {
         type : 'radar',
         data : data,
         options : options
      });
   </script>
               </div>

               <div class="product_ml" style="clear: both;">
                  <hr class="subject">
                  <p class="text-left mr-4">
                     <a href="#" class="mr-2" style="color: #000;"> <span
                        style="color: black; font-weight: bold;"> 용량 &nbsp;&nbsp;<%=bean.getProduct_weight()%></span></a>
                  </p>
                  <p class="text-left">
                     <a href="#" class="mr-2" style="color: #000;"> <span
                        style="color: black; font-weight: bold;"> 국가 &nbsp;&nbsp;<%=bean.getProduct_origin()%></span></a>
                  </p>
                  <p class="text-left">
                     <a href="#" class="mr-2" style="color: #000;"> <span
                        style="color: black; font-weight: bold;"> 재료 &nbsp;&nbsp;<%=bean.getProduct_material()%></span></a>
                  </p>
                  <p class="text-left">
                  <hr class="subject">
                  <a href="#" class="mr-2" style="color: #000;"> <span
                     style="color: black; font-weight: bold;"> 상세설명<br>
                        &nbsp;&nbsp;<%=bean.getProduct_content()%></span></a>
                  <hr class="subject">
                  </p>
               </div>
               
               <p class="price" style="clear: both;">
                  <span><%=(price - (int) ((double) price * (double) sale / 100))%></span>원
               </p>
               <p></p>
               <div class="row mt-4">

                  <div class="w-100"></div>
                  <div class="input-group col-md-6 d-flex mb-3">
                     <span class="input-group-btn mr-2">
                        <button type="button" class="quantity-left-minus btn"
                           data-type="minus" data-field="">
                           <i class="ion-ios-remove"></i>
                        </button>
                     </span> <input type="text" id="quantity" name="quantity"
                        class="form-control input-number" value="1" min="1" max="100">
                     <span class="input-group-btn ml-2">
                        <button type="button" class="quantity-right-plus btn"
                           data-type="plus" data-field="">
                           <i class="ion-ios-add"></i>
                        </button>
                     </span>
                  </div>
                  <div class="w-100"></div>
                  <div class="col-md-12">
                     <p style="color: #000;"></p>
                  </div>
               </div>
               <p>
                  <a href="#" onclick="Trade_OnCart()" class="btn btn-black py-3 px-5">장바구니에 추가</a>
               </p>
            </div>
         </div>
      </div>
   </section>


   <section class="container">
      <div class="review">
         <div class="insertReview">
            <form name="reviewFr" action="insertReview.shop" method="Get">
               <div class="radio_box">
                  <p style="margin: 0; width: 44px; float: left;">리뷰</p>
                  <input type="hidden" name="product_num" value="<%=product_num%>">

                  <div class="1star" style="float: left; width: 45px;">
                     <input type="hidden" class="product_num"> <input
                        type="radio" value="1" name="star" class="star" required>
                     <%
                        for (int i = 1; i <= 1; i++) {
                     %>
                     <a href="#"><span class="ion-ios-star"></span></a>
                     <%
                        }
                     %>

                  </div>

                  <div class="2star" style="float: left; width: 65px;">
                     <input type="radio" value="2" name="star" class="star">
                     <%
                        for (int i = 1; i <= 2; i++) {
                     %>
                     <a href="#"><span class="ion-ios-star"></span></a>
                     <%
                        }
                     %>

                  </div>
                  <div class="3star" style="float: left; width: 80px;">
                     <input type="radio" value="3" name="star" class="star">
                     <%
                        for (int i = 1; i <= 3; i++) {
                     %>
                     <a href="#"><span class="ion-ios-star"></span></a>
                     <%
                        }
                     %>

                  </div>
                  <div class="4star" style="float: left; width: 95px;">
                     <input type="radio" value="4" name="star" class="star">
                     <%
                        for (int i = 1; i <= 4; i++) {
                     %>
                     <a href="#"><span class="ion-ios-star"></span></a>
                     <%
                        }
                     %>

                  </div>
                  <div class="5star">
                     <input type="radio" value="5" name="star" class="star">
                     <%
                        for (int i = 1; i <= 5; i++) {
                     %>
                     <a href="#"><span class="ion-ios-star"></span></a>
                     <%
                        }
                     %>

                  </div>
               </div>
               <textarea rows="2" cols="100" id="review" class="reviewText"
                  name="review" required></textarea>
               <span class="reviewSubBtn" style="position: relative; top: -11px;">
                  <input type="submit" id="reviewSubBtn" value="댓글달기"
                  style="border: 0; background-color: black; width: 85px; border-radius: 17px; color: white; font-family: sans-serif; font-size: 1rem; height: 33px;">
               </span> <span class="reviewModBtn" style="position: relative; top: -11px;">
                  <input type="button" id="reviewModBtn" value="댓글수정"
                  onclick="reviewModPro()"
                  style="border: 0; background-color: black; width: 85px; border-radius: 17px; color: white; font-family: sans-serif; font-size: 1rem; height: 33px;">
               </span>
            </form>
         </div>
      </div>
      <div class="reviewList">
         <form class="reviewList_form"
            style="position: relative; left: -46px;">
            
            <%
            	if(reviewList.size()>0){
            %>
            <ul id="tr1" style="float: left; list-style: none;">
               <li style="width: 50px; float: left; margin: 10px;">아이디</li>
               <li style="width: 549px; float: left; margin: 10px;">상품후기</li>
               <li style="width: 90px; float: left; margin: 10px;">별점</li>
               <li style="float: left; margin: 10px;">작성일</li>

            </ul>
            <%
            	}
            	for (ReViewBean review : reviewList) {
            %>
            <ul class="review<%=review.getReview_num()%>"
               style="clear: both; list-style: none;">
               <li style="width: 50px; float: left; margin: 10px;"><%=review.getUser_id()%></li>
               <li style="width: 549px; float: left; margin: 10px;"><%=review.Review()%></li>
               <li style="width: 90px; float: left; margin: 10px;">
                  <%
                     for (int i = 1; i <= review.getStar(); i++) {
                  %> <a href="#"><span class="ion-ios-star"></span></a> <%
    }
 %>
               </li>
               <li style="float: left; margin: 10px;"><%=review.getDate()%></li>
               <li style="float: left; margin: 10px;"><input type="button"
                  class="modifyBtn" value="수정"
                  onclick="modifyReview(<%=review.getReview_num()%>)"
                  style="border: 0; background-color: black; width: 85px; border-radius: 17px; color: white; font-family: sans-serif; font-size: 1rem; height: 33px;">
                  <input type="button" class="deleteBtn" value="삭제"
                  onclick="deleteReview(<%=review.getReview_num()%>)"
                  style="border: 0; background-color: black; width: 85px; border-radius: 17px; color: white; font-family: sans-serif; font-size: 1rem; height: 33px;"></li>
            </ul>
            <%
               }
            %>
            <br> <br> <br>
         </form>
      </div>
   </section>


   <!-- //======================================================================== -->
   <!-- //======================================================================== -->
   <!-- //======================================================================== -->
   <!-- //========================제품추천======================================== -->
   <!-- //======================================================================== -->
   <!-- //======================================================================== -->
   <!-- //======================================================================== -->


   


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

   <script>
      function Trade_OnCart(){
         
         var quantity = $('.input-number').val();
         var Product_num =<%=bean.getProduct_num()%>;
         var page = <%=nowPage%>;
         location.href = 'Trade_onCart.shop?product_num='+Product_num+'&from=Main.shop&page='+page+'&quantity='+quantity;
         
      }
      function reviewModPro(){
         var review_num = $('.product_num').val();
          var reviewText = $('.reviewText').val();
          var starPoint = $(':input:radio[name=star]:checked').val();
          
         $.ajax({
            url: 'ReviewModifyPro.shop',
             data: {
                review_num : review_num,
                review : reviewText,
                star : starPoint
             },
             dataType : 'html',
              //$$확인
              success:function(msg){
                 if(msg != null){
                    //$$ 디비에서 json가져오기
                    $('.reviewSubBtn').show();
                    $('.reviewModBtn').hide();
                    location.reload();
                    
                    $('.modifyBtn').removeAttr("disabled");
                    $('.deleteBtn').removeAttr("disabled");
                    
                    
                 }else{
                    alert("본인이 작성한 리뷰만 수정하실수 있습니다.");
                 }
              }
         });
         
         
      }
    
      function modifyReview(review_num){
         $.ajax({
            url: 'ReviewModify.shop',
             data: {
                review_num : review_num
             },
             dataType : 'html',
              //$$확인
              success:function(msg){
                 msg = msg.trim();
                 if(msg == 'true'){
                    //$$ 디비에서 json가져오기,지금 else에 안걸림 null이 아니라 공백이 하나 출력되는듯 trim으로 잘라야하는데 그럼 json
                    //으로 못받을수 있음 아무튼 수정
                    $('.reviewSubBtn').hide();
                    $('.reviewModBtn').show();
                    $('.product_num').val(review_num);
                    
                    $('.modifyBtn').attr("disabled",true);
                    $('.deleteBtn').attr("disabled",true);

                    
                 }else{
                    alert("본인이 작성한 리뷰만 수정하실수 있습니다.");
                 }
              }
         });
      }
      
      function deleteReview(review_num){
         $.ajax({
            url: 'ReviewDelete.shop',
             data: {
                review_num : review_num
             },
             dataType : 'html',
              //$$확인
              success:function(msg){
                 msg = msg.trim();
                 if(msg == 'true'){
                    alert("리뷰삭제성공.");
                  $('.review'+review_num).remove();
                 }else{
                    alert("본인이 작성한 리뷰만 삭제하실수 있습니다.");
                 }
              }
         });
      }
      $(document).ready(function() {
         $('.reviewModBtn').hide();
         
         var quantitiy = 0;
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

</body>
</html>