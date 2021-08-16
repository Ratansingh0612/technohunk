package com.techquiz.programys.common.vo;

import java.sql.Time;
import java.sql.Timestamp;

public class SessionScheduleVO {
	private long sid;
	private String technology;
	private String topics;
	private Time starttime;
	private Time endtime;
	private String batch;
	private Timestamp doe;
	private String tname;
	
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getTopics() {
		return topics;
	}
	public void setTopics(String topics) {
		this.topics = topics;
	}
	public Time getStarttime() {
		return starttime;
	}
	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}
	public Time getEndtime() {
		return endtime;
	}
	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public Timestamp getDoe() {
		return doe;
	}
	public void setDoe(Timestamp doe) {
		this.doe = doe;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "TrainingSessionScheduleVO [sid=" + sid + ", technology=" + technology + ", topics=" + topics
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", batch=" + batch + ", doe=" + doe + ", tname="
				+ tname + "]";
	}
	
	
	
	
	
	
}
