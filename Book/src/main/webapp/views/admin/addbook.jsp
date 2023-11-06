<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add" method="post">

		<input type="text" name="isbn" placeholder="Nhập mã định danh">
		<input type="text" name="title" placeholder="Nhập tựa">
		<input type="text" name="publisher" placeholder="Nhập nhà xuất bản">
		<input type="text" name="price" placeholder="Nhập giá">
		<input type="text" name="description" placeholder="Nhập mô tả">
		<input type="text" name="publish_date" placeholder="Nhập ngày xuất bản">
		<input type="text" name="cover_image" placeholder="Nhập hình minh họa">
		<input type="text" name="quantity" placeholder="Nhập số lượng">
		
		<input type="submit" value="Insert book">
	</form>
</body>
</html>