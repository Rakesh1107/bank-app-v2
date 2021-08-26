
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="./header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Accounts</title>
</head>
<body>
<h3>Accounts</h3>

<table border ="1" width="500" align="center">
         <tr bgcolor="EFB7B7">
         <th></th>
         <th><b>User id</b></th>
          <th><b>Account Number</b></th>
          <th><b>Branch</b></th>
          <th><b>Balance</b></th>
         </tr>
     
       
    <c:forEach items="${data}" var="account">
    <tr>
    <td><input type = "checkbox"></td>
	<td>${account.getUserId()}"</td>
    <td>${account.getAccountNumber()}</td>
    <td>${account.getBranch()}</td> 
    <td>${account.getBalance()}</td>
    </tr>
</c:forEach>
    
        </table> 
        
        <form action="http://localhost:8080/Bank-App/controller?page=add-account" method="post">
    <input type="submit" value="Add" />
</form>
        
		<button type="submit">Delete</button>





</body>
</html>
<%@include file="./footer.jsp" %>