package com.synergisitic.it.dao;

import java.util.List;

import com.synergisitic.it.model.FeedbackInputData;
import com.synergisitic.it.model.PendingTopicFeedbackEntity;

/**
 * 
 * @author Nagendra
 * @since 09-04-2018
 */
public interface ConsultantDao {

	public String addTopicFeedback(FeedbackInputData feedbackInputData);
	public List<PendingTopicFeedbackEntity> findPendingTopicFeedbacks(String consultantid);
	public String resetConsultantPassword(String email, String newpassword);
}
