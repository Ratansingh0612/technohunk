package com.synergisitic.it.email.service.vo;

public class EmailMessageVO {
	private String toEmail;
	private String imageContextPath;
	private String emailMessage;
	private String from;
	private String name;
	private String userSessionId;
	private String mobile;;
	private String salutation;
	private String type;
	private String jobcardimage1;
	private String jobcardimage2;
	private String jobcardimage3;
	private String jobcardimage4;
	private String jobcardimage5;
	private String jobcardimage6;
	private String suggestion;
	private String contextPath;
	
	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getUserSessionId() {
		return userSessionId;
	}

	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getJobcardimage3() {
		return jobcardimage3;
	}

	public void setJobcardimage3(String jobcardimage3) {
		this.jobcardimage3 = jobcardimage3;
	}

	public String getJobcardimage4() {
		return jobcardimage4;
	}

	public void setJobcardimage4(String jobcardimage4) {
		this.jobcardimage4 = jobcardimage4;
	}

	public String getJobcardimage5() {
		return jobcardimage5;
	}

	public void setJobcardimage5(String jobcardimage5) {
		this.jobcardimage5 = jobcardimage5;
	}

	public String getJobcardimage6() {
		return jobcardimage6;
	}

	public void setJobcardimage6(String jobcardimage6) {
		this.jobcardimage6 = jobcardimage6;
	}

	public String getJobcardimage1() {
		return jobcardimage1;
	}

	public void setJobcardimage1(String jobcardimage1) {
		this.jobcardimage1 = jobcardimage1;
	}

	public String getJobcardimage2() {
		return jobcardimage2;
	}

	public void setJobcardimage2(String jobcardimage2) {
		this.jobcardimage2 = jobcardimage2;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * @return the emailMessage
	 */
	public String getEmailMessage() {
		return emailMessage;
	}

	/**
	 * @param emailMessage
	 *            the emailMessage to set
	 */
	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation
	 *            the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the imageContextPath
	 */
	public String getImageContextPath() {
		return imageContextPath;
	}

	/**
	 * @param imageContextPath
	 *            the imageContextPath to set
	 */
	public void setImageContextPath(String imageContextPath) {
		this.imageContextPath = imageContextPath;
	}

	/**
	 * @return the toEmail
	 */
	public String getToEmail() {
		return toEmail;
	}

	/**
	 * @param toEmail
	 *            the toEmail to set
	 */
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmailMessageVO [toEmail=" + toEmail + "]";
	}

}
