<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     <%@ page import = "management.web.UserServlet" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar"
			style="background-color: tomato">
			<div>
				<h1 class="navbar-brand"> Login Success, Welcome Admin </h1>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Products</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
	

		<div class="container">
			<h3 class="text-center">List of Products</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					Product</a>
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
					Search Product</a>
				<a href="<%=request.getContextPath()%>/list" class="btn btn-success">
					Total Product</a>
				
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Product Name</th>
						<th>Product Price</th>
						<th>Product Quantity</th>
						<th>Product Discount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.pid}" /></td>
							<td><c:out value="${user.pname}" /></td>
							<td><c:out value="${user.pprice}" /></td>
							<td><c:out value="${user.pquantity}" /></td>
							<td><c:out value="${user.pdiscount}" /></td>
							<td><a href="edit?id=<c:out value='${user.pid}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="delete?id=<c:out value='${user.pid}' />">Delete</a></td>
						</tr>
					</c:forEach>
	
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>