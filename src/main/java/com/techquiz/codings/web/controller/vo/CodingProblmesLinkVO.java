package com.techquiz.codings.web.controller.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author nagendra
 * @since 07-Aug-2018
 *
 */
public class CodingProblmesLinkVO implements Comparable<CodingProblmesLinkVO> {

	private long gid;
	private String name;
	private String email;
	private String gender;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
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

	public long getGid() {
		return gid;
	}

	public void setGid(long gid) {
		this.gid = gid;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

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

	public String getCodingStatus() {
		return codingStatus;
	}

	public void setCodingStatus(String codingStatus) {
		this.codingStatus = codingStatus;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String getPduration() {
		return pduration;
	}

	public void setPduration(String pduration) {
		this.pduration = pduration;
	}

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	@Override
	public String toString() {
		return "CodingProblmesLinkVO [gid=" + gid + ", name=" + name + ", email=" + email + ", doe=" + doe
				+ ", adminid=" + adminid + ", generatedCodeLink=" + generatedCodeLink + ", expiryDate=" + expiryDate
				+ ", codingStatus=" + codingStatus + ", userid=" + userid + ", techName=" + techName + ", problemId="
				+ problemId + ", pduration=" + pduration + ", userSessionId=" + userSessionId + "]";
	}

	@Override
	public int compareTo(CodingProblmesLinkVO o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
