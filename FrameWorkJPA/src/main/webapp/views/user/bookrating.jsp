<%@ include file="/common/taglib.jsp"%>
<table style="width: 100%; border: 1px solid black;">
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
				<p>Review: ${i.rating_list.size()}</p>
			
		</td>
	</tr>
	<tr><td style="border: 1px solid black;">Review</td></tr>
	<tr>
		<td style="width: 100%; border: 1px solid black;" colspan="2">
		<c:forEach var="rl" items="${ratinglist}">
			<p>[${rl.user.fullname}]: [${rl.review_text}]</p>
		 </c:forEach>
		 </td>
	</tr>
	<tr>
		<td style="width: 100%; border: 1px solid black;" colspan="2">
			<p>Form thêm review</p><br>
			<input type="submit" value="Sumit">
		</td>
	</tr>
</table>