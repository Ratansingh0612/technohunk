package com.techquiz.trainer.web.controller.vo;

import java.sql.Timestamp;

public class InterviewQuestionsAnswerVO {
	private long qid;
	private String questionText;
	private String answerText;
	private String techName;
	private String topic;
	private String complexity;
	private Timestamp doe;
	private String userid;
	private int orderid;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public long getQid() {
		return qid;
	}

	public void setQid(long qid) {
		this.qid = qid;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "InterviewQuestionsAnswerVO [qid=" + qid + ", questionText=" + questionText + ", answerText="
				+ answerText + ", techName=" + techName + ", topic=" + topic + ", complexity=" + complexity + ", doe="
				+ doe + ", userid=" + userid + "]";
	}

	public void setCategory(String techName2) {
		// TODO Auto-generated method stub
		
	}


}
