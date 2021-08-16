package com.techquiz.programys.common.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batches_tbl")
public class BatchEntity {
	private int bid;
	private String batch;
	private String comment;
	private String active;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Column(length=3)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Column(length=20)
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Column(length=50)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Column(length=30)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "BatchEntity [bid=" + bid + ", batch=" + batch + ", comment="
				+ comment + ", active=" + active + ", doe=" + doe + ", dom="
				+ dom + ", userid=" + userid + "]";
	}

}
