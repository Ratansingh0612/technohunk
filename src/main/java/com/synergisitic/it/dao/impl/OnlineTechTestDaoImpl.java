package com.synergisitic.it.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.OnlineTechTestDao;
import com.synergisitic.it.exception.OnlineTechException;
import com.synergisitic.it.model.Answers;
import com.synergisitic.it.model.AssignedQuestionAnswers;
import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.AvailableGuestTest;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.GuestUserEntity;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.model.StudentLoginEntity;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.model.UserExamDetailStatus;
import com.synergisitic.it.model.UserExamProgressData;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.model.UserTechTestDetailEntity;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.techquiz.info.jdbc.dao.entity.QuestionsBankEntity;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

/**
 * 
 * @author nagendra.yadav
 * 
 */
@Repository("OnlineTechTestDaoImpl")
@Transactional
public class OnlineTechTestDaoImpl implements OnlineTechTestDao {

	/**
	 * Initiate Logger for this class
	 */

	private static final Log logger = LogFactory
			.getLog(OnlineTechTestDaoImpl.class);
	private static final int limit = 3;
	// @PersistenceContext annotation injecting entityManager from above bean
	// This is Spring and JPA with hibernate integration

	@PersistenceContext
	private EntityManager em;
	


	
	/**
	 * @Since 26-Aug-2018
	 */
	@Override
	public List<AssignedTestUser> findAssignedTestsToGroupName(String groupName){
		Query query = em
				.createQuery("select distinct  atu from AssignedTestUser as atu where atu.groupName=?");
		query.setParameter(1,groupName);
		List<AssignedTestUser> assignedTestUsersdbList=query.getResultList();
		List<AssignedTestUser> filteredList=new ArrayList<AssignedTestUser>();
		if(assignedTestUsersdbList!=null && assignedTestUsersdbList.size()>0) {
			String userid=assignedTestUsersdbList.get(0).getAssignedTestCompositeKey().getUserId();
			for(AssignedTestUser temp:assignedTestUsersdbList){
				  if(userid.equalsIgnoreCase(temp.getAssignedTestCompositeKey().getUserId())){
					  filteredList.add(temp);
				  }
			}
		}
		return filteredList;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public String findUserTechSessionId(String userid,String techName,String testName) {
		Query query = em
				.createQuery("from AssignedTestUser atu where atu.assignedTestCompositeKey.userId=? and atu.assignedTestCompositeKey.techName=? and atu.assignedTestCompositeKey.testName=?");
		query.setParameter(1,userid);
		query.setParameter(2, techName);
		query.setParameter(3, testName);
		AssignedTestUser assignedTestUser = (AssignedTestUser) query
				.getSingleResult();
		return assignedTestUser.getUserSessionId();
	}
	
	

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<AvailableTest> findAllAvailableTest() {
		Query query = em.createQuery("from AvailableTest");
		return query.getResultList();
	}

	@Override
	public List<AvailableTest> findAllAvailableTestByUserId(String userid) {
		Query query = em.createQuery("from AvailableTest where lastModifyBy=?");
		query.setParameter(1, userid);
		return query.getResultList();
	}
	
	
	/**
	 * 
	 */
	@Override
	public  String findTestByUseridTechTestName(String userid,String techName,String testName) {
		Query query = em.createQuery("from AvailableTest where lastModifyBy=? and techName=? and testName=?");
		query.setParameter(1, userid);
		query.setParameter(2, techName);
		query.setParameter(3, testName);
		List<AvailableTest>  availableTests= query.getResultList();
		if(availableTests!=null && availableTests.size()>0){
			return "exist";
		}else{
			return "notexist";
		}
	}
	
	@Override
	public List<String> findTechListByUserid(String userid) {
		Query query = em.createQuery("select at.techName from AvailableTest as at where at.lastModifyBy=?");
		query.setParameter(1, userid);
		System.out.println("_________________@#&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		return (List<String>)query.getResultList();
	}
	
	@Override
	public List<AvailableTest> findAllAvailableTestByUserIdAndTechName(String userid,String techName) {
		Query query = em.createQuery("from AvailableTest where lastModifyBy=? and techName=?");
		query.setParameter(1, userid);
		query.setParameter(2, techName);
		return query.getResultList();
	}
	
	@Override
	public List<AvailableTest> findAllAvailableTestByTechName(String techName) {
		Query query = em.createQuery("from AvailableTest where  techName=?");
		query.setParameter(1, techName);
		return query.getResultList();
	}
	
	@Override
	public List<TrainingSessionsDetailEntity> findTrainingSessionDetailByUserid(String userid, String techId) {
		Query query=em.createQuery("from TrainingSessionsDetailEntity  where userid=? and technology=?");
		query.setParameter(1, userid);
		query.setParameter(2, techId);
		List<TrainingSessionsDetailEntity> trainingSessionsDetailEntity=(List<TrainingSessionsDetailEntity>)query.getResultList();
		return trainingSessionsDetailEntity;
		}
	
	@Override
	public TechnologyEntity findTechnologyEntityByTechName(String tname)
	{
		Query query1=em.createQuery("from TechnologyEntity where tname=?");
		query1.setParameter(1, tname);
		TechnologyEntity technologyEntity=(TechnologyEntity)query1.getSingleResult();
		return technologyEntity;
	}

	/**
	 * 
	 */
	@Override
	public  AvailableTest findAvailableTestTechTestName(String techName,String testName) {
		AvailableTest availableTest=new AvailableTest();
		Query query = em.createQuery("from AvailableTest where techName=? and testName=?");
		query.setParameter(1, techName);
		query.setParameter(2, testName);
		try {
			availableTest=(AvailableTest)query.getSingleResult();
		}catch(Exception ex){
			 System.out.println(ex.getMessage());
		}
		return availableTest;
	}

	/**
	 * @param testName
	 *            the name of testName for which all the questions are loaded.
	 * @return Object of {@link AvailableTest}
	 */
	@Override
	public AvailableTest fetchAllQuestionsByTestName(String testName,String techName,
			String userId,String userSessionId, boolean isTestResume) {
		Query query = em
				.createQuery("from AvailableTest as at where at.testName=? and at.techName=?");
		query.setParameter(1, testName);
		query.setParameter(2, techName);
		AvailableTest availableTest = null;
		AvailableTest availableTestTarget = new AvailableTest();
		try {
			availableTest = (AvailableTest) query.getSingleResult();
			BeanUtils.copyProperties(availableTest, availableTestTarget);
		} catch (Exception e) {
			if (logger.isErrorEnabled())
				logger.error(e.getMessage());
		}
		if (isTestResume) {
			// converting array of questionIds into the List of Ids
			// Exception in thread "main"
			// java.lang.UnsupportedOperationException
			// List<String>
			// listQuestionIds=Arrays.asList(availableTest.getQuestionIds().split(","));
			List<String> listQuestionIds = new ArrayList<String>(
					Arrays.asList(availableTest.getQuestionIds().split(",")));
			StringBuilder stringBuilder = new StringBuilder();
			List<UserExamDetailStatus> userExamDetailStatusList = resumeTestDataForUser(
					testName,techName, userId,userSessionId);
			int oldQcount = 0;
			for (UserExamDetailStatus userExamDetailStatus : userExamDetailStatusList) {
				oldQcount = oldQcount + 1;
				listQuestionIds.remove(userExamDetailStatus.getQuestionId());
			}
			int newQcount = 0;
			for (String questionId : listQuestionIds) {
				newQcount = newQcount + 1;
				stringBuilder.append(questionId + ",");
			}
			availableTestTarget.setQuestionIds(stringBuilder.toString());
			availableTestTarget.setTotalQuestions(newQcount);
		}
		return availableTestTarget;
	}

	/**
	 * 
	 * @param testName
	 * @param userId
	 * @return
	 * 
	 */
	private List<UserExamDetailStatus> resumeTestDataForUser(String testName,String techName,
			String userId,String userSessionId) {
		Query query = em
				.createQuery("from UserExamDetailStatus as  ueds  where ueds.techName=? and ueds.testName=? and ueds.userId=? and ueds.userSessionId=?");
		query.setParameter(1, techName);
		query.setParameter(2, testName);
		query.setParameter(3, userId);
		query.setParameter(4, userSessionId);
		List<UserExamDetailStatus> userExamDetailStatusList = query
				.getResultList();
		return userExamDetailStatusList;
	}
	
	/**
	 * 
	 * @param techName
	 * @param testName
	 * @return
	 */
	@Override
	public List<QuestionAndAnsTestDataVO> findQuestionsAnswersByTechTest(String techName,String testName) {
		List<QuestionAndAnsTestDataVO> questionAndAnsTestDataVOs=new ArrayList<QuestionAndAnsTestDataVO>();
		Query tquery = em
				.createQuery("from AvailableTest as at where at.testName=? and at.techName=?");
		tquery.setParameter(1, testName);
		tquery.setParameter(2, techName);
		AvailableTest  availableTest = (AvailableTest) tquery.getSingleResult();
		String questionsId[]=availableTest.getQuestionIds().split(",");
		
		for(String questionId : questionsId){ 
			QuestionAndAnsTestDataVO questionAndAnsTestDataVO=new QuestionAndAnsTestDataVO();
			questionId=questionId.trim();
			Query cquery = em
					.createQuery("from Questions que where que.questionId=?");
			cquery.setParameter(1, questionId);
			List<Questions> questionsList = cquery.getResultList();
			if (questionsList != null && questionsList.size() == 1) {
				questionAndAnsTestDataVO.setTopic(questionsList.get(0).getTopic());
				questionAndAnsTestDataVO.setTechnology(questionsList.get(0).getTechnology());
				questionAndAnsTestDataVO.setQuestionComplexity(questionsList.get(0).getQuestionComplexity());
				questionAndAnsTestDataVO.setCorrectAnsDescription(questionsList.get(0).getDescription());
			}else{
				OnlineTechException onlineTechException=new OnlineTechException("Sorry!  this test is no longer valid , please contact to test adminstrator.");
				throw onlineTechException;
			}

			Query query = em
					.createQuery("from AssignedQuestionAnswers aqa where aqa.questionId=?");
			query.setParameter(1, questionId);
			List<AssignedQuestionAnswers> assignedQuestionAnswersList = query
					.getResultList();
			//We are uploading questions and answer with excel sheet where first entry is always right answer
			////please remember
			//if(assignedQuestionAnswersList!=null)
			//Query bankquery = em
					//.createQuery("from QuestionsBankEntity qbe where qbe.qbankname=? and qbe.techName=?");
		//	bankquery.setParameter(1, qbankName);
			//bankquery.setParameter(2, techName);
			//QuestionsBankEntity ebankEntity=null;
			///try {
			// ebankEntity= (QuestionsBankEntity)bankquery.getSingleResult();
			//}catch(Exception ex){
				// System.out.println("Error = "+ex.getMessage());
			//}
			//Question's Answers should be shuffle only for those questions which are uploaded throuh excel sheet  
			//if(ebankEntity!=null && ebankEntity.getExcelSheetName()!=null && ebankEntity.getExcelSheetName().length()>0 )
			//Collections.shuffle(assignedQuestionAnswersList);
			
			// ################Here we can write logic to randomize questions and
			// answers######
			int noOfOptions = assignedQuestionAnswersList != null ? assignedQuestionAnswersList
					.size() : 0;

			questionAndAnsTestDataVO.setNoOfOptions(noOfOptions);

			questionAndAnsTestDataVO.setQuestionId(assignedQuestionAnswersList.get(
					0).getQuestionId());
			questionAndAnsTestDataVO.setQuestionText(assignedQuestionAnswersList
					.get(0).getQuestions().getQuestionText());

			// Setting information of answerId1
			questionAndAnsTestDataVO.setAnswerId1(assignedQuestionAnswersList
					.get(0).getAnswerId());
			Query query1 = em.createQuery("from Answers ans where ans.answerId=?");
			query1.setParameter(1, assignedQuestionAnswersList.get(0).getAnswerId());
			Answers answers1 = (Answers) query1.getSingleResult();
			String ansText1 = answers1.getAnswerText();
			questionAndAnsTestDataVO.setAnswerText1(ansText1);
			if (assignedQuestionAnswersList.get(0).getAnswerStatus()
					.equalsIgnoreCase("R")) {
				questionAndAnsTestDataVO.setCorrectOption(answers1.getAnswerId());
				questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(0).getDescription());
			}

			// Setting information of answerId2
			if (assignedQuestionAnswersList.size() > 1) {
				questionAndAnsTestDataVO.setAnswerId2(assignedQuestionAnswersList
						.get(1).getAnswerId());
				Query query2 = em
						.createQuery("from Answers ans where ans.answerId=?");
				query2.setParameter(1, assignedQuestionAnswersList.get(1)
						.getAnswerId());
				Answers answers2 = (Answers) query2.getSingleResult();
				String ansText2 = answers2.getAnswerText();
				questionAndAnsTestDataVO.setAnswerText2(ansText2);
				if (assignedQuestionAnswersList.get(1).getAnswerStatus()
						.equalsIgnoreCase("R")) {
					questionAndAnsTestDataVO.setCorrectOption(answers2
							.getAnswerId());
					questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(1).getDescription());
				}
			}

			// Setting information of answerId3
			if (assignedQuestionAnswersList.size() > 2) {
				questionAndAnsTestDataVO.setAnswerId3(assignedQuestionAnswersList
						.get(2).getAnswerId());
				Query query3 = em
						.createQuery("from Answers ans where ans.answerId=?");
				query3.setParameter(1, assignedQuestionAnswersList.get(2)
						.getAnswerId());
				Answers answers3 = (Answers) query3.getSingleResult();
				String ansText3 = answers3.getAnswerText();
				questionAndAnsTestDataVO.setAnswerText3(ansText3);
				if (assignedQuestionAnswersList.get(2).getAnswerStatus()
						.equalsIgnoreCase("R")) {
					questionAndAnsTestDataVO.setCorrectOption(answers3
							.getAnswerId());
					questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(2).getDescription());
				}
			}

			// Setting information of answerId4
			if (assignedQuestionAnswersList.size() > 3) {
				questionAndAnsTestDataVO.setAnswerId4(assignedQuestionAnswersList
						.get(3).getAnswerId());
				Query query4 = em
						.createQuery("from Answers ans where ans.answerId=?");
				query4.setParameter(1, assignedQuestionAnswersList.get(3)
						.getAnswerId());
				Answers answers4 = (Answers) query4.getSingleResult();
				String ansText4 = answers4.getAnswerText();
				questionAndAnsTestDataVO.setAnswerText4(ansText4);
				if (assignedQuestionAnswersList.get(3).getAnswerStatus()
						.equalsIgnoreCase("R")) {
					questionAndAnsTestDataVO.setCorrectOption(answers4
							.getAnswerId());
					questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(3).getDescription());
				}
			}

			// Setting information of answerId5
			if (assignedQuestionAnswersList.size() > 4) {
				questionAndAnsTestDataVO.setAnswerId5(assignedQuestionAnswersList
						.get(4).getAnswerId());
				Query query5 = em
						.createQuery("from Answers ans where ans.answerId=?");
				query5.setParameter(1, assignedQuestionAnswersList.get(4)
						.getAnswerId());
				Answers answers5 = (Answers) query5.getSingleResult();
				String ansText5 = answers5.getAnswerText();
				questionAndAnsTestDataVO.setAnswerText5(ansText5);
				if (assignedQuestionAnswersList.get(4).getAnswerStatus()
						.equalsIgnoreCase("R")) {
					questionAndAnsTestDataVO.setCorrectOption(answers5
							.getAnswerId());
					questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(4).getDescription());
				}
			}
			// Setting information of answerId6
			if (assignedQuestionAnswersList.size() > 5) {
				questionAndAnsTestDataVO.setAnswerId6(assignedQuestionAnswersList
						.get(5).getAnswerId());
				Query query6 = em
						.createQuery("from Answers ans where ans.answerId=?");
				query6.setParameter(1, assignedQuestionAnswersList.get(5)
						.getAnswerId());
				Answers answers6 = (Answers) query6.getSingleResult();
				String ansText6 = answers6.getAnswerText();
				questionAndAnsTestDataVO.setAnswerText6(ansText6);
				if (assignedQuestionAnswersList.get(5).getAnswerStatus()
						.equalsIgnoreCase("R")) {
					questionAndAnsTestDataVO.setCorrectOption(answers6
							.getAnswerId());
					questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(5).getDescription());
				}
			}
			// Setting information of answerId7
			if (assignedQuestionAnswersList.size() > 6) {
				questionAndAnsTestDataVO.setAnswerId7(assignedQuestionAnswersList
						.get(6).getAnswerId());
				Query query7 = em
						.createQuery("from Answers ans where ans.answerId=?");
				query7.setParameter(1, assignedQuestionAnswersList.get(6)
						.getAnswerId());
				Answers answers7 = (Answers) query7.getSingleResult();
				String ansText7 = answers7.getAnswerText();
				questionAndAnsTestDataVO.setAnswerText7(ansText7);
				if (assignedQuestionAnswersList.get(6).getAnswerStatus()
						.equalsIgnoreCase("R")) {
					questionAndAnsTestDataVO.setCorrectOption(answers7
							.getAnswerId());
					questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(6).getDescription());
				}
			}

			questionAndAnsTestDataVO.setChoiceType(assignedQuestionAnswersList.get(
					1).getChoiceType());
			questionAndAnsTestDataVO.setDescription(assignedQuestionAnswersList
					.get(1).getQuestions().getDescription());
			questionAndAnsTestDataVOs.add(questionAndAnsTestDataVO);
			
		}
		return questionAndAnsTestDataVOs;
	}

	@Override
	public QuestionAndAnsTestDataVO fetchNextQuestionAnswer(String questionId,String userid,String testName,String techName,String userSessionId){
		
		//finding the selected option for user if selected the answer already
		//in case of jump to the questions
		QuestionAndAnsTestDataVO questionAndAnsTestDataVO = new QuestionAndAnsTestDataVO();
		
		Query squery = em
				.createQuery("from UserExamDetailStatus as  ueds  where ueds.testName=? and ueds.techName=? and ueds.userId=? and ueds.questionId=? and ueds.userSessionId=?");
		squery.setParameter(1, testName);
		squery.setParameter(2, techName);
		squery.setParameter(3, userid);
		//squery.setParameter(4, noOfAttemts);
		squery.setParameter(4, questionId);
		squery.setParameter(5, userSessionId);
		
		try {
		  UserExamDetailStatus userExamDetailStatusList =(UserExamDetailStatus) squery.getSingleResult();
		  questionAndAnsTestDataVO.setSelectedOption(userExamDetailStatusList.getSelectedAnswerId());
		}catch(NoResultException noResultException){
			//noResultException.printStackTrace();
			System.out.println(noResultException.getMessage());
			questionAndAnsTestDataVO.setSelectedOption("NOAID");
		}
		
		String qbankName="";
		Query cquery = em
				.createQuery("from Questions que where que.questionId=?");
		cquery.setParameter(1, questionId);
		List<Questions> questionsList = cquery.getResultList();
		if (questionsList != null && questionsList.size() == 1) {
			qbankName=questionsList.get(0).getQbankName();
			questionAndAnsTestDataVO.setTopic(questionsList.get(0).getTopic());
			questionAndAnsTestDataVO.setTechnology(questionsList.get(0).getTechnology());
			questionAndAnsTestDataVO.setQuestionComplexity(questionsList.get(0).getQuestionComplexity());
			questionAndAnsTestDataVO.setCorrectAnsDescription(questionsList.get(0).getDescription());
		}else{
			OnlineTechException onlineTechException=new OnlineTechException("Sorry!  this test is no longer valid , please contact to test adminstrator.");
			throw onlineTechException;
		}

		Query query = em
				.createQuery("from AssignedQuestionAnswers aqa where aqa.questionId=?");
		query.setParameter(1, questionId);
		List<AssignedQuestionAnswers> assignedQuestionAnswersList = query
				.getResultList();
		
		//We are uploading questions and answer with excel sheet where first entry is always right answer
		////please remember
		//if(assignedQuestionAnswersList!=null)
		Query bankquery = em
				.createQuery("from QuestionsBankEntity qbe where qbe.qbankname=? and qbe.techName=?");
		bankquery.setParameter(1, qbankName);
		bankquery.setParameter(2, techName);
		QuestionsBankEntity ebankEntity=null;
		try {
		 ebankEntity= (QuestionsBankEntity)bankquery.getSingleResult();
		}catch(Exception ex){
			 System.out.println("Error = "+ex.getMessage());
		}
		//Question's Answers should be shuffle only for those questions which are uploaded throuh excel sheet  
		if(ebankEntity!=null && ebankEntity.getExcelSheetName()!=null && ebankEntity.getExcelSheetName().length()>0 )
		Collections.shuffle(assignedQuestionAnswersList);
		
		// ################Here we can write logic to randomize questions and
		// answers######
		int noOfOptions = assignedQuestionAnswersList != null ? assignedQuestionAnswersList
				.size() : 0;

		questionAndAnsTestDataVO.setNoOfOptions(noOfOptions);

		questionAndAnsTestDataVO.setQuestionId(assignedQuestionAnswersList.get(
				0).getQuestionId());
		questionAndAnsTestDataVO.setQuestionText(assignedQuestionAnswersList
				.get(0).getQuestions().getQuestionText());

		// Setting information of answerId1
		questionAndAnsTestDataVO.setAnswerId1(assignedQuestionAnswersList
				.get(0).getAnswerId());
		Query query1 = em.createQuery("from Answers ans where ans.answerId=?");
		query1.setParameter(1, assignedQuestionAnswersList.get(0).getAnswerId());
		Answers answers1 = (Answers) query1.getSingleResult();
		String ansText1 = answers1.getAnswerText();
		questionAndAnsTestDataVO.setAnswerText1(ansText1);
		if (assignedQuestionAnswersList.get(0).getAnswerStatus()
				.equalsIgnoreCase("R")) {
			questionAndAnsTestDataVO.setCorrectOption(answers1.getAnswerId());
			questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(0).getDescription());
		}

		// Setting information of answerId2
		if (assignedQuestionAnswersList.size() > 1) {
			questionAndAnsTestDataVO.setAnswerId2(assignedQuestionAnswersList
					.get(1).getAnswerId());
			Query query2 = em
					.createQuery("from Answers ans where ans.answerId=?");
			query2.setParameter(1, assignedQuestionAnswersList.get(1)
					.getAnswerId());
			Answers answers2 = (Answers) query2.getSingleResult();
			String ansText2 = answers2.getAnswerText();
			questionAndAnsTestDataVO.setAnswerText2(ansText2);
			if (assignedQuestionAnswersList.get(1).getAnswerStatus()
					.equalsIgnoreCase("R")) {
				questionAndAnsTestDataVO.setCorrectOption(answers2
						.getAnswerId());
				questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(1).getDescription());
			}
		}

		// Setting information of answerId3
		if (assignedQuestionAnswersList.size() > 2) {
			questionAndAnsTestDataVO.setAnswerId3(assignedQuestionAnswersList
					.get(2).getAnswerId());
			Query query3 = em
					.createQuery("from Answers ans where ans.answerId=?");
			query3.setParameter(1, assignedQuestionAnswersList.get(2)
					.getAnswerId());
			Answers answers3 = (Answers) query3.getSingleResult();
			String ansText3 = answers3.getAnswerText();
			questionAndAnsTestDataVO.setAnswerText3(ansText3);
			if (assignedQuestionAnswersList.get(2).getAnswerStatus()
					.equalsIgnoreCase("R")) {
				questionAndAnsTestDataVO.setCorrectOption(answers3
						.getAnswerId());
				questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(2).getDescription());
			}
		}

		// Setting information of answerId4
		if (assignedQuestionAnswersList.size() > 3) {
			questionAndAnsTestDataVO.setAnswerId4(assignedQuestionAnswersList
					.get(3).getAnswerId());
			Query query4 = em
					.createQuery("from Answers ans where ans.answerId=?");
			query4.setParameter(1, assignedQuestionAnswersList.get(3)
					.getAnswerId());
			Answers answers4 = (Answers) query4.getSingleResult();
			String ansText4 = answers4.getAnswerText();
			questionAndAnsTestDataVO.setAnswerText4(ansText4);
			if (assignedQuestionAnswersList.get(3).getAnswerStatus()
					.equalsIgnoreCase("R")) {
				questionAndAnsTestDataVO.setCorrectOption(answers4
						.getAnswerId());
				questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(3).getDescription());
			}
		}

		// Setting information of answerId5
		if (assignedQuestionAnswersList.size() > 4) {
			questionAndAnsTestDataVO.setAnswerId5(assignedQuestionAnswersList
					.get(4).getAnswerId());
			Query query5 = em
					.createQuery("from Answers ans where ans.answerId=?");
			query5.setParameter(1, assignedQuestionAnswersList.get(4)
					.getAnswerId());
			Answers answers5 = (Answers) query5.getSingleResult();
			String ansText5 = answers5.getAnswerText();
			questionAndAnsTestDataVO.setAnswerText5(ansText5);
			if (assignedQuestionAnswersList.get(4).getAnswerStatus()
					.equalsIgnoreCase("R")) {
				questionAndAnsTestDataVO.setCorrectOption(answers5
						.getAnswerId());
				questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(4).getDescription());
			}
		}
		// Setting information of answerId6
		if (assignedQuestionAnswersList.size() > 5) {
			questionAndAnsTestDataVO.setAnswerId6(assignedQuestionAnswersList
					.get(5).getAnswerId());
			Query query6 = em
					.createQuery("from Answers ans where ans.answerId=?");
			query6.setParameter(1, assignedQuestionAnswersList.get(5)
					.getAnswerId());
			Answers answers6 = (Answers) query6.getSingleResult();
			String ansText6 = answers6.getAnswerText();
			questionAndAnsTestDataVO.setAnswerText6(ansText6);
			if (assignedQuestionAnswersList.get(5).getAnswerStatus()
					.equalsIgnoreCase("R")) {
				questionAndAnsTestDataVO.setCorrectOption(answers6
						.getAnswerId());
				questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(5).getDescription());
			}
		}
		// Setting information of answerId7
		if (assignedQuestionAnswersList.size() > 6) {
			questionAndAnsTestDataVO.setAnswerId7(assignedQuestionAnswersList
					.get(6).getAnswerId());
			Query query7 = em
					.createQuery("from Answers ans where ans.answerId=?");
			query7.setParameter(1, assignedQuestionAnswersList.get(6)
					.getAnswerId());
			Answers answers7 = (Answers) query7.getSingleResult();
			String ansText7 = answers7.getAnswerText();
			questionAndAnsTestDataVO.setAnswerText7(ansText7);
			if (assignedQuestionAnswersList.get(6).getAnswerStatus()
					.equalsIgnoreCase("R")) {
				questionAndAnsTestDataVO.setCorrectOption(answers7
						.getAnswerId());
				questionAndAnsTestDataVO.setCorrectAnsDescription(assignedQuestionAnswersList.get(6).getDescription());
			}
		}

		questionAndAnsTestDataVO.setChoiceType(assignedQuestionAnswersList.get(
				1).getChoiceType());
		questionAndAnsTestDataVO.setDescription(assignedQuestionAnswersList
				.get(1).getQuestions().getDescription());

		return questionAndAnsTestDataVO;
	}

	@Override
	public int findNoOfAttemptsForCurrentTest(String testName,String techName, String userid) {
		String totalCorrectAnswer = "SELECT max(ueds.noOfAttemts) FROM UserExamDetailStatus ueds where ueds.testName=? and ueds.techName=? and ueds.userId=?";
		Query query = em.createQuery(totalCorrectAnswer);
		query.setParameter(1, testName);
		query.setParameter(2, techName);
		query.setParameter(3, userid);
		int totalMaxAtt = 0;
		Number countResult = (Number) query.getSingleResult();
		totalMaxAtt = countResult == null ? 0 : countResult.intValue();
		totalMaxAtt++;
		return totalMaxAtt;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserOnlineExamStatus submitTechAnswerForQuestion(
			UserExamDetailStatus userExamDetailStatus, boolean isTestDone) {
		
		//just checking weather question is already attempted or not
		Query query=em.createQuery("from UserExamDetailStatus as ueds where ueds.questionId=? and ueds.testName=? and ueds.techName=? and ueds.userId=? and userSessionId=?");
		query.setParameter(1,userExamDetailStatus.getQuestionId());
		query.setParameter(2,userExamDetailStatus.getTestName());
		query.setParameter(3,userExamDetailStatus.getTechName());
		query.setParameter(4,userExamDetailStatus.getUserId());
		query.setParameter(5,userExamDetailStatus.getUserSessionId());
			if(userExamDetailStatus.getWeightage()!=null && "yes".equalsIgnoreCase(userExamDetailStatus.getWeightage())){
				try {
				Query query7 = em.createQuery("from Answers ans where ans.answerId=?");
				query7.setParameter(1, userExamDetailStatus.getSelectedAnswerId());
				Answers answers7 = (Answers) query7.getSingleResult();
				//This is marks......
					String desc=answers7.getDescription();//marks
					//String text=answers7.getAnswerText(); //answertext
					//since this text is fixed!!!!!!!!!!!
					Questions questions=findQuestionSetByQuestionId(userExamDetailStatus.getQuestionId());
					String pcategory=questions.getCategory();
					//setting the values now
					int num=0;
					try {
						num=Integer.parseInt(desc);
					}catch(Exception ex){
						
					}
					userExamDetailStatus.setCorrectAnswerCount(num);
					userExamDetailStatus.setDescription(pcategory);
					
				}catch(Exception ex){
					RuntimeException runtimeException=new RuntimeException("Problem occures during processing of weightage question!");
					throw runtimeException;
				}
			}
		try {
		   UserExamDetailStatus examDetailStatus=(UserExamDetailStatus)query.getSingleResult();
		   userExamDetailStatus.setId(examDetailStatus.getId());
		   em.merge(userExamDetailStatus);
		  // BeanUtils.cop
		}catch(Exception nonUniqueResultException){
			// here we have set no of attempts
			//means record is not present inside the database since questions is attempted
			//first time.
			em.persist(userExamDetailStatus);
		}
		
		if (isTestDone) {
			return genarateSummaryForTest(userExamDetailStatus);
		}
		return null;
	}
	
	/*This method is written to get test details in order to send mail after completing the test
	 * 
	 * */
	public UserOnlineExamStatus sendCompleteTestEmailDao(UserExamDetailStatus userExamDetailStatus) {
		Query query=em.createQuery("from UserExamDetailStatus as ueds where ueds.questionId=? and ueds.testName=? and ueds.techName=? and ueds.userId=? and userSessionId=?");
		query.setParameter(1,userExamDetailStatus.getQuestionId());
		query.setParameter(2,userExamDetailStatus.getTestName());
		query.setParameter(3,userExamDetailStatus.getTechName());
		query.setParameter(4,userExamDetailStatus.getUserId());
		query.setParameter(5,userExamDetailStatus.getUserSessionId());
		UserOnlineExamStatus userOnlineExamStatus=(UserOnlineExamStatus)query.getSingleResult();
		   return userOnlineExamStatus;
}
	
	
	
	
	

	/**
	 * This method generate the summary for the user once test is completed.
	 * 
	 * @param userExamDetailStatus
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public UserOnlineExamStatus genarateSummaryForTest(
			UserExamDetailStatus userExamDetailStatus) {
		UserOnlineExamStatus userOnlineExamStatus = new UserOnlineExamStatus();
		userOnlineExamStatus.setUserSessionId(userExamDetailStatus.getUserSessionId());

		// Finding total number of questions attempted correctly.
		String totalCorrectAnswer = "SELECT sum(ueds.correctAnswerCount) FROM UserExamDetailStatus ueds where ueds.testName=? and ueds.techName=?  and ueds.userId=? and ueds.userSessionId=?";
		Query query = em.createQuery(totalCorrectAnswer);
		query.setParameter(1, userExamDetailStatus.getTestName());
		query.setParameter(2, userExamDetailStatus.getTechName());
		query.setParameter(3, userExamDetailStatus.getUserId());
		query.setParameter(4, userExamDetailStatus.getUserSessionId());
		int totalNoCorrectAnswer = 0;
		try {
			Number countResult = (Number) query.getSingleResult();
			totalNoCorrectAnswer = countResult == null ? 0 : countResult
					.intValue();
		} catch (NonUniqueResultException e) {
			if (logger.isErrorEnabled()) {
				logger.error(e.getMessage(), e);
			}
		}

		// Finding total number of questions attempted.
		String totalQuestionsAttempted = "SELECT count(*) FROM UserExamDetailStatus ueds where ueds.testName=? and ueds.techName=? and ueds.userId=? and ueds.userSessionId=?";
		Query query1 = em.createQuery(totalQuestionsAttempted);
		query1.setParameter(1, userExamDetailStatus.getTestName());
		query1.setParameter(2, userExamDetailStatus.getTechName());
		query1.setParameter(3, userExamDetailStatus.getUserId());
		query1.setParameter(4, userExamDetailStatus.getUserSessionId());
		int totalNoQuestionsAttempted = 0;
		try {
			Number countResult = (Number) query1.getSingleResult();
			totalNoQuestionsAttempted = countResult == null ? 0 : countResult
					.intValue();
		} catch (NonUniqueResultException e) {
			if (logger.isErrorEnabled()) {
				logger.error(e.getMessage(), e);
			}
		}
		// Setting the into the entity before persisting into the database
		userOnlineExamStatus
				.setDateOfTest(userExamDetailStatus.getDateOfTest());
		userOnlineExamStatus.setDescription(userExamDetailStatus
				.getDescription());
		userOnlineExamStatus
				.setExamStatus(userExamDetailStatus.getTestStatus());
		// assuming one mark for one question
		// we can modify it in future when marks are different for different
		// questions.
		userOnlineExamStatus.setSecureMarks(totalNoCorrectAnswer);
		userOnlineExamStatus.setTestName(userExamDetailStatus.getTestName());
		userOnlineExamStatus.setTotalCorrectAnswer(totalNoCorrectAnswer);

		// Fetch total number of marks for this test.
		int totalQuestions=0;
		if(ApplicationContant.GUEST_ROLE.equalsIgnoreCase(userExamDetailStatus.getRole())) {
			Query  availableGuestTestQuery= em
					.createQuery("from AvailableGuestTest as at where at.testName=? and at.techName=?");
			availableGuestTestQuery.setParameter(1, userExamDetailStatus.getTestName());
			availableGuestTestQuery.setParameter(2, userExamDetailStatus.getTechName());
			AvailableGuestTest  availableGuestTest   = (AvailableGuestTest) availableGuestTestQuery.getSingleResult();
			totalQuestions=availableGuestTest.getTotalQuestions();
		}
		else{ 	
		Query query2 = em
				.createQuery("from AvailableTest as at where at.testName=? and at.techName=?");
					query2.setParameter(1, userExamDetailStatus.getTestName());
					query2.setParameter(2, userExamDetailStatus.getTechName());
					AvailableTest availableTest = (AvailableTest) query2.getSingleResult();
					totalQuestions=availableTest.getTotalQuestions();	
		}

		// Assuming 1 mark for each question
		userOnlineExamStatus.setTotalMarks(totalQuestions);
		userOnlineExamStatus
				.setTotalNoAnsweredQuestion(totalNoQuestionsAttempted);
		userOnlineExamStatus.setTotalNoQuestion(totalQuestions);
		userOnlineExamStatus.setTotalWrongAnswer(totalNoQuestionsAttempted
				- totalNoCorrectAnswer);
		userOnlineExamStatus.setUserId(userExamDetailStatus.getUserId());
		userOnlineExamStatus.setNoOfAttemts(userExamDetailStatus
				.getNoOfAttemts());
		userOnlineExamStatus.setTechName(userExamDetailStatus.getTechName());
		//userOnlineExamStatus.setTechName(userExamDetailStatus.getTechName());
		em.persist(userOnlineExamStatus);

		// Updating status and userSessionId for assigned_test_user_tbl 
		if(ApplicationContant.GUEST_ROLE.equalsIgnoreCase(userExamDetailStatus.getRole())) {
					GuestUserEntity guestUserEntity=new GuestUserEntity();
					String hql="from GuestUserEntity as u where u.email=:pemail and u.generatedTestLink=:ptestLink";
					Query questExamStatusQuery = em.createQuery(hql);
					questExamStatusQuery.setParameter("pemail", userExamDetailStatus.getUserId());
					System.out.println("ptestLink = "+userExamDetailStatus.getTestLink());
					questExamStatusQuery.setParameter("ptestLink", userExamDetailStatus.getTestLink());
					List<GuestUserEntity> guestUserEntityList = (List<GuestUserEntity>) questExamStatusQuery.getResultList();
					if(guestUserEntityList!=null && guestUserEntityList.size()>0){
							guestUserEntity= guestUserEntityList.get(0);
					}
					guestUserEntity.setTestStatus(ApplicationContant.COMPLETE_EXAM_STATUS);
		}else {
					Query query3 = em
							.createQuery("from AssignedTestUser atu where atu.assignedTestCompositeKey.userId=? and atu.assignedTestCompositeKey.techName=? and atu.assignedTestCompositeKey.testName=?");
					query3.setParameter(1, userExamDetailStatus.getUserId());
					query3.setParameter(2, userExamDetailStatus.getTechName());
					query3.setParameter(3, userExamDetailStatus.getTestName());
					AssignedTestUser assignedTestUser = (AssignedTestUser) query3
							.getSingleResult();
					//PLEASE LOOK INTO THIS @ 07-06-2018
					assignedTestUser.setTestStatus(ApplicationContant.COMPLETE_EXAM_STATUS);
					assignedTestUser.setUserSessionId(null);
		}

		// ///delete data from user_exam_progress_data_tbl
		Query query4 = em
				.createQuery("delete from UserExamProgressData uepd where uepd.userId=? and uepd.testName=? and uepd.techName=?");
		query4.setParameter(1, userExamDetailStatus.getUserId());
		query4.setParameter(2, userExamDetailStatus.getTestName());
		query4.setParameter(3, userExamDetailStatus.getTechName());
		int p = query4.executeUpdate();
		if (logger.isDebugEnabled())
			logger.debug(p
					+ " record is deleted from user_exam_progress_data_tbl for user = "
					+ userExamDetailStatus.getUserId());
		return userOnlineExamStatus;
	}

	@Override
	public List<AssignedTestUser> findAssignedTestByUserId(String userId) {
		Query query = em
				.createQuery("from AssignedTestUser atu where atu.assignedTestCompositeKey.userId=? and atu.active=?");
		query.setParameter(1, userId);
		query.setParameter(2,"YES");
		List<AssignedTestUser> assignedTestList = query.getResultList();
		return assignedTestList;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String pushProgressDataForUser(
			UserExamProgressData userExamProgressData) {
		em.persist(userExamProgressData);
		updateTestStatusProgress(userExamProgressData);
		return ApplicationContant.SUCCESS;
	}

	/**
	 * method will update the testStatus column assigned_test_user_tbl as
	 * progress since test is started now.
	 * 
	 * @param data
	 */
	private void updateTestStatusProgress(UserExamProgressData data) {
		Query query = em
				.createQuery("update AssignedTestUser as atu set atu.testStatus=?,atu.userSessionId=? where atu.assignedTestCompositeKey.userId=? and atu.assignedTestCompositeKey.techName=? and atu.assignedTestCompositeKey.testName=?");
		query.setParameter(1, ApplicationContant.IN_PROGRESS);
		query.setParameter(2, data.getUserSessionId());
		query.setParameter(3, data.getUserId());
		query.setParameter(4, data.getTechName());
		query.setParameter(5, data.getTestName());
		int p = query.executeUpdate();
		if (logger.isDebugEnabled()) {
			logger.debug("p = "
					+ p
					+ "status is update as In Progress for table = assigned_test_user_tbl"
					+ " for user " + data.getUserId());
		}
	}

	@Override
	public String findEmailIdByUserId(String userid) {
		Query query2 = em.createQuery("from User as u where u.loginid=?");
		query2.setParameter(1, userid);
		User user = (User) query2.getSingleResult();
		return user.getEmail();
	}
	
	@Override
	public String findEmailIdByConsultantId(String consultantId) {
		Query query2 = em.createQuery("from ConsultantsEntity as ce where ce.userid=?");
		query2.setParameter(1, consultantId);
		ConsultantsEntity user = (ConsultantsEntity) query2.getSingleResult();
		return user.getEmail();
	}

	@Override
	public UserExamDetailStatus findExamDetail(String userid, String testName,String techName,
			String userSessionId, String QuestionId) {
		Query query = em
				.createQuery("from UserExamDetailStatus as d where d.userId=? and d.testName=? and d.techName=?  and d.questionId=? and userSessionId=?");
		query.setParameter(1, userid);
		query.setParameter(2, testName);
		query.setParameter(3, techName);
		//query.setParameter(4, noOfAttempt);
		query.setParameter(4, QuestionId);
		query.setParameter(5, userSessionId);
		// UserExamDetailStatus detail = (UserExamDetailStatus)
		// query.getSingleResult();
		UserExamDetailStatus  userExamDetailStatus=null;
		try {
			  userExamDetailStatus=(UserExamDetailStatus) query.getSingleResult();
		}catch(NoResultException noResultException){
			//noResultException.printStackTrace();
			 System.out.println("Error ="+noResultException.getMessage());
			userExamDetailStatus=new UserExamDetailStatus();
		}catch(NonUniqueResultException nonUniqueResultException){
			nonUniqueResultException.printStackTrace();
		}
		return userExamDetailStatus;
	}
	
	
	
	@Override
	public String updateAssignedTestStatus(String groupName,String techName,String testName,String cstatus){
		 Query uquery=em.createQuery("update AssignedTestUser as atest set atest.active=?  where atest.groupName=? and atest.assignedTestCompositeKey.techName=? and atest.assignedTestCompositeKey.testName=?");
		 uquery.setParameter(1, cstatus);
		 uquery.setParameter(2, groupName);
		 uquery.setParameter(3, techName);
		 uquery.setParameter(4, testName);
		 //Updating the test status
		 uquery.executeUpdate();
		
		 return "success";
	}
	
	@Override
	public List<AssignedTestUser> findAllAssignedTests(String groupName){
		 List<AssignedTestUser> assignedTestUsersList=new ArrayList<>();
		 Query query=em.createQuery("from AssignedTestUser as atest where atest.groupName='"+groupName+"'");
		 query.setMaxResults(2);
		 List<AssignedTestUser>  userIdList=(List<AssignedTestUser>)query.getResultList();
		 if(userIdList!=null && userIdList.size()>0) {
			 Query squery=em.createQuery("from AssignedTestUser as atest where atest.assignedTestCompositeKey.userId='"+userIdList.get(0).getAssignedTestCompositeKey().getUserId()+"'");
			 assignedTestUsersList=squery.getResultList();
		 }
		 return assignedTestUsersList;
	}

	@Override
	public void addAssignedTest(AssignedTestUser assignedTest) {
		// let us write code here
		AvailableTest availableTest=null;
		if(assignedTest!=null ) {
			 Query query=em.createQuery("from AvailableTest as atest where atest.testName='"+assignedTest.getAssignedTestCompositeKey().getTestName()+"' and atest.techName='"+assignedTest.getAssignedTestCompositeKey().getTechName()+"'");
			 availableTest=(AvailableTest)query.getSingleResult();
		}
		AssignedTestUser assignedTestUser = em.find(AssignedTestUser.class,
				assignedTest.getAssignedTestCompositeKey());
		if (assignedTestUser == null) {
			assignedTest.setNumberOfQuestions(availableTest.getTotalQuestions());
			assignedTest.setDurationInMin(availableTest.getTestDuration());
			assignedTest.setLocked("unlocked");
			assignedTest.setTestExpireOn(new Timestamp(new Date().getTime()).toString());
			assignedTest.setTestExpireTimeInHrs(1000);
			assignedTest.setResetDate(new Date());
			em.persist(assignedTest);
		} else {
			if(availableTest!=null) {
				assignedTestUser.setNumberOfQuestions(availableTest.getTotalQuestions());
				assignedTestUser.setDurationInMin(availableTest.getTestDuration());
			}
			assignedTestUser.setTestStatus(ApplicationContant.NOT_STARTED);
			assignedTestUser.setAssignDate(new Date());
			assignedTest.setResetDate(new Date());
			assignedTestUser.setAttamptLimit(1);
			assignedTestUser.setGroupName(assignedTest.getGroupName());
			assignedTestUser.setLink(assignedTest.getLink());
		}
	}

	@Override
	public String unassignedTestToUser(String userid,String techName,String testName) {
		Query query = em
				.createQuery("delete from AssignedTestUser atu where atu.assignedTestCompositeKey.userId=? and atu.assignedTestCompositeKey.techName=? and atu.assignedTestCompositeKey.testName=?");
		query.setParameter(1, userid);
		query.setParameter(2, techName);
		query.setParameter(3, testName);
		int p = query.executeUpdate();
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	public void assignedTestToUsers(List<AssignedTestUser> assignedTestUsersList) {
		AvailableTest availableTest=null;
		if(assignedTestUsersList!=null && assignedTestUsersList.size()>0) {
			 Query query=em.createQuery("from AvailableTest as atest where atest.testName='"+assignedTestUsersList.get(0).getAssignedTestCompositeKey().getTestName()+"' and atest.techName='"+assignedTestUsersList.get(0).getAssignedTestCompositeKey().getTechName()+"'");
			 availableTest=(AvailableTest)query.getSingleResult();
		}
		//creating an obj of AssignedTestUser and iterating it thr the records
		for (AssignedTestUser assignedTestUser : assignedTestUsersList) {
			// let us write code here
			AssignedTestUser dassignedTestUser = em.find(AssignedTestUser.class,
					assignedTestUser.getAssignedTestCompositeKey());
			if (dassignedTestUser == null) {	
				assignedTestUser.setNumberOfQuestions(availableTest.getTotalQuestions());
				assignedTestUser.setDurationInMin(availableTest.getTestDuration());
				assignedTestUser.setLocked("unlocked");
				//05-March-2019
				assignedTestUser.setActive(ApplicationContant.TEST_NOT_VISIBLE_TO_CONSULTANT);
				assignedTestUser.setTestExpireOn(new Timestamp(new Date().getTime()).toString());
				assignedTestUser.setTestExpireTimeInHrs(1000);
				try {
				em.persist(assignedTestUser);
				////////////////////////////////////////////////////////////////////
				/////////////////GENRERATING USERID AND PASSWORD///////////////////
				////////////////////////////////////////////////////////////////////
						//createUserIdAndPassword(assignedTestUser.getAssignedTestCompositeKey().getUserId());
				}catch (Exception e) {
						System.out.println("Test is already assigned.........."+e.getMessage());
				}
			} else {
				dassignedTestUser.setTestStatus(ApplicationContant.NOT_STARTED);
				//05-March-2019
				assignedTestUser.setActive(ApplicationContant.TEST_NOT_VISIBLE_TO_CONSULTANT);
				dassignedTestUser.setAssignDate(new Date());
				if(availableTest!=null) {
					dassignedTestUser.setNumberOfQuestions(availableTest.getTotalQuestions());
					dassignedTestUser.setDurationInMin(availableTest.getTestDuration());
				}
				dassignedTestUser.setAttamptLimit(1);
				dassignedTestUser.setLink(assignedTestUser.getLink());
				dassignedTestUser.setGroupName(assignedTestUser.getGroupName());
				////////////////////////////////////////////////////////////////////
				/////////////////GENRERATING USERID AND PASSWORD///////////////////
				////////////////////////////////////////////////////////////////////
				try {
						//createUserIdAndPassword(dassignedTestUser.getAssignedTestCompositeKey().getUserId());
				}catch (Exception e) {
						System.out.println("Login is already there.........."+e.getMessage());
				}
			}
		
		}
	}
	
	/**
	 * 
	 * @param userid
	 */
	private void createUserIdAndPassword(String userid) {
		StudentLoginEntity loginEntity=new StudentLoginEntity();
		loginEntity.setStudentRoll(userid);
		//loginEntity.setPassword("ts@123");
		//7ijIryJqOpo=
		loginEntity.setPassword("7ijIryJqOpo=");
		loginEntity.setLocked("no");
		loginEntity.setRole("user");
		loginEntity.setEuserid("yadna01");
		loginEntity.setDoe(new Date());
		loginEntity.setDom(new Date());
		em.persist(loginEntity);
	}

	@Override
	public AssignedTestUser findAssignedTestByURL(String link) {
		try {
			Query query = em
					.createQuery("from AssignedTestUser as a where a.link=?");
			query.setParameter(1, link);
			return (AssignedTestUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public List<AssignedTestUser> findAssignedTestByGroup(String groupName) {
		try {
			Query query = em
					.createQuery("from AssignedTestUser as a where a.groupName=?");
			query.setParameter(1, groupName);
			return (List<AssignedTestUser>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public Questions findQuestionSetByQuestionId(String questionId) {
		try {
			Query q = em
					.createQuery("from Questions as q where q.questionId=?");
			q.setParameter(1, questionId);
			return (Questions) q.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Questions> findAllQuestions() {
		try {
			Query q = em
					.createQuery("from Questions as q where q.technology='Core Java'");
			return (List<Questions>) q.getResultList();
		} catch (NoResultException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<com.synergisitic.it.model.Questions> getQuestionsbyTech(
			String getSelectParam, int page) {
		try {
			/*
			 * int offsett=0; int limitt=2;
			 */
			int offset = (page - 1) * limit;
			System.out.println("printing offset " + offset + "and limit "
					+ limit);
			Query q = em
					.createQuery(
							"from Questions as q where q.technology='Core Java'")
					.setFirstResult(offset).setMaxResults(limit);
			/* q.setParameter(1, "Core Java"); */
			/* List ques=q.getResultList(); */
			return (List<Questions>) q.getResultList();
			// for(Questions qq:ques)
			/*
			 * Iterator a = ques.iterator(); while(a.hasNext()){ Questions
			 * st=(Questions)a.next();
			 * System.out.print("sname:"+st.getLastModifyBy()); }
			 */
			/* return (List<Questions>)q.getResultList(); */
		} catch (NoResultException e) {

			System.out.println("inside catch");
			e.printStackTrace();
			throw e;
		}
	}

	/*
	 * }
	 * 
	 * }
	 */

	public int getNoofRecords() {
		Query q = em
				.createQuery("SELECT count(x) FROM Questions x where x.technology='Core Java'");
		System.out.println(" am i printing  " + q.getSingleResult());
		// Integer intCount = Long.intValue(q.getSingleResult());
		// List<Integer> l = (Integer)q.getSingleResult()
		long noR = (Long) q.getSingleResult();
		int number = (int) noR;
		return number;
	}

	@Override
	public List<Questions> deleteQues(String qId) {
		// System.out.println("in the dao layer");
		/*
		 * Query
		 * query=em.createQuery("delete from Questions u where u.questionText=?"
		 * ); query.setParameter(1,qId); int q=query.executeUpdate();
		 * System.out.println("printing q:"+q);
		 */
		Query q = em
				.createQuery("SELECT id FROM Questions x where x.questionId=?");
		q.setParameter(1, qId);
		int hjid = (Integer) q.getSingleResult();
		// System.out.println("about to execute second query");
		Query q1 = em
				.createQuery("SELECT answerId FROM AssignedQuestionAnswers x where x.questionId=?");
		q1.setParameter(1, qId);
		List<String> answerText = q1.getResultList();
		Iterator stIterator = answerText.iterator();
		while (stIterator.hasNext()) {
			// Student st=(Student)stIterator.next();
			// System.out.println("printing the ans text:"+stIterator.next());
			Query ansDelete = em
					.createQuery("delete from Answers a where a.answerId=?");
			String temp = (String) stIterator.next();
			ansDelete.setParameter(1, temp);
			int i = ansDelete.executeUpdate();
			System.out.println("printing true or not?" + i);
		}
		// System.out.println("exiting......");
		Questions ques = em.find(Questions.class, hjid);
		em.remove(ques);
		return getQuestionsbyTech("Core Java", 1);

	}
	
	@Override
	public List<UserTechTestDetailEntity> findTestsByTechName(String techName) {
		String sqlString="select t.tname,t.shortName,t.image,a.testName,a.totalQuestions,a.testDuration,a.dateOfEntry  from  technology_tbl as t , available_test_tbl as a where   a.techName=t.tname and t.tname=?";
		Query query= em.createNativeQuery(sqlString, UserTechTestDetailEntity.class);
		query.setParameter(1, techName);
		return query.getResultList();
	}
	
	/**
	 * 
	 * @param testName
	 * @param userId
	 * @return
	 * 
	 */
	@Override
	public List<UserExamDetailStatus> findTestTechDetailSummary(String testName,String techName,String userId,String userSessionId) {
		Query query = em
				.createQuery("from UserExamDetailStatus as  ueds  where ueds.techName=? and ueds.testName=? and ueds.userId=? and ueds.userSessionId=?");
		query.setParameter(1, techName);
		query.setParameter(2, testName);
		query.setParameter(3, userId);
		query.setParameter(4, userSessionId);
		List<UserExamDetailStatus> userExamDetailStatusList = query
				.getResultList();
		return userExamDetailStatusList;
	}

}
