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
@Table(name="cp_company_business_info_tbl")
public class CompanyBusinessEntity {
	private int cbid;
	private String image;
	private String mainHeading;
	private String text;
	private String url;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;
	
	@Id
	@GeneratedValue
	public int getCbid() {
		return cbid;
	}
	public void setCbid(int cbid) {
		this.cbid = cbid;
	}
	
	@Column(length=100)
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Column(length=100)
	public String getMainHeading() {
		return mainHeading;
	}
	public void setMainHeading(String mainHeading) {
		this.mainHeading = mainHeading;
	}
	
	@Column(length=500)
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Column(length=200)
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
	
	@Column(length=100)
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "CompanyBusinessEntity [cbid=" + cbid + ", image=" + image + ", mainHeading=" + mainHeading + ", text="
				+ text + ", url=" + url + ", doe=" + doe + ", dom=" + dom + ", userid=" + userid + "]";
	}
}
