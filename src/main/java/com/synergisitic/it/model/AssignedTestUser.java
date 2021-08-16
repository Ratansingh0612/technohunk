package com.synergisitic.it.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "assigned_test_user_tbl")
//@NamedQueries({
//@NamedQuery(name = "find.all.completed.test.by.tech", query = "from AssignedTestUser atu where atu.assignedTestCompositeKey.techName=? and atu.testStatus in (?,?)"),
//@NamedQuery(name = "find.all.users.assind.test", query = "from AssignedTestUser")})
public class AssignedTestUser {
	// private int id;
	// This name is confusing , this should be testName
	/*
	 * private String techName; private String userId;
	 */
	private AssignedTestCompositeKey assignedTestCompositeKey;
	
	private Date assignDate;
	private String testExpireOn;
	private int testExpireTimeInHrs;
	private String modifyBy;
	private int numberOfQuestions;
	private int durationInMin;
	// Not Attempted
	// Completed
	// Incomplete
	private String testStatus = "Not Attempted";
	private String link;
	private int attamptLimit;
	private String groupName;
	private Date resetDate;
	private String locked;
	private String  userSessionId;
	public String active="NO";
	
	
	@Column(length = 3)
	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	@Column(length = 30)
	public String getUserSessionId() {
		return userSessionId;
	}


	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}


	@Column(length = 10)
	public String getLocked() {
		return locked;
	}


	public void setLocked(String locked) {
		this.locked = locked;
	}


	@EmbeddedId
	public AssignedTestCompositeKey getAssignedTestCompositeKey() {
		return assignedTestCompositeKey;
	}
	

	public void setAssignedTestCompositeKey(
			AssignedTestCompositeKey assignedTestCompositeKey) {
		this.assignedTestCompositeKey = assignedTestCompositeKey;
	}

	
	

	public int getAttamptLimit() {
		return attamptLimit;
	}

	public void setAttamptLimit(int attamptLimit) {
		this.attamptLimit = attamptLimit;
	}

	@Column(length = 30)
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(length = 20)
	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	
	

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO) public int getId() { return
	 * id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 */

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

	public Date getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}

	@Column(length = 25)
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

	@Column(length = 30)
	public String getModifyBy() {
		return modifyBy;
	}

	@Column(length = 20)
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

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}


	@Override
	public String toString() {
		return "AssignedTestUser [assignedTestCompositeKey=" + assignedTestCompositeKey + ", assignDate=" + assignDate
				+ ", testExpireOn=" + testExpireOn + ", testExpireTimeInHrs=" + testExpireTimeInHrs + ", modifyBy="
				+ modifyBy + ", numberOfQuestions=" + numberOfQuestions + ", durationInMin=" + durationInMin
				+ ", testStatus=" + testStatus + ", link=" + link + ", attamptLimit=" + attamptLimit + ", groupName="
				+ groupName + ", resetDate=" + resetDate + ", locked=" + locked + ", userTestSessionId="
				+ userSessionId + "]";
	}
	
}
