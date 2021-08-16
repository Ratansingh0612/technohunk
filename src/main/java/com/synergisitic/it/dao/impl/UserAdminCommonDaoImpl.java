package com.synergisitic.it.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.UserAdminCommonDao;
import com.synergisitic.it.model.AssignedQuestionAnswers;
import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.AvailableQuestionsBankEntity;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.util.ApplicationContant;
import com.techquiz.programys.common.dao.entity.BatchEntity;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */

@Repository("UserAdminCommonDaoImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class UserAdminCommonDaoImpl implements UserAdminCommonDao {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(AdminDaoImpl.class);

	//EntityManagerFactory
	@PersistenceContext
	private EntityManager em;
	//this EntityManager is similar to session in hibernate
	//here who is managing EntityManagerFactory and EntityManager + Transaction????? Spring

	@Override
	public List<Questions> findAllQuestionByTechAndUser(String technology,
			String userid) {
		  String ejbqlString="from Questions as qt where qt.technology=? and questionOwner=? ";
		  Query query=em.createQuery(ejbqlString);
		  query.setParameter(1,technology);
		  query.setParameter(2,userid);
		  return query.getResultList();
	}
	
	@Override
	public List<Questions> findAllQuestionByTechAndUser(String technology) {
		  String ejbqlString="from Questions as qt where qt.technology=? ";
		  Query query=em.createQuery(ejbqlString);
		  query.setParameter(1,technology);
		  return query.getResultList();
	}
	

	@Override
	public List<Questions> findQuestionsInBankByTech(String qbankName,String techName) {
		  String ejbqlString="from Questions as qt where qt.technology=? and qt.qbankName=?";
		  Query query=em.createQuery(ejbqlString);
		  query.setParameter(1,techName);
		  query.setParameter(2,qbankName);
		  List<Questions> questionsList=query.getResultList();
		  return questionsList;
	}
	
	
	@Override
	public String  deleteQuestionFromBankByTech(String questionid ) {
		  //deleting the question from question table
		  String selectAllAssignedAnswers="from AssignedQuestionAnswers as aq where aq.questionId=?";
		  Query squery=em.createQuery(selectAllAssignedAnswers);
		  squery.setParameter(1,questionid);
		  List<AssignedQuestionAnswers> assignedQuestionAnswersList=squery.getResultList();
		  String techName="";
		  String qbankname="";
		  int row=0;
		  for(AssignedQuestionAnswers assignedQuestionAnswers:assignedQuestionAnswersList) {
			  techName=assignedQuestionAnswers.getQuestions().getTechnology();
			  qbankname=assignedQuestionAnswers.getQuestions().getQbankName();
			  //em.remove(assignedQuestionAnswers.getQuestions());
			  em.remove(assignedQuestionAnswers);
			  String deleteAnswer="delete from Answers as at where at.answerId=?";
			  Query query=em.createQuery(deleteAnswer);
			  query.setParameter(1,assignedQuestionAnswers.getAnswerId());
			  row=query.executeUpdate();
		  }
		  String updateNoOfQues="update QuestionsBankEntity set  noq=noq-1 where qbankname=? and techName=?";
		  Query uquery=em.createQuery(updateNoOfQues);
		  uquery.setParameter(1,qbankname);
		  uquery.setParameter(2,techName);
		   row=uquery.executeUpdate();
		  //Updating the no of  questions 
		  return "success";
	}
	
	

	@Override
	public List<Questions> findAllQuestionInByBankTechAndUserId(String qbankName,String userid,String techName) {
		  //String ejbqlString="from Questions as qt where qt.questionOwner=? and qt.qbankName=?";
		String ejbqlString="from Questions as qt where qt.qbankName=?";
		  Query query=em.createQuery(ejbqlString);
		  //query.setParameter(1,userid);
		  query.setParameter(1,qbankName);
		  List<Questions> questionsList=query.getResultList();
		  List<Questions> fquestionsList=new ArrayList<Questions>();
		  
		  String assignedQuestionsAnswer="from AssignedQuestionAnswers as aq where aq.technology=?";
		  Query pquery=em.createQuery(assignedQuestionsAnswer);
		  pquery.setParameter(1,techName);
		  List<AssignedQuestionAnswers> assignedQuestionAnswersList=pquery.getResultList();
		  for(Questions question:questionsList){
			  AssignedQuestionAnswers assignedQuestionAnswers=new AssignedQuestionAnswers();
			  assignedQuestionAnswers.setQuestionId(question.getQuestionId());
			  if(assignedQuestionAnswersList.contains(assignedQuestionAnswers)){
				  fquestionsList.add(question);
			  }
		  }
		  return fquestionsList;
	}
	
	@Override
	public AvailableTest findAvailableTestByTestName(String testName) {
		  String findAvailableTest="from AvailableTest as at where at.testName=? ";
		  Query query=em.createQuery(findAvailableTest);
		  query.setParameter(1,testName);
		  return (AvailableTest)query.getSingleResult();
	}
	
	@Override
	public List<String> findAvailableTestByTechName(String techName) {
		  String findAvailableTest="select testName from AvailableTest as at where at.techName=? ";
		  Query query=em.createQuery(findAvailableTest);
		  query.setParameter(1,techName);
		  List<String> testsList=(List<String>)query.getResultList();
		  return testsList;
	}
	
	@Override
	public String deleteTestByTechName(String techName,String testName) {
		  String deleteAvailableTest="delete from AvailableTest as at where at.techName=? and at.testName=? ";
		  Query query=em.createQuery(deleteAvailableTest);
		  query.setParameter(1,techName);
		  query.setParameter(2,testName);
		  query.executeUpdate();
		  
		  //code is used to delete all the assigned test which is not started so far
		  String deleteAssignedTest="delete from AssignedTestUser as atu where  atu.assignedTestCompositeKey.techName=? and atu.assignedTestCompositeKey.testName=? and atu.testStatus='Not Started'";
		  Query deleteAssignedTestQuery=em.createQuery(deleteAssignedTest);
		  deleteAssignedTestQuery.setParameter(1,techName);
		  deleteAssignedTestQuery.setParameter(2,testName);
		  deleteAssignedTestQuery.executeUpdate();
		  return "success";
	}
	
	public List<String> findQuestionBankByTechName(String techName) {
		  String findAvailableTest="select qbankname from QuestionsBankEntity as at where at.techName=? ";
		  Query query=em.createQuery(findAvailableTest);
		  query.setParameter(1,techName);
		  List<String> testsList=(List<String>)query.getResultList();
		  return testsList;
	}
	
	@Override
	public List<String> findTopicsByTechName(String techName) {
		  String findAvailableTest="select topic from TopicEntity as at where at.tname=? ";
		  Query query=em.createQuery(findAvailableTest);
		  query.setParameter(1,techName);
		  List<String> topicsList=(List<String>)query.getResultList();
		  return topicsList;
	}

	@Override
	public List<Questions> findAllQuestionByQuestionIds(
			String[] selectedQuestionIds) {
		List<Questions>  questionsList=new ArrayList<Questions>();
		String ejbqlString="from Questions as qt where qt.questionId=? ";
		 Query query=em.createQuery(ejbqlString);
		for(String questionId:selectedQuestionIds){
			 query.setParameter(1,questionId);
			 Questions squestion=(Questions)query.getSingleResult();
			 questionsList.add(squestion);
		}
		return questionsList;
	}
	
	@Override
	public String checkConsultantId(String consultantid) {
		Query query=em.createQuery("from ConsultantsEntity as c where c.userid=?");
		query.setParameter(1, consultantid);
		String status=ApplicationContant.SUCCESS;
		try {
			ConsultantsEntity consultantsEntity=(ConsultantsEntity)query.getSingleResult();
		}catch(Exception ex){
			status=ApplicationContant.FAIL;
		}
		return status;
	}
	
	@Override
	public String checkBatchName(String batch) {
		Query query=em.createQuery("from BatchEntity as c where c.batch=?");
		query.setParameter(1, batch);
		String status=ApplicationContant.SUCCESS;
		try {
			BatchEntity batchEntity=(BatchEntity)query.getSingleResult();
		}catch(Exception ex){
			status=ApplicationContant.FAIL;
		}
		return status;
	}
	
	@Override
	public BatchEntity findBatchByBatchName(String batch) {
		Query query=em.createQuery("from BatchEntity as c where c.batch=?");
		query.setParameter(1, batch);
		BatchEntity batchEntity=new BatchEntity();
		try {
			 batchEntity=(BatchEntity)query.getSingleResult();
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return batchEntity;
	}

	@Override
	public String addBatch(BatchEntity batchEntity) {
		String status=ApplicationContant.SUCCESS;
		try {
			em.persist(batchEntity);
		}catch(Exception ex){
			status=ApplicationContant.FAIL;
		}
		return status;
	}
	
	@Override
	public List<BatchEntity> findBatches() {
		List<BatchEntity>  batchEntityList=new ArrayList<BatchEntity>();
		String batchQuery="from BatchEntity";
		 Query query=em.createQuery(batchQuery);
		return query.getResultList();
	}
	
	@Override
	public boolean isTechTestAssignedToConsultant(String techName, String testName, String userid){
		Query query=em.createQuery("from AssignedTestUser as atu where atu.assignedTestCompositeKey.userId=? and atu.assignedTestCompositeKey.techName=? and atu.assignedTestCompositeKey.testName=?");
		query.setParameter(1, userid);
		query.setParameter(2, techName);
		query.setParameter(3, testName);
		boolean status=false; 
		try {
			List<AssignedTestUser> assignedTestUsersList=(List<AssignedTestUser>)query.getResultList();
			if(assignedTestUsersList.size()>0){
				status=true;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return status;
	}
	
	@Override
	public boolean isTechTestAssignedToGroup(String techName,String testName, String groupName) {
		Query query=em.createQuery("from AssignedTestUser as atu where atu.groupName=? and atu.assignedTestCompositeKey.techName=? and atu.assignedTestCompositeKey.testName=?");
		query.setParameter(1, groupName);
		query.setParameter(2, techName);
		query.setParameter(3, testName);
		boolean status=false; 
		try {
			List<AssignedTestUser> assignedTestUsersList=(List<AssignedTestUser>)query.getResultList();
			if(assignedTestUsersList.size()>0){
				status=true;
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return status;
	}

	@Override
	public String deleteTestByTechNameandTestName(String techName, String testName)
	{
		String deleteTest ="delete from AvailableTest where techName=? and testName=?";
		Query query = em.createQuery(deleteTest);
		query.setParameter(1, techName);
		query.setParameter(2, testName);
		query.executeUpdate();
		return "success";
	}
	
	@Override
	public String findTechImageByTechName(String techName) {
		System.out.println(techName+"= =========================");
		//taking whole record
		Query query = em.createQuery("from TechnologyEntity where tname=?");
		query.setParameter(1, techName);
		TechnologyEntity technologyEntity = (TechnologyEntity) query.getSingleResult();
		System.out.println("***Image***: "+technologyEntity.getImage());
		return technologyEntity.getImage();
	}
	
	
	

}
