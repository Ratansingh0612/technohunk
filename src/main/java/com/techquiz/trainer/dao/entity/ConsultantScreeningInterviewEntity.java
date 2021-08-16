package com.techquiz.trainer.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consultant_screening_interview_tbl")
public class ConsultantScreeningInterviewEntity {
	private long csie;
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getCsie() {
		return csie;
	}

	public void setCsie(long csie) {
		this.csie = csie;
	}

	@Column(length=100)
	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	@Column(length=50)
	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Column(length=100)
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

	@Column(length=200)
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Column(length=1000)
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(length=2)
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Column(length=100)
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

	@Column(length=100)
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	@Column(length=300)
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
				+ comment + "]";
	}

}
