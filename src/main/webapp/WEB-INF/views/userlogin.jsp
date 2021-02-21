<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<s:url value="/resources/images" var="images"></s:url>

<style type="text/css">
#main_cover {
	width: 100%;
	height: 250px
}
</style>
</head>
<body>
	<div class="container-fluid" id="company_main_cover">
		<div class="row">
			<img class="img-fluid" src="${images}/maincover.jpeg"
				alt="main cover" id="main_cover">
		</div>
	</div>
	<div class="container-fluid" id="left_body">
		<div class="row">
			<div class="col-xl-4 col-md-4 col-4">
				<div class="list-group">
					<a href="index" class="list-group-item list-group-item-action">Home</a>
					<a href="register" class="list-group-item list-group-item-action">Register</a>
					<a href="${pageContext.request.contextPath }/userlogin" class="list-group-item list-group-item-action">User
						Login</a> <a href="${pageContext.request.contextPath }/admin/login"
						class="list-group-item list-group-item-action">Admin Login</a>
				</div>
			</div>
			<div class="col-xl-8 col-md-8 col-8">
				<h3>User Login</h3>
				<form action="usersignin" method="post">
					<div class="form-group">
						<label for="userid">UserId:</label> 
						<input type="text" class="form-control" placeholder="Enter UserID" id="userid" name="userID" required>
					</div>
					<div class="form-group">
						<label for="userpassword">Password:</label> 
						<input type="password" class="form-control" placeholder="Enter Password" id="userpassword" name="userPassword" required>
						<div>${message}</div>
					</div>
					<input type="submit" value="Login" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>