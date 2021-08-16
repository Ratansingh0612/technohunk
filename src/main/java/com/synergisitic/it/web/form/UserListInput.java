package com.synergisitic.it.web.form;

/**
 * 
 * @author nagendra.yadav
 * @Since 13-Aug-2018
 *
 */
public class UserListInput {

	private String selectedGroupName;
	private String selectedTech;
	private String questionComplexity;

	public String getQuestionComplexity() {
		return questionComplexity;
	}

	public void setQuestionComplexity(String questionComplexity) {
		this.questionComplexity = questionComplexity;
	}

	public String getSelectedTech() {
		return selectedTech;
	}

	public void setSelectedTech(String selectedTech) {
		this.selectedTech = selectedTech;
	}

	public String getSelectedGroupName() {
		return selectedGroupName;
	}

	public void setSelectedGroupName(String selectedGroupName) {
		this.selectedGroupName = selectedGroupName;
	}

	@Override
	public String toString() {
		return "UserListInput [selectedGroupName=" + selectedGroupName
				+ ", selectedTech=" + selectedTech + ", questionComplexity="
				+ questionComplexity + "]";
	}

}
