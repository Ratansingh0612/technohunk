package com.synergisitic.it.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.AdminDao;
import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.AvailableGuestTest;
import com.synergisitic.it.model.AvailableQuestionsBankEntity;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.model.User;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.util.ApplicationContant;

@Repository("AdminDaoImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class AdminDaoImpl implements AdminDao  {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(AdminDaoImpl.class);

	//EntityManagerFactory
	@PersistenceContext
	private EntityManager em;
	//this EntityManager is similar to session in hibernate
	//here who is managing EntityManagerFactory and EntityManager + Transaction????? Spring

	public List<User> findAllUsers() {
		String namedQuery="from User";
		Query query=em.createQuery(namedQuery);
		List<User> usersList=query.getResultList();
		return usersList;
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Questions> findAllAssignedQuestionByTech(String technology) {
		Query query=em.createNamedQuery("find.all.assigned.question.by.tech");
	    query.setParameter("tech",technology);
	    List<Questions> assignedQAList=query.getResultList();
	    Set<Questions> tempSet=new HashSet<Questions>(assignedQAList.size());
	    tempSet.addAll(assignedQAList);
		return new ArrayList<Questions>(tempSet);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String updateConfiguredTest(AvailableTest availableTest,boolean isUpdate) {
		AvailableGuestTest availableGuestTest=new AvailableGuestTest();
		BeanUtils.copyProperties(availableTest, availableGuestTest);
		if(isUpdate) {
			   //delete the old test
			   Query query2=em.createQuery("update AvailableTest set  testDuration=?,randQuestion=? where testName=? and techName=? and id=?");
			   query2.setParameter(1,availableTest.getTestDuration());
			   query2.setParameter(2,availableTest.isRandQuestion());
			   query2.setParameter(3,availableTest.getTestName());
			   query2.setParameter(4,availableTest.getTechName());
			   query2.setParameter(5,availableTest.getId());
			   int p=query2.executeUpdate();
		}
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addNewTechTest(AvailableTest availableTest,boolean isUpdate) {
		AvailableGuestTest availableGuestTest=new AvailableGuestTest();
		BeanUtils.copyProperties(availableTest, availableGuestTest);
		if(isUpdate) {
			   //delete the old test
			   Query query2=em.createQuery("delete from  AvailableTest as at  where at.testName=? and at.techName=? and at.lastModifyBy=?");
			   query2.setParameter(1,availableTest.getTestName());
			   query2.setParameter(2,availableTest.getTechName());
			   query2.setParameter(3,availableTest.getLastModifyBy());
			   int p=query2.executeUpdate();
			   
			   Query query3=em.createQuery("delete from  AvailableGuestTest as at  where at.testName=? and at.techName=? and at.lastModifyBy=?");
			   query3.setParameter(1,availableTest.getTestName());
			   query3.setParameter(2,availableTest.getTechName());
			   query3.setParameter(3,availableTest.getLastModifyBy());
			   p=query3.executeUpdate();
		}
		em.persist(availableTest);
		availableGuestTest.setActive(ApplicationContant.USER_ACTIVE_NO.toUpperCase());
		em.persist(availableGuestTest);
		return ApplicationContant.SUCCESS;
	}

	@Override
	public List<AssignedTestUser> findAllCompletedTestListByTech(
			String technology) {
		Query query=em.createQuery("from AssignedTestUser as atus where atus.assignedTestCompositeKey.techName=? ");
		query.setParameter(1,technology);
		//query.setParameter(2,ApplicationContant.COMPLETE_EXAM_STATUS);
		//query.setParameter(3,ApplicationContant.IN_COMPLETE_EXAM_STATUS);
		List<AssignedTestUser> assignedTestUserList=query.getResultList();
		return assignedTestUserList;
	}
	
	@Override
	public List<AssignedTestUser> findAllCompletedTestListByTechAndGroup(
			String technology, String groupName) {
		Query query=em.createQuery("from AssignedTestUser atu where atu.assignedTestCompositeKey.techName=? and atu.groupName=? and atu.testStatus in (?,?)");
		query.setParameter(1,technology);
		query.setParameter(2,groupName);
		//query.setParameter(3,ApplicationContant.COMPLETE_EXAM_STATUS);
		//query.setParameter(4,ApplicationContant.IN_COMPLETE_EXAM_STATUS);
		List<AssignedTestUser> assignedTestUserList=query.getResultList();
		return assignedTestUserList;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String resetUserTest(String testName, String userId) {
		   Query query1=em.createQuery("update AssignedTestUser as t set t.testStatus=? where t.assignedTestCompositeKey.techName=? and t.assignedTestCompositeKey.userId=?");
		   query1.setParameter(1,ApplicationContant.NOT_STARTED);
		   query1.setParameter(2,testName);
		   query1.setParameter(3,userId);
		   int p=query1.executeUpdate();
		   
		   Query query2=em.createQuery("delete from  UserExamDetailStatus as ueds  where ueds.testName=? and ueds.userId=?");
		   query2.setParameter(1,testName);
		   query2.setParameter(2,userId);
		   p=query2.executeUpdate();
		   
		   
		   Query query3=em.createQuery("delete from  UserOnlineExamStatus as uoes  where uoes.testName=? and uoes.userId=?");
		   query3.setParameter(1,testName);
		   query3.setParameter(2,userId);
		   p=query3.executeUpdate();
		   
			/////delete data from user_exam_progress_data_tbl
			Query query4=em.createQuery("delete from UserExamProgressData uepd where uepd.userId=? and uepd.testName=?");
			query4.setParameter(1,userId);
			query4.setParameter(2, testName);
		     p=query4.executeUpdate();
			if(logger.isDebugEnabled())
				logger.debug(p+" record is deleted from user_exam_progress_data_tbl for user = "+userId);
			
		   return ApplicationContant.SUCCESS;
	}
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String resetConsultantTestByTech(String techName,String testName, String userId,boolean withHistory,String userSessionId) {
		   Query query=em.createQuery("from AssignedTestUser as t where t.assignedTestCompositeKey.techName=? and t.assignedTestCompositeKey.testName=? and t.assignedTestCompositeKey.userId=?");
		   query.setParameter(1,techName);
		   query.setParameter(2,testName);
		   query.setParameter(3,userId);
		   AssignedTestUser assignedTestUser=null;
		   try {
			    assignedTestUser=(AssignedTestUser)query.getSingleResult();
		   }catch(Exception ex){
			    return "fail";
		   }
		   //userSessionId=assignedTestUser.getUserSessionId();
		   assignedTestUser.setTestStatus(ApplicationContant.NOT_STARTED);
		   assignedTestUser.setUserSessionId(null);
		  // Query query1=em.createQuery("update AssignedTestUser as t set t.testStatus=?,userSessionId=? where t.assignedTestCompositeKey.techName=? and t.assignedTestCompositeKey.testName=? and t.assignedTestCompositeKey.userId=?");
		   //query1.setParameter(1,ApplicationContant.NOT_STARTED);
		   //query1.setParameter(2,null);
		   //query1.setParameter(3,techName);
		   //query1.setParameter(4,testName);
		   //query1.setParameter(5,userId);
		  //query1.executeUpdate();
		   int p=0;
		   if(withHistory) {
				   Query query2=em.createQuery("delete from  UserExamDetailStatus as ueds  where  ueds.testName=? and ueds.techName=? and ueds.userId=? and ueds.userSessionId=?");
				   query2.setParameter(1,testName);
				   query2.setParameter(2,techName);
				   query2.setParameter(3,userId);
				   query2.setParameter(4,userSessionId);
				   p=query2.executeUpdate();
				   
				   
				   Query query3=em.createQuery("delete from  UserOnlineExamStatus as uoes  where uoes.testName=? and uoes.techName=? and uoes.userId=? and uoes.userSessionId=?");
				   query3.setParameter(1,testName);
				   query3.setParameter(2,techName);
				   query3.setParameter(3,userId);
				   query3.setParameter(4,userSessionId);
				   p=query3.executeUpdate();
				   
					/////delete data from user_exam_progress_data_tbl
					Query query4=em.createQuery("delete from UserExamProgressData uepd where uepd.userId=? and  uepd.testName=? and uepd.techName=? and uepd.userSessionId=?");
					query4.setParameter(1,userId);
					query4.setParameter(2, testName);
					query4.setParameter(3, techName);
					query4.setParameter(4,userSessionId);
				     p=query4.executeUpdate();
					if(logger.isDebugEnabled())
						logger.debug(p+" record is deleted from user_exam_progress_data_tbl for user = "+userId);
		   }
		   return ApplicationContant.SUCCESS;
	}

	@Override
	public List<UserOnlineExamStatus> findReportCardByUserid(String userid) {
		Query query=em.createQuery("from UserOnlineExamStatus as uoes where uoes.userId=?");
		query.setParameter(1,userid);
		List<UserOnlineExamStatus> userOnlineExamStatus=query.getResultList();
		return userOnlineExamStatus;
	}
	
	@Override
	public List<UserOnlineExamStatus> findReportCardByUseridAndTest(String userid,String techName,String testName) {
		Query query=em.createQuery("from UserOnlineExamStatus as uoes where uoes.userId=? and uoes.techName=? and uoes.testName=? order by uoes.dateOfTest desc");
		query.setParameter(1,userid);
		query.setParameter(2,techName);
		query.setParameter(3,testName);
		List<UserOnlineExamStatus> userOnlineExamStatus=query.getResultList();
		return userOnlineExamStatus;
	}
	
	@Override
	public List<UserOnlineExamStatus> findReportCardByUseridAndTechTestSessionId(String userid,String techName,String testName,String userSessionId) {
		Query query=em.createQuery("from UserOnlineExamStatus as uoes where uoes.userId=? and uoes.techName=? and uoes.testName=? and  userSessionId=? order by uoes.dateOfTest desc");
		query.setParameter(1,userid);
		query.setParameter(2,techName);
		query.setParameter(3,testName);
		query.setParameter(4,userSessionId);
		List<UserOnlineExamStatus> userOnlineExamStatus=query.getResultList();
		return userOnlineExamStatus;
	}

	@Override
	public List<AvailableQuestionsBankEntity> findAllAvailableQuestionBank() {
		String nativeQuery = "select excelSheetName as imagePath,doe,description,qbankname as qbankName,noq as totalQuestions,ownerName as questionOwner,techName as questionBankName  from questions_bank_tbl";
		Query query= em.createNativeQuery(nativeQuery, AvailableQuestionsBankEntity.class);
		List<AvailableQuestionsBankEntity> availableQuestionsBankList=query.getResultList();
		return availableQuestionsBankList;
	}

	@Override
	public List<AvailableQuestionsBankEntity> findAllAvailableQuestionBankByUserId(
			String userid) {
		String nativeQuery = "select excelSheetName as imagePath,doe,description,qbankname as qbankName,noq as totalQuestions,ownerName as questionOwner,techName as questionBankName  from questions_bank_tbl where ownerName='"+userid+"'";
		Query query= em.createNativeQuery(nativeQuery, AvailableQuestionsBankEntity.class);
		List<AvailableQuestionsBankEntity> availableQuestionsBankList=query.getResultList();
		return availableQuestionsBankList;
	}
	

	@Override
	public List<AvailableTest> findAllAvailableOnlineTests() {
		Query query=em.createQuery("from AvailableTest");
		List<AvailableTest> availableTestList=query.getResultList();
		return availableTestList;
	}
	
	@Override
	public List<AvailableTest> findConfiguredTestByTrainer(String trainerId) {
		Query query=em.createQuery("from AvailableTest at where at.lastModifyBy=?");
		query.setParameter(1, trainerId);
		List<AvailableTest> availableTestList=query.getResultList();
		return availableTestList;
	}

	@Override
	public List<AssignedTestUser> findUsersByName(String userName,String testName) {
		Query query=em.createQuery("from AssignedTestUser as atuser where atuser.assignedTestCompositeKey.userId=? and atuser.assignedTestCompositeKey.techName=?");
		query.setParameter(1,userName);
		query.setParameter(2,testName);
		List<AssignedTestUser> users=query.getResultList();
		return users;
	}

}
