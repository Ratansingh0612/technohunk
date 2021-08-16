
package com.synergisitic.it.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.base.AbstractUserSession;
import com.synergisitic.it.navigation.AdminNavigationPage;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.web.form.Technology;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;

@Controller
public class TechnologyController extends AbstractUserSession{
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(TechnologyController.class);
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;
	
	@RequestMapping(value="add-edit-technology",method=RequestMethod.GET)
	public String showUserTechnologyPage(Model model){
		Technology technology=new Technology();
		//model is type of hashMap
		model.addAttribute("technology",technology);
		model.addAttribute("action","technologyForm");
		List<Technology> allTechs=technolgyCategoryService.findAllTechnolgy();
		//request.setAttribute("allTechs",allTechs);
		model.addAttribute(allTechs);
		model.addAttribute("allTechs",allTechs);
		model.addAttribute("buttonLable","Add");
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.ADD_EDIT_TECHNOLOGY_PAGE;	
	}
	
	/**
	 * 
	 * @param technology
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="add-new-technology",method=RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse submitTechForm(Technology technology,HttpSession session,Model model){
		if(logger.isDebugEnabled()){
			logger.debug(technology);
		}
		technology.setShortName(technology.getTname());
		technology.setDateOfEntry(new Date());
		technology.setLastModifyOn(new Date());
		technology.setLastModifyBy(getUserIdFromSession(session).getLoginId());
		//Here Service Integration
		String status=technolgyCategoryService.addTechnology(technology);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		if(ApplicationContant.SUCCESS.equalsIgnoreCase(status)){
				applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
				applicationMessageResponse.setMessage(ApplicationMessageConstant.TECHNOLOGY_IS_ADDED_MESSAGE);
		}else{
			applicationMessageResponse.setStatus(ApplicationContant.FAIL);
			applicationMessageResponse.setMessage(ApplicationMessageConstant.TECHNOLOGY_ALREADY_EXIST_MESSAGE);
		}
		return  applicationMessageResponse;
	}
	
	
	@RequestMapping(value="selectEditTechnologyForm",method=RequestMethod.GET)
	public String selectEditTechnologyForm(Model model){
		return "selectEditTechnology";	
	}

	@ModelAttribute("technologyList")
	public List<String> populateTechnologyList() {
		//Data referencing for web framework combo
		List<String> technologyList = new ArrayList<String>();
		technologyList.add("Spring MVC");
		technologyList.add("Spring");
		technologyList.add("Oracle");
		technologyList.add("JSF");
		technologyList.add("Core Java");
		technologyList.add("JSP");
		technologyList.add("Servlet");
		technologyList.add("Hibernate");
		technologyList.add("Struts2.0");
		return technologyList;
	}
	
	
	
	@RequestMapping(value="editTechnologyForm",method=RequestMethod.GET)
	public String showTechEditPage(@RequestParam("techName") String techName,Model model){
		Technology technology=technolgyCategoryService.findTechnologyByName(techName);
		//model is type of hashMap
		model.addAttribute("technology",technology);
		model.addAttribute("buttonLable","Edit");
		model.addAttribute("action","editTechnologyForm");
		List<Technology> allTechs=technolgyCategoryService.findAllTechnolgy();
		model.addAttribute("allTechs",allTechs);
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.ADD_EDIT_TECHNOLOGY_PAGE;		
	}
	
	@RequestMapping(value="editTechnologyForm",method=RequestMethod.POST)
	public String submitTechEditPage(@ModelAttribute("technology") Technology technology,HttpSession session,Model model){
		System.out.println(technology);
		technology.setDateOfEntry(new Date());
		technology.setLastModifyOn(new Date());
		technology.setLastModifyBy(getUserIdFromSession(session).getLoginId());
		//Here Service Integration
		technolgyCategoryService.addTechnology(technology);
		model.addAttribute("action","technologyForm");
		model.addAttribute("buttonLable","Add");
		technology.setDescription("");
		technology.setTname("");
		technology.setShortName("");
		List<Technology> allTechs=technolgyCategoryService.findAllTechnolgy();
		model.addAttribute("allTechs",allTechs);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.TECHNOLOGY_IS_UPDATED_MESSAGE);
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.ADD_EDIT_TECHNOLOGY_PAGE;	
	}
	
	
	@RequestMapping(value="allTechnology",method=RequestMethod.GET)
	public String allTechnology(Model model){
		List<Technology> allTechs=technolgyCategoryService.findAllTechnolgy();
		//request.setAttribute("allTechs",allTechs);
		model.addAttribute("allTechs",allTechs);
		return "allTechnology";	
	}
	
	@RequestMapping(value="deleteTechnology",method=RequestMethod.GET)
	public String deleteTechnology(Model model,HttpServletRequest request){
		String dcbox[]=request.getParameterValues("dcbox");
		List<Technology> allTechs=technolgyCategoryService.deleteTechnology(dcbox);
		model.addAttribute("allTechs",allTechs);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.TECHNOLOGY_IS_DELETE_MESSAGE);
		Technology technology=new Technology();
		//model is type of hashMap
		model.addAttribute("technology",technology);
		model.addAttribute("action","technologyForm");
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.ADD_EDIT_TECHNOLOGY_PAGE;
	}
	
	@RequestMapping(value="selectTechnology",method=RequestMethod.GET)
	public String selectTechnology() {
		return "selectTechnology";	
	}
	
	
	@ModelAttribute("testNameList")
	public List<String> populateTestNameList() {
		//Data referencing for web framework combo
		List<String> testNameList=technolgyCategoryService.findAllTestName();
		return testNameList;
	}
	
	@RequestMapping(value="showResetTestPage",method=RequestMethod.GET)
	public String showResetTestPage() {
		return "resetSelectTechnology";	
	}

	@Override
	public UserId getUserIdFromSession(HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}

}
