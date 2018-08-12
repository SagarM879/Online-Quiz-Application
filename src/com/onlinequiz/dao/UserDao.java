package com.onlinequiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.onlinequiz.model.User;

public class UserDao {

	public static String msg;

	public static User getUser(String username)
	{
		System.out.println("get user details from db for "+username);
		Connection conn=ConnectionManager.getConnection();
		Statement stmt=null;
		User user = null;
		try {
			stmt= conn.createStatement();
			String getUserQuery= "SELECT * FROM user where userName='"+username+"'";
			ResultSet rs = stmt.executeQuery(getUserQuery);
			while(rs.next()){
				//Retrieve by column name
				int userID  = rs.getInt("userID");
				String userName = rs.getString("userName");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String emailID = rs.getString("emailID");
				String password = rs.getString("password");
				int recoveryQuestionID = rs.getInt("recoveryQuestionID");	
				String recoveryAnswer = rs.getString("recoveryAnswer");


				user = new User(userID,userName,firstName, lastName, emailID,password,recoveryQuestionID,recoveryAnswer);
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

		return user;
	}

	public static boolean createUser(User user)
	{
		Connection conn=ConnectionManager.getConnection();
		PreparedStatement pst=null;
		boolean flag=false;

		try {

			pst= conn.prepareStatement(Queries.addUser);

			pst.setString(1,user.getUserName());
			pst.setString(2,user.getFirstName());
			pst.setString(3,user.getLastName());
			pst.setString(4,user.getEmailID());
			pst.setString(5,user.getPassword());
			pst.setInt(6,user.getRecoveryQuestionID());
			pst.setString(7,user.getRecoveryAnswer());
			int rowUpdated = pst.executeUpdate();
			if(rowUpdated > 0)
				flag=true;
			conn.close();
		}
		catch(MySQLIntegrityConstraintViolationException icve)
		{
			msg = "User Name is already Exist";
		}
		catch (SQLException sqle) {
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


	public static boolean updateUser(User user) {

		Connection conn=ConnectionManager.getConnection();
		PreparedStatement pst=null;

		try {
			pst= conn.prepareStatement(Queries.updateUser);

			pst.setString(2,user.getUserName());
			pst.setString(3,user.getFirstName());
			pst.setString(4,user.getLastName());
			pst.setString(5,user.getEmailID());
			pst.setString(6,user.getPassword());
			pst.setInt(7,user.getRecoveryQuestionID());
			pst.setString(8,user.getRecoveryAnswer());
			pst.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}

	public static boolean updateUserPassword(String userName,String pass)
	{
		Connection conn=ConnectionManager.getConnection();
		PreparedStatement pst=null;

		try {
			pst= conn.prepareStatement(Queries.updateUserPass);

			pst.setString(1,pass);
			pst.setString(2, userName);
			pst.execute();
		} catch (SQLException e) {
			msg = "Connection Problem, Password is not Updated";
			e.printStackTrace();
		}
		return true;

	}
	public boolean deleteUser(String username)
	{
		Connection conn=ConnectionManager.getConnection();
		PreparedStatement pst=null;

		try {
			pst= conn.prepareStatement(Queries.deleteUser);

			pst.setString(1,username);
			pst.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}
}
