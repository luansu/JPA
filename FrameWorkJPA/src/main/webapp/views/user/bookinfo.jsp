<%@ include file="/common/taglib.jsp"%>
<c:set var="page" value="${page}"></c:set>
<div class="pagination">
		<c:forEach begin="${1}" end="${num}" var="i">
			<a href="home?page=${i}">${i}</a>
			<!-- Thêm dấu chấm hoặc khoảng cách ở đây -->

		</c:forEach>
	</div>
	
<table style="width: 100%; border: 1px solid black;" >
	<c:forEach var="i" items="${requestScope.list}">
		<tr>
			<td style="width: 30%; border: 1px solid black;">
			<p>${i.cover_image}</p>
			</td>
			<td style="width: 70%; border: 1px solid black;">
					<p> <a href="./detail?id=${i.bookid}"> Tiêu đề: ${i.title} </a></p>
					<p>Mã isbn: ${i.isbn}</p>
					<c:forEach var="au" items="${i.authors}">
						<p>Author name: ${au.author_name}</p>
					 </c:forEach>
					<p>Publisher: ${i.publisher}</p>
					<p>Punlisher_Date: ${i.publish_date}</p>
					<p>Quantity: ${i.quantity}</p>
					<p>Review: (${i.rating_list.size()})</p>
				
			</td>
		</tr>
	</c:forEach>
</table>