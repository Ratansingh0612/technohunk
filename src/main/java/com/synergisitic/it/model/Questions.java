package com.synergisitic.it.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author nagendra.yadav
 * This is pojo
 */
@Table(name = "questions_tbl")
@Entity
@NamedQuery(name="select.current.max.id.from.question",query="SELECT MAX(p.id) FROM Questions p")
public class Questions {

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

	
	@Column(length=30)
	public String getQuestionOwner() {
		return questionOwner;
	}

	public void setQuestionOwner(String questionOwner) {
		this.questionOwner = questionOwner;
	}
	
	@Column(length=50)
	public String getQbankName() {
		return qbankName;
	}

	public void setQbankName(String qbankName) {
		this.qbankName = qbankName;
	}


	private Set<AssignedQuestionAnswers> assignedQuestionAnswers;

	@OneToMany(mappedBy="questions",cascade={CascadeType.ALL})
	public Set<AssignedQuestionAnswers> getAssignedQuestionAnswers() {
		return assignedQuestionAnswers;
	}

	public void setAssignedQuestionAnswers(
			Set<AssignedQuestionAnswers> assignedQuestionAnswers) {
		this.assignedQuestionAnswers = assignedQuestionAnswers;
	}
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="hjid")
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
	

	@Column(length=40)
	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

   @Column(length=1500,nullable=false)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result
				+ ((questionText == null) ? 0 : questionText.hashCode());
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
		Questions other = (Questions) obj;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		return true;
	}
	
	
}
