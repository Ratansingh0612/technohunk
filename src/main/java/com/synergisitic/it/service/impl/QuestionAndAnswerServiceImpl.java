/**
 *
 * Copyright (c) 2012 SYNERGISITICIT.  All rights reserved.
 *  
 * This software and all information contained therein is confidential and 
 * proprietary and shall not be duplicated, used, disclosed or disseminated 
 * in any way except as authorized by the applicable license agreement, 
 * without the express written permission of SYNERGISITICIT. All authorized reproductions 
 * must be marked with this language.  
 *
 * EXCEPT AS SET FORTH IN THE APPLICABLE LICENSE AGREEMENT, TO THE EXTENT 
 * PERMITTED BY APPLICABLE LAW, SYNERGISITICIT PROVIDES THIS SOFTWARE WITHOUT 
 * WARRANTY OF ANY KIND, INCLUDING WITHOUT LIMITATION, ANY IMPLIED 
 * WARRANTIES OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE.  IN 
 * NO EVENT WILL SYNERGISITICIT BE LIABLE TO THE END USER OR ANY THIRD PARTY FOR ANY 
 * LOSS OR DAMAGE, DIRECT OR INDIRECT, FROM THE USE OF THIS SOFTWARE, 
 * INCLUDING WITHOUT LIMITATION, LOST PROFITS, BUSINESS INTERRUPTION, 
 * GOODWILL, OR LOST DATA, EVEN IF SYNERGISITICIT IS EXPRESSLY ADVISED OF SUCH LOSS OR 
 * DAMAGE.
 *
 */
package com.synergisitic.it.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.QuestionAndAnswerDao;
import com.synergisitic.it.model.Answers;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.service.QuestionAndAnswerService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.QuestionAndAnswers;

/**
 * 
 * @author nagendra.yadav
 * 
 * This is service  implementation for handling all the operation for
 * CRUD operation.
 */

@Service("QuestionAndAnswerServiceImpl")
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {
	
	@Autowired
	@Qualifier("QuestionAndAnswerDaoImpl")
	private QuestionAndAnswerDao questionAndAnswerDao;
	
	/**
	 * 
	 * @param questions
	 * @return success when question is persisted successfully
	 */
	@Override
	public String addQuestion(Questions questions){
		questionAndAnswerDao.addQuestion(questions);
		return ApplicationContant.SUCCESS;
	}


	/**
	 * 
	 * @param questionAndAnswers
	 * @return success when questionAndAnswers is persisted successfully
	 */
	@Override
	public String addQuestionAndAnswers(QuestionAndAnswers questionAndAnswers,boolean updateQBank) {
		return questionAndAnswerDao.addQuestionAndAnswers(questionAndAnswers,updateQBank);
	}

	/**
	 * 
	 * @param answers
	 * @return success when answer is persisted successfully
	 */
	@Override
	public String addAnswer(Answers answers) {
		return questionAndAnswerDao.addAnswer(answers);
	}


	@Override
	public void updateQues(String qId) {
		 questionAndAnswerDao.updateQues(qId);
		
	}


	@Override
	public String updateQuestionAndAnswers(QuestionAndAnswers questionAndAnswers) {
		return questionAndAnswerDao.updateQuestionAndAnswers(questionAndAnswers);
	}

}
