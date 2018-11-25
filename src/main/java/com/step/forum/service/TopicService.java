package com.step.forum.service;

import com.step.forum.model.Comment;
import com.step.forum.model.Topic;

import java.sql.SQLException;
import java.util.List;

public interface TopicService {
    List<Topic> getAllTopic() throws SQLException;
    Topic getTopicById(int id) throws SQLException;
    List<Topic> getPopularTopics() throws SQLException;
    void addTopic(Topic topic) throws SQLException;
    void updateTopicViewCount(int topicId) throws SQLException;
    List<Topic> getSimilarTopics(String[] keywords) throws SQLException;
    List<Comment> getCommentsByTopicId(int id) throws SQLException;
    void addComment(Comment comment) throws SQLException;
    List<Topic> getTopicByUserId(int idUser) throws SQLException;
}
