package com.techquiz.trainer.web.controller.vo;

import java.sql.Timestamp;

public class CourseContentsDetailVO {
	private long ctid;
	private String topicname;
	private String topicid;
	private String technologyid;
	private String course;
	private String description;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;
	private String technologyname;
	public long getCtid() {
		return ctid;
	}
	public void setCtid(long ctid) {
		this.ctid = ctid;
	}
	public String getTopicname() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	public String getTopicid() {
		return topicid;
	}
	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}
	public String getTechnologyid() {
		return technologyid;
	}
	public void setTechnologyid(String technologyid) {
		this.technologyid = technologyid;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTechnologyname() {
		return technologyname;
	}
	public void setTechnologyname(String technologyname) {
		this.technologyname = technologyname;
	}
	@Override
	public String toString() {
		return "CourseContentsDetailVO [ctid=" + ctid + ", topicname=" + topicname + ", topicid=" + topicid
				+ ", technologyid=" + technologyid + ", course=" + course + ", description=" + description + ", doe="
				+ doe + ", dom=" + dom + ", userid=" + userid + ", technologyname=" + technologyname + "]";
	}
	
	
}
