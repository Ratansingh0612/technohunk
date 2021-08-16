package com.techquiz.codings.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author nagendra
 *
 */
@Entity
@Table(name = "test_cases_tbl")
public class TestCasesEntity {
	private long tcid;
	private String expectedInput;
	private String expectedOutput;
	private String comment;
	private Timestamp doe;
	private Timestamp dom;
	private CodingProblemsEntity codingProblems;
	
    
	@Id
	@GeneratedValue
	public long getTcid() {
		return tcid;
	}

	public void setTcid(long tcid) {
		this.tcid = tcid;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cprob_id", nullable = false)
	public CodingProblemsEntity getCodingProblems() {
		return codingProblems;
	}

	public void setCodingProblems(CodingProblemsEntity codingProblems) {
		this.codingProblems = codingProblems;
	}

	@Column(name="expected_input",length=200)
	public String getExpectedInput() {
		return expectedInput;
	}

	public void setExpectedInput(String expectedInput) {
		this.expectedInput = expectedInput;
	}

	@Column(name="expected_output",length=150)
	public String getExpectedOutput() {
		return expectedOutput;
	}

	public void setExpectedOutput(String expectedOutput) {
		this.expectedOutput = expectedOutput;
	}

	@Column(name="comment",length=300)
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
		return "TestCasesEntity [tcid=" + tcid + ", expectedInput=" + expectedInput + ", expectedOutput="
				+ expectedOutput + ", comment=" + comment + ", doe=" + doe + ", dom=" + dom + "]";
	}

}
