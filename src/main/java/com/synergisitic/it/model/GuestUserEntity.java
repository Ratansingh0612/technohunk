package com.synergisitic.it.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guest_users_tbl")
public class GuestUserEntity {
	private long gid;
	private String name;
	private String email;
	private String mobile;
	private String gender;
	private String occupation;
	private String location;
	private Timestamp doe;
	private String adminid;
	private String generatedTestLink;
	private Timestamp expiryDate;
	private String testStatus;
	private String techName;
	private String testName;
	private String tduration;
	private String userSessionId;

	@Column(length=100)
	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}
	
	@Column(length=100)
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	@Column(length=100)
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	

	/**
	 * @return the testStatus
	 */

	@Column(length=3)
	public String getTduration() {
		return tduration;
	}

	public void setTduration(String tduration) {
		this.tduration = tduration;
	}

	/**
	 * @return the generatedTestLink
	 */
	@Column(length = 20)
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
	 * @param generatedTestLink
	 *            the generatedTestLink to set
	 */
	public void setGeneratedTestLink(String generatedTestLink) {
		this.generatedTestLink = generatedTestLink;
	}

	/**
	 * @return the expiryDate
	 */
	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            the expiryDate to set
	 */
	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the generatedTestLink
	 */
	@Column(length = 200)
	public String getGeneratedTestLink() {
		return generatedTestLink;
	}

	/**
	 * @return the gid
	 */
	@Id
	@GeneratedValue
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
	@Column(length = 200)
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
	@Column(length = 200)
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

	@Column(length = 20)
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
	@Column(length = 6)
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
	@Column(length = 30)
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
	@Column(length = 500)
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
	@Column(length = 100)
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
	public String toString() {
		return "GuestUserEntity [gid=" + gid + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", gender=" + gender + ", occupation=" + occupation + ", location=" + location + ", doe=" + doe
				+ ", adminid=" + adminid + ", generatedTestLink=" + generatedTestLink + ", expiryDate=" + expiryDate
				+ "]";
	}

}
