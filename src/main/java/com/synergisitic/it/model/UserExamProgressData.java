package com.synergisitic.it.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_exam_progress_data_tbl")
public class UserExamProgressData {

	private int id;
	private String testName;
	private String techName;
	private String userId;
	private String assignedQuestionIds;
	private Date doe;
	private String description;
	private int noOfHaltLeftForTest;

	//This will be helpful when user is allowed to attempt same test more than one time.
	private String userSessionId;
	
	
	
	public void setTechName(String techName) {
		this.techName = techName;
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
	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}


	@Column(length=30)
	public String getTechName() {
		return techName;
	}

	
	@Column(length=30)
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

	@Column(length=3000)
	public String getAssignedQuestionIds() {
		return assignedQuestionIds;
	}

	public void setAssignedQuestionIds(String assignedQuestionIds) {
		this.assignedQuestionIds = assignedQuestionIds;
	}

	
	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	@Column(length=30)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNoOfHaltLeftForTest() {
		return noOfHaltLeftForTest;
	}

	public void setNoOfHaltLeftForTest(int noOfHaltLeftForTest) {
		this.noOfHaltLeftForTest = noOfHaltLeftForTest;
	}

	@Override
	public String toString() {
		return "UserExamProgressData [id=" + id + ", testName=" + testName + ", techName=" + techName + ", userId="
				+ userId + ", assignedQuestionIds=" + assignedQuestionIds + ", doe=" + doe + ", description="
				+ description + ", noOfHaltLeftForTest=" + noOfHaltLeftForTest + ", userSessionId=" + userSessionId
				+ "]";
	}
	
	

}
