package com.synergisitic.it.web.form;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class AvailableQuestionsBankForm {

	private String questionBankName;
	private String totalQuestions;
	private String imagePath;
	private String questionOwner;
	private String description;
	private String doe;
	
	
	public String getDoe() {
		return doe;
	}

	public void setDoe(String doe) {
		this.doe = doe;
	}
private String  qbankName;
	
	
	public String getQbankName() {
		return qbankName;
	}

	public void setQbankName(String qbankName) {
		this.qbankName = qbankName;
	}

	public String getQuestionBankName() {
		return questionBankName;
	}

	public void setQuestionBankName(String questionBankName) {
		this.questionBankName = questionBankName;
	}

	public String getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(String totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getQuestionOwner() {
		return questionOwner;
	}

	public void setQuestionOwner(String questionOwner) {
		this.questionOwner = questionOwner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AvailableQuestionsBankForm [questionBankName=" + questionBankName + ", totalQuestions=" + totalQuestions
				+ ", imagePath=" + imagePath + ", questionOwner=" + questionOwner + ", description=" + description
				+ ", doe=" + doe + ", qbankName=" + qbankName + "]";
	}

	

}
