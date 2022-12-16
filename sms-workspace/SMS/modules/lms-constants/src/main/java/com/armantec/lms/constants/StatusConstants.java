package com.armantec.lms.constants;

import java.util.Map;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * The purpose of this interface to list down all the contstants
 * that will be used with respect to status.
 *
 * Accessibility : Througout application
 *
 *
 *@author Dorjee Tsering
 * 
 */
public class StatusConstants {
	/**
	 * Will be used throughout application if Status for an entity is active
	 */
	public static final int STATUS_ACTIVE = 0;
	
	/**
	 * Will be used throughout application if Status for an entity is approve
	 */
	public static final int STATUS_APPROVE = 1;
	
	/**
	 * Will be used throughout application if Status for an entity is draft
	 */
	public static final int STATUS_DRAFT = 2;
	
	/**
	 * Will be used throughout application if Status for an entity is reject
	 */
	public static final int STATUS_REJECT = 3;
	
	/**
	 * Will be used throughout application if Status for an entity is withdraw
	 */
	public static final int STATUS_WITHDRAW = 4;
	
	/**
	 * Will be used as text throughout application if Status for an entity is active
	 */
	public static final String STATUS_LOCALE_TEXT_ACTIVE = "active";
	
	/**
	 * Will be used as text throughout application if Status for an entity is activated
	 */
	public static final String STATUS_LOCALE_TEXT_ACTIVATED = "activated";
	
	
	/**
	 * Will be used as text throughout application if Status for an entity is approve
	 */
	public static final String STATUS_LOCALE_TEXT_APPROVE = "approve";
	
	/**
	 * Will be used as text throughout application if Status for an entity is approved
	 */
	public static final String STATUS_LOCALE_TEXT_APPROVED = "approved";
	
	
	/**
	 * Will be used as text throughout application if Status for an entity is draft
	 */
	public static final String STATUS_LOCALE_TEXT_DRAFT = "draft";
	
	/**
	 * Will be used as text throughout application if Status for an entity is drafted
	 */
	public static final String STATUS_LOCALE_TEXT_DRAFTED = "drafted";
	
	/**
	 * Will be used as text throughout application if Status for an entity is reject
	 */
	public static final String STATUS_LOCALE_TEXT_REJECT = "reject";
	
	/**
	 * Will be used as text throughout application if Status for an entity is rejected
	 */
	public static final String STATUS_LOCALE_TEXT_REJECTED = "rejected";
	
	/**
	 * Will be used as text throughout application if Status for an entity is withdraw
	 */
	public static final String STATUS_LOCALE_TEXT_WITHDRAW = "withdraw";
	
	/**
	 * Will be used as text throughout application if Status for an entity is withdrawn
	 */
	public static final String STATUS_LOCALE_TEXT_WITHDRAWN = "withdrawn";
	
	/**
	 * This method is used for getting the Status names for Integer status number.
	 * This method is called from view.jsp for displaying Status filters.
	 * @return Map<Integer, String> : Holds Status number as key and Status name as per locale as value
	 */
	public static Map<Integer, String> getStatusTextAsPerLocaleForStatus(){
		Map<Integer, String> statusText = new HashMap<Integer, String>();
		statusText.put(STATUS_ACTIVE, STATUS_LOCALE_TEXT_ACTIVATED);
		statusText.put(STATUS_REJECT, STATUS_LOCALE_TEXT_REJECTED);
		statusText.put(STATUS_DRAFT, STATUS_LOCALE_TEXT_DRAFTED);
		statusText.put(STATUS_APPROVE, STATUS_LOCALE_TEXT_APPROVED);
		statusText.put(STATUS_WITHDRAW, STATUS_LOCALE_TEXT_WITHDRAWN);
		statusText.put(STATUS_START,STATUS_LOCALE_TEXT_STARTED);
		statusText.put(STATUS_CLOSE,STATUS_LOCALE_TEXT_CLOSED);
		statusText.put(STATUS_PROGRESS,STATUS_LOCALE_TEXT_PROGRESS);
		statusText.put(STATUS_WITHDRAW,STATUS_LOCALE_TEXT_WITHDRAWN);	
		return statusText;
	}
	
	
	
	public static Map<Integer, String> getStatusTextAsPerLocaleForStatus(Locale locale){
		Map<Integer, String> statusText = new HashMap<Integer, String>();
		statusText.put(STATUS_DRAFT, LanguageUtil.get(locale, STATUS_LOCALE_TEXT_DRAFTED));
		statusText.put(STATUS_APPROVE, LanguageUtil.get(locale, STATUS_LOCALE_TEXT_APPROVED));
		statusText.put(STATUS_ACTIVE, LanguageUtil.get(locale, STATUS_LOCALE_TEXT_ACTIVATED));
		statusText.put(STATUS_REJECT, LanguageUtil.get(locale, STATUS_LOCALE_TEXT_REJECTED));
		statusText.put(STATUS_WITHDRAW, LanguageUtil.get(locale, STATUS_LOCALE_TEXT_WITHDRAWN));
		statusText.put(STATUS_START,LanguageUtil.get(locale, STATUS_LOCALE_TEXT_STARTED));
		statusText.put(STATUS_CLOSE,LanguageUtil.get(locale, STATUS_LOCALE_TEXT_CLOSED));
		statusText.put(STATUS_PROGRESS,LanguageUtil.get(locale, STATUS_LOCALE_TEXT_PROGRESS));
		statusText.put(STATUS_WITHDRAW, LanguageUtil.get(locale, STATUS_LOCALE_TEXT_WITHDRAWN));	
		return statusText;
	}
	
	public static JSONObject getStatusMapObject(Locale locale){
		JSONObject statusMap = JSONFactoryUtil.createJSONObject();
/*
		statusMap.put(String.valueOf(STATUS_DRAFT),LanguageUtil.get(locale, STATUS_LOCALE_TEXT_DRAFTED));
		statusMap.put(String.valueOf(STATUS_APPROVE),LanguageUtil.get(locale, STATUS_LOCALE_TEXT_APPROVED));
		statusMap.put(String.valueOf(STATUS_ACTIVE),LanguageUtil.get(locale, STATUS_LOCALE_TEXT_ACTIVATED));
		statusMap.put(String.valueOf(STATUS_REJECT),LanguageUtil.get(locale, STATUS_LOCALE_TEXT_REJECTED));
		statusMap.put(String.valueOf(STATUS_WITHDRAW), LanguageUtil.get(locale, STATUS_LOCALE_TEXT_WITHDRAWN));	
		statusMap.put(String.valueOf(STATUS_START),LanguageUtil.get(locale, STATUS_LOCALE_TEXT_STARTED));
		statusMap.put(String.valueOf(STATUS_CLOSE),LanguageUtil.get(locale, STATUS_LOCALE_TEXT_CLOSED));
		statusMap.put(String.valueOf(STATUS_PROGRESS),LanguageUtil.get(locale, STATUS_LOCALE_TEXT_PROGRESS));
		statusMap.put(String.valueOf(STATUS_WITHDRAW), LanguageUtil.get(locale, STATUS_LOCALE_TEXT_WITHDRAWN));	
*/
		return statusMap;
	}
	
	public static List<Integer> getStatus(){
		List<Integer> statusList = new ArrayList<Integer>();
		statusList.add(STATUS_REJECT);
		statusList.add(STATUS_DRAFT);
		statusList.add(STATUS_ACTIVE);
		statusList.add(STATUS_APPROVE);
		statusList.add(STATUS_WITHDRAW);	
		statusList.add(STATUS_START);
		statusList.add(STATUS_CLOSE);
		statusList.add(STATUS_PROGRESS);
		statusList.add(STATUS_WITHDRAW);	
		return statusList;
	}
	
    public static final int STATUS_START = 5;
	
	public static final int STATUS_PROGRESS = 6;
	
	public static final int STATUS_CLOSE = 7;
		
	
	
	public static final String STATUS_LOCALE_TEXT_STARTED = "started";
	
	public static final String STATUS_LOCALE_TEXT_CLOSED = "closed";
		
	public static final String STATUS_LOCALE_TEXT_PROGRESS = "in_progress";
	
	
	
	
}
