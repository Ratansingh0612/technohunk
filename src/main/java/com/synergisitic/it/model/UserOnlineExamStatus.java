package com.synergisitic.it.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author nagendra.yadav
 * 
 */
@Entity
@Table(name = "user_online_exam_status_tbl")
//@NamedQuery(name="find.all.online.exam.status.by.userid",query="from UserOnlineExamStatus as uoes where uoes.userId=?")
public class UserOnlineExamStatus {

	private int id;
	private String testName;
	private String techName;
	private String userId;
	private Date dateOfTest;
	private int totalNoQuestion;
	private int totalNoAnsweredQuestion;
	private int totalMarks;
	private int secureMarks;
	private int totalCorrectAnswer;
	private int totalWrongAnswer;
	//This can take two values
	//Complete and incomplete
	private String examStatus;
	private String description;
	private String userSessionId;
	private int noOfAttemts;

	public int getNoOfAttemts() {
		return noOfAttemts;
	}

	public void setNoOfAttemts(int noOfAttemts) {
		this.noOfAttemts = noOfAttemts;
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
	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	@Column(length=30)
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

	@Column(length=100)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Date getDateOfTest() {
		return dateOfTest;
	}

	public void setDateOfTest(Date dateOfTest) {
		this.dateOfTest = dateOfTest;
	}

	public int getTotalNoQuestion() {
		return totalNoQuestion;
	}

	public void setTotalNoQuestion(int totalNoQuestion) {
		this.totalNoQuestion = totalNoQuestion;
	}

	public int getTotalNoAnsweredQuestion() {
		return totalNoAnsweredQuestion;
	}

	public void setTotalNoAnsweredQuestion(int totalNoAnsweredQuestion) {
		this.totalNoAnsweredQuestion = totalNoAnsweredQuestion;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getSecureMarks() {
		return secureMarks;
	}

	public void setSecureMarks(int secureMarks) {
		this.secureMarks = secureMarks;
	}

	public int getTotalCorrectAnswer() {
		return totalCorrectAnswer;
	}

	public void setTotalCorrectAnswer(int totalCorrectAnswer) {
		this.totalCorrectAnswer = totalCorrectAnswer;
	}

	public int getTotalWrongAnswer() {
		return totalWrongAnswer;
	}

	public void setTotalWrongAnswer(int totalWrongAnswer) {
		this.totalWrongAnswer = totalWrongAnswer;
	}

	@Column(length=50)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	@Override
	public String toString() {
		return "UserOnlineExamStatus [id=" + id + ", testName=" + testName + ", techName=" + techName + ", userId="
				+ userId + ", dateOfTest=" + dateOfTest + ", totalNoQuestion=" + totalNoQuestion
				+ ", totalNoAnsweredQuestion=" + totalNoAnsweredQuestion + ", totalMarks=" + totalMarks
				+ ", secureMarks=" + secureMarks + ", totalCorrectAnswer=" + totalCorrectAnswer + ", totalWrongAnswer="
				+ totalWrongAnswer + ", examStatus=" + examStatus + ", description=" + description + ", userSessionId="
				+ userSessionId + ", noOfAttemts=" + noOfAttemts + "]";
	}

	

}
