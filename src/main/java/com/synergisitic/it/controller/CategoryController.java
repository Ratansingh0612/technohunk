/**
 * 
 */
package com.synergisitic.it.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.model.Category;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.util.NavigationPage;
import com.synergisitic.it.web.form.CategoryFrom;

/**
 * @author Pranay
 * 
 */
@Controller
public class CategoryController {

	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;

	@RequestMapping(value = "categoryForm", method = RequestMethod.GET)
	public String showAddEditCategoryPage(Model model) {
		Category category = new Category();
		// model is type of hashMap
		model.addAttribute("category", category);
		return "addEditCategory";
	}

	@RequestMapping(value = "categoryForm", method = RequestMethod.POST)
	public String submitCategoryForm(
			@ModelAttribute("category") Category category) {
		// System.out.println(category);
		category.setDateOfEntry(new Date());
		category.setLastModifyOn(new Date());
		category.setLastModifyBy("yadna01");
		// Here Service Integration
		technolgyCategoryService.addCategory(category);
		return NavigationPage.ADMIN_HOME;
	}

	@RequestMapping(value = "deleteCategoryById", method = RequestMethod.GET)
	public @ResponseBody
	String deleteCategoryById(
			@RequestParam(value = "cid", required = false) int cid) {
		// /
		System.out.println("cid = " + cid);
		String deleted = technolgyCategoryService.deleteCategoryByID(cid);
		System.out.println("result = " + deleted);
		return "deleted";
	}

	@RequestMapping(value = "updateCategoryById", method = RequestMethod.GET)
	public String updateCategoryById(HttpServletRequest request, Model model) {
		// /System
		// @RequestParam("catid")int catid,

		String catid = request.getParameter("catid");
		System.out.println("cid = " + catid);
		int catid1 = Integer.parseInt(catid);
		// String deleted=technolgyCategoryService.findCategoryByID(catid);
		// System.out.println("result = "+update);
		Category cat = technolgyCategoryService.findCategoryByID(catid1);
		System.out.println(cat.getCatName());
		model.addAttribute(cat);
		return "addEditCategory";
	}

	@RequestMapping(value="updateCategoryById",method=RequestMethod.POST)
	public String  updatedCategoryById(@ModelAttribute("category") Category category,Model model)
	{
		category.setDateOfEntry(new Date());
		category.setLastModifyOn(new Date());
		category.setLastModifyBy("yadna01");
		technolgyCategoryService.addCategory(category);
		List<CategoryFrom> categoryFroms = technolgyCategoryService.findAllCategory();
		//for(CategoryFrom)
		model.addAttribute("categoryFroms",categoryFroms);
		return "listCategory";
	}

	@RequestMapping(value = "listCategory", method = RequestMethod.GET)
	public String listCategory(Model model) {
		System.out.println("inside the controller");
		List<CategoryFrom> categoryFroms = technolgyCategoryService
				.findAllCategory();
		model.addAttribute("categoryFroms", categoryFroms);
		return "listCategory";
	}
}
