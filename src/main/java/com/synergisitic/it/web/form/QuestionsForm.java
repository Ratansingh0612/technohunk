package com.synergisitic.it.web.form;

import java.util.Date;


public class QuestionsForm {

	private int id;
	private String questionId;
	private String questionText;
	private String category;
	private String technology;
	private String questionType;
	private int marks;
	private String questionComplexity;
	private String choiceType;
	private int numberOfAnswers;
	private String description;
	private Date dateOfEntry;
	private Date lastModifyOn;
	private String lastModifyBy;
	private String topic;
	private String qbankName;
	private String questionOwner;
	
	
 
	public String getQbankName() {
		return qbankName;
	}

	public void setQbankName(String qbankName) {
		this.qbankName = qbankName;
	}

	public String getQuestionOwner() {
		return questionOwner;
	}

	public void setQuestionOwner(String questionOwner) {
		this.questionOwner = questionOwner;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getId() {
		return id;
	}
	
	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public Date getLastModifyOn() {
		return lastModifyOn;
	}

	public void setLastModifyOn(Date lastModifyOn) {
		this.lastModifyOn = lastModifyOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}


	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getQuestionComplexity() {
		return questionComplexity;
	}

	public void setQuestionComplexity(String questionComplexity) {
		this.questionComplexity = questionComplexity;
	}

	public String getChoiceType() {
		return choiceType;
	}

	public void setChoiceType(String choiceType) {
		this.choiceType = choiceType;
	}

	public int getNumberOfAnswers() {
		return numberOfAnswers;
	}

	public void setNumberOfAnswers(int numberOfAnswers) {
		this.numberOfAnswers = numberOfAnswers;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionsForm other = (QuestionsForm) obj;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionsForm [id=" + id + ", questionId=" + questionId + ", questionText=" + questionText
				+ ", category=" + category + ", technology=" + technology + ", questionType=" + questionType
				+ ", marks=" + marks + ", questionComplexity=" + questionComplexity + ", choiceType=" + choiceType
				+ ", numberOfAnswers=" + numberOfAnswers + ", description=" + description + ", dateOfEntry="
				+ dateOfEntry + ", lastModifyOn=" + lastModifyOn + ", lastModifyBy=" + lastModifyBy + ", topic=" + topic
				+ ", qbankName=" + qbankName + ", questionOwner=" + questionOwner + "]";
	}
	
}
