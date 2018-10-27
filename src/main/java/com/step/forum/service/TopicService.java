package com.step.forum.service;

import com.step.forum.model.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getAllTopic();
    Topic getTopicById(int id);
    List<Topic> getPopularTopics();
}
