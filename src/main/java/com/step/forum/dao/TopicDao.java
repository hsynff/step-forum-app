package com.step.forum.dao;

import com.step.forum.model.Topic;

import java.util.List;

public interface TopicDao {
    List<Topic> getAllTopic();
    Topic getTopicById(int id);
    List<Topic> getPopularTopics();
}