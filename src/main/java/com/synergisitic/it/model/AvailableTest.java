package com.synergisitic.it.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(  name = "available_test_tbl",uniqueConstraints = {@UniqueConstraint(columnNames = {"testName","techName","lastModifyBy"})})
//@NamedQuery(name="find.all.available.online.test",query="from AvailableTest")
public class AvailableTest {

	private int id;
	private String testName;
	private String techName;
	private int testDuration;
	private int durationOnEachQ;
	private String questionIds;
	private int totalQuestions;
	private String testInstruction;
	private int markQuestion;
	private Date dateOfEntry;
	private Date lastModifyOn;
	private String lastModifyBy;
	private int noOfAttempts;
	private boolean randQuestion;
	private boolean randOption;

	public boolean isRandOption() {
		return randOption;
	}

	public void setRandOption(boolean randOption) {
		this.randOption = randOption;
	}

	public boolean isRandQuestion() {
		return randQuestion;
	}

	public void setRandQuestion(boolean randQuestion) {
		this.randQuestion = randQuestion;
	}

	public int getMarkQuestion() {
		return markQuestion;
	}

	public void setMarkQuestion(int markQuestion) {
		this.markQuestion = markQuestion;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length=100)
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Column(length=30)
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	
	public int getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}

	public int getDurationOnEachQ() {
		return durationOnEachQ;
	}

	public void setDurationOnEachQ(int durationOnEachQ) {
		this.durationOnEachQ = durationOnEachQ;
	}

	@Column(length=3000)
	public String getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(String questionIds) {
		this.questionIds = questionIds;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	@Column(length=100)
	public String getTestInstruction() {
		return testInstruction;
	}

	public void setTestInstruction(String testInstruction) {
		this.testInstruction = testInstruction;
	}
	
	@Column(length=15)
	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	@Column(length=15)
	public Date getLastModifyOn() {
		return lastModifyOn;
	}

	public void setLastModifyOn(Date lastModifyOn) {
		this.lastModifyOn = lastModifyOn;
	}

	@Column(length=100)
	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}

	public int getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}
	
	@Override
	public String toString() {
		return "AvailableTest [id=" + id + ", testName=" + testName
				+ ", techName=" + techName + ", questionIds=" + questionIds
				+ "]";
	}
}
