<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
  <%
	if (session.getAttribute("idusuario")==null){
		
		%>
  <script>
  document.getElementById("logout").submit();
  </script>
  <%} %>
<meta charset="ISO-8859-1">
</head>

<nav class="navbar navbar-light bg-light">

  <form class="form-inline" action="LogoutController" method="post" id="logout">
    
    <button class="btn  my-2 my-sm-0" type="submit">Salir</button>
  </form>

</nav>
</html>