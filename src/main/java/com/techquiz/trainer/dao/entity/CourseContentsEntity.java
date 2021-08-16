package com.techquiz.trainer.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course_contents_tbl")
public class CourseContentsEntity {
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
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getCtid() {
		return ctid;
	}
	
	public void setCtid(long ctid) {
		this.ctid = ctid;
	}
	@Column(length=100)
	public String getTopicname() {
		return topicname;
	}
	
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	
	@Column(length=20)
	public String getTopicid() {
		return topicid;
	}
	
	public void setTopicid(String topicid) {
		this.topicid = topicid;
	}
	
	@Column(length=10)
	public String getTechnologyid() {
		return technologyid;
	}
	
	public void setTechnologyid(String technologyid) {
		this.technologyid = technologyid;
	}
	
	@Column(length=100)
	public String getCourse() {
		return course;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	@Column(length=50)
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
	
	@Column(length=60)
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Column(length=60)
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