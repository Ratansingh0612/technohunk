
package com.synergisitic.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.GuestUserDao;
import com.synergisitic.it.model.AvailableGuestTest;
import com.synergisitic.it.model.AvailableTest;
import com.synergisitic.it.model.GuestUserEntity;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.DateUtils;


@Repository("GuestUserDaoImpl")
@Transactional
public class GuestUserDaoImpl  implements GuestUserDao{

	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(GuestUserDaoImpl.class);

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String updateGuestNameSalutation(GuestUserEntity guestUserEntity) {
		   //query to delete the test for guest user.....
		   Query query=em.createQuery("update GuestUserEntity set name=?,gender=?  where email=? and gid=?");
		   query.setParameter(1,guestUserEntity.getName());
		   query.setParameter(2,guestUserEntity.getGender());
		   query.setParameter(3,guestUserEntity.getEmail());
		   query.setParameter(4,guestUserEntity.getGid());
		   int  p=query.executeUpdate();
		   return p==1 ? ApplicationContant.SUCCESS : ApplicationContant.FAIL;
	}	 
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String updateGuestUserSessionId(String userId,long gid,String userSessionId) {
		   //query to delete the test for guest user.....
		   Query query=em.createQuery("update GuestUserEntity set userSessionId=?  where email=? and gid=?");
		   query.setParameter(1,userSessionId);
		   query.setParameter(2,userId);
		   query.setParameter(3,gid);
		   int  p=query.executeUpdate();
		   return p==1 ? ApplicationContant.SUCCESS : ApplicationContant.FAIL;
	}	 
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String updateGuestUserTest(String userId,long gid,String status) {
		   //query to delete the test for guest user.....
		   Query query=em.createQuery("update GuestUserEntity set testStatus=?  where email=? and gid=?");
		   query.setParameter(1,status);
		   query.setParameter(2,userId);
		   query.setParameter(3,gid);
		   int  p=query.executeUpdate();
		   return p==1 ? ApplicationContant.SUCCESS : ApplicationContant.FAIL;
	}	 
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String deleteGuestUserTest(String userId,long gid) {
		   //query to delete the test for guest user.....
		   Query query=em.createQuery("delete from GuestUserEntity as t  where t.email=? and t.gid=?");
		   query.setParameter(1,userId);
		   query.setParameter(2,gid);
		   int  p=query.executeUpdate();
		   return p==1 ? ApplicationContant.SUCCESS : ApplicationContant.FAIL;
	}	   
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public String resetGuestUserTest(String userId,String userSessionId,boolean withHistory) {
		   Query query=em.createQuery("from GuestUserEntity as t  where t.email=? and t.userSessionId=?");
		   query.setParameter(1,userId);
		   query.setParameter(2,userSessionId);
		   GuestUserEntity guestUserEntity=null;
		   try {
			   guestUserEntity=(GuestUserEntity)query.getSingleResult();
		   }catch(Exception ex){
			   ex.printStackTrace();
			    return "fail";
		   }
		   guestUserEntity.setTestStatus(ApplicationContant.NOT_STARTED);
		   guestUserEntity.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
		   int p=0;
		   if(withHistory) {
				   Query query2=em.createQuery("delete from  UserExamDetailStatus as ueds  where ueds.userId=? and ueds.userSessionId=?");
				   query2.setParameter(1,userId);
				   query2.setParameter(2,userSessionId);
				   p=query2.executeUpdate();
				   
				   Query query3=em.createQuery("delete from  UserOnlineExamStatus as uoes  where  uoes.userId=? and uoes.userSessionId");
				   query3.setParameter(1,userId);
				   query3.setParameter(2,userSessionId);
				   p=query3.executeUpdate();
				   
					/////delete data from user_exam_progress_data_tbl
					Query query4=em.createQuery("delete from UserExamProgressData uepd where uepd.userId=? and uepd.userSessionId");
					query4.setParameter(1,userId);
					query4.setParameter(2,userSessionId);
				     p=query4.executeUpdate();
					if(logger.isDebugEnabled())
						logger.debug(p+" record is deleted from user_exam_progress_data_tbl for user = "+userId);
		   }
		   return ApplicationContant.SUCCESS;
	}
	
	@Override
	public List<UserOnlineExamStatus> findGuestTestTechtStatus(String userid) {
		Query scorequery=em.createQuery("from UserOnlineExamStatus where userId=?");
		scorequery.setParameter(1, userid);
		List<UserOnlineExamStatus>  userOnlineExamStatusList=(List<UserOnlineExamStatus>)scorequery.getResultList();
		return userOnlineExamStatusList;
	}

	
	@Override
	public UserOnlineExamStatus findGuestTestTechtStatus(String userid,String userSessionId,String testName,String techName) {
		String testStatus="Not Assigned";
		UserOnlineExamStatus userOnlineExamStatus=new UserOnlineExamStatus();
		userOnlineExamStatus.setExamStatus(testStatus);
		Query query=em.createQuery("from GuestUserEntity where email=? and userSessionId=?");
		query.setParameter(1, userid);
		query.setParameter(2, userSessionId);
		try {
			GuestUserEntity guestUserEntity=(GuestUserEntity)query.getSingleResult();
			testStatus=guestUserEntity.getTestStatus();
			userOnlineExamStatus.setExamStatus(testStatus);
		}catch(Exception ex){
			System.out.println("Nagendra = "+ex.getMessage());
		}
		if(!ApplicationContant.NOT_STARTED.equalsIgnoreCase(testStatus)){
			Query scorequery=em.createQuery("from UserOnlineExamStatus where userId=? and userSessionId=?");
			scorequery.setParameter(1, userid);
			scorequery.setParameter(2, userSessionId);
			try {
		    userOnlineExamStatus=(UserOnlineExamStatus)scorequery.getSingleResult();
			}catch(Exception ex){
				System.out.println("Nagendra = "+ex.getMessage());
			}
		}
		return userOnlineExamStatus;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String addGuestUser(GuestUserEntity guestUserEntity) {
		em.persist(guestUserEntity);
		return "success";
	}
	
	
	
	@Override
	public List<GuestUserEntity> findGuestUserWithSearchString(String serachString) {
		Query query=em.createQuery("from GuestUserEntity where name LIKE :pname OR email LIKE :pemail");
		query.setParameter("pname", "%" + serachString + "%");
		query.setParameter("pemail", "%" + serachString + "%");
		List<GuestUserEntity>  guestUserEntityList=query.getResultList();
		return guestUserEntityList;
	}
	
	@Override
	public List<GuestUserEntity> findGuestUser() {
		Query query=em.createQuery("from GuestUserEntity");
		List<GuestUserEntity> guestUserEntityList=query.getResultList();
		return guestUserEntityList;
	}
	
	@Override
	public List<GuestUserEntity> findPendingGuestUserTests() {
		Query query=em.createQuery("from GuestUserEntity where testStatus='Not Started'");
		List<GuestUserEntity> guestUserEntityList=query.getResultList();
		return guestUserEntityList;
	}
	
	@Override
	public List<GuestUserEntity> findPendingGuestUserTests(String email) {
		Query query=em.createQuery("from GuestUserEntity where testStatus='Not Started' and email=?");
		query.setParameter(1, email);
		List<GuestUserEntity> guestUserEntityList=query.getResultList();
		return guestUserEntityList;
	}
	
	@Override
	public GuestUserEntity findGuestByEmailId(String email) {
		GuestUserEntity guestUserEntity=new GuestUserEntity();
		String hql="from GuestUserEntity as u where u.email=:pemail";
		Query query = em.createQuery(hql);
		query.setParameter("pemail", email);
			List<GuestUserEntity> guestUserEntityList = (List<GuestUserEntity>) query.getResultList();
			if(guestUserEntityList!=null && guestUserEntityList.size()>0){
				guestUserEntity= guestUserEntityList.get(0);
		   }
			return guestUserEntity;
	}
	
	@Override
	public GuestUserEntity findGuestByEmailId(String email,String userSessionId) {
		GuestUserEntity guestUserEntity=new GuestUserEntity();
		String hql="from GuestUserEntity as u where u.email=:pemail and u.userSessionId=:puserSessionId";
		Query query = em.createQuery(hql);
		query.setParameter("pemail", email);
		query.setParameter("puserSessionId", userSessionId);
			List<GuestUserEntity> guestUserEntityList = (List<GuestUserEntity>) query.getResultList();
			if(guestUserEntityList!=null && guestUserEntityList.size()>0){
				guestUserEntity= guestUserEntityList.get(0);
		   }
			return guestUserEntity;
	}
	
	@Override
	public String updateGuestTestStatusByEmailId(String email,String testStatus) {
			GuestUserEntity guestUserEntity=new GuestUserEntity();
			String hql="from GuestUserEntity as u where u.email=:pemail";
			Query query = em.createQuery(hql);
			query.setParameter("pemail", email);
			List<GuestUserEntity> guestUserEntityList = (List<GuestUserEntity>) query.getResultList();
			if(guestUserEntityList!=null && guestUserEntityList.size()>0){
				guestUserEntity= guestUserEntityList.get(0);
				guestUserEntity.setTestStatus(testStatus);
				//em.merge(guestUserEntity);
		   }
			return "updated";
	}
	
	@Override
	public GuestUserEntity findGuestByGeneratedTestLink(String testLink) {
		GuestUserEntity guestUserEntity=new GuestUserEntity();
		String hql="from GuestUserEntity as u where u.generatedTestLink=:ptestLink";
		Query query = em.createQuery(hql);
		query.setParameter("ptestLink", testLink);
			List<GuestUserEntity> guestUserEntityList = (List<GuestUserEntity>) query.getResultList();
			if(guestUserEntityList!=null && guestUserEntityList.size()>0){
				guestUserEntity= guestUserEntityList.get(0);
		   }
			return guestUserEntity;
	}
	
	@Override
	public AvailableGuestTest loadAvailableTestByTechTestName(String techName,String testName) {
		Query query = em
				.createQuery("from AvailableGuestTest as at where at.testName=? and at.techName=?");
		query.setParameter(1, testName);
		query.setParameter(2, techName);
		AvailableGuestTest  availableGuestTest = (AvailableGuestTest) query.getSingleResult();
		return availableGuestTest;
	}
	
	/**
	 * 
	 */
	@Override
	public AvailableTest loadTestDetailsByTechTest(String techName,String testName) {
		Query query = em
				.createQuery("from AvailableTest as at where at.testName=? and at.techName=?");
		query.setParameter(1, testName);
		query.setParameter(2, techName);
		AvailableTest  availableTest = (AvailableTest) query.getSingleResult();
		return availableTest;
	}
	
	@Override
	public AvailableGuestTest findCurrentActiveGuestTechTest() {
		Query query = em
				.createQuery("from AvailableGuestTest as at where at.active=?");
		query.setParameter(1, "YES");
		AvailableGuestTest  availableGuestTest = (AvailableGuestTest) query.getSingleResult();
		return availableGuestTest;
	}

}
