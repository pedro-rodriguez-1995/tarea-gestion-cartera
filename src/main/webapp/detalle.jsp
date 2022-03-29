<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="logchecker.jsp" />
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

<title>Listado Movimientos</title>
</head>
<body>
	<div class="container mt-3">
		<%
		@SuppressWarnings("unchecked")
		List<Movimiento> listamov = (List<Movimiento>) request.getAttribute("listamov");
		Locale spanishLocale = new Locale("es", "ES");
		int intmes = (Integer) request.getAttribute("intmes");
		String mes = LocalDate.of(2022, intmes, 1).getMonth().getDisplayName(TextStyle.FULL, spanishLocale);
		int idusuario = (Integer) request.getAttribute("idusuario");
		int idcategoria = (Integer) request.getAttribute("idcategoria");
		int nPages = (Integer) request.getAttribute("noOfPages");
		int currentPage = (Integer) request.getAttribute("currentPage");
		int recordsPerPage = (Integer) request.getAttribute("recordsPerPage");
		%>


		<div class="top-main">
			<h1>Detalle</h1>
		</div>

		<form action="DetalleController" class="form-inline" method="post">




			<div class="form-group mb-4">
				<input type="hidden" id="idcategoria" name="idcategoria"
					value="<%=idcategoria%>"> <input type="hidden"
					id="currentPage" name="currentPage" value="1"> <label
					for="records">Registros por página:</label> <select
					class="form-control" id="records" name="recordsPerPage">
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="15">15</option>
				</select>
			</div>


			<button type="submit" class="btn btn-primary">Aplicar</button>

		</form>
		<h3 style="text-align: center">Movimientos</h3>
		<table class="table table-light table-striped table-hover">
			<thead>
				<tr>

					<th scope="col" class="w-33">Fecha</th>
					<th scope="col" class="w-33">Importe</th>
					<th scope="col" class="w-33"></th>
				</tr>
			</thead>
			<tbody>
				<%
					MovimientoLogic movlogic = new MovimientoLogic();

					for (Movimiento mov : listamov) {
					%>
				<tr>
					<th scope="row"><%=mov.getFecha().toString()%></th>

					<td><%=mov.getImporte()%> EUR</td>
					<td><form action="DetalleController" method="post"
							id="formdetalle">
							<input type="hidden" id="idcategoria" name="idcategoria"
								value="<%=idcategoria%>"> <input type="hidden"
								id="currentPage" name="currentPage" value="<%=currentPage%>">
							<input type="hidden" name="recordsPerPage"
								value="<%=recordsPerPage%>"> <input type="hidden"
								name="intmes" value="<%=intmes%>">
							<button type="submit" form="formdetalle" id="idmovimiento"
								class="btn btn-primary btn-sm active" name="idmovimiento"
								value="<%=mov.getIdmovimiento()%>">Eliminar</button>
						</form></td>

				</tr>

				<%
					}
					%>
			</tbody>
		</table>

		<form action="DetalleController" method="post" id="formpag">
			<input type="hidden" id="idcategoria" name="idcategoria"
				value="<%=idcategoria%>"> <input type="hidden"
				name="recordsPerPage" value="<%=recordsPerPage%>"> <input
				type="hidden" name="intmes" value="<%=intmes%>">
			<nav>
				<ul class="pagination justify-content-center">
					<%
						if (currentPage > 1) {
						%>
					<li class="page-item"><button class="btn" type="submit"
							form="formpag" id="currentPage" value="<%=currentPage - 1%>"
							name="currentPage">&laquo;</button></li>
					<%
						}
						%>
					<li class="page-item"><%=currentPage%></li>
					<%
						if (currentPage < nPages) {
						%>
					<li class="page-item"><button class="btn" type="submit"
							form="formpag" id="currentPage" value="<%=currentPage + 1%>"
							name="currentPage">&raquo;</button></li>
					<%
						}
						%>
				</ul>
			</nav>
		</form>
		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">
				<h3>
					Total:
					<%=movlogic.totalMovimientosCategoria(idusuario, idcategoria, intmes, (String) session.getAttribute("method"))%>
					EUR
				</h3>
			</div>
			<div class="col-sm"></div>
		</div>
		<a href="MainappController" class="btn btn-primary btn-lg active"
			role="button">Volver</a>

	</div>



</body>
</html>