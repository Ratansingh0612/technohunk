package com.techquiz.programys.common.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.synergisitic.it.navigation.UserNavigationPage;

/**
 * @author nagendra
 * @since 14-06-2018
 */
@Controller
public class TechnologyNotesController {
	
	
	@PostConstruct
	public void init() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!TechnologyNotesControllerTechnologyNotesController");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!TechnologyNotesControllerTechnologyNotesController");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!TechnologyNotesControllerTechnologyNotesController");
	}

	
	@GetMapping("soap-web-service-notes")
	public String fetchSpringInterviewQuestions(Model model) {
		return UserNavigationPage.PUBLIC_BASE + UserNavigationPage.SOAP_WEB_SERVICE_NOTES_PAGE;
	}
	
	
	@GetMapping("java-full-stack-developer")
	public String javaFullStackDeveloper(Model model) {
		return UserNavigationPage.PUBLIC_BASE + UserNavigationPage.JAVA_FULL_STACK_DEVELOPER_PAGE;
	}
	
}
