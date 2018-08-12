package com.onlinequiz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinequiz.dao.UserDao;
import com.onlinequiz.model.User;

public class PasswordRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PasswordRecovery() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Password Recovery in Post......!");
		String userName,recoveryAns,password,rePassword;
		int recoveryQue;
		userName = request.getParameter("userName");
		recoveryQue=Integer.parseInt(request.getParameter("recoveryQue"));
		recoveryAns = request.getParameter("recoveryAns");
		password = request.getParameter("password");
		rePassword = request.getParameter("rePassword");

		System.out.println(userName+"  "+recoveryQue+"  "+recoveryAns+"  "+password+"  "+rePassword);

		User user = UserDao.getUser(userName);
		System.out.println(user);
		if(user != null){
			System.out.println(user.getRecoveryQuestionID()+"  "+recoveryQue+"  "+recoveryAns+"  "+user.getRecoveryAnswer()+"  "+rePassword);
			if(user.getRecoveryQuestionID() == recoveryQue && (recoveryAns.toLowerCase()).equals(user.getRecoveryAnswer().toLowerCase())){
				System.out.println("Question is correct..........!");
				boolean result = UserDao.updateUserPassword(userName,password);
				if(!result){
					System.out.println("Password not Updated...");
					request.setAttribute("msg", UserDao.msg);
					request.getRequestDispatcher("forgetPass.jsp").forward(request, response);
				}
				else{
					System.out.println("Password Updated...");
					response.sendRedirect("index.jsp");
				}
			}
			else{
				System.out.println("Question is incorrect..........!");
				request.setAttribute("msg", "Invalid Answer!");
				request.getRequestDispatcher("forgetPass.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("msg", "User Name is Incorrect");
			request.getRequestDispatcher("forgetPass.jsp").forward(request, response);
		}
	}
}
