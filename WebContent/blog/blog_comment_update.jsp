<%@page import="java.util.ArrayList"%>
<%@page import="vo.CommentBean"%>
<%@page import="vo.BlogBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

 <%
 	int comment_blog_num = Integer.parseInt(request.getParameter("comment_blog_num"));
 	//int blog_num = Integer.parseInt(request.getParameter("blog_num"));
//  	String nowPage = (String) request.getAttribute("page");
//  	BlogBean article = (BlogBean) request.getAttribute("article");
 	CommentBean comment = (CommentBean)request.getAttribute("comment");
	//ArrayList<CommentBean> commentList = (ArrayList) request.getAttribute("commentList");
 %> 
<%
	String sId = null;
	if (session.getAttribute("sId") != null) {
		sId = (String) session.getAttribute("sId");
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
</style>
<script type="text/javascript">
// 	function updateSubmit() {
// 		document.id.action="BlogList.bl";
// 		document.id.submit();
// 	}

</script>
</head>
<body onload="checkSession(<%=sId%>)">
	<!--   <body class="goto-here"> -->
	<jsp:include page="/configuration/top.jsp" flush="false"/>
	<!-- END nav -->

	<jsp:include page="/configuration/blogbanner.jsp" flush="false" />
	
	<section id="comment_Update_Form">
					<div class="comment-form-wrap pt-5">
					<!-- 댓글 수정 폼 -->
                <h3 class="mb-5">Leave a comment</h3>
                <form action="CommentUpdatePro.bl" method="post"  class="p-5 bg-light" name="commentupdatePro" >
 				<input type="hidden" name="comment_num"  value="<%=comment.getComment_num()%>" >
 				<input type="hidden" name="comment_blog_num" value="<%=comment_blog_num%>">   
                  <div class="form-group">
                    Name 
				 <input type="text" name ="comment_name" class="form-control" id="comment_name" required="required" value="<%=comment.getComment_name()%>"/> 
                  </div>
                  <div class="form-group">
                  Message 
 					<textarea id="comment_content" name="comment_content" cols="30" rows="10" class="form-control" required="required" ><%=comment.getComment_content() %>
                    </textarea>
                  </div>
                  <div class="form-group">
<%-- 	   			<input type="hidden" name="comment_num"  value="<%=comment.getComment_num() %>">   --%>
                    <input type="submit" value="수정" class="btn py-3 px-4 btn-primary">&nbsp;&nbsp;
                    <input type="button" value="뒤로" class="btn btn-primary py-2 px-3" onclick="history.back()">
				 <input type="reset"value="취소" class="btn py-3 px-4 btn-primary"> 
                  </div>
                </form>
                </div>
                </section>
<!-- 								<input type="hidden" name="blog_num" -->
<%-- 									value="<%=article.getBlog_num()%>"> <label for="name">NAME --%>
<!-- 									*</label> <input type="text" class="form-control" id="name" -->
<!-- 									name="comment_name"> -->
							<!--                   <div class="form-group"> -->
							<!--                     <label for="email">Email *</label> -->
							<!--                     <input type="email" class="form-control" id="email"> -->
							<!--                   </div> -->
							<!--                   <div class="form-group"> -->
							<!--                     <label for="website">Website</label> -->
							<!--                     <input type="url" class="form-control" id="website"> -->
							<!--                   </div> -->

<!-- 							<div class="form-group"> -->
<!-- 								<label for="message">Message</label> -->
<!-- 								<textarea name="comment_content" id="comment_content" cols="100" -->
<!-- 									rows="10" class="form-control"></textarea> -->
<!-- 							</div> -->
<!-- 							<section id="commandCell"> -->
<!-- 							<div class="form-group"> -->
<%-- 							<% if(commentList!=null) { --%>
<!-- //                for(int i=0;i<commentList.size();i++) { -->
<%--                %> --%>
<%-- 					<input type="hidden" name="comment_num" value="<%=commentList.get(i).getComment_num()%>"> --%>
<!-- 					<input type="submit" value="확인" class="btn py-3 px-4 btn-primary"> -->
<!--  					<input type="button" value="수정" class="btn py-3 px-4 btn-primary" onclick="location.href='BlogList.bl?'">  -->
<!-- 							</div> -->
<%-- 							<%  --%>
<!-- //  								String id = (String) session.getAttribute("id"); -->
<!-- // 								if (id != null) { -->
<%-- 							%>  --%>
<!-- 							<div id="update"> --> 
<!--  								<input type="button" value="수정" class="btn py-3 px-4 btn-primary" --> 
<%--  									onclick="location.href='CommentUpdateForm.bl?page=<%=nowPage%>'"> --%> 
<!--  							</div> --> 
<%--  							<%  --%>
<!-- //  								} -->
<%-- 							%> --%>

<!-- -------------------------------------------------------------------- -->
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
