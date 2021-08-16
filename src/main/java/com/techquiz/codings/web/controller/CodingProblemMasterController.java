package com.techquiz.codings.web.controller;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.codings.service.CodingProblemsService;
import com.techquiz.codings.service.TestCasesProblemService;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;

/**
 * 
 * @author nagendra
 * @since 13-Aug-2018
 *
 */
@Controller
@RequestMapping("/codings")
public class CodingProblemMasterController {
	
	
	@Value("${author.name}")
	private String authorName;
	
	@Value("${code.image.icon}")
	private String codeImageIcon;
	
	
	@Autowired
	@Qualifier("CodingProblemsServiceImpl")
	private CodingProblemsService codingProblemsService;
	
	@Autowired
	@Qualifier("TestCasesProblemServiceImpl")
	private TestCasesProblemService testCasesProblemService;
	
	public CodingProblemMasterController(){
		System.out.println("!!!CodingProblemMasterController----");
	}
	
	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "find-test-cases-by-problemid", method = RequestMethod.GET)
	@ResponseBody public CodingProblemsVO findAvailableTestCasesByCPid(@RequestParam("cpid") long cpid) {
		return codingProblemsService.findCodingProblemsByProbId(cpid);
	}
	
	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "delete-particular-test-case", method = RequestMethod.GET)
	@ResponseBody public ApplicationMessageResponse deleteParticularTestCase(@RequestParam("pid") long cpid,@RequestParam("input") String input,@RequestParam("expectedOutput") String output) {
		String status=testCasesProblemService.deleteTestCaseForProblem(cpid, input, output);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus(status);
		applicationMessageResponse.setMessage("Test case is deleted successfully from the database for selected problem id "+cpid);
		return applicationMessageResponse;
	}
	
	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "add-new-testcase-for-problem", method = RequestMethod.POST)
	@ResponseBody public CodingProblemsVO addNewTestCaseForProblem(@RequestParam("cpid") long cpid,@RequestParam("testInput") String input,@RequestParam("expectedTestOutput") String output,String description) {
		return testCasesProblemService.addTestCaseForProblem(cpid, input, output, description);
	}

	/**
	 * 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "add-coding-problem", method = RequestMethod.GET)
	public String addCodingProblem(Model model,HttpSession session) {
			CodingProblemsVO codingProblemsVO = new CodingProblemsVO();
			model.addAttribute("codingProblemsVO", codingProblemsVO);
			model.addAttribute("action","add-coding-problem");
			return UserNavigationPage.TRAINER_BASE + UserNavigationPage.ADD_CODING_PROBLEM_PAGE; 
	}
	
	/**
	 * 
	 * @param codingProblemsVO
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "add-coding-problem", method = RequestMethod.POST)
	 public String addCodingProblemPost(@ModelAttribute CodingProblemsVO codingProblemsVO,HttpSession session,Model model) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		codingProblemsVO.setUserid(userId.getLoginId());
		codingProblemsVO.setAuthor(authorName);
		codingProblemsVO.setReadMore("TODO");
		codingProblemsVO.setImage(codeImageIcon);
		Timestamp currentTime=DateUtils.getCurrentTimeIntoTimestamp();
		codingProblemsVO.setDoe(currentTime);
		codingProblemsVO.setDom(currentTime);
		System.out.println(codingProblemsVO);
		codingProblemsService.addCodingProblem(codingProblemsVO);
		model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE, ApplicationMessageConstant.CONDING_PROBLEM_HAS_BEEN_ADDED_INTO_DATABASE_SUCCESSFULLY);
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.ADD_CODING_PROBLEM_PAGE; 
	}
	
	/**
	 * 
	 * @param codingProblemsVO
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update-coding-problem", method = RequestMethod.POST)
	@ResponseBody public ApplicationMessageResponse  updateCodingProblem(@RequestParam("problemId") String problemId,
			@RequestParam("problemTitle") String problemTitle,@RequestParam("level") String level,@RequestParam("duration") String duration,HttpSession session,Model model) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		Timestamp currentTime=DateUtils.getCurrentTimeIntoTimestamp();
		CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
		codingProblemsVO.setCpid(Long.parseLong(problemId));
		codingProblemsVO.setDom(currentTime);
		codingProblemsVO.setTitle(problemTitle);
		codingProblemsVO.setLevel(level);
		codingProblemsVO.setDuration(Integer.parseInt(duration));
		codingProblemsVO.setUserid(userId.getLoginId());
		codingProblemsService.updateCodingProblem(codingProblemsVO);
		ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
		applicationMessageResponse.setStatus("success");
		applicationMessageResponse.setMessage("Problem has been updated successfully!");
		return applicationMessageResponse;
	}
	
	@ModelAttribute("techNameList")
	public Map<Integer,String> loadTechNameList(){
		Map<Integer,String> techNameList=new LinkedHashMap<Integer,String>();
		techNameList.put(1, "JAVA");
		techNameList.put(2, "SQL");
		techNameList.put(3, "Python");
		return techNameList;
	}
	
	@ModelAttribute("complexity")
	public Map<String,String> loadProblemComplexity(){
		Map<String,String> problemComplexity=new LinkedHashMap<String,String>();
		problemComplexity.put("Simple", "Simple");
		problemComplexity.put("Medium", "Medium");
		problemComplexity.put("Difficult", "Difficult");
		return problemComplexity;
	}
	
	@ModelAttribute("timeduration")
	public Map<Integer,Integer> loadTimeDuration(){
		Map<Integer,Integer> timeduration=new LinkedHashMap<Integer,Integer>();
		for(int x=10;x<=60;x=x+5){
			timeduration.put(x, x);	
		}
		return timeduration;
	}

}
