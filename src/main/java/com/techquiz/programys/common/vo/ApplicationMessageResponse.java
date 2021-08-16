package com.techquiz.programys.common.vo;

public class ApplicationMessageResponse {
	private String status;
	private String message;
	private String cmessage;
	private String errorCode;
	private String errorDescription;

	public String getCmessage() {
		return cmessage;
	}

	public void setCmessage(String cmessage) {
		this.cmessage = cmessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	@Override
	public String toString() {
		return "ApplicationMessageResponse [status=" + status + ", message="
				+ message + ", errorCode=" + errorCode + ", errorDescription="
				+ errorDescription + "]";
	}

}
