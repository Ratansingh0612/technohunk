package com.synergisitic.it.web.form;

import java.util.Date;

import com.synergisitic.it.util.DateUtils;

public class UserForm implements Comparable<UserForm> {

	private int id;
	private String empid;
	private int testStatus;
	private String firstName;

	private String lastName;

	private String address;

	private String mobile;

	private String email;

	private Date dob;

	private String description;

	private String loginid;

	private String password;

	private Date doe;
	
	private String role;
	
	private String lockStatus;
	
	private byte[] photo;
	
	private String batch;
	
	private String techTestStatus;
	
	private String score;
	private String dot;
	private String userSessionId;
	private Date doj;
	private String testName;
	private String techName;
	

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

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	/**
	 * @return the doj
	 */
	public Date getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getDot() {
		return dot;
	}

	public void setDot(String dot) {
		this.dot = dot;
	}

	public String getTechTestStatus() {
		return techTestStatus;
	}

	public void setTechTestStatus(String techTestStatus) {
		this.techTestStatus = techTestStatus;
	}

	public String getBatch() {
		return batch;
	}

	public int getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(int testStatus) {
		this.testStatus = testStatus;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "UserForm [id=" + id + ", testStatus=" + testStatus + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", mobile=" + mobile + ", email=" + email + ", dob=" + dob
				+ ", description=" + description + ", loginid=" + loginid + ", password=" + password + ", doe=" + doe
				+ ", role=" + role + ", lockStatus=" + lockStatus + ", batch=" + batch + ", techTestStatus="
				+ techTestStatus + ", score=" + score + ", dot=" + dot + ", userSessionId=" + userSessionId + "]";
	}

	@Override
	public int compareTo(UserForm o) {
	 	           int status=0;
					 if(this.techTestStatus!=null && o.getTechTestStatus()!=null) {
						 if(!this.techTestStatus.equalsIgnoreCase("NA") && !o.getTechTestStatus().equalsIgnoreCase("NA")) {
							 status= this.techTestStatus.compareTo(o.getTechTestStatus());
						 }	 
					}  
		return status;
	}
	
}
