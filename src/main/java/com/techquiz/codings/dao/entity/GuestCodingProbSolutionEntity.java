package com.techquiz.codings.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "guest_coding_probsolution_tbl")
public class GuestCodingProbSolutionEntity {
	private long gcpid;
	private String email;
	private String name;
	private String gender;
	private String location;
	private Timestamp expireon;
	private String generatedCodeLink;
	private CodingProblemsEntity codingProblems;
	private String codeState;
	private int cpduraton;
	private String adminid;
	private Timestamp doe;
	private Timestamp dom;

	@Id
	@GeneratedValue
	public long getGcpid() {
		return gcpid;
	}

	public void setGcpid(long gcpid) {
		this.gcpid = gcpid;
	}
	
	@JoinColumn(name = "problemid", unique = true)
	@OneToOne
	public CodingProblemsEntity getCodingProblems() {
		return codingProblems;
	}

	public void setCodingProblems(CodingProblemsEntity codingProblems) {
		this.codingProblems = codingProblems;
	}

	@Column(length=150)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length=150)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=7)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(length=150)
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

	@Column(length=150)
	public String getGeneratedCodeLink() {
		return generatedCodeLink;
	}

	public void setGeneratedCodeLink(String generatedCodeLink) {
		this.generatedCodeLink = generatedCodeLink;
	}

	@Column(length=12)
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

	@Column(length=100)
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
		return "GuestCodingProbSolutionEntity [gcpid=" + gcpid + ", email=" + email + ", name=" + name + ", gender="
				+ gender + ", location=" + location + ", expireon=" + expireon + ", generatedCodeLink="
				+ generatedCodeLink + ", codeState=" + codeState + ", cpduraton=" + cpduraton + ", adminid=" + adminid
				+ ", doe=" + doe + ", dom=" + dom + "]";
	}

}
