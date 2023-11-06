<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa sách</title>
    <link href='<c:url value="/template/user/css/style.css"/>' rel="stylesheet" type="text/css">
</head>
<body>
    <div class="container update" style = "flex: 1; aligns-items-center">
        <h1>Chỉnh sửa sách</h1>
        <form action="admin-updatebooks" method="post" class="book-form" style="height: 100%">
	            <label class="">ID Book:</label>
	            <input type="text" name="bookid" value="${book.bookid}" readonly="readonly"><br>
	
	            <label>Nhập ISBN:</label>
	            <input type="text" name="isbn" value="${book.isbn}"><br>
	
	            <label>Nhập tiêu đề:</label>
	            <input type="text" name="title" value="${book.title}"><br>
	
	            <label>Nhập nhà xuất bản:</label>
	            <input type="text" name="publisher" value="${book.publisher}"><br>
	
	            <label>Nhập giá:</label>
	            <input type="text" name="price" value="${book.price}"><br>
	
	            <label>Nhập mô tả:</label>
	            <input type="text" name="description" value="${book.description}"><br>
	
	            <label>Nhập ngày xuất bản:</label>
	            <input type="text" name="publish_date" value="${book.publish_date}"><br>
	
	            <label>Nhập bìa:</label>
	            <input type="text" name="cover_image" value="${book.cover_image}"><br>
	
	            <label>Nhập số lượng:</label>
	            <input type="text" name="quantity" value="${book.quantity}"><br>
	            
	            <input type="submit" value="Cập nhật">
        </form>
    </div>
</body>
</html>