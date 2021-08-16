package com.techquiz.trainer.web.controller.vo;

import java.util.List;

/**
 * 
 * @author nagendra
 * @since 06-04-2018
 */
public class TrainerDailySessionReportList {
	
	private List<TrainerDailySessionReport> dailySessionReports;

	public List<TrainerDailySessionReport> getDailySessionReports() {
		return dailySessionReports;
	}

	public void setDailySessionReports(List<TrainerDailySessionReport> dailySessionReports) {
		this.dailySessionReports = dailySessionReports;
	}

	@Override
	public String toString() {
		return "TrainerDailySessionReportList [dailySessionReports=" + dailySessionReports + "]";
	}

}
