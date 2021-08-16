package com.synergisitic.it.report.model;

public class CourseCoveredStatusVO {

	private String technology;
	private String topicCovered;
	private String topicRemaining;
	private String courseStatus;
	private String comment;

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getTopicCovered() {
		return topicCovered;
	}

	public void setTopicCovered(String topicCovered) {
		this.topicCovered = topicCovered;
	}

	public String getTopicRemaining() {
		return topicRemaining;
	}

	public void setTopicRemaining(String topicRemaining) {
		this.topicRemaining = topicRemaining;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "CourseCoveredStatusVO [technology=" + technology
				+ ", topicCovered=" + topicCovered + ", topicRemaining="
				+ topicRemaining + ", courseStatus=" + courseStatus
				+ ", comment=" + comment + "]";
	}

}
