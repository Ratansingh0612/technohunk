package com.synergisitic.it.web.form;

import java.util.Date;

/**
 * 
 * @author nagendra.yadav
 * This is pojo which will be used to carry data from view to model
 */

public class QuestionAndAnswers {
	
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
	
	//for storing answer text from UI.
	private String answerText1;
	private String answerText2;
	private String answerText3;
	private String answerText4;
	private String answerText5;
	private String answerText6;
	private String answerText7;
	
	private String correct1;
	private String correct2;
	private String correct3;
	private String correct4;
	private String correct5;
	private String correct6;
	private String correct7;
	
	private String correct;
	
	private Date dateOfEntry;
	private Date lastModifyOn;
	private String description;
	private String lastModifyBy;
	private String correctAnsDescription;
	
	private String questionOwner;
	private String qbankName;
	private String  topicName;

	/**
	 * @return the topicName
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * @param topicName the topicName to set
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

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

	private String topic;
	
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getCorrectAnsDescription() {
		return correctAnsDescription;
	}

	public void setCorrectAnsDescription(String correctAnsDescription) {
		this.correctAnsDescription = correctAnsDescription;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
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

	public String getAnswerText1() {
		return answerText1;
	}

	public void setAnswerText1(String answerText1) {
		this.answerText1 = answerText1;
	}

	public String getAnswerText2() {
		return answerText2;
	}

	public void setAnswerText2(String answerText2) {
		this.answerText2 = answerText2;
	}

	public String getAnswerText3() {
		return answerText3;
	}

	public void setAnswerText3(String answerText3) {
		this.answerText3 = answerText3;
	}

	public String getAnswerText4() {
		return answerText4;
	}

	public void setAnswerText4(String answerText4) {
		this.answerText4 = answerText4;
	}

	public String getAnswerText5() {
		return answerText5;
	}

	public void setAnswerText5(String answerText5) {
		this.answerText5 = answerText5;
	}

	public String getAnswerText6() {
		return answerText6;
	}

	public void setAnswerText6(String answerText6) {
		this.answerText6 = answerText6;
	}
	
	

	public String getCorrect1() {
		return correct1;
	}

	public void setCorrect1(String correct1) {
		this.correct1 = correct1;
	}

	public String getCorrect2() {
		return correct2;
	}

	public void setCorrect2(String correct2) {
		this.correct2 = correct2;
	}

	public String getCorrect3() {
		return correct3;
	}

	public void setCorrect3(String correct3) {
		this.correct3 = correct3;
	}

	public String getCorrect4() {
		return correct4;
	}

	public void setCorrect4(String correct4) {
		this.correct4 = correct4;
	}

	public String getCorrect5() {
		return correct5;
	}

	public void setCorrect5(String correct5) {
		this.correct5 = correct5;
	}

	public String getCorrect6() {
		return correct6;
	}

	public void setCorrect6(String correct6) {
		this.correct6 = correct6;
	}

	
	public String getAnswerText7() {
		return answerText7;
	}

	public void setAnswerText7(String answerText7) {
		this.answerText7 = answerText7;
	}

	public String getCorrect7() {
		return correct7;
	}

	public void setCorrect7(String correct7) {
		this.correct7 = correct7;
	}

	@Override
	public String toString() {
		return "QuestionAndAnswers [id=" + id + ", questionId=" + questionId + ", questionText=" + questionText
				+ ", category=" + category + ", technology=" + technology + ", questionType=" + questionType
				+ ", marks=" + marks + ", questionComplexity=" + questionComplexity + ", choiceType=" + choiceType
				+ ", numberOfAnswers=" + numberOfAnswers + ", answerText1=" + answerText1 + ", answerText2="
				+ answerText2 + ", answerText3=" + answerText3 + ", answerText4=" + answerText4 + ", answerText5="
				+ answerText5 + ", answerText6=" + answerText6 + ", answerText7=" + answerText7 + ", correct1="
				+ correct1 + ", correct2=" + correct2 + ", correct3=" + correct3 + ", correct4=" + correct4
				+ ", correct5=" + correct5 + ", correct6=" + correct6 + ", correct7=" + correct7 + ", correct="
				+ correct + ", dateOfEntry=" + dateOfEntry + ", lastModifyOn=" + lastModifyOn + ", description="
				+ description + ", lastModifyBy=" + lastModifyBy + ", correctAnsDescription=" + correctAnsDescription
				+ ", questionOwner=" + questionOwner + ", qbankName=" + qbankName + ", topic=" + topic + "]";
	}

	

}
