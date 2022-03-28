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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
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
		<h2>Entrar a la aplicaci�n</h2>
		<% 
			String errorstatus =(String)request.getAttribute("errorstatus");
		if (errorstatus !=null && errorstatus.equals("true")){
			
			%>
		<div class="alert alert-danger" role="alert" >Ese Usuario ya existe</div>
		<%}else if (errorstatus !=null && errorstatus.equals("false")){ %>
		<div class="alert alert-success" role="alert" >Usuario creado con exito</div>
		<%} %>
		<form action="UsuarioFormController" method="post">
			
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
			<div class="mb-3 mt-3">
				<label for="password">E-mail:</label> <input type="email"
					required class="form-control" id="email"
					placeholder="Introduzca la contrase�a" name="password">
			</div>
	
			<label for="method">M�todo de gesti�n:</label> <select
					name="method" id="method">
					
						<option value="standard">Est�ndar</option>
						<option value="stored">Stored Procedure</option>
				
				</select>

			<button type="submit" class="btn btn-primary">Crear Usuario</button>
		</form>
		<a href="login.jsp">Volver a Login</a>
	</div>
</body>
</html>