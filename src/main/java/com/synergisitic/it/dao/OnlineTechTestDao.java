package com.synergisitic.it.dao;

import java.util.List;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.UserExamDetailStatus;
import com.synergisitic.it.model.UserExamProgressData;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.model.UserTechTestDetailEntity;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.QuestionsForm;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;


/**
 * 
 * @author nagendra.yadav
 * This is contract for online tech test
 *
 */
public interface OnlineTechTestDao {
	
	public abstract List<AvailableTest> findAllAvailableTest();
	
	public abstract List<AvailableTest> findAllAvailableTestByUserId(String userid);
	
	public abstract AvailableTest fetchAllQuestionsByTestName(String testName,String techName,String userId,String userSessionId,boolean isTestResume);
	
	public QuestionAndAnsTestDataVO fetchNextQuestionAnswer(String questionId,String userid,String testName,String techName,String userSessionId); 
		
	
	public UserOnlineExamStatus submitTechAnswerForQuestion(
			UserExamDetailStatus userExamDetailStatus,boolean isTestDone) ;
	
	public UserOnlineExamStatus genarateSummaryForTest(UserExamDetailStatus userExamDetailStatus);
	
	public List<AssignedTestUser>  findAssignedTestByUserId(String userId);
	
	public AssignedTestUser findAssignedTestByURL(String link);
	
	public String pushProgressDataForUser(UserExamProgressData userExamProgressData);

	public int findNoOfAttemptsForCurrentTest(String testName,String techName,String userid);
	
	public String findEmailIdByUserId(String userid) ;
	
	public UserExamDetailStatus findExamDetail(String userid, String testName,String techName, String userSessionId, String QuestionId);
	
	public void addAssignedTest(AssignedTestUser assignedTest);
	
	public void assignedTestToUsers(List<AssignedTestUser> assignedTestUsersList);
	
	public List<com.synergisitic.it.model.Questions> getQuestionsbyTech(String getSelectParam,int page);
	
	public int getNoofRecords();

	public  List<Questions> deleteQues(String qId);

	public List<Questions> findAllQuestions();

	public String findEmailIdByConsultantId(String consultantId);

	public String findUserTechSessionId(String userid, String techName, String testName);

	public List<UserTechTestDetailEntity> findTestsByTechName(String techName);

	public	List<AvailableTest> findAllAvailableTestByUserIdAndTechName(String userid, String techName);

	public  UserOnlineExamStatus sendCompleteTestEmailDao(UserExamDetailStatus userExamDetailStatus);

	public TechnologyEntity findTechnologyEntityByTechName(String tname);

	public List<TrainingSessionsDetailEntity> findTrainingSessionDetailByUserid(String userid, String techId);

	public String findTestByUseridTechTestName(String userid, String techName, String testName);

	public List<String> findTechListByUserid(String userid);

	public String unassignedTestToUser(String userid, String techName, String testName);

	public	AvailableTest findAvailableTestTechTestName(String techName, String testName);

	public List<AvailableTest> findAllAvailableTestByTechName(String techName);

	public Questions findQuestionSetByQuestionId(String questionId);

	public List<AssignedTestUser> findAssignedTestsToGroupName(String groupName);

	public abstract List<UserExamDetailStatus> findTestTechDetailSummary(
			String testName, String techName, String userId,
			String userSessionId);

	public List<QuestionAndAnsTestDataVO> findQuestionsAnswersByTechTest(
			String techName, String testName);

	public List<AssignedTestUser> findAllAssignedTests(String groupName);

	public String updateAssignedTestStatus(String groupName, String techName, String testName,String cstatus);

	List<AssignedTestUser> findAssignedTestByGroup(String groupName);

}
