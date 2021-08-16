package com.techquiz.consultant.attendance.vo;

import java.io.Serializable;

/**
 * 
 * @author astha
 *
 */
public class SubjectAssignmentVO implements Serializable {
	
	private int userid;
	private String subcode;
	private String brsemsec;
	private String subjectname;
	private String subtype;
	private String fshortsubjectname;
	private String labName;

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public SubjectAssignmentVO() {

	}

	public SubjectAssignmentVO(int userid, String subcode, String brsemsec,
			String subjectname, String subtype, String fshortsubjectname) {
		super();
		this.userid = userid;
		this.subcode = subcode;
		this.brsemsec = brsemsec;
		this.subjectname = subjectname;
		this.subtype = subtype;
		this.fshortsubjectname = fshortsubjectname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getBrsemsec() {
		return brsemsec;
	}

	public void setBrsemsec(String brsemsec) {
		this.brsemsec = brsemsec;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getFshortsubjectname() {
		return fshortsubjectname;
	}

	public void setFshortsubjectname(String fshortsubjectname) {
		this.fshortsubjectname = fshortsubjectname;
	}

	@Override
	public String toString() {
		return "SubjectAssignmentVO [userid=" + userid + ", subcode=" + subcode
				+ ", brsemsec=" + brsemsec + ", subjectname=" + subjectname
				+ ", subtype=" + subtype + ", fshortsubjectname="
				+ fshortsubjectname + "]";
	}

}
