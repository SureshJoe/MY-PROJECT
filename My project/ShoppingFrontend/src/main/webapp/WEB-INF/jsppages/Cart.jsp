<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Cart</title>
</head>
<body>
<%@ include file="HeaderAdmin.jsp"%>
Hi ${cart.username}
<div class="container">
<table class="table table-bordered" style="border-width:3px;border-color:black;">
<tr style="background-color:black; color:white;">
<td>Serial No</td>
<td>Product Name</td>
<td>Product Price</td>
<td>Quantity</td>
<td>Product Image</td>
<td>Operation</td>
</tr>
<c:forEach items="${listCarts}" var="cart">
<tr>
<td></td>
<td>${cart.productName}</td>
<td>${cart.total}</td>
<td>${cart.quantity}</td>
<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="75px" height="75px"></td>
<td>
<a href="<c:url value="/updatecart/${product.productId}"/>" class="btn btn-success btn-xs">Refresh</a>
<a href="<c:url value="/deletecart/${product.productId}"/>" class="btn btn-danger btn-xs">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>