package com.synergisitic.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.UserDao;
import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.StudentLoginEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.util.ApplicationContant;
import com.techquiz.trainer.dao.entity.ApprovePendingUserEntity;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(UserDaoImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String addUser(User user) {
		Query query = em.createQuery("from User as ut where ut.loginid=?");
		query.setParameter(1, user.getLoginid());
		List<User> userList = query.getResultList();
		if (userList != null && userList.size() > 0) {
			return ApplicationContant.USER_ALREADY_EXISTS;
		}
		em.persist(user);
		return "success";
	}

	/**
	 * This method will validate userid & password for logged in user into the
	 * application.
	 */
	@Override
	public User validateUser(String username,String password) {
		String namedQuery="from User as u where u.loginid=:plogin and u.password=:ppassword";
		Query query = em.createQuery(namedQuery);
		query.setParameter("plogin", username);
		query.setParameter("ppassword",password);
		try {
			User duser = (User) query.getSingleResult();
			if (logger.isInfoEnabled()) {
				logger.info(duser);
			}
			return duser;
		} catch (NoResultException e) {
			query = em
					.createQuery("from ConsultantsEntity as ce where (ce.userid=? or ce.email=?) and ce.password=?");
			query.setParameter(1, username);
			query.setParameter(2, username);
			query.setParameter(3, password);
			User cuser=new User();
			try {
			ConsultantsEntity  consultantsEntity = (ConsultantsEntity) query.getSingleResult();
			cuser.setLoginid(consultantsEntity.getUserid());
			cuser.setBatch(consultantsEntity.getBatch());
			cuser.setConsultantid(consultantsEntity.getEmpid());
			cuser.setRole(consultantsEntity.getRole());
			cuser.setPassword(consultantsEntity.getPassword());
			cuser.setEmail(consultantsEntity.getEmail());
			cuser.setGender(consultantsEntity.getGender());
			cuser.setMobile(consultantsEntity.getMobile());
			cuser.setFirstName(consultantsEntity.getName());
			cuser.setStream(consultantsEntity.getStream());
			cuser.setActive(consultantsEntity.getActive());
			cuser.setLockStatus(consultantsEntity.getLockStatus());
			cuser.setAddress(consultantsEntity.getOrg());
			return cuser;
			}catch(Exception exe){
			query = em
					.createQuery("from StudentLoginEntity as sle where sle.studentRoll=? and sle.password=?");
			query.setParameter(2, password);
			query.setParameter(1, username);
			try {
				StudentLoginEntity duser = (StudentLoginEntity) query.getSingleResult();
				 cuser=new User();
				cuser.setLoginid(duser.getStudentRoll());
				cuser.setRole(duser.getRole());
				cuser.setPassword(duser.getPassword());
				cuser.setActive(duser.getLocked());
				return cuser;
			} catch (Exception ex) {
				System.out.println("__@___user is not valid.."+ex.getMessage());
			}
			}	
			
			if (logger.isWarnEnabled()) {
				logger.warn("User does not exist!");
				logger.warn(e.getMessage());
			}
			return null;
		}
	}
	
	@Override
	public String resetConsultantPassword(String username,String email,String newpassword) {
		Query query=em.createQuery("update ConsultantsEntity as u set u.password=? where u.userid=? and u.email=?");
		query.setParameter(1, newpassword);
		query.setParameter(2, username);
		query.setParameter(3, email);
		int status=query.executeUpdate();
		return status==1?"success":"fail";
	}
	
	@Override
	public String resetGroupPasswords(String groupName,String newpassword) {
		Query query=em.createQuery("update ConsultantsEntity as u set u.password=? where u.batch=?");
		query.setParameter(1, newpassword);
		query.setParameter(2, groupName);
		int status=query.executeUpdate();
		return status==1?"success":"fail";
	}
	
	@Override
	public String deleteConsultant(String groupName,String email) {
		Query query=em.createQuery("delete from ConsultantsEntity as u where u.batch=? and u.email=?");
		query.setParameter(1, groupName);
		query.setParameter(2, email);
		int status=query.executeUpdate();
		return status==1?"success":"fail";
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User findUserById(int id) {
		return em.find(User.class, id);
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User findUserByLoginId(String loginid) {
		Query query=em.createQuery("from User where loginid=?");
		query.setParameter(1, loginid);
		return (User)query.getSingleResult();
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User findUserByEmailId(String email) {
		try {
			Query query=em.createQuery("from User where email=?");
			query.setParameter(1, email);
			return (User)query.getSingleResult();
		}catch(Exception ex){
			Query query = em
					.createQuery("from ConsultantsEntity as ce where (ce.userid=? or ce.email=?)");
			query.setParameter(1, email);
			query.setParameter(2, email);
			User cuser=new User();
			try {
					ConsultantsEntity  consultantsEntity = (ConsultantsEntity) query.getSingleResult();
					cuser.setLoginid(consultantsEntity.getUserid());
					cuser.setBatch(consultantsEntity.getBatch());
					cuser.setConsultantid(consultantsEntity.getEmpid());
					cuser.setRole(consultantsEntity.getRole());
					cuser.setPassword(consultantsEntity.getPassword());
					cuser.setEmail(consultantsEntity.getEmail());
					cuser.setGender(consultantsEntity.getGender());
					cuser.setMobile(consultantsEntity.getMobile());
					cuser.setFirstName(consultantsEntity.getName());
					cuser.setStream(consultantsEntity.getStream());
					cuser.setActive(consultantsEntity.getActive());
					cuser.setLockStatus(consultantsEntity.getLockStatus());
					cuser.setAddress(consultantsEntity.getOrg());
					return cuser;
			 }catch(Exception ee){
					User puser=new User();
					return puser;
			 }	
		 }
	}

	@Override
	public String updateUser(User user) {
		
		User duser = em.getReference(User.class, user.getId());
		duser.setEmail(user.getEmail());
		duser.setMobile(user.getMobile());
		duser.setGender(user.getGender());
		duser.setStream(user.getStream());
		if(user.getPhoto()!=null && user.getPhoto().length>0)
		duser.setPhoto(user.getPhoto());
		return "success";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String changePassword(User user) {
		Query query=em.createQuery("from User as ce where ce.loginid=?");
		query.setParameter(1, user.getLoginid());
		try {
			User duser=(User)query.getSingleResult();
			duser.setPassword(user.getPassword());
		}catch(Exception ex){
			Query cquery=em.createQuery("from ConsultantsEntity as ce where ce.userid=?");
			cquery.setParameter(1, user.getLoginid());
			ConsultantsEntity consultantsEntity=(ConsultantsEntity)cquery.getSingleResult();
			consultantsEntity.setPassword(user.getPassword());
		}
		return "success";
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	/**
	 * This code will not execute inside the transaction
	 * readOnly=true = means we are not suppose to update the data inside this method
	 */
	public List<User> findAllUsers() {
		String namedQuery="from User";
		Query query = em.createQuery(namedQuery);
		List<User> usersList = query.getResultList();
		return usersList;
	}
	
	@Override
	public List<User> findAllUserByRole(String role) {
		Query query=em.createQuery("from User where role=? order by doe desc");
		query.setParameter(1,role);
		List<User> userList=query.getResultList();
		return userList;
	}
	
	
	@Override
	public String deleteUserById(String uid) {
		Query query = em.createQuery("delete from User u where u.id=?");
		query.setParameter(1, Integer.parseInt(uid));
		int status = query.executeUpdate();
		return status==1?"success":"fail";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<User> deleteUser(String[] userCb) {
		for (String userCbId : userCb) {
			Query query = em.createQuery("delete from User u where u.id=?");
			query.setParameter(1, Integer.parseInt(userCbId));
			int q = query.executeUpdate();
		}
		return findAllUsers();
	}

	/*
	 * @Override
	 * 
	 * @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	 */
	/*
	 * public List<User> editUser(String kk) {
	 * 
	 * Query
	 * query=em.createQuery("update user_tbl set email=?"+" where u.id=?");
	 * query.setParameter(1,"Astha");
	 * query.setParameter(2,Integer.parseInt(kk)); int q=query.executeUpdate();
	 * 
	 * return findAllUsers(); }
	 */

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserOnlineExamStatus> findAllUserOnlineExamStatus(String userId) {
		String namedQuery="from UserOnlineExamStatus as uoes where uoes.userId=?";
		Query query = em
				.createQuery(namedQuery);
		query.setParameter(1, userId);
		List<UserOnlineExamStatus> userList=query.getResultList();
		return userList;
	}
	
	@Override
	public UserOnlineExamStatus findUserOnlineExamStatusBySessionid(String userId,String userSessionId) {
		String hql="from UserOnlineExamStatus as uoes where uoes.userId=? and userSessionId=?";
		Query query = em
				.createQuery(hql);
		query.setParameter(1, userId);
		query.setParameter(2, userSessionId);
		List<UserOnlineExamStatus> userList=query.getResultList();
		if(userList!=null && userList.size()>0 ){
			return userList.get(0);
		}else{
			return new UserOnlineExamStatus();
		}
	}

	/**
	 * 
	 */
	@Override
	public byte[] findPhotoByUserId(String userid) {
		System.out.println(userid+"= =========findPhotoByUserId================");
		byte[] photo={};
		Query query = em.createQuery("from User as u where u.loginid=?");
		query.setParameter(1, userid);
		try {
			User user = (User) query.getSingleResult();
			photo=user.getPhoto();
		}catch(Exception ex){
			try {
				query = em
					.createQuery("from ConsultantsEntity as ce where ce.userid=?");
				query.setParameter(1,userid);
				ConsultantsEntity  consultantsEntity = (ConsultantsEntity) query.getSingleResult();
				photo=consultantsEntity.getImage();
			}catch(Exception e){
				System.out.println("Profile image is not in db");
				//e.printStackTrace();
			}
		}
		return photo;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<AssignedTestUser> findAllAssignedTestUsers(String selectedGroupName,String testname) {
		Query query=em.createQuery("from AssignedTestUser where groupName=? and techName=?");
		query.setParameter(1, selectedGroupName);
		query.setParameter(2, testname);
		return query.getResultList();
	}

	@Override
	public List<AssignedTestUser> findTestNotStartedUser(String loginid) {
		Query query=em.createQuery("from AssignedTestUser where userId=? and testStatus=?");
		query.setParameter(1, loginid);
		query.setParameter(2, "Not Started");
		List<AssignedTestUser> userList=query.getResultList();
		return userList;
	}
	
	
	@Override
	public String lockUnlockUser(String userid,String active) {
			Query query=em.createQuery("update ConsultantsEntity as u set u.active=? where u.userid=?");
			query.setParameter(1, active);
			query.setParameter(2, userid);
			int status=query.executeUpdate();
			return status==1?"success":"fail";
	}
	
	@Override
	public String approveUserForApp(ApprovePendingUserEntity approvePendingUserEntity) {
			Query query=em.createQuery("update User as u set u.id=?,u.batch=?,u.stream=?,u.consultantid=?,u.role=?,u.active=? where u.email=?");
			String consultantid=approvePendingUserEntity.getConsultantid();
			if(consultantid.startsWith("E") || consultantid.startsWith("e")){
				approvePendingUserEntity.setConsultantid(consultantid.substring(1));
			}
			query.setParameter(1, Integer.parseInt(approvePendingUserEntity.getConsultantid()));
			query.setParameter(2, approvePendingUserEntity.getStream());
			query.setParameter(3, approvePendingUserEntity.getStream());
			query.setParameter(4, approvePendingUserEntity.getConsultantid());
			query.setParameter(5, approvePendingUserEntity.getRole());
			query.setParameter(6, approvePendingUserEntity.getActive());
			query.setParameter(7, approvePendingUserEntity.getEmail());
			int status=query.executeUpdate();
			return status==1?"success":"fail";
	}
	

	@Override
	public void updateLockStatus(String loginid,String loggedRole,String lockStatus) {
		if(ApplicationContant.ADMIN_ROLE.equalsIgnoreCase(loggedRole)){
			Query query=em.createQuery("update User as u set u.lockStatus=? where u.loginid=? ");
			query.setParameter(1, lockStatus);
			query.setParameter(2, loginid);
			query.executeUpdate();
		}else{
			Query query=em.createQuery("update ConsultantsEntity as u set u.lockStatus=? where u.userid=? ");
			query.setParameter(1, lockStatus);
			query.setParameter(2, loginid);
			query.executeUpdate();
		}
	}
	
	@Override
	public List<User> findAllTrainer() {
		Query query = em.createQuery("from User as ut where ut.role=?");
		query.setParameter(1, ApplicationContant.TRAINER_ROLE);
		List<User> userList = query.getResultList();
		return userList;
	}
	
}
