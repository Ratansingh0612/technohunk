package com.synergisitic.it.web.form;

public class AssignTestUserForm {
	private String testStatus;
	private String locked;
	private String name;
	private String email;
	private String loginid;
	private String assigned;
	private String batch;


	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getName() {	
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "AssignTestUserForm [name=" + name + ", email=" + email + ", loginid=" + loginid + ", assigned="
				+ assigned + ", batch=" + batch + "]";
	}
	
}
