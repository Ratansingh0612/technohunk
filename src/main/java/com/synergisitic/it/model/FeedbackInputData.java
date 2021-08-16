package com.synergisitic.it.model;


/**
 * 
 * @author Nagendra
 *
 */
public class FeedbackInputData {
	private int fid;
	private String consultantid;
	private String empid;
	private long sid;
	private String comment;
	
	/**
	 * @return the empid
	 */
	public String getEmpid() {
		return empid;
	}

	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(String empid) {
		this.empid = empid;
	}

	/**
	 * @return the fid
	 */
	public int getFid() {
		return fid;
	}

	/**
	 * @param fid
	 *            the fid to set
	 */
	public void setFid(int fid) {
		this.fid = fid;
	}

	/**
	 * @return the consultantid
	 */
	public String getConsultantid() {
		return consultantid;
	}

	/**
	 * @param consultantid
	 *            the consultantid to set
	 */
	public void setConsultantid(String consultantid) {
		this.consultantid = consultantid;
	}

	/**
	 * @return the sid
	 */
	public long getSid() {
		return sid;
	}

	/**
	 * @param sid
	 *            the sid to set
	 */
	public void setSid(long sid) {
		this.sid = sid;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FeedbackInputData [fid=" + fid + ", consultantid=" + consultantid + ", sid=" + sid + ", comment="
				+ comment + "]";
	}

}
