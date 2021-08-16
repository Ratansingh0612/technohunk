package com.synergisitic.it.service;

import java.util.List;

import com.synergisitic.it.model.FeedbackInputData;
import com.synergisitic.it.web.form.PendingTopicFeedbackForm;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

/**
 * 
 * @author Nagendra
 * @since 09-04-2018
 */
public interface ConsultantService {
	public String addTopicFeedback(FeedbackInputData feedbackInputData) ;
	public List<PendingTopicFeedbackForm> findPendingTopicFeedbacks(String consultantid);
	String updateConsultantGroupByUserid(ConsultantsVO consultantsVO);
	String resetConsultantPassword(String email, String newpassword);
}
