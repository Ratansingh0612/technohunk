package com.techquiz.trainer.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses_tbl")
public class CourseCoverdEntity {
	private int cid;
	private String name;
	private String description;
	private Timestamp doe;
	private Timestamp dom;
	private String euserid;
	private String active;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	@Column(length=100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=100)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	@Column(length=100)
	public String getEuserid() {
		return euserid;
	}
	public void setEuserid(String euserid) {
		this.euserid = euserid;
	}
	@Column(length=255)
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "CourseCoverdEntity [cid=" + cid + ", name=" + name + ", description=" + description + ", doe=" + doe
				+ ", dom=" + dom + ", euserid=" + euserid + ", active=" + active + "]";
	}
	
	
	

}
