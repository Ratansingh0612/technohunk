package com.techquiz.codings.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.navigation.CodingsNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.techquiz.codings.service.CodingProblemsService;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;
import com.techquiz.codings.web.controller.vo.JavaCodeResponse;
import com.techquiz.codings.web.controller.vo.JavaCodeResponseWrapper;
import com.techquiz.codings.web.controller.vo.TestCasesVO;


/**
 * 
 * @author VC1
 *
 */
@Controller
@RequestMapping("/codings")
public class ProblemProblemController {
	
	@Autowired
	private CodingProblemsService codingProblemsService;
	
	@Value("${coding.problem.pageSize}")
	private int pageSize;
	
	@Value("${app.base.url}")
	private String appBaseUrl;
	
	
	 
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/pagelists")
	public String codingProblemsListWithPagination(@RequestParam("page") int page,Model model){
		int totalProblemsCount=codingProblemsService.totalCodingProblems();
		int totalPage=totalProblemsCount/pageSize;
		if(totalProblemsCount%pageSize>0){
			totalPage=totalPage+1;
		}
		model.addAttribute("totalProblemsCount", totalProblemsCount);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", page);
		if(page<=1){
			page=0;
		}else{
			page=page-1;
		}
		List<CodingProblemsVO> codingProblemsVOs=codingProblemsService.findCodingProblemsByTech("Java", page, this.pageSize);
		for(CodingProblemsVO codingProblemsVO:codingProblemsVOs){
			//<img src="/images/codings/menu-choice-pattern.png" alt="/images/codings/menu-choice-pattern.png">Menu Choice Coding Problem
			String tdescription=codingProblemsVO.getDescription();
			tdescription=tdescription.substring(tdescription.indexOf("=\"")+2);
			tdescription="<img src=\""+appBaseUrl+tdescription;
			codingProblemsVO.setDescription(tdescription);
		}
		model.addAttribute("codingProblemsVOs",codingProblemsVOs);
		return UserNavigationPage.CODINGS_BASE + CodingsNavigationPage.CODING_LISTS_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/java/lists")
	public String codingProblemsList(@RequestParam(value="problemCategory",required=false) String problemCategory,@RequestParam(value="pc",required=false) String pc,Model model){
		
		List<CodingProblemsVO> codingProblemsVOs=new ArrayList<CodingProblemsVO>();
		if(problemCategory==null || "All".equalsIgnoreCase(problemCategory)){
			if(pc==null || "All".equalsIgnoreCase(pc)){
				codingProblemsVOs=codingProblemsService.findCodingProblemsByTech("Java");
			}else{
				codingProblemsVOs=codingProblemsService.findCodingProblemsByLevel(pc);
			}
		}else{
			if(pc==null || "All".equalsIgnoreCase(pc)){
				codingProblemsVOs=codingProblemsService.findCodingProblemsByCategory(problemCategory);	
			}else{
				codingProblemsVOs=codingProblemsService.findCodingProblemsByCategory(problemCategory,pc);
			}
		}
		
		for(CodingProblemsVO codingProblemsVO:codingProblemsVOs){
			//<img src="/images/codings/menu-choice-pattern.png" alt="/images/codings/menu-choice-pattern.png">Menu Choice Coding Problem
			String tdescription=codingProblemsVO.getDescription();
			tdescription=tdescription.substring(tdescription.indexOf("=\"")+2);
			tdescription="<img src=\""+appBaseUrl+tdescription;
			codingProblemsVO.setDescription(tdescription);
		}
		model.addAttribute("codingProblemsVOs",codingProblemsVOs);
		return UserNavigationPage.CODINGS_BASE + CodingsNavigationPage.CODING_LISTS_PAGE;
	}
	
	}
