package com.techquiz.trainer.dao;

import java.util.List;
import java.util.Map;

import com.synergisitic.it.model.AssignedTestUser;
import com.synergisitic.it.model.GuestUserEntity;
import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.techquiz.programys.common.vo.TopicVO;
import com.techquiz.trainer.dao.entity.ConsultantScreeningInterviewEntity;
import com.techquiz.trainer.dao.entity.ConsultantScreeningInterviewHistoryEntity;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsScheduleEntity;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

public interface IConsultantAssesmentDao {
	
	public List<String> findActiveBatches();
	public List<ConsultantsEntity> findConsultantsByBatch(String batchName) ;
	public byte[] findPhotoByUserId(String userid);
	public ConsultantsEntity findConsultantByUserid(String userid);
	public String persistConsultantScreeningInterview(ConsultantScreeningInterviewEntity consultantScreeningInterviewEntity);
	public int findTotalQuestionsByConsultantId(String consultantId);
	public String submitConsultantScreeningInterview(
			ConsultantScreeningInterviewEntity consultantScreeningInterviewEntity);
	
	public List<String> findAllStream();
	public String registerConsultant(ConsultantsEntity consultantsEntity);
	public List<ConsultantScreeningInterviewHistoryEntity>  findScreeningInterviewsByConsultantUserid(String userid);
	public List<ConsultantScreeningInterviewHistoryEntity> findScreeningInterviewStatusDetail(
			String consultantId, String interviewId);
	public List<TrainingSessionsDetailEntity> findConsultantTechnologyStatusBy(String consultantId);
	public String saveTrainingSessionDetail(
			TrainingSessionsDetailEntity trainingSessionsDetailEntity);
	
	public List<AssignedTestUser> findConsultantByTrainerIdTestName(String tid,String testName);
	public List<ConsultantsEntity> findAllConsultants();
	public List<TechnologyEntity> findAllLanguages();
	public List<TrainingSessionsDetailVO> findAllTopics();
	public List<String> findAvailableCourses();
	public List<TopicVO> fetchAllTopics();
//	public List<CourseContentsEntity> findAllCoverdTopics(String topicid, String courseId);
	public Map<String,String> findActiveBatchesAsMap();
	public String saveTrainingSessionSchedule(
			TrainingSessionsScheduleEntity trainingSessionsScheduleEntity);
	public List<User> findAllTrainers();
	public List<TrainingSessionsScheduleEntity> findAllSessionsSchedule();
	public UserOnlineExamStatus findConsultantTestTechtStatus(String userid, String testName, String techName, String groupName);
	public String updateConsultantByUserid(ConsultantsEntity consultantsEntity);
	public String updateConsultantPasswordByUserid(String userid, String npassword);
	public List<ConsultantsEntity> findAllConsultantsWithSearchString(String key);
	public List<AssignedTestUser> findConsultantTestInfoByUserId(String userId);
	//public TechnologyEntity findTechNameByLoginId(String loginId);
	public ConsultantsEntity findConsultantByEmail(String email);
	public String updateConsultantGroupByUserid(ConsultantsEntity consultantsEntity);
	public String deleteConsultantByEmailId(String userid);
	String addUserByAdmin(ConsultantsEntity consultantsEntity);

}
