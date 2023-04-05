<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Customer Management</title>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${customer != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${customer == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${customer != null}">
            			Edit Customer
            		</c:if>
						<c:if test="${customer == null}">
            			Add New Customer
            		</c:if>
					</h2>
				</caption>

				<c:if test="${customer != null}">
					<input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Customer Full Name</label> <input type="text"
						value="<c:out value='${customer.full_name}' />" class="form-control"
						name="full_name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Date of Birth</label> <input type="text"
						value="<c:out value='${customer.date_of_birth}' />" class="form-control"
						name="date_of_birth">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Email</label> <input type="text"
						value="<c:out value='${customer.email}' />" class="form-control"
						name="email">
				</fieldset>
                                <fieldset class="form-group">
					<label>Customer Age</label> <input type="text"
						value="<c:out value='${customer.age}' />" class="form-control"
						name="age">
				</fieldset>
                                <fieldset class="form-group">
					<label>Customer Gender</label> <input type="text"
						value="<c:out value='${customer.gender}' />" class="form-control"
						name="gender">
				</fieldset>
                                                <fieldset class="form-group">
					<label>Customer Loan Balance</label> <input type="text"
						value="<c:out value='${customer.loan_balance}' />" class="form-control"
						name="loan_balance">
				</fieldset>
                                                <fieldset class="form-group">
					<label>Customer Used Amount</label> <input type="text"
						value="<c:out value='${customer.used_amount}' />" class="form-control"
						name="used_amount">
				</fieldset>
                                                <fieldset class="form-group">
					<label>Customer Installment Plan</label> <input type="text"
						value="<c:out value='${customer.installment_plan}' />" class="form-control"
						name="installment_plan">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>