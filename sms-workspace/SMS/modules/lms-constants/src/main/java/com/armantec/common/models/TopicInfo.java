package com.armantec.common.models;

public class TopicInfo {
	String[] topicNames;
	public String[] getTopicNames() {
		return topicNames;
	}
	public void setTopicNames(String[] topicNames) {
		this.topicNames = topicNames;
	}
	public Long[] getTopicIds() {
		return topicIds;
	}
	public void setTopicIds(Long[] topicIds) {
		this.topicIds = topicIds;
	}
	Long[] topicIds;
}
