package com.onlinequiz.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.onlinequiz.model.Question;
import com.onlinequiz.util.EmailUtility;


public class SubmitQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String qname="";

	public SubmitQuiz() {
		super();
	}


	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Submit Quiz Invoked..!");
		Map<Integer, Question> queList ;
		int userID;
		String userName,firstName,lastName,emailID;
		HttpSession session=request.getSession();  
		userID = (int) session.getAttribute("userID");
		userName = (String) session.getAttribute("userName");
		firstName = (String) session.getAttribute("firstName");
		lastName = (String) session.getAttribute("lastName");
		emailID = (String) session.getAttribute("emailID");


		String name = firstName+" "+lastName;

		queList = StartQuiz.queList;
		int noOfQue = 0;
		String fileName = firstName+"_"+lastName+"_"+qname+".pdf";

		int index = this.getClass().getClassLoader().getResource("").getPath().indexOf(".");
		String path = this.getClass().getClassLoader().getResource("").getPath().substring(0, index).replaceAll("%20", " ")+"OnlineQuiz/WebContent/Reports/"+fileName;
		//System.out.println(noOfQue+" Que List is : "+queList);
		int marks = 0;
		String json="";
		String param = (String) request.getParameter("param");;


		if(param.equals("submitQuiz")){
			qname = request.getParameter("quizName");
			System.out.println("Ws Dir : "+path);
			for(int i=1;i<=noOfQue;i++)
			{
				Question que = queList.get(i);
				String selAns = que.getSelectedAns();
				//System.out.println("Ans is :"+selAns+"  "+que.getCorrectAns());

				if(que.getCorrectAns().equals(selAns))
					marks++;
			}

			noOfQue = Integer.parseInt(request.getParameter("noOfQue"));

			PDDocument doc = null;
			try{
				doc = new PDDocument();
				PDFont font = PDType1Font.HELVETICA_BOLD;
				PDPage page = new PDPage();
				PDPageContentStream conStream = new PDPageContentStream(doc, page,true,true);
				conStream.beginText();
				conStream.setFont(font, 40);
				conStream.moveTextPositionByAmount(200, 700);
				conStream.drawString("Certificate");
				conStream.endText();

				conStream.beginText();
				conStream.setFont(font, 20);
				conStream.moveTextPositionByAmount(100, 650);
				conStream.drawString("Mr./Ms. "+name);
				conStream.endText();

				conStream.beginText();
				conStream.setFont(font, 20);
				conStream.moveTextPositionByAmount(100, 600);
				conStream.drawString("has Successfully Completed. "+qname+" Quiz");
				conStream.endText();

				conStream.beginText();
				conStream.setFont(font, 20);
				conStream.moveTextPositionByAmount(100, 550);
				conStream.drawString("Your marks is : "+marks+" out of "+noOfQue);
				conStream.endText();
				conStream.close();
				doc.addPage(page);
				doc.save(path);

				Thread.currentThread();
				Thread.sleep(2000);

				json = "<div id = 'certificate'><br><h1 style='margin-left: 25%'>Certificate</h1><br><br>Mr./Ms. "+name+"<br>has Successfully Completed "+qname+" Quiz<br>Your marks is : "+marks+" out of "+noOfQue+"<br><a href='./Reports/"+fileName+"' target='_blank'>Click here to Download CERTIFICATE</a><br><a href='home.jsp'>Go to Home page</a></div>";
				System.out.println(" Marks : "+json);
				response.setContentType("text/html");
				response.getWriter().write(json);

			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
				doc.close();
			}
		}
		if(param.equals("eMailResult")){
			System.out.println(path+"  "+name);
			EmailUtility.sendEmail(emailID,path,name);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
