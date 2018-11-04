package com.step.forum.service;

import com.step.forum.dao.TopicDao;
import com.step.forum.model.Comment;
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

    @Override
    public boolean addTopic(Topic topic) {
        return topicDao.addTopic(topic);
    }

    @Override
    public boolean updateTopicViewCount(int topicId) {
        return topicDao.updateTopicViewCount(topicId);
    }

    @Override
    public List<Topic> getSimilarTopics(String[] keywords) {
        return topicDao.getSimilarTopics(keywords);
    }

    @Override
    public List<Comment> getCommentsByTopicId(int id) {
        return topicDao.getCommentsByTopicId(id);
    }

    @Override
    public boolean addComment(Comment comment) {
        return topicDao.addComment(comment);
    }

    @Override
    public List<Topic> getTopicByUserId(int idUser) {
        return topicDao.getTopicByUserId(idUser);
    }
}
