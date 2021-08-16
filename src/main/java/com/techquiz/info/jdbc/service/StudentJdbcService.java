package com.techquiz.info.jdbc.service;

import java.util.List;

import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.UserForm;

public interface StudentJdbcService {

  	public List<String> findAllDifferentGroups();
	public List<UserForm> loadUserByGroupName(String groupName) ;
	public AssignedTestUserForm findUserAssignedTestDetailByTestName(String techName, String userid);

}
