<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Customer Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="AdminHome.jsp" class="navbar-brand"> Home </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Customers</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Customers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Customer</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Full Name</th>
                                                <th>Date of Birth</th>
                                                <th>Email</th>
                                                <th>Age</th>
                                                <th>Gender</th>
						<th>Loan Balance</th>
						<th>Used Amount</th>
                                                <th>Installment Plan</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="customer" items="${listCustomer}">

						<tr>
							<td><c:out value="${customer.id}" /></td>
							<td><c:out value="${customer.full_name}" /></td>
                                                        <td><c:out value="${customer.date_of_birth}" /></td>
							<td><c:out value="${customer.email}" /></td>
                                                        <td><c:out value="${customer.age}" /></td>
                                                        <td><c:out value="${customer.gender}" /></td>
							<td><c:out value="${customer.loan_balance}" /></td>
                                                        <td><c:out value="${customer.used_amount}" /></td>
                                                        <td><c:out value="${customer.installment_plan}" /></td>
							<td><a href="edit?id=<c:out value='${customer.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="delete?id=<c:out value='${customer.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>