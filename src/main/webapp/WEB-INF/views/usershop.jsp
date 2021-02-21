<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Shop Page</title>
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
					<a href="${pageContext.request.contextPath}/view" class="list-group-item list-group-item-action">Order Details</a>
					<a href="${pageContext.request.contextPath}/viewmycars" class="list-group-item list-group-item-action">view my cars</a>
					<a href="${pageContext.request.contextPath}/dologout" class="list-group-item list-group-item-action">Logout</a>
				</div>
			</div>
			<div class="col-xl-8 col-md-8 col-8">
				<div class="jumbotron">
					<a href="${pageContext.request.contextPath}/shop_old_cars" class="btn btn-info" role="button">Shop For Old Cars</a>
					<a href="${pageContext.request.contextPath}/shop_new_cars" class="btn btn-info" role="button">Shop For New Cars</a>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div class="container" id="table_body">
		<div class="row">
			<div class="col-xl-12 col-md-12 col-12">
				<div class="jumbotron">
					<h2>Here is the list of all Old Cars to shop:</h2>
					<br>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>CarID</th>
								<th>CarCompany</th>
								<th>CarModel</th>
								<th>FuelType</th>
								<th>Km_driven</th>
								<th>Pricing</th>
								<th>Image</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${oldcarlist}" var="oldcars">
								<tr>
									<td>${oldcars.carID}</td>
									<td>${oldcars.carCompany}</td>
									<td>${oldcars.carModel}</td>
									<td>${oldcars.fuelType}</td>
									<td>${oldcars.km_driven}</td>
									<td>${oldcars.pricing}</td>
									<td><img alt="car image" style="height:100px;width:150px" src="<c:url value="/resources/images/${oldcars.image}" />" /></td>
									<td><a class="btn btn-success" href="${pageContext.request.contextPath}/user_buy_car/${oldcars.carID}">Buy</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<div class="container" id="table_body">
		<div class="row">
			<div class="col-xl-12 col-md-12 col-12">
				<div class="jumbotron">
					<h2>Here is the list of all New Cars to shop:</h2>
					<br>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>CarID</th>
								<th>CarCompany</th>
								<th>CarModel</th>
								<th>FuelType</th>
								<th>Pricing</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${newcarlist}" var="newcars">
								<tr>
									<td>${newcars.carID}</td>
									<td>${newcars.carCompany}</td>
									<td>${newcars.carModel}</td>
									<td>${newcars.fuelType}</td>
									<td>${newcars.pricing}</td>
									<td><a class="btn btn-success" href="${pageContext.request.contextPath}/user_buy_car/${newcars.carID}">Buy</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>