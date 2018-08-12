package com.onlinequiz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinequiz.dao.QuestionDao;
import com.onlinequiz.dao.UserDao;
import com.onlinequiz.model.Question;

public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AddQuestion() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("CreateQuiz Servlet Invoked");

		int quizID;
		String question;
		String correctAns;
		String optionA;
		String optionB;
		String optionC;
		String optionD;
		Question addQuestion;

		try
		{
			quizID=Integer.parseInt(request.getParameter("quizName"));
			question= request.getParameter("question").trim();
			correctAns = request.getParameter("correctAns");
			optionA = request.getParameter("optionA").trim();
			optionB = request.getParameter("optionB").trim();
			optionC = request.getParameter("optionC").trim();
			optionD = request.getParameter("optionD").trim();

			System.out.println(quizID+" "+question+" "+correctAns+" "+optionA+" "+optionB+" "+optionC+" "+optionD);
			addQuestion = new Question(quizID, question, correctAns, optionA, optionB, optionC, optionD);
			boolean addQue = QuestionDao.addQuestion(addQuestion);
			if(!addQue){
				request.setAttribute("msg", UserDao.msg);
				request.getRequestDispatcher("addQuestion.jsp").forward(request, response);
				System.out.println("Question not Created Successfully!");	

			}
			else
			{
				response.sendRedirect("addQuestion.jsp");
				System.out.println("Question Created Successfully!");

			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
