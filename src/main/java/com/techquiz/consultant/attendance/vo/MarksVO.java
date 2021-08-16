package com.techquiz.consultant.attendance.vo;

/**
 * 
 */

import java.util.Date;

/**
 * @author Administrator
 *
 */
public class MarksVO implements Comparable<MarksVO> {
	 private String upTechRoll;
	 private String studentName; 
	 private String studentRoll;
	 private String marks ;
	 private String maxMarks;
	 private Date doe;
	 private int roworder;

	 public int getRoworder() {
	 	return roworder;
	 }

	 public void setRoworder(int roworder) {
	 	this.roworder = roworder;
	 }
	 
	 public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public MarksVO(String upTechRoll,String studentName,String studentRoll,String marks ){
		 
		 this.upTechRoll=upTechRoll ;
		 this.studentName=studentName;
		 this.studentRoll=studentRoll;
		 this.marks=marks;
	 }
	
	public MarksVO(String upTechRoll, String studentName, String studentRoll,
			String marks, String maxMarks,int roworder) {
		this.upTechRoll = upTechRoll;
		this.studentName = studentName;
		this.studentRoll = studentRoll;
		this.marks = marks;
		this.maxMarks = maxMarks;
		this.roworder=roworder;
	}
	 
	public MarksVO(String upTechRoll, String studentName, String studentRoll,
			String marks, String maxMarks,int roworder,Date date) {
		this.upTechRoll = upTechRoll;
		this.studentName = studentName;
		this.studentRoll = studentRoll;
		this.marks = marks;
		this.maxMarks = maxMarks;
		this.roworder=roworder;
		this.doe=date;
	}


	public String getMaxMarks() {
		return maxMarks;
	}


	/**
	 * @return the marks
	 */
	public String getMarks() {
		return marks;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @return the studentRoll
	 */
	public String getStudentRoll() {
		return studentRoll;
	}
	/**
	 * @return the upTechRoll
	 */
	public String getUpTechRoll() {
		return upTechRoll;
	}
	
	@Override
	public int compareTo(MarksVO o) {
		int p=0;
		p=roworder-o.roworder;
		return p;
	} 
}
