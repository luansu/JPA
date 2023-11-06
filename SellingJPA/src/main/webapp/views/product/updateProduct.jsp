<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="update" method="post">
		<label>ID: </label> 
	p<input type="text" name="productID" value="${product.productID}" readonly ="readonly"> 
		<label>Nhập product name:</label>
		<input type="text" name="productName" value="${product.productName}">
		<label>Nhập link icon:</label> 
		<input type="text" name="description"value="${product.description}">
		<input type="text" name="price"value="${product.price}"> 
		<input type="file" name="imageLink"value="${product.imageLink}"> 
		<label for="category">Nhập mã loại:</label>
											<select name="categoryID">
												<c:forEach items="${listCate}" var="item">
													<option value="${item.cateID}" ${product.categoryID==item.cateID?'selected':'' }>${item.cateName} </option>
												</c:forEach>
											</select>
		<input type="text" name="sellerID"value="${product.sellerID}"> 
		<input type="text" name="amount"value="${product.amount}"> 
		<input type="text" name="stoke"value="${product.stoke}"> 
		<input type="submit" value="Update Product">
		

	</form>

</body>
</html>