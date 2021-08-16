package com.techquiz.trainer.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Nagendra
 *
 */
@Entity
@Table(name = "trainer_sessions_tbl")
public class TrainerSessionEntity {
	private int tsid;
	private int techid;
	private String trainer;
	private String firsthalf;
	private String middlehalf;
	private String secondhalf;
	private String batch;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;

	@Id
	@GeneratedValue
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

	@Column(length=100)
	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	@Column(length=3)
	public String getFirsthalf() {
		return firsthalf;
	}

	public void setFirsthalf(String firsthalf) {
		this.firsthalf = firsthalf;
	}

	@Column(length=3)
	public String getMiddlehalf() {
		return middlehalf;
	}

	public void setMiddlehalf(String middlehalf) {
		this.middlehalf = middlehalf;
	}

	@Column(length=3)
	public String getSecondhalf() {
		return secondhalf;
	}

	public void setSecondhalf(String secondhalf) {
		this.secondhalf = secondhalf;
	}

	@Column(length=30)
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

	@Column(length=100)
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
