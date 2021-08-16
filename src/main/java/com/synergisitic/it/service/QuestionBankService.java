package com.synergisitic.it.service;

import com.techquiz.programys.common.controller.model.QuestionsBankForm;

/**
 * 
 * @author Nagendra
 * 
 * @since 18-Sept-2017
 */
public interface QuestionBankService {

	public String addQuestionBank(QuestionsBankForm questionsBankForm);
	public String checkQuestionBankTechName(String techName, String qbname);

}
