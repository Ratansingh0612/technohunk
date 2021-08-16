package com.techquiz.programys.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.techquiz.programys.common.controller.model.ErrorLogForm;
import com.techquiz.programys.common.dao.ISessionScheduleDao;
import com.techquiz.programys.common.service.ISessionSchedule;
import com.techquiz.trainer.dao.entity.ErrorLogEntity;
import com.techquiz.trainer.dao.entity.TrainingSessionsDetailEntity;
import com.techquiz.trainer.web.controller.vo.TrainingSessionsDetailVO;

	@Service("SessionSchedule")
	@Scope("singleton")
	public class SessionSchedule  implements ISessionSchedule{
		
		@Autowired
		@Qualifier("SessionScheduleDao")
		private ISessionScheduleDao sessionScheduleDao;

		@Override
		public List<TrainingSessionsDetailVO> findActiveSessionSchedule() {
			List<TrainingSessionsDetailEntity> trainingSessionsDetailEntityList=sessionScheduleDao.findActiveSessionSchedule();
			List<TrainingSessionsDetailVO> trainingSessionsDetailVOList=new ArrayList<TrainingSessionsDetailVO>();
			for(TrainingSessionsDetailEntity tsde:trainingSessionsDetailEntityList)
			{
				TrainingSessionsDetailVO trainingSessionsDetailVO=new TrainingSessionsDetailVO();
				BeanUtils.copyProperties(tsde, trainingSessionsDetailVO);
				trainingSessionsDetailVOList.add(trainingSessionsDetailVO);
			
			}
			return trainingSessionsDetailVOList;
		}
		
	
		@Override
		public void logAppErrorDb(ErrorLogForm form){
			ErrorLogEntity errorLogEntity=new ErrorLogEntity();
			BeanUtils.copyProperties(form, errorLogEntity);
			sessionScheduleDao.logAppErrorDb(errorLogEntity);
		}
		

}
