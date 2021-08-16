package com.techquiz.programys.common.controller.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ErrorLogForm {
	private int lid;
	String errorText;
	private String userName;
	private Timestamp doe;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	
	@Column(length=5000)
	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	@Column(length=100)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "ErrorLogForm [lid=" + lid + ", errorText=" + errorText + ", userName=" + userName + ", doe=" + doe
				+ "]";
	}

}
