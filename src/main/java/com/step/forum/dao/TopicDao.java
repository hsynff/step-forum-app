package com.step.forum.dao;

import com.step.forum.model.Comment;
import com.step.forum.model.Topic;

import java.util.List;

public interface TopicDao {
    List<Topic> getAllTopic();
    Topic getTopicById(int id);
    List<Topic> getPopularTopics();
    boolean addTopic(Topic topic);
    boolean updateTopicViewCount(int topicId);
    List<Topic> getSimilarTopics(String[] keywords);
    List<Comment> getCommentsByTopicId(int id);
    boolean addComment(Comment comment);
    List<Topic> getTopicByUserId(int idUser);
}
