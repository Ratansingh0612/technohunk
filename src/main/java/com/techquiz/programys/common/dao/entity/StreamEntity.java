package com.techquiz.programys.common.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="streams_tbl")
public class StreamEntity {
	private int sid;
	private String stream;
	private String comment;
	private String active;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Column(length=3)
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
	
	@Column(length=50)
	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
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
		return "StreamEntity [sid=" + sid + ", stream=" + stream + ", comment="
				+ comment + ", active=" + active + ", doe=" + doe + ", dom="
				+ dom + ", userid=" + userid + "]";
	}

}
