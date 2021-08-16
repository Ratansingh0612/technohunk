package com.synergisitic.it.report.model;

import java.util.List;

public class OCJPReportCardWrapper {

	private List<OCJPReportCard> ocjpReportCards;
	private String userid;
	private String photo;

	public List<OCJPReportCard> getOcjpReportCards() {
		return ocjpReportCards;
	}

	public void setOcjpReportCards(List<OCJPReportCard> ocjpReportCards) {
		this.ocjpReportCards = ocjpReportCards;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "OCJPReportCardWrapper [ocjpReportCards=" + ocjpReportCards
				+ ", userid=" + userid + ", photo=" + photo + "]";
	}

}
