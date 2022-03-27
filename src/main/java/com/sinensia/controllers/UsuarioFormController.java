package com.sinensia.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinensia.business.UsuarioLogic;

/**
 * Servlet implementation class LoginController
 */
public class UsuarioFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioFormController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String method = request.getParameter("method");

		try {
			UsuarioLogic userlogic = new UsuarioLogic();
			if (userlogic.insertarUsuario(nombre, password, method) != 0) {

				String destination = "usuarioform.jsp";
				request.setAttribute("errorstatus", "false");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
				requestDispatcher.forward(request, response);
			} else {
				String destination = "usuarioform.jsp";
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
