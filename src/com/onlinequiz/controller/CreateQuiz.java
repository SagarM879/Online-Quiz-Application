package com.onlinequiz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinequiz.dao.QuizDao;
import com.onlinequiz.dao.UserDao;
import com.onlinequiz.model.Quiz;

public class CreateQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static int noOfQue;

	public CreateQuiz() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("CreateQuiz Servlet Invoked");

		String quizName="";

		Boolean isTimed;
		String isTimedValue;
		int quizTime;
		Quiz createQuiz;

		try
		{
			quizName=request.getParameter("quizName");
			noOfQue= Integer.parseInt(request.getParameter("noOfQue"));
			isTimedValue = request.getParameter("isTimed");
			isTimed = false;
			quizTime = 0;
			if(isTimedValue.equals("Yes"))
			{
				isTimed = true;
			}

			if(isTimed == false)
			{
				createQuiz=new Quiz(quizName,noOfQue,isTimed);
			}
			else
			{
				quizTime= Integer.parseInt(request.getParameter("quizTime"));
				createQuiz=new Quiz(quizName,noOfQue,isTimed,quizTime);
			}
			System.out.println(quizName+" "+noOfQue+" "+isTimedValue+" "+isTimed+" "+quizTime);
			boolean regUser = QuizDao.createQuiz(createQuiz);
			if(!regUser){
				request.setAttribute("msg", UserDao.msg);
				request.getRequestDispatcher("createQuiz.jsp").forward(request, response);
				System.out.println("Registration Failed!");	

			}
			else
			{
				response.sendRedirect("home.jsp");
				System.out.println("Quiz Created Successfully!");

			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
