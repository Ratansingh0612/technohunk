package com;

import org.springframework.scheduling.annotation.Scheduled;

public class SpringSchedulerConfig {

	/**
	  * @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}") 
	 */
	@Scheduled(cron = "0 15 10 15 * ?")
	public void scheduleTaskUsingCronExpression() {
		long now = System.currentTimeMillis() / 1000;
		System.out.println("schedule tasks using cron jobs - " + now);
	}
}