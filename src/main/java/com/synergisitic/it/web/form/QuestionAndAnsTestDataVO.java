package com.synergisitic.it.web.form;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author nagendra.yadav This is pojo which will be used to carry data from
 *         view to model
 */

@XmlRootElement
public class QuestionAndAnsTestDataVO implements Serializable {
	private int id;
	private String questionId;
	private String questionText;
	private String choiceType;
	// for storing answer text from UI.
	private String answerId1;
	private String answerId2;
	private String answerId3;
	private String answerId4;
	private String answerId5;
	private String answerId6;
	private String answerId7;

	private String answerText1;
	private String answerText2;
	private String answerText3;
	private String answerText4;
	private String answerText5;
	private String answerText6;
	private String answerText7;

	private String correctOption;
	private String selectedOption;

	private String description;
	
	private int noOfOptions;
	
	private String topic;
	private String technology;
	private String questionComplexity;
	private String correctAnsDescription;

	/**
	 * @return the correctAnsDescription
	 */
	public String getCorrectAnsDescription() {
		return correctAnsDescription;
	}

	/**
	 * @param correctAnsDescription the correctAnsDescription to set
	 */
	public void setCorrectAnsDescription(String correctAnsDescription) {
		this.correctAnsDescription = correctAnsDescription;
	}

	/**
	 * @return the questionComplexity
	 */
	public String getQuestionComplexity() {
		return questionComplexity;
	}

	/**
	 * @param questionComplexity the questionComplexity to set
	 */
	public void setQuestionComplexity(String questionComplexity) {
		this.questionComplexity = questionComplexity;
	}

	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getNoOfOptions() {
		return noOfOptions;
	}

	public void setNoOfOptions(int noOfOptions) {
		this.noOfOptions = noOfOptions;
	}

	public int getId() {
		return id;
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

	public String getChoiceType() {
		return choiceType;
	}

	public void setChoiceType(String choiceType) {
		this.choiceType = choiceType;
	}

	public String getAnswerId1() {
		return answerId1;
	}

	public void setAnswerId1(String answerId1) {
		this.answerId1 = answerId1;
	}

	public String getAnswerId2() {
		return answerId2;
	}

	public void setAnswerId2(String answerId2) {
		this.answerId2 = answerId2;
	}

	public String getAnswerId3() {
		return answerId3;
	}

	public void setAnswerId3(String answerId3) {
		this.answerId3 = answerId3;
	}

	public String getAnswerId4() {
		return answerId4;
	}

	public void setAnswerId4(String answerId4) {
		this.answerId4 = answerId4;
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

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}

	public String getAnswerId5() {
		return answerId5;
	}

	public void setAnswerId5(String answerId5) {
		this.answerId5 = answerId5;
	}

	public String getAnswerId6() {
		return answerId6;
	}

	public void setAnswerId6(String answerId6) {
		this.answerId6 = answerId6;
	}

	public String getAnswerId7() {
		return answerId7;
	}

	public void setAnswerId7(String answerId7) {
		this.answerId7 = answerId7;
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

	public String getAnswerText7() {
		return answerText7;
	}

	public void setAnswerText7(String answerText7) {
		this.answerText7 = answerText7;
	}

	@Override
	public String toString() {
		return "QuestionAndAnsTestDataVO [id=" + id + ", questionId="
				+ questionId + ", questionText=" + questionText
				+ ", choiceType=" + choiceType + ", answerId1=" + answerId1
				+ ", answerId2=" + answerId2 + ", answerId3=" + answerId3
				+ ", answerId4=" + answerId4 + ", answerId5=" + answerId5
				+ ", answerId6=" + answerId6 + ", answerId7=" + answerId7
				+ ", answerText1=" + answerText1 + ", answerText2="
				+ answerText2 + ", answerText3=" + answerText3
				+ ", answerText4=" + answerText4 + ", answerText5="
				+ answerText5 + ", answerText6=" + answerText6
				+ ", answerText7=" + answerText7 + ", correctOption="
				+ correctOption + ", selectedOption=" + selectedOption
				+ ", description=" + description + ", noOfOptions="
				+ noOfOptions + ", topic=" + topic + "]";
	}

}
