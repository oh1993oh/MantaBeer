<%@page import="java.util.List"%>
<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
List user_List=(List)request.getAttribute("user_List");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User_search_pro.jsp</title>
</head>
<body>
<h1><mark>◎ 검색 결과</mark> </h1><br>

<table border="1">
<tr><td>회원 성명</td><td>회원 아이디</td><td>회원 이메일</td><td>회원 연락처</td></tr>

<%
	for(int i=0; i<user_List.size(); i++) {

		 UserBean user=(UserBean)user_List.get(i);
		 out.println("<tr>");
		 out.println("<td>");
		 out.println(user.getUser_name());
		 out.println("</td>");
		 out.println("<td>");
		 out.println(user.getUser_id());
		 out.println("</td>");
		 out.println("<td>");
		 out.println(user.getUser_email());
		 out.println("</td>");
		 out.println("<td>");
		 out.println(user.getUser_number());
		 out.println("</td>");
		 out.println("</tr>");
		 
		 }


%>

</table>
</body>
</html>