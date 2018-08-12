package com.onlinequiz.model;

public class Question {

	private int questionID;
	private int quizID;
	private String question;
	private String correctAns;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String selectedAns;
	private int result;

	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getSelectedAns() {
		return selectedAns;
	}
	public void setSelectedAns(String selectedAns) {
		this.selectedAns = selectedAns;
	}

	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public int getQuizID() {
		return quizID;
	}
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAns() {
		return correctAns;
	}
	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}

	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", quizID=" + quizID + ", question=" + question + ", correctAns="
				+ correctAns + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD="
				+ optionD + "]";
	}
	public Question(int questionID, int quizID, String question, String correctAns, String optionA, String optionB,
			String optionC, String optionD) {
		super();
		this.questionID = questionID;
		this.quizID = quizID;
		this.question = question;
		this.correctAns = correctAns;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}
	public Question(int quizID, String question, String correctAns, String optionA, String optionB,
			String optionC, String optionD) {
		super();
		this.quizID = quizID;
		this.question = question;
		this.correctAns = correctAns;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}
}
