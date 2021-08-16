package com.techquiz.programys.common;

import java.util.Arrays;

public class EquationsVO {
	
	private String cbid;
	private String image;
	private byte[] pimage;
	public String getCbid() {
		return cbid;
	}
	public void setCbid(String cbid) {
		this.cbid = cbid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public byte[] getPimage() {
		return pimage;
	}
	public void setPimage(byte[] pimage) {
		this.pimage = pimage;
	}
	@Override
	public String toString() {
		return "EquationsVO [cbid=" + cbid + ", image=" + image + ", pimage="
				+ Arrays.toString(pimage) + "]";
	}
	
}
