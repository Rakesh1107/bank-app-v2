<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="./header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Add Account</title>
</head>
<body>
<h3>Create new Account</h3>
<form action="http://localhost:8080/Bank-App/controller?page=new-account" method="post">
		<label for="userid">User ID</label><br>
		<input name="userid" id="userid" type="number" required="required"><br>
		
		<label for="address">Branch</label><br>
		<input name="branch" id="address" type="text" required="required"><br>
		
		<label for="deposit">Initial deposit</label><br>
		<input name="deposit" id="deposit" type="number" required="required"><br>
		

		<input required="required" type="checkbox">
		<span>Agree to our <a href="https://www.zoho.com/">Terms and conditions</a></span>
		<br>
		<button type="submit">Submit</button>
		<button type="reset">Reset</button>
</form>
</body>
</html>
<%@include file="./footer.jsp" %>