package com.synergisitic.it.service;

import java.util.List;

import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.report.model.OCJPReportCard;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.AvailableQuestionsBankForm;
import com.synergisitic.it.web.form.TestConfiguration;

/**
 * 
 * @author nagendra.yadav
 *  This is service contract for admin.
 */
public interface AdminService {
	
	public List<com.synergisitic.it.web.form.QuestionsForm> findAllAssignedQuestionByTech(String technology);
	
	public List<com.synergisitic.it.web.form.AssignedTestUserForm> findAllCompletedTestListByTech(String technology);
	
	public List<com.synergisitic.it.web.form.AssignedTestUserForm> findAllCompletedTestListByTechAndGroup(String technology,String groupName);

	public String addNewTechTest(TestConfiguration testConfiguration,boolean isUpdate);
	
	public String 	resetUserTest(String testName,String userId);
	
	public List<OCJPReportCard> findReportCardByUserid(String userid) ;
	
	public List<AvailableQuestionsBankForm> findAllAvailableQuestionBank();
	
	public List<AvailableQuestionsBankForm> findAllAvailableQuestionBankByUserId(String userid);
	
	public List<TestConfiguration> findAllAvailableOnlineTests() ;
	
	public List<TestConfiguration> findConfiguredTestByTrainer(String trainerId);
	public List<AssignedTestUserForm> findUsersByName(String userName,String testName);

	public List<OCJPReportCard> findReportCardByUseridAndTest(String userid,String techName,
			String testName);

	public String resetConsultantTestByTech(String techName, String testName, String userId,boolean withHistory,String userSessionId);

	public List<OCJPReportCard> findReportCardByUseridAndTechTestSessionId(String userid, String techName, String testName,
			String userSessionId);

	public String resetConsultantGroupTestByTech(String techName, String testName, String groupName, boolean withHistory);

	public String updateConfiguredTest(TestConfiguration testConfiguration, boolean isUpdate);
	
}
