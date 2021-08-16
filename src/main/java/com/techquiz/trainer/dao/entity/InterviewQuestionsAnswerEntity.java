package com.techquiz.trainer.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interview_questions_answer_tbl")
public class InterviewQuestionsAnswerEntity {
	private long qid;
	private String questionText;
	private String answerText;
	private String techName;
	private String topic;
	private String complexity;
	private Timestamp doe;
	private String userid;
	private int orderid;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getQid() {
		return qid;
	}

	public void setQid(long qid) {
		this.qid = qid;
	}

	@Column(length=1000)
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Column(length=3000)
	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	@Column(length=50)
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	@Column(length=50)
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Column(length=10)
	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Column(length=100)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	@Override
	public String toString() {
		return "InterviewQuestionsAnswerEntity [qid=" + qid + ", questionText=" + questionText + ", answerText="
				+ answerText + ", techName=" + techName + ", topic=" + topic + ", complexity=" + complexity + ", doe="
				+ doe + ", userid=" + userid + "]";
	}

}
