<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Transactions</title>
</head>
<body>

<h3>Transactions</h3>

<table border ="1" width="500" align="center">
         <tr bgcolor="EFB7B7">
        
         <th><b>Account Number</b></th>
          <th><b>Amount</b></th>
          
         </tr>
     
       
    <c:forEach items="${data}" var="transaction">
    <tr>
    
    <td>${transaction.getAccountNumber()}</td> 
    <td>${transaction.getAmount()}</td>
    </tr>
</c:forEach>
    
        </table> 

</body>
</html>