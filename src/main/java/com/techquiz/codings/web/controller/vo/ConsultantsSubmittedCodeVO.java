package com.techquiz.codings.web.controller.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author VC1
 * @Since 06-08-2018 
 */
public class ConsultantsSubmittedCodeVO {
	private long cid;
	private String cpid;
	private String problemTitle;
	private String consultantid;
	private String javacode;
	private String comment;
	private String grade;
	private String compilationError;
	private int testPassed;
	private int testFailed;
	private String userSessionId;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
	private Timestamp doe;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
	private Timestamp dom;
	private String cduration;
	private String techName;
	private String userId;
	private CodingProblmesLinkVO codingProblmesLinkVO;
	private CodingProblemsVO codingProblemsVO;
	private String problemTimeout;
	
	public String getProblemTimeout() {
		return problemTimeout;
	}

	public void setProblemTimeout(String problemTimeout) {
		this.problemTimeout = problemTimeout;
	}

	public CodingProblemsVO getCodingProblemsVO() {
		return codingProblemsVO;
	}

	public void setCodingProblemsVO(CodingProblemsVO codingProblemsVO) {
		this.codingProblemsVO = codingProblemsVO;
	}

	public CodingProblmesLinkVO getCodingProblmesLinkVO() {
		return codingProblmesLinkVO;
	}

	public void setCodingProblmesLinkVO(CodingProblmesLinkVO codingProblmesLinkVO) {
		this.codingProblmesLinkVO = codingProblmesLinkVO;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCduration() {
		return cduration;
	}

	public void setCduration(String cduration) {
		this.cduration = cduration;
	}

	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}
	
	

	public String getCpid() {
		return cpid;
	}

	public void setCpid(String cpid) {
		this.cpid = cpid;
	}

	public String getConsultantid() {
		return consultantid;
	}

	public void setConsultantid(String consultantid) {
		this.consultantid = consultantid;
	}

	

	public String getJavacode() {
		return javacode;
	}

	public void setJavacode(String javacode) {
		this.javacode = javacode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCompilationError() {
		return compilationError;
	}

	public void setCompilationError(String compilationError) {
		this.compilationError = compilationError;
	}

	public int getTestPassed() {
		return testPassed;
	}

	public void setTestPassed(int testPassed) {
		this.testPassed = testPassed;
	}

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
		return "ConsultantsSubmittedCodeVO [cid=" + cid + ", cpid=" + cpid + ", consultantid=" + consultantid
				+ ", javacode=" + javacode + ", comment=" + comment + ", grade=" + grade + ", compilationError="
				+ compilationError + ", testPassed=" + testPassed + ", testFailed=" + testFailed + ", doe=" + doe
				+ ", dom=" + dom + "]";
	}



}
