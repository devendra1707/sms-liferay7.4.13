package com.armantec.lms.constants;

public class RoleConstants {
	public static final String ADMINISTRATOR = "Administrator";
	public static final String LMS_ADMIN = "LMS Admin";
	public static final String LMS_COURSE_INSTRUCTOR = "LMS Course Instructor";
	 public static final String LMS_COURSE_COORDINATOR = "LMS Course Coordinator";
	 public static final String LMS_COURSE_DIRECTOR = "LMS Course Approver";

	public static final String LMS_COURSE_CREATOR = "LMS Course Creator";
	public static final String LMS_COURSE_APPROVER = "LMS Course Approver";
	public static final String LMS_STUDENT = "Student";
	public static final String LMS_ALT_STUDENT = "LMS Student";
	public static final String LMS_DOCUMENT_MANAGER = "Document Manager";
	
	public static final String[] ALL_USER_ROLES = new String[]{ADMINISTRATOR,LMS_ADMIN,LMS_COURSE_INSTRUCTOR,LMS_COURSE_CREATOR,LMS_COURSE_APPROVER,LMS_STUDENT};
	
	public static final String[] ALL_LMS_USER_ROLES   = new String[]{LMS_ADMIN,LMS_COURSE_INSTRUCTOR,LMS_COURSE_COORDINATOR,LMS_COURSE_DIRECTOR,LMS_COURSE_CREATOR,LMS_COURSE_APPROVER,LMS_STUDENT};
	
	public static final String CURRENT_USER_ROLES = "CURRENT_USER_ROLES";

	String dump="";
}
