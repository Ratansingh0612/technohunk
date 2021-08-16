package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.impl.UserDaoImpl;
import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.User;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.service.Userervice;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserOnlineExamStatusForm;
import com.techquiz.trainer.dao.entity.ApprovePendingUserEntity;
import com.techquiz.trainer.web.rest.api.vo.ApprovePendingUserVO;

/**
 * 
 * @author nagendra.yadav
 * 
 * This is service layer to interact with DAL
 * for User Entity 
 *
 */
@Service
public class UsererviceImpl implements Userervice{
	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDaoImpl userDaoImpl;
	
	@Override
	public String resetConsultantPassword(String username,String email,String newpassword) {
		return userDaoImpl.resetConsultantPassword(username,email,newpassword);
	}
	

	@Override
	public String deleteConsultant(String groupName,String email) {
		return userDaoImpl.deleteConsultant(groupName,email);
	}
	@Override
	public String resetGroupPasswords(String groupName,String newpassword) {
		return userDaoImpl.resetGroupPasswords(groupName,newpassword);
	}
	
	/**
	 * 
	 * @param user the object which has to persist into the database
	 * @return String "success" when user is persisted in database
	 */
	
	@Override
	public String addUser(User user) {
		//setting other attributes 
		return userDaoImpl.addUser(user);
	}
	
	@Override
	public String deleteUserById(String uid){
		return userDaoImpl.deleteUserById(uid);
	}
	
	/**
	 *  
	 * @param user
	 * @return User object when user is valid 
	 * return null when user does not exist into the database. 
	 */
	public User validateUser(String username,String password){
		return userDaoImpl.validateUser(username,password);
	}
	

	@Override
	public User findUserByLoginId(String loginid){
		return userDaoImpl.findUserByLoginId(loginid);
	}
	
	@Override
	public User findUserByEmailId(String loginid){
		return userDaoImpl.findUserByEmailId(loginid);
	}


	@Override
	public User findUserById(int id) {
		return userDaoImpl.findUserById(id);
	}

	@Override
	public String updateUser(User user) {
	  return userDaoImpl.updateUser(user); 
	}

	@Override
	public String changePassword(User user) {
		return userDaoImpl.changePassword(user);
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
		  userForm.setLockStatus(u.getLockStatus());
		  userList.add(userForm);
		}
		return userList;
	}

	@Override
	public List<UserForm> findAllUserByRole(String role) {
		 List<User> users=userDaoImpl.findAllUserByRole(role);
		 return convertEntity(users);
	}
	
	@Override
	public String approveUserForApp(ApprovePendingUserVO approvePendingUserVO) {
		ApprovePendingUserEntity approvePendingUserEntity=new ApprovePendingUserEntity();
		BeanUtils.copyProperties(approvePendingUserVO,approvePendingUserEntity);
		return userDaoImpl.approveUserForApp(approvePendingUserEntity);
	}

	@Override
	public List<UserForm> findAllUsers() {
		 List<User> users=userDaoImpl.findAllUsers();
		 return convertEntity(users);
	}
	
	@Override
	public List<UserForm> findAllTrainer(){
		 List<User> users=userDaoImpl.findAllTrainer();
		 return convertEntity(users);
	}
	

	@Override
	public List<UserForm> deleteUser(String[] userCb) {
		List<User> users=userDaoImpl.deleteUser(userCb);
		return convertEntity(users);
	}
	
	 /*public List<UserForm> editUser(String userCb[])
	 {
		 List<User> users = userDaoImpl.editUser(userCb);
		 return convertEntity(users);
	 }*/

	/**
	 * @param userId
	 */
	@Override
	public List<UserOnlineExamStatusForm> findAllUserOnlineExamStatus(
			String userId) {
		 List<UserOnlineExamStatus> userOnlineExamStatusList=userDaoImpl.findAllUserOnlineExamStatus(userId);
		 List<UserOnlineExamStatusForm> userOnlineExamStatusFormList=new ArrayList<UserOnlineExamStatusForm>(userOnlineExamStatusList.size());
         for(UserOnlineExamStatus userOnlineExamStatus:userOnlineExamStatusList) {
        	 UserOnlineExamStatusForm userOnlineExamStatusForm=BeanUtils.instantiate(UserOnlineExamStatusForm.class);
        	 BeanUtils.copyProperties(userOnlineExamStatus, userOnlineExamStatusForm);
        	 userOnlineExamStatusFormList.add(userOnlineExamStatusForm);
         }
		 return userOnlineExamStatusFormList;
	}

	@Override
	public byte[] findPhotoByUserId(String userid) {
		return userDaoImpl.findPhotoByUserId(userid);
	}

	@Override
	public List<AssignedTestUserForm> findAllAssignedTestUsers(String selectedGroupName,String testname) {
		
		List<AssignedTestUser> assignedTestUsers=userDaoImpl.findAllAssignedTestUsers(selectedGroupName,testname);
		List<AssignedTestUserForm> usersList=new ArrayList<AssignedTestUserForm>();
		for(AssignedTestUser testUser:assignedTestUsers){
			AssignedTestUserForm assignedTestuser=new AssignedTestUserForm();
			BeanUtils.copyProperties(testUser, assignedTestuser);
			assignedTestuser.setUserId(testUser.getAssignedTestCompositeKey().getUserId());
			assignedTestuser.setTechName(testUser.getAssignedTestCompositeKey().getTechName());
			usersList.add(assignedTestuser);
		}
		return usersList;
	}

	@Override
	public List<AssignedTestUserForm> findTestNotStartedUser(String loginid) {
		List<AssignedTestUser> users=userDaoImpl.findTestNotStartedUser(loginid);
		List<AssignedTestUserForm> usersList=new ArrayList<AssignedTestUserForm>();
		for(AssignedTestUser testUser:users){
			AssignedTestUserForm assignedTestuser=new AssignedTestUserForm();
			BeanUtils.copyProperties(testUser, assignedTestuser);
			assignedTestuser.setUserId(testUser.getAssignedTestCompositeKey().getUserId());
			assignedTestuser.setTechName(testUser.getAssignedTestCompositeKey().getTechName());
			usersList.add(assignedTestuser);
		}
		return usersList;
	}

	@Override
	public String lockUnlockUser(String userid, String lockStatus){
		 return userDaoImpl.lockUnlockUser(userid, lockStatus);
	}
	
	@Override
	public void updateLockStatus(String loginid,String loggedRole,String lockStatus) {
		userDaoImpl.updateLockStatus(loginid,loggedRole,lockStatus);
		
	}
	
	@Override
	public UserOnlineExamStatusForm findUserOnlineExamStatusBySessionid(String userId, String userSessionId){
		UserOnlineExamStatus onlineExamStatus=userDaoImpl.findUserOnlineExamStatusBySessionid(userId,userSessionId);
		UserOnlineExamStatusForm userOnlineExamStatusForm=new UserOnlineExamStatusForm();
		BeanUtils.copyProperties(onlineExamStatus, userOnlineExamStatusForm);
		return userOnlineExamStatusForm;
	}
	

//	@Override
/*	public List<User> editUser(String kk) {
		
		return userDaoImpl.editUser(kk);
	}*/
}
