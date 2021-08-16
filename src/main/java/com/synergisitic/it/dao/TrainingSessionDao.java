package com.synergisitic.it.dao;

import java.util.List;

import com.techquiz.trainer.dao.entity.TrainerSessionEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

/**
 * 
 * @author nagendra
 * @since 06-04-2018
 *
 */
public interface TrainingSessionDao {

	public List<TrainingSessionsDetailEntity> findTrainingSessionDetailByUserid(String userid, String techId);
	public List<TrainingSessionsDetailEntity> findTrainingSessionsDetailByDate(String dot);
	public String addTrainerSession(TrainerSessionEntity entity);
	public String deleteTrainerSession(TrainerSessionEntity entity);
	public List<TrainerSessionEntity> findAllTrainerSchedule();
	public List<TrainerSessionEntity> findAllTrainerScheduleByBatch(String batch);

}
