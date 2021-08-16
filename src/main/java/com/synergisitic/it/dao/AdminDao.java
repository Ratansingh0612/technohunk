package com.synergisitic.it.dao;

import java.util.List;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.AvailableQuestionsBankEntity;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.model.UserOnlineExamStatus;

/**
 * 
 * @author nagendra.yadav
 * This is contract for admin
 *
 */
public interface AdminDao {
	
    public List<Questions> findAllAssignedQuestionByTech(String technology);
    
    public String addNewTechTest(AvailableTest testConfiguration,boolean isUpdate) ;
    
    public List<AssignedTestUser> findAllCompletedTestListByTech(
			String technology) ;
    
	public List<AssignedTestUser> findAllCompletedTestListByTechAndGroup(
			String technology, String groupName) ;
    
    public String resetUserTest(String testName, String userId) ;
    
    public List<UserOnlineExamStatus> findReportCardByUserid(String userid);
    
    public List<AvailableQuestionsBankEntity> findAllAvailableQuestionBank();
	
	public List<AvailableQuestionsBankEntity> findAllAvailableQuestionBankByUserId(String userid);
	
	public List<AvailableTest> findAllAvailableOnlineTests();
	
	public List<AssignedTestUser> findUsersByName(String userName,String testName);

	public List<AvailableTest> findConfiguredTestByTrainer(String trainerId);

	public List<UserOnlineExamStatus> findReportCardByUseridAndTest(String userid,String techName,
			String testName);

	public String resetConsultantTestByTech(String testName, String techName, String userId,boolean withHistory,String userSessionId);

	public List<UserOnlineExamStatus> findReportCardByUseridAndTechTestSessionId(String userid, String techName,
			String testName, String userSessionId);

	public String updateConfiguredTest(AvailableTest availableTest, boolean isUpdate);

	
}
