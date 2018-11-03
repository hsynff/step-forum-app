package com.step.forum.service;

import com.step.forum.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopic();
    Topic getTopicById(int id);
    List<Topic> getPopularTopics();
    boolean addTopic(Topic topic);
    boolean updateTopicViewCount(int topicId);
    List<Topic> getSimilarTopics(String[] keywords);
}
