<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Buy Car</title>
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
					<a href="${pageContext.request.contextPath}/uhome" class="list-group-item list-group-item-action">Home</a>
					<a href="${pageContext.request.contextPath}/user_shop" class="list-group-item list-group-item-action">Shop</a>
					<a href="${pageContext.request.contextPath}/useraddoldcar" class="list-group-item list-group-item-action">Add Old Car</a>
					<a href="${pageContext.request.contextPath}/view" class="list-group-item list-group-item-action">OrderDetails</a> 
					<a href="${pageContext.request.contextPath}/viewmycars" class="list-group-item list-group-item-action">view my cars</a>
					<a href="${pageContext.request.contextPath}/dologout" class="list-group-item list-group-item-action">Logout</a>
				</div>
			</div>
			<div class="col-xl-8 col-md-8 col-8">
				<h3>User Buy Car</h3>
				<form action="${pageContext.request.contextPath}/addorder" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="carid" name="carID" value="${car_id}" readonly>
					</div>
					<div class="form-group">
						<label for="address">Address:</label>
						<textarea class="form-control" rows="5" id="address"
							name="orderAddress" required></textarea>
					</div>
					<h4>Choose Mode Of Payment:</h4>
					<div class="form-check-inline">
						<label class="form-check-label"> 
						<input type="radio" class="form-check-input" name="mode" value="cash" required>Cash
						</label>
					</div>
					<div class="form-check-inline">
						<label class="form-check-label"> 
						<input type="radio" class="form-check-input" name="mode" value="cheque" required>Cheque
						</label>
					</div>
					<input type="submit" value="Buy" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>