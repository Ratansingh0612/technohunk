package com.synergisitic.it.dao;

import java.util.List;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.User;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.techquiz.trainer.dao.entity.ApprovePendingUserEntity;

/**
 * 
 * @author nagendra.yadav This is contract for user
 * 
 */
public interface UserDao {

	public String addUser(User user);

	public String updateUser(User user);

	public String changePassword(User user);

	public User validateUser(String username,String password);

	public User findUserById(int id);

	public List<User> findAllUsers();

	public List<User> deleteUser(String userCb[]);

	public List<UserOnlineExamStatus> findAllUserOnlineExamStatus(String userId);

	public byte[] findPhotoByUserId(String userid);
	
	public List<AssignedTestUser> findAllAssignedTestUsers(String selectedGroupName,String testname);
	public List<AssignedTestUser> findTestNotStartedUser(String loginid);
	
	public void updateLockStatus(String loginid,String loggedRole,String lockStatus);

	public User findUserByLoginId(String loginid);

	public String lockUnlockUser(String userid, String lockStatus);

	public List<User> findAllUserByRole(String role);

	public String approveUserForApp(ApprovePendingUserEntity approvePendingUserEntity);

	public List<User> findAllTrainer();

	public UserOnlineExamStatus findUserOnlineExamStatusBySessionid(String userId, String userSessionId);

	public String deleteUserById(String uid);

	public User findUserByEmailId(String email);

	public String resetConsultantPassword(String username, String email, String newpassword);

	public String resetGroupPasswords(String groupName, String newpassword);

	public String deleteConsultant(String groupName, String email);

}
