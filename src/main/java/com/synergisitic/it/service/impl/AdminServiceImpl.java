package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.impl.AdminDaoImpl;
import com.synergisitic.it.model.AssignedTestCompositeKey;
import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.AvailableQuestionsBankEntity;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.report.model.OCJPReportCard;
import com.synergisitic.it.service.AdminService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.AvailableQuestionsBankForm;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.TestConfiguration;
import com.synergisitic.it.web.form.UserForm;
import com.techquiz.trainer.service.IConsultantAssesmentService;

/**
 * 
 * @author nagendra.yadav
 * 
 * This is service layer to interact with DAL
 * for User Entity 
 *
 */
@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	@Qualifier("AdminDaoImpl")
	private AdminDaoImpl adminDaoImpl;
	

	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	

	@Override
	public List<QuestionsForm> findAllAssignedQuestionByTech(String technology) {
		List<com.synergisitic.it.model.Questions> questionList=adminDaoImpl.findAllAssignedQuestionByTech(technology);
		List<QuestionsForm> qlist=new ArrayList<QuestionsForm>();
		for(com.synergisitic.it.model.Questions dquestion:questionList){
			QuestionsForm questions=new QuestionsForm();
			questions.setId(dquestion.getId());
			questions.setQuestionId(dquestion.getQuestionId());
			questions.setQuestionText(dquestion.getQuestionText());
			questions.setQuestionComplexity(dquestion.getQuestionComplexity());
			qlist.add(questions);
		}
		return qlist;
	}
	
	@Override
	public String updateConfiguredTest(TestConfiguration testConfiguration,boolean isUpdate) {
		AvailableTest availableTest=BeanUtils.instantiate(AvailableTest.class);
		BeanUtils.copyProperties(testConfiguration, availableTest);
		adminDaoImpl.updateConfiguredTest(availableTest,isUpdate);
		return ApplicationContant.SUCCESS;
	}

	@Override
	public String addNewTechTest(TestConfiguration testConfiguration,boolean isUpdate) {
		AvailableTest availableTest=BeanUtils.instantiate(AvailableTest.class);
		BeanUtils.copyProperties(testConfiguration, availableTest);
		adminDaoImpl.addNewTechTest(availableTest,isUpdate);
		return ApplicationContant.SUCCESS;
	}

	/**
	 *  @param technology 
	 *   the name of technology passed from UI
	 *   
	 */
	@Override
	public List<AssignedTestUserForm> findAllCompletedTestListByTech(
			String technology) {
		 List<AssignedTestUser> assignedTestUsersList=adminDaoImpl.findAllCompletedTestListByTech(technology);
		 List<AssignedTestUserForm> assignedTestUserFormsList=null;
		 if(assignedTestUsersList.size()>0){
			 assignedTestUserFormsList=new  ArrayList<AssignedTestUserForm>(assignedTestUsersList.size()); 
		 } else {
			 assignedTestUserFormsList=new  ArrayList<AssignedTestUserForm>(); 
		 }
		 
		 for(AssignedTestUser assignedTestUser:assignedTestUsersList) {
			 AssignedTestCompositeKey assignedTestCompositeKey=new AssignedTestCompositeKey();
			 assignedTestCompositeKey.setTechName(assignedTestUser.getAssignedTestCompositeKey().getTechName());
			 assignedTestCompositeKey.setUserId(assignedTestUser.getAssignedTestCompositeKey().getUserId()); 	 
			 AssignedTestUserForm assignedTestUserForm=BeanUtils.instantiate(AssignedTestUserForm.class);
			 assignedTestUserForm.setAssignedTestCompositeKey(assignedTestCompositeKey);
			 assignedTestUserForm.setTechName(assignedTestUser.getAssignedTestCompositeKey().getTechName());
			 assignedTestUserForm.setUserId(assignedTestUser.getAssignedTestCompositeKey().getUserId());
			 assignedTestUserForm.setAttamptLimit(assignedTestUser.getAttamptLimit());
			 assignedTestUserForm.setLink(assignedTestUser.getLink());
			 assignedTestUserForm.setTestStatus(assignedTestUser.getTestStatus());
			 assignedTestUserForm.setTestExpireOn(assignedTestUser.getTestExpireOn());
			 assignedTestUserForm.setAssignDate(assignedTestUser.getAssignDate());
			 assignedTestUserForm.setGroupName(assignedTestUser.getGroupName());
			 assignedTestUserForm.setResetDate(assignedTestUser.getResetDate());
			 assignedTestUserFormsList.add(assignedTestUserForm);
		 }
		 return assignedTestUserFormsList;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public String resetConsultantGroupTestByTech(String techName,String testName, String groupName,boolean withHistory) {
		List<UserForm> users = consultantAssesmentService
		.findConsultantByBatchWithTechTestStatus(techName, testName, groupName, false);
		for(UserForm userForm: users){
			adminDaoImpl.resetConsultantTestByTech(techName,testName, userForm.getLoginid(),withHistory,null);
		}
		return "done";
	}

	
	@Override
	public String resetConsultantTestByTech(String techName,String testName, String userId,boolean withHistory,String userSessionId) {
		return adminDaoImpl.resetConsultantTestByTech(techName,testName, userId,withHistory,userSessionId);
	}

	@Override
	public String resetUserTest(String testName, String userId) {
		return adminDaoImpl.resetUserTest(testName, userId);
	}

	@Override
	public List<OCJPReportCard> findReportCardByUserid(String userid) {
		 List<OCJPReportCard> ocjpReportCards=new ArrayList<OCJPReportCard>();
		List<UserOnlineExamStatus>  onlineExamStatus= adminDaoImpl.findReportCardByUserid(userid);
		for(UserOnlineExamStatus examStatus:onlineExamStatus){
			OCJPReportCard ocjpReportCard=new OCJPReportCard();
			BeanUtils.copyProperties(examStatus, ocjpReportCard);
			ocjpReportCard.setSdateOfTest(ocjpReportCard.getDateOfTest().toString());
			ocjpReportCards.add(ocjpReportCard);
		}
		return ocjpReportCards;
	}
	
	@Override
	public List<OCJPReportCard> findReportCardByUseridAndTest(String userid,String techName,
			String testName){
		 List<OCJPReportCard> ocjpReportCards=new ArrayList<OCJPReportCard>();
			List<UserOnlineExamStatus>  onlineExamStatus= adminDaoImpl.findReportCardByUseridAndTest(userid,techName,testName);
			for(UserOnlineExamStatus examStatus:onlineExamStatus){
				OCJPReportCard ocjpReportCard=new OCJPReportCard();
				BeanUtils.copyProperties(examStatus, ocjpReportCard);
				ocjpReportCard.setSdateOfTest(ocjpReportCard.getDateOfTest().toString());
				ocjpReportCards.add(ocjpReportCard);
			}
			return ocjpReportCards;
	}
	
	@Override
	public List<OCJPReportCard> findReportCardByUseridAndTechTestSessionId(String userid,String techName,String testName,String userSessionId) {
		 List<OCJPReportCard> ocjpReportCards=new ArrayList<OCJPReportCard>();
			List<UserOnlineExamStatus>  onlineExamStatus= adminDaoImpl.findReportCardByUseridAndTechTestSessionId(userid,techName,testName,userSessionId);
			for(UserOnlineExamStatus examStatus:onlineExamStatus){
				OCJPReportCard ocjpReportCard=new OCJPReportCard();
				BeanUtils.copyProperties(examStatus, ocjpReportCard);
				ocjpReportCard.setSdateOfTest(ocjpReportCard.getDateOfTest().toString());
				ocjpReportCards.add(ocjpReportCard);
			}
			return ocjpReportCards;
	}
	

	@Override
	public List<AvailableQuestionsBankForm> findAllAvailableQuestionBank() {
		List<AvailableQuestionsBankEntity> availableQuestionsBankEntityList=adminDaoImpl.findAllAvailableQuestionBank();
		List<AvailableQuestionsBankForm> availableQuestionsBankList=new ArrayList<AvailableQuestionsBankForm>();
		for(AvailableQuestionsBankEntity availableQuestionsBank:availableQuestionsBankEntityList){
			AvailableQuestionsBankForm AvailableQuestionsBankForm=new AvailableQuestionsBankForm();
			BeanUtils.copyProperties(availableQuestionsBank, AvailableQuestionsBankForm);
			availableQuestionsBankList.add(AvailableQuestionsBankForm);
		}
		return availableQuestionsBankList;
	}

	@Override
	public List<AvailableQuestionsBankForm> findAllAvailableQuestionBankByUserId(
			String userid) {
		List<AvailableQuestionsBankEntity> availableQuestionsBankEntityList=adminDaoImpl.findAllAvailableQuestionBankByUserId(userid);
		List<AvailableQuestionsBankForm> availableQuestionsBankList=new ArrayList<AvailableQuestionsBankForm>();
		for(AvailableQuestionsBankEntity availableQuestionsBank:availableQuestionsBankEntityList){
			AvailableQuestionsBankForm AvailableQuestionsBankForm=new AvailableQuestionsBankForm();
			BeanUtils.copyProperties(availableQuestionsBank, AvailableQuestionsBankForm);
			availableQuestionsBankList.add(AvailableQuestionsBankForm);
		}
		return availableQuestionsBankList;
	}

	@Override
	public List<TestConfiguration> findAllAvailableOnlineTests() {
		List<AvailableTest> availableTestsList=adminDaoImpl.findAllAvailableOnlineTests();
		List<TestConfiguration> availableTestConfList=new ArrayList<TestConfiguration>();
		for(AvailableTest availableTest:availableTestsList){
			TestConfiguration testConfiguration=new TestConfiguration();
			BeanUtils.copyProperties(availableTest, testConfiguration);
			availableTestConfList.add(testConfiguration);
		}
		return availableTestConfList;
	}

	@Override
	public List<AssignedTestUserForm> findAllCompletedTestListByTechAndGroup(
			String technology, String groupName) {
		 List<AssignedTestUser> assignedTestUsersList=adminDaoImpl.findAllCompletedTestListByTechAndGroup(technology, groupName);
		 List<AssignedTestUserForm> assignedTestUserFormsList=null;
		 if(assignedTestUsersList.size()>0){
			 assignedTestUserFormsList=new  ArrayList<AssignedTestUserForm>(assignedTestUsersList.size()); 
		 } else {
			 assignedTestUserFormsList=new  ArrayList<AssignedTestUserForm>(); 
		 }
		 
		 for(AssignedTestUser assignedTestUser:assignedTestUsersList) {
			 AssignedTestUserForm assignedTestUserForm=BeanUtils.instantiate(AssignedTestUserForm.class); 
			 assignedTestUserForm.setTechName(assignedTestUser.getAssignedTestCompositeKey().getTechName());
			 assignedTestUserForm.setUserId(assignedTestUser.getAssignedTestCompositeKey().getUserId());
			 assignedTestUserForm.setAttamptLimit(assignedTestUser.getAttamptLimit());
			 assignedTestUserForm.setLink(assignedTestUser.getLink());
			 assignedTestUserForm.setTestStatus(assignedTestUser.getTestStatus());
			 assignedTestUserForm.setTestExpireOn(assignedTestUser.getTestExpireOn());
			 assignedTestUserForm.setAssignDate(assignedTestUser.getAssignDate());
			 assignedTestUserForm.setGroupName(assignedTestUser.getGroupName());
			 assignedTestUserForm.setResetDate(assignedTestUser.getResetDate());
			 assignedTestUserFormsList.add(assignedTestUserForm);
		 }
		 return assignedTestUserFormsList;
	}

	@Override
	public List<AssignedTestUserForm> findUsersByName(String userName,String testName) {
		List<AssignedTestUser> userLists=adminDaoImpl.findUsersByName(userName,testName);
		List<AssignedTestUserForm> usersList=new ArrayList<AssignedTestUserForm>();
		for(AssignedTestUser user:userLists){
			AssignedTestUserForm users=new AssignedTestUserForm();
			BeanUtils.copyProperties(user, users);
			usersList.add(users);
		}
		return usersList;
	}

	@Override
	public List<TestConfiguration> findConfiguredTestByTrainer(String trainerId) {
		List<AvailableTest> availableTestsList=adminDaoImpl.findConfiguredTestByTrainer(trainerId);
		List<TestConfiguration> availableTestConfList=new ArrayList<TestConfiguration>();
		for(AvailableTest availableTest:availableTestsList){
			TestConfiguration testConfiguration=new TestConfiguration();
			BeanUtils.copyProperties(availableTest, testConfiguration);
			availableTestConfList.add(testConfiguration);
		}
		return availableTestConfList;
	}
}
