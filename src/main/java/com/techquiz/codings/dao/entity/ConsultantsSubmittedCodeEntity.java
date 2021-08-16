package com.techquiz.codings.dao.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consultants_submitted_code_tbl")
public class ConsultantsSubmittedCodeEntity {

	private long cid;
	private String consultantid;
	private String javacode;
	private String comment;
	private String grade;
	private String compilationError;
	private int testPassed;
	private int testFailed;
	private String userSessionId;
	private Timestamp doe;
	private Timestamp dom;
	private CodingProblmesLinkEntity codingProblemLink;
	private CodingProblemsEntity codingProblemsEntity;

	@JoinColumn(name = "cpid", unique = false,referencedColumnName="cpid")
    @OneToOne
    public CodingProblemsEntity getCodingProblemsEntity() {
		return codingProblemsEntity;
	}

	public void setCodingProblemsEntity(CodingProblemsEntity codingProblemsEntity) {
		this.codingProblemsEntity = codingProblemsEntity;
	}

	@JoinColumn(name = "problemlinkid", unique = false,referencedColumnName="gid")
    @OneToOne
	public CodingProblmesLinkEntity getCodingProblemLink() {
		return codingProblemLink;
	}

	public void setCodingProblemLink(CodingProblmesLinkEntity codingProblemLink) {
		this.codingProblemLink = codingProblemLink;
	}

	@Column(length=100)
	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}


	@Id
	@GeneratedValue
	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	@Column(length=100)
	public String getConsultantid() {
		return consultantid;
	}

	public void setConsultantid(String consultantid) {
		this.consultantid = consultantid;
	}

	
	@Column(length=5000,name="scode")
	public String getJavacode() {
		return javacode;
	}

	public void setJavacode(String javacode) {
		this.javacode = javacode;
	}

	@Column(length=400)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(length=20)
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(length=3)
	public String getCompilationError() {
		return compilationError;
	}

	public void setCompilationError(String compilationError) {
		this.compilationError = compilationError;
	}

	@Column(length=2)
	public int getTestPassed() {
		return testPassed;
	}

	public void setTestPassed(int testPassed) {
		this.testPassed = testPassed;
	}

	@Column(length=2)
	public int getTestFailed() {
		return testFailed;
	}

	public void setTestFailed(int testFailed) {
		this.testFailed = testFailed;
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
		return "ConsultantsSubmittedCodeEntity [consultantid=" + consultantid + ", javacode=" + javacode + ", comment="
				+ comment + ", grade=" + grade + ", compilationError=" + compilationError + ", testPassed=" + testPassed
				+ ", testFailed=" + testFailed + ", doe=" + doe + ", dom=" + dom + "]";
	}

}
