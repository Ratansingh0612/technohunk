package com.techquiz.control.panel.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="news_letter_subscription_tbl")
public class NewsLetterEntity {
	private long nlid;
	private String email;
	private Timestamp doe;
	private Timestamp dom;

	@Id
	@GeneratedValue
	public long getNlid() {
		return nlid;
	}

	public void setNlid(long nlid) {
		this.nlid = nlid;
	}

	@Column(length=120)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "NewsLetterEntity [nlid=" + nlid + ", email=" + email + ", doe=" + doe + ", dom=" + dom + "]";
	}

}
