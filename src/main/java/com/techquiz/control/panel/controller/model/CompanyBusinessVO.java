package com.techquiz.control.panel.controller.model;

import java.sql.Timestamp;

/**
 * 
 * @author Nagendra
 *
 */

public class CompanyBusinessVO {
	private int cbid;
	private String image;
	private byte[] pimage;
	private String mainHeading;
	private String text;
	private String url;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;
	
	public byte[] getPimage() {
		return pimage;
	}
	public void setPimage(byte[] pimage) {
		this.pimage = pimage;
	}
	public int getCbid() {
		return cbid;
	}
	public void setCbid(int cbid) {
		this.cbid = cbid;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getMainHeading() {
		return mainHeading;
	}
	public void setMainHeading(String mainHeading) {
		this.mainHeading = mainHeading;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
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
		return "CompanyBusinessVO [cbid=" + cbid + ", image=" + image + ", mainHeading=" + mainHeading + ", text="
				+ text + ", url=" + url + ", doe=" + doe + ", dom=" + dom + ", userid=" + userid + "]";
	}
}
