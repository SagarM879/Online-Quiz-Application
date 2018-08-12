package com.onlinequiz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinequiz.dao.UserDao;
import com.onlinequiz.model.User;

public class Registration extends HttpServlet {
	public Registration()
	{
		super();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Registration Servlet Invoked");

		String userName="";
		String firstName="";
		String lastName="";
		String email="";
		String password="";
		int recoveryQue;
		String recoveryAns="";


		try
		{
			userName=request.getParameter("userName");
			firstName= request.getParameter("firstName");
			lastName=request.getParameter("lastName");
			email=request.getParameter("email");		
			password=request.getParameter("password");
			recoveryQue=Integer.parseInt(request.getParameter("recoveryQue"));
			recoveryAns=request.getParameter("recoveryAns");
			System.out.println(userName+" "+firstName+" "+lastName+" "+email+" "+password+" "+recoveryQue+" "+recoveryAns+" ");
			User createUser=new User(userName,firstName,lastName,email,password,recoveryQue,recoveryAns);
			boolean regUser = UserDao.createUser(createUser);
			if(!regUser){
				request.setAttribute("msg", UserDao.msg);
				request.getRequestDispatcher("registration.jsp").forward(request, response);
				System.out.println("Registration Failed!");	

			}
			else
			{
				response.sendRedirect("index.jsp");
				System.out.println("Registration completed Successfully!");

			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
