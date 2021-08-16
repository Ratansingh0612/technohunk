package com.techquiz.trainer.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.GuestUserEntity;
import com.synergisitic.it.model.PendingTopicFeedbackEntity;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.DateUtils;
import com.techquiz.programys.common.dao.entity.BatchEntity;
import com.techquiz.programys.common.dao.entity.CourseEntity;
import com.techquiz.programys.common.vo.TopicVO;
import com.techquiz.trainer.dao.IConsultantAssesmentDao;
import com.techquiz.trainer.dao.entity.ConsultantScreeningInterviewEntity;
import com.techquiz.trainer.dao.entity.ConsultantScreeningInterviewHistoryEntity;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsScheduleEntity;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

@Repository("ConsultantAssesmentDao")
@Scope("singleton")
@Transactional
public class ConsultantAssesmentDao implements IConsultantAssesmentDao {
	
	/**
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(ConsultantAssesmentDao.class);

	@PersistenceContext
	private EntityManager em;
	
	@Override
    public String deleteConsultantByEmailId(String userid) {
       Query tquery=em.createQuery("delete from ConsultantsEntity as ce where ce.userid=? or ce.email=?");
       tquery.setParameter(1, userid);
       tquery.setParameter(2, userid);
       int status = tquery.executeUpdate();
       return status>0 ? "deleted":"notdeleted";
    }  
	
	@Override
	public List<String> findActiveBatches() {
		Query query=em.createQuery("from BatchEntity");
		List<BatchEntity> batchEntities=query.getResultList();
		List<String> batchList= new ArrayList<String>();
		for(BatchEntity batchEntity:batchEntities){
			if(!batchList.contains(batchEntity.getBatch()))
			batchList.add(batchEntity.getBatch());
		}
		return batchList;
	}
	
	
	
	@Override
	public Map<String,String> findActiveBatchesAsMap() {
		Query query=em.createQuery("from BatchEntity");
		List<BatchEntity> batchEntities=query.getResultList();
		Map<String,String> batchMap= new LinkedHashMap<String,String>();
		for(BatchEntity batchEntity:batchEntities){
			batchMap.put(batchEntity.getBid()+"",batchEntity.getBatch());
		}
		return batchMap;
	}
	
	@Override
	public List<String> findAvailableCourses() {
		Query query=em.createQuery("from CourseEntity");
		List<CourseEntity> courseEntitiesList=query.getResultList();
		List<String> coursesList= new ArrayList<String>();
		for(CourseEntity courseEntity:courseEntitiesList){
			if(!coursesList.contains(courseEntity.getName()))
				coursesList.add(courseEntity.getName());
		}
		return coursesList;
	}
	
	@Override
	public List<ConsultantScreeningInterviewHistoryEntity> findScreeningInterviewsByConsultantUserid(String userid) {
		Query query=em.createQuery("from ConsultantScreeningInterviewHistoryEntity as ce where ce.consultantId=?");
		query.setParameter(1, userid);
		List<ConsultantScreeningInterviewHistoryEntity> consultantScreeningInterviewHistoryList=query.getResultList();
		return consultantScreeningInterviewHistoryList;
	}

	@Override
	public ConsultantsEntity findConsultantByUserid(String userid) {
		Query query=em.createQuery("from ConsultantsEntity as ce where ce.userid=?");
		query.setParameter(1, userid);
		ConsultantsEntity consultantsEntity=(ConsultantsEntity)query.getSingleResult();
		return consultantsEntity;
	}
	
	@Override
	public String updateConsultantGroupByUserid(ConsultantsEntity consultantsEntity) {
		Query query=em.createQuery("from ConsultantsEntity as ce where ce.userid=?");
		query.setParameter(1, consultantsEntity.getUserid());
		ConsultantsEntity dconsultantsEntity=(ConsultantsEntity)query.getSingleResult();
		dconsultantsEntity.setName(consultantsEntity.getName());
		dconsultantsEntity.setGender(consultantsEntity.getGender());
		dconsultantsEntity.setBatch(consultantsEntity.getBatch());
		dconsultantsEntity.setDom(new Timestamp(new Date().getTime()));
		dconsultantsEntity.setRole(consultantsEntity.getRole());
		return "updated";
	}
	
	@Override
	public ConsultantsEntity findConsultantByEmail(String email) {
		Query query=em.createQuery("from ConsultantsEntity as ce where ce.email=?");
		query.setParameter(1, email);
		ConsultantsEntity consultantsEntity=(ConsultantsEntity)query.getSingleResult();
		return consultantsEntity;
	}
	
	/*
	/*This method fetches the tech Name of the respective consultants
	 *  (whichever techology tests assigned to him/her)
	 
	public TechnologyEntity findTechNameByLoginId(String loginId)
	{
		//fetching consultant specific techIds
		Query query=em.createQuery("from TrainingSessionsDetailEntity where userid=?");
		query.setParameter(1, loginId);
		TrainingSessionsDetailEntity trainingSessionsDetailEntity=(TrainingSessionsDetailEntity)query.getSingleResult();
		String techId = trainingSessionsDetailEntity.getTechnology();
		
		
		Query query1=em.createQuery("from TechnologyEntity where id=?");
		query1.setParameter(1, techId);
		TechnologyEntity technologyEntity=(TechnologyEntity)query1.getSingleResult();
		return technologyEntity;
	}
	*/
	
	
	@Override
	public String updateConsultantPasswordByUserid(String userid,String npassword) {
		Query query=em.createQuery("from ConsultantsEntity as ce where ce.userid=?");
		query.setParameter(1, userid);
		ConsultantsEntity consultantsEntity=(ConsultantsEntity)query.getSingleResult();
		consultantsEntity.setPassword(npassword);
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	public String updateConsultantByUserid(ConsultantsEntity consultantsEntity) {
		Query query=em.createQuery("from ConsultantsEntity as ce where ce.userid=?");
		query.setParameter(1, consultantsEntity.getUserid());
		ConsultantsEntity dconsultantsEntity=(ConsultantsEntity)query.getSingleResult();
		dconsultantsEntity.setName(consultantsEntity.getName());
		dconsultantsEntity.setEmail(consultantsEntity.getEmail());
		dconsultantsEntity.setGender(consultantsEntity.getGender());
		dconsultantsEntity.setStream(consultantsEntity.getStream());
		if(consultantsEntity.getImage()!=null && consultantsEntity.getImage().length>0)
		dconsultantsEntity.setImage(consultantsEntity.getImage());
		return ApplicationContant.SUCCESS;
	}

	@Override
	public List<ConsultantsEntity> findConsultantsByBatch(String batchName) {
		Query query=em.createQuery("from ConsultantsEntity as ce where ce.batch=?");
		query.setParameter(1, batchName);
		List<ConsultantsEntity> consultantsList=query.getResultList();
		return consultantsList;
	}
	
	
	@Override
	public List<ConsultantsEntity> findAllConsultants() {
		Query query=em.createQuery("from ConsultantsEntity");
		List<ConsultantsEntity> consultantsList=query.getResultList();
		return consultantsList;
	}
	
	@Override
	public List<User> findAllTrainers() {
		Query query=em.createQuery("from User as u where u.role='"+ApplicationContant.TRAINER_ROLE+"'");
		List<User> trainerList=query.getResultList();
		return trainerList;
	}
	
	@Override
	public byte[] findPhotoByUserId(String userid) {
		System.out.println(userid+"= =========================");
		Query query = em.createQuery("from ConsultantsEntity as u where u.userid=? or u.empid=?");
		query.setParameter(1, userid);
		query.setParameter(2, userid);
		ConsultantsEntity consultantsEntity=new ConsultantsEntity();
		try {
		 consultantsEntity = (ConsultantsEntity) query.getSingleResult();
		}catch(Exception ex){
			System.out.println("findPhotoByUserId image does not exist!");
		}
		return consultantsEntity.getImage();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String persistConsultantScreeningInterview(
			ConsultantScreeningInterviewEntity consultantScreeningInterviewEntity) {
		em.persist(consultantScreeningInterviewEntity);
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String submitConsultantScreeningInterview(ConsultantScreeningInterviewEntity consultantScreeningInterviewEntity) {
		em.persist(consultantScreeningInterviewEntity);
		Query query=em.createQuery("from ConsultantScreeningInterviewEntity where consultantId=?");
		query.setParameter(1,consultantScreeningInterviewEntity.getConsultantId());
		List<ConsultantScreeningInterviewEntity> consultantScreeningInterviewEntityList=query.getResultList();
		String screeningInterviewId="csi"+System.currentTimeMillis();
		for(ConsultantScreeningInterviewEntity consultantScreening : consultantScreeningInterviewEntityList){
			ConsultantScreeningInterviewHistoryEntity consultantScreeningInterviewHistoryEntity=new ConsultantScreeningInterviewHistoryEntity();
			BeanUtils.copyProperties(consultantScreening, consultantScreeningInterviewHistoryEntity,new String[]{"csie"});
			consultantScreeningInterviewHistoryEntity.setInterviewId(screeningInterviewId);
			em.persist(consultantScreeningInterviewHistoryEntity);
			em.remove(consultantScreening);
		}
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	public int findTotalQuestionsByConsultantId(String consultantId) {
		String hql = "select count(consultantId) from ConsultantScreeningInterviewEntity where consultantId=?";
		Query query = em.createQuery(hql);
		query.setParameter(1, consultantId);
		List listResult = query.getResultList();
		int count=0;
		if(listResult!=null && listResult.size()>0){
			Number number = (Number) listResult.get(0);
			count=number.intValue();
		}
		return count; 
	}

	@Override
	public List<String> findAllStream() {
		Query query=em.createQuery("from ConsultantsEntity as ce where ce.active=?");
		query.setParameter(1, "yes");
		List<ConsultantsEntity> consultantsList=query.getResultList();
		List<String> streamList= new ArrayList<String>();
		for(ConsultantsEntity consultantsEntity:consultantsList){
			if(!streamList.contains(consultantsEntity.getStream()))
				streamList.add(consultantsEntity.getStream());
		}
		return streamList;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String registerConsultant(ConsultantsEntity consultantsEntity) {
		if(consultantsEntity.getEmpid()==null){
			Query query=em.createQuery("from ConsultantsEntity order by doe desc");
			List<ConsultantsEntity> consultantsList=query.getResultList();
			String empid;
			if(consultantsList!=null && consultantsList.size()!=0){
				ConsultantsEntity consultant=(ConsultantsEntity)consultantsList.get(0);
				empid=consultant.getEmpid();
				int id=Integer.parseInt(empid.substring(2,empid.length()));
				id++;
				empid="E"+id;
			}
			else{
				empid="E100";
			}
			consultantsEntity.setEmpid(empid);
		}
		Query tquery = em.createQuery("delete from User u where u.id=?");
		tquery.setParameter(1, Integer.parseInt(consultantsEntity.getTuserid()));
		int status = tquery.executeUpdate();
		em.persist(consultantsEntity);
		return ApplicationContant.SUCCESS;
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String addUserByAdmin(ConsultantsEntity consultantsEntity) {
		em.persist(consultantsEntity);
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String saveTrainingSessionDetail(TrainingSessionsDetailEntity trainingSessionsDetailEntity) {
		String pempids=trainingSessionsDetailEntity.getPempids();
		String tokens[]=pempids.split(",");
		List<PendingTopicFeedbackEntity> pendingTopicFeedbackList=new ArrayList<PendingTopicFeedbackEntity>();
		for(String empid:tokens) {
				PendingTopicFeedbackEntity pendingTopicFeedbackEntity=new PendingTopicFeedbackEntity();
				pendingTopicFeedbackEntity.setConsultantid(empid);
				pendingTopicFeedbackEntity.setComment(trainingSessionsDetailEntity.getComments());
				pendingTopicFeedbackEntity.setDoe(DateUtils.getCurrentTimeIntoTimestamp());
				pendingTopicFeedbackEntity.setDos(DateUtils.getCurrentTimeIntoTimestamp());
				pendingTopicFeedbackEntity.setTechnology(trainingSessionsDetailEntity.getTechnology());
				pendingTopicFeedbackEntity.setTopics(trainingSessionsDetailEntity.getTopics());
				//pendingTopicFeedbackList.add(pendingTopicFeedbackEntity);
				pendingTopicFeedbackEntity.setTrainingSession(trainingSessionsDetailEntity);
				em.persist(pendingTopicFeedbackEntity);
		}
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public String saveTrainingSessionSchedule(TrainingSessionsScheduleEntity trainingSessionsScheduleEntity) {
		em.persist(trainingSessionsScheduleEntity);
		return ApplicationContant.SUCCESS;
	}
	
	@Override
	public List<TrainingSessionsScheduleEntity> findAllSessionsSchedule() {
		 String hql="from TrainingSessionsScheduleEntity";
		 Query query=em.createQuery(hql);
		 List<TrainingSessionsScheduleEntity> trainingSessionsScheduleEntityList=query.getResultList();
		 return trainingSessionsScheduleEntityList;
	}
	
	
	@Override
	public  List<ConsultantScreeningInterviewHistoryEntity>  findScreeningInterviewStatusDetail(String consultantId,String interviewId) {
		 String hql="from ConsultantScreeningInterviewHistoryEntity as csih where csih.consultantId=? and csih.interviewId=?  order by csih.technology";
		 Query query=em.createQuery(hql);
		 query.setParameter(1,consultantId);
		 query.setParameter(2,interviewId);
		 List<ConsultantScreeningInterviewHistoryEntity> consultantScreeningInterviewHistoryList=query.getResultList();
		 return consultantScreeningInterviewHistoryList;
	}
	
	

	@Override
	public List<TrainingSessionsDetailEntity> findConsultantTechnologyStatusBy(String consultantId) {
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<TrainingSessionsDetailEntity> cq=cb.createQuery(TrainingSessionsDetailEntity.class);
		 Root<TrainingSessionsDetailEntity> root=cq.from(TrainingSessionsDetailEntity.class);
		 CriteriaQuery<TrainingSessionsDetailEntity> select=cq.select(root);
		 //elect.where(cb.like(from.get("QWE"),"DDD");
		 select.where(cb.like(root.<String>get("pempids"),"%"+consultantId+"%"));
		 TypedQuery<TrainingSessionsDetailEntity> tq=em.createQuery(cq);
		 List<TrainingSessionsDetailEntity> trainingSessionsDetailEntityList=tq.getResultList();
		 if(trainingSessionsDetailEntityList!=null) {
			   for(TrainingSessionsDetailEntity entity:trainingSessionsDetailEntityList) {
				    Query query=em.createQuery("from TechnologyEntity tech where tech.id="+entity.getTechnology());
				    TechnologyEntity technologyEntity=(TechnologyEntity)query.getSingleResult();
				    entity.setTechName(technologyEntity.getTname());
			   }
		 }
		 System.out.println("Daooooo Layer : "+trainingSessionsDetailEntityList);
		 return trainingSessionsDetailEntityList;
	}
	
	
	@Override
	public List<AssignedTestUser> findConsultantTestInfoByUserId(String userId) {
		Query query = em
				.createQuery("from AssignedTestUser atu where atu.assignedTestCompositeKey.userId=?");
		query.setParameter(1, userId);
		List<AssignedTestUser> assignedTestList = query.getResultList();
		return assignedTestList;
	}

	@Override
	public List<AssignedTestUser> findConsultantByTrainerIdTestName(String tid,String testName) {

		Query query=em.createQuery("from AssignedTestUser where modifyBy=? and techName=?");
		query.setParameter(1, tid);
		query.setParameter(2, testName);
		List<AssignedTestUser> consultantList=query.getResultList();
		return consultantList;
	}
	
	@Override
	public UserOnlineExamStatus findConsultantTestTechtStatus(String userid,String testName,String techName,String groupName) {
		String testStatus="Not Assigned";
		UserOnlineExamStatus userOnlineExamStatus=new UserOnlineExamStatus();
		userOnlineExamStatus.setExamStatus(testStatus);
		Query query=em.createQuery("from AssignedTestUser as atu where atu.assignedTestCompositeKey.userId=? and atu.assignedTestCompositeKey.techName=? and atu.assignedTestCompositeKey.testName=?");
		query.setParameter(1, userid);
		query.setParameter(2, techName);
		query.setParameter(3, testName);
		try {
			AssignedTestUser assignedTestUser=(AssignedTestUser)query.getSingleResult();
			testStatus=assignedTestUser.getTestStatus();
			userOnlineExamStatus.setExamStatus(testStatus);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		if("complete".equalsIgnoreCase(testStatus)){
			Query scorequery=em.createQuery("from UserOnlineExamStatus as uoes where uoes.techName=? and uoes.testName=? and uoes.userId=?");
			scorequery.setParameter(1, techName);
			scorequery.setParameter(2, testName);
			scorequery.setParameter(3, userid);
			List<UserOnlineExamStatus>  userOnlineExamStatusList=(List<UserOnlineExamStatus>)scorequery.getResultList();
			if(userOnlineExamStatusList!=null && userOnlineExamStatusList.size()>0){
			userOnlineExamStatus=userOnlineExamStatusList.get(0);
			int max=userOnlineExamStatus.getSecureMarks();
			for(UserOnlineExamStatus uoes:userOnlineExamStatusList){
				 if(max<uoes.getSecureMarks()){
					 max=uoes.getSecureMarks();
					 userOnlineExamStatus=uoes;
				 }
			}
			}else{
				userOnlineExamStatus.setExamStatus("Not Known");
			}
		}
		return userOnlineExamStatus;
	}

	@Override
	public List<TechnologyEntity> findAllLanguages() {
		Query query=em.createQuery("from TechnologyEntity");
		List<TechnologyEntity> languageList=query.getResultList();
		return languageList;
	}

	@Override
	public List<TrainingSessionsDetailVO> findAllTopics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TopicVO> fetchAllTopics() {
		Query query=em.createQuery("from topics");
		List<TopicVO> topicList=query.getResultList();
		return topicList;
	}


//	@Override
//	public List<CourseContentsEntity> findAllCoverdTopics(String topicid, String courseId) {
//		List<TopicVO> findAllCoverdTopic(String tid);
//		Query query=em.createQuery("from CourseContentsEntity where modifyBy=? and course=?");
//		query.setParameter(1, topicid);
//		query.setParameter(2, courseId);
//		List<CourseContentsEntity> courseContentsDetailVO=query.getResultList();
//		
//		return courseContentsDetailVO;
//	}

	@Override
	public List<ConsultantsEntity> findAllConsultantsWithSearchString(String key) {
		System.out.println("I am in the dao layer....");
		Query query=em.createQuery("from ConsultantsEntity where name LIKE :pname OR email LIKE :pemail");
		query.setParameter("pname", "%" + key + "%");
		query.setParameter("pemail", "%" + key + "%");
		System.out.println("Dao layer query list: "+query);
		List<ConsultantsEntity> consultantsList=query.getResultList();
		System.out.println("Dao layer Output: "+consultantsList);
		return consultantsList;
	}
	
	

}
