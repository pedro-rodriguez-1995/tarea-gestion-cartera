<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sinensia.business.CategoriaLogic"%>
<%@ page import="com.sinensia.model.Categoria"%>
<%@ page import="com.sinensia.business.MovimientoLogic"%>
<%@ page import="com.sinensia.model.Movimiento"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.math.BigDecimal"%>
<%@ page import="java.time.format.TextStyle"%>
<jsp:include page="logchecker.jsp"/>
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
		Locale spanishLocale = new Locale("es", "ES");
		int intmes =(Integer) request.getAttribute("intmes");
		String mes = LocalDate.of(2022, intmes, 1).getMonth().getDisplayName(TextStyle.FULL, spanishLocale);
		%>
		
		<div class="top-main">
		<h2>
			Listado de movimientos por categoría </h2>
			<nav>
			<ul class="pagination justify-content-center">
			<%if(intmes>1){ %>
				<li class="page-item buttonlink"><a class="page-link" href="MainappController?page=<%=intmes-1 %>"
					tabindex="-1">&laquo;</a></li>
			<%} %>
				<li class="page-item textlink"><%=mes%></li>
				<%if(intmes<12){ %>
				<li class="page-item buttonlink"><a class="page-link" href="MainappController?page=<%=intmes+1 %>">&raquo;</a></li>
				<%} %>
			</ul>
		</nav>
		</div>
		<div class="inner-table">
		<h3>Gastos</h3>
		<table class="table table-light table-striped table-hover">
			<thead>
				<tr>
					<th scope="col" class="w-25"></th>
					<th scope="col" class="w-25">Nombre</th>
					<th scope="col" class="w-25">Total</th>
					<th scope="col" class="w-25"></th>
				</tr>
			</thead>
			<tbody>
				<%
				int idusuario = (Integer) request.getAttribute("idusuario");
				MovimientoLogic movlogic = new MovimientoLogic();
				CategoriaLogic catlogic = new CategoriaLogic();
				Map<Categoria, BigDecimal> listacategoriasgasto = catlogic.listarCategoriasUsuarioTipo(idusuario, intmes,"gasto",(String)session.getAttribute("method"));

				for (Map.Entry<Categoria, BigDecimal> entry : listacategoriasgasto.entrySet()) {
				%>
				<tr>
					<th scope="row"><img class="img-fluid" width="40" height="40"
						src="<%=entry.getKey().getUrlimagen()%>"></th>
					<td><%=entry.getKey().getNombre()%></td>
					<td><%=entry.getValue()%> EUR</td>
					<td><form action="DetalleController" method="post"
							id="formdetalle">
							<input type="hidden" name="recordsPerPage" value="5">
							<input type="hidden" name="currentPage" value="1">
							<input type="hidden" name="intmes" value="<%=intmes %>">
							<button type="submit" form="formdetalle" id="idcategoria"
								name="idcategoria" class="btn btn-primary btn-sm active" value="<%=entry.getKey().getIdcategoria()%>">Detalle</button>
						</form></td>

				</tr>

				<%
				}
				%>
			</tbody>
		</table>
		<h3>Ingresos</h3>
		<table class="table table-light table-striped table-hover">
			<thead>
				<tr>
					<th scope="col" class="w-25"></th>
					<th scope="col" class="w-25">Nombre</th>
					<th scope="col" class="w-25">Total</th>
					<th scope="col" class="w-25"></th>
				</tr>
			</thead>
			<tbody>
				<%
				
				Map<Categoria, BigDecimal> listacategoriasingreso = catlogic.listarCategoriasUsuarioTipo(idusuario, intmes,"ingreso",(String)session.getAttribute("method"));

				for (Map.Entry<Categoria, BigDecimal> entry : listacategoriasingreso.entrySet()) {
				%>
				<tr>
					<th scope="row"><img class="img-fluid" width="40" height="40"
						src="<%=entry.getKey().getUrlimagen()%>"></th>
					<td><%=entry.getKey().getNombre()%></td>
					<td><%=entry.getValue()%> EUR</td>
					<td><form action="DetalleController" method="post"
							id="formdetalle">
							<input type="hidden" name="recordsPerPage" value="5">
							<input type="hidden" name="currentPage" value="1">
							<button type="submit" form="formdetalle" id="idcategoria"
								name="idcategoria" class="btn btn-primary btn-sm active" value="<%=entry.getKey().getIdcategoria()%>">Detalle</button>
						</form></td>

				</tr>

				<%
				}
				%>
			</tbody>
		</table>
		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">
				<h3>
					Total:
					<%=movlogic.totalMovimientos(idusuario, intmes,(String)session.getAttribute("method")) %>
					EUR
				</h3>
			</div>
			<div class="col-sm"></div>
		</div>


		<div class="row">
			<div class="col col-sm-3">
				<a href="insertargasto.jsp" class="btn btn-primary btn-lg active"
					role="button">Nuevo Gasto</a>
			</div>
			 <div class="col-sm-6"></div>
			<div class="col col-sm-3 ">
				<a href="insertaringreso.jsp" class="btn btn-primary btn-lg active float-end"
					role="button">Nuevo Ingreso</a>
			</div>
		</div>
		</div>
	</div>




</body>
</html>