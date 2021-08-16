package com.synergisitic.it.web.form;

/**
 * 
 * @author nagendra.yadav
 * 
 */
public class AssignedTestUser {

	private int id;
	private String techName;
	private String userId;
	private String assignDate;
	private String testExpireOn;
	private int testExpireTimeInHrs;
	private String modifyBy;

	// Not Attempted
	// Completed
	// Incomplete
	private String testStatus = "Not Attempted";

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	public String getTestExpireOn() {
		return testExpireOn;
	}

	public void setTestExpireOn(String testExpireOn) {
		this.testExpireOn = testExpireOn;
	}

	public int getTestExpireTimeInHrs() {
		return testExpireTimeInHrs;
	}

	public void setTestExpireTimeInHrs(int testExpireTimeInHrs) {
		this.testExpireTimeInHrs = testExpireTimeInHrs;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

}
