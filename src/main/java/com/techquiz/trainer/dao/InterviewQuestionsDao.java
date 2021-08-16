package com.techquiz.trainer.dao;

import java.util.List;

import com.techquiz.trainer.dao.entity.InterviewQuestionsAnswerEntity;

public interface InterviewQuestionsDao {
	public String addInterviewQuestionAnswer(InterviewQuestionsAnswerEntity interviewQuestionsAnswerEntity);
	public List<InterviewQuestionsAnswerEntity> findInterviewQuestionsByTechTopic(String techName, String topic,String complexity);
}
