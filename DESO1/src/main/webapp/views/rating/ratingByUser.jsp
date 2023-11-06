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

	<table style="width: 100%; border: 1px solid black;" >
		<tr>
			<td style="width: 30%; border: 1px solid black;">User: ${user.id} <br> FullName:
				${user.fullname} <br> Email: ${user.email}
			</td>
			<td style="width: 70%; border: 1px solid black;"><c:forEach var="i" items="${listrating}">
					<p>BookID: ${i.bookid}</p>
				</c:forEach></td>
		</tr>
	</table>

</body>
</html>