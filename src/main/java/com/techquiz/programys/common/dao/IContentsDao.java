package com.techquiz.programys.common.dao;

import java.util.List;

import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.dao.entity.CourseContentsEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

public interface IContentsDao {

	public String addTopicsCourse(List<CourseContentsEntity> contentsEntityList);
	public List<TrainingSessionsDetailEntity> findCourseCoveredStatusForBatch(String batchName);
	public List<ConsultantsEntity> findConsultantDetailsByBatch(String batchName);
	public List<String> findTotalTopicsByTechName(String techName);

}
