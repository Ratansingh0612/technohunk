package com.synergisitic.it.web.form;

import java.util.Date;

/**
 * 
 * @author nagendra.yadav
 * 
 */
public class AttemptQuestionAnswerDTO {

	private String questionId;
	private String correctAnswerId;
	private String selectedAnswerId;
	private String testName;
	private String techName;
	private String userId;
	private Date dateOfTest;
	private int correctAnswerCount;
	private String description;
	private int questionNo;
	private String userSessionId;
	private int noOfAttemts;
	private String role;
	private String testLink;
	private String testStatus;
	private String weightage;
	
	public String getWeightage() {
		return weightage;
	}

	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public String getTestLink() {
		return testLink;
	}

	public void setTestLink(String testLink) {
		this.testLink = testLink;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public int getNoOfAttemts() {
		return noOfAttemts;
	}

	public void setNoOfAttemts(int noOfAttemts) {
		this.noOfAttemts = noOfAttemts;
	}

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AttemptQuestionAnswerDTO() {
	}

	public AttemptQuestionAnswerDTO(String questionId, String correctAnswerId,
			String selectedAnswerId, String testName, String userId,
			Date dateOfTest, int correctAnswerCount) {
		this.questionId = questionId;
		this.correctAnswerId = correctAnswerId;
		this.selectedAnswerId = selectedAnswerId;
		this.testName = testName;
		this.userId = userId;
		this.dateOfTest = dateOfTest;
		this.correctAnswerCount = correctAnswerCount;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getCorrectAnswerId() {
		return correctAnswerId;
	}

	public void setCorrectAnswerId(String correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}

	public String getSelectedAnswerId() {
		return selectedAnswerId;
	}

	public void setSelectedAnswerId(String selectedAnswerId) {
		this.selectedAnswerId = selectedAnswerId;
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

	public int getCorrectAnswerCount() {
		return correctAnswerCount;
	}

	public void setCorrectAnswerCount(int correctAnswerCount) {
		this.correctAnswerCount = correctAnswerCount;
	}

	@Override
	public String toString() {
		return "AttemptQuestionAnswerDTO [questionId=" + questionId + ", correctAnswerId=" + correctAnswerId
				+ ", selectedAnswerId=" + selectedAnswerId + ", testName=" + testName + ", techName=" + techName
				+ ", userId=" + userId + ", dateOfTest=" + dateOfTest + ", correctAnswerCount=" + correctAnswerCount
				+ ", description=" + description + ", questionNo=" + questionNo + ", userSessionId=" + userSessionId
				+ ", noOfAttemts=" + noOfAttemts + ", role=" + role + ", testLink=" + testLink + "]";
	}

}
