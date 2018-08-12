package com.onlinequiz.model;

public class RecoveryQuestion {

	public RecoveryQuestion(int recoveryQuestionID, String question) {
		super();
		this.recoveryQuestionID = recoveryQuestionID;
		this.question = question;
	}

	private int recoveryQuestionID;
	private String question;

	public int getRecoveryQuestionID() {
		return recoveryQuestionID;
	}
	public void setrRecoveryQuestionID(int recoveryQuestionID) {
		this.recoveryQuestionID = recoveryQuestionID;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "RecoveryQuestion [recoveryQuestionID=" + recoveryQuestionID + ", question=" + question + "]";
	}

}
