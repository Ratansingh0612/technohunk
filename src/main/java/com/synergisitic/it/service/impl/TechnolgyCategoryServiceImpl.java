package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.TechnolgyCategoryDao;
import com.synergisitic.it.model.Category;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.web.form.CategoryFrom;

@Service("TechnolgyCategoryServiceImpl")
public class TechnolgyCategoryServiceImpl implements TechnolgyCategoryService{
	
	@Autowired
	@Qualifier("TechnolgyCategoryDaoImpl")
	private TechnolgyCategoryDao technolgyCategoryDao;

	@Override
	public String addTechnology(
			com.synergisitic.it.web.form.Technology technology) {
		TechnologyEntity hentity=new TechnologyEntity();
		hentity.setTname(technology.getTname());
		hentity.setShortName(technology.getShortName());
		hentity.setLastModifyOn(technology.getLastModifyOn());
		hentity.setLastModifyBy(technology.getLastModifyBy());
		hentity.setDescription(technology.getDescription());
		hentity.setDateOfEntry(technology.getDateOfEntry());
		String result=technolgyCategoryDao.addTechnology(hentity);
		return result;
	}

	@Override
	public String addCategory(Category category) {
		com.synergisitic.it.model.Category catHibEntity = new com.synergisitic.it.model.Category();
		catHibEntity.setCatName(category.getCatName());
		catHibEntity.setShortName(category.getShortName());
		catHibEntity.setLastModifyOn(category.getLastModifyOn());
		catHibEntity.setLastModifyBy(category.getLastModifyBy());
		catHibEntity.setDescription(category.getDescription());
		catHibEntity.setDateOfEntry(category.getDateOfEntry());
		String result=technolgyCategoryDao.addCategory(catHibEntity);
		return result;
	}

	@Override
	public List<com.synergisitic.it.web.form.Technology> findAllTechnolgy() {
		List<TechnologyEntity> technologies=technolgyCategoryDao.findAllTechnolgy();
		return convertEntity(technologies);
	}

	@Override
	public List<com.synergisitic.it.web.form.Technology> deleteTechnology(String[] dcbox) {
		List<TechnologyEntity> technologies=technolgyCategoryDao.deleteTechnology(dcbox);
		return convertEntity(technologies);
	}
	
	/**
	 * Method which converts entity into form object 
	 * @param technologies
	 * @return
	 */
	private List<com.synergisitic.it.web.form.Technology>  convertEntity(List<TechnologyEntity> technologies){
		List<com.synergisitic.it.web.form.Technology> techs=new ArrayList<com.synergisitic.it.web.form.Technology>(technologies.size());
		for(TechnologyEntity webTech:technologies){
		  com.synergisitic.it.web.form.Technology tech=new com.synergisitic.it.web.form.Technology();
		  tech.setDateOfEntry(webTech.getDateOfEntry());
		  tech.setDescription(webTech.getDescription());
		  tech.setId(webTech.getId());
		  tech.setImage(webTech.getImage());
		  tech.setLastModifyBy(webTech.getLastModifyBy());
		  tech.setShortName(webTech.getShortName());
		  tech.setTname(webTech.getTname());
		  techs.add(tech);
		}
		return techs;
	}

	@Override
	public List<String> findAllTestName() {
		return 	technolgyCategoryDao.findAllTestName();
	}
	@Override
	public List<CategoryFrom> findAllCategory() {  
		System.out.println("printing the form");
		  List<Category> categories=technolgyCategoryDao.findAllCategory();
		  List<CategoryFrom> CategoryFromList=new ArrayList<CategoryFrom>();
		  for(Category category:categories){
			  CategoryFrom categoryFrom=new CategoryFrom();
			  BeanUtils.copyProperties(category, categoryFrom);
			  System.out.println(categoryFrom.getCatName());
			  System.out.println(categoryFrom.getDescription());
			  CategoryFromList.add(categoryFrom);
		  }
		  return CategoryFromList;
	 }

	@Override
	public String deleteCategoryByID(int cid) {
		return technolgyCategoryDao.deleteCategoryByID(cid);
	}

	@Override
	public String updateCategoryByID(int cid) {
		return technolgyCategoryDao.updateCategoryByID(cid);
	}

	@Override
	public Category findCategoryByID(int catid) {
		return technolgyCategoryDao.findCategoryByID(catid);
	}

	@Override
	public com.synergisitic.it.web.form.Technology findTechnologyByName(
			String techName) {
		TechnologyEntity technology=technolgyCategoryDao.findTechnologyByName(techName);
		com.synergisitic.it.web.form.Technology ttechForm=new com.synergisitic.it.web.form.Technology();
		BeanUtils.copyProperties(technology, ttechForm);
		return ttechForm;
	}  
	
	@Override
	public com.synergisitic.it.web.form.Technology findTechnologyByTid(String tid){
		TechnologyEntity technology=technolgyCategoryDao.findTechnologyByTid(tid);
		com.synergisitic.it.web.form.Technology ttechForm=new com.synergisitic.it.web.form.Technology();
		BeanUtils.copyProperties(technology, ttechForm);
		return ttechForm;
	}

	
}
