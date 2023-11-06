<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<link href='<c:url value="/templates/user/css/style.css"/>' rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Book List</title>
    <style>
        .page-link {
            text-decoration: none;
            padding: 5px 10px;
            border: 1px solid #ccc;
            margin: 0 5px;
            color: #333;
        }
        .page-link.active {
            background-color: #007bff;
            color: #fff;
            border: 1px solid #007bff;
        }
    </style>
</head>
<body>
    <c:if test="${message != null}">${message}</c:if>
    <c:if test="${error != null}">${error}</c:if>
    <a href="add">Add New Author</a>
    <table border="1" style="width: 100%">
        <thead>
            <th>ID</th>
            <th>Tên tác giả</th>
            <th>Ngày sinh</th>
        </thead>
       
        <tbody>
            <c:forEach var="item" items="${list}">
                <tr>
                    <td>${item.authorid}</td>
                    <td> <a href="#?id=${item.authorid}">${item.authorname} </a></td>
                    <td>${item.date_of_birth}</td>
                    <td>
                        <a href="update?id=${item.authorid}">Update</a>
                        ||
                        <a href="delete?id=${item.authorid}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <ul class="pagination">
        <c:if test="${tag > 1}">
            <li class="page-item">
                <a class="page-link" href="home?index=${tag-1}">Previous</a>
            </li>
        </c:if>
        <c:forEach var="i" begin="1" end="${endP}">
            <c:choose>
                <c:when test="${tag eq i}">
                    <li class="page-item active">
                        <a class="page-link" href="home?index=${i}">${i}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="home?index=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${tag < endP}">
            <li class="page-item">
                <a class="page-link" href="home?index=${tag+1}">Next</a>
            </li>
        </c:if>
    </ul>
</body>
</html>