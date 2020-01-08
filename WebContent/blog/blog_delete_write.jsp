<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
    
    // 현재 세션 객체에 "sId" 세션값이 존재할 경우 String 타입 변수 sId에 저장(세션 id 가져옴)
   // String sId=null;
    //if(session.getAttribute("sId")!=null){
    //sId =(String) session.getAttribute("sId");
    //}
    int blog_num = Integer.parseInt(request.getParameter("blog_num"));
    String nowPage = request.getParameter("page");
    %>



<!DOCTYPE html>
<html lang="en">
  <head>
 <style type="text/css">
 #blog_delete_write {
		width: 500px;
		height: 610px;
 		border: 1px solid white;
		margin: auto;
	}

	#commandCell {
		text-align: center;
	}
 
 
 
 </style>
    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

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

    <jsp:include page="/configuration/blogbanner.jsp" flush="false" />
    
    
<!--    enctype="multipart/form-data"  -->
   	<section id="blog_delete_write"> 
 <form name="deleteForm" action="BlogDeletePro.bl?blog_num=<%=blog_num %>&page=<%=nowPage %>" method="post"  name="blog_delete_write">
  <table>
 
<!--   <tr> -->
<!--   <td class="td_left"><label for="board_id" class="btn btn-primary py-2 px-3">아이디</label></td> -->
<!--   <td class="td_right"><input name="board_id" type="id" id ="board_id" required="required"/></td> -->
<!--   </tr> -->
  
  <tr>
  <td class="td_left"><label for="blog_pass" class="btn btn-primary py-2 px-3">비밀번호</label></td>
  <td class="td_right"><input name="blog_pass" type="password" id ="blog_pass" required="required"/></td>
  </tr>
  </table>
  <section id="commandCell">
  
 
 <input type="submit" value="삭제" class="btn btn-primary py-2 px-3" />&nbsp;&nbsp;
 <input type="button" value="뒤로" class="btn btn-primary py-2 px-3" onclick="history.go(-1)" />

  </section>
    </form>
    </section>
    
    
    <jsp:include page="/configuration/footer.jsp" flush="false" />
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


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
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>
