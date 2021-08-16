package com.synergisitic.it.model;

import java.sql.Timestamp;

//select t.tname,t.shortName,t.image,a.testName,a.totalQuestions,a.testDuration,a.dateOfEntry  from  technology_tbl as t , available_test_tbl as a where   a.techName=t.tname and t.tname='Spring'
public class UserTechTestDetailEntity {
	
	private String tname;
	private String shortName;
	private String image;
	private String testName;
	private int totalQuestions;
	private int testDuration;
	private Timestamp dateOfEntry;

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public int getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}

	public Timestamp getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Timestamp dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	@Override
	public String toString() {
		return "UserTechTestDetailEntity [tname=" + tname + ", shortName=" + shortName + ", image=" + image
				+ ", testName=" + testName + ", totalQuestions=" + totalQuestions + ", testDuration=" + testDuration
				+ ", dateOfEntry=" + dateOfEntry + "]";
	}

}
