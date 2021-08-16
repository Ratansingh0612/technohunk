package com.synergisitic.it.dao;

import java.util.List;

import com.synergisitic.it.model.AvailableGuestTest;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.GuestUserEntity;
import com.synergisitic.it.model.UserOnlineExamStatus;

/**
 * 
 * @author Nagendra
 *
 */
public interface GuestUserDao {

	public String addGuestUser(GuestUserEntity guestUserEntity);
	public GuestUserEntity findGuestByEmailId(String email,String userSessionId);
	public AvailableGuestTest loadAvailableTestByTechTestName(String testName, String techName);
	public GuestUserEntity findGuestByGeneratedTestLink(String testLink);
	public String updateGuestTestStatusByEmailId(String email, String testStatus);
	public List<GuestUserEntity> findGuestUser();
	public UserOnlineExamStatus findGuestTestTechtStatus(String userid, String userSessionId,String testName, String techName);
	public String resetGuestUserTest(String userId,String userSessionId, boolean withHistory);
	public AvailableGuestTest findCurrentActiveGuestTechTest();
	public AvailableTest loadTestDetailsByTechTest(String techName, String testName);
	public List<GuestUserEntity> findGuestUserWithSearchString(String serachString);
	public String deleteGuestUserTest(String userId, long gid);
	public String updateGuestUserTest(String userId, long gid, String status);
	public String updateGuestUserSessionId(String userId, long gid, String userSessionId);
	public GuestUserEntity findGuestByEmailId(String email);
	public List<UserOnlineExamStatus> findGuestTestTechtStatus(String userid);
	public String updateGuestNameSalutation(GuestUserEntity guestUserEntity);
	public List<GuestUserEntity> findPendingGuestUserTests();
	public List<GuestUserEntity> findPendingGuestUserTests(String email);

}
