package com.synergisitic.it.service;

import java.util.List;

import com.synergisitic.it.model.Category;
import com.synergisitic.it.web.form.CategoryFrom;
import com.synergisitic.it.web.form.Technology;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface TechnolgyCategoryService {
	
	public String addTechnology(com.synergisitic.it.web.form.Technology technology);
	
	public Technology findTechnologyByName(String techName);
	
	public String addCategory(Category category);
	
	public List<com.synergisitic.it.web.form.Technology> findAllTechnolgy();
	
	public List<com.synergisitic.it.web.form.Technology> deleteTechnology(String dcbox[]);
	
	public List<String> findAllTestName();

	public List<CategoryFrom> findAllCategory();

	public String deleteCategoryByID(int cid);

	public String updateCategoryByID(int cid);

	public Category findCategoryByID(int catid);

	public Technology findTechnologyByTid(String tid);
	
	

}
