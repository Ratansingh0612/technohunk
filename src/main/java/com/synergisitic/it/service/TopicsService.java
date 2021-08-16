package com.synergisitic.it.service;

import java.util.List;

import com.techquiz.programys.common.vo.TopicVO;

public interface TopicsService {
	public String addTopic(TopicVO topicVO);
	public List<TopicVO> findTopics();
	public List<TopicVO> deleteTopics(String[] dcbox);
	public TopicVO findTopicByTid(String tid);
	public int findTotalTopicsByTId(String tid);
	public List<TopicVO> findTopicsByLanguageId(String languageId);
	public String deleteTopicById(String tid);
}
