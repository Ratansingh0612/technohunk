package com.synergisitic.it.dao;

import java.util.List;

import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.Questions;
import com.techquiz.programys.common.dao.entity.BatchEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface UserAdminCommonDao {

	public List<Questions> findAllQuestionByTechAndUser(String technology,String userid);
	public List<Questions> findAllQuestionByTechAndUser(String technology);
	public List<Questions> findAllQuestionByQuestionIds(String[] selectedQuestionIds);
	public AvailableTest findAvailableTestByTestName(String testName);
	public List<Questions> findQuestionsInBankByTech(String qbankName, String techName);
	public List<String> findAvailableTestByTechName(String techName);
	public boolean isTechTestAssignedToGroup(String techName, String testName, String groupName);
	public boolean isTechTestAssignedToConsultant(String techName, String testName, String userid);
	public String checkConsultantId(String consultantid);
	public String checkBatchName(String batch);
	public String addBatch(BatchEntity batchEntity);
	public List<String> findQuestionBankByTechName(String techName);
	public String deleteTestByTechName(String techName, String testName);
	public List<String> findTopicsByTechName(String techName);
	public String deleteTestByTechNameandTestName(String techName, String testName);
	public String findTechImageByTechName(String techName);
	public 	List<Questions> findAllQuestionInByBankTechAndUserId(String qbankName, String userid, String techName);
	public List<BatchEntity> findBatches();
	public BatchEntity findBatchByBatchName(String batch);
	public String deleteQuestionFromBankByTech(String questionid);
}
