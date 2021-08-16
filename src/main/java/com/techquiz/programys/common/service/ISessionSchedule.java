package com.techquiz.programys.common.service;

import java.util.List;

import com.techquiz.programys.common.controller.model.ErrorLogForm;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

public interface ISessionSchedule {

	public List<TrainingSessionsDetailVO> findActiveSessionSchedule();

	public void logAppErrorDb(ErrorLogForm form);

}
