<%@page import="vo.PageInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.BlogBean"%>
<%@page import="dao.BlogDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
ArrayList<BlogBean> searchList = (ArrayList) request.getAttribute("searchList");
ArrayList<BlogBean> articleListRe = (ArrayList) request.getAttribute("articleListRe");
PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
// "pageInfo" 객체로부터 페이지 관련 값들을 꺼내서 변수에 저장
int nowPage = pageInfo.getPage();
int maxPage = pageInfo.getMaxPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();
int listCount = pageInfo.getListCount();
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
.float {
   float: right;
   /* width:45% !important; */
}
footer {
   clear: both;
}

#content{
   margin-right: 60px;
}

#picture{
    margin-right: 200px; 
   padding-right: 200px;
   padding-left: 200px;
}
.block-27 {
	position: relative;
	margin-left: 425px;
	align-content: center;
}

</style>
</head>
<body class="goto-here">

   <jsp:include page="/configuration/top.jsp" flush="false"/>
   <!-- END nav -->

  <jsp:include page="/configuration/blogbanner.jsp" flush="false" />
  
   <div class="col-lg-3 sidebar ftco-animate float" style="margin-right: 200px;">
      <div class="sidebar-box">
         <form action="BlogSearch.bl" method="get" class="search-form">
            <div class="form-group">
               <span class="icon ion-ios-search"></span> <input type="text"
                  name="search" class="form-control" placeholder="Search...">
            </div>
            <span></span> <span></span> <br>
         </form>
         <!--          </div> -->

         <p>
            <a href="BlogWriteForm.bl" class="btn btn-primary py-2 px-3"
               id="write_btn">블로그에 글 올리기</a>
         </p>
         
         
      </div>


     <div class="sidebar-box ftco-animate">
         <h3 class="heading">Recent Blog</h3>
         <%
            if (articleListRe != null && listCount > 0) {
//             	int i;
               for (int i = 0; i < articleListRe.size(); i++) {
//                   if (i == 3) {
//                      break;
//                   }
         %>
         <div class="block-21 mb-4 d-flex">
            <!--                 <a class="blog-img mr-4" style="background-image: url(images/image_1.jpg);"></a> -->
            <a
               href="BlogDetail.bl?blog_num=<%=articleListRe.get(i).getBlog_num()%>&page=<%=nowPage%>"><img
               src="./blogUpload/<%=articleListRe.get(i).getBlog_file()%>" alt=""
               width="100" height="100"></a>
            <div class="text">
               <h3 class="heading-1">
                  <a href="BlogDetail.bl?blog_num=<%=articleListRe.get(i).getBlog_num()%>&page=<%=nowPage%>"><%=articleListRe.get(i).getBlog_subject()%></a>
               </h3>
               <div class="meta">
                  <div>
                     <a href="BlogDetail.bl?blog_num=<%=articleListRe.get(i).getBlog_num()%>&page=<%=nowPage%>"><span class="icon-calendar"></span><%=articleListRe.get(i).getBlog_date()%></a>
                  </div>
                  <div>
                     <a href=""><span class="icon-person"></span> Admin</a>
                  </div>
                  <div>
                     <a href=""><span class="icon-chat"></span><%=articleListRe.get(i).getReadcount()%></a>
                  </div>
               </div>
            </div>
         </div>
         <%
               
            }
            }
         %>
      </div>
      <div class="sidebar-box ftco-animate">
         <h3 class="heading">세계인의 맥주 축제</h3>
         <form>
            <ul>
               <li><a href=" http://sapporo-natsu.com/english/">삿포로 오도리
                     비어가든</a></li>
               <li><a
                  href=" http://www.thatsqingdao.com/qingdao-international-beer-festival/">
                     청도 맥주 축제</a></li>
               <li><a href=" http://www.oktoberfest.de"> 옥토버 페스트</a></li>
               <li><a href=" http://www.pilsnerfest.cz/"> 체코 필스너 페스트</a></li>
               <li><a href="http://www.hrbicesnow.com/beer"> 하얼빈 국제 맥주 축제</a></li>
            </ul>
         </form>
      </div>
   </div>
   <div class="float" id="content">
      <section class="ftco-section ftco-degree-bg">
         <div class="container">
            <div class="row">
               <div class="col-lg-8 ftco-animate">
      <%
         if (searchList != null && listCount > 0) {
            for (int i = 0; i < searchList.size(); i++) {
      %>
                  <div class="row" id="picture">
                     <div class="text d-block pl-md-4">
                        <div class="meta mb-3">

                           <%--                         <%=articleList.get(i).getBlog_file() %> --%>
                           <span><%=searchList.get(i).getBlog_date()%></span> <span>
                              <a href="">Admin</a>
                           </span> <span> <a href="" class="meta-chat"><span
                                 class="icon-chat"><%=searchList.get(i).getReadcount()%></span></a>
                           </span>
                        </div>
                                    <h3 class="heading">
                        <%=searchList.get(i).getBlog_subject()%>
                                    </h3>      
                        <img src="./blogUpload/<%=searchList.get(i).getBlog_file()%>"
                           alt="" width="300" height="200">
<%--                       <%=articleList.get(i).getBlog_content()%> --%>
                       
                                 
                        <p>
                           <a
                              href="BlogDetail.bl?blog_num=<%=searchList.get(i).getBlog_num()%>&page=<%=nowPage%>"
                              class="btn btn-primary py-2 px-3">Read more</a>
                        </p>
                     </div>
                  </div>
            <%
               }
               }
            %>
               </div>
            </div>
            
         </div>
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
         <li><a href="./BlogList.bl?page=<%=nowPage - 1%>">&lt;</a></li>
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
         <li><a href="./BlogList.bl?page=<%=a%>"><%=a%></a></li>
         <%
            }
            }
         %>

         <%
            if (nowPage >= maxPage) {
         %>
         <li><a>&gt;</a></li>
         <%
            } else {
         %>
         <li><a href="./BlogList.bl?page=<%=nowPage + 1%>">&gt;</a></li>
         <%
            }
         %>
         		</ul>
					</div>
				</div>
      </section>
   </div>
       
       
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