package com.techquiz.programys.common;

public class ApplicationRestStatusVO {

	private String status;
	private String statusCode;
	private String massage;
	private String discription;
	private String url;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "ApplicationRestStatusVO [status=" + status + ", statusCode=" + statusCode + ", massage=" + massage
				+ ", discription=" + discription + ", url=" + url + "]";
	}
	
	
}
