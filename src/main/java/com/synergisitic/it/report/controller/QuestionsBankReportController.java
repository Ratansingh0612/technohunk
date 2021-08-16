package com.synergisitic.it.report.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.synergisitic.it.service.OnlineTechTestService;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.synergisitic.it.web.form.QuestionAndAnswers;
import com.synergisitic.it.web.form.QuestionsForm;
import com.techquiz.info.jdbc.service.UploadRecordExcelService;

/**
 * 
 * @author nagendra 
 *  this class is used to download the questions bank as excel sheet!
 */
@Controller
public class QuestionsBankReportController {
	
	
	@Autowired
	@Qualifier("UploadRecordExcelServiceImpl")
	private UploadRecordExcelService uploadRecordExcelService;
	
	@Autowired
	@Qualifier("OnlineTechTestServiceImpl")
	private OnlineTechTestService onlineTechTestService;
	

	 /*
	  * Handle request to download an Excel document
	     */
	    @RequestMapping(value = "/questions-bank-with-answers-excel", method = RequestMethod.POST)
	    public ModelAndView downloadExcel(@RequestParam("qbankName") String qbankName,@RequestParam("techName") String techName,Model model,HttpSession session) {
	        // create some sample data
	    	List<QuestionsForm> questionsInBankList=uploadRecordExcelService.findQuestionsInBankByTech(qbankName,techName);
	    	List<QuestionAndAnsTestDataVO> listQuestionAndAnswers = new ArrayList<QuestionAndAnsTestDataVO>();
	    	for(QuestionsForm questionsForm:questionsInBankList) {
	    		QuestionAndAnsTestDataVO questionAndAnsTestDataVO=onlineTechTestService.fetchNextQuestionAnswer(questionsForm.getQuestionId(),"","","","");	
	    		questionAndAnsTestDataVO.setDescription(questionsForm.getQuestionOwner());
	    		listQuestionAndAnswers.add(questionAndAnsTestDataVO);
	    	}
	        // return a view which will be resolved by an excel view resolver
	    	
	    	model.addAttribute("qbankName", qbankName);
	        return new ModelAndView("questions-bank-with-answers-excel", "listQuestionAndAnswers", listQuestionAndAnswers);
	    }
}
