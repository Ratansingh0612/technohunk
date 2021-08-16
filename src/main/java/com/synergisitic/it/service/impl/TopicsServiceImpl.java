package com.synergisitic.it.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergisitic.it.dao.TopicsDao;
import com.synergisitic.it.service.TopicsService;
import com.techquiz.programys.common.dao.entity.TopicEntity;
import com.techquiz.programys.common.vo.TopicVO;

@Service("TopicsServiceImpl")
@Scope("singleton")
public class TopicsServiceImpl  implements TopicsService{
	
	@Autowired
	@Qualifier("TopicsDaoImpl")
	private TopicsDao topicsDao;

	@Override
	public String addTopic(TopicVO topicVO) {
		TopicEntity topicEntity=new TopicEntity();
		BeanUtils.copyProperties(topicVO, topicEntity);
		return topicsDao.addTopic(topicEntity);
	}

	@Override
	public List<TopicVO> findTopics() {
		 List<TopicEntity> topicEntityList=topicsDao.findTopics();
		 List<TopicVO> topicVOs=new ArrayList<TopicVO>();
		 for(TopicEntity topicEntity:topicEntityList){
			 TopicVO topicVO=new TopicVO();
			 BeanUtils.copyProperties(topicEntity, topicVO);
			 topicVOs.add(topicVO);
		 }
		 return topicVOs;
	}

	@Override
	public List<TopicVO> deleteTopics(String[] dcbox) {
		 List<TopicEntity> topicEntityList=topicsDao.deleteTopics(dcbox);
		 List<TopicVO> topicVOs=new ArrayList<TopicVO>();
		 for(TopicEntity topicEntity:topicEntityList){
			 TopicVO topicVO=new TopicVO();
			 BeanUtils.copyProperties(topicEntity, topicVO);
			 topicVOs.add(topicVO);
		 }
		 return topicVOs;
	}

	@Override
	public TopicVO findTopicByTid(String tid) {
		TopicEntity topicEntity=topicsDao.findTopicByTid(tid);
		TopicVO topicVO=new TopicVO();
		 BeanUtils.copyProperties(topicEntity, topicVO);
		return topicVO;
	}

	@Override
	public int findTotalTopicsByTId(String tid) {
		return topicsDao.findTotalTopicsByTId(tid);
	}
	
	@Override
	public List<TopicVO> findTopicsByLanguageId(String languageId) {
			List<TopicEntity> topicEntityList=topicsDao.findTopicsByLanguageId(languageId);
			List<TopicVO> topicVoList=new ArrayList<TopicVO>();
			for(TopicEntity topicEntity: topicEntityList){
				TopicVO  topicVO=new TopicVO();
				BeanUtils.copyProperties(topicEntity, topicVO);
				topicVoList.add(topicVO);
			}
			return topicVoList;
	}
	
	@Override
	public String deleteTopicById(String tid){
		return topicsDao.deleteTopicById(tid);
	}

}
