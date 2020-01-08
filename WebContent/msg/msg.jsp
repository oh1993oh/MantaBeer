<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<String> msgList = (ArrayList) request.getAttribute("msgList");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(String msg : msgList){
	%>
	<%=msg %>
	<%
}
%>
</body>
</html>