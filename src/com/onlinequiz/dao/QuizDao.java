package com.onlinequiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.onlinequiz.model.Quiz;

public class QuizDao {
	private static Map<Integer, String> dataList=null;
	private static Map<String, Object> dataList2=null;
	public static int count;

	private static String quizByName = null;
	public static Map<Integer, String> getQuiz()
	{
		System.out.println("get Quiz from db ");
		Connection conn=ConnectionManager.getConnection();
		Statement stmt=null;
		dataList = new LinkedHashMap<>();
		try {
			stmt= conn.createStatement();
			String getUserQuery= "SELECT quizID,quizName FROM quiz order by quizName";
			ResultSet rs = stmt.executeQuery(getUserQuery);
			while(rs.next()){
				//Retrieve by column name
				int quizID  = rs.getInt("quizID");
				String quizName = rs.getString("quizName");
				dataList.put(quizID,quizName);
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
		return dataList;

	}




	public static boolean createQuiz(Quiz quiz)
	{
		Connection conn=ConnectionManager.getConnection();
		PreparedStatement pst=null;
		int rowUpdated;
		boolean flag = false;
		rowUpdated = 0;
		try {

			if(quiz.getQuizTime() != 0)
			{
				pst= conn.prepareStatement(Queries.addQuizWithTime);
				pst.setString(1,quiz.getQuizName());
				pst.setInt(2,quiz.getNoOfQue());
				pst.setBoolean(3,quiz.getIsTimed());
				pst.setInt(4,quiz.getQuizTime());
			}
			else
			{
				pst= conn.prepareStatement(Queries.addQuizWithoutTime);
				pst.setString(1,quiz.getQuizName());
				pst.setInt(2,quiz.getNoOfQue());
				pst.setBoolean(3,quiz.getIsTimed());
			}
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
			//finally block used to close resources
			try{

				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return flag;

	}




	public static Map<String, Object> getQuiz(String param) {
		System.out.println("get Quiz details from db ");
		Connection conn=ConnectionManager.getConnection();
		quizByName = "Select * from quiz where quizname = '"+param+"'";
		dataList2 = new LinkedHashMap<>();
		Statement stmt = null;
		try {
			stmt= conn.createStatement();
			ResultSet rs = stmt.executeQuery(quizByName);
			while(rs.next()){
				//Retrieve by column name
				int quizID  =rs.getInt("quizID");
				String quizName = rs.getString("quizName");
				int noOfQue = rs.getInt("noOfQue");
				Boolean isTimed = rs.getBoolean("isTimed");
				int quizTime = rs.getInt("quizTime");

				
				dataList2.put("quizID",quizID);
				dataList2.put("quizName",quizName);
				dataList2.put("noOfQue",noOfQue);
				dataList2.put("isTimed",isTimed);
				if(!isTimed)
					dataList2.put("quizTime","-");
				else
					dataList2.put("quizTime",quizTime);
					System.out.println(quizID+" "+quizName+" "+noOfQue+" "+isTimed+" "+quizTime);
			}
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
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
		return dataList2;

	}


}
