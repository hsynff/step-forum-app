package com.step.forum.service;

import com.step.forum.dao.TopicDao;
import com.step.forum.model.Comment;
import com.step.forum.model.Topic;

import java.sql.SQLException;
import java.util.List;

public class TopicServiceImpl implements TopicService {

    private TopicDao topicDao;

    public TopicServiceImpl(TopicDao topicDao){
        this.topicDao = topicDao;
    }


    @Override
    public List<Topic> getAllTopic() throws SQLException {
        return topicDao.getAllTopic();
    }

    @Override
    public Topic getTopicById(int id)throws SQLException {
        return topicDao.getTopicById(id);
    }

    @Override
    public List<Topic> getPopularTopics()throws SQLException {
        return topicDao.getPopularTopics();
    }

    @Override
    public void addTopic(Topic topic)throws SQLException {
        topicDao.addTopic(topic);
    }

    @Override
    public void updateTopicViewCount(int topicId)throws SQLException {
        topicDao.updateTopicViewCount(topicId);
    }

    @Override
    public List<Topic> getSimilarTopics(String[] keywords)throws SQLException {
        return topicDao.getSimilarTopics(keywords);
    }

    @Override
    public List<Comment> getCommentsByTopicId(int id)throws SQLException {
        return topicDao.getCommentsByTopicId(id);
    }

    @Override
    public void addComment(Comment comment)throws SQLException {
        topicDao.addComment(comment);
    }

    @Override
    public List<Topic> getTopicByUserId(int idUser)throws SQLException {
        return topicDao.getTopicByUserId(idUser);
    }
}
