package com.techquiz.info.jdbc.dao;

import java.util.List;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.User;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface StudentJdbcDao {

	public List<String> findAllDifferentGroups();

	public List<User> loadUserByGroupName(String groupName);

	public AssignedTestUser findUserAssignedTestDetailByTestName(String techName, String userid);

}
