package com.armantec.lms.constants;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.Locale;

public class FeedbackConstants {
	/**
	 * Holds the constant and its value
	 */
	public static final String FEEDBACK_CREATE_AND_EDIT_BACK_BUTTON_URL = "/group/lms/feedback-creation-edit"; 
	public static final int BASE_RATING = 5; 
	public static final String FEEDBACK_TYPE_TOPIC = "topic"; 
	public static final String FEEDBACK_TYPE_QUIZ_ASSESSMENT = "quizAssessment"; 
	public static final String[] FEEDBACK_TYPES = new String[] {FEEDBACK_TYPE_TOPIC,FEEDBACK_TYPE_QUIZ_ASSESSMENT};
	public static JSONArray getFeedbackTypeArray(Locale locale){
		JSONArray feedbackTypeArray = JSONFactoryUtil.createJSONArray();
		JSONObject feedbackTypeTopic = JSONFactoryUtil.createJSONObject();
//		feedbackTypeTopic.put("id",FEEDBACK_TYPE_TOPIC);
//		feedbackTypeTopic.put("title",LanguageUtil.get(locale, FEEDBACK_TYPE_TOPIC));
		JSONObject feedbackTypeQuiz = JSONFactoryUtil.createJSONObject();
//		feedbackTypeQuiz.put("id",FEEDBACK_TYPE_QUIZ_ASSESSMENT);
//		feedbackTypeQuiz.put("title",LanguageUtil.get(locale, FEEDBACK_TYPE_QUIZ_ASSESSMENT));
//		feedbackTypeArray.put(feedbackTypeTopic);
//		feedbackTypeArray.put(feedbackTypeQuiz);
		return feedbackTypeArray;
	}
	
	//Session Feedback
	public static final int SESSION_FEEDBACK_BASE_RATING = 4; 
	
}
