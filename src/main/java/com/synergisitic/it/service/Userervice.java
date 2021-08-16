package com.synergisitic.it.service;

import java.util.List;

import com.synergisitic.it.model.User;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.UserForm;
import com.synergisitic.it.web.form.UserOnlineExamStatusForm;
import com.techquiz.trainer.web.rest.api.vo.ApprovePendingUserVO;

public interface Userervice {
	
	 public String addUser(User user);
	 
	 public String updateUser(User user);
	 
	 public String changePassword(User user); 
	 
	 public User  validateUser(String username,String password);
	 
	 public User findUserById(int id) ;
	 
	 public List<UserForm> findAllUsers();
	 
	 public List<UserForm> deleteUser(String userCb[]);
	 
//	public List<UpdateAllUserDetails> editUser(String kk);

	 public List<UserOnlineExamStatusForm> findAllUserOnlineExamStatus(String userId);
	 
	public byte[] findPhotoByUserId(String userid);
	
	public List<AssignedTestUserForm> findAllAssignedTestUsers(String selectedGroupName,String testname);
	
	public List<AssignedTestUserForm> findTestNotStartedUser(String loginid);
	
	public void updateLockStatus(String loginid,String loggedRole,String lockStatus);

	public User findUserByLoginId(String loginid);

	public String lockUnlockUser(String userid, String lockStatus);

	public List<UserForm> findAllUserByRole(String role);

	public String approveUserForApp(ApprovePendingUserVO approvePendingUserVO);

	public List<UserForm> findAllTrainer();

	public UserOnlineExamStatusForm findUserOnlineExamStatusBySessionid(String userId, String userSessionId);

	public String deleteUserById(String uid);

	public User findUserByEmailId(String loginid);

	public String resetConsultantPassword(String username, String email, String newpassword);

	public String resetGroupPasswords(String groupName, String newpassword);

	public	String deleteConsultant(String groupName, String email);


}
