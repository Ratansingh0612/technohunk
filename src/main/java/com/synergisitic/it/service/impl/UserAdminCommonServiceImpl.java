package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.UserAdminCommonDao;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.service.UserAdminCommonService;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.techquiz.programys.common.dao.entity.BatchEntity;
import com.techquiz.trainer.web.controller.BatchVO;


@Service("UserAdminCommonServiceImpl")
public class UserAdminCommonServiceImpl implements UserAdminCommonService {
	
	
	@Autowired
	@Qualifier("UserAdminCommonDaoImpl")
	UserAdminCommonDao userAdminCommonDao;
	
	@Override
	public String  deleteQuestionFromBankByTech(String questionid ) {
		return userAdminCommonDao.deleteQuestionFromBankByTech(questionid);
	}

	@Override
	public List<QuestionsForm> findAllQuestionByTechAndUser(String technology,
			String userid) {
		List<Questions> questionList=userAdminCommonDao.findAllQuestionByTechAndUser(technology, userid);
		List<QuestionsForm> qlist=new ArrayList<QuestionsForm>();
		for(com.synergisitic.it.model.Questions dquestion:questionList){
			QuestionsForm questions=new QuestionsForm();
			questions.setId(dquestion.getId());
			questions.setQuestionId(dquestion.getQuestionId());
			questions.setQuestionText(dquestion.getQuestionText());
			questions.setQuestionComplexity(dquestion.getQuestionComplexity());
			questions.setTechnology(dquestion.getTechnology());
			qlist.add(questions);
		}
		return qlist;
	}
	
	
	@Override
	public List<QuestionsForm> findAllQuestionByTechAndUser(String technology) {
		List<Questions> questionList=userAdminCommonDao.findAllQuestionByTechAndUser(technology);
		List<QuestionsForm> qlist=new ArrayList<QuestionsForm>();
		for(com.synergisitic.it.model.Questions dquestion:questionList){
			QuestionsForm questions=new QuestionsForm();
			questions.setId(dquestion.getId());
			questions.setQuestionId(dquestion.getQuestionId());
			questions.setQuestionText(dquestion.getQuestionText());
			questions.setQuestionComplexity(dquestion.getQuestionComplexity());
			questions.setTechnology(dquestion.getTechnology());
			questions.setQuestionOwner(dquestion.getQuestionOwner());
			qlist.add(questions);
		}
		return qlist;
	}
	
	
	@Override
	public List<QuestionsForm> findAllQuestionInByBankTechAndUserId(String qbankName,String userid,String techName) {
		List<Questions> questionList=userAdminCommonDao.findAllQuestionInByBankTechAndUserId(qbankName,userid,techName);
		List<QuestionsForm> qlist=new ArrayList<QuestionsForm>();
		for(com.synergisitic.it.model.Questions dquestion:questionList){
			QuestionsForm questions=new QuestionsForm();
			questions.setQbankName(qbankName);
			questions.setId(dquestion.getId());
			questions.setQuestionId(dquestion.getQuestionId());
			questions.setQuestionText(dquestion.getQuestionText());
			questions.setQuestionComplexity(dquestion.getQuestionComplexity());
			questions.setTechnology(dquestion.getTechnology());
			questions.setQuestionOwner(dquestion.getQuestionOwner());
			qlist.add(questions);
		}
		return qlist;
	}


	@Override
	public List<QuestionsForm> findAllQuestionByQuestionIds(String[] selectedQuestionIds) {
		List<Questions> questionList=userAdminCommonDao.findAllQuestionByQuestionIds(selectedQuestionIds);
		List<QuestionsForm> qlist=new ArrayList<QuestionsForm>();
		for(com.synergisitic.it.model.Questions dquestion:questionList){
			QuestionsForm questions=new QuestionsForm();
			questions.setId(dquestion.getId());
			questions.setQuestionId(dquestion.getQuestionId());
			questions.setQuestionText(dquestion.getQuestionText());
			questions.setQuestionComplexity(dquestion.getQuestionComplexity());
			questions.setQuestionOwner(dquestion.getQuestionOwner());
			questions.setTechnology(dquestion.getTechnology());
			qlist.add(questions);
		}
		return qlist;
	}
	
	@Override
	public TestConfiguration findAvailableTestByTestName(String testName){
		AvailableTest availableTest=userAdminCommonDao.findAvailableTestByTestName(testName);
		TestConfiguration testConfiguration=new TestConfiguration();
		BeanUtils.copyProperties(availableTest, testConfiguration);
		return  testConfiguration;
	}
	
	@Override
	public List<String> findAvailableTestByTechName(String techName) {
		return  userAdminCommonDao.findAvailableTestByTechName(techName);
	}

	@Override
	public List<String> findQuestionBankByTechName(String techName) {
		return  userAdminCommonDao.findQuestionBankByTechName(techName);
	}
	
	@Override
	public List<String> findTopicsByTechName(String techName) {
		return  userAdminCommonDao.findTopicsByTechName(techName);
	}

	/**
	 * 
	 */
	@Override
	public boolean isTechTestAssignedToGroup(String techName, String testName, String groupName) {
		return userAdminCommonDao.isTechTestAssignedToGroup(techName, testName, groupName);
	}
	public boolean isTechTestAssignedToConsultant(String techName, String testName, String userid){
			return userAdminCommonDao.isTechTestAssignedToConsultant(techName, testName, userid);
	}


	@Override
	public String checkConsultantId(String consultantid) {
		return userAdminCommonDao.checkConsultantId(consultantid);
	}	
	
	@Override
	public String checkBatchName(String batch){
		return userAdminCommonDao.checkBatchName(batch);
	}
	
	@Override
	public BatchVO findBatchByBatchName(String batch){
		 BatchEntity entity=userAdminCommonDao.findBatchByBatchName(batch);
		BatchVO batchVO=new BatchVO();
		BeanUtils.copyProperties(entity, batchVO);
		return batchVO;
	}
	
	@Override
	public String addBatch(BatchVO batchVO){
		BatchEntity batchEntity=new BatchEntity();
		BeanUtils.copyProperties(batchVO, batchEntity);
		String result=userAdminCommonDao.addBatch(batchEntity);
		return result;
	}
	
	@Override
	public List<BatchVO> findBatches() {
		List<BatchEntity> batchEntityList=userAdminCommonDao.findBatches();
		List<BatchVO> blist=new ArrayList<BatchVO>();
		for(BatchEntity batchEntity:batchEntityList){
			BatchVO batchVO=new BatchVO();
			BeanUtils.copyProperties(batchEntity, batchVO);
			blist.add(batchVO);
		}
		return blist;
	}


	@Override
	public String deleteTestByTechName(String techName, String testName) {
		return userAdminCommonDao.deleteTestByTechName(techName, testName);
	}
	
	@Override
	public String deleteTestByTechNameandTestName(String techName, String testName)
	{
		return userAdminCommonDao.deleteTestByTechNameandTestName(techName, testName);
	}
	
	@Override
	public String findTechImageByTechName(String techName)
	{
		return userAdminCommonDao.findTechImageByTechName(techName);
	}


	/*@Override
	public List<QuestionsForm> findAllQuestionInByBankAndUserId(String qbankName, String userid) {
		List<Questions> questionList=userAdminCommonDao.findAllQuestionInByBankAndUserId(qbankName,userid);
		List<QuestionsForm> qlist=new ArrayList<QuestionsForm>();
		for(com.synergisitic.it.model.Questions dquestion:questionList){
			QuestionsForm questions=new QuestionsForm();
			questions.setId(dquestion.getId());
			questions.setQuestionId(dquestion.getQuestionId());
			questions.setQuestionText(dquestion.getQuestionText());
			questions.setQuestionComplexity(dquestion.getQuestionComplexity());
			questions.setTechnology(dquestion.getTechnology());
			questions.setQuestionOwner(dquestion.getQuestionOwner());
			qlist.add(questions);
		}
		return qlist;
	}*/
	


}
