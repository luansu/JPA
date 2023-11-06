<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<style>
.active {
	background-color: #0062cc;
	color: #ffffff;
}
</style>

<div class="container">
	<tey:forEach var="item" items="${listcate}">
		<tey:forEach var="item1" items="${countCID}">
			<tey:if test="${item1.authorid == item.authorid && item1.total != 0}">
				<a href='<tey:url value="./listbookauthor?authorId=${item.authorid}" />'>
		 			<span class="${setactive==item.authorid?'active':'' }"> ${item.authorname}</span> <small>(${item1.total})</small>
				</a>
				<br>
			</tey:if>
		</tey:forEach>
	</tey:forEach>
</div>