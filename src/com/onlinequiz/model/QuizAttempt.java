package com.onlinequiz.model;

public class QuizAttempt {

	public QuizAttempt(int quizID, int questionID, int userID, String correctAns, String userAns, int result) {
		super();
		this.quizID = quizID;
		this.questionID = questionID;
		this.userID = userID;
		this.correctAns = correctAns;
		this.userAns = userAns;
		this.result = result;
	}
	private int quizID;
	private int questionID;
	private int userID;
	private String correctAns;
	private String userAns;
	private int result;

	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}

	public String getUserAns() {
		return userAns;
	}
	public void setUserAns(String userAns) {
		this.userAns = userAns;
	}

	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "QuizAttempt [quizID=" + quizID + ", questionID=" + questionID + ", userID=" + userID + ", correctAns="
				+ correctAns + ", userAns=" + userAns + ", result=" + result + "]";
	}

}
