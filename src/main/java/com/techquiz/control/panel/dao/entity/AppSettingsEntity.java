package com.techquiz.control.panel.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Nagendra
 *
 */
@Entity
@Table(name = "app_settings_tbl")
public class AppSettingsEntity {

	private int iid;
	private String allowGuestMultipleTest;
	private int defaultGuestTestDuration;
	private int guestTextExpireTimeInHrs;
	private String comment;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	@Column(length=3)
	public String getAllowGuestMultipleTest() {
		return allowGuestMultipleTest;
	}

	public void setAllowGuestMultipleTest(String allowGuestMultipleTest) {
		this.allowGuestMultipleTest = allowGuestMultipleTest;
	}

	@Column(length=3)
	public int getDefaultGuestTestDuration() {
		return defaultGuestTestDuration;
	}

	public void setDefaultGuestTestDuration(int defaultGuestTestDuration) {
		this.defaultGuestTestDuration = defaultGuestTestDuration;
	}

	@Column(length=100)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	@Column(length=3)
	public int getGuestTextExpireTimeInHrs() {
		return guestTextExpireTimeInHrs;
	}

	public void setGuestTextExpireTimeInHrs(int guestTextExpireTimeInHrs) {
		this.guestTextExpireTimeInHrs = guestTextExpireTimeInHrs;
	}

	@Override
	public String toString() {
		return "AppSettingsEntity [iid=" + iid + ", allowGuestMultipleTest=" + allowGuestMultipleTest
				+ ", defaultGuestTestDuration=" + defaultGuestTestDuration + ", comment=" + comment + "]";
	}

}
