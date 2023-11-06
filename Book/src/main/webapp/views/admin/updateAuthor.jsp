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
	<form action="update" method = "post">
		<label>ID :</label>
		<input type = "text" name = "authorname" value = "${author.authorid}" readonly="readonly">
		<label>Nhập tên tác giả:</label>
		<input type = "text" name = "date_of_birth" value = "${author.authorname}">
		<label>Nhập ngày sinh:</label>
		<input type = "text" name = "cateIcon" value = "${author.date_of_birth}">
		
		<input type = "submit" value="Update Author">
	</form>
</body>
</html>