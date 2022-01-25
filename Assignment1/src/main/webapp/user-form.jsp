<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<h1 class="navbar-brand"> Product Shop </h1>
			</div>

		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${product != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${product == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit Product
            		</c:if>
						<c:if test="${user == null}">
            			Add New Product
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>ID</label> <input type="text"
						value="<c:out value='${user.pid}' />" class="form-control"
						name="pid" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Product Name</label> <input type="text"
						value="<c:out value='${user.pname}' />" class="form-control"
						name="pname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Product Price</label> <input type="text"
						value="<c:out value='${user.pprice}' />" class="form-control"
						name="pprice">
				</fieldset>

				<fieldset class="form-group">
					<label>Product Quantity</label> <input type="text"
						value="<c:out value='${user.pquantity}' />" class="form-control"
						name="pquantity">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Product Discount</label> <input type="text"
						value="<c:out value='${user.pdiscount}' />" class="form-control"
						name="pdiscount">
				</fieldset>

				<button type="submit" class="btn btn-success">Add</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>