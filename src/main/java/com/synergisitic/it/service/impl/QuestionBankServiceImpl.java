package com.synergisitic.it.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.QuestionBankDao;
import com.synergisitic.it.service.QuestionBankService;
import com.techquiz.info.jdbc.dao.entity.QuestionsBankEntity;
import com.techquiz.programys.common.controller.model.QuestionsBankForm;

@Service("QuestionBankServiceImpl")
@Scope("singleton")
public class QuestionBankServiceImpl implements  QuestionBankService {
	
	
	@Autowired
	@Qualifier("QuestionBankDaoImpl")
	private QuestionBankDao questionBankDao;
	
	@Override
	public String checkQuestionBankTechName(String techName,String qbname) {
		return questionBankDao.checkQuestionBankTechName(techName, qbname);
	}

	@Override
	public String addQuestionBank(QuestionsBankForm questionsBankForm){
		QuestionsBankEntity questionsBankEntity=new QuestionsBankEntity();
		BeanUtils.copyProperties(questionsBankForm, questionsBankEntity);
		String result=questionBankDao.addQuestionBank(questionsBankEntity);
		return result;
	}
}
