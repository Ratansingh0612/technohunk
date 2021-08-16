package com.techquiz.control.panel.controller.model;

import java.sql.Timestamp;

/**
 * 
 * @author Nagendra
 *
 */

public class LoginSliderVO {
	private int lpid;
	private String welcomeMessage;
	private String loginTitle;
	private String sliderImage;
	private byte[] psliderImage;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;

	public int getLpid() {
		return lpid;
	}

	public void setLpid(int lpid) {
		this.lpid = lpid;
	}
	

	public byte[] getPsliderImage() {
		return psliderImage;
	}

	public void setPsliderImage(byte[] psliderImage) {
		this.psliderImage = psliderImage;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	public String getLoginTitle() {
		return loginTitle;
	}

	public void setLoginTitle(String loginTitle) {
		this.loginTitle = loginTitle;
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
		return "LoginSliderVO [lpid=" + lpid + ", welcomeMessage=" + welcomeMessage + ", loginTitle=" + loginTitle
				+ ", sliderImage=" + sliderImage + ", doe=" + doe + ", dom=" + dom + ", userid=" + userid + "]";
	}

}
