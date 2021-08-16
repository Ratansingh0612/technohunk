package com.techquiz.trainer.web.controller.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nagendra
 * @since 06-04-2018
 */
public class TrainerDailySessionReport {
	private String name;
	private String email;
	private String empid;
	private String technology;
	private String startTime;
	private String endTime;
	private String sessionDuration;
	private String topicCovered;
	private String batchName;
	List<ConsultantsVO> consultantList = new ArrayList<ConsultantsVO>();
	
	/**
	 * @return the batchName
	 */
	public String getBatchName() {
		return batchName;
	}

	/**
	 * @param batchName the batchName to set
	 */
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSessionDuration() {
		return sessionDuration;
	}

	public void setSessionDuration(String sessionDuration) {
		this.sessionDuration = sessionDuration;
	}

	public String getTopicCovered() {
		return topicCovered;
	}

	public void setTopicCovered(String topicCovered) {
		this.topicCovered = topicCovered;
	}

	public List<ConsultantsVO> getConsultantList() {
		return consultantList;
	}

	public void setConsultantList(List<ConsultantsVO> consultantList) {
		this.consultantList = consultantList;
	}

	@Override
	public String toString() {
		return "TrainerDailySessionReport [name=" + name + ", email=" + email + ", empid=" + empid + ", technology="
				+ technology + ", startTime=" + startTime + ", endTime=" + endTime + ", sessionDuration="
				+ sessionDuration + ", topicCovered=" + topicCovered + ", consultantList=" + consultantList + "]";
	}

}
