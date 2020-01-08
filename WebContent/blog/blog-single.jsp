<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.CommentBean"%>
<%@page import="vo.BlogBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int blog_num = Integer.parseInt(request.getParameter("blog_num"));
	String nowPage = (String) request.getAttribute("page");
	BlogBean article = (BlogBean) request.getAttribute("article");
	ArrayList<CommentBean> commentList = (ArrayList) request.getAttribute("commentList");
	// 	int comment_num = Integer.parseInt(request.getParameter("comment_num"));

   String sId = null;
   if (session.getAttribute("user_id") != null) {
      sId = (String) session.getAttribute("user_id");
   }

%>
<!DOCTYPE html>
<html lang="utf-8">
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
#commentForm {
	width: 900px;
	height: 100px;
	border: 1px solid #f7f6f2;
	margin: auto;
}

#comment {
	width: 600px;
}

#comment_name {
	font-weight: bold;
	font-size: 20px;
}
</style>
<script type="text/javascript">
// 	function fun1() {
// 		var a = confirm("삭제하시겠습니까?");

// 		if (a) {
// 			document.CommentUpdateDelete.action = "CommentDelete.bl";
// 			document.CommentUpdateDelete.submit();
// 		} else {
// 			return false;
// 		}
// 	}

function checkSession(sId) {
   if(sId==null){
      alert("로그인이 필요합니다");
//       location.href="#";
   }
}



	function fun2() {
		// 		window.open('CommentReply.bl',width=10,height=5);
		window.open("CommentReply.bl", "", "width=500,height=500");
	}
	function btn_click(str,commentNum) {
		if (str == "delete") {
			var a = confirm("삭제하시겠습니까?");
			if (a) {
				document.CommentUpdateDelete.action = "CommentDelete.bl?comment_num="+commentNum;
				document.CommentUpdateDelete.submit();
			} else {
				return false;
			}
		} 
		else if(str=="update") {
			document.CommentUpdateDelete.action = "CommentUpdateForm.bl?comment_num="+commentNum;
			document.CommentUpdateDelete.submit();
		}
	}
</script>
</head>
<body class="goto-here" >
	<jsp:include page="/configuration/top.jsp" flush="false"/>
	<!-- END nav -->

	<jsp:include page="/configuration/blogbanner.jsp" flush="false" />

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 ftco-animate">
					<h2 class="mb-3"><%=article.getBlog_subject()%></h2>
						<%
							if (!(article.getBlog_file() == null)) {
						%>
						<img src="./blogUpload/<%=article.getBlog_file()%>" alt=""
							width="700" height="600">
						<%
							}
						%>
				<p>
						<br><br><br>
					<%=article.getBlog_content()%>
					</p>
				</div>


				<div class="pt-5 mt-5">
					<input type="button" class="btn btn-primary py-2 px-3" value="수 정"
						onclick="location.href='BlogModifyForm.bl?blog_num=<%=article.getBlog_num()%>&page=<%=nowPage%>'">
					<input type="button" class="btn btn-primary py-2 px-3" value="삭 제"
						onclick="location.href='BlogDeleteForm.bl?blog_num=<%=article.getBlog_num()%>&page=<%=nowPage%>'">
					<input type="button" class="btn btn-primary py-2 px-3" value="목 록"
						onclick="location.href='BlogList.bl?page=<%=nowPage%>'">

					<!-- END comment-list -->


					<div class="comment-form-wrap pt-5">
						<h3 class="mb-5">Leave a comment</h3>
						<form action="BlogCommentWritePro.bl" class="p-5 bg-light">
							<div class="form-group">
								<input type="hidden" name="blog_num"
									value="<%=article.getBlog_num()%>"> 
									
						
<!-- 									<label for="name">NAME -->
<!-- 									*</label> <input type="text" class="form-control" id="name" -->
<!-- 									name="comment_name" required> -->
								
							</div>

							<div class="form-group">
								<label for="message">Message*</label>
								<textarea name="comment_content" id="message" cols="100"
									rows="5" class="form-control" required></textarea>
							</div>
							<div class="form-group">
								<input type="submit" value="확인"
									class="btn py-3 px-4 btn-primary"> <input type="reset"
									value="취소" class="btn py-3 px-4 btn-primary">
							</div>

						</form>
					</div>
					<form action="" method="post"
						name="CommentUpdateDelete">
						<%
							if (commentList != null) {
								for (int i = 0; i < commentList.size(); i++) {
						%>
						<%-- 					작성자 : <input type="text" value="<%=commentList.get(i).getComment_name()%>"><br> --%>
						<%-- 					작성일 : <input type="text" value="<%=commentList.get(i).getComment_date()%>"><br> --%>
						<%-- 					댓글 : <input type="text" value="<%=commentList.get(i).getComment_content() %>"><br> --%>
						<input type="hidden" 
						value="<%=commentList.get(i).getComment_num()%>"
							name="comment_num" id="comment_num"> <input type="hidden"
							value="<%=blog_num%>" name="comment_blog_num">
						<table border="1" id="commentForm">
							<tr>
								<td id="comment_name" name="comment_name">작성자 : <%=commentList.get(i).getComment_name()%></td>
							</tr>
							<tr>
								<td><textarea cols=100 rows=1><%=commentList.get(i).getComment_content()%></textarea><br>
<!-- 									<input type="button" value="답글" onclick="fun2()">  -->
									<%if(sId!=null) {
										if(sId.equals(commentList.get(i).getComment_name())) {%>
									<input
									type="submit" value="수정" onclick='btn_click("update","<%=commentList.get(i).getComment_num()%>");'> 
									
									<input type="submit" value="삭제" onclick='btn_click("delete","<%=commentList.get(i).getComment_num()%>");'>
									<%} }%>
								</td>
							</tr>
							<tr>
								<td><%=commentList.get(i).getComment_date()%></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
						</table>
						<%
							}
							}
						%>
					</form>

				</div>
			</div>
<!-- 			<div class="col-lg-4 sidebar ftco-animate"> -->
<!-- 				<div class="sidebar-box"> -->
<!-- 					<form action="#" class="search-form"> -->
<!-- 						<div class="form-group"> -->
<!-- 							<span class="icon ion-ios-search"></span> <input type="text" -->
<!-- 								class="form-control" placeholder="Search..."> -->
<!-- 						</div> -->
<!-- 					</form> -->
<!-- 				</div> -->
			<!-- .col-md-8 -->
				<!--             <div class="sidebar-box ftco-animate"> -->
				<!--             	<h3 class="heading">Categories</h3> -->
				<!--               <ul class="categories"> -->
				<!--                 <li><a href="#">Vegetables <span>(12)</span></a></li> -->
				<!--                 <li><a href="#">Fruits <span>(22)</span></a></li> -->
				<!--                 <li><a href="#">Juice <span>(37)</span></a></li> -->
				<!--                 <li><a href="#">Dries <span>(42)</span></a></li> -->
				<!--               </ul> -->
				<!--             </div> -->

				<!--             <div class="sidebar-box ftco-animate"> -->
				<!--               <h3 class="heading">Recent Blog</h3> -->
				<!--               <div class="block-21 mb-4 d-flex"> -->


<!-- 			</div> -->

			<!--             <div class="sidebar-box ftco-animate"> -->
			<!--               <h3 class="heading">Tag Cloud</h3> -->
			<!--               <div class="tagcloud"> -->
			<!--                 <a href="#" class="tag-cloud-link">fruits</a> -->
			<!--                 <a href="#" class="tag-cloud-link">tomatoe</a> -->
			<!--                 <a href="#" class="tag-cloud-link">mango</a> -->
			<!--                 <a href="#" class="tag-cloud-link">apple</a> -->
			<!--                 <a href="#" class="tag-cloud-link">carrots</a> -->
			<!--                 <a href="#" class="tag-cloud-link">orange</a> -->
			<!--                 <a href="#" class="tag-cloud-link">pepper</a> -->
			<!--                 <a href="#" class="tag-cloud-link">eggplant</a> -->
			<!--               </div> -->
			<!--             </div> -->

			<!--             <div class="sidebar-box ftco-animate"> -->
			<!--               <h3 class="heading">Paragraph</h3> -->
			<!--               <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ducimus itaque, autem necessitatibus voluptate quod mollitia delectus aut, sunt placeat nam vero culpa sapiente consectetur similique, inventore eos fugit cupiditate numquam!</p> -->
			<!--             </div> -->
			<!--           </div> -->

			<!--         </div> -->
			<!--       </div> -->
	</section>
	<!-- .section -->

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
