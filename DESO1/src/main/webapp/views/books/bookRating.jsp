<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/template/user/css/style.css"/>' rel="stylesheet" type="text/css">
</head>

<body>

	<table border="1" style="width: 100%">
		<thead>
			<th>Mã sách</th>
			<th>ISBN</th>
			<th>Tiêu đề</th>
			<th>Nhà xuất bản</th>
			<th>Giá</th>
			<th>Mô tả</th>
			<th>Ngày xuất bản</th>
			<th>Ảnh bìa</th>
			<th>Số lượng</th>
			<th>Mã người dùng</th>
			<th>Điểm đánh giá</th>
			<th>Lời đánh giá</th>
		</thead>
		<tbody>
			<c:forEach var="i" items="${requestScope.list}">
				<tr>
					<td>${i.bookid}</td>
					<td>${i.isbn}</td>
					<td>${i.title}</td>
					<td>${i.publisher}</td>
					<td>${i.price}</td>
					<td>${i.description}</td>
					<td>${i.publish_date}</td>
					<td>${i.cover_image}</td>
					<td>${i.quantity}</td>
					<td>${i.rating.user_id}</td>
					<td>${i.rating.rating}</td>
					<td>${i.rating.review_text}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>