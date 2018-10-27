package com.step.forum.service;

import com.step.forum.dao.TopicDAO;
import com.step.forum.dao.TopicDaoImpl;
import com.step.forum.model.Topic;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDAO topicDao;

    public TopicServiceImpl(TopicDAO topicDao){
        this.topicDao = topicDao;
    }


    @Override
    public List<Topic> getAllTopic() {
        return topicDao.getAllTopic();
    }

    @Override
    public Topic getTopicById(int id) {
        return topicDao.getTopicById(id);
    }

    @Override
    public List<Topic> getPopularTopics() {
        return topicDao.getPopularTopics();
    }
}
