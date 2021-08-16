package com.techquiz.programys.common.dao;

import java.util.List;

import com.techquiz.trainer.dao.entity.ErrorLogEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;

public interface ISessionScheduleDao {

	public List<TrainingSessionsDetailEntity> findActiveSessionSchedule();

	public void logAppErrorDb(ErrorLogEntity entity);

}
