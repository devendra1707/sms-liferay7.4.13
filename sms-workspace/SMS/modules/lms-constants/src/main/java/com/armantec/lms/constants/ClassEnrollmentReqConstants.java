package com.armantec.lms.constants;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class ClassEnrollmentReqConstants {

	

	//Designation type
	public static final String DESIGNATION_TYPE_ISS = "iss_probationer";
	public static final String DESIGNATION_TYPE_ASSISTANT_DIRECTOR = "assistant_director";
	public static final String DESIGNATION_TYPE_DEPUTY_DIRECTOR = "deputy_director";
	public static final String DESIGNATION_TYPE_JOINT_DIRECTOR = "joint_director";
	
	public static final String DESIGNATION_TYPE_DIRECTOR = "director";
	public static final String DESIGNATION_TYPE_DEPUTY_DIRECTOR_GENERAL = "deputy_director_general";
	public static final String DESIGNATION_TYPE_ADDITIONAL_DIRECTOR_GENERAL = "additional_director_general";
	public static final String DESIGNATION_TYPE_DIRECTOR_GENERAL = "director_general";
	
	public static final String DESIGNATION_TYPE_SECRETARY = "secretary";
	public static final String DESIGNATION_TYPE_OTHERS = "others";
	public static final String DESIGNATION_TYPE_JUNIOR_STATISTICAL_OFFICER = "junior_statistical_officer";
	public static final String DESIGNATION_TYPE_SENIOR_STATISTICAL_OFFICER = "senior_statistical_officer";
	
	public static final String DESIGNATION_TYPE_RESEARCH_OFFICER = "research_officer";
	public static final String DESIGNATION_TYPE_SENIOR_RESEARCH_OFFICER = "senior_research_officer";
	public static final String DESIGNATION_TYPE_STUDENT = "student";
	public static final String DESIGNATION_TYPE_ASSISTANT_PROFESSOR = "assistant_professor";
	
	public static final String DESIGNATION_TYPE_ASSOCIAT_PRODESSOR = "associat_prodessor";
	public static final String DESIGNATION_TYPE_PROFESSOR = "professor";
	public static final String DESIGNATION_TYPE_UNIVERSITY_COLLEGE_FACULTY = "university_college_faculty";
	public static final String DESIGNATION_TYPE_STATISTICAL_INVESTIGATOR = "statistical_investigator";
	
	
	public static Map<String, String> getDesignationTypes(Locale locale){
		Map<String, String> designationTypesList = new HashMap<String, String>();
		designationTypesList.put(DESIGNATION_TYPE_ISS, LanguageUtil.get(locale, DESIGNATION_TYPE_ISS));
		designationTypesList.put(DESIGNATION_TYPE_ASSISTANT_DIRECTOR, LanguageUtil.get(locale, DESIGNATION_TYPE_ASSISTANT_DIRECTOR));
		designationTypesList.put(DESIGNATION_TYPE_DEPUTY_DIRECTOR, LanguageUtil.get(locale, DESIGNATION_TYPE_DEPUTY_DIRECTOR));
		designationTypesList.put(DESIGNATION_TYPE_JOINT_DIRECTOR, LanguageUtil.get(locale, DESIGNATION_TYPE_JOINT_DIRECTOR));
		
		designationTypesList.put(DESIGNATION_TYPE_DIRECTOR, LanguageUtil.get(locale, DESIGNATION_TYPE_DIRECTOR));
		designationTypesList.put(DESIGNATION_TYPE_DEPUTY_DIRECTOR_GENERAL, LanguageUtil.get(locale, DESIGNATION_TYPE_DEPUTY_DIRECTOR_GENERAL));
		designationTypesList.put(DESIGNATION_TYPE_ADDITIONAL_DIRECTOR_GENERAL, LanguageUtil.get(locale, DESIGNATION_TYPE_ADDITIONAL_DIRECTOR_GENERAL));
		designationTypesList.put(DESIGNATION_TYPE_DIRECTOR_GENERAL, LanguageUtil.get(locale, DESIGNATION_TYPE_DIRECTOR_GENERAL));
		
		designationTypesList.put(DESIGNATION_TYPE_SECRETARY, LanguageUtil.get(locale, DESIGNATION_TYPE_SECRETARY));
		designationTypesList.put(DESIGNATION_TYPE_OTHERS, LanguageUtil.get(locale, DESIGNATION_TYPE_OTHERS));
		designationTypesList.put(DESIGNATION_TYPE_JUNIOR_STATISTICAL_OFFICER, LanguageUtil.get(locale, DESIGNATION_TYPE_JUNIOR_STATISTICAL_OFFICER));
		designationTypesList.put(DESIGNATION_TYPE_SENIOR_STATISTICAL_OFFICER, LanguageUtil.get(locale, DESIGNATION_TYPE_SENIOR_STATISTICAL_OFFICER));
		
		designationTypesList.put(DESIGNATION_TYPE_RESEARCH_OFFICER, LanguageUtil.get(locale, DESIGNATION_TYPE_RESEARCH_OFFICER));
		designationTypesList.put(DESIGNATION_TYPE_SENIOR_RESEARCH_OFFICER, LanguageUtil.get(locale, DESIGNATION_TYPE_SENIOR_RESEARCH_OFFICER));
		designationTypesList.put(DESIGNATION_TYPE_STUDENT, LanguageUtil.get(locale, DESIGNATION_TYPE_STUDENT));
		designationTypesList.put(DESIGNATION_TYPE_ASSISTANT_PROFESSOR, LanguageUtil.get(locale, DESIGNATION_TYPE_ASSISTANT_PROFESSOR));
		
		designationTypesList.put(DESIGNATION_TYPE_ASSOCIAT_PRODESSOR, LanguageUtil.get(locale, DESIGNATION_TYPE_ASSOCIAT_PRODESSOR));
		designationTypesList.put(DESIGNATION_TYPE_PROFESSOR, LanguageUtil.get(locale, DESIGNATION_TYPE_PROFESSOR));
		designationTypesList.put(DESIGNATION_TYPE_UNIVERSITY_COLLEGE_FACULTY, LanguageUtil.get(locale, DESIGNATION_TYPE_UNIVERSITY_COLLEGE_FACULTY));
		designationTypesList.put(DESIGNATION_TYPE_STATISTICAL_INVESTIGATOR, LanguageUtil.get(locale, DESIGNATION_TYPE_STATISTICAL_INVESTIGATOR));
		
		
	return designationTypesList;
	}

	
	public static JSONObject getDesignationTypesMapObject(Locale locale){
		JSONObject designationTypesMap = JSONFactoryUtil.createJSONObject();
/*	
		designationTypesMap.put(DESIGNATION_TYPE_ISS, LanguageUtil.get(locale, DESIGNATION_TYPE_ISS));
		designationTypesMap.put(DESIGNATION_TYPE_ASSISTANT_DIRECTOR, LanguageUtil.get(locale, DESIGNATION_TYPE_ASSISTANT_DIRECTOR));
		designationTypesMap.put(DESIGNATION_TYPE_DEPUTY_DIRECTOR, LanguageUtil.get(locale, DESIGNATION_TYPE_DEPUTY_DIRECTOR));
		designationTypesMap.put(DESIGNATION_TYPE_JOINT_DIRECTOR, LanguageUtil.get(locale, DESIGNATION_TYPE_JOINT_DIRECTOR));
		
		designationTypesMap.put(DESIGNATION_TYPE_DIRECTOR, LanguageUtil.get(locale, DESIGNATION_TYPE_DIRECTOR));
		designationTypesMap.put(DESIGNATION_TYPE_DEPUTY_DIRECTOR_GENERAL, LanguageUtil.get(locale, DESIGNATION_TYPE_DEPUTY_DIRECTOR_GENERAL));
		designationTypesMap.put(DESIGNATION_TYPE_ADDITIONAL_DIRECTOR_GENERAL, LanguageUtil.get(locale, DESIGNATION_TYPE_ADDITIONAL_DIRECTOR_GENERAL));
		designationTypesMap.put(DESIGNATION_TYPE_DIRECTOR_GENERAL, LanguageUtil.get(locale, DESIGNATION_TYPE_DIRECTOR_GENERAL));
		
		designationTypesMap.put(DESIGNATION_TYPE_SECRETARY, LanguageUtil.get(locale, DESIGNATION_TYPE_SECRETARY));
		designationTypesMap.put(DESIGNATION_TYPE_OTHERS, LanguageUtil.get(locale, DESIGNATION_TYPE_OTHERS));
		designationTypesMap.put(DESIGNATION_TYPE_JUNIOR_STATISTICAL_OFFICER, LanguageUtil.get(locale, DESIGNATION_TYPE_JUNIOR_STATISTICAL_OFFICER));
		designationTypesMap.put(DESIGNATION_TYPE_SENIOR_STATISTICAL_OFFICER, LanguageUtil.get(locale, DESIGNATION_TYPE_SENIOR_STATISTICAL_OFFICER));
		
		designationTypesMap.put(DESIGNATION_TYPE_RESEARCH_OFFICER, LanguageUtil.get(locale, DESIGNATION_TYPE_RESEARCH_OFFICER));
		designationTypesMap.put(DESIGNATION_TYPE_SENIOR_RESEARCH_OFFICER, LanguageUtil.get(locale, DESIGNATION_TYPE_SENIOR_RESEARCH_OFFICER));
		designationTypesMap.put(DESIGNATION_TYPE_STUDENT, LanguageUtil.get(locale, DESIGNATION_TYPE_STUDENT));
		designationTypesMap.put(DESIGNATION_TYPE_ASSISTANT_PROFESSOR, LanguageUtil.get(locale, DESIGNATION_TYPE_ASSISTANT_PROFESSOR));
		
		designationTypesMap.put(DESIGNATION_TYPE_ASSOCIAT_PRODESSOR, LanguageUtil.get(locale, DESIGNATION_TYPE_ASSOCIAT_PRODESSOR));
		designationTypesMap.put(DESIGNATION_TYPE_PROFESSOR, LanguageUtil.get(locale, DESIGNATION_TYPE_PROFESSOR));
		designationTypesMap.put(DESIGNATION_TYPE_UNIVERSITY_COLLEGE_FACULTY, LanguageUtil.get(locale, DESIGNATION_TYPE_UNIVERSITY_COLLEGE_FACULTY));
		designationTypesMap.put(DESIGNATION_TYPE_STATISTICAL_INVESTIGATOR, LanguageUtil.get(locale, DESIGNATION_TYPE_STATISTICAL_INVESTIGATOR));
*/		
		return designationTypesMap;
	}
	
	
	
	
}
