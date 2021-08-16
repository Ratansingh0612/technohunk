package com.techquiz.info.jdbc.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Nagendra
 *
 */
@Entity
@Table(name="questions_bank_tbl")
public class QuestionsBankEntity {
	private int sno;
	private String qbankname;
	private String techName;
	private int noq;
	private String ownerName;
	private String excelSheetName;
	private Timestamp doe;
	private String url;
	private String description;
	public String visibleAll;
	
	@Column(length=50)
	public String getExcelSheetName() {
		return excelSheetName;
	}

	public void setExcelSheetName(String excelSheetName) {
		this.excelSheetName = excelSheetName;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSno() {
		return sno;
	}
	

	public void setSno(int sno) {
		this.sno = sno;
	}
	
	@Column(length=3)
	public String getVisibleAll() {
		return visibleAll;
	}

	public void setVisibleAll(String visibleAll) {
		this.visibleAll = visibleAll;
	}

	@Column(length=40)
	public String getQbankname() {
		return qbankname;
	}

	public void setQbankname(String qbankname) {
		this.qbankname = qbankname;
	}

	@Column(length=30)
	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public int getNoq() {
		return noq;
	}

	public void setNoq(int noq) {
		this.noq = noq;
	}

	@Column(length=100)
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Timestamp getDoe() {
		return doe;
	}

	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}

	@Column(length=100)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "QuestionsBankEntity [sno=" + sno + ", qbankname=" + qbankname + ", techName=" + techName + ", noq="
				+ noq + ", ownerName=" + ownerName + ", doe=" + doe + ", url=" + url + ", description=" + description
				+ "]";
	}

}
