package com.synergisitic.it.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author nagendra.yadav
 * 
 */
@Table(name = "user_exam_detail_status_tbl")
@Entity
public class UserExamDetailStatus {

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
	
	@Transient
	public String getWeightage() {
		return weightage;
	}

	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}

	@Transient
	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	
	
	@Transient
	public String getTestLink() {
		return testLink;
	}

	public void setTestLink(String testLink) {
		this.testLink = testLink;
	}
	
	/**
	 * @return the role
	 */
	@Transient
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(length=40)
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	@Column(length=40)
	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	@Column(length=40)
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	@Column(length=40)
	public String getSelectedAnswerId() {
		return selectedAnswerId;
	}

	public void setSelectedAnswerId(String selectedAnswerId) {
		this.selectedAnswerId = selectedAnswerId;
	}

	@Column(length=40)
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

	@Column(length=40)
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Column(length=100)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(length=50)
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
		return "UserExamDetailStatus [id=" + id + ", questionId=" + questionId
				+ ", selectedAnswerId=" + selectedAnswerId
				+ ", correctAnswerId=" + correctAnswerId + ", dateOfTest="
				+ dateOfTest + ", correctAnswerCount=" + correctAnswerCount
				+ ", testName=" + testName + ", userId=" + userId
				+ ", description=" + description + ", userSessionId="
				+ userSessionId + ", noOfAttemts=" + noOfAttemts + "]";
	}


}
