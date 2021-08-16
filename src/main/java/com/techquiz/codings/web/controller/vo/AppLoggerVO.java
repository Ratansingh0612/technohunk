package com.techquiz.codings.web.controller.vo;

import java.sql.Timestamp;

/**
 * 
 * @author Nagendra
 *
 */
public class AppLoggerVO {

	private long applogid;
	private String stacktrace;
	private String comment;
	private String loginDetails;
	private Timestamp doe;

	public long getApplogid() {
		return applogid;
	}

	public void setApplogid(long applogid) {
		this.applogid = applogid;
	}

	public String getStacktrace() {
		return stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

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
		return "AppLoggerVO [applogid=" + applogid + ", stacktrace=" + stacktrace + ", comment=" + comment
				+ ", loginDetails=" + loginDetails + ", doe=" + doe + "]";
	}
	
}
