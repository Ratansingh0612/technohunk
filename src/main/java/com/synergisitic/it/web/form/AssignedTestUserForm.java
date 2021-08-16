package com.synergisitic.it.web.form;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.NamedQuery;

import com.synergisitic.it.model.AssignedTestCompositeKey;



public class AssignedTestUserForm {

	
	private AssignedTestCompositeKey assignedTestCompositeKey;
	
	private int id;
	private String techName;
	private String testName;
	private String userSessionId;
	private String userId;
	private Date assignDate;
	private String testExpireOn;	
	private int testExpireTimeInHrs;
	private String modifyBy;
	private String testStatus;
	private String link;
	private int attamptLimit;
	private int numberOfQuestions;
	private int durationInMin;
private String locked;

	
	
	public String getUserSessionId() {
	return userSessionId;
}


public void setUserSessionId(String userSessionId) {
	this.userSessionId = userSessionId;
}


	public String getTestName() {
	return testName;
}


public void setTestName(String testName) {
	this.testName = testName;
}


	public String getLocked() {
		return locked;
	}


	public void setLocked(String locked) {
		this.locked = locked;
	}
	private String groupName;
	private Date resetDate;
	
	
	public AssignedTestCompositeKey getAssignedTestCompositeKey() {
		return assignedTestCompositeKey;
	}

	public void setAssignedTestCompositeKey(AssignedTestCompositeKey assignedTestCompositeKey) {
		this.assignedTestCompositeKey = assignedTestCompositeKey;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public int getDurationInMin() {
		return durationInMin;
	}

	public void setDurationInMin(int durationInMin) {
		this.durationInMin = durationInMin;
	}

	public int getAttamptLimit() {
		return attamptLimit;
	}

	public void setAttamptLimit(int attamptLimit) {
		this.attamptLimit = attamptLimit;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

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

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
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
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getResetDate() {
		return resetDate;
	}

	public void setResetDate(Date resetDate) {
		this.resetDate = resetDate;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedTestCompositeKey == null) ? 0 : assignedTestCompositeKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignedTestUserForm other = (AssignedTestUserForm) obj;
		if (assignedTestCompositeKey == null) {
			if (other.assignedTestCompositeKey != null)
				return false;
		} else if (!assignedTestCompositeKey.equals(other.assignedTestCompositeKey))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssignedTestUserForm [id=" + id + ", techName=" + techName
				+ ", userId=" + userId + ", assignDate=" + assignDate
				+ ", testExpireOn=" + testExpireOn + ", testExpireTimeInHrs="
				+ testExpireTimeInHrs + ", modifyBy=" + modifyBy
				+ ", testStatus=" + testStatus + ", link=" + link
				+ ", attamptLimit=" + attamptLimit + ", numberOfQuestions="
				+ numberOfQuestions + ", durationInMin=" + durationInMin
				+ ", groupName=" + groupName + ", resetDate=" + resetDate + "]";
	}

}
