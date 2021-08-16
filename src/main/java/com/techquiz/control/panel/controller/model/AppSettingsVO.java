package com.techquiz.control.panel.controller.model;

/**
 * 
 * @author Nagendra
 *
 */
public class AppSettingsVO {

	private int iid;
	private String allowGuestMultipleTest;
	private int defaultGuestTestDuration;
	private int guestTextExpireTimeInHrs;
	private String comment;

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getAllowGuestMultipleTest() {
		return allowGuestMultipleTest;
	}

	public void setAllowGuestMultipleTest(String allowGuestMultipleTest) {
		this.allowGuestMultipleTest = allowGuestMultipleTest;
	}

	public int getDefaultGuestTestDuration() {
		return defaultGuestTestDuration;
	}

	public void setDefaultGuestTestDuration(int defaultGuestTestDuration) {
		this.defaultGuestTestDuration = defaultGuestTestDuration;
	}
	
	

	public int getGuestTextExpireTimeInHrs() {
		return guestTextExpireTimeInHrs;
	}

	public void setGuestTextExpireTimeInHrs(int guestTextExpireTimeInHrs) {
		this.guestTextExpireTimeInHrs = guestTextExpireTimeInHrs;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "AppSettingsVO [iid=" + iid + ", allowGuestMultipleTest=" + allowGuestMultipleTest
				+ ", defaultGuestTestDuration=" + defaultGuestTestDuration + ", guestTextExpireTimeInHrs="
				+ guestTextExpireTimeInHrs + ", comment=" + comment + "]";
	}




}
