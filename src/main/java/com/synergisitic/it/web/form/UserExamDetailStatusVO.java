package com.synergisitic.it.web.form;

import java.util.Date;

/**
 * 
 * @author nagendra.yadav
 * 
 */
public class UserExamDetailStatusVO {

	private int id;
	private String questionId;
	private String selectedAnswerId;
	private String correctAnswerId;
	private Date dateOfTest;
	private int correctAnswerCount;
	private String testName;
	private String techName;
	private String userId;
	private String description;
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

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	public String getSelectedAnswerId() {
		return selectedAnswerId;
	}

	public void setSelectedAnswerId(String selectedAnswerId) {
		this.selectedAnswerId = selectedAnswerId;
	}

	public String getCorrectAnswerId() {
		return correctAnswerId;
	}

	public void setCorrectAnswerId(String correctAnswerId) {
		this.correctAnswerId = correctAnswerId;
	}

	
	public int getNoOfAttemts() {
		return noOfAttemts;
	}

	public void setNoOfAttemts(int noOfAttemts) {
		this.noOfAttemts = noOfAttemts;
	}

	public Date getDateOfTest() {
		return dateOfTest;
	}

	public void setDateOfTest(Date dateOfTest) {
		this.dateOfTest = dateOfTest;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getCorrectAnswerCount() {
		return correctAnswerCount;
	}

	public void setCorrectAnswerCount(int correctAnswerCount) {
		this.correctAnswerCount = correctAnswerCount;
	}

	@Override
	public String toString() {
		return "UserExamDetailStatusVO [id=" + id + ", questionId=" + questionId
				+ ", selectedAnswerId=" + selectedAnswerId
				+ ", correctAnswerId=" + correctAnswerId + ", dateOfTest="
				+ dateOfTest + ", correctAnswerCount=" + correctAnswerCount
				+ ", testName=" + testName + ", userId=" + userId
				+ ", description=" + description + ", userSessionId="
				+ userSessionId + ", noOfAttemts=" + noOfAttemts + "]";
	}


}
