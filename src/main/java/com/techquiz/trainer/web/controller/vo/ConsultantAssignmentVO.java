package com.techquiz.trainer.web.controller.vo;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

public class ConsultantAssignmentVO {

	private int aid;
	private String consultantId;
	private String topicId;
	private String technologyId;
	private Timestamp doe;
	private Timestamp dom;
	private String discription;
	private String status;
	private String userid;
	private String assigment;
	private String batch;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getAssigment() {
		return assigment;
	}

	public void setAssigment(String assigment) {
		this.assigment = assigment;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(String technologyId) {
		this.technologyId = technologyId;
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "ConsultantAssignmentVO [aid=" + aid + ", consultantId=" + consultantId + ", topicId=" + topicId
				+ ", technologyId=" + technologyId + ", doe=" + doe + ", dom=" + dom + ", discription=" + discription
				+ ", status=" + status + ", userid=" + userid + ", assigment=" + assigment + ", batch=" + batch + "]";
	}

}
