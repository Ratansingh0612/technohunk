package com.techquiz.trainer.dao;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.synergisitic.it.model.TechnologyEntity;
import com.synergisitic.it.model.User;
import com.techquiz.trainer.dao.entity.CourseContentsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

public interface IManagerAssesmentDao {

	public List<User> findAllTrainer();
	public List<TrainingSessionsDetailEntity> findTrainerSessionDetailByTid(String trainerId,Timestamp startDate,Timestamp endDate);
	public String findUserNameByLoginId(String id);
	public Map<String,List<TrainingSessionsDetailEntity>> findAllTrainerSessionDetail(Timestamp startDate,
			Timestamp endDate);
	public List<TrainingSessionsDetailEntity> findTrainerTotalSessionDuration();
	public List<CourseContentsEntity> findAllTechnologyFromCourseContent(String course);
	public List<CourseContentsEntity> findAllCourseContentesTopics(String tName);
	public TechnologyEntity findLogoByTechName(String tName);
}
