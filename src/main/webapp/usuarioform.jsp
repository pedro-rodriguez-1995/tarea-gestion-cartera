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
      <link rel="stylesheet" href="mystyle.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Log In</title>
</head>
</head>

<body>
	<div class="container mt-3">
	
		<div class="header-login">
		<img class="mb-4"
			src="img/handshake.png"
			alt="" width="72" height="72">
			<h1>Nuevo Usuario</h1>
		</div>
		<div class="inner-login">
		<h3>Introduzca sus datos</h3>
		
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
				<label for="password">Contraseña:</label> <input type="password"
					required class="form-control" id="password"
					placeholder="Introduzca la contraseña" name="password">
			</div>
			<div class="mb-3 mt-3">
				<label for="password">E-mail:</label> <input type="email"
					required class="form-control" id="email"
					placeholder="Introduzca su e-mail" name="email">
			</div>
	
			<label for="method">Método de gestión:</label> <select
					name="method" id="method">
					
						<option value="standard">Estándar</option>
						<option value="stored">Stored Procedure</option>
				
				</select>
<br>
<br>
			<button type="submit" class="btn btn-lg btn-primary">Crear Usuario</button>
			<a href="login.jsp" class="btn btn-lg btn-primary" role="button">Volver a Login</a>
		</form>
		</div>
	</div>
</body>
</html>