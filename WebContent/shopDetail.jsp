<%@page import="vo.ShopBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	String nowPage = (String)request.getAttribute("page"); 
	ShopBean bean = (ShopBean)request.getAttribute("shopBean");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello</h1>
<%=bean.getProduct_num() %>,&nbsp;<%=bean.getProduct_name() %>
</body>
</html>