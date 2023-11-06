<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<span>
			<c:if test ="${message != null }">
				${message }
			
			</c:if>
		</span>
	</div>


	<span><a href="<c:url value='/user-product/addproduct'/>">Add Category</a></span>
	<table border="1" style="width: 100%">
		<tr>
			<td>ID</td>
			<td>ProductName</td>
			<td>Description</td>
			<td>Price</td>
			<td>Image Link</td>
			<td>Category ID</td>
			<td>Seller ID</td>
			<td>Amount</td>
			<td>Stoke</td>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.productID}</td>
				<td>${i.productName}</td>
				<td>${i.description}</td>
				<td>${i.price}</td>
				<td>${i.imageLink}</td>
				<td>${i.categoryID}</td>
				<td>${i.sellerID}</td>
				<td>${i.amount}</td>
				<td>${i.stoke}</td>
				<td>
				<span><a href="<c:url value='/user-product/update?id=${i.productID}'/>">Update</a></span>
				<span><a href="<c:url value='/user-product/delete?id=${i.productID}'/>">Delete</a></span>
				</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>