package com.sinensia.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinensia.business.UsuarioLogic;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		String method = request.getParameter("method");

		try {
			UsuarioLogic userlogic = new UsuarioLogic();
			Integer idusuario = userlogic.comprobarUsuario(nombre, password, method);
			if (idusuario != 0) {

				session.setAttribute("idusuario", idusuario);
				session.setAttribute("intmes", LocalDate.now().getMonthValue());
				session.setAttribute("method", method);
				response.sendRedirect(request.getContextPath() + "/MainappController");
			} else {
				String destination = "login.jsp";
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
