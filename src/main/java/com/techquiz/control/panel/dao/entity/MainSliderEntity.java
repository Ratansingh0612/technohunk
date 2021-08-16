package com.techquiz.control.panel.dao.entity;

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
@Table(name="cp_mainslider_tbl")
public class MainSliderEntity {
	private int lpid;
	private String mainHeading;
	private String subHeading;
	private String icon;
	private String sliderImage;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;

	@Id
	@GeneratedValue
	public int getLpid() {
		return lpid;
	}

	public void setLpid(int lpid) {
		this.lpid = lpid;
	}

	@Column(length=100)
	public String getMainHeading() {
		return mainHeading;
	}

	public void setMainHeading(String mainHeading) {
		this.mainHeading = mainHeading;
	}

	@Column(length=100)
	public String getSubHeading() {
		return subHeading;
	}

	public void setSubHeading(String subHeading) {
		this.subHeading = subHeading;
	}

	@Column(length=100)
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(length=100)
	public String getSliderImage() {
		return sliderImage;
	}

	public void setSliderImage(String sliderImage) {
		this.sliderImage = sliderImage;
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

	@Column(length=100)
	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "MainSliderVO [lpid=" + lpid + ", mainHeading=" + mainHeading + ", subHeading=" + subHeading + ", icon="
				+ icon + ", sliderImage=" + sliderImage + ", doe=" + doe + ", dom=" + dom + ", userid=" + userid + "]";
	}

}
