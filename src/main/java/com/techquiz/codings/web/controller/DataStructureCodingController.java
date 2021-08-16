package com.techquiz.codings.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergisitic.it.navigation.CodingsNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.codings.service.CodingProblemsService;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;

/**
 * 
 * @author VC1
 * @Since 15-OCT-2108
 *
 */
@Controller
@RequestMapping("/codings")
public class DataStructureCodingController {
	
	@Autowired
	private CodingProblemsService codingProblemService; 
	
	
	/**
	 * 
	 * @param problemId
	 * @param session
	 * @param model
	 */
	private void loadCodingProblemData(long problemId,HttpSession session,Model model){
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		String sproblemId="";
		if(problemId==0){
			sproblemId=userId.getProblemId();
		}else{
			sproblemId=""+problemId;
		}
		CodingProblemsVO codingProblemsVO=codingProblemService.findCodingProblemsByProbId(Long.parseLong(sproblemId));
		model.addAttribute("codingProblemsVO",codingProblemsVO);
		model.addAttribute("item",codingProblemsVO);
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/ds/write-code-binary-search-tree")
	public String writeCodeBinarySearchTree(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.DS+ CodingsNavigationPage.WRITE_CODE_BINARY_SEARCH_TREE_PAGE;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/ds/write-code-binary-search-tree-preorder-traversal")
	public String writeCodeBinarySearchTreePreorderTraversal(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.DS+ CodingsNavigationPage.WRITE_CODE_BINARY_SEARCH_TREE_PREORDER_TRAVERSAL_PAGE;
	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/ds/code-count-leaf-node-in-bsearch-tree")
	public String codeCountLeafNodeInBsearchTree(Model model,@RequestParam(value="problemId",required=false,defaultValue="0") long problemId,HttpSession session){
		loadCodingProblemData(problemId,session,model);
		return UserNavigationPage.CODINGS_BASE +CodingsNavigationPage.DS+ CodingsNavigationPage.CODE_COUNT_LEAF_NODE_IN_BSEARCH_TREE_PAGE;
	}
	
	
}
