<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	rel="stylesheet">
<!-- Core theme CSS (includes Bootstrap)-->
<link href='<c:url value="/stylecss/base/basecss.css" />'
	rel="stylesheet" type="text/css">
<link href='<c:url value="/css/bootstrap.css" />' rel="stylesheet"
	type="text/css">

<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/login-project/css/main.css">
<body>
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="index.html">Book</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarsExampleDefault"
				aria-controls="navbarsExampleDefault" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse justify-content-end"
				id="navbarsExampleDefault">
				<ul class="navbar-nav m-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Đăng
							nhập <span class="sr-only">(current)</span>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<form method="post" action="login" id="login-form">
		<div class="bg__img">
			<div class="container d-flex justify-content-center w-200 min-vh-100"
				style="padding-top: 30px;">

				<!-- login -->
				<div class="row border rounded-5 p-3 bg-white shadow edit"
					style="width: 900px; height: fit-content;">

					<!-- 		left box -->
					<div
						class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box"
						style="background: #908d8d">
						<div class="featured-image md-3">
							<img
								src="${pageContext.request.contextPath}/template/images/sach.jpg"
								class="img-fluid" , style="width: 250px;">
						</div>
					</div>

					<!-- right-box -->

					<div class="col-md-6 right-box">
						<div class="row align-items-center">
							<div class="header-text mb-4 text-center">
								<h1 style="font-size: 2rem;">SIGN-IN</h1>
							</div>
							<div class="input-group mb-3">
								<input type="text"
									class="form-control form-control-lg bg-light fs-6"
									name="username" placeholder="UserName">
							</div>
							<div class="input-group mb-4">
								<input type="password"
									class="form-control form-control-lg bg-light fs-6"
									name="passwd" placeholder="Password">
							</div>
							<div class="input-group mb-5 d-flex justify-content-between">
								<div class="form-check">
									<input type="checkbox" class="form-check-input" id="formCheck">
									<label for="formCheck" class="form-check-label text-secondary"><small>Remember
											me</small></label>
								</div>
								<div class="forgot">
									<small><a href="#">Forgot Password?</a></small>
								</div>
							</div>
						</div>
						<div class="input-group mb-3">
							<button class="btn btn-lg btn-primary w-100 fs-6" type="submit">Login</button>
						</div>
						<div class="input-group mb-5">
							<button class="btn btn-lg btn-light w-100 fs-6">
								<img
									src="${pageContext.request.contextPath}/template/images/google.png"
									style="width: 20px" class="me-2"><small>Sign In
									with Google</small>
							</button>
						</div>
						<div class="row text-center ">
							<small>Don't have account? <a href="#">Sign Up</a></small>

						</div>
					</div>

				</div>
			</div>
		</div>
	</form>

	<footer class="fixed-bottom text-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-lg-4 col-xl-3">
					<h5>21110665</h5>
				</div>

				<div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
					<h5>ĐẶNG GIA THUẬN</h5>

				</div>
				<div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
					<h5>ĐỀ SỐ 1</h5>
				</div>
			</div>
		</div>
	</footer>

</body>
<!-- JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	type="text/javascript"></script>
</html>