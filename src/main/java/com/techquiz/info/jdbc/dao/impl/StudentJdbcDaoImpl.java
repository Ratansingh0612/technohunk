package com.techquiz.info.jdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.User;
import com.techquiz.info.jdbc.dao.StudentJdbcDao;
import com.techquiz.info.jdbc.dao.wrapper.UserVOWrapper;

@Repository("StudentJdbcDaoImpl")
@Scope("singleton")
//@Transactional(propagation = Propagation.REQUIRED)
public class StudentJdbcDaoImpl extends JdbcDaoSupport implements StudentJdbcDao {

	@Autowired
	@Qualifier("javaTechDataSource-ds")
	public void intitJdbcTemplate(DataSource dataSource) {
		super.setDataSource(dataSource);
	}	
	
	@Override
	public List<String> findAllDifferentGroups() {
		String query = "select CLASS_NAME  from groups_names_tbl";
		List<String> branchSemSecList = (List<String>) super.getJdbcTemplate()
				.queryForList(query, String.class);
		return branchSemSecList;
	}
	
	@Override
	public List<User> loadUserByGroupName(String groupName) {
		String branchSemSection[]=groupName.split("-");
		final String query = "SELECT b.f_lib_id,CONCAT(v.first_name ,' ',v.middle_name,' ',v.last_name),v.E_MAIL,v.PHONE  FROM branch_section_changes b, students v WHERE b.branch =? AND b.semester =?  AND b.section=? AND b.f_lib_id = v.lib_id"
			+ " order by  b.f_lib_id  asc";
		List<User> usersList=super.getJdbcTemplate().query(query,new Object[]{branchSemSection[0],branchSemSection[1],branchSemSection[2]},new UserVOWrapper<User>(groupName));
		return usersList;
	}
	
	@Override
	public AssignedTestUser findUserAssignedTestDetailByTestName(String techName,String userid) {
		AssignedTestUser assignedTestUser=null;
		final String query = "select * from assigned_test_user_tbl where techName=? and userid=?";
	    try {
	    	assignedTestUser=super.getJdbcTemplate().queryForObject(query,new Object[]{techName,userid},new BeanPropertyRowMapper<>(AssignedTestUser.class));
	    }catch(Exception ex){
	    	System.out.println("----------error--------------"+ex.getMessage());
	    }
		return assignedTestUser;
	}
}
