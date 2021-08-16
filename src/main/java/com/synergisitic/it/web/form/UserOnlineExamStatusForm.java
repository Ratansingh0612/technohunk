package com.synergisitic.it.web.form;

import java.util.Date;

/**
 * 
 * @author nagendra.yadav
 * 
 */
public class UserOnlineExamStatusForm {

	private int id;
	private String testName;
	private String techName;
	private String userId;
	private Date dateOfTest;
	private int totalNoQuestion;
	private int totalNoAnsweredQuestion;
	private int totalMarks;
	private int secureMarks;
	private int totalCorrectAnswer;
	private int totalWrongAnswer;
	private String userSessionId;
	private String examStatus;

	/**
	 * @return the examStatus
	 */
	public String getExamStatus() {
		return examStatus;
	}

	/**
	 * @param examStatus the examStatus to set
	 */
	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDateOfTest() {
		return dateOfTest;
	}

	public void setDateOfTest(Date dateOfTest) {
		this.dateOfTest = dateOfTest;
	}

	public int getTotalNoQuestion() {
		return totalNoQuestion;
	}

	public void setTotalNoQuestion(int totalNoQuestion) {
		this.totalNoQuestion = totalNoQuestion;
	}

	public int getTotalNoAnsweredQuestion() {
		return totalNoAnsweredQuestion;
	}

	public void setTotalNoAnsweredQuestion(int totalNoAnsweredQuestion) {
		this.totalNoAnsweredQuestion = totalNoAnsweredQuestion;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getSecureMarks() {
		return secureMarks;
	}

	public void setSecureMarks(int secureMarks) {
		this.secureMarks = secureMarks;
	}

	public int getTotalCorrectAnswer() {
		return totalCorrectAnswer;
	}

	public void setTotalCorrectAnswer(int totalCorrectAnswer) {
		this.totalCorrectAnswer = totalCorrectAnswer;
	}

	public int getTotalWrongAnswer() {
		return totalWrongAnswer;
	}

	public void setTotalWrongAnswer(int totalWrongAnswer) {
		this.totalWrongAnswer = totalWrongAnswer;
	}

	@Override
	public String toString() {
		return "UserOnlineExamStatusForm [id=" + id + ", testName=" + testName + ", techName=" + techName + ", userId="
				+ userId + ", dateOfTest=" + dateOfTest + ", totalNoQuestion=" + totalNoQuestion
				+ ", totalNoAnsweredQuestion=" + totalNoAnsweredQuestion + ", totalMarks=" + totalMarks
				+ ", secureMarks=" + secureMarks + ", totalCorrectAnswer=" + totalCorrectAnswer + ", totalWrongAnswer="
				+ totalWrongAnswer + ", userSessionId=" + userSessionId + "]";
	}

	

	// This can take two values
	// Complete and incomplete

}
