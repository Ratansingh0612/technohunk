package com.synergisitic.it.web.form;

import java.sql.Timestamp;

public class StreamForm {
	private int sid;
	private String stream;
	private String comment;
	private String active;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "StreamForm [sid=" + sid + ", stream=" + stream + ", comment="
				+ comment + ", active=" + active + ", doe=" + doe + ", dom="
				+ dom + ", userid=" + userid + "]";
	}

}
