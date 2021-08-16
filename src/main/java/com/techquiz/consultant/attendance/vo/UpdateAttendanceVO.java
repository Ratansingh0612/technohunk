package com.techquiz.consultant.attendance.vo;

import java.util.List;

public class UpdateAttendanceVO {

	private List<String> absentStudentRollList;
	private String period;
	private String topicDescription;
	private String doc;
	private String doe;

	public List<String> getAbsentStudentRollList() {
		return absentStudentRollList;
	}

	public void setAbsentStudentRollList(List<String> absentStudentRollList) {
		this.absentStudentRollList = absentStudentRollList;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getDoe() {
		return doe;
	}

	public void setDoe(String doe) {
		this.doe = doe;
	}

	@Override
	public String toString() {
		return "UpdateAttendanceVO [absentStudentRollList="
				+ absentStudentRollList + ", period=" + period
				+ ", topicDescription=" + topicDescription + ", doc=" + doc
				+ ", doe=" + doe + "]";
	}

}
