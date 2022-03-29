<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sinensia.business.CategoriaLogic"%>
<%@ page import="com.sinensia.model.Categoria"%>
<jsp:include page="logchecker.jsp"/>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Añadir Ingreso</title>
</head>
</head>

<body>
	<div class="container mt-3">
		<div class="header-login">
		<img class="mb-4"
			src="img/add-button.png"
			alt="" width="72" height="72">
			<h1>Nuevo Ingreso</h1>
		</div>
		<div class="inner-login">
		<h3>Introduzca datos del ingreso</h3>
		<% 
			String errorstatus =(String)request.getAttribute("errorstatus");
		if (errorstatus !=null && errorstatus.equals("true")){
			
			%>
		<div class="alert alert-danger" role="alert" >Error insertando ingreso</div>
		<%}else if (errorstatus !=null && errorstatus.equals("false")){ %>
		<div class="alert alert-success" role="alert" >Ingreso añadido con exito</div>
		<%} %>
		<form action="InsertarMovController" method="post">

			<div class="mb-3">
				<label for="importe">Cantidad:</label> <input type="number" required
					class="form-control" id="importe" min="1" max="99999999999"placeholder="Introduzca cantidad"
					name="importe">
			</div>
			<div class="mb-3 mt-3">
				<label for="categoriaid">Categoria:</label> <select
					name="categoriaid" id="categoriaid" class="form-control">
					<% 
					CategoriaLogic catlogic = new CategoriaLogic();
					for(Categoria categoria : catlogic.listarCategoriasTipo("ingreso",(String)session.getAttribute("method"))){ %>
						<option value="<%=categoria.getIdcategoria() %>"><%=categoria.getNombre() %></option>
					<%} %>
				</select>
			</div>
			
				<label for="fecha">Fecha:</label> <input type="date" required
					class="form-control" id="fecha" name="fecha">
		
			<input id="tipo" name="tipo" type="hidden" value="ingreso">
			<input id="return" name="return" type="hidden" value="insertaringreso.jsp">
			
			
			<br>
			<button type="submit" class="btn btn-lg btn-primary">Añadir</button>
			<a href="MainappController" class="btn btn-lg btn-primary" role="button">Volver</a>
		</form>
		
		</div>
	</div>
</body>
</html>