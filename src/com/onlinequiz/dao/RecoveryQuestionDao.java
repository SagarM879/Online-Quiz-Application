package com.onlinequiz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecoveryQuestionDao {
	static int recoveryQuestionID;
	static String question;
	private static Map<Integer,String> dataMap=null;
	public static int count;

	public static Map<Integer, String> getRecoveryQuestions()
	{
		System.out.println("get Recovery Question details from db ");
		Connection conn=ConnectionManager.getConnection();
		Statement stmt=null;
		dataMap = new LinkedHashMap<>();

		try {
			count = 0;
			stmt= conn.createStatement();
			String getRecoveryQuestions= "SELECT * FROM recoveryquestion";
			ResultSet rs = stmt.executeQuery(getRecoveryQuestions);
			while(rs.next()){
				recoveryQuestionID = rs.getInt("recoveryQuestionID");	
				question = rs.getString("question");
				//System.out.println(recoveryQuestionID + "  "+question);
				dataMap.put(recoveryQuestionID, question);
				count++;
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
		return dataMap;
	}


}
