package com.techquiz.programys.common.controller.model;

import java.sql.Timestamp;

/**
 * 
 * @author Nagendra
 *
 */
public class QuestionsBankForm {
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

	
	public String getVisibleAll() {
		return visibleAll;
	}

	public void setVisibleAll(String visibleAll) {
		this.visibleAll = visibleAll;
	}

	public String getExcelSheetName() {
		return excelSheetName;
	}

	public void setExcelSheetName(String excelSheetName) {
		this.excelSheetName = excelSheetName;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getQbankname() {
		return qbankname;
	}

	public void setQbankname(String qbankname) {
		this.qbankname = qbankname;
	}

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
		return "QuestionsBankForm [sno=" + sno + ", qbankname=" + qbankname + ", techName=" + techName + ", noq="
				+ noq + ", ownerName=" + ownerName + ", doe=" + doe + ", url=" + url + ", description=" + description
				+ "]";
	}

}
