package com.synergisitic.it.dao;

import com.synergisitic.it.model.Answers;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.web.form.QuestionAndAnswers;

/**
 * 
 * @author nagendra.yadav
 * 
 * This is DAO for handling all the operation for
 * CRUD operation
 */
public interface QuestionAndAnswerDao {
	
	/**
	 * 
	 * @param questions
	 * @return success when question is persisted successfully
	 */
	public String addQuestion(Questions questions);
	
	/**
	 * 
	 * @param questions
	 * @return success when question is persisted successfully
	 */
	public String addAnswer(Answers answers);
	
	/**
	 * Method to add question and answer from the same page
	 * @param questionAndAnswers
	 * @return
	 */
	public String addQuestionAndAnswers(QuestionAndAnswers questionAndAnswers,boolean updateQBank);

	public void updateQues(String qId);

	public String updateQuestionAndAnswers(QuestionAndAnswers questionAndAnswers);
		

}
