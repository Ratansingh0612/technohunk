package com.synergisitic.it.web.form;

import java.util.Date;


/**
 * 
 * @author nagendra.yadav
 *
 */
public class UserExamProgressDataVO {

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
	

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "UserExamProgressDataVO [id=" + id + ", testName=" + testName + ", techName=" + techName + ", userId="
				+ userId + ", assignedQuestionIds=" + assignedQuestionIds + ", doe=" + doe + ", description="
				+ description + ", noOfHaltLeftForTest=" + noOfHaltLeftForTest + "]";
	}
	

}
