<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Add New Car</title>
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
					<a href="${pageContext.request.contextPath }/admin/home" class="list-group-item list-group-item-action">Home</a>
					<a href="${pageContext.request.contextPath }/admin/view_approvals" class="list-group-item list-group-item-action">View Old Cars Approval</a>
					<a href="${pageContext.request.contextPath }/admin/add_newcar" class="list-group-item list-group-item-action">Add New Car</a>
					<a href="${pageContext.request.contextPath }/admin/viewOrders" class="list-group-item list-group-item-action">Order Details</a>
					<a href="${pageContext.request.contextPath }/admin/dologout" class="list-group-item list-group-item-action">Logout</a>
				</div>
			</div>
			<div class="col-xl-8 col-md-8 col-8">
				<h3>Add New Car</h3>
				<form action="${pageContext.request.contextPath }/admin/addCar" method="post">
					<div class="form-group">
						<label for="newcarcompany">Car Company:</label> 
						<input type="text" class="form-control" placeholder="Enter Car Company" id="newcarcompany" name="newCarCompany" required>
					</div>
					<div class="form-group">
						<label for="newcarmodel">Car Model:</label> 
						<input type="text" class="form-control" placeholder="Enter Car Model" id="newcarmodel" name="newCarModel" required>
					</div>
					<div class="form-group">
						<label for="newcarfueltype">Car FuelType:</label> 
						<input type="text" class="form-control" placeholder="Enter Car FuelType" id="newcarfueltype" name="newCarFuelType" required>
					</div>
					<div class="form-group">
						<label for="newcarpricing">Car Pricing:</label> 
						<input type="int" class="form-control" placeholder="Enter Car Pricing" id="newcarpricing" name="newCarPricing" required>
					</div>
					<input type="submit" value="Add New Car" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>