<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hibernate Example</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>My Web Site</h1>
			<p> My Web Site Slogan </p>
			<hr/>
			<a href="register.jsp" class="btn btn-warning"> REGISTER </a>
			<a href="login.jsp" class="btn btn-success"> LOGIN </a>
		</div>
		<div class="jumbotron">
			<h3> My Web Site Registration Page</h3>
			<form action="reg" method="post">
				<label>Name</label>
				<input type="text" name="name" class="form-control"/>
				<label>Address</label>
				<textarea name="address" class="form-control"></textarea>
				<label>Email</label>
				<input type="email" name="email" class="form-control"/>
				<label>Password</label>
				<input type="password" name="password" class="form-control"/>
				<label>Mobile</label>
				<input type="text" name="mobile" class="form-control"/> 
				<input type="reset" value="RESET" class="btn btn-warning"/>
				<input type="submit" value="REGISTER" class="btn btn-danger"/>
			</form>
		</div>
	</div>
</body>
</html>