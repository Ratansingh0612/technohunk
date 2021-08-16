package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.ConsultantDao;
import com.synergisitic.it.model.FeedbackInputData;
import com.synergisitic.it.model.PendingTopicFeedbackEntity;
import com.synergisitic.it.service.ConsultantService;
import com.synergisitic.it.web.form.PendingTopicFeedbackForm;
import com.techquiz.trainer.dao.IConsultantAssesmentDao;
import com.techquiz.trainer.dao.entity.ConsultantsEntity;
import com.techquiz.trainer.web.controller.vo.ConsultantsVO;

/**
 * 
 * @author Nagendra
 * @since 09-04-2018
 */
@Service("ConsultantServiceImpl")
public class ConsultantServiceImpl  implements ConsultantService{

	@Autowired
	@Qualifier("ConsultantDaoImpl")
	private ConsultantDao consultantDao;
	
	
	@Autowired
	@Qualifier("ConsultantAssesmentDao")
	private IConsultantAssesmentDao consultantAssesmentDao;
	
	@Override
	public String updateConsultantGroupByUserid(ConsultantsVO consultantsVO) {
		ConsultantsEntity consultantsEntity=new ConsultantsEntity();
		BeanUtils.copyProperties(consultantsVO, consultantsEntity);
		return consultantAssesmentDao.updateConsultantByUserid(consultantsEntity);
	}
	
	@Override
	public String resetConsultantPassword(String email,String newpassword){
		return consultantDao.resetConsultantPassword(email,newpassword);
	}	
	
	
	@Override
	public String addTopicFeedback(FeedbackInputData feedbackInputData) {
		return consultantDao.addTopicFeedback(feedbackInputData);
	}
	
	@Override
	public List<PendingTopicFeedbackForm> findPendingTopicFeedbacks(String consultantid){
		List<PendingTopicFeedbackEntity>  pendingTopicFeedbackEntityList=consultantDao.findPendingTopicFeedbacks(consultantid);
		List<PendingTopicFeedbackForm> feedbackForms=new ArrayList<PendingTopicFeedbackForm>();
		for(PendingTopicFeedbackEntity pendingTopicFeedbackEntity:pendingTopicFeedbackEntityList){
			PendingTopicFeedbackForm feedbackForm=new PendingTopicFeedbackForm();
			BeanUtils.copyProperties(pendingTopicFeedbackEntity, feedbackForm);
			feedbackForm.setSid(pendingTopicFeedbackEntity.getTrainingSession().getSid());
			feedbackForms.add(feedbackForm);
		}
		return feedbackForms;
	}

}
