package com.school.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.school.dao.UserDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao loginDao;

	public void init() {
		loginDao = new UserDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}


	private void setCredentials(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");

		if (username == null && password == null) {
			username = request.getParameter("username");
			password = request.getParameter("password");
		}
		session.setAttribute("username", username);
		session.setAttribute("password", password);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.setCredentials(request);
			authenticate(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");

		String result = loginDao.validate(username, password);
		session.setAttribute("role", result);
		if (result != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("resources/dashboard.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("resources/login-error.jsp");
			dispatcher.forward(request, response);
		}

	}

}
