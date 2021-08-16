package com.synergisitic.it.service;

import java.util.List;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.UserExamDetailStatus;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.AttemptQuestionAnswerDTO;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserExamDetailStatusVO;
import com.synergisitic.it.web.form.UserExamProgressDataVO;
import com.synergisitic.it.web.form.UserTechTestDetailForm;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

/**
 * 
 * @author nagendra.yadav
 *  This is service contract for user.
 */
public interface OnlineTechTestService {
	
	public List<TestConfiguration> findAllAvailableTest() ;
	
	public AvailableTest fetchAllQuestionsByTestName(String testName,String techName,String userId,String userSessionId,boolean isTestResume) ;
	
	public QuestionAndAnsTestDataVO fetchNextQuestionAnswer(String questionId,String userid,String testName,String techName,String userSessionId) ;
	
	public UserOnlineExamStatus submitTechAnswerForQuestion(AttemptQuestionAnswerDTO attemptQuestionAnswerDTO,boolean isTestDone);
	
	public UserOnlineExamStatus genarateSummaryForTest(
			AttemptQuestionAnswerDTO attemptQuestionAnswerDTO) ;
	
	public List<AssignedTestUserForm>  findAssignedTestByUserId(String userId) ;
	
	public AssignedTestUserForm  findAssignedTestByURL(String link);
	
	public String pushProgressDataForUser(UserExamProgressDataVO userExamProgressDataVO);

	public int findNoOfAttemptsForCurrentTest(String testName,String techName, String userid);
	
	public String findEmailIdByUserId(String userid);
	
	public UserExamDetailStatus findExamDetail(String userid, String testName,String techName, String userSessionId, String QuestionId);
	
	public void addAssignedTest(AssignedTestUserForm assignedTest);
	
	public void assignedTestToUsers(List<AssignedTestUserForm> assignedTest);

	public List<QuestionsForm> getQuestionsbyTech(String getSelectparam,int page);
	
	public int getNoofRecords();

	public List<QuestionsForm> deleteQues(String qId);
	
	public List<QuestionsForm> findAllQuestions();

	public String findEmailIdByConsultantId(String consultantId);

	public String findUserTechSessionId(String userid, String techName, String testName);

	public List<UserTechTestDetailForm> findTestsByTechName(String techName);

	public List<TestConfiguration> findAllAvailableTestByUserId(String userid);

	public List<TestConfiguration> findAllAvailableTestByUserIdAndTechName(String userid, String techName);

	public UserOnlineExamStatus sendCompleteTestEmailService(AttemptQuestionAnswerDTO attemptQuestionAnswerDTO);

	public List<TrainingSessionsDetailVO> findTrainingSessionDetailsByUserId(String loginid, String techId);

	public TechnologyEntity findTechnologyEntityByTechName(String tname);

	public String findTestByUseridTechTestName(String userid, String techName, String testName);

	public List<String> findTechListByUserid(String userid);

	public String unassignedTestToUser(String userid, String techName, String testName);

	public TestConfiguration findAvailableTestTechTestName(String techName, String testName);

	public List<TestConfiguration> findAllAvailableTestByTechName(String techName);

	public QuestionsForm findQuestionSetByQuestionId(String questionId);

	public List<AssignedTestUserForm> findAssignedTestsToGroupName(String groupName);

	public List<UserExamDetailStatusVO> findTestTechDetailSummary(String testName,
			String techName, String userId, String userSessionId);

	public List<QuestionAndAnsTestDataVO> findQuestionsAnswersByTechTest(
			String techName, String testName);

	public List<AssignedTestUser> findAllAssignedTests(String groupName);

	public String updateAssignedTestStatus(String groupName, String techName, String testName, String cstatus);

	List<AssignedTestUserForm> findAssignedTestByGroup(String groupName);
}
