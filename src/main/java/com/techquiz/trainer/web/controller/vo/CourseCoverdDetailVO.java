package com.techquiz.trainer.web.controller.vo;

import java.sql.Timestamp;

public class CourseCoverdDetailVO 
{
	private int cid;
	private String name;
	private String description;
	private Timestamp doe;
	private Timestamp dom;
	private String euserid;
	private String active;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getEuserid() {
		return euserid;
	}
	public void setEuserid(String euserid) {
		this.euserid = euserid;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "CourseCoverdDetailVO [cid=" + cid + ", name=" + name + ", description=" + description + ", doe=" + doe
				+ ", dom=" + dom + ", euserid=" + euserid + ", active=" + active + "]";
	}
	

}
