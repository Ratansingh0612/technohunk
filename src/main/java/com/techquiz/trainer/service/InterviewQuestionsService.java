package com.techquiz.trainer.service;

import java.util.List;

import com.techquiz.trainer.web.controller.vo.InterviewQuestionsAnswerVO;

public interface InterviewQuestionsService {

	public String addInterviewQuestionAnswer(InterviewQuestionsAnswerVO interviewQuestionsAnswerVO);

	public List<InterviewQuestionsAnswerVO> findInterviewQuestionsByTechTopic(String techName, String topic,String complexity);

}
