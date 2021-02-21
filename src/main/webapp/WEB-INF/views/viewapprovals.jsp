<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin View Cars For Approval</title>
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
					<a href="${pageContext.request.contextPath }/admin/home"
						class="list-group-item list-group-item-action">Home</a> <a
						href="${pageContext.request.contextPath }/admin/view_approvals"
						class="list-group-item list-group-item-action">View Old Cars
						Approval</a> <a
						href="${pageContext.request.contextPath }/admin/add_newcar"
						class="list-group-item list-group-item-action">Add New Car</a> <a
						href="${pageContext.request.contextPath }/admin/viewOrders"
						class="list-group-item list-group-item-action">Order Details</a> <a
						href="${pageContext.request.contextPath }/admin/dologout"
						class="list-group-item list-group-item-action">Logout</a>
				</div>
			</div>
			<div class="col-xl-8 col-md-8 col-8">
				<div class="jumbotron">
					<a
						href="${pageContext.request.contextPath }/admin/view_cars_approval"
						class="btn btn-info" role="button">View All Cars For Approval</a>
				</div>
			</div>
		</div>
	</div>
	<br>
	<div class="container" id="table_body">
		<div class="row">
			<div class="col-xl-12 col-md-12 col-12">
				<div class="jumbotron">
					<h2>Here is the list of all cars for approval:</h2>
					<br>
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th>CarID</th>
								<th>CarCompany</th>
								<th>CarModel</th>
								<th>Condition</th>
								<th>FuelType</th>
								<th>Km_driven</th>
								<th>Pricing</th>
								<th>User ID</th>
								<th>Image</th>
								<th>Action1</th>
								<th>Reason for rejection</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${approvalList}" var="appl">
								<tr>
									<td>${appl.carID}</td>
									<td>${appl.carCompany}</td>
									<td>${appl.carModel}</td>
									<td>${appl.condition}</td>
									<td>${appl.fuelType}</td>
									<td>${appl.km_driven}</td>
									<td>${appl.pricing}</td>
									<td>${appl.userLogin.userID}</td>
									<td><img alt="car image" style="height:100px;width:150px" src="<c:url value="/resources/images/${appl.image}" />" /></td>
									<td><a class="btn btn-success" href="${pageContext.request.contextPath }/admin/update/${appl.carID}/approved">Accept</a></td>
									<th>
										<form action="${pageContext.request.contextPath }/admin/update/${appl.carID}/rejected"
											method="get">
											<div class="form-group">
												<textarea class="form-control" rows="5" id="reason"
													name="Reason" required></textarea>
											</div>
											<input type="submit" value="Rejected" />
										</form>
									</th>
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