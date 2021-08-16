package com.techquiz.trainer.web.controller.vo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.techquiz.programys.common.convertor.CustomTimestampSerializer;

public class TrainingSessionsDetailVO {
	private long sid;
	private String technology;
	private String topics;
	private Time starttime;
	private Time endtime;
	private Date sessiondate;
	private String timeduration;
	private String batch;
	private String pempids;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;
	private String trainer;
	private String comments;
	private String name;
	private String techName;
	private int totalDuration;
	private String color;
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}	

		public int getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonSerialize(using=CustomTimestampSerializer.class)
	public Date getSessiondate() {
		return sessiondate;
	}

	public void setSessiondate(Date sessiondate) {
		this.sessiondate = sessiondate;
	}

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

	public String getTimeduration() {
		return timeduration;
	}

	public void setTimeduration(String timeduration) {
		this.timeduration = timeduration;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getPempids() {
		return pempids;
	}

	public void setPempids(String pempids) {
		this.pempids = pempids;
	}

	@JsonSerialize(using=CustomTimestampSerializer.class)
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TrainingSessionsDetailVO [sid=" + sid + ", technology="
				+ technology + ", topics=" + topics + ", starttime="
				+ starttime + ", endtime=" + endtime + ", sessiondate="
				+ sessiondate + ", timeduration=" + timeduration + ", batch="
				+ batch + ", pempids=" + pempids + ", doe=" + doe + ", dom="
				+ dom + ", userid=" + userid + ", trainer=" + trainer
				+ ", comments=" + comments + ", name=" + name + ", techName="
				+ techName + ", color=" + color + "]";
}
}
