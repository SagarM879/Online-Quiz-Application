package com.onlinequiz.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.onlinequiz.dao.QuestionDao;
import com.onlinequiz.dao.QuizDao;
import com.onlinequiz.model.Question;


public class StartQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static Map<Integer, Question> queList ;
	public static Map<Integer, Question> queList2 ;
	public static Boolean isTimed = false;
	public static int quizTime = 0;
	public static int marks;

	public StartQuiz() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Start Quiz Servlet Invoked in GET.!");
		queList2 = new LinkedHashMap<Integer, Question>();
		String json="";
		String param="";
		int queID = 1;
		param=request.getParameter("load");
		int quizID = 0;

		System.out.println("PROCESS DATA param is "+param+" "+queID);
		String selectedAns = "";
		Question que;
		String quizName;

		if(param.equals("start")){	

			quizID = Integer.parseInt(request.getParameter("quiz"));
			quizName = request.getParameter("quizName");

			Map<String, Object> quizMap = QuizDao.getQuiz(quizName);
			isTimed  = (Boolean) quizMap.get("isTimed");
			if(isTimed)
				quizTime  = (int) quizMap.get("quizTime");
			


			queList = QuestionDao.getQuestion(quizID);
			queList2.put(queID, queList.get(queID));
			
			json= new Gson().toJson(queList2);
			System.out.println(" Quiz List is :"+json);
			response.setContentType("application/json");
			response.getWriter().write(json);
		}


		if (param.equals("next")) {

			queID = Integer.parseInt(request.getParameter("queID"));
			que = queList.get(queID);
			selectedAns = request.getParameter("selectedAns");
			que.setSelectedAns(selectedAns);
			System.out.println("Sel Ans is : "+que.getSelectedAns());
			queList.put(queID, que);
			System.out.println(queList);
			queID++;
			System.out.println("PROCESS DATA param is "+param+" "+queID);
			queList2.put(queID, queList.get(queID));
			json= new Gson().toJson(queList2);
			//System.out.println(" Quiz List is :"+json);
			response.setContentType("application/json");
			response.getWriter().write(json);

		}
		if (param.equals("prev")) {

			queID = Integer.parseInt(request.getParameter("queID"));
			que = queList.get(queID);
			selectedAns = request.getParameter("selectedAns");
			que.setSelectedAns(selectedAns);
			System.out.println("Sel Ans is : "+que.getSelectedAns());
			queList.put(queID, que);
			queID--;
			System.out.println("PROCESS DATA param is "+param+" "+queID);
			queList2.put(queID, queList.get(queID));
			//System.out.println(queList+"  "+count);
			json= new Gson().toJson(queList2);
			//System.out.println(" Quiz List is :"+json);
			response.setContentType("application/json");
			response.getWriter().write(json);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Start Quiz Servlet Invoked.!");


	}

}
