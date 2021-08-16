package com.techquiz.info.jdbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.User;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.UserForm;
import com.techquiz.info.jdbc.dao.StudentJdbcDao;
import com.techquiz.info.jdbc.service.StudentJdbcService;
import com.techquiz.trainer.dao.IConsultantAssesmentDao;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;

@Service("StudentJdbcServiceImpl")
public class StudentJdbcServiceImpl implements StudentJdbcService {
	
	@Autowired
	@Qualifier("StudentJdbcDaoImpl")
	private StudentJdbcDao studentJdbcDao;
	
	
	@Autowired
	@Qualifier("ConsultantAssesmentDao")
	private IConsultantAssesmentDao consultantAssesmentDao;
	
	
	@Override
	public List<String> findAllDifferentGroups(){
		return studentJdbcDao.findAllDifferentGroups();
	}
	
	@Override
	public AssignedTestUserForm findUserAssignedTestDetailByTestName(String techName,String userid) {
		AssignedTestUser assignedTestUser=studentJdbcDao.findUserAssignedTestDetailByTestName(techName,userid);
		if(assignedTestUser==null)
			return null;
		AssignedTestUserForm assignedTestUserForm=new AssignedTestUserForm();
		BeanUtils.copyProperties(assignedTestUser, assignedTestUserForm);
		return assignedTestUserForm;
	}

	@Override
	public List<UserForm> loadUserByGroupName(String groupName) {
		List<User> usersList=null;
		try {
			usersList= studentJdbcDao.loadUserByGroupName(groupName);
		}catch(Exception ex){
			System.out.println("loadUserByGroupName in service.."+ex.getMessage());
		}
		if(usersList==null || usersList.size()==0){
			List<ConsultantsEntity> consultantsEntityList=new ArrayList<ConsultantsEntity>();
			if(ApplicationContant.ALL.equalsIgnoreCase(groupName)){
				consultantsEntityList= consultantAssesmentDao.findAllConsultants();
			}else {
				consultantsEntityList= consultantAssesmentDao.findConsultantsByBatch(groupName);
			}
			List<UserForm> userList=new ArrayList<UserForm>(consultantsEntityList.size());
			for(ConsultantsEntity consultantsEntity:consultantsEntityList){
				 UserForm userForm=new UserForm();
				  userForm.setId(consultantsEntity.getCid());
				  userForm.setEmail(consultantsEntity.getEmail());
				  userForm.setFirstName(consultantsEntity.getName());
				  userForm.setLastName("");
				  userForm.setPassword(consultantsEntity.getPassword());
				  userForm.setLoginid(consultantsEntity.getUserid());
				  userForm.setMobile(consultantsEntity.getMobile());
				  userForm.setRole(consultantsEntity.getRole());
					if(ApplicationContant.USER_LOCKED.equalsIgnoreCase(consultantsEntity.getLockStatus())) {
						userForm.setLockStatus(ApplicationContant.USER_LOCKED);
					}else{
						userForm.setLockStatus(ApplicationContant.USER_UNLOCKED);
					}
				  userList.add(userForm);
			}
			return userList;
		}else {
			return convertEntity(usersList);
		}	
	}
	
	private List<UserForm>  convertEntity(List<User> users){
		List<UserForm> userList=new ArrayList<UserForm>(users.size());
		for(User u:users){
		  UserForm userForm=new UserForm();
		  userForm.setAddress(u.getAddress());
		  userForm.setDescription(u.getDescription());
		  userForm.setId(u.getId());
		  userForm.setDob(u.getDob());
		  userForm.setDoe(u.getDoe());
		  userForm.setEmail(u.getEmail());
		  userForm.setFirstName(u.getFirstName());
		  userForm.setLastName(u.getLastName());
		  userForm.setLoginid(u.getLoginid());
		  userForm.setMobile(u.getMobile());
		  userForm.setPassword(u.getPassword());
		  userForm.setRole(u.getRole());
		  userList.add(userForm);
		}
		return userList;
	}


}
