package com.armantec.lms.constants;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CandidateConstants {
	/**
	 * Holds the constant and its value
	 */
	public static final String CONDIDATE_ATTACHMENT = "candidate-attachment"; 
	public static final String CONDIDATE_STATUS = "candidate-status"; 
	
	public static final String CONDIDATE_ACTIVATION_ERROR_URL = "/web/lms/activation-error"; 
	public static final String CONDIDATE_ACTIVATION_LINK_EXPIRED_URL = "/web/lms/activation-link-expired"; 
	public static final String CONDIDATE_ACTIVATION_SUCCESS_URL = "/web/lms/activation-success"; 
	public static final String CONDIDATE_REGISTRATION_URL = "/web/lms/candidate-registration"; 

	
	
	

	
	//employer type
	public static final String EMPLOYER_TYPE_CENTRAL_GOVT = "central_govt";
	public static final String EMPLOYER_TYPE_STATE_GOVT = "state_govt";
	public static final String EMPLOYER_TYPE_PSUS_AUTONOMOUS_BODY = "psus_autonomous_body";
	public static final String EMPLOYER_TYPE_OTHERS = "others";	
	public static final String EMPLOYER_TYPE_NOT_APPLICABLE = "not_applicable";
	public static final String EMPLOYER_TYPE_UNIVERSITY = "university";
	public static final String EMPLOYER_TYPE_COLLEGE = "college";
	public static final String EMPLOYER_TYPE_INSTITUTION = "institution";
	
	
	//Applicant Category
	public static final String APPLICANT_CATEGORY_ISS = "iss";
	public static final String APPLICANT_CATEGORY_SSS = "sss";
	public static final String APPLICANT_CATEGORY_STATE_GOVT_EMPLOYEE = "state_govt_employee";
	public static final String APPLICANT_CATEGORY_UNIVERSITY_FACULTY = "university_faculty";
	public static final String APPLICANT_CATEGORY_STUDENT = "Student";
	public static final String APPLICANT_CATEGORY_ISS_PROBATIONER = "iss_probationer";
	public static final String APPLICANT_CATEGORY_SSS_PROBATIONER = "sss_probationer";
	
	

	
	public static Map<String, String> getEmployerTypes(Locale locale){
		Map<String, String> employerTypesList = new HashMap<String, String>();
		employerTypesList.put(EMPLOYER_TYPE_CENTRAL_GOVT, LanguageUtil.get(locale, EMPLOYER_TYPE_CENTRAL_GOVT));
		employerTypesList.put(EMPLOYER_TYPE_STATE_GOVT, LanguageUtil.get(locale, EMPLOYER_TYPE_STATE_GOVT));
		employerTypesList.put(EMPLOYER_TYPE_PSUS_AUTONOMOUS_BODY, LanguageUtil.get(locale, EMPLOYER_TYPE_PSUS_AUTONOMOUS_BODY));
		employerTypesList.put(EMPLOYER_TYPE_OTHERS, LanguageUtil.get(locale, EMPLOYER_TYPE_OTHERS));
		
		employerTypesList.put(EMPLOYER_TYPE_NOT_APPLICABLE, LanguageUtil.get(locale, EMPLOYER_TYPE_NOT_APPLICABLE));
		employerTypesList.put(EMPLOYER_TYPE_UNIVERSITY, LanguageUtil.get(locale, EMPLOYER_TYPE_UNIVERSITY));
		employerTypesList.put(EMPLOYER_TYPE_COLLEGE, LanguageUtil.get(locale, EMPLOYER_TYPE_COLLEGE));
		employerTypesList.put(EMPLOYER_TYPE_INSTITUTION, LanguageUtil.get(locale, EMPLOYER_TYPE_INSTITUTION));
		
		
	return employerTypesList;
	}
	
	
	
	public static JSONObject getEmployerTypesMapObject(Locale locale){
		JSONObject employerTypesMap = JSONFactoryUtil.createJSONObject();
/*
		employerTypesMap.put(EMPLOYER_TYPE_CENTRAL_GOVT, LanguageUtil.get(locale, EMPLOYER_TYPE_CENTRAL_GOVT));
		employerTypesMap.put(EMPLOYER_TYPE_STATE_GOVT, LanguageUtil.get(locale, EMPLOYER_TYPE_STATE_GOVT));
		employerTypesMap.put(EMPLOYER_TYPE_PSUS_AUTONOMOUS_BODY, LanguageUtil.get(locale, EMPLOYER_TYPE_PSUS_AUTONOMOUS_BODY));
		employerTypesMap.put(EMPLOYER_TYPE_OTHERS, LanguageUtil.get(locale, EMPLOYER_TYPE_OTHERS));
		
		employerTypesMap.put(EMPLOYER_TYPE_NOT_APPLICABLE, LanguageUtil.get(locale, EMPLOYER_TYPE_NOT_APPLICABLE));
		employerTypesMap.put(EMPLOYER_TYPE_UNIVERSITY, LanguageUtil.get(locale, EMPLOYER_TYPE_UNIVERSITY));
		employerTypesMap.put(EMPLOYER_TYPE_COLLEGE, LanguageUtil.get(locale, EMPLOYER_TYPE_COLLEGE));
		employerTypesMap.put(EMPLOYER_TYPE_INSTITUTION, LanguageUtil.get(locale, EMPLOYER_TYPE_INSTITUTION));
*/	
		return employerTypesMap;
	}
	
	
	
	public static Map<String, String> getApplicantCategory(Locale locale){
		Map<String, String> applicantCategoryList = new HashMap<String, String>();
		applicantCategoryList.put(APPLICANT_CATEGORY_ISS, LanguageUtil.get(locale, APPLICANT_CATEGORY_ISS));
		applicantCategoryList.put(APPLICANT_CATEGORY_SSS, LanguageUtil.get(locale, APPLICANT_CATEGORY_SSS));
		applicantCategoryList.put(APPLICANT_CATEGORY_STATE_GOVT_EMPLOYEE, LanguageUtil.get(locale, APPLICANT_CATEGORY_STATE_GOVT_EMPLOYEE));
		applicantCategoryList.put(APPLICANT_CATEGORY_UNIVERSITY_FACULTY, LanguageUtil.get(locale, APPLICANT_CATEGORY_UNIVERSITY_FACULTY));
		
		applicantCategoryList.put(APPLICANT_CATEGORY_STUDENT, LanguageUtil.get(locale, APPLICANT_CATEGORY_STUDENT));
		applicantCategoryList.put(APPLICANT_CATEGORY_ISS_PROBATIONER, LanguageUtil.get(locale, APPLICANT_CATEGORY_ISS_PROBATIONER));
		applicantCategoryList.put(APPLICANT_CATEGORY_SSS_PROBATIONER, LanguageUtil.get(locale, APPLICANT_CATEGORY_SSS_PROBATIONER));
		
		
	return applicantCategoryList;
	}
	
	
	public static JSONObject getApplicantCategoryMapObject(Locale locale){
		JSONObject applicantCategoryMap = JSONFactoryUtil.createJSONObject();
/*	
		applicantCategoryMap.put(APPLICANT_CATEGORY_ISS, LanguageUtil.get(locale, APPLICANT_CATEGORY_ISS));
		applicantCategoryMap.put(APPLICANT_CATEGORY_SSS, LanguageUtil.get(locale, APPLICANT_CATEGORY_SSS));
		applicantCategoryMap.put(APPLICANT_CATEGORY_STATE_GOVT_EMPLOYEE, LanguageUtil.get(locale, APPLICANT_CATEGORY_STATE_GOVT_EMPLOYEE));
		applicantCategoryMap.put(APPLICANT_CATEGORY_UNIVERSITY_FACULTY, LanguageUtil.get(locale, APPLICANT_CATEGORY_UNIVERSITY_FACULTY));
		
		applicantCategoryMap.put(APPLICANT_CATEGORY_STUDENT, LanguageUtil.get(locale, APPLICANT_CATEGORY_STUDENT));
		applicantCategoryMap.put(APPLICANT_CATEGORY_ISS_PROBATIONER, LanguageUtil.get(locale, APPLICANT_CATEGORY_ISS_PROBATIONER));
		applicantCategoryMap.put(APPLICANT_CATEGORY_SSS_PROBATIONER, LanguageUtil.get(locale, APPLICANT_CATEGORY_SSS_PROBATIONER));
*/		
		return applicantCategoryMap;
	}
	
	
	
	
	
	
	
}
