package com.techquiz.trainer.web.controller.vo;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;

public class ConsultantsVO {

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
    

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTuserid() {
		return tuserid;
	}

	public void setTuserid(String tuserid) {
		this.tuserid = tuserid;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

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

	@Override
	public String toString() {
		return "ConsultantsVO [cid=" + cid + ", empid=" + empid + ", name="
				+ name + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + ", userid=" + userid + ", dob="
				+ dob + ", doj=" + doj + ", batch=" + batch + ", role=" + role
				+ ", stream=" + stream + ", active=" + active + ", doe=" + doe
				+ ", dom=" + dom + ", adminid=" + adminid + ", org=" + org
				+ ", gender=" + gender + ", lockStatus=" + lockStatus + "]";
	}

}
