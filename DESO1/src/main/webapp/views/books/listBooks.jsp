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

	<c:if test="${not empty message}">${message}</c:if>
	<c:if test="${not empty error}">${error}</c:if>

	<a href='<c:url value="admin-addbooks"/>'>Add book</a>
	<a href='<c:url value="admin-rating"/>'>Rating book</a>
	<a href='<c:url value="admin-bookbyauthor"/>'>Rating book</a>
	
	<c:set var="page" value="${page}"></c:set>
	<div class="pagination">
		<c:forEach begin="${1}" end="${num}" var="i">
			<a href="admin-listbooks?page=${i}">${i}</a>
			<!-- Thêm dấu chấm hoặc khoảng cách ở đây -->

		</c:forEach>
	</div>

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
					<td><a href="admin-updatebooks?id=${i.bookid}"> Update </a> || <a
						href="admin-deletebooks?id=${i.bookid}">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>