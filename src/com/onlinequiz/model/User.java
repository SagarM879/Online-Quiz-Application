package com.onlinequiz.model;

import java.util.Map;

public class User {

	private int userID;
	private String userName;
	private String firstName;
	private String lastName;
	private String emailID;
	private String password;
	private int recoveryQuestionID;
	private String recoveryAnswer;

	Map<Integer, Question> quizMap;

	public User(int userID, String userName, String firstName, String lastName, String emailID, String password,
			int recoveryQuestionID, String recoveryAnswer) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
		this.recoveryQuestionID = recoveryQuestionID;
		this.recoveryAnswer = recoveryAnswer;
	}


	public User(String userName, String firstName, String lastName, String emailID, String password,
			int recoveryQuestionID, String recoveryAnswer) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
		this.recoveryQuestionID = recoveryQuestionID;
		this.recoveryAnswer = recoveryAnswer;
	}


	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getRecoveryQuestionID() {
		return recoveryQuestionID;
	}
	public void setrRecoveryQuestionID(int recoveryQuestionID) {
		this.recoveryQuestionID = recoveryQuestionID;
	}

	public String getRecoveryAnswer() {
		return recoveryAnswer;
	}
	public void setRecoveryAnswer(String recoveryAnswer) {
		this.recoveryAnswer = recoveryAnswer;
	}
	public Map<Integer, Question> getQuizMap() {
		return quizMap;
	}


	public void setQuizMap(Map<Integer, Question> quizMap) {
		this.quizMap = quizMap;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailID=" + emailID + ", password=" + password + ", recoveryQuestionID="
				+ recoveryQuestionID + ", recoveryAnswer=" + recoveryAnswer + "]";
	}
}


