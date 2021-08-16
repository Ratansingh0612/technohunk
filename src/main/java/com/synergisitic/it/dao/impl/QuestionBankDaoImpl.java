package com.synergisitic.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.QuestionBankDao;
import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.TechnologyEntity;
import com.techquiz.info.jdbc.dao.entity.QuestionsBankEntity;

@Repository("QuestionBankDaoImpl")
@Transactional
public class QuestionBankDaoImpl implements QuestionBankDao{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public String checkQuestionBankTechName(String techName,String qbname) {
		TechnologyEntity technologyEntity=em.getReference(TechnologyEntity.class, Integer.parseInt(techName));
		String hql="from QuestionsBankEntity as qbe where qbe.techName=? and qbe.qbankname=?";
		Query query=em.createQuery(hql);
		query.setParameter(1,technologyEntity.getTname());
		query.setParameter(2, qbname);
		String status="notexist";
		List<QuestionsBankEntity> bankEntityList=query.getResultList();
		if(bankEntityList!=null && bankEntityList.size()>0){
				status="exist";
		}
		return status;
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addQuestionBank(QuestionsBankEntity questionsBankEntity) {
		TechnologyEntity technologyEntity=em.getReference(TechnologyEntity.class, Integer.parseInt(questionsBankEntity.getTechName()));
		questionsBankEntity.setTechName(technologyEntity.getTname());
		em.persist(questionsBankEntity);
		return "succcess";
	}

}
