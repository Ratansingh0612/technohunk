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
@Table(name="cp_loginslider_tbl")
public class LoginSliderEntity {
	private int lpid;
	private String welcomeMessage;
	private String loginTitle;
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
	

	@Column(length=200)
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@Column(length=100)
	public String getLoginTitle() {
		return loginTitle;
	}

	public void setLoginTitle(String loginTitle) {
		this.loginTitle = loginTitle;
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
		return "LoginSliderEntity [lpid=" + lpid + ", welcomeMessage=" + welcomeMessage + ", loginTitle=" + loginTitle
				+ ", sliderImage=" + sliderImage + ", doe=" + doe + ", dom=" + dom + ", userid=" + userid + "]";
	}

}
