package com.techquiz.trainer.web.controller.vo;

import java.sql.Timestamp;

/**
 * 
 * @author Nagendra
 * @since 11-04-2018
 *
 */
public class TrainerSessionVO {
	private int tsid;
	private int techid;
	private String technology;
	private String trainer;
	private String tcolor;
	private String fcolor;
	private String mcolor;
	private String scolor;
	private String firsthalf;
	private String middlehalf;
	private String secondhalf;
	private String batch;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;
	
	public String getTcolor() {
		return tcolor;
	}

	public void setTcolor(String tcolor) {
		this.tcolor = tcolor;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getFcolor() {
		return fcolor;
	}

	public void setFcolor(String fcolor) {
		this.fcolor = fcolor;
	}

	public String getMcolor() {
		return mcolor;
	}

	public void setMcolor(String mcolor) {
		this.mcolor = mcolor;
	}

	public String getScolor() {
		return scolor;
	}

	public void setScolor(String scolor) {
		this.scolor = scolor;
	}

	public int getTsid() {
		return tsid;
	}

	public void setTsid(int tsid) {
		this.tsid = tsid;
	}

	public int getTechid() {
		return techid;
	}

	public void setTechid(int techid) {
		this.techid = techid;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getFirsthalf() {
		return firsthalf;
	}

	public void setFirsthalf(String firsthalf) {
		this.firsthalf = firsthalf;
	}

	public String getMiddlehalf() {
		return middlehalf;
	}

	public void setMiddlehalf(String middlehalf) {
		this.middlehalf = middlehalf;
	}

	public String getSecondhalf() {
		return secondhalf;
	}

	public void setSecondhalf(String secondhalf) {
		this.secondhalf = secondhalf;
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

	@Override
	public String toString() {
		return "TrainerSessionEntity [tsid=" + tsid + ", techid=" + techid + ", trainer=" + trainer + ", firsthalf="
				+ firsthalf + ", middlehalf=" + middlehalf + ", secondhalf=" + secondhalf + ", batch=" + batch
				+ ", doe=" + doe + ", dom=" + dom + ", userid=" + userid + "]";
	}

}
