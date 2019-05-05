<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstarp.min.js"></script>
<title>Supplier</title>
</head>
<body>
<%@ include file="HeaderAdmin.jsp"%>
<h4>Supplier Page</h4>
    <form class="form-inline" action="AddSupplier" method="post">
    <table class="table table-hover">
    <tr>
<td>Supplier Name</td>
<td><input name="name"/></td>
</tr>
<tr>
<td>Supplier Location</td>
<td><input name="supploc"/></td>
</tr>
<tr>
<td colspan = "2">
<center><input type="submit" class="btn btn-success btn-xs" value="Add"/>
<input type="reset" class="btn btn-danger btn-xs" value="Reset"/></center>
</td>
</tr>
</table>
<div class="container">
<table class="table table-bordered" style="border-width:3px;border-color:black;">
<tr style="background-color:black; color:white;">
<td>Supplier ID</td>
<td>Supplier Name</td>
<td>Supplier Location</td>
<td>Operation</td>
</tr>
<c:forEach items="${listSuppliers}" var="supplier">
<tr>
<td>${supplier.supplierId}</td>
<td>${supplier.supplierName}</td>
<td>${supplier.supplierLocation}</td>
<td>
<a href="<c:url value="/updateSupplier/${supplier.supplierId}"/>" class="btn btn-success btn-xs">Update</a>
<a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>" class="btn btn-danger btn-xs">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</form>
</body>
</html>