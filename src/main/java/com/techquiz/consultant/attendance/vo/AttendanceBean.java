/**
 * 
 */
package com.techquiz.consultant.attendance.vo;

import java.io.Serializable;


/**
 * @author nagendra.yadav
 * 
 */
public class AttendanceBean implements Serializable {

	private String subject;
	private String branch;
	private String semester;
	private String section;
	private String subCode;
	private String period;
	private String dd;
	private String mm;
	private String yy;
	private String ctType;
	private int maxMarks;
	private int empid;
	private String orderBy;
	private String reportType;
	private int percentageBelow;
	private String datepicker;
	private String temp;
	private String operationType;
	private String unit;
	private String topicDescription;
	private String[] remarks;
	private int numberOfRecords;
	private boolean isSubjectLab;
	private String labName;
	
	public boolean isSubjectLab() {
		return isSubjectLab;
	}

	public void setSubjectLab(boolean isSubjectLab) {
		this.isSubjectLab = isSubjectLab;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public String[] getRemarks() {
		return remarks;
	}

	public void setRemarks(String[] remarks) {
		this.remarks = remarks;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getSubCode() {
		return subCode;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getDatepicker() {
		return datepicker;
	}

	public void setDatepicker(String datepicker) {
		this.datepicker = datepicker;
	}

	/**
	 * @return the percentageBelow
	 */
	public int getPercentageBelow() {
		return percentageBelow;
	}

	/**
	 * @param percentageBelow
	 *            the percentageBelow to set
	 */
	public void setPercentageBelow(int percentageBelow) {
		this.percentageBelow = percentageBelow;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch
	 *            the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the dd
	 */
	public String getDd() {
		return dd;
	}

	/**
	 * @param dd
	 *            the dd to set
	 */
	public void setDd(String dd) {
		this.dd = dd;
	}

	/**
	 * @return the mm
	 */
	public String getMm() {
		return mm;
	}

	/**
	 * @param mm
	 *            the mm to set
	 */
	public void setMm(String mm) {
		this.mm = mm;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}

	/**
	 * @param period
	 *            the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}

	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @param section
	 *            the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester
	 *            the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the yy
	 */
	public String getYy() {
		return yy;
	}

	/**
	 * @param yy
	 *            the yy to set
	 */
	public void setYy(String yy) {
		this.yy = yy;
	}

	/**
	 * @return the ctType
	 */
	public String getCtType() {
		return ctType;
	}

	/**
	 * @param ctType
	 *            the ctType to set
	 */
	public void setCtType(String ctType) {
		this.ctType = ctType;
	}

	/**
	 * @return the maxMarks
	 */
	public int getMaxMarks() {
		return maxMarks;
	}

	/**
	 * @param maxMarks
	 *            the maxMarks to set
	 */
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	/**
	 * @return the empid
	 */
	public int getEmpid() {
		return empid;
	}

	/**
	 * @param empid
	 *            the empid to set
	 */
	public void setEmpid(int empid) {
		this.empid = empid;
	}

	/**
	 * @return the orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy
	 *            the orderBy to set
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * @return the reportType
	 */
	public String getReportType() {
		return reportType;
	}

	/**
	 * @param reportType
	 *            the reportType to set
	 */
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}
