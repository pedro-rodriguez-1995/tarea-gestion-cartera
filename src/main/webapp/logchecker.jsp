<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      <link rel="stylesheet" href="mystyle.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <%
	if (session.getAttribute("idusuario")==null){
		
		%>
  <script>
  document.getElementById("logout").submit();
  </script>
  <%} %>
<meta charset="ISO-8859-1">
</head>

<nav class="navbar navbar-light bg-light ">
  <a class="navbar-brand">Gestion de Cartera</a>
  <form class="form-inline"  action="LogoutController" method="post" id="logout">
    
    <button class="btn btn-outline-warning my-3 my-sm-0" type="submit">Cerrar Sesión</button>
  </form>
</nav>
</html>