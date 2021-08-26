<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="./header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Add Customer</title>
</head>
<body>
<h3>Create new User</h3>
<form action="http://localhost:8080/Bank-App/controller?page=new-user" method="post">
		<label for="name">Account Holder Name</label><br>
		<input name="name" id="name" type="text" required="required"><br>
		
		<label for="address">Address</label><br>
		<textarea name="address" id="address" required="required"></textarea><br>
		
		<label for="phone">Phone number</label><br>
		<input name="phone" id="phone" type="number" required="required"><br>
		
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