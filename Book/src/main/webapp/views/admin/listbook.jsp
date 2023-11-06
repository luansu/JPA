<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <style>
        .pagination {
            display: flex;
            list-style: none;
        }
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
    <a href="add">Add New Book</a>
    <a href="list">List Book Review</a>
    <table border="1" style="width: 100%">
        <thead>
            <th>Cover_Image</th>
            <th>Tiêu đề</th>
            <th>Mã isbn</th>
            <th>Tác giả</th>
            <th>Publisher</th>
            <th>Publisher_date</th>
            <th>Quantity</th>
            <th>Reviews</th>
        </thead>
       
        <tbody>
            <c:forEach var="item" items="${listbook}">
                <tr>
                    <td>${item.cover_image}</td>
                    <td>${item.title}</td>
                    <td>${item.isbn}</td>
                    <td>${author.authorname}</td>
                    <td>${item.publisher}</td>
                    <td>${item.publish_date}</td>
                    <td>${item.quantity}</td>
                    <td>${count}</td>
                    <td>
                        <a href="update?id=${item.bookid}">Update</a>
                        ||
                        <a href="delete?id=${item.bookid}">Delete</a>
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