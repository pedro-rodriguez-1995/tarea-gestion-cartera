<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sinensia.business.CategoriaLogic"%>
<%@ page import="com.sinensia.model.Categoria"%>
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
<title>Añadir Gasto</title>
</head>
</head>

<body>
	<div class="container mt-3">
		<img class="mb-4"
			src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
			alt="" width="72" height="72">
		<h2>Añadir Gasto</h2>
		<% 
			String errorstatus =(String)request.getAttribute("errorstatus");
		if (errorstatus !=null && errorstatus.equals("true")){
			
			%>
		<div class="alert alert-danger" role="alert" >Error insertando gasto</div>
		<%}else if (errorstatus !=null && errorstatus.equals("false")){ %>
		<div class="alert alert-success" role="alert" >Gasto añadido con exito</div>
		<%} %>

		<form action="InsertarMovController" method="post">

			<div class="mb-3">
				<label for="nombre">Cantidad:</label> <input type="number" required
					class="form-control" id="importe" placeholder="Introduzca cantidad"
					name="importe">
			</div>
			<div class="mb-3 mt-3">
				<label for="categoriaid">Categoria:</label> <select
					name="categoriaid" id="categoriaid">
					<%
					CategoriaLogic catlogic = new CategoriaLogic();
					for (Categoria categoria : catlogic.listarCategoriasTipo("gasto")) {
					%>
					<option value="<%=categoria.getIdcategoria()%>"><%=categoria.getNombre()%></option>
					<%
					}
					%>
				</select>
			</div>
			<input id="tipo" name="tipo" type="hidden" value="gasto">
			<input id="return" name="return" type="hidden" value="insertargasto.jsp">
			<button type="submit" class="btn btn-primary">Añadir</button>
		</form>
		<a href="MainappController">Volver</a>
	</div>
</body>
</html>