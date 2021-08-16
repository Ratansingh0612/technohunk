package com.synergisitic.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.TopicsDao;
import com.synergisitic.it.util.ApplicationContant;
import com.techquiz.programys.common.dao.entity.TopicEntity;


@Repository("TopicsDaoImpl")
@Transactional
public class TopicsDaoImpl implements TopicsDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addTopic(TopicEntity topicEntity) {
		  String pquery = "FROM TopicEntity order by doe desc";
		  Query query = em.createQuery(pquery);
		  query.setFirstResult(0);
		  query.setMaxResults(1);
		  TopicEntity currentTid = (TopicEntity)query.getSingleResult();
		  String tempid="T"+(Integer.parseInt(currentTid.getTid().substring(1))+1);
		  topicEntity.setTid(tempid);
		em.persist(topicEntity);
		return tempid;
	}
	

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<TopicEntity> findTopics() {
		Query query=em.createQuery("from TopicEntity");
		return query.getResultList();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public List<TopicEntity> deleteTopics(String[] dcbox) {
		for(String dcboxId:dcbox){
		   Query query=em.createQuery("delete from TopicEntity t where t.tid=?");
		   query.setParameter(1,Integer.parseInt(dcboxId));
		   int p=query.executeUpdate();
		}
		return findTopics();
	}

	@Override
	public TopicEntity findTopicByTid(String tid) {
		Query query=em.createQuery("from TopicEntity t where t.tid="+tid);
		return (TopicEntity)query.getSingleResult();
	}
	
	@Override
	public int  findTotalTopicsByTId(String tid) {
		String pquery = "SELECT count(*) FROM TopicEntity t where t.tid="+tid;
		  Query query = em.createQuery(pquery);
		  Integer row=0;
		  row = (Integer)query.getSingleResult();
		 return row;
	}
	

	@Override
	public List<TopicEntity> findTopicsByLanguageId(String languageId) {
		Query query=em.createQuery("from TopicEntity as te where te.language="+languageId);
		return query.getResultList();
	}
	
	@Override
	public String deleteTopicById(String tid) {
		Query query=em.createQuery("delete from TopicEntity as te where te.tid=?");
		query.setParameter(1,tid);
		query.executeUpdate();
		return ApplicationContant.SUCCESS;
	}
}
