<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Worldbeershop_search_Form(# 관리자용/ Test 용)</title>
</head>
<body>
<h1><mark>☆회원 정보 검색(관리자 용/ Test 용)☆</mark></h1>
<hr>
<form action="userSearchPro.me" method="post">
<label>◆  회원 정보 검색 </label><br>
<select name="user_search">
  <option value="user_search_name">회원 이름</option>
  <option value="user_search_id">회원 아이디</option>
  <option value="user_search_number">회원 연락처</option>
</select>
<input type="text" name="user_name">
<input type="submit" value="검색 하기">
<input type="reset" value="취소하기">
</form>
</body>
</html>