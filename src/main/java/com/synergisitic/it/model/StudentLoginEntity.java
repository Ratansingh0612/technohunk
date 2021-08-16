package com.synergisitic.it.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students_login_tbl")
public class StudentLoginEntity {

	@Id
	@Column(length = 100)
	private String studentRoll;
	
	@Column(length = 20)
	private String password;
	
	@Column(length = 20)
	private String role;
	
	@Column(length = 3)
	private String locked;
	
	private Date doe;
	
	private Date dom;
	
	@Column(name = "e_userid", length = 20)
	private String euserid;

	public String getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(String studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public Date getDom() {
		return dom;
	}

	public void setDom(Date dom) {
		this.dom = dom;
	}

	public String getEuserid() {
		return euserid;
	}

	public void setEuserid(String euserid) {
		this.euserid = euserid;
	}

	@Override
	public String toString() {
		return "StudentLoginEntity [studentRoll=" + studentRoll + ", password="
				+ password + ", role=" + role + ", locked=" + locked + ", doe="
				+ doe + ", dom=" + dom + ", euserid=" + euserid + "]";
	}

}
