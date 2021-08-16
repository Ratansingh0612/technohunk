package com.synergisitic.it.dao;

import com.techquiz.info.jdbc.dao.entity.QuestionsBankEntity;

/**
 * 
 * @author Nagendra
 *
 */
public interface QuestionBankDao {

	public String addQuestionBank(QuestionsBankEntity questionsBankEntity);
	public String checkQuestionBankTechName(String techName, String qbname);

}
