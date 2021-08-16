package com.synergisitic.it.service;

import com.synergisitic.it.model.Answers;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.web.form.QuestionAndAnswers;

/**
 * 
 * @author nagendra.yadav
 * 
 * This is service for handling all the operation for
 * CRUD operation
 */
public interface QuestionAndAnswerService {
	
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
	public String addQuestionAndAnswers(QuestionAndAnswers questionAndAnswers,boolean updateQBank);
	public void updateQues(String qId);
	public String updateQuestionAndAnswers(QuestionAndAnswers questionAndAnswers);

}
