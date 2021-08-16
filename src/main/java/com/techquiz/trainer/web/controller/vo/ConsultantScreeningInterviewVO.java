package com.techquiz.trainer.web.controller.vo;

import java.sql.Timestamp;

public class ConsultantScreeningInterviewVO {
	private String empid;
	private String consultantId;
	private Timestamp dateOfInterview;
	private String interviewId;
	private String interviewerUserid;
	

	public String getInterviewerUserid() {
		return interviewerUserid;
	}

	public void setInterviewerUserid(String interviewerUserid) {
		this.interviewerUserid = interviewerUserid;
	}

	public String getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(String interviewId) {
		this.interviewId = interviewId;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	public Timestamp getDateOfInterview() {
		return dateOfInterview;
	}

	public void setDateOfInterview(Timestamp dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((interviewId == null) ? 0 : interviewId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultantScreeningInterviewVO other = (ConsultantScreeningInterviewVO) obj;
		if (interviewId == null) {
			if (other.interviewId != null)
				return false;
		} else if (!interviewId.equals(other.interviewId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConsultantScreeningInterviewVO [empid=" + empid
				+ ", consultantId=" + consultantId + ", dateOfInterview="
				+ dateOfInterview + ", interviewId=" + interviewId
				+ ", interviewerUserid=" + interviewerUserid + "]";
	}

}
