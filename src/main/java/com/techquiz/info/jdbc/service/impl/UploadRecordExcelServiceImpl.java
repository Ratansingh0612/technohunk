package com.techquiz.info.jdbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.UserAdminCommonDao;
import com.synergisitic.it.dao.impl.QuestionAndAnswerDaoImpl;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.web.form.QuestionsForm;
import com.techquiz.info.jdbc.dao.UploadRecordExcelDao;
import com.techquiz.info.jdbc.dao.entity.QuestionsBankEntity;
import com.techquiz.info.jdbc.service.UploadRecordExcelService;
import com.techquiz.programys.common.controller.model.QuestionsBankForm;
import com.techquiz.programys.common.vo.ExcelSheetData;


/**
 * 
 * @author Nagendra
 *
 */
@Service("UploadRecordExcelServiceImpl")
@Scope("singleton")
public class UploadRecordExcelServiceImpl implements UploadRecordExcelService {

	@Autowired
	@Qualifier("UploadRecordExcelDaoImpl")
	private UploadRecordExcelDao uploadRecordExcelDao;
	
	@Autowired
	@Qualifier("UserAdminCommonDaoImpl")
	private UserAdminCommonDao userAdminCommonDao;
	
	
	@Override
	public List<QuestionsForm> findQuestionsInBankByTech(String qbankName, String techName) {
		List<Questions> questionsList=userAdminCommonDao.findQuestionsInBankByTech(qbankName, techName);
		List<QuestionsForm>  questionsFormList=new ArrayList<QuestionsForm>();
		for(Questions question:questionsList){
			QuestionsForm questionsForm=new QuestionsForm();
			BeanUtils.copyProperties(question, questionsForm);
			questionsFormList.add(questionsForm);
		}
		return questionsFormList;
	}
	
	
	@Override
	public List<QuestionsForm> findAllQuestionInByBankTechAndUserId(String qbankName, String userid,String techName) {
		List<Questions> questionsList=userAdminCommonDao.findAllQuestionInByBankTechAndUserId(qbankName, userid,techName);
		List<QuestionsForm>  questionsFormList=new ArrayList<QuestionsForm>();
		for(Questions question:questionsList){
			QuestionsForm questionsForm=new QuestionsForm();
			BeanUtils.copyProperties(question, questionsForm);
			questionsFormList.add(questionsForm);
		}
		return questionsFormList;
	}
	
	
	@Override
	public List<QuestionsBankForm> findQuestionsBankByUserid(String userid){
		List<QuestionsBankEntity> questionsBankEntityList=uploadRecordExcelDao.findQuestionsBankByUserid(userid);
		List<QuestionsBankForm> questionsBankFormsList=new ArrayList<>();
		for(QuestionsBankEntity questionsBankEntity:questionsBankEntityList){
			QuestionsBankForm questionsBankForm=new QuestionsBankForm();
			BeanUtils.copyProperties(questionsBankEntity, questionsBankForm);
			questionsBankFormsList.add(questionsBankForm);
		}
		return questionsBankFormsList;
	}
	
	@Override
	public List<QuestionsBankForm> findAllQuestionsBank(){
		List<QuestionsBankEntity> questionsBankEntityList=uploadRecordExcelDao.findAllQuestionsBank();
		List<QuestionsBankForm> questionsBankFormsList=new ArrayList<>();
		for(QuestionsBankEntity questionsBankEntity:questionsBankEntityList){
			QuestionsBankForm questionsBankForm=new QuestionsBankForm();
			BeanUtils.copyProperties(questionsBankEntity, questionsBankForm);
			questionsBankFormsList.add(questionsBankForm);
		}
		return questionsBankFormsList;
	}
	
	@Override
	public String uploadQuestionBank(List<List<String>> rowdataList,ExcelSheetData excelSheetData){
		return uploadRecordExcelDao.uploadQuestionBank(rowdataList,excelSheetData);
	}
	
}
