<%@page import="vo.UserBean"%>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Worldbeershop_listView(◆ 회원 정보 상세 조회 - 관리자 페이지 전용)</title>
</head>
<body>

<section id = "UserInfoArea">
<h1><mark>★ ${user.user_name} 님의 상세 정보 조회</mark></h1>

<table border="1">
 <tr><td>회원아이디</td><td>비밀번호</td><td>회원성명</td><td>회원이메일</td><td>회원연락처</td></tr>
	<tr><td>${user.user_id}</td><td>${user.user_pass}</td><td>${user.user_name}</td>
	<td>${user.user_email}</td><td>${user.user_number}</td></tr>
	
</table>

<hr>
<a href="User_list.me"> ♣ 목록으로 돌아가기</a>

</section>
</body>
</html>