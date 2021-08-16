
package com.synergisitic.it.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.service.TopicsService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.Technology;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.programys.common.ApplicationRestStatusVO;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;
import com.techquiz.programys.common.vo.TopicVO;

@Controller
public class TopicsController extends AbstractUserSession{
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(TopicsController.class);
	
	@Autowired
	@Qualifier("TopicsServiceImpl")
	private TopicsService topicsService;
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;
	
	@RequestMapping(value="addTopic",method=RequestMethod.GET)
	public String showUserTechnologyPage(Model model){
		TopicVO topicVO=new TopicVO();
		//model is type of hashMap
		model.addAttribute("topicVO",topicVO);
		model.addAttribute("action","addTopic");
		model.addAttribute("buttonLable","Add");
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.ADD_EDIT_TOPICS_PAGE;	
	}
	
	@RequestMapping(value="addTopic",method=RequestMethod.POST)
@ResponseBody	public ApplicationMessageResponse submitTechForm(@ModelAttribute TopicVO topicVO,HttpSession session,Model model){
		if(logger.isDebugEnabled()){
			logger.debug(topicVO);
		}
		topicVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		topicVO.setLastUpdate(DateUtils.getCurrentTimeIntoTimestamp());
		topicVO.setAdminid(getUserIdFromSession(session).getLoginId());
		topicVO.setTname(topicVO.getTopic());
		//Here Service Integration
		String topicId=topicsService.addTopic(topicVO);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(ApplicationContant.SUCCESS);
		applicationMessageResponse.setMessage(ApplicationMessageConstant.TOPIC_IS_ADDED_MESSAGE);
		applicationMessageResponse.setCmessage(topicId);
	 	return applicationMessageResponse;
	}
	
	@RequestMapping(value="editTopicForm",method=RequestMethod.GET)
	public String showTechEditPage(@RequestParam("techName") String techName,Model model){
		Technology technology=technolgyCategoryService.findTechnologyByName(techName);
		//model is type of hashMap
		model.addAttribute("technology",technology);
		model.addAttribute("buttonLable","Edit");
		model.addAttribute("action","editTopicForm");
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.ADD_EDIT_TOPICS_PAGE;		
	}
	
	@RequestMapping(value="editTopicForm",method=RequestMethod.POST)
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
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.ADD_EDIT_TOPICS_PAGE;	
	}
	
	
	@RequestMapping(value="deleteTopic",method=RequestMethod.GET)
	public String deleteTechnology(Model model,HttpServletRequest request){
		String dcbox[]=request.getParameterValues("dcbox");
		List<Technology> allTechs=technolgyCategoryService.deleteTechnology(dcbox);
		model.addAttribute("allTechs",allTechs);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,ApplicationMessageConstant.TECHNOLOGY_IS_DELETE_MESSAGE);
		Technology technology=new Technology();
		//model is type of hashMap
		model.addAttribute("technology",technology);
		model.addAttribute("action","technologyForm");
		return AdminNavigationPage.ADMIN_BASE+AdminNavigationPage.ADD_EDIT_TOPICS_PAGE;
	}
	
	
	@RequestMapping(value = "deleteTopicByTid", method = RequestMethod.GET)
	@ResponseBody public ApplicationRestStatusVO deleteTopicByTid(
			@RequestParam("tid") String tid) {
		String status = topicsService.deleteTopicById(tid);
		ApplicationRestStatusVO applicationRestStatusVO=new ApplicationRestStatusVO();
		applicationRestStatusVO.setStatus(ApplicationContant.SUCCESS);
		applicationRestStatusVO.setMassage("Topic with tid "+tid+" is deleted successfully from the database.");
		return applicationRestStatusVO;
	}
	
	
	/*@ModelAttribute("testNameList")
	public List<String> populateTestNameList() {
		//Data referencing for web framework combo
		List<String> testNameList=technolgyCategoryService.findAllTestName();
		return testNameList;
	}*/
	

	@Override
	public UserId getUserIdFromSession(HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		return userId;
	}
	
	@ModelAttribute("allTechs")
	public Map<String,String> fecthAllTechnologies(Model model){
		List<Technology> allTechs=technolgyCategoryService.findAllTechnolgy();
		Map<String,String> technologyMaps=new LinkedHashMap<String,String>();
		for(Technology tech:allTechs){
			technologyMaps.put(tech.getId()+"", tech.getTname());
		}
		return technologyMaps;
	}

}
