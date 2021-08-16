package com.synergisitic.it.service;

import java.util.List;

import com.synergisitic.it.model.Questions;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.techquiz.trainer.web.controller.BatchVO;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface UserAdminCommonService {

	public List<QuestionsForm> findAllQuestionByTechAndUser(String technology,String userid);

	public List<QuestionsForm> findAllQuestionByTechAndUser(String technology);
	
	public List<QuestionsForm> findAllQuestionByQuestionIds(
			String[] selectedQuestionIds) ;

	public TestConfiguration findAvailableTestByTestName(String testName);

	public List<String> findAvailableTestByTechName(String techName);
	
	public boolean isTechTestAssignedToGroup(String techName, String testName, String groupName);
	
	public boolean isTechTestAssignedToConsultant(String techName, String testName, String userid);
	
	public String checkConsultantId(String consultantid);

	public String checkBatchName(String batch);

	public String addBatch(BatchVO batchVO);

	public List<String> findQuestionBankByTechName(String techName);

	public String deleteTestByTechName(String techName,String testName);
	
	public List<String> findTopicsByTechName(String techName);

	public String deleteTestByTechNameandTestName(String techName, String testName);

	public String findTechImageByTechName(String techName);

/*	public List<QuestionsForm> findAllQuestionInByBankAndUserId(String qbankName, String userid);*/

	public 	List<QuestionsForm> findAllQuestionInByBankTechAndUserId(String qbankName, String userid, String techName);

	public List<BatchVO> findBatches();

	public BatchVO findBatchByBatchName(String batch);

	public String deleteQuestionFromBankByTech(String questionid);
	

}
