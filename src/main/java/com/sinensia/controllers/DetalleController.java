package com.sinensia.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinensia.business.MovimientoLogic;
import com.sinensia.model.Movimiento;

/**
 * Servlet implementation class DetalleController
 */
public class DetalleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetalleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int intmes = (Integer) session.getAttribute("intmes");
		int idusuario = (Integer) session.getAttribute("idusuario");
		int idcategoria = Integer.valueOf(request.getParameter("idcategoria"));
		String destination = "detalle.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		request.setAttribute("intmes", intmes);
		request.setAttribute("idusuario", idusuario);
		request.setAttribute("idcategoria", idcategoria);

		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
		MovimientoLogic movlogic = new MovimientoLogic();

		try {
			if (request.getParameter("idmovimiento") != null) {
				int idmovimiento = Integer.parseInt(request.getParameter("idmovimiento"));

				movlogic.borrarMovimiento(idmovimiento);

			}

			List<Movimiento> listamov = movlogic.listarMovimientosCategoriaPag(idusuario, idcategoria, intmes,
					currentPage, recordsPerPage);
			int rows = movlogic.listarMovimientosCategoria(idusuario, idcategoria, intmes).size();

			int nOfPages = movlogic.numOfPages(rows, recordsPerPage);

			request.setAttribute("noOfPages", nOfPages);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("recordsPerPage", recordsPerPage);

			request.setAttribute("listamov", listamov);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		requestDispatcher.forward(request, response);
	}

}
