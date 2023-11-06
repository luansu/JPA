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
			<th>ID</th>
			<th>Tài khoản</th>
			<th>Email</th>
			<th>Fullname</th>
			<th>SĐT</th>
			<th>passwd</th>
			<th>signup_date</th>
			<th>last_login</th>
			<th>is_admin</th>
		</thead>
		<tbody>
			<c:forEach var="i" items="${listuser}">
				<tr>
					<td>${i.id}</td>
					<td>
						<a href='<c:url value="/ratingByUser?id=${i.id}"/>'>${i.username}</a>
						</td>
					<td>${i.email}</td>
					<td>${i.fullname}</td>
					<td>${i.phone}</td>
					<td>${i.passwd}</td>
					<td>${i.signup_date}</td>
					<td>${i.last_login}</td>
					<td>${i.is_admin}</td>
					<td><a href="update?id=${i.id}"> Update </a> || <a
						href="delete?id=${i.id}">Delete</a>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>