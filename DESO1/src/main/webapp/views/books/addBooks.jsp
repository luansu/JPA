<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/template/user/css/style.css"/>'
	rel="stylesheet" type="text/css">
</head>
<body>
	<form action="admin-addbooks" method = "post">
		<label>Nhập ISBN:</label>
		<input type = "text" name = "isbn"><br>
		<label>Nhập tiêu đề:</label>
		<input type = "text" name = "title"><br>
		<label>Nhập nhà xuất bản:</label>
		<input type = "text" name = "publisher"><br>
		<label>Nhập giá:</label>
		<input type = "text" name = "price"><br>
		<label>Nhập mô tả:</label>
		<input type = "text" name = "description"><br>
		<label>Nhập ngày xuất bản:</label>
		<input type = "text" name = "publish_date"><br>
		<label>Nhập hình ảnh:</label>
		<input type = "text" name = "cover_image"><br>
		<label>Nhập số lượng:</label>
		<input type = "text" name = "quantity"><br>
		
		
		<input type = "submit" value="Insert Book">
	</form>
</body>
</html>