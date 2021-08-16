package com.techquiz.control.panel.controller.model;

import java.sql.Timestamp;

/**
 * 
 * @author Nagendra
 *
 */
public class MainSliderVO {
	private int lpid;
	private String mainHeading;
	private String subHeading;
	private String icon;
	private byte[] picon;
	private String sliderImage;
	private byte[] psliderImage;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;

	public byte[] getPicon() {
		return picon;
	}

	public void setPicon(byte[] picon) {
		this.picon = picon;
	}

	public byte[] getPsliderImage() {
		return psliderImage;
	}

	public void setPsliderImage(byte[] psliderImage) {
		this.psliderImage = psliderImage;
	}

	public int getLpid() {
		return lpid;
	}

	public void setLpid(int lpid) {
		this.lpid = lpid;
	}

	public String getMainHeading() {
		return mainHeading;
	}

	public void setMainHeading(String mainHeading) {
		this.mainHeading = mainHeading;
	}

	public String getSubHeading() {
		return subHeading;
	}

	public void setSubHeading(String subHeading) {
		this.subHeading = subHeading;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

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

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "MainSliderVO [lpid=" + lpid + ", mainHeading=" + mainHeading + ", subHeading=" + subHeading + ", icon="
				+ icon + ", sliderImage=" + sliderImage + ", doe=" + doe + ", dom=" + dom + ", userid=" + userid + "]";
	}

}
