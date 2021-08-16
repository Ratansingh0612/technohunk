package com.techquiz.trainer.service;

import java.util.List;
import java.util.Map;

import com.techquiz.trainer.web.controller.vo.CourseContentsDetailVO;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;


/**
 * 
 * @author Astha
 *
 */
public interface IManagerAssesmentService {
	
	
	public Map<String,String> findAllTrainer();
	public List<TrainingSessionsDetailVO> findTrainerSessionDetailByTid(String trainerId,String startDate,String endDate);
	public Map<String,List<TrainingSessionsDetailVO>> findAllTrainerSessionDetail(String startDate, String endDate);
	public List<TrainingSessionsDetailVO> findTrainerTotalSessionDuration( );
	public Map<String, List<CourseContentsDetailVO>> findAllCourseContentsTopics(String course);
}
