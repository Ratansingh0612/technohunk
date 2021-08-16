package com.synergisitic.it.dao;

import java.util.List;

import com.techquiz.programys.common.dao.entity.TopicEntity;

public interface TopicsDao {

	public String addTopic(TopicEntity topicEntity);
	public List<TopicEntity> findTopics();
	public List<TopicEntity> deleteTopics(String[] dcbox);
	public TopicEntity findTopicByTid(String tid);
	public int findTotalTopicsByTId(String tid);
	public List<TopicEntity> findTopicsByLanguageId(String languageId);
	public String deleteTopicById(String tid);
	
}
