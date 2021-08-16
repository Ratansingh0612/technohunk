package com.synergisitic.it.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AssignedTestCompositeKey  implements Serializable {

	// This name is confusing , this should be testName
	private String techName;
	private String userId;
	private String testName;

	public AssignedTestCompositeKey() {

	}

	public AssignedTestCompositeKey(String techName, String userId, String testName) {
		this.techName = techName;
		this.userId = userId;
		this.testName = testName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((techName == null) ? 0 : techName.hashCode());
		result = prime * result + ((testName == null) ? 0 : testName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		AssignedTestCompositeKey other = (AssignedTestCompositeKey) obj;
		if (techName == null) {
			if (other.techName != null)
				return false;
		} else if (!techName.equals(other.techName))
			return false;
		if (testName == null) {
			if (other.testName != null)
				return false;
		} else if (!testName.equals(other.testName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssignedTestCompositeKey [techName=" + techName + ", userId=" + userId + ", testName=" + testName + "]";
	}

}
