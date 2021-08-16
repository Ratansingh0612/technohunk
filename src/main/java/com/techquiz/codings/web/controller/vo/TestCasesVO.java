package com.techquiz.codings.web.controller.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author VC1
 * @Since 02-08-2018 
 */
public class TestCasesVO {

	private long tcid;
	private String expectedInput;
	private String expectedOutput;
	private String comment;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
	private Timestamp doe;
	private Timestamp dom;

	public long getTcid() {
		return tcid;
	}

	public void setTcid(long tcid) {
		this.tcid = tcid;
	}

	public String getExpectedInput() {
		return expectedInput;
	}

	public void setExpectedInput(String expectedInput) {
		this.expectedInput = expectedInput;
	}

	public String getExpectedOutput() {
		return expectedOutput;
	}

	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
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

	@Override
	public String toString() {
		return "TestCasesVO [tcid=" + tcid + ", expectedInput=" + expectedInput + ", expectedOutput=" + expectedOutput
				+ ", comment=" + comment + ", doe=" + doe + ", dom=" + dom + "]";
	}

}
