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
    	<c:forEach var="i" items="${listbook}">
		<tr>
			<td style="width: 30%; border: 1px solid black;">
			<p>${i.cover_image}</p>
			</td>
			<td style="width: 70%; border: 1px solid black;">
					<p> <a href="./detailReviews?id=${i.bookid}"> Tiêu đề: ${i.title} </a></p>
					<p>Mã isbn: ${i.isbn}</p>
					<p>Tac gia: ${i.author.authorname}</p>
					<p>Publisher: ${i.publisher}</p>
					<p>Punlisher_Date: ${i.publish_date}</p>
					<p>Quantity: ${i.quantity}</p>
					<p>Review: ${i.total_reviews}</p>
				
			</td>
		</tr>
		</c:forEach>
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