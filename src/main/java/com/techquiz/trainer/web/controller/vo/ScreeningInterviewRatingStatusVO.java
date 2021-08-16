package com.techquiz.trainer.web.controller.vo;

import java.util.List;

public class ScreeningInterviewRatingStatusVO {
	private String technology;
	private String crating;
	private String comment;
	private String totalRating;
	private String techlogo;
	private String interviewerName;
	private List<ConsultantScreeningInterviewHistoryVO> consultantScreeningInterviewHistoryVOs;
	
	
	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getTechlogo() {
		return techlogo;
	}

	public void setTechlogo(String techlogo) {
		this.techlogo = techlogo;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getCrating() {
		return crating;
	}

	public void setCrating(String crating) {
		this.crating = crating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(String totalRating) {
		this.totalRating = totalRating;
	}

	public List<ConsultantScreeningInterviewHistoryVO> getConsultantScreeningInterviewHistoryVOs() {
		return consultantScreeningInterviewHistoryVOs;
	}

	public void setConsultantScreeningInterviewHistoryVOs(
			List<ConsultantScreeningInterviewHistoryVO> consultantScreeningInterviewHistoryVOs) {
		this.consultantScreeningInterviewHistoryVOs = consultantScreeningInterviewHistoryVOs;
	}

	@Override
	public String toString() {
		return "ScreeningInterviewRatingStatusVO [technology=" + technology
				+ ", crating=" + crating + ", comment=" + comment
				+ ", totalRating=" + totalRating + ", techlogo=" + techlogo
				+ ", interviewerName=" + interviewerName
				+ ", consultantScreeningInterviewHistoryVOs="
				+ consultantScreeningInterviewHistoryVOs + "]";
	}
}
