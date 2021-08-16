package com.techquiz.trainer.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.model.TechnologyEntity;
import com.techquiz.trainer.dao.InterviewQuestionsDao;
import com.techquiz.trainer.dao.entity.InterviewQuestionsAnswerEntity;


/**
 * 
 * @author Nagendra
 *
 */
@Repository("InterviewQuestionsDaoImpl")
@Scope("singleton")
public class InterviewQuestionsDaoImpl  implements InterviewQuestionsDao{

	@PersistenceContext
	private EntityManager em;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public List<InterviewQuestionsAnswerEntity> findInterviewQuestionsByTechTopic(String techName,String topic,String complexity){
		TechnologyEntity technologyEntity=em.getReference(TechnologyEntity.class, Integer.parseInt(techName));
		 String tname=technologyEntity.getTname();
		 Query query=null;
		 if("All".equalsIgnoreCase(complexity) && "All".equalsIgnoreCase(topic)) {
			  query=em.createQuery("from  InterviewQuestionsAnswerEntity as iqa where iqa.techName=?");
		    query.setParameter(1, tname);
		 }else  if("All".equalsIgnoreCase(complexity) && !"All".equalsIgnoreCase(topic)) {
			  query=em.createQuery("from  InterviewQuestionsAnswerEntity as iqa where iqa.techName=? and iqa.topic=?");
			    query.setParameter(1, tname);
			    query.setParameter(2, topic);
		 } else if(!"All".equalsIgnoreCase(complexity) && "All".equalsIgnoreCase(topic)) {
			  query=em.createQuery("from  InterviewQuestionsAnswerEntity as iqa where iqa.techName=?  and iqa.complexity=?");
			    query.setParameter(1, tname);
			    query.setParameter(2, complexity);
		 }else{
			   query=em.createQuery("from  InterviewQuestionsAnswerEntity as iqa where iqa.techName=? and iqa.topic=? and iqa.complexity=?");
			    query.setParameter(1, tname);
			    query.setParameter(2, topic);
			    query.setParameter(3, complexity);
		 }
		List<InterviewQuestionsAnswerEntity>  questionsAnswerEntityList=query.getResultList();
		 return questionsAnswerEntityList;
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public String addInterviewQuestionAnswer(InterviewQuestionsAnswerEntity interviewQuestionsAnswerEntity){
// this code convert Technology Id to Technology Name		
//		TechnologyEntity technologyEntity=em.getReference(TechnologyEntity.class, Integer.parseInt(interviewQuestionsAnswerEntity.getTechName()));
//		interviewQuestionsAnswerEntity.setTechName(technologyEntity.getTname());
		TechnologyEntity technologyEntity=em.getReference(TechnologyEntity.class, Integer.parseInt(interviewQuestionsAnswerEntity.getTechName()));
		interviewQuestionsAnswerEntity.setTechName(technologyEntity.getTname());
		em.persist(interviewQuestionsAnswerEntity);
		return "success";
	}
	
	
}
