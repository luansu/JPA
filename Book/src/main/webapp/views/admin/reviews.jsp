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
    <table style="width: 100%; border: 1px solid black;" >
		<tr>
			<td style="width: 30%; border: 1px solid black;">
			<p>${book.cover_image}</p>
			</td>
			<td style="width: 70%; border: 1px solid black;">
					<p>Tiêu đề: ${book.title}</p>
					<p>Mã isbn: ${book.isbn}</p>
					<p>Tac gia: ${book.author.authorname}</p>
					<p>Publisher: ${book.publisher}</p>
					<p>Punlisher_Date: ${book.publish_date}</p>
					<p>Quantity: ${book.quantity}</p>
					<p>Review: ${book.total_reviews}</p>
				
			</td>
		</tr>
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