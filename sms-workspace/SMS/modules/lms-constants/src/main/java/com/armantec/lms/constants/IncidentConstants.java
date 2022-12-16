package com.armantec.lms.constants;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class IncidentConstants {

	
	public static final String INCIDENT_FOLDER = "Incident"; 
	public static final String INCIDENT_QUERIES_FILE_NAME = "queries"; 
	public static final String INCIDENT_COMMENT_FILE_NAME = "comment"; 
	public static final String INCIDENTCOMMENT_FOLDER = "IncidentComment"; 

	
	
	public static final String INCIDENT_ROLE_STUDENT = "student"; 
	public static final String INCIDENT_ROLE_INSTRUCTOR = "instructor";
	public static final String INCIDENT_ROLE_COURSECREATOR = "coursecreator"; 
	public static final String INCIDENT_ROLE_ADMIN = "admin"; 
	
	
	//incident type
	public static final String INCIDENT_TYPE_COURSE = "course";
	public static final String INCIDENT_TYPE_LESSON = "lesson";
	public static final String INCIDENT_TYPE_ASSESSMENT = "assessment";
	public static final String INCIDENT_TYPE_INSTRUCTOR = "instructor";
	public static final String INCIDENT_TYPE_COURSECREATOR = "coursecreator";
	public static final String INCIDENT_TYPE_ASSIGNMENT = "assignment";
	public static final String INCIDENT_TYPE_FACILITY_RELATED= "facility_related";
	
	//severity type
	public static final String SEVERITY_TYPE_CRITICAL = "critical";
	public static final String SEVERITY_TYPE_MAJOR = "major";
	public static final String SEVERITY_TYPE_MODERATE = "moderate";
	public static final String SEVERITY_TYPE_LOW = "low";
	

	
	public static Map<String, String> getIncidentTypes(Locale locale){
		Map<String, String> incidentTypeList = new HashMap<String, String>();
		incidentTypeList.put(INCIDENT_TYPE_COURSE, LanguageUtil.get(locale, INCIDENT_TYPE_COURSE));
		incidentTypeList.put(INCIDENT_TYPE_LESSON, LanguageUtil.get(locale, INCIDENT_TYPE_LESSON));
		incidentTypeList.put(INCIDENT_TYPE_ASSESSMENT, LanguageUtil.get(locale, INCIDENT_TYPE_ASSESSMENT));
		incidentTypeList.put(INCIDENT_TYPE_INSTRUCTOR, LanguageUtil.get(locale, INCIDENT_TYPE_INSTRUCTOR));
		incidentTypeList.put(INCIDENT_TYPE_COURSECREATOR, LanguageUtil.get(locale, INCIDENT_TYPE_COURSECREATOR));
		incidentTypeList.put(INCIDENT_TYPE_ASSIGNMENT,LanguageUtil.get(locale, INCIDENT_TYPE_ASSIGNMENT));
		incidentTypeList.put(INCIDENT_TYPE_FACILITY_RELATED,LanguageUtil.get(locale, INCIDENT_TYPE_FACILITY_RELATED));
		
	return incidentTypeList;
	}
	
	public static Map<String, String> getSeverityTypes(Locale locale){
		Map<String, String> severityTypesList = new HashMap<String, String>();
		severityTypesList.put(SEVERITY_TYPE_CRITICAL, LanguageUtil.get(locale, SEVERITY_TYPE_CRITICAL));
		severityTypesList.put(SEVERITY_TYPE_MAJOR, LanguageUtil.get(locale, SEVERITY_TYPE_MAJOR));
		severityTypesList.put(SEVERITY_TYPE_MODERATE, LanguageUtil.get(locale, SEVERITY_TYPE_MODERATE));
		severityTypesList.put(SEVERITY_TYPE_LOW, LanguageUtil.get(locale, SEVERITY_TYPE_LOW));
		
	return severityTypesList;
	}
	

	public static JSONObject getIncidentTypesMapObject(Locale locale){
		JSONObject incidentTypesMap = JSONFactoryUtil.createJSONObject();
/*
		incidentTypesMap.put(INCIDENT_TYPE_COURSE,LanguageUtil.get(locale, INCIDENT_TYPE_COURSE));
		incidentTypesMap.put(INCIDENT_TYPE_LESSON,LanguageUtil.get(locale, INCIDENT_TYPE_LESSON));
		incidentTypesMap.put(INCIDENT_TYPE_ASSESSMENT,LanguageUtil.get(locale, INCIDENT_TYPE_ASSESSMENT));
		incidentTypesMap.put(INCIDENT_TYPE_INSTRUCTOR,LanguageUtil.get(locale, INCIDENT_TYPE_INSTRUCTOR));
		incidentTypesMap.put(INCIDENT_TYPE_COURSECREATOR,LanguageUtil.get(locale, INCIDENT_TYPE_COURSECREATOR));
		incidentTypesMap.put(INCIDENT_TYPE_ASSIGNMENT,LanguageUtil.get(locale, INCIDENT_TYPE_ASSIGNMENT));
		incidentTypesMap.put(INCIDENT_TYPE_FACILITY_RELATED,LanguageUtil.get(locale, INCIDENT_TYPE_FACILITY_RELATED));
*/
		return incidentTypesMap;
	}
	
	
	
	public static JSONObject getSeverityTypesMapObject(Locale locale){
		JSONObject severityTypesMap = JSONFactoryUtil.createJSONObject();
/*		
		severityTypesMap.put(SEVERITY_TYPE_CRITICAL,LanguageUtil.get(locale, SEVERITY_TYPE_CRITICAL));
		severityTypesMap.put(SEVERITY_TYPE_MAJOR,LanguageUtil.get(locale, SEVERITY_TYPE_MAJOR));
		severityTypesMap.put(SEVERITY_TYPE_MODERATE,LanguageUtil.get(locale, SEVERITY_TYPE_MODERATE));
		severityTypesMap.put(SEVERITY_TYPE_LOW,LanguageUtil.get(locale, SEVERITY_TYPE_LOW));		
*/
		return severityTypesMap;
	}
	
	
	

	
	
}
