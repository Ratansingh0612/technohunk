package com.techquiz.trainer.dao.entity;

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

@Entity
@Table(name = "consultant_assignments_tbl")
public class ConsultantAssignmentEntity {

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

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	@Column(length=200)
	public String getAssigment() {
		return assigment;
	}

	public void setAssigment(String assigment) {
		this.assigment = assigment;
	}

	@Column(length=50)
	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	@Column(length=50)
	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	@Column(length=20)
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

	@Column(length=100)
	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Column(length=100)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(length=100)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "ConsultantAssignmentEntity [aid=" + aid + ", consultantId=" + consultantId + ", topicId=" + topicId
				+ ", technologyId=" + technologyId + ", doe=" + doe + ", dom=" + dom + ", discription=" + discription
				+ ", status=" + status + ", userid=" + userid + "]";
	}

}
