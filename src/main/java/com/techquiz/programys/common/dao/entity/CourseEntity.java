package com.techquiz.programys.common.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses_tbl")
public class CourseEntity {
	private int cid;
	private String name;
	private String description;
	private String active;
	private Timestamp doe;
	private Timestamp dom;
	private String euserid;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Column(length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 100)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Column(length = 100)
	public String getEuserid() {
		return euserid;
	}

	public void setEuserid(String euserid) {
		this.euserid = euserid;
	}

	@Override
	public String toString() {
		return "CourseEntity [cid=" + cid + ", name=" + name + ", description="
				+ description + ", active=" + active + ", doe=" + doe
				+ ", dom=" + dom + ", euserid=" + euserid + "]";
	}

}
