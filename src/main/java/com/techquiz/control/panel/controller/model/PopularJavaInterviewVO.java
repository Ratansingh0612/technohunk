package com.techquiz.control.panel.controller.model;

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

public class PopularJavaInterviewVO {
	private int pjiid;
	private String technology;
	private String image;
	private byte[] pimage;
	private String icon;
	private byte[] picon;
	private String text;
	private String author;
	private String url;
	private Timestamp doe;
	private Timestamp dom;
	private String userid;
	private int techid;
	
	public int getTechid() {
		return techid;
	}
	public void setTechid(int techid) {
		this.techid = techid;
	}

	public byte[] getPimage() {
		return pimage;
	}

	public void setPimage(byte[] pimage) {
		this.pimage = pimage;
	}

	public byte[] getPicon() {
		return picon;
	}

	public void setPicon(byte[] picon) {
		this.picon = picon;
	}

	public int getPjiid() {
		return pjiid;
	}

	public void setPjiid(int pjiid) {
		this.pjiid = pjiid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

	@Column(length = 100)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "PopularJavaInterviewVO [pjiid=" + pjiid + ", technology=" + technology + ", image=" + image + ", icon="
				+ icon + ", text=" + text + ", author=" + author + ", doe=" + doe + ", dom=" + dom + ", userid="
				+ userid + "]";
	}

}
