package com.synergisitic.it.email.service;

import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

public class ProfileCreationEmailSenderThread extends Thread {

	private IAttendanceEmailReminderService attendanceEmailReminderService;
	private ConsultantsVO consultantsVO;
	private String imageContextPath;
	
	public ProfileCreationEmailSenderThread(IAttendanceEmailReminderService attendanceEmailReminderService,
			ConsultantsVO consultantsVO, String imageContextPath) {
		this.attendanceEmailReminderService = attendanceEmailReminderService;
		this.consultantsVO = consultantsVO;
		this.imageContextPath = imageContextPath;
	}

	public void run() {
		try {
			System.out.println("---sending email....  "+consultantsVO);
			attendanceEmailReminderService.sendWelcomeEmailToConsultant(consultantsVO, imageContextPath);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
