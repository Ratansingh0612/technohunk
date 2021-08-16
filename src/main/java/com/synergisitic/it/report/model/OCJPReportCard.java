package com.synergisitic.it.report.model;

import java.util.Date;

public class OCJPReportCard {

	private Date dateOfTest;
	private String sdateOfTest;
	private String examStatus;
	private int secureMarks;
	private String testName;
	private int totalMarks;
	private String userSessionId;
	

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public Date getDateOfTest() {
		return dateOfTest;
	}

	public void setDateOfTest(Date dateOfTest) {
		this.dateOfTest = dateOfTest;
	}

	public String getSdateOfTest() {
		return sdateOfTest;
	}

	public void setSdateOfTest(String sdateOfTest) {
		this.sdateOfTest = sdateOfTest;
	}

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public int getSecureMarks() {
		return secureMarks;
	}

	public void setSecureMarks(int secureMarks) {
		this.secureMarks = secureMarks;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	@Override
	public String toString() {
		return "OCJPReportCard [dateOfTest=" + dateOfTest + ", sdateOfTest=" + sdateOfTest + ", examStatus="
				+ examStatus + ", secureMarks=" + secureMarks + ", testName=" + testName + ", totalMarks=" + totalMarks
				+ ", userSessionId=" + userSessionId + "]";
	}

	

}
