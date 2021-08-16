package com.techquiz.codings.web.controller.vo;

import java.sql.Timestamp;

/**
 * 
 * @author VC1
 * @since 27-08-2018
 */
public class GuestCodingProbSolutionVO {
	private long gcpid;
	private String email;
	private String name;
	private String gender;
	private String location;
	private Timestamp expireon;
	private String generatedCodeLink;
	private String codeState;
	private int cpduraton;
	private String adminid;
	private Timestamp doe;
	private Timestamp dom;

	public long getGcpid() {
		return gcpid;
	}

	public void setGcpid(long gcpid) {
		this.gcpid = gcpid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getExpireon() {
		return expireon;
	}

	public void setExpireon(Timestamp expireon) {
		this.expireon = expireon;
	}

	public String getGeneratedCodeLink() {
		return generatedCodeLink;
	}

	public void setGeneratedCodeLink(String generatedCodeLink) {
		this.generatedCodeLink = generatedCodeLink;
	}

	public String getCodeState() {
		return codeState;
	}

	public void setCodeState(String codeState) {
		this.codeState = codeState;
	}

	public int getCpduraton() {
		return cpduraton;
	}

	public void setCpduraton(int cpduraton) {
		this.cpduraton = cpduraton;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	public Timestamp getDom() {
		return dom;
	}

	public void setDom(Timestamp dom) {
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "GuestCodingProbSolutionVO [gcpid=" + gcpid + ", email=" + email + ", name=" + name + ", gender="
				+ gender + ", location=" + location + ", expireon=" + expireon + ", generatedCodeLink="
				+ generatedCodeLink + ", codeState=" + codeState + ", cpduraton=" + cpduraton + ", adminid=" + adminid
				+ ", doe=" + doe + ", dom=" + dom + "]";
	}

}
