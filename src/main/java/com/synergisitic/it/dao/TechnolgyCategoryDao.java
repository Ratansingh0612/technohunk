package com.synergisitic.it.dao;

import java.util.List;

import com.synergisitic.it.model.Category;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.web.form.Technology;

public interface TechnolgyCategoryDao {
	
	public String addTechnology(TechnologyEntity technology);
	
	public TechnologyEntity findTechnologyByName(String techName) ;
	
	public String addCategory(Category category);
	
	public List<TechnologyEntity> findAllTechnolgy();
	
	public List<TechnologyEntity> deleteTechnology(String dcbox[]);
	
	public List<String> findAllTestName();

	 public List<Category> findAllCategory();
	 
	 public String deleteCategoryByID(int cid);

	public String updateCategoryByID(int cid);

	public Category findCategoryByID(int catid);

	public TechnologyEntity findTechnologyByTid(String tid);

	
}
