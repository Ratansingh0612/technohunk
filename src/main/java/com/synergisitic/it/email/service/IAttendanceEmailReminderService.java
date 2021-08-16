package com.synergisitic.it.email.service;

import java.util.List;

import com.synergisitic.it.email.service.vo.EmailMessageVO;
import com.synergisitic.it.model.UserOnlineExamStatus;
import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;
import com.techquiz.codings.web.controller.vo.ConsultantsSubmittedCodeVO;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

/**
 * 
 * @author Nagendra
 *
 */
public interface IAttendanceEmailReminderService {

	public String sendWelcomeEmailToConsultant(ConsultantsVO consultantsVO, String imageContextPath);

	public String sendConfirmationEmail(String message, String name, String toEmail, String imageContextPath);

	public String sendCompletedTestEmail(UserOnlineExamStatus userOnlineExamStatus, EmailMessageVO emailMessageVO);

	public String sendCompletedTestSummaryWithQuizAnsEmail(List<QuestionAndAnsTestDataVO> questionList,UserOnlineExamStatus userOnlineExamStatus,
			EmailMessageVO emailMessageVO);

	public String sendCodingProblemSummaryEmail(ConsultantsSubmittedCodeVO consultantsSubmittedCodeVO,
			EmailMessageVO emailMessageVO);
}
