package com.synergisitic.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.StreamDao;
import com.techquiz.programys.common.dao.entity.StreamEntity;

/**
 * 
 * @author Nagendra
 *
 */
@Repository("StreamDaoImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class StreamDaoImpl implements StreamDao  {
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(StreamDaoImpl.class);

	//EntityManagerFactory
	@PersistenceContext
	private EntityManager em;
	//this EntityManager is similar to session in hibernate
	//here who is managing EntityManagerFactory and EntityManager + Transaction????? Spring

	@Override
	public List<StreamEntity> findStreams() {
		String namedQuery="from StreamEntity";
		Query query=em.createQuery(namedQuery);
		List<StreamEntity> streamEntityList=query.getResultList();
		return streamEntityList;
	}

}
