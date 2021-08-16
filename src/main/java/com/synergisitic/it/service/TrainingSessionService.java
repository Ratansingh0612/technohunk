package com.synergisitic.it.service;

import java.util.List;
import java.util.Map;

import com.techquiz.trainer.web.controller.vo.TrainerDailySessionReport;
import com.techquiz.trainer.web.controller.vo.TrainerSessionVO;

/**
 * 
 * @author nagendra
 * @since 06-04-2018
 *
 */
public interface TrainingSessionService {

	public List<TrainerDailySessionReport> findTrainingSessionsDetailByDate(String dot);
	public Map<String, List<TrainerSessionVO>> findAllTrainerSchedule();
	public Map<String, List<TrainerSessionVO>> findAllTrainerScheduleByBatch(String batch);
	public String deleteTrainerSession(TrainerSessionVO session);
	public String addTrainerSession(TrainerSessionVO trainerSessionVO);

}
