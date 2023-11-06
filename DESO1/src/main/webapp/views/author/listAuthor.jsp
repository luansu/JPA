<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty message}">${message}</c:if>
	<c:if test="${not empty error}">${error}</c:if>

	<table border="1" style="width: 100%">
		<thead>
			<th>Mã tác giả</th>
			<th>Tên tác giả</th>
			<th>Ngày sinh</th>
		</thead>
		<tbody>
			<c:forEach var="i" items="${requestScope.listauthors}">
				<tr>
					<td>${i.author_id}</td>
					<td>
						<a href="/DESO1/bookByAuthor?idAuthor=${i.author_id}">${i.author_name}</a>
						</td>
					<td>${i.date_of_birth}</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>