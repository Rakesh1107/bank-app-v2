
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Customers</title>
</head>
<body>

<h3>Customers</h3>
<table border ="1" width="500" align="center">
         <tr bgcolor="EFB7B7">
         <th></th>
         <th><b>User id</b></th>
          <th><b>Address</b></th>
          <th><b>Mobile Number</b></th>
          
         </tr>
        
    <c:forEach items="${data}" var="customer">
    <tr>
   <td><input type = "checkbox"></td>
	<td>${customer.getUserId()}"</td>
    <td>${customer.getAddress()}</td>
    <td>${customer.getMobileNumber()}</td> 
   
    </tr>
</c:forEach>


    
        </table> 
          <form action="http://localhost:8080/Bank-App/controller?page=add-customer" method="post">
    <input type="submit" value="Add" />
</form>
<button type="submit">Delete</button>
</body>
</html>