package com.onlinequiz.model;

import java.util.Date;

public class Report {

	public Report(int reportID, int userID, int quizID, int score, Date date) {
		super();
		this.reportID = reportID;
		this.userID = userID;
		this.quizID = quizID;
		this.score = score;
		this.date = date;
	}
	private int reportID;
	private int userID;
	private int quizID;
	private int score;
	private Date date;

	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public Date getDate() {
		return date;
	}
	public void setScore(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Report [reportID=" + reportID + ", userID=" + userID + ", quizID=" + quizID + ", score=" + score
				+ ", date=" + date + "]";
	}
}
