package com.techquiz.trainer.service;

import java.util.List;
import java.util.Map;

import com.synergisitic.it.model.User;
import com.synergisitic.it.web.form.AssignedTestUserForm;
import com.synergisitic.it.web.form.UserForm;
import com.techquiz.trainer.web.controller.vo.ConsultantAssignmentVO;
import com.techquiz.trainer.web.controller.vo.ConsultantQuestionAnswerVO;
import com.techquiz.trainer.web.controller.vo.ConsultantScreeningInterviewVO;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;
import com.techquiz.trainer.web.controller.vo.ScreeningInterviewRatingStatusVO;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

/**
 * 
 * @author Astha
 *
 */
public interface IConsultantAssignmentService {
	public List<String> findActiveBatches();
	public List<ConsultantsVO> findConsultantsByBatch(String batchName);
	public List<ConsultantsVO> findAllConsultants();
	public byte[] findPhotoByUserId(String userid);
	public ConsultantsVO findConsultantByUserid(String userid);
	public String persistConsultantScreeningInterview(
			ConsultantQuestionAnswerVO consultantQuestionAnswerVO);
	public int findTotalQuestionsByConsultantId(String consultantId);
	public String submitConsultantScreeningInterview(
			ConsultantQuestionAnswerVO consultantQuestionAnswerVO);
	
	public List<String> findAllStream();
	public void registerConsultant(ConsultantsVO consultantsVO);
	public List<ConsultantScreeningInterviewVO> findScreeningInterviewsByConsultantUserid(String userid);
	public List<ScreeningInterviewRatingStatusVO> findScreeningInterviewStatusDetail(String consultantId,
			String interviewId);
	public int findTotalQuestionsFromHistoryByConsultantId(String consultantId,String interviewId);
	
	public List<TrainingSessionsDetailVO> findConsultantTechnologyStatusBy(String consultantId);
	public String saveTrainingSessionDetail(
			TrainingSessionsDetailVO trainingSessionsDetailVO);
	public List<UserForm> findConsultantByBatch(String batchName);
	
	public List<AssignedTestUserForm> findConsultantByTrainerIdTestName(String tid,String testName);
	
	public Map<Integer,String> findAllLanguages();
	
	public List<String> findAvailableCourses() ;
	Map<String, String> fetchAllTopics();
//	public List<CourseContentsDetailVO> findAllCoverdTopics(String topicid, String courseId);
	public Map<String, String> findActiveBatchesAsMap();
	public String saveTrainingSessionSchedule(
			TrainingSessionsDetailVO trainingSessionsDetailVO);
	public List<User> findAllTrainers();
	public List<TrainingSessionsDetailVO> findAllSessionsSchedule();
	public String addAssignmentToConsultant(ConsultantAssignmentVO assignmentVO);
}
