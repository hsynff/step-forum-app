package com.step.forum.service;

import com.step.forum.dao.TopicDao;
import com.step.forum.model.Topic;

import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDao topicDao;

    public TopicServiceImpl(TopicDao topicDao){
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
