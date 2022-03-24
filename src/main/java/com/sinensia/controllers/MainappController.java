package com.sinensia.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainappController
 */
public class MainappController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainappController() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int intmes = 1;
		int idusuario = 0;
		if (session.getAttribute("intmes") != null) {
			intmes = (Integer) session.getAttribute("intmes");

		}
		if (session.getAttribute("idusuario") != null) {
			idusuario = (Integer) session.getAttribute("idusuario");

		}
		if (request.getParameter("page") != null) {
			intmes = Integer.parseInt(request.getParameter("page"));
		}

		String destination = "mainapp.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		request.setAttribute("intmes", intmes);
		request.setAttribute("idusuario", idusuario);
		requestDispatcher.forward(request, response);

	}

}
