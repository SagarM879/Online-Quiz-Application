package com.onlinequiz.dao;

public final class Queries {

	public static String addUser="INSERT INTO `user`( `userName`, `firstName`, `lastName`, `emailID`, `password`, `recoveryQuestionID`, `recoveryAnswer`) VALUES (?,?,?,?,?,?,?)";
	public static String updateUser= "UPDATE user "
			+ "SET userName = ?, "
			+ " firstName = ?,"
			+ " lastName = ?,"
			+ " emailID = ?,"
			+ "  password= ?,"
			+ "  recoveryQuestionID= ? "
			+"recoveryAnswer= ?"
			+ " WHERE userID = ?";
	
	public static String updateUserPass= "UPDATE user SET password= ?  WHERE userName = ?";
	public static String deleteUser="DELETE FROM users WHERE username = ?";

	public static String addQuestion="INSERT INTO question(`quizID`,`question`,`correctAns`,`optionA`,`optionB`,`optionC`,`optionD`) VALUES (?,?,?,?,?,?,?)";
	public static String delQuestion="";


	public static String addQuizWithTime="INSERT INTO `quiz` (`quizName`, `noOfQue`, `isTimed`, `quizTime`) VALUES(?,?,?,?)";
	public static String addQuizWithoutTime="INSERT INTO `quiz` (`quizName`, `noOfQue`, `isTimed`) VALUES(?,?,?)";


}
