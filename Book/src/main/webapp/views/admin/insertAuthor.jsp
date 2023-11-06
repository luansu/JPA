<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method = "post">
		<label>Nhập tên tác giả:</label>
		<input type = "text" name = "authorname">
		<label>Nhập ngày sinh:</label>
		<input type = "text" name = "date_of_birth">
		
		<input type = "submit" value="Add Author">
	</form>
</body>
</html>