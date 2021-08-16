package com.techquiz.control.panel.dao.entity;

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
@Entity
@Table(name = "app_loggers_tbl")
public class AppLoggerEntity {

	private long applogid;
	private String stacktrace;
	private String comment;
	private String loginDetails;
	private Timestamp doe;

	@Id
	@GeneratedValue
	public long getApplogid() {
		return applogid;
	}

	public void setApplogid(long applogid) {
		this.applogid = applogid;
	}

	@Column(length=5000)
	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	@Column(length=1000)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(length=2000)
	public String getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(String loginDetails) {
		this.loginDetails = loginDetails;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "AppLoggerEntity [applogid=" + applogid + ", stacktrace=" + stacktrace + ", comment=" + comment
				+ ", loginDetails=" + loginDetails + ", doe=" + doe + "]";
	}
	
}
