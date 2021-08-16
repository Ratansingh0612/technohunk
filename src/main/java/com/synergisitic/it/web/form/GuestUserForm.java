package com.synergisitic.it.web.form;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GuestUserForm implements Comparable<GuestUserForm> {

	private long gid;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private String occupation;
	private String location;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
	private Timestamp doe;
	private String adminid;
	private String generatedTestLink;
	private Timestamp expiryDate;
	private String testStatus;
	private String userid;
	private String techName;
	private String testName;
	private String tduration;
	private String userSessionId;

	
	public String getTduration() {
		return tduration;
	}

	public void setTduration(String tduration) {
		this.tduration = tduration;
	}

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

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the testStatus
	 */
	public String getTestStatus() {
		return testStatus;
	}

	/**
	 * @param testStatus the testStatus to set
	 */
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	/**
	 * @return the expiryDate
	 */
	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the generatedTestLink
	 */
	public String getGeneratedTestLink() {
		return generatedTestLink;
	}

	/**
	 * @param generatedTestLink the generatedTestLink to set
	 */
	public void setGeneratedTestLink(String generatedTestLink) {
		this.generatedTestLink = generatedTestLink;
	}

	/**
	 * @return the gid
	 */
	public long getGid() {
		return gid;
	}

	/**
	 * @param gid
	 *            the gid to set
	 */
	public void setGid(long gid) {
		this.gid = gid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation
	 *            the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the doe
	 */
	public Timestamp getDoe() {
		return doe;
	}

	/**
	 * @param doe
	 *            the doe to set
	 */
	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	/**
	 * @return the adminid
	 */
	public String getAdminid() {
		return adminid;
	}

	/**
	 * @param adminid
	 *            the adminid to set
	 */
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		GuestUserForm other = (GuestUserForm) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GuestUserForm [gid=" + gid + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + ", occupation=" + occupation + ", location=" + location + ", doe=" + doe + ", adminid="
				+ adminid + ", generatedTestLink=" + generatedTestLink + ", expiryDate=" + expiryDate + ", testStatus="
				+ testStatus + ", userid=" + userid + ", techName=" + techName + ", testName=" + testName + "]";
	}

	@Override
	public int compareTo(GuestUserForm o) {
		return email.compareTo(o.getEmail());
	}

}
