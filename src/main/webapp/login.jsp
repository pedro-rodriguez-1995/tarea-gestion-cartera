<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Log In</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="mystyle.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<body>
	<div class="container mt-3 ">
		<div class="header-login">
		<img class="mb-4"
			src="img/income.png"
			alt="" width="72" height="72">
			<h1>Gesti�n de Cartera</h1>
		</div>
		<div class="inner-login">
		<h3>Entrar a la aplicaci�n</h3>
		<% 
			String errorstatus =(String)request.getAttribute("errorstatus");
		if (errorstatus !=null && errorstatus.equals("true")){
			%>
		<div class="alert alert-danger" role="alert" >Usuario o Contrase�a incorrectos</div>
		<%} %>
		<form action="LoginController" method="post">
			
			<div class="mb-3">
				<label for="nombre">Nombre:</label> <input type="text" required
					class="form-control" id="nombre" placeholder="Introduzca nombre"
					name="nombre">
			</div>
			<div class="mb-3 mt-3">
				<label for="password">Contrase�a:</label> <input type="password"
					required class="form-control" id="password"
					placeholder="Introduzca la contrase�a" name="password">
			</div>
			<label for="method">M�todo de gesti�n:</label> <select
					name="method" id="method">
					
						<option value="standard">Est�ndar</option>
						<option value="stored">Stored Procedure</option>
				
				</select>
			<br>
			<br>
			<button type="submit" class="btn btn-primary btn-lg">Entrar</button>
			<a href="usuarioform.jsp" class="btn btn-primary btn-lg " role="button" aria-pressed="true">Nuevo Usuario</a>
		</form>
		
		
		</div>
	</div>
</body>
</html>