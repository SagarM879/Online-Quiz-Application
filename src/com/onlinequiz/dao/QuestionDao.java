package com.onlinequiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.onlinequiz.model.Question;

public class QuestionDao {

	private static Map<Integer, Question> questionList = null;

	public static Map<Integer, Question> getQuestion(int quizID)
	{
		System.out.println("get Quiz from db ");
		Connection conn=ConnectionManager.getConnection();
		Statement stmt=null;

		try {
			stmt= conn.createStatement();
			questionList = new LinkedHashMap<>();
			Question que = null;
			String getUserQuery= "SELECT * FROM question where quizID = "+quizID;
			ResultSet rs = stmt.executeQuery(getUserQuery);
			int count = 1;
			while(rs.next()){
				//Retrieve by column name

				int questionID = rs.getInt("questionID");
				quizID  = rs.getInt("quizID");
				String question = rs.getString("question");
				String correctAns = rs.getString("correctAns");
				String optionA = rs.getString("optionA");
				String optionB = rs.getString("optionB");
				String optionC = rs.getString("optionC");
				String optionD = rs.getString("optionD");
				que = new Question(questionID,quizID, question, correctAns, optionA, optionB, optionC, optionD);
				questionList.put(count, que);
				count++;
				System.out.println(questionList+" "+count);
			}
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return questionList;

	}

	public static boolean addQuestion(Question question)
	{
		Connection conn=ConnectionManager.getConnection();
		PreparedStatement pst;
		int rowUpdated;
		boolean flag = false;
		rowUpdated = 0;
		try {
			pst= conn.prepareStatement(Queries.addQuestion);
			pst.setInt(1,question.getQuizID());
			pst.setString(2,question.getQuestion());
			pst.setString(3,question.getCorrectAns());
			pst.setString(4,question.getOptionA());
			pst.setString(5,question.getOptionB());
			pst.setString(6,question.getOptionC());
			pst.setString(7,question.getOptionD());

			rowUpdated = pst.executeUpdate();
			if(rowUpdated > 0)
				flag = true;
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{

			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return flag;

	}

}
