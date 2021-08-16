package com.synergisitic.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.QuestionAndAnswerDao;
import com.synergisitic.it.model.Answers;
import com.synergisitic.it.model.AssignedQuestionAnswers;
import com.synergisitic.it.model.Questions;
import com.synergisitic.it.web.form.QuestionAndAnswers;
import com.techquiz.info.jdbc.dao.entity.QuestionsBankEntity;

/**
 * 
 * @author nagendra.yadav
 * 
 * This is DAO for handling all the operation for
 * CRUD operation.
 * 
 */
@Repository("QuestionAndAnswerDaoImpl")
@Transactional
public class QuestionAndAnswerDaoImpl  implements QuestionAndAnswerDao {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(QuestionAndAnswerDaoImpl.class);

	// @PersistenceContext annotation injecting entityManager from above bean
	// This is Spring and JPA with hibernate integration
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public String updateQuestionAndAnswers(QuestionAndAnswers questionAndAnswers) {
		 //Update  questions table
		Query query=em.createQuery("from Questions where questionId=?");
		query.setParameter(1,questionAndAnswers.getQuestionId());
		Questions  questionEntity=(Questions)query.getSingleResult();
		questionEntity.setQuestionText(questionAndAnswers.getQuestionText());
		questionEntity.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		questionEntity.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		
		Query aqaQuery=em.createQuery("from AssignedQuestionAnswers where questionId=?");
		aqaQuery.setParameter(1,questionAndAnswers.getQuestionId());
		List<AssignedQuestionAnswers> assignedQuestionAnswersList=aqaQuery.getResultList();
		for(AssignedQuestionAnswers aqa:assignedQuestionAnswersList){
				aqa.setLastModifyOn(questionAndAnswers.getLastModifyOn());
				aqa.setLastModifyBy(questionAndAnswers.getLastModifyBy());
			    if(questionAndAnswers.getCorrect()!=null && questionAndAnswers.getCorrect().equals(aqa.getAnswerId())){
			    	aqa.setAnswerStatus("R");
			    	aqa.setDescription(questionAndAnswers.getCorrectAnsDescription());
			    }else{
			    	aqa.setAnswerStatus("W");
			    	aqa.setDescription("Not Correct!");
			    }
		}
		//Updating the answer table;
		if(questionAndAnswers.getAnswerText1()!=null && questionAndAnswers.getAnswerText1().trim().length()!=0){
			  Query aquery=em.createQuery("from Answers where answerId=?");
			  aquery.setParameter(1,questionAndAnswers.getCorrect1());
			  Answers  answersEntity1=(Answers)aquery.getSingleResult();
			  answersEntity1.setAnswerText(questionAndAnswers.getAnswerText1());
			  answersEntity1.setLastModifyBy(questionAndAnswers.getLastModifyBy());
			  answersEntity1.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		}
		if(questionAndAnswers.getAnswerText2()!=null && questionAndAnswers.getAnswerText2().trim().length()!=0){
			 Query aquery=em.createQuery("from Answers where answerId=?");
			  aquery.setParameter(1,questionAndAnswers.getCorrect2());
			  Answers  answersEntity2=(Answers)aquery.getSingleResult();
			  answersEntity2.setAnswerText(questionAndAnswers.getAnswerText2());
			  answersEntity2.setLastModifyBy(questionAndAnswers.getLastModifyBy());
			  answersEntity2.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		}
		if(questionAndAnswers.getAnswerText3()!=null && questionAndAnswers.getAnswerText3().trim().length()!=0){
			  Query aquery=em.createQuery("from Answers where answerId=?");
			  aquery.setParameter(1,questionAndAnswers.getCorrect3());
			  Answers  answersEntity3=(Answers)aquery.getSingleResult();
			  answersEntity3.setAnswerText(questionAndAnswers.getAnswerText3());
			  answersEntity3.setLastModifyBy(questionAndAnswers.getLastModifyBy());
			  answersEntity3.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		}
		if(questionAndAnswers.getAnswerText4()!=null && questionAndAnswers.getAnswerText4().trim().length()!=0){
			  Query aquery=em.createQuery("from Answers where answerId=?");
			  aquery.setParameter(1,questionAndAnswers.getCorrect4());
			  Answers  answersEntity4=(Answers)aquery.getSingleResult();
			  answersEntity4.setAnswerText(questionAndAnswers.getAnswerText4());
			  answersEntity4.setLastModifyBy(questionAndAnswers.getLastModifyBy());
			  answersEntity4.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		}
		if(questionAndAnswers.getAnswerText5()!=null && questionAndAnswers.getAnswerText5().trim().length()!=0){
			 Query aquery=em.createQuery("from Answers where answerId=?");
			  aquery.setParameter(1,questionAndAnswers.getCorrect5());
			  Answers  answersEntity5=(Answers)aquery.getSingleResult();
			  answersEntity5.setAnswerText(questionAndAnswers.getAnswerText5());
			  answersEntity5.setLastModifyBy(questionAndAnswers.getLastModifyBy());
			  answersEntity5.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		}
		if(questionAndAnswers.getAnswerText6()!=null && questionAndAnswers.getAnswerText6().trim().length()!=0){
			 Query aquery=em.createQuery("from Answers where answerId=?");
			  aquery.setParameter(1,questionAndAnswers.getCorrect6());
			  Answers  answersEntity6=(Answers)aquery.getSingleResult();
			  answersEntity6.setAnswerText(questionAndAnswers.getAnswerText6());
			  answersEntity6.setLastModifyBy(questionAndAnswers.getLastModifyBy());
			  answersEntity6.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		}
		if(questionAndAnswers.getAnswerText7()!=null && questionAndAnswers.getAnswerText7().trim().length()!=0){
			 Query aquery=em.createQuery("from Answers where answerId=?");
			  aquery.setParameter(1,questionAndAnswers.getCorrect7());
			  Answers  answersEntity7=(Answers)aquery.getSingleResult();
			  answersEntity7.setAnswerText(questionAndAnswers.getAnswerText7());
			  answersEntity7.setLastModifyBy(questionAndAnswers.getLastModifyBy());
			  answersEntity7.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		}
		//updating 
		return "success";
	}

	
	/**
	 * 
	 * @param questions
	 * @return success when question is persisted successfully
	 */
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false,rollbackFor=Syn.class)
	//roll back for all unchecked exception , but for checked exception not
	public String addQuestion(Questions questions) {
		if(logger.isInfoEnabled()){
			logger.info("Inside the method addQuestion");
		}
		Query query=em.createQuery("SELECT MAX(p.id) FROM Questions p");
		try {
			Number countResult=(Number) query.getSingleResult();
		    questions.setQuestionId("Q-"+questions.getTechnology()+"-"+(countResult==null?1:countResult.intValue()+1));
		}catch (NonUniqueResultException e) {
			if(logger.isErrorEnabled()){
				logger.error(e.getMessage(), e);
			}
			questions.setQuestionId(questions.getTechnology()+"-"+1);			
		}
		em.persist(questions);
		return "success";
	}

	public void updateUser(){
		Questions questions=null;
		addQuestion(questions);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addQuestionAndAnswers(QuestionAndAnswers questionAndAnswers,boolean updateQBank) {
		
		//persisting the question
		Questions questions=new Questions();
		questions.setCategory(questionAndAnswers.getCategory());
		questions.setChoiceType(questionAndAnswers.getChoiceType());
		questions.setDateOfEntry(questionAndAnswers.getDateOfEntry());
		questions.setDescription(questionAndAnswers.getCorrectAnsDescription());
		questions.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		questions.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		questions.setMarks(questionAndAnswers.getMarks());
		questions.setNumberOfAnswers(questionAndAnswers.getNumberOfAnswers());
		questions.setQuestionComplexity(questionAndAnswers.getQuestionComplexity());
		questions.setQuestionText(questionAndAnswers.getQuestionText());
		questions.setQuestionType(questionAndAnswers.getQuestionType());
		questions.setTechnology(questionAndAnswers.getTechnology());
		questions.setTopic(questionAndAnswers.getTopic());
		questions.setQuestionOwner(questionAndAnswers.getQuestionOwner());
		questions.setQbankName(questionAndAnswers.getQbankName());
		//questions.setDescription(questionAndAnswers.getDescription());
		
		String questionId=null;
		Query query=em.createNamedQuery("select.current.max.id.from.question");
		try {
			Number countResult=(Number) query.getSingleResult();
			int nextId=countResult==null?0:countResult.intValue();
			nextId=nextId+1;
			questionId="Q-"+questions.getTechnology()+"-"+nextId;
		    questions.setQuestionId(questionId);
		    questionAndAnswers.setQuestionId(questionId);
		}catch (NonUniqueResultException e) {
			//e.printStackTrace();			
			if(logger.isErrorEnabled()){
				logger.error(e.getMessage(), e);
			}
		}
			
		em.persist(questions);
		
		//Answer1
		if(questionAndAnswers.getAnswerText1()!=null && questionAndAnswers.getAnswerText1().length()>0){
			persistAnswers1(questionAndAnswers,questions);
		} 

		//Answer2
		if(questionAndAnswers.getAnswerText2()!=null && questionAndAnswers.getAnswerText2().length()>0){
			persistAnswers2(questionAndAnswers,questions);
		}
		
		//Answer3
		if(questionAndAnswers.getAnswerText3()!=null && questionAndAnswers.getAnswerText3().length()>0){
			persistAnswers3(questionAndAnswers,questions);
		}
		
		//Persisting Answers4
		if(questionAndAnswers.getAnswerText4()!=null && questionAndAnswers.getAnswerText4().length()>0){
			persistAnswers4(questionAndAnswers,questions);
					}
		
		//Persisting Answers5
		if(questionAndAnswers.getAnswerText5()!=null && questionAndAnswers.getAnswerText5().length()>0){
			persistAnswers5(questionAndAnswers,questions);
		}

		//Persisting Answers6
		if(questionAndAnswers.getAnswerText6()!=null && questionAndAnswers.getAnswerText6().length()>0){
			persistAnswers6(questionAndAnswers,questions);
		}
		
		if(questionAndAnswers.getAnswerText7()!=null && questionAndAnswers.getAnswerText7().length()>0){
			persistAnswers7(questionAndAnswers,questions);
		}
		if(updateQBank) {
			//Query qbquery=em.createQuery("from QuestionsBankEntity where qbankname=? and techName=? and  ownerName=?");
			//Exception was coming when question bank was updated by different trainer...........
			Query qbquery=em.createQuery("from QuestionsBankEntity where qbankname=? and techName=?");
			qbquery.setParameter(1,questionAndAnswers.getQbankName());
			qbquery.setParameter(2,questionAndAnswers.getTechnology());
			//qbquery.setParameter(3,questionAndAnswers.getQuestionOwner());
			QuestionsBankEntity  questionsBankEntity=(QuestionsBankEntity)qbquery.getSingleResult();
			questionsBankEntity.setNoq(questionsBankEntity.getNoq()+1);
		}
		return "success";
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	private void persistAssignedQuestionAnswers(String answerId,QuestionAndAnswers questionAndAnswers,String answerStatus,Questions questions) {
		AssignedQuestionAnswers assignedQuestionAnswers=new AssignedQuestionAnswers();
		assignedQuestionAnswers.setAnswerId(answerId);
		assignedQuestionAnswers.setAnswerStatus(answerStatus);
		assignedQuestionAnswers.setChoiceType(questionAndAnswers.getChoiceType());
		assignedQuestionAnswers.setDateOfEntry(questionAndAnswers.getDateOfEntry());
		assignedQuestionAnswers.setDescription("NA");
		assignedQuestionAnswers.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		assignedQuestionAnswers.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		assignedQuestionAnswers.setQuestionId(questionAndAnswers.getQuestionId());
		assignedQuestionAnswers.setTechnology(questionAndAnswers.getTechnology());
		//################Assigning questions to assignedQuestion&Answer
		assignedQuestionAnswers.setQuestions(questions);
		//#######################################
		em.persist(assignedQuestionAnswers);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	private void persistAnswers1(QuestionAndAnswers questionAndAnswers,Questions questions) {
		String answerId=null;
		if(questionAndAnswers.getAnswerText1()!=null && questionAndAnswers.getAnswerText1().length()>0){
			//persisting the answer
		   Answers answers=new Answers();
		   answers.setAnswerText(questionAndAnswers.getAnswerText1());
		   answers.setCategory(questionAndAnswers.getCategory());
		   answers.setDescription("NA");
		   answers.setDateOfEntry(questionAndAnswers.getDateOfEntry());
		   answers.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		   answers.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		   Query aquery=em.createNamedQuery("select.current.max.id.from.answers");
			try {
				Number countResult=(Number) aquery.getSingleResult();
				int nextId=countResult==null?0:countResult.intValue();
				nextId=nextId+1;
				answerId="A-"+questionAndAnswers.getTechnology()+"-"+nextId;
				answers.setAnswerId(answerId);
			}catch (NonUniqueResultException e) {
				//e.printStackTrace();			
				if(logger.isErrorEnabled()){
					logger.error(e.getMessage(), e);
				}
			}
			String answerStatus =(questionAndAnswers.getCorrect1()==null || questionAndAnswers.getCorrect1().length()==0)?"W":"R";
			persistAssignedQuestionAnswers(answerId, questionAndAnswers, answerStatus,questions);
			em.persist(answers);
		}
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	private void persistAnswers2(QuestionAndAnswers questionAndAnswers,Questions questions) {
		String answerId=null;
		if(questionAndAnswers.getAnswerText2()!=null && questionAndAnswers.getAnswerText2().length()>0){
			//persisting the answer
		   Answers answers=new Answers();
		   answers.setAnswerText(questionAndAnswers.getAnswerText2());
		   answers.setCategory(questionAndAnswers.getCategory());
		   answers.setDescription(questionAndAnswers.getDescription());
		   answers.setDateOfEntry(questionAndAnswers.getDateOfEntry());
		   answers.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		   answers.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		   Query aquery=em.createNamedQuery("select.current.max.id.from.answers");
			try {
				Number countResult=(Number) aquery.getSingleResult();
				int nextId=countResult==null?0:countResult.intValue();
				nextId=nextId+1;
				answerId="A-"+questionAndAnswers.getTechnology()+"-"+nextId;
				answers.setAnswerId(answerId);
			}catch (NonUniqueResultException e) {
				//e.printStackTrace();			
				if(logger.isErrorEnabled()){
					logger.error(e.getMessage(), e);
				}
			}
			
			String answerStatus =(questionAndAnswers.getCorrect2()==null || questionAndAnswers.getCorrect2().length()==0)?"W":"R";
			persistAssignedQuestionAnswers(answerId, questionAndAnswers, answerStatus,questions);
			em.persist(answers);
		}
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	private void persistAnswers3(QuestionAndAnswers questionAndAnswers,Questions questions) {
	
	String answerId=null;
	//Answer3
	if(questionAndAnswers.getAnswerText3()!=null && questionAndAnswers.getAnswerText3().length()>0){
		//persisting the answer
	   Answers answers=new Answers();
	   answers.setAnswerText(questionAndAnswers.getAnswerText3());
	   answers.setCategory(questionAndAnswers.getCategory());
	   answers.setDescription(questionAndAnswers.getDescription());
	   answers.setDateOfEntry(questionAndAnswers.getDateOfEntry());
	   answers.setLastModifyBy(questionAndAnswers.getLastModifyBy());
	   answers.setLastModifyOn(questionAndAnswers.getLastModifyOn());
	   Query aquery=em.createNamedQuery("select.current.max.id.from.answers");
		try {
			Number countResult=(Number) aquery.getSingleResult();
			int nextId=countResult==null?0:countResult.intValue();
			nextId=nextId+1;
			answerId="A-"+questionAndAnswers.getTechnology()+"-"+nextId;
			answers.setAnswerId(answerId);
		}catch (NonUniqueResultException e) {
			//e.printStackTrace();			
			if(logger.isErrorEnabled()){
				logger.error(e.getMessage(), e);
			}
		}
		
		String answerStatus =(questionAndAnswers.getCorrect3()==null || questionAndAnswers.getCorrect3().length()==0)?"W":"R";
		persistAssignedQuestionAnswers(answerId, questionAndAnswers, answerStatus,questions);
		em.persist(answers);
	}
}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	private void persistAnswers4(QuestionAndAnswers questionAndAnswers,Questions questions) {
		//Answer4
		String answerId=null;
		if(questionAndAnswers.getAnswerText4()!=null && questionAndAnswers.getAnswerText4().length()>0){
			//persisting the answer
		   Answers answers=new Answers();
		   answers.setAnswerText(questionAndAnswers.getAnswerText4());
		   answers.setCategory(questionAndAnswers.getCategory());
		   answers.setDescription(questionAndAnswers.getDescription());
		   answers.setDateOfEntry(questionAndAnswers.getDateOfEntry());
		   answers.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		   answers.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		   Query aquery=em.createNamedQuery("select.current.max.id.from.answers");
			try {
				Number countResult=(Number) aquery.getSingleResult();
				int nextId=countResult==null?0:countResult.intValue();
				nextId=nextId+1;
				answerId="A-"+questionAndAnswers.getTechnology()+"-"+nextId;
				answers.setAnswerId(answerId);
			}catch (NonUniqueResultException e) {
				//e.printStackTrace();			
				if(logger.isErrorEnabled()){
					logger.error(e.getMessage(), e);
				}
			}
			String answerStatus =(questionAndAnswers.getCorrect4()==null || questionAndAnswers.getCorrect4().length()==0)?"W":"R";
			persistAssignedQuestionAnswers(answerId, questionAndAnswers, answerStatus,questions);
			em.persist(answers);
		}
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	private void persistAnswers5(QuestionAndAnswers questionAndAnswers,Questions questions) {
		//Answer4
		String answerId=null;
		if(questionAndAnswers.getAnswerText5()!=null && questionAndAnswers.getAnswerText5().length()>0){
			//persisting the answer
		   Answers answers=new Answers();
		   answers.setAnswerText(questionAndAnswers.getAnswerText5());
		   answers.setCategory(questionAndAnswers.getCategory());
		   answers.setDescription(questionAndAnswers.getDescription());
		   answers.setDateOfEntry(questionAndAnswers.getDateOfEntry());
		   answers.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		   answers.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		   Query aquery=em.createNamedQuery("select.current.max.id.from.answers");
			try {
				Number countResult=(Number) aquery.getSingleResult();
				int nextId=countResult==null?0:countResult.intValue();
				nextId=nextId+1;
				answerId="A-"+questionAndAnswers.getTechnology()+"-"+nextId;
				answers.setAnswerId(answerId);
			}catch (NonUniqueResultException e) {
				//e.printStackTrace();			
				if(logger.isErrorEnabled()){
					logger.error(e.getMessage(), e);
				}
			}
			String answerStatus =(questionAndAnswers.getCorrect5()==null || questionAndAnswers.getCorrect5().length()==0)?"W":"R";
			persistAssignedQuestionAnswers(answerId, questionAndAnswers, answerStatus,questions);
			em.persist(answers);
		}
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	private void persistAnswers6(QuestionAndAnswers questionAndAnswers,Questions questions) {
		//Answer6
		String answerId=null;
		if(questionAndAnswers.getAnswerText6()!=null && questionAndAnswers.getAnswerText6().length()>0){
			//persisting the answer
		   Answers answers=new Answers();
		   answers.setAnswerText(questionAndAnswers.getAnswerText6());
		   answers.setCategory(questionAndAnswers.getCategory());
		   answers.setDescription(questionAndAnswers.getDescription());
		   answers.setDateOfEntry(questionAndAnswers.getDateOfEntry());
		   answers.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		   answers.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		   Query aquery=em.createNamedQuery("select.current.max.id.from.answers");
			try {
				Number countResult=(Number) aquery.getSingleResult();
				int nextId=countResult==null?0:countResult.intValue();
				nextId=nextId+1;
				answerId="A-"+questionAndAnswers.getTechnology()+"-"+nextId;
				answers.setAnswerId(answerId);
			}catch (NonUniqueResultException e) {
				//e.printStackTrace();			
				if(logger.isErrorEnabled()){
					logger.error(e.getMessage(), e);
				}
			}
			String answerStatus =(questionAndAnswers.getCorrect6()==null || questionAndAnswers.getCorrect6().length()==0)?"W":"R";
			persistAssignedQuestionAnswers(answerId, questionAndAnswers, answerStatus,questions);
			em.persist(answers);
		}
	}
	
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=false)
	private void persistAnswers7(QuestionAndAnswers questionAndAnswers,Questions questions) {
		//Answer7
		String answerId=null;
		if(questionAndAnswers.getAnswerText7()!=null && questionAndAnswers.getAnswerText7().length()>0){
			//persisting the answer
		   Answers answers=new Answers();
		   answers.setAnswerText(questionAndAnswers.getAnswerText7());
		   answers.setCategory(questionAndAnswers.getCategory());
		   answers.setDescription(questionAndAnswers.getDescription());
		   answers.setDateOfEntry(questionAndAnswers.getDateOfEntry());
		   answers.setLastModifyBy(questionAndAnswers.getLastModifyBy());
		   answers.setLastModifyOn(questionAndAnswers.getLastModifyOn());
		   Query aquery=em.createNamedQuery("select.current.max.id.from.answers");
			try {
				Number countResult=(Number) aquery.getSingleResult();
				int nextId=countResult==null?0:countResult.intValue();
				nextId=nextId+1;
				answerId="A-"+questionAndAnswers.getTechnology()+"-"+nextId;
				answers.setAnswerId(answerId);
			}catch (NonUniqueResultException e) {
				//e.printStackTrace();			
				if(logger.isErrorEnabled()){
					logger.error(e.getMessage(), e);
				}
			}
			String answerStatus =(questionAndAnswers.getCorrect7()==null || questionAndAnswers.getCorrect7().length()==0)?"W":"R";
			persistAssignedQuestionAnswers(answerId, questionAndAnswers, answerStatus,questions);
			em.persist(answers);
		}
	}

	@Override
	public String addAnswer(Answers answers) {
		if(logger.isInfoEnabled()){
			logger.info("Inside the method addAnswer");
		}
		em.persist(answers);
		return "success";
	}

	@Override
	public void updateQues(String qId) {
		AssignedQuestionAnswers testObj = new AssignedQuestionAnswers();
		
		
	}

}

class Syn extends Exception {
	
	Syn(String msg){
		super(msg);
	}
	
}
