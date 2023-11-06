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

	<div>
		<span>
			<c:if test ="${message != null }">
				${message }
			
			</c:if>
		</span>
	</div>


	<span><a href="<c:url value='/user-category/addcate'/>">Add Category</a></span>
	<table border="1" style="width: 100%">
		<tr>
			<td>ID</td>
			<td>CateName</td>
			<td>Icon</td>
			<td>Action</td>
		</tr>
		<c:forEach var="i" items="${list}">
			<tr>
				<td>${i.categoryID}</td>
				<td>${i.categoryName}</td>
				<td>${i.images }</td>
				<td>
				<span><a href="<c:url value='/user-category/update?id=${i.categoryID}'/>">Update</a></span>
				<span><a href="<c:url value='/user-category/delete?id=${i.categoryID}'/>">Delete</a></span>
				</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>