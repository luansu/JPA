
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="category.html">Category</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Sub-category</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-12 col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Authors
                </div>
                <ul class="list-group category_block">
                    <c:forEach items="${authors}" var="author" varStatus="STT">
                        <c:url value="/author_book?authorid=${author.authorid}" var="targetUrl"></c:url>
                        <li class="list-group-item"><a href="${targetUrl}">${author.authorname}</a></li>
                    </c:forEach>
                </ul>
            </div>
<%--            <div class="card bg-light mb-3">--%>
<%--                <div class="card-header bg-success text-white text-uppercase">Last bookduct</div>--%>
<%--                <div class="card-body">--%>
<%--                    <img class="img-fluid" src="https://dummyimage.com/600x400/55595c/fff"/>--%>
<%--                    <h5 class="card-title">Product title</h5>--%>
<%--                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the--%>
<%--                        card's content.</p>--%>
<%--                    <p class="bloc_left_price">99.00 $</p>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <div class="col">
            <div class="row">
                <c:forEach items="${booksByAuthors}" var="book" varStatus="STT">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="https://dummyimage.com/600x400/55595c/fff"
                                 alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title"><a href="" title="${book.title}">${book.title}</a>
                                </h4>
                                <p class="card-text">${book.description}</p>
<%--                                <div class="row">--%>
<%--                                    <div class="col">--%>
<%--                                        <p class="btn btn-danger btn-block">99.00 $</p>--%>
<%--                                    </div>--%>
<%--                                    <div class="col">--%>
<%--                                        <a href="#" class="btn btn-success btn-block">Add to cart</a>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
                            </div>
                        </div>
                    </div>


                </c:forEach>

            </div>
        </div>

    </div>
</div>

</body>
</html>
