package com.techquiz.trainer.web.controller.vo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ConsultantSessionDetailWrapperVO {

	private Map<String, List<TrainingSessionsDetailVO>> trainerSessionDetailMap;
	private Collection<TrainerLoadVO> trainerLoadVOsList;

	public Map<String, List<TrainingSessionsDetailVO>> getTrainerSessionDetailMap() {
		return trainerSessionDetailMap;
	}

	public void setTrainerSessionDetailMap(Map<String, List<TrainingSessionsDetailVO>> trainerSessionDetailMap) {
		this.trainerSessionDetailMap = trainerSessionDetailMap;
	}

	public Collection<TrainerLoadVO> getTrainerLoadVOsList() {
		return trainerLoadVOsList;
	}

	public void setTrainerLoadVOsList(Collection<TrainerLoadVO> trainerLoadVOsList) {
		this.trainerLoadVOsList = trainerLoadVOsList;
	}

	@Override
	public String toString() {
		return "ConsultantSessionDetailWrapperVO [trainerSessionDetailMap=" + trainerSessionDetailMap
				+ ", trainerLoadVOsList=" + trainerLoadVOsList + "]";
	}

}
