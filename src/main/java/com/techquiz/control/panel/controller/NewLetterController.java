package com.techquiz.control.panel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.util.DateUtils;
import com.techquiz.control.panel.controller.model.NewsLetterVO;
import com.techquiz.control.panel.service.NewsLetterService;
import com.techquiz.programys.common.vo.ApplicationMessageResponse;

@Controller
public class NewLetterController {

	@Autowired
	@Qualifier("NewsLetterServiceImpl")
	private NewsLetterService newsLetterService;
	
	@RequestMapping("register-news-letter")
	@ResponseBody	public ApplicationMessageResponse registerNewsLetter(@RequestParam("email") String email,Model model){
		
		NewsLetterVO newsLetterVO=new NewsLetterVO();
		newsLetterVO.setEmail(email);
		newsLetterVO.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		newsLetterVO.setDom(DateUtils.getCurrentTimeIntoTimestamp());
		newsLetterService.registerNewsLetters(newsLetterVO);
		ApplicationMessageResponse aMessageResponse=new ApplicationMessageResponse();
		aMessageResponse.setStatus(ApplicationContant.SUCCESS);
		aMessageResponse.setMessage(ApplicationMessageConstant.YOU_HAVE_SUCCESSFULLY_REGISTERED_WITH_US_FOR_NOTIFICATION);
		return aMessageResponse;
	}
	

}
