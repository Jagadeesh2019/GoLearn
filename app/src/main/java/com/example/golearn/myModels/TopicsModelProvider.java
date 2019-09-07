package com.example.golearn.myModels;

public class TopicsModelProvider {

    public static String topicName;

    public TopicsModelProvider() {
    }

    public static String getTopicName() {
        return topicName;
    }

    public static void setTopicName(String topicName) {
        TopicsModelProvider.topicName = topicName;
    }
}
