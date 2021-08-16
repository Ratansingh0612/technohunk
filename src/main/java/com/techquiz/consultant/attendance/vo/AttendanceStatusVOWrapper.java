package com.techquiz.consultant.attendance.vo;

import java.util.List;

/**
 * 
 * @author nagendra.yadav
 *  @Since 6th July 2014
 *
 */
public class AttendanceStatusVOWrapper implements Comparable<AttendanceStatusVOWrapper> {
	
	private int totalStudent;
	private int totalPresentStudent;
	private String facultyName;
	private String empCode;
	private float totalAvgStudentInClass;
	private String subjectCode;
	private String subjectName;
	private String subShortName;
	private String gperiod;
	private List<AttendanceStatusVO> attendanceStatusVOs;
	private List<String> dayPeriods;
	private String subjectType;
	private String labName;

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public List<String> getDayPeriods() {
		return dayPeriods;
	}

	public void setDayPeriods(List<String> dayPeriods) {
		this.dayPeriods = dayPeriods;
	}

	public int getTotalPresentStudent() {
		return totalPresentStudent;
	}

	public void setTotalPresentStudent(int totalPresentStudent) {
		this.totalPresentStudent = totalPresentStudent;
	}

	public String getGperiod() {
		return gperiod;
	}

	public void setGperiod(String gperiod) {
		this.gperiod = gperiod;
	}

	
	public String getSubShortName() {
		return subShortName;
	}

	public void setSubShortName(String subShortName) {
		this.subShortName = subShortName;
	}

	public int getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(int totalStudent) {
		this.totalStudent = totalStudent;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public float getTotalAvgStudentInClass() {
		return totalAvgStudentInClass;
	}

	public void setTotalAvgStudentInClass(float totalAvgStudentInClass) {
		this.totalAvgStudentInClass = totalAvgStudentInClass;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<AttendanceStatusVO> getAttendanceStatusVOs() {
		return attendanceStatusVOs;
	}

	public void setAttendanceStatusVOs(
			List<AttendanceStatusVO> attendanceStatusVOs) {
		this.attendanceStatusVOs = attendanceStatusVOs;
	}

	@Override
	public String toString() {
		return "AttendanceStatusVOWrapper [totalStudent=" + totalStudent
				+ ", totalPresentStudent=" + totalPresentStudent
				+ ", facultyName=" + facultyName + ", empCode=" + empCode
				+ ", totalAvgStudentInClass=" + totalAvgStudentInClass
				+ ", subjectCode=" + subjectCode + ", subjectName="
				+ subjectName + ", subShortName=" + subShortName + ", gperiod="
				+ gperiod + ", attendanceStatusVOs=" + attendanceStatusVOs
				+ ", dayPeriod=" + dayPeriods + "]";
	}

	@Override
	public int compareTo(AttendanceStatusVOWrapper o) {
		return gperiod.compareTo(o.getGperiod());
	}

}
