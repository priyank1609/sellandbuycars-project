<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Old car</title>
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
				<h3>User - Add Old Car</h3>
				<form action="useraddoldcar" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="carcompany">Car Company:</label> 
						<input type="text" class="form-control" placeholder="Enter Car Company" id="carcompany" name="car_Company" required>
					</div>
					<div class="form-group">
						<label for="carmodel">Car Model:</label> 
						<input type="text" class="form-control" placeholder="Enter Car Model" id="carmodel" name="car_Model" required>
					</div>
					<div class="form-group">
						<label for="fueltype">FuelType:</label> 
						<input type="text" class="form-control" placeholder="Enter Fuel Type" id="fueltype" name="car_FuelType" required>
					</div>
					<div class="form-group">
						<label for="kmdriven">Car KM Driven:</label> 
						<input type="text" class="form-control" placeholder="Enter Car KM Driven" id="kmdriven" name="car_KMDriven" required>
					</div>
					<div class="form-group">
						<label for="pricing">Car Pricing:</label> 
						<input type="text" class="form-control" placeholder="Enter Car Pricing" id="pricing" name="car_Pricing" required>
					</div>
					<div>
						<label>Select Image:</label>
						<input type="file" name="imageupload" />
					</div>
					<input type="submit" value="Add Car" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>