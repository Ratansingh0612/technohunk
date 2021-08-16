package com.techquiz.control.panel.controller.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author Nagendra
 *
 */
public class NewsLetterVO {
	private long nlid;
	private String email;
	private Timestamp doe;
	private Timestamp dom;

	public long getNlid() {
		return nlid;
	}

	public void setNlid(long nlid) {
		this.nlid = nlid;
	}

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
		return "NewsLetterVO [nlid=" + nlid + ", email=" + email + ", doe=" + doe + ", dom=" + dom + "]";
	}

}
