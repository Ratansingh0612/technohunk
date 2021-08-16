package com.techquiz.trainer.dao.entity;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="consultants_tbl")
public class ConsultantsEntity {
	private String testStatus;
	private int cid;
	private String empid;
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String userid;
	private byte[] image;
	private Date dob;
	private Date doj;
	private String batch;
	private String role;
	private String stream;
	private String active;
	private Timestamp doe;
	private Timestamp dom;
	private String adminid;
	private String org;
	private String gender;
	private String lockStatus;
    private String tuserid;
    private String address;
    private String visa;
    private String remarks;
    private String degree;

    public String getVisa() {
		return visa;
	}


	public void setVisa(String visa) {
		this.visa = visa;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	@Column(length=500)
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Transient
	public String getTuserid() {
		return tuserid;
	}


	public void setTuserid(String tuserid) {
		this.tuserid = tuserid;
	}



	@Column(length=10)
	public String getTestStatus() {
		return testStatus;
	}




	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getCid() {
		return cid;
	}




	public void setCid(int cid) {
		this.cid = cid;
	}




	public String getEmpid() {
		return empid;
	}




	public void setEmpid(String empid) {
		this.empid = empid;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getUserid() {
		return userid;
	}




	public void setUserid(String userid) {
		this.userid = userid;
	}



	@Column(name="image",columnDefinition="longblob")
	public byte[] getImage() {
		return image;
	}




	public void setImage(byte[] image) {
		this.image = image;
	}




	public Date getDob() {
		return dob;
	}




	public void setDob(Date dob) {
		this.dob = dob;
	}




	public Date getDoj() {
		return doj;
	}




	public void setDoj(Date doj) {
		this.doj = doj;
	}




	public String getBatch() {
		return batch;
	}




	public void setBatch(String batch) {
		this.batch = batch;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public String getStream() {
		return stream;
	}




	public void setStream(String stream) {
		this.stream = stream;
	}




	public String getActive() {
		return active;
	}




	public void setActive(String active) {
		this.active = active;
	}




	public Timestamp getDoe() {
		return doe;
	}




	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}




	public Timestamp getDom() {
		return dom;
	}




	public void setDom(Timestamp dom) {
		this.dom = dom;
	}




	public String getAdminid() {
		return adminid;
	}




	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}




	public String getOrg() {
		return org;
	}




	public void setOrg(String org) {
		this.org = org;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getLockStatus() {
		return lockStatus;
	}




	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}




	@Override
	public String toString() {
		return "ConsultantsEntity [testStatus=" + testStatus + ", cid=" + cid + ", empid=" + empid + ", name=" + name
				+ ", email=" + email + ", mobile=" + mobile + ", password=" + password + ", userid=" + userid
				+ ", image=" + Arrays.toString(image) + ", dob=" + dob + ", doj=" + doj + ", batch=" + batch + ", role="
				+ role + ", stream=" + stream + ", active=" + active + ", doe=" + doe + ", dom=" + dom + ", adminid="
				+ adminid + ", org=" + org + ", gender=" + gender + ", lockStatus=" + lockStatus + "]";
	}

}
