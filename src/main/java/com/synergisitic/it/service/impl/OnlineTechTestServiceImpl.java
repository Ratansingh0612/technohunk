package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.OnlineTechTestDao;
import com.synergisitic.it.model.AssignedTestCompositeKey;
import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.UserExamDetailStatus;
import com.synergisitic.it.model.UserExamProgressData;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.model.UserTechTestDetailEntity;
import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.AttemptQuestionAnswerDTO;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserExamDetailStatusVO;
import com.synergisitic.it.web.form.UserExamProgressDataVO;
import com.synergisitic.it.web.form.UserTechTestDetailForm;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Service("OnlineTechTestServiceImpl")
public class OnlineTechTestServiceImpl implements OnlineTechTestService {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(OnlineTechTestServiceImpl.class);

	@Autowired
	@Qualifier("OnlineTechTestDaoImpl")
	private OnlineTechTestDao onlineTechTestDao;


	@Override
	public String updateAssignedTestStatus(String groupName,String techName,String testName,String cstatus){
		return onlineTechTestDao.updateAssignedTestStatus(groupName, techName, testName,cstatus);	
	}
	
	@Override
	public List<AssignedTestUser> findAllAssignedTests(String groupName) {
		List<AssignedTestUser>  assignedTestUsersList=onlineTechTestDao.findAllAssignedTests(groupName);
		return assignedTestUsersList;
	}
	
	

	@Override
	public String findUserTechSessionId(String userid, String techName, String testName) {
		return onlineTechTestDao.findUserTechSessionId(userid, techName, testName);
	}
	
	
	@Override
	public  String findTestByUseridTechTestName(String userid,String techName,String testName) {
		   return onlineTechTestDao.findTestByUseridTechTestName(userid, techName, testName);
	}	
	
	@Override
	public List<String> findTechListByUserid(String userid) {
		return onlineTechTestDao.findTechListByUserid(userid);
	}
	
	@Override
	public  TestConfiguration findAvailableTestTechTestName(String techName,String testName) {
		AvailableTest availableTest= onlineTechTestDao.findAvailableTestTechTestName(techName,testName);
		TestConfiguration configuration=new TestConfiguration();
		BeanUtils.copyProperties(availableTest, configuration);
		return configuration;
	}

	@Override
	public List<TestConfiguration> findAllAvailableTestByUserId(String userid) {
		//AvailableTest is entity
		List<AvailableTest> availableTests = onlineTechTestDao.findAllAvailableTestByUserId(userid);
		List<TestConfiguration> testConfigurations = new ArrayList<TestConfiguration>();
		for (AvailableTest at : availableTests) {
			TestConfiguration tc = new TestConfiguration();
			BeanUtils.copyProperties(at, tc);
			testConfigurations.add(tc);
		}
		return testConfigurations;
	}
	
	@Override
	public	List<TestConfiguration>  findAllAvailableTestByUserIdAndTechName(String userid, String techName){
		//AvailableTest is entity
				List<AvailableTest> availableTests = onlineTechTestDao.findAllAvailableTestByUserIdAndTechName(userid,techName);
				List<TestConfiguration> testConfigurations = new ArrayList<TestConfiguration>();
				for (AvailableTest at : availableTests) {
					TestConfiguration tc = new TestConfiguration();
					BeanUtils.copyProperties(at, tc);
					testConfigurations.add(tc);
				}
				return testConfigurations;
	}
	
	@Override
	public List<TestConfiguration> findAllAvailableTestByTechName(String techName){
		List<AvailableTest> availableTests = onlineTechTestDao.findAllAvailableTestByTechName(techName);
		List<TestConfiguration> testConfigurations = new ArrayList<TestConfiguration>();
		for (AvailableTest at : availableTests) {
			TestConfiguration tc = new TestConfiguration();
			BeanUtils.copyProperties(at, tc);
			testConfigurations.add(tc);
		}
		return testConfigurations;
	}
	
	@Override
	public List<TrainingSessionsDetailVO> findTrainingSessionDetailsByUserId(String userid, String techId) {
		
		List<TrainingSessionsDetailEntity>  trainingSessionsDetailEntity  = onlineTechTestDao.findTrainingSessionDetailByUserid(userid,techId);
		List<TrainingSessionsDetailVO> trainingSessionsDetailVO = new ArrayList<TrainingSessionsDetailVO>();
		
		for(TrainingSessionsDetailEntity trainingSessionsDetails : trainingSessionsDetailEntity) {
			TrainingSessionsDetailVO trainingSessionsDetailsVo = new TrainingSessionsDetailVO();
			BeanUtils.copyProperties(trainingSessionsDetails, trainingSessionsDetailsVo);
			trainingSessionsDetailVO.add(trainingSessionsDetailsVo);
		}
		return trainingSessionsDetailVO;
	}
	
	@Override
	public TechnologyEntity findTechnologyEntityByTechName(String tname){
		return onlineTechTestDao.findTechnologyEntityByTechName(tname);
	}
	
	
	
	
	
	

	@Override
	public List<TestConfiguration> findAllAvailableTest() {
		List<AvailableTest> availableTests = onlineTechTestDao.findAllAvailableTest();
		List<TestConfiguration> testConfigurations = null;
		if (availableTests.size() > 0) {
			testConfigurations = new ArrayList<TestConfiguration>(availableTests.size());
		} else {
			testConfigurations = new ArrayList<TestConfiguration>(1);
		}

		for (AvailableTest at : availableTests) {
			TestConfiguration tc = new TestConfiguration();
			BeanUtils.copyProperties(at, tc);
			testConfigurations.add(tc);
		}
		return testConfigurations;
	}

	@Override
	public AvailableTest fetchAllQuestionsByTestName(String testName, String techName, String userId,
			String userSessionId, boolean isTestResume) {
		return onlineTechTestDao.fetchAllQuestionsByTestName(testName, techName, userId, userSessionId, isTestResume);
	}
	
	@Override
	public QuestionsForm findQuestionSetByQuestionId(String questionId) {
		Questions question=onlineTechTestDao.findQuestionSetByQuestionId(questionId);
		QuestionsForm questionsForm=new QuestionsForm();
		BeanUtils.copyProperties(question, questionsForm);
		return questionsForm;
	}

	@Override
	public List<QuestionAndAnsTestDataVO> findQuestionsAnswersByTechTest(String techName,String testName) {
		return onlineTechTestDao.findQuestionsAnswersByTechTest(techName, testName);
	}
	@Override
	public QuestionAndAnsTestDataVO fetchNextQuestionAnswer(String questionId, String userid, String testName,
			String techName, String userSessionId) {
		// TODO Auto-generated method stub
		return onlineTechTestDao.fetchNextQuestionAnswer(questionId, userid, testName, techName, userSessionId);
	}

	@Override
	public UserOnlineExamStatus submitTechAnswerForQuestion(AttemptQuestionAnswerDTO attemptQuestionAnswerDTO,
			boolean isTestDone) {
		// UserExamDetailStatus
		UserExamDetailStatus userExamDetailStatus = BeanUtils.instantiate(UserExamDetailStatus.class);
		BeanUtils.copyProperties(attemptQuestionAnswerDTO, userExamDetailStatus);
		UserOnlineExamStatus result = onlineTechTestDao.submitTechAnswerForQuestion(userExamDetailStatus, isTestDone);
		return result;
	}

	
	/*
	 * test details for sending an email after completing the test
	 * */
	@Override
	public UserOnlineExamStatus sendCompleteTestEmailService(AttemptQuestionAnswerDTO attemptQuestionAnswerDTO) {
		UserExamDetailStatus userExamDetailStatus = BeanUtils.instantiate(UserExamDetailStatus.class);
		BeanUtils.copyProperties(attemptQuestionAnswerDTO, userExamDetailStatus);
		UserOnlineExamStatus result = onlineTechTestDao.sendCompleteTestEmailDao(userExamDetailStatus);
		return result;
	}
	
	
	
	
	
	
	
	@Override
	public List<QuestionsForm> getQuestionsbyTech(String getSelectParam, int page) {
		List<Questions> ques = onlineTechTestDao.getQuestionsbyTech(getSelectParam, page);
		System.out.println("inside the service layer");
		List<QuestionsForm> QuestionsFormList = new ArrayList<QuestionsForm>();
		for (Questions q : ques) {
			/* System.out.println("in"); */
			QuestionsForm qform = new QuestionsForm();
			BeanUtils.copyProperties(q, qform);
			/*
			 * System.out.println("printing:"+qform.getLastModifyBy());
			 * System.out.println("text:"+qform.getQuestionText());
			 */
			QuestionsFormList.add(qform);
			/* System.out.println("out"); */
		}
		/*
		 * Iterator it = ques.iterator(); while(it.hasNext()) { Questions q =
		 * (Questions)it.next();
		 * 
		 * System.out.println("printing qujes"+q.getLastModifyBy()); }
		 */

		return QuestionsFormList;
	}

	/*
	 * public List<CategoryFrom> findAllCategory() { System.out.println(
	 * "printing the form"); List<Category>
	 * categories=technolgyCategoryDao.findAllCategory(); List<CategoryFrom>
	 * CategoryFromList=new ArrayList<CategoryFrom>(); for(Category
	 * category:categories){ CategoryFrom categoryFrom=new CategoryFrom();
	 * BeanUtils.copyProperties(category, categoryFrom);
	 * System.out.println(categoryFrom.getCatName());
	 * System.out.println(categoryFrom.getDescription());
	 * CategoryFromList.add(categoryFrom); } return CategoryFromList; }
	 */
	@Override
	public UserOnlineExamStatus genarateSummaryForTest(AttemptQuestionAnswerDTO attemptQuestionAnswerDTO) {
		UserExamDetailStatus userExamDetailStatus = BeanUtils.instantiate(UserExamDetailStatus.class);
		BeanUtils.copyProperties(attemptQuestionAnswerDTO, userExamDetailStatus);
		UserOnlineExamStatus result = onlineTechTestDao.genarateSummaryForTest(userExamDetailStatus);
		return result;
	}

	@Override
	public List<AssignedTestUserForm> findAssignedTestByUserId(String userId) {
		List<AssignedTestUser> assignedTestList = onlineTechTestDao.findAssignedTestByUserId(userId);
		if(logger.isDebugEnabled()) {
			logger.debug("Records available are: "+assignedTestList);
		}
		List<AssignedTestUserForm> testUserFormList = null;
		if (assignedTestList.size() > 0) {
			testUserFormList = new ArrayList<AssignedTestUserForm>(assignedTestList.size());
		} else {
			testUserFormList = new ArrayList<AssignedTestUserForm>(1);
		}
		
		for (AssignedTestUser assignedTestUser : assignedTestList) {
			AssignedTestUserForm assignedTestUserForm = new AssignedTestUserForm();
			// assignedTestUserForm.setId(assignedTestUser.getId());
			assignedTestUserForm.setTechName(assignedTestUser.getAssignedTestCompositeKey().getTechName());
			assignedTestUserForm.setTestName(assignedTestUser.getAssignedTestCompositeKey().getTestName());
			assignedTestUserForm.setUserId(assignedTestUser.getAssignedTestCompositeKey().getUserId());
			assignedTestUserForm.setTestExpireTimeInHrs(assignedTestUser.getTestExpireTimeInHrs());
			assignedTestUserForm.setAssignDate(assignedTestUser.getAssignDate());
			assignedTestUserForm.setTestExpireOn(assignedTestUser.getTestExpireOn());
			assignedTestUserForm.setTestStatus(assignedTestUser.getTestStatus());
			assignedTestUserForm.setDurationInMin(assignedTestUser.getDurationInMin());
			assignedTestUserForm.setNumberOfQuestions(assignedTestUser.getNumberOfQuestions());
			assignedTestUserForm.setUserSessionId(assignedTestUser.getUserSessionId());
			testUserFormList.add(assignedTestUserForm);
		}
		// BeanUtils.copyProperties(assignedTestList, testUserFormList);
		return testUserFormList;
	}

	/**
	 * 
	 */
	@Override
	public String pushProgressDataForUser(UserExamProgressDataVO userExamProgressDataVO) {
		UserExamProgressData userExamProgressData = BeanUtils.instantiate(UserExamProgressData.class);
		BeanUtils.copyProperties(userExamProgressDataVO, userExamProgressData);
		onlineTechTestDao.pushProgressDataForUser(userExamProgressData);
		return ApplicationContant.SUCCESS;
	}

	@Override
	public int findNoOfAttemptsForCurrentTest(String testName, String techName, String userid) {
		return onlineTechTestDao.findNoOfAttemptsForCurrentTest(testName, techName, userid);
	}

	@Override
	public String findEmailIdByUserId(String userid) {
		return onlineTechTestDao.findEmailIdByUserId(userid);
	}

	@Override
	public String findEmailIdByConsultantId(String consultantId) {
		return onlineTechTestDao.findEmailIdByConsultantId(consultantId);
	}

	@Override
	public UserExamDetailStatus findExamDetail(String userid, String testName, String techName, String userSessionId,
			String QuestionId) {
		return onlineTechTestDao.findExamDetail(userid, testName, techName, userSessionId, QuestionId);
	}

	@Override
	public void addAssignedTest(AssignedTestUserForm assignedTest) {
		AssignedTestUser atest = new AssignedTestUser();
		BeanUtils.copyProperties(assignedTest, atest);
		// setting composite key manually for AssignedTestUser table
		AssignedTestCompositeKey assignedTestCompositeKey = new AssignedTestCompositeKey();
		assignedTestCompositeKey.setTechName(assignedTest.getTechName());
		assignedTestCompositeKey.setTestName(assignedTest.getTestName());
		assignedTestCompositeKey.setUserId(assignedTest.getUserId());
		atest.setAssignedTestCompositeKey(assignedTestCompositeKey);
		onlineTechTestDao.addAssignedTest(atest);
	}
	
	@Override
	public String unassignedTestToUser(String userid,String techName,String testName) {
		 return onlineTechTestDao.unassignedTestToUser(userid, techName, testName);
	}
	
	@Override
	public List<AssignedTestUserForm> findAssignedTestsToGroupName(String groupName){
		List<AssignedTestUser>  assignedTestUsers=onlineTechTestDao.findAssignedTestsToGroupName(groupName);
		List<AssignedTestUserForm> assignedTestUserFormsList=new ArrayList<AssignedTestUserForm>();
		for(AssignedTestUser atu:assignedTestUsers) {
			AssignedTestUserForm assignedTestUserForm=new AssignedTestUserForm();
			BeanUtils.copyProperties(atu, assignedTestUserForm);
			assignedTestUserForm.setTechName(atu.getAssignedTestCompositeKey().getTechName());
			assignedTestUserForm.setUserId(atu.getAssignedTestCompositeKey().getUserId());
			assignedTestUserForm.setTestName(atu.getAssignedTestCompositeKey().getTestName());
			assignedTestUserFormsList.add(assignedTestUserForm);
		}
		return assignedTestUserFormsList;
	}

	@Override
	public void assignedTestToUsers(List<AssignedTestUserForm> assignedTest) {
		List<AssignedTestUser> assignedTestDbList = new ArrayList<AssignedTestUser>();
		for (AssignedTestUserForm assignedTestUserForm : assignedTest) {
			AssignedTestUser atest = new AssignedTestUser();
			BeanUtils.copyProperties(assignedTestUserForm, atest);
			// setting composite key manually for AssignedTestUser table
			AssignedTestCompositeKey assignedTestCompositeKey = new AssignedTestCompositeKey();
			assignedTestCompositeKey.setTechName(assignedTestUserForm.getTechName());
			assignedTestCompositeKey.setUserId(assignedTestUserForm.getUserId());
			assignedTestCompositeKey.setTestName(assignedTestUserForm.getTestName());
			atest.setAssignedTestCompositeKey(assignedTestCompositeKey);
			assignedTestDbList.add(atest);
		}
		onlineTechTestDao.assignedTestToUsers(assignedTestDbList);
	}

	@Override
	public AssignedTestUserForm findAssignedTestByURL(String link) {
		try {
			AssignedTestUserForm atestForm = new AssignedTestUserForm();
			AssignedTestUser at = onlineTechTestDao.findAssignedTestByURL(link);
			BeanUtils.copyProperties(at, atestForm);
			AssignedTestCompositeKey assignedTestCompositeKey = at.getAssignedTestCompositeKey();
			atestForm.setUserId(assignedTestCompositeKey.getUserId());
			atestForm.setTechName(assignedTestCompositeKey.getTechName());
			atestForm.setTestName(assignedTestCompositeKey.getTestName());
			return atestForm;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public List<AssignedTestUserForm> findAssignedTestByGroup(String groupName) {
		List<AssignedTestUserForm> assignedTestUserForms=new ArrayList<>();
		List<AssignedTestUser>  at = onlineTechTestDao.findAssignedTestByGroup(groupName);
		for (AssignedTestUser assignedTestUser : at) {
			AssignedTestUserForm atestForm = new AssignedTestUserForm();
			BeanUtils.copyProperties(assignedTestUser, atestForm);
			AssignedTestCompositeKey assignedTestCompositeKey = assignedTestUser.getAssignedTestCompositeKey();
			atestForm.setUserId(assignedTestCompositeKey.getUserId());
			atestForm.setTechName(assignedTestCompositeKey.getTechName());
			atestForm.setTestName(assignedTestCompositeKey.getTestName());
			assignedTestUserForms.add(atestForm);
		}
		return assignedTestUserForms;
	}

	public int getNoofRecords() {
		return onlineTechTestDao.getNoofRecords();
	}

	@Override
	public List<QuestionsForm> deleteQues(String qId) {
		// TODO Auto-generated method stub
		List<Questions> quest = onlineTechTestDao.deleteQues(qId);
		List<QuestionsForm> QuestionsFormList = new ArrayList<QuestionsForm>();
		for (Questions q : quest) {
			/* System.out.println("in"); */
			QuestionsForm qform = new QuestionsForm();
			BeanUtils.copyProperties(q, qform);
			/*
			 * System.out.println("printing:"+qform.getLastModifyBy());
			 * System.out.println("text:"+qform.getQuestionText());
			 */
			QuestionsFormList.add(qform);

		}
		return QuestionsFormList;
	}

	@Override
	public List<QuestionsForm> findAllQuestions() {
		List<Questions> questionsList = onlineTechTestDao.findAllQuestions();
		List<QuestionsForm> QuestionsFormList = new ArrayList<QuestionsForm>();
		for (Questions q : questionsList) {
			QuestionsForm qform = new QuestionsForm();
			BeanUtils.copyProperties(q, qform);
			QuestionsFormList.add(qform);
		}
		return QuestionsFormList;
	}

	@Override
	public List<UserTechTestDetailForm> findTestsByTechName(String techName) {
		List<UserTechTestDetailEntity> userTechTestDetailEntitiesList = onlineTechTestDao.findTestsByTechName(techName);
		List<UserTechTestDetailForm> userTechTestDetailFormsList = new ArrayList<UserTechTestDetailForm>();
		for (UserTechTestDetailEntity userTechTestDetailEntity : userTechTestDetailEntitiesList) {
			UserTechTestDetailForm userTechTestDetailForm = new UserTechTestDetailForm();
			BeanUtils.copyProperties(userTechTestDetailEntity, userTechTestDetailForm);
			userTechTestDetailFormsList.add(userTechTestDetailForm);
		}
		return userTechTestDetailFormsList;
	}
	
	
	/**
	 * 
	 * @param testName
	 * @param userId
	 * @return
	 * 
	 */
	@Override
	public List<UserExamDetailStatusVO> findTestTechDetailSummary(String testName,String techName,String userId,String userSessionId) {
		List<UserExamDetailStatus> userExamDetailStatusList = onlineTechTestDao.findTestTechDetailSummary(testName,techName,userId,userSessionId);
		List<UserExamDetailStatusVO> examDetailStatusVOs=new ArrayList<UserExamDetailStatusVO>();
		for (UserExamDetailStatus userExamDetailStatus : userExamDetailStatusList) {
			UserExamDetailStatusVO examDetailStatusVO = new UserExamDetailStatusVO();
			BeanUtils.copyProperties(userExamDetailStatus, examDetailStatusVO);
			examDetailStatusVOs.add(examDetailStatusVO);
		}
		return examDetailStatusVOs;
	}

}
