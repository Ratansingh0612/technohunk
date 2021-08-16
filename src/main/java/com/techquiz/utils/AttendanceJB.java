package com.techquiz.utils;

/**
 * This class is used as VO for attendance page
 */

import java.io.Serializable;
import java.util.Set;

/**
 * @author nagendra.yadav
 *
 */
public class AttendanceJB implements Serializable{
private Set subjectSet;
private Set branchSet;
private Set semesterSet;
private Set sectionSet;
private Set month;
public AttendanceJB(){
}
public AttendanceJB(Set subjectSet,Set branchSet,Set semesterSet,Set sectionSet){
	this.subjectSet=subjectSet;
	this.branchSet=branchSet;
	this.semesterSet=semesterSet;
	this.sectionSet=sectionSet;
}
public AttendanceJB(Set subjectSet,Set branchSet,Set semesterSet,Set sectionSet,Set month){
	this(subjectSet,branchSet,semesterSet,sectionSet);
	this.month=month;
}

/**
 * @return the branchSet
 */
public Set getBranchSet() {
	return branchSet;
}
/**
 * @return the sectionSet
 */
public Set getSectionSet() {
	return sectionSet;
}
/**
 * @return the semesterSet
 */
public Set getSemesterSet() {
	return semesterSet;
}
/**
 * @return the subjectSet
 */
public Set getSubjectSet() {
	return subjectSet;
}
/**
 * @return the month
 */
public Set getMonth() {
	return month;
}

	
}
