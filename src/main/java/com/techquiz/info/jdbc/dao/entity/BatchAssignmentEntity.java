package com.techquiz.info.jdbc.dao.entity;

import java.util.Date;

/**
 * 
 * @author Nagendra
 *
 */
public class BatchAssignmentEntity {

	private int baid;
	private String trainerName;
	private String batch;
	private String comment;
	private String batchid;
	private Date doc;
	private String adminid;

	public int getBaid() {
		return baid;
	}

	public void setBaid(int baid) {
		this.baid = baid;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	public Date getDoc() {
		return doc;
	}

	public void setDoc(Date doc) {
		this.doc = doc;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	@Override
	public String toString() {
		return "BatchAssignmentEntity [baid=" + baid + ", trainerName=" + trainerName + ", batch=" + batch
				+ ", comment=" + comment + ", batchid=" + batchid + ", doc=" + doc + ", adminid=" + adminid + "]";
	}

}
