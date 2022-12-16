package com.armantec.lms.constants;

public class SearchConstants {
  public static final int TOPIC_SEARCH_DELTA = 10;
  public static final int PAGINATION_DELTA = 2;
  public static final String TOPIC_MODEL_NAME = "com.armantec.lms.model.Topic";
  public static final String TOPIC_SEARCH_COLUMN_NAME = "title";
  public static final String TOPIC_SEARCH_REMOTE_API_URL = "/api/jsonws/lms.translation/search-topics";
  public static final String COURSE_SEARCH_PRIVATE_PAGE_URL = "/group/lms/search";
  public static final String COURSE_SEARCH_KEYWORD_PARAM_NAME = "keywords";
  public static final String COURSE_SEARCH_SELECTED_TOPICS_PARAM_NAME = "selectedTopics";
  public static final String TOPIC_SEPARATOR = ",";
  public static final String TOPIC_ID_NAME_SEPARATOR = "::";
  public static final int MAX_COURSE_EXPIRY_DURATION_YEAR = 100;
  public static final String PRIVATE_LANDING_PAGE_URL = "/group/lms";
}
