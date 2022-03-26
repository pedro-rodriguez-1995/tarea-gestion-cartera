package com.sinensia.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinensia.business.MovimientoLogic;

/**
 * Servlet implementation class InsertarMovController
 */
public class InsertarMovController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarMovController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idusuario = (Integer) session.getAttribute("idusuario");
		int idcategoria = Integer.valueOf(request.getParameter("categoriaid"));
		String tipo = request.getParameter("tipo");
		BigDecimal importe = new BigDecimal(request.getParameter("importe"));
		LocalDate fecha = LocalDate.now();
		String destination = request.getParameter("return");
		try {
			MovimientoLogic movlogic = new MovimientoLogic();
			if (movlogic.insertarMovimiento(idcategoria, idusuario, importe, tipo, fecha) != 0) {

				request.setAttribute("errorstatus", "false");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
				requestDispatcher.forward(request, response);
			} else {

				;
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
				request.setAttribute("errorstatus", "true");
				requestDispatcher.forward(request, response);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			throw new ServletException("Error de SQL: " + e.getMessage());
		}
	}

}
