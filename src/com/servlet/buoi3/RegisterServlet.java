package com.servlet.buoi3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.dao.UserDAO;
import com.entity.User;
import com.utils.HibernateUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.getRequestDispatcher("/views/auth/register.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User entity = new User();
		try {
			BeanUtils.populate(
				entity,
				request.getParameterMap()
			);
			
			entity.setRole(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserDAO dao = new UserDAO();
		dao.store(entity);

		doGet(request, response);
	}

	@Override
	public void init() throws ServletException
	{
		System.out.println("Initializing...");
		super.init();
	}

	@Override
	public void destroy()
	{
		System.out.println("Destroying...");
		super.destroy();
	}

	@Override
	public void service(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		System.out.println("Processing...");
		super.service(request, response);
	}
}
