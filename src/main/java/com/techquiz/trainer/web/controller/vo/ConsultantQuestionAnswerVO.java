package com.techquiz.trainer.web.controller.vo;

import java.sql.Timestamp;

public class ConsultantQuestionAnswerVO {
	private String consultantId;
	private String technology;
	private String topic;
	private String complexity;
	private String questionText;
	private String answer;
	private String rating;
	private String interviewerUserid;
	private Timestamp doe;
	private Timestamp dom;
	private String adminid;
	private String comment;
	private String operation;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
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

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getInterviewerUserid() {
		return interviewerUserid;
	}

	public void setInterviewerUserid(String interviewerUserid) {
		this.interviewerUserid = interviewerUserid;
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

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ConsultantQuestionAnswerVO [consultantId=" + consultantId
				+ ", technology=" + technology + ", topic=" + topic
				+ ", complexity=" + complexity + ", questionText="
				+ questionText + ", answer=" + answer + ", rating=" + rating
				+ ", interviewerUserid=" + interviewerUserid + ", doe=" + doe
				+ ", dom=" + dom + ", adminid=" + adminid + ", comment="
				+ comment + ", operation=" + operation + "]";
	}

}
