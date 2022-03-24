<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="logchecker.jsp"/>
<%@ page import="com.sinensia.business.MovimientoLogic"%>
<%@ page import="com.sinensia.model.Movimiento"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="java.time.format.TextStyle"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Listado Movimientos</title>
</head>
<body>
	<div class="container mt-3">
		<%
		Locale spanishLocale = new Locale("es", "ES");
		int intmes =(Integer) request.getAttribute("intmes");
		String mes = LocalDate.of(2022, intmes, 1).getMonth().getDisplayName(TextStyle.FULL, spanishLocale);
		%>


		
		<h1>Detalle</h1>
		<table class="table">
			<thead>
				<tr>
					
					<th scope="col">Fecha</th>
					<th scope="col">Importe</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<%
				int idusuario = (Integer) request.getAttribute("idusuario");
				int idcategoria = (Integer) request.getAttribute("idcategoria");
				MovimientoLogic movlogic = new MovimientoLogic();
				@SuppressWarnings("unchecked")
				List<Movimiento> listamov =(List<Movimiento>)request.getAttribute("listamov");

				for (Movimiento mov : listamov) {
				%>
				<tr>
					<th scope="row"><%= mov.getFecha().toString() %></th>
					
					<td><%=mov.getImporte() %> EUR</td>
					<td><form action="DetalleController" method="post"
							id="formdetalle">
							<input type="hidden" id="idcategoria"
								name="idcategoria" value="<%=idcategoria %>">
							<button type="submit" form="formdetalle" id="idmovimiento"
								name="idmovimiento" value="<%= mov.getIdmovimiento() %>">Eliminar</button>
						</form></td>

				</tr>

				<%
				}
				%>
			</tbody>
		</table>
		
	<div class="row">
    <div class="col-sm">
    </div>
    <div class="col-sm">
      <h3>Total: <%=movlogic.totalMovimientosCategoria(idusuario,idcategoria, intmes) %> EUR</h3>
    </div>
    <div class="col-sm">
    </div>
  </div>
		<a href="MainappController">Volver</a>
	</div>
	
	
		
	
</body>
</html>