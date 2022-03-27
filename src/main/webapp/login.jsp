<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Log In</title>
</head>
</head>

<body>
	<div class="container mt-3">
		<img class="mb-4"
			src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
			alt="" width="72" height="72">
		<h2>Entrar a la aplicación</h2>
		<% 
			String errorstatus =(String)request.getAttribute("errorstatus");
		if (errorstatus !=null && errorstatus.equals("true")){
			%>
		<div class="alert alert-danger" role="alert" >Usuario o Contraseña incorrectos</div>
		<%} %>
		<form action="LoginController" method="post">
			
			<div class="mb-3">
				<label for="nombre">Nombre:</label> <input type="text" required
					class="form-control" id="nombre" placeholder="Introduzca nombre"
					name="nombre">
			</div>
			<div class="mb-3 mt-3">
				<label for="password">Contraseña:</label> <input type="password"
					required class="form-control" id="password"
					placeholder="Introduzca la contraseña" name="password">
			</div>
			<label for="method">Método de gestión:</label> <select
					name="method" id="method">
					
						<option value="standard">Estándar</option>
						<option value="stored">Stored Procedure</option>
				
				</select>

			<button type="submit" class="btn btn-primary">Entrar</button>
		</form>
		<a href="usuarioform.jsp">Nuevo Usuario</a>
	</div>
</body>
</html>