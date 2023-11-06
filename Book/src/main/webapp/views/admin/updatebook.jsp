<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
		
		<input type="text" name="bookid" value="${listbook.bookid}" placeholder="Nhập mã sách">
		<input type="text" name="isbn" value="${listbook.isbn}" placeholder="Nhập mã định danh">
		<input type="text" name="title" value="${listbook.title}" placeholder="Nhập tựa">
		<input type="text" name="publisher" value="${listbook.publisher}" placeholder="Nhập nhà xuất bản">
		<input type="text" name="price" value="${listbook.price}" placeholder="Nhập giá">
		<input type="text" name="description" value="${listbook.description}" placeholder="Nhập mô tả">
		<input type="text" name="publish_date" value="${listbook.publish_date}" placeholder="Nhập ngày xuất bản">
		<input type="text" name="cover_image" value="${listbook.cover_image}" placeholder="Nhập hình minh họa">
		<input type="text" name="quantity" value="${listbook.quantity}" placeholder="Nhập số lượng">
		
		<input type="submit" value="Update book">
	</form>
</body>
</html>