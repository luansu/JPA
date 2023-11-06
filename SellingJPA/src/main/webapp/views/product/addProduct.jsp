<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/common/taglist.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="addproduct" method="post" enctype="multipart/form-data">
		<label>Nhập Product name:</label>
		<input type="text" name ="productName"><br>
		<label>Nhập Mô tả:</label>
		<textarea name ="description" cols="5" class="form=control" style="width:100%;"></textarea>
		<label>Nhập giá sản phẩm:</label>
		<input type="text" name ="price"><br>
		<label>Nhập hình ảnh:</label>
		<input type="file" name ="imageLink"><br>
		<label for="category">Nhập mã loại:</label>
											<select name="categoryID">
												<c:forEach items="${listCate}" var="item">
													<option value="${item.cateID}">${item.cateName} </option>
												</c:forEach>
											</select><br>
		<label>Nhập người bán:</label>
		<input type="text" name ="sellerID"><br>
		<label>Nhập số lượng:</label>
		<input type="text" name ="amount"><br>
		<label>Nhập đã bán:</label>
		<input type="text" name ="stoke"><br>
		<input type="submit" value="add product">
	</form>
</body>
</html>