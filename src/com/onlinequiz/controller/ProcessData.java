package com.onlinequiz.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinequiz.dao.QuizDao;
import com.onlinequiz.dao.RecoveryQuestionDao;
import com.google.gson.Gson;


@WebServlet("/ProcessData")
public class ProcessData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<Integer, String> dataMap;
	private Map<String, Object> dataMap2;

	public ProcessData() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String json="";
		String param="";
		param=(String) request.getParameter("load");
		System.out.println("PROCESS DATA param is "+param);
		if(param.equals("recoveryQue"))
		{
			System.out.println("param is now "+param);
			HttpSession session = request.getSession();
			session.removeAttribute("msg");
			dataMap =  RecoveryQuestionDao.getRecoveryQuestions();
			json= new Gson().toJson(dataMap);
			response.setContentType("application/json");
			response.getWriter().write(json);
		}

		if(param.equals("quizList"))
		{
			System.out.println("param is now "+param);
			HttpSession session = request.getSession();
			session.removeAttribute("msg");
			dataMap = QuizDao.getQuiz();
			json= new Gson().toJson(dataMap);

			System.out.println(" Quiz List is :"+json);
			response.setContentType("application/json");
			response.getWriter().write(json);
		}
		if(param.equals("quizDetail"))
		{
			System.out.println("Process Quiz detailssss...");
			String quizName = (String)request.getParameter("quiz");
			dataMap2 = QuizDao.getQuiz(quizName);
			System.out.println(dataMap2);
			json= new Gson().toJson(dataMap2);
			HttpSession session=request.getSession();  
			session.setAttribute("isTimed",dataMap2.get("isTimed"));
			
			//if(dataMap2.get("isTimed").equals("true")){
				session.setAttribute("quizTime",dataMap2.get("quizTime"));
				session.setAttribute("noOfQue",dataMap2.get("noOfQue"));
				System.out.println("Quiz timed or not : "+dataMap2.get("isTimed"));
//			}
//			else{
//				session.setAttribute("quizTime","-");
//				System.out.println(dataMap2.get("isTimed"));
//			}
			System.out.println(" Quiz Detail is :"+json);
			response.setContentType("application/json");
			response.getWriter().write(json);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
