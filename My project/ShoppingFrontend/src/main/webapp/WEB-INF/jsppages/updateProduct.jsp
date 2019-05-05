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
<title>ProductPage</title>
<style>
#sel { width:175px; }
</style>
</head>
<body>
<%@ include file="HeaderAdmin.jsp"%>
<h4>Add Product</h4>
<form method="post" action="<c:url value="/updateProductDB/${product.productId}"/>">
<table class="table table-hover">
<tr>
<td>Select Category:</td>
<td><select id="sel" name="categoryId">
<c:forEach items="${listCategories}" var="category">
<option value="${category.categoryId}">${category.categoryName}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Select Supplier:</td>
<td><select id="sel" name="supplierId">
<c:forEach items="${listSuppliers}" var="supplier">
<option value="${supplier.supplierId}">${supplier.supplierName}</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>Product Name</td>
<td><input name="proname" value="${product.productName}"/></td>
</tr>
<tr>
<td>Product Description</td>
<td><input name="prodescription" value="${product.productDescription}"/></td>
</tr>
<tr>
<td>Product Price</td>
<td><input name="proprice" value="${product.price}"/></td>
</tr>
<tr>
<td>Product Stock</td>
<td><input name="prostock" value="${product.stock}"/></td>
</tr>
<tr>
<td colspan = "2">
<center><input type="submit" class="btn btn-success btn-xs" value="Update"/>
<input type="reset" class="btn btn-danger btn-xs" value="Reset"/></center>
</td>
</tr>
</table>
<div class="container">
<table class="table table-bordered">
<tr style="background-color:black; color:white;">
<td>Product ID</td>
<td>Product Name</td>
<td>Product Description</td>
<td>Product Price</td>
<td>Product Stock</td>
<td>Category ID</td>
<td>Supplier ID</td>
<td>Operation</td>
</tr>
<c:forEach items="${listProducts}" var="product">
<tr>
<td>${product.productId}</td>
<td>${product.productName}</td>
<td>${product.productDescription}</td>
<td>${product.price}</td>
<td>${product.stock}</td>
<td>${product.categoryId}</td>
<td>${product.supplierId}</td>
<td>
<a href="<c:url value="/updateProduct/${product.productId}"/>" class="btn btn-success btn-xs">Update</a>
<a href="<c:url value="/deleteProduct/${product.productId}"/>" class="btn btn-danger btn-xs">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</form>
</body>
</html>