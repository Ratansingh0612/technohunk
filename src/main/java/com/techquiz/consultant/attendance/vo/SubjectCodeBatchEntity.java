package com.techquiz.consultant.attendance.vo;

public class SubjectCodeBatchEntity {
	private String subjectCode;
	private String shortSubjectName;
	private String labName;
	private String subjectType;

	public String getShortSubjectName() {
		return shortSubjectName;
	}

	public void setShortSubjectName(String shortSubjectName) {
		this.shortSubjectName = shortSubjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	@Override
	public String toString() {
		return "SubjectCodeBatchEntity [subjectCode=" + subjectCode
				+ ", shortSubjectName=" + shortSubjectName + ", labName="
				+ labName + ", subjectType=" + subjectType + "]";
	}

}
