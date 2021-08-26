<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./header.jsp" %>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">


<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet"> 
<title>Welcome</title>
</head>
<body>

	<p>${message}</p>
	

	<div class="sidenav">
	<a href="http://localhost:8080/Bank-App/controller?page=accounts">Accounts</a><br>
	<a href="http://localhost:8080/Bank-App/controller?page=customers">Customers</a><br>
	<a href="http://localhost:8080/Bank-App/controller?page=transactions">Transactions</a><br>
	</div>
	
</body>
</html>
<%@include file="./footer.jsp" %>