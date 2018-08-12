package com.onlinequiz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinequiz.business.*;
import com.onlinequiz.dao.UserDao;
import com.onlinequiz.model.User;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet Invoked");
		String username,password;
		username= request.getParameter("username");
		password= request.getParameter("password");
		User user=null;
		user=	LoginApp.authenticate(username, password);
		System.out.println("Login Servlet got user as "+user);

		if(user == null)
		{
			request.setAttribute("msg", UserDao.msg);
			request.getRequestDispatcher("index.jsp").forward(request, response);	

		}
		else{

			HttpSession session=request.getSession();  
			session.setAttribute("userID",user.getUserID());
			session.setAttribute("userName",user.getUserName());
			session.setAttribute("firstName",user.getFirstName());
			session.setAttribute("lastName",user.getLastName());
			session.setAttribute("emailID",user.getEmailID());
			response.sendRedirect("home.jsp");
		}

	}

}
