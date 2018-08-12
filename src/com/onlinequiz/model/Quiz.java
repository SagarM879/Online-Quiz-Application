package com.onlinequiz.model;

public class Quiz {

	private int quizID;
	private String quizName;
	private int noOfQue;
	private Boolean isTimed;
	private int quizTime;

	public Quiz(int quizID, String quizName) {
		super();
		this.quizID = quizID;
		this.quizName = quizName;
	}

	public Quiz(int quizID, String quizName, int noOfQue, Boolean isTimed, int quizTime) {
		super();
		this.quizID = quizID;
		this.quizName = quizName;
		this.noOfQue = noOfQue;
		this.isTimed = isTimed;
		this.quizTime = quizTime;
	}

	public Quiz(String quizName, int noOfQue, Boolean isTimed, int quizTime) {
		super();
		this.quizName = quizName;
		this.noOfQue = noOfQue;
		this.isTimed = isTimed;
		this.quizTime = quizTime;
	}




	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public int getNoOfQue() {
		return noOfQue;
	}
	public void setNoOfQue(int noOfQue) {
		this.noOfQue = noOfQue;
	}

	public Boolean getIsTimed() {
		return isTimed;
	}
	public Quiz(String quizName, int noOfQue, Boolean isTimed) {
		super();
		this.quizName = quizName;
		this.noOfQue = noOfQue;
		this.isTimed = isTimed;
	}

	public void setIsTimed(Boolean isTimed) {
		this.isTimed = isTimed;
	}

	public int getQuizTime() {
		return quizTime;
	}
	public void setQuizTime(int quizTime) {
		this.quizTime = quizTime;
	}
	@Override
	public String toString() {
		return "Quiz [quizID=" + quizID + ", quizName=" + quizName + ", noOfQue=" + noOfQue + ", isTimed=" + isTimed
				+ ", quizTime=" + quizTime + "]";
	}
}
