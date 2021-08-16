/**
 * 
 */
package com.techquiz.consultant.attendance.vo;

/**
 * @author nagendra.yadav
 *
 */
public class StudentListVO implements Comparable<StudentListVO>{
 private String upTechRoll;
 private String studentName; 
 private String studentRoll;
 private String absRolls;
 private String email;
 private int roworder;
 private String studentId;
 
 public StudentListVO(){
	 
 }

public String getStudentId() {
	return studentId;
}

public void setStudentId(String studentId) {
	this.studentId = studentId;
}

public void setUpTechRoll(String upTechRoll) {
	this.upTechRoll = upTechRoll;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public void setStudentRoll(String studentRoll) {
	this.studentRoll = studentRoll;
}

public int getRoworder() {
	return roworder;
}

public void setRoworder(int roworder) {
	this.roworder = roworder;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public StudentListVO(String upTechRoll, String studentName, String studentRoll,
		String absRolls, String email) {
	super();
	this.upTechRoll = upTechRoll;
	this.studentName = studentName;
	this.studentRoll = studentRoll;
	this.absRolls = absRolls;
	this.email = email;
}

public StudentListVO(String upTechRoll,String studentName,String studentRoll,String absRolls)
 { 	 this.upTechRoll=upTechRoll;
	 this.studentName=studentName;
	 this.studentRoll=studentRoll;
	 this.absRolls=absRolls ;
 }
 
 public StudentListVO(String upTechRoll,String studentName,String studentRoll)
 { 	 this.upTechRoll=upTechRoll;
	 this.studentName=studentName;
	 this.studentRoll=studentRoll;
 }
 
 public StudentListVO(String upTechRoll, String studentName, String studentRoll,
		int roworder) {
	super();
	this.upTechRoll = upTechRoll;
	this.studentName = studentName;
	this.studentRoll = studentRoll;
	this.roworder = roworder;
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

/**
 * @return the absRolls
 */
public String getAbsRolls() {
	return absRolls;
}

@Override
public int compareTo(StudentListVO o) {
	int p=0;
	p=roworder-o.roworder;
	return p;
} 
}
