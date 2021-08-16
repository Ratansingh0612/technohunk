package com.techquiz.trainer.dao.entity;

/**
 * 
 * @author Nagendra
 *
 */
public class ApprovePendingUserEntity {
	private String consultantid;
	private String email;
	private String stream;
	private String batch;
	private String role;
	private String active;

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	/**
	 * @return the consultantid
	 */
	public String getConsultantid() {
		return consultantid;
	}

	/**
	 * @param consultantid
	 *            the consultantid to set
	 */
	public void setConsultantid(String consultantid) {
		this.consultantid = consultantid;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the stream
	 */
	public String getStream() {
		return stream;
	}

	/**
	 * @param stream
	 *            the stream to set
	 */
	public void setStream(String stream) {
		this.stream = stream;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "ApprovePendingUserEntity [consultantid=" + consultantid + ", email=" + email + ", stream=" + stream
				+ ", batch=" + batch + ", role=" + role + ", active=" + active + "]";
	}

}
