package com.techquiz.trainer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.techquiz.trainer.dao.InterviewQuestionsDao;
import com.techquiz.trainer.dao.entity.InterviewQuestionsAnswerEntity;
import com.techquiz.trainer.service.InterviewQuestionsService;
import com.techquiz.trainer.web.controller.vo.InterviewQuestionsAnswerVO;

@Service("InterviewQuestionsServiceImpl")
@Scope("singleton")
public class InterviewQuestionsServiceImpl implements InterviewQuestionsService {
	
	@Autowired
	@Qualifier("InterviewQuestionsDaoImpl")
	private InterviewQuestionsDao interviewQuestionsDao;
	
	@Override
	public List<InterviewQuestionsAnswerVO> findInterviewQuestionsByTechTopic(String techName,String topic,String complexity){
		List<InterviewQuestionsAnswerVO>  interviewQuestionsAnswerVOs=new ArrayList<InterviewQuestionsAnswerVO>();
		List<InterviewQuestionsAnswerEntity> interviewQuestionsAnswerEntityList=interviewQuestionsDao.findInterviewQuestionsByTechTopic(techName, topic,complexity);
		for(InterviewQuestionsAnswerEntity answerEntity:interviewQuestionsAnswerEntityList){
			InterviewQuestionsAnswerVO interviewQuestionsAnswerVO=new InterviewQuestionsAnswerVO();
			BeanUtils.copyProperties(answerEntity, interviewQuestionsAnswerVO);
			interviewQuestionsAnswerVOs.add(interviewQuestionsAnswerVO);
		}
		return interviewQuestionsAnswerVOs;
	}
	
	@Override
	public String addInterviewQuestionAnswer(InterviewQuestionsAnswerVO interviewQuestionsAnswerVO){
		InterviewQuestionsAnswerEntity interviewQuestionsAnswerEntity=new InterviewQuestionsAnswerEntity();
		BeanUtils.copyProperties(interviewQuestionsAnswerVO, interviewQuestionsAnswerEntity);
		String result=interviewQuestionsDao.addInterviewQuestionAnswer(interviewQuestionsAnswerEntity);
		return result;
	}

}
