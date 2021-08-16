package com.synergisitic.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.ConsultantDao;
import com.synergisitic.it.model.FeedbackEntity;
import com.synergisitic.it.model.FeedbackInputData;
import com.synergisitic.it.model.PendingTopicFeedbackEntity;
import com.synergisitic.it.model.TopicFeedbackEntity;
import com.synergisitic.it.util.DateUtils;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

/**
 *
 * @author Nagendra
 * @ since 09-04-2018
 */
@Repository("ConsultantDaoImpl")
@Transactional
public class ConsultantDaoImpl implements ConsultantDao {
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(ConsultantDaoImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String resetConsultantPassword(String email,String newpassword){
			Query query=em.createQuery("from ConsultantsEntity where email=?");
			query.setParameter(1, email);
			List<ConsultantsEntity> consultantsEntities=query.getResultList();
			ConsultantsEntity consultantsEntity=consultantsEntities.get(0);
			consultantsEntity.setPassword(newpassword);
			return "done";
	}
	
	@Override
	public List<PendingTopicFeedbackEntity> findPendingTopicFeedbacks(String consultantid){
			Query query=em.createQuery("from PendingTopicFeedbackEntity where consultantid=?");
			query.setParameter(1, consultantid);
			return query.getResultList();
	}
	
	@Override
	public String addTopicFeedback(FeedbackInputData feedbackInputData) {
		TrainingSessionsDetailEntity trainingSessionsDetail=em.getReference(TrainingSessionsDetailEntity.class, feedbackInputData.getSid()); 	
		FeedbackEntity feedbackEntity=em.getReference(FeedbackEntity.class, feedbackInputData.getFid()); 	
		TopicFeedbackEntity topicFeedbackEntity=new TopicFeedbackEntity();
		topicFeedbackEntity.setComment(feedbackInputData.getComment());
		topicFeedbackEntity.setConsultantid(feedbackInputData.getConsultantid());
		topicFeedbackEntity.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		topicFeedbackEntity.setFeedback(feedbackEntity);
		topicFeedbackEntity.setSid(trainingSessionsDetail);
		em.persist(topicFeedbackEntity);
		Query deleteRecord=em.createNativeQuery("delete from pending_topics_feedback_tbl where consultantid=? and sid=?");
		deleteRecord.setParameter(1, feedbackInputData.getEmpid());
		deleteRecord.setParameter(2, feedbackInputData.getSid());
		deleteRecord.executeUpdate();
		if(logger.isDebugEnabled()) {
			logger.debug(topicFeedbackEntity);
		}
		return "success";
	}

}
