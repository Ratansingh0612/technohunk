package com.techquiz.codings.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author nagendra
 * @since 07-Aug-2018
 *
 */
@Entity
@Table(name="coding_problmes_link_tbl")
public class CodingProblmesLinkEntity  {

	private long gid;
	private String name;
	private String email;
	private String gender;
	private Timestamp doe;
	private String adminid;
	private String generatedCodeLink;
	private Timestamp expiryDate;
	private String codingStatus;
	private String userid;
	private String techName;
	private String problemId;
	private String problemTitle;
	private String pduration;
	private String userSessionId;
	

	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	@Id
	@GeneratedValue
	public long getGid() {
		return gid;
	}

	public void setGid(long gid) {
		this.gid = gid;
	}
	

	@Column(length=6)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=130)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Column(length=100)
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	@Column(length = 200)
	public String getGeneratedCodeLink() {
		return generatedCodeLink;
	}

	public void setGeneratedCodeLink(String generatedCodeLink) {
		this.generatedCodeLink = generatedCodeLink;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(length = 12)
	public String getCodingStatus() {
		return codingStatus;
	}

	public void setCodingStatus(String codingStatus) {
		this.codingStatus = codingStatus;
	}

	@Column(length = 130)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(length = 50)
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	@Column(length = 20)
	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	@Column(length = 3)
	public String getPduration() {
		return pduration;
	}

	public void setPduration(String pduration) {
		this.pduration = pduration;
	}

	@Column(length=100)
	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	@Override
	public String toString() {
		return "CodingProblmesLinkEntity [gid=" + gid + ", name=" + name + ", email=" + email + ", doe=" + doe
				+ ", adminid=" + adminid + ", generatedCodeLink=" + generatedCodeLink + ", expiryDate=" + expiryDate
				+ ", codingStatus=" + codingStatus + ", userid=" + userid + ", techName=" + techName + ", problemId="
				+ problemId + ", pduration=" + pduration + ", userSessionId=" + userSessionId + "]";
	}
	}

