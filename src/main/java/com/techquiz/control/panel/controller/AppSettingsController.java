package com.techquiz.control.panel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.control.panel.service.AppSettingsService;

/**
 * 
 * @author Nagendra
 *
 */
@Controller
@Scope("singleton")
public class AppSettingsController {
	
	@Autowired
	@Qualifier("AppSettingsServiceImpl")
	private AppSettingsService appSettingsService;
	
	@GetMapping("/logged-in-users")
	public String currentLoggedInUsers(Model model){
		model.addAttribute("loggedUsers", UserId.getCurrentLoggedUsers());
		return UserNavigationPage.TRAINER_BASE + CommonNavigationPage.LOGGED_USERS_PAGE;
	}
	
	//Design for GUI

}
