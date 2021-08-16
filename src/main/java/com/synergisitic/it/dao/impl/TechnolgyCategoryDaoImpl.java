package com.synergisitic.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.TechnolgyCategoryDao;
import com.synergisitic.it.model.Category;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.Technology;


@Repository("TechnolgyCategoryDaoImpl")
@Transactional
public class TechnolgyCategoryDaoImpl implements TechnolgyCategoryDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addTechnology(TechnologyEntity technology) {
		String hql="from TechnologyEntity where tname=?";
		Query query=em.createQuery(hql);
		query.setParameter(1, technology.getTname());
		List<TechnologyEntity> technologyEntityList=query.getResultList();
		if(technologyEntityList!=null && technologyEntityList.size()>0){
			return "fail";
		}
		em.persist(technology);
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String addCategory(Category category) {
		em.persist(category);
		return "success";
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<TechnologyEntity> findAllTechnolgy() {
		String namedQuery="from TechnologyEntity";
		Query query=em.createQuery(namedQuery);
		return query.getResultList();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public List<TechnologyEntity> deleteTechnology(String[] dcbox) {
		for(String dcboxId:dcbox){
		   Query query=em.createQuery("delete from TechnologyEntity t where t.id=?");
		   query.setParameter(1,Integer.parseInt(dcboxId));
		   int p=query.executeUpdate();
		}
		return findAllTechnolgy();
	}

	@Override
	public List<String> findAllTestName() {
		Query query=em.createQuery("select at.testName from AvailableTest as at");
		return query.getResultList();
	}
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Category> findAllCategory()	{
		Query query=em.createQuery("from Category");
		return query.getResultList();
	}

	@Override
	public String deleteCategoryByID(int cid) {
		Query query=em.createQuery("delete from Category c where c.id=?");
		query.setParameter(1,cid);
		int p=query.executeUpdate();
		return "successfully deleted";
	}

	@Override
	public String updateCategoryByID(int cid) {
		return null;
	}

	@Override
	public Category findCategoryByID(int catid) {
		return em.find(Category.class,catid);
	}

	@Override
	public TechnologyEntity findTechnologyByName(String techName) {
		Query query=em.createQuery("from TechnologyEntity tech where tech.tname=?");
		query.setParameter(1,techName);
		return (TechnologyEntity)query.getSingleResult();
	}
	
	@Override
	public TechnologyEntity findTechnologyByTid(String tid) {
		Query query=em.createQuery("from TechnologyEntity tech where tech.id="+tid);
		return (TechnologyEntity)query.getSingleResult();
	}
}
