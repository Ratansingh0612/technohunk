package com.synergisitic.it.web.form;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.synergisitic.it.util.JsonDateSerializer;

/**
 * 
 * @author nagendra.yadav
 * 
 * This pojo will be used to create new test.
 */
@JsonInclude(value=Include.NON_NULL)
public class TestConfiguration {

	private int id;
	private String techName;
	private String testName;
	private int totalQuestions;
	private int testDuration;
	private int markQuestion;
	private String testInstruction;
	private int durationOnEachQ;
	private int noOfAttempts;
	private int validity;
	private String questionIds;
	
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date dateOfEntry;
	private Date lastModifyOn;
	private String lastModifyBy;
	
	private boolean randQuestion;
	private boolean randOption;
	
	/**
	 * @return the validity
	 */
	public int getValidity() {
		return validity;
	}

	/**
	 * @param validity the validity to set
	 */
	public void setValidity(int validity) {
		this.validity = validity;
	}

	private String timage;
	
	
	public String getTimage() {
		return timage;
	}

	public void setTimage(String timage) {
		this.timage = timage;
	}

	public String getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(String questionIds) {
		this.questionIds = questionIds;
	}
	

	public int getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getMarkQuestion() {
		return markQuestion;
	}

	public void setMarkQuestion(int markQuestion) {
		this.markQuestion = markQuestion;
	}

	public String getTestInstruction() {
		return testInstruction;
	}

	public void setTestInstruction(String testInstruction) {
		this.testInstruction = testInstruction;
	}

	public int getDurationOnEachQ() {
		return durationOnEachQ;
	}

	public void setDurationOnEachQ(int durationOnEachQ) {
		this.durationOnEachQ = durationOnEachQ;
	}

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public Date getLastModifyOn() {
		return lastModifyOn;
	}

	public void setLastModifyOn(Date lastModifyOn) {
		this.lastModifyOn = lastModifyOn;
	}

	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

	@Override
	public String toString() {
		return "TestConfiguration [id=" + id + ", techName=" + techName
				+ ", testName=" + testName + ", totalQuestions=" + totalQuestions + ", testDuration="
				+ testDuration + ", markQuestion=" + markQuestion
				+ ", testInstruction=" + testInstruction + ", durationOnEachQ="
				+ durationOnEachQ + "]";
	}

	public boolean isRandQuestion() {
		return randQuestion;
	}

	public void setRandQuestion(boolean randQuestion) {
		this.randQuestion = randQuestion;
	}

	public boolean isRandOption() {
		return randOption;
	}

	public void setRandOption(boolean randOption) {
		this.randOption = randOption;
	}
	
	
}
