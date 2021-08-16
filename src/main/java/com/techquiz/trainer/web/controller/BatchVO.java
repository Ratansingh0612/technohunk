package com.techquiz.trainer.web.controller;

import java.sql.Timestamp;

public class BatchVO {
	private int bid;
	private String batch;
	private String active;
	private String comment;
	private String userid;
	private Timestamp doe;
	private Timestamp dom;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	@Override
	public String toString() {
		return "BatchVO [bid=" + bid + ", batch=" + batch + ", active=" + active + ", comment=" + comment + ", userid="
				+ userid + ", doe=" + doe + ", dom=" + dom + "]";
	}

}
