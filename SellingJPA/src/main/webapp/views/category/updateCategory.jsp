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
		<input type="text" name="categoryID" value="${cate.categoryID}" readonly ="readonly"> 
		<label>Nhập category name:</label>
		<input type="text" name="categoryName" value="${cate.categoryName}">
		<label>Nhập link icon:</label> 
		<input type="text" name="images"value="${cate.images }"> 
		<input type="submit" value="Update Category">
	</form>

</body>
</html>