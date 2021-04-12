package com.servlet.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO;

	public LoginServlet() {
		this.userDAO = new UserDAO();
	}

	@Override
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.setAttribute("view", "/views/auth/login.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	@Override
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws IOException {
		String email = request.getParameter("email"),
			password = request.getParameter("password");

		User entity = this.userDAO.login(email, password);

		if (entity != null) {
			HttpSession servletSession = request.getSession();

			servletSession.setAttribute("user", entity);

			response.sendRedirect(
				request.getContextPath() + "/admin/users"
			);
		} else {
			response.sendRedirect(
				request.getContextPath() + "/login"
			);
		}
	}
}
