package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.GuestUserDao;
import com.synergisitic.it.model.AvailableGuestTest;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.GuestUserEntity;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.service.GuestUserService;
import com.synergisitic.it.web.form.GuestUserForm;

/**
 * 
 * @author Nagendra
 *
 */
@Service("GuestUserServiceImpl")
public class GuestUserServiceImpl implements GuestUserService {
	
	@Autowired
	@Qualifier("GuestUserDaoImpl")
	private GuestUserDao guestUserDao;
	
	@Override
	public String updateGuestNameSalutation(GuestUserForm guestUserForm) {
		  GuestUserEntity entity=new GuestUserEntity();
		  BeanUtils.copyProperties(guestUserForm,  entity);
		  return guestUserDao.updateGuestNameSalutation(entity);
	}
	
	@Override
	public String updateGuestUserSessionId(String userId, long gid, String userSessionId){
		 return guestUserDao.updateGuestUserSessionId(userId,gid, userSessionId);
	}
	
	
	@Override
	public String updateGuestUserTest(String userId, long gid, String status){
		 return guestUserDao.updateGuestUserTest(userId,gid, status);
	}
	
	@Override
	public String deleteGuestUserTestLink(String userId, long gid) {
		 return guestUserDao.deleteGuestUserTest(userId,gid);
	}

	@Override
	public String resetGuestUserTest(String userId,String userSessionId,boolean withHistory) {
		 return guestUserDao.resetGuestUserTest(userId,userSessionId,withHistory);
	}
	
	@Override
	public List<UserOnlineExamStatus> findGuestTestTechtStatus(String userid) {
		 return guestUserDao.findGuestTestTechtStatus(userid);
	}
	
	@Override
	public UserOnlineExamStatus findGuestTestTechtStatus(String userid,String userSessionId,String testName,String techName) {
		 return guestUserDao.findGuestTestTechtStatus(userid,userSessionId, testName, techName);
	}
	
	
	@Override
	public List<GuestUserForm> findGuestUserWithSearchString(String searchString){
		List<GuestUserForm> guestUsers=new ArrayList<GuestUserForm>();
		List<GuestUserEntity>  guestUserEntityList=guestUserDao.findGuestUserWithSearchString(searchString);
		for(GuestUserEntity gue: guestUserEntityList){
			GuestUserForm guestUserForm=new GuestUserForm();
			BeanUtils.copyProperties(gue,guestUserForm);
			guestUsers.add(guestUserForm);
		}
		return guestUsers;
	}
	
	@Override
	public List<GuestUserForm> findGuestUser(){
		List<GuestUserForm> guestUsers=new ArrayList<GuestUserForm>();
		List<GuestUserEntity>  guestUserEntityList=guestUserDao.findGuestUser();
		for(GuestUserEntity gue: guestUserEntityList){
			GuestUserForm guestUserForm=new GuestUserForm();
			BeanUtils.copyProperties(gue,guestUserForm);
			guestUsers.add(guestUserForm);
		}
		return guestUsers;
	}
	
	@Override
	public List<GuestUserForm> findPendingGuestUserTests() {
		List<GuestUserForm> guestUsers=new ArrayList<GuestUserForm>();
		List<GuestUserEntity>  guestUserEntityList=guestUserDao.findPendingGuestUserTests();
		for(GuestUserEntity gue: guestUserEntityList){
			GuestUserForm guestUserForm=new GuestUserForm();
			BeanUtils.copyProperties(gue,guestUserForm);
			guestUsers.add(guestUserForm);
		}
		return guestUsers;
	}
	
	@Override
	public List<GuestUserForm> findPendingGuestUserTests(String email) {
		List<GuestUserForm> guestUsers=new ArrayList<GuestUserForm>();
		List<GuestUserEntity>  guestUserEntityList=guestUserDao.findPendingGuestUserTests(email);
		for(GuestUserEntity gue: guestUserEntityList){
			GuestUserForm guestUserForm=new GuestUserForm();
			BeanUtils.copyProperties(gue,guestUserForm);
			guestUsers.add(guestUserForm);
		}
		return guestUsers;
	}
	
	@Override
	public String addGuestUser(GuestUserForm guestUserForm) {
		GuestUserEntity guestUserEntity=new GuestUserEntity();
		BeanUtils.copyProperties(guestUserForm,guestUserEntity);
		return guestUserDao.addGuestUser(guestUserEntity);
	}
	
	@Override
	public String updateGuestTestStatusByEmailId(String email,String testStatus) {
		return guestUserDao.updateGuestTestStatusByEmailId(email,testStatus);
	}
	
	@Override
	public GuestUserForm findGuestByEmailId(String email){
		GuestUserEntity guestUserEntity= guestUserDao.findGuestByEmailId(email);
		GuestUserForm guestUserForm=new GuestUserForm();
		BeanUtils.copyProperties(guestUserEntity,guestUserForm);
		return guestUserForm;
	}

	@Override
	public GuestUserForm findGuestByEmailId(String email,String userSessionId) {
		GuestUserEntity guestUserEntity= guestUserDao.findGuestByEmailId(email,userSessionId);
		GuestUserForm guestUserForm=new GuestUserForm();
		BeanUtils.copyProperties(guestUserEntity,guestUserForm);
		return guestUserForm;
	}
	
	@Override
	public GuestUserForm findGuestByGeneratedTestLink(String testLink) {
		GuestUserEntity guestUserEntity= guestUserDao.findGuestByGeneratedTestLink(testLink);
		GuestUserForm guestUserForm=new GuestUserForm();
		BeanUtils.copyProperties(guestUserEntity,guestUserForm);
		return guestUserForm;
	}
	
	
	@Override
	public AvailableGuestTest loadAvailableTestByTechTestName(String techName,String testName) {
		return guestUserDao.loadAvailableTestByTechTestName(techName, testName);
	}
	
	/**
	 * 
	 */
	@Override
	public AvailableTest loadTestDetailsByTechTest(String techName,String testName) {
		return guestUserDao.loadTestDetailsByTechTest(techName, testName);
	}
	
	@Override
	public AvailableGuestTest findCurrentActiveGuestTechTest() {
		return guestUserDao.findCurrentActiveGuestTechTest();
	}
}
