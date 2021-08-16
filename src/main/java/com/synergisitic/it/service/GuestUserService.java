package com.synergisitic.it.service;

import java.util.List;

import com.synergisitic.it.model.AvailableGuestTest;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.web.form.GuestUserForm;

/**
 * 
 * @author Nagendra
 *
 */
public interface GuestUserService {
	public String addGuestUser(GuestUserForm guestUserForm);
	public GuestUserForm findGuestByEmailId(String email,String userSessionId);
	public AvailableGuestTest loadAvailableTestByTechTestName(String testName, String techName);
	public GuestUserForm findGuestByGeneratedTestLink(String testLink);
	public String updateGuestTestStatusByEmailId(String email, String testStatus);
	public List<GuestUserForm> findGuestUser();
	public	UserOnlineExamStatus findGuestTestTechtStatus(String userid, String userSessionId,String testName, String techName);
	public String resetGuestUserTest(String userId, String userSessionId,boolean withHistory);
	public AvailableGuestTest findCurrentActiveGuestTechTest();
	public AvailableTest loadTestDetailsByTechTest(String techName, String testName);
	public List<GuestUserForm> findGuestUserWithSearchString(String searchString);
	public String deleteGuestUserTestLink(String userId, long gid);
	public String updateGuestUserTest(String userId, long gid, String status);
	public String updateGuestUserSessionId(String userId, long gid, String userSessionId);
	public GuestUserForm findGuestByEmailId(String email);
	public List<UserOnlineExamStatus> findGuestTestTechtStatus(String userid);
	public String updateGuestNameSalutation(GuestUserForm guestUserForm);
	public List<GuestUserForm> findPendingGuestUserTests();
	public List<GuestUserForm> findPendingGuestUserTests(String email);
}
