/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.armantec.lms.common.util.services.service.impl;

import com.armantec.lms.common.util.services.exception.NoSuchTranslationException;
import com.armantec.lms.common.util.services.model.Translation;
import com.armantec.lms.common.util.services.service.base.CommonUtilServiceLocalServiceBaseImpl;
import com.armantec.lms.constants.FileConstants;
import com.liferay.asset.kernel.exception.NoSuchVocabularyException;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.content.ContentUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.SecureRandom;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the common util service local service.
 *
 * @author Brian Wing Shun Chan
 * @see CommonUtilServiceLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.armantec.lms.common.util.services.model.CommonUtilService", service = AopService.class)
public class CommonUtilServiceLocalServiceImpl extends CommonUtilServiceLocalServiceBaseImpl {

	public final static int MINUTE_VALUE = 60 * 1000;// 1 Minute
	public final static String LAB_STATUS_STARTED = "Started";
	public final static String LAB_STATUS_ERROR = "Error";
	public final static String LAB_STATUS_STOPPED = "Stopped";
    static final SecureRandom rnd = new SecureRandom();


	public int getMinut() {

		return MINUTE_VALUE;
	}

	public String getLabStatusStarted() {

		return LAB_STATUS_STARTED;
	}

	public String getLabStatusError() {

		return LAB_STATUS_ERROR;
	}

	public String getLabStatusStoped() {

		return LAB_STATUS_STOPPED;
	}

	public String listTextAsPerLangCodeRecordId(String columnName, String modelName, long recordId, String localeCode,long groupId)
			throws PortalException, SystemException {
		Translation translation = null;
		try {

			translation = translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(groupId,
					false, modelName, columnName, localeCode, recordId);

		} catch (NoSuchTranslationException e) {
			String defaultLangCode = translationLocalService.getDefault();
			System.out.println("defaultLangCode:" + defaultLangCode);
			System.out.println("modelName:" + modelName);
			System.out.println("columnName:" + columnName);
			System.out.println("recordId:" + recordId);
			try {
			translation = translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(groupId,
					false, modelName, columnName, defaultLangCode, recordId);
			}catch (Exception ex) {
				try {
				defaultLangCode = defaultLangCode.replace("_", "-");
				translation = translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(getUserOrganizationId(),
						false, modelName, columnName, defaultLangCode, recordId);
				}catch (Exception ex1) {
					return "";
				}
				
			}

		}
		return translation.getText();
	}
	
	public String listTextAsPerLangCodeRecordId(String columnName, String modelName, long recordId, String localeCode)
			throws PortalException, SystemException {
		//System.out.println("columnName:"+columnName+" modelName:"+modelName+" recordId:"+recordId+" localeCode:"+localeCode+" getUserOrganizationId():"+getUserOrganizationId());
		Translation translation = null;

		try {

			translation = translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(getUserOrganizationId(),
					false, modelName, columnName, localeCode, recordId);

		} catch (NoSuchTranslationException e) {
			
			String defaultLangCode = translationLocalService.getDefault();
			System.out.println("defaultLangCode:"+defaultLangCode);
			System.out.println("defaultLangCode:" + defaultLangCode);
			System.out.println("modelName:" + modelName);
			System.out.println("columnName:" + columnName);
			System.out.println("recordId:" + recordId);
			try {
			translation = translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(getUserOrganizationId(),
					false, modelName, columnName, defaultLangCode, recordId);
			}catch (Exception ex) {
				//try {
					defaultLangCode = defaultLangCode.replace("_", "-");
					translation = translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(getUserOrganizationId(),
							false, modelName, columnName, defaultLangCode, recordId);
					/*}catch (Exception ex1) {
					}*/
					
			}

		}
		return translation.getText();
	}

	public String updateTextAsPerLangCode(String multiLingualText, String columnName, String modelName, long recordId,
			String localeCode) throws PortalException, SystemException {
		String defaultLangCode = translationLocalService.getDefault();
		String defaultLangText = "";

		try {

			if (localeCode.trim().equals(defaultLangCode)) {
				defaultLangText = multiLingualText;
			}
			Translation translation = null;
			try {
				translation = translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(
						getUserOrganizationId(), false, modelName, columnName, localeCode, recordId);
				// System.out.println("localeCode:" + localeCode);

			} catch (NoSuchTranslationException e) {
				translation = translationPersistence
						.create(counterLocalService.increment(Translation.class.getClass().getName()));
				// System.out.println("NoSuchTranslationException:");
				translation.setCreateDate(new Date());
				translation.setUserName(getCurrentUser().getFullName());
				translation.setUuid(PortalUUIDUtil.generate());
				translation.setGroupId(getUserOrganizationId());
				translation.setLanguageCode(localeCode.trim());
				translation.setColumnName(columnName);
				translation.setModelName(modelName);
				translation.setRecordId(recordId);
			}
			translation.setModifiedDate(new Date());
			translation.setModifiedBy(PrincipalThreadLocal.getUserId());
			translation.setModifiedByName(getCurrentUser().getFullName());
			translation.setUserId(PrincipalThreadLocal.getUserId());
			translation.setText(multiLingualText);
			translationPersistence.update(translation);
		} catch (Exception e) {

			throwException(e);
		}
		return defaultLangText;
	}

	public ServiceContext getServiceContext() {
		return getServiceContext(false);
	}

	public String evaluateVelocityTemplate(String templateContent, Map variable) {
		Iterator iter = variable.keySet().iterator();
		while (iter.hasNext()) {
			String variableName = (String) iter.next();
			String variableValue = String.valueOf(variable.get(variableName));
			templateContent = templateContent.replaceAll("[$]" + variableName,  Matcher.quoteReplacement(variableValue));
			// System.out.println("[$]" + variableName+":::"+variableValue);
			
		}
		return templateContent;
	}

	public long getCompanyId() {
		try {
			Company company = CompanyLocalServiceUtil.getCompany(PortalUtil.getDefaultCompanyId());
			if (company != null) {
				// System.out.println("company id --" + company.getCompanyId());
				return company.getCompanyId();
			}
		} catch (SystemException e) {

			return 0;
		} catch (PortalException e) {
			return 0;
		}

		return 0;
	}

	public long getServiceScopeGroupIdBySiteName() throws PortalException {

		return GroupLocalServiceUtil.getGroup(CompanyThreadLocal.getCompanyId().longValue(), "LMS").getGroupId();
	}
	
	
	public long getServiceScopeGroupId() {

		// System.out.println("site Id: " +
		// PropsUtil.get("api.permission.scopegroup.id"));
		return Long.parseLong(PropsUtil.get("api.permission.scopegroup.id"));

	}

	public ServiceContext getServiceContext(boolean scopeGroup) {
		ServiceContext context = ServiceContextThreadLocal.getServiceContext();
		if (context == null) {
			context = new ServiceContext();
		}
		if (scopeGroup) {
			// System.out.println("scopeGroup:" + getServiceScopeGroupId() + ":context:" +
			// context);
			context.setScopeGroupId(getServiceScopeGroupId());
			// System.out.println("scopeGroup:" + context.getScopeGroupId());

		}
		return context;
	}

	public long getGroupId(String name) {
		try {
			return GroupLocalServiceUtil.getGroup(CompanyThreadLocal.getCompanyId(), name).getGroupId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long getUserGroupId(long userId, String name) {
		long groupId = 0;
		try {
			User user = UserLocalServiceUtil.getUser(userId);
			List<UserGroup> userGrps = user.getUserGroups();
			for (UserGroup ug : userGrps) {

				if (ug.getName().equalsIgnoreCase(name)) {
					groupId = ug.getGroup().getGroupId();
				}
			}
		} catch (Exception e) {
		}
		return groupId;
	}

	public long getUserGroupId(long userId, String userGroupName, String defaultUserGroupName) {
		long groupId = getUserGroupId(userId, "Student");
		if (groupId == 0) {
			groupId = getGroupId("Guest"); // 10184;
		}
		return groupId;
	}

	public boolean hasUserGroup(User user, String userGroupName) {
		boolean isUserGroup = false;
		try {
			List<UserGroup> userGroups = user.getUserGroups();
			for (UserGroup ug : userGroups) {
				if (ug.getName().equalsIgnoreCase(userGroupName)) {
					isUserGroup = true;
					break;
				}
			}
		} catch (Exception e) {
			// Need not handle
		}
		return isUserGroup;
	}

	public User addRole(User user, String roleName) throws SystemException, PortalException {
		Role liferayRole = roleLocalService.fetchRole(CompanyThreadLocal.getCompanyId(), roleName);
		roleLocalService.addUserRole(user.getUserId(), liferayRole.getRoleId());
		
		UserLocalServiceUtil.updateUser(user);
		return user;
	}
	
	
	
	public User deleteUserRole(User user, String roleName) throws SystemException, PortalException {
		Role liferayRole = roleLocalService.fetchRole(CompanyThreadLocal.getCompanyId(), roleName);
		roleLocalService.deleteUserRole(user.getUserId(), liferayRole.getRoleId());
		UserLocalServiceUtil.updateUser(user);
		return user;
	}

	public boolean hasRole(User user, String roleName) {
		boolean hasRole = false;
		try {
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				if (role.getName().equalsIgnoreCase(roleName)) {
					hasRole = true;
					break;
				}
			}
		} catch (Exception e) {
			// Need not handle
		}
		return hasRole;
	}

	public ArrayList hasRole(User user, String[] roleNames) {
		ArrayList<String> roleList = new ArrayList<String>();
		try {
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				for (String roleName : roleNames) {
					if (role.getName().equalsIgnoreCase(roleName)) {
						roleList.add(roleName);
						break;
					}
				}
			}
		} catch (Exception e) {
		}
		return roleList;
	}

	public boolean hasAnyRole(ArrayList<String> userRoles, String[] roleNames) {
		boolean hasRole = false;
		for (String roleName : roleNames) {
			if (userRoles.contains(roleName)) {
				hasRole = true;
				break;
			}
		}
		return hasRole;
	}

	public boolean hasAllRoles(ArrayList<String> userRoles, String[] roleNames) {
		int matchedCounter = 0;
		for (String roleName : roleNames) {
			if (userRoles.contains(roleName)) {
				matchedCounter += 1;
			}
		}
		return roleNames.length == matchedCounter;
	}

	public void assignUserGroup(long userId, long companyId, String groupName) throws PortalException, SystemException {

		Group group = GroupLocalServiceUtil.getGroup(companyId, groupName);
		if (group != null) {
			GroupLocalServiceUtil.addUserGroup(userId, group);
		}
	}

	public String getRandomString(int len) {
		char[] charset = "abcdefghijklnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~`!@#$%^&*()-_=+[]{}\\|;:'\",<.>/?"
				.toCharArray();
		if (len > charset.length) {
			return null;
		}
		String phrase = "";
		for (int i = 0; i < len; ++i) {
			phrase += charset[(int) (Math.floor(Math.random() * charset.length))];
		}
		return phrase;
	}

	public User getCurrentUser() throws SystemException, PortalException {
		return UserLocalServiceUtil.getUser(PrincipalThreadLocal.getUserId());
	}

	public long getUserOrganizationLogoId() throws SystemException {
		List<Organization> organizations = null;
		try {
			organizations = organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					//// System.out.println("org id:" + org.getOrganizationId() + " name:" +
					//// org.getName());
					return org.getLogoId();
				}
			}
		}
		return 0;
	}

	public long getUserOrganizationId() throws SystemException {
		List<Organization> organizations = null;

		try {
			//// System.out.println("PrincipalThreadLocal.getUserId()" +
			//// PrincipalThreadLocal.getUserId());
			//// System.out.println("organizationLocalService.getUserOrganizations()"
			// +
			//// organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(),
			//// false));

			organizations = organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					return org.getOrganizationId();
				}
			}
		}
		return 0;
	}

	public long getUserOrganizationId(long userId) throws SystemException {
		List<Organization> organizations = null;
		try {
			organizations = organizationLocalService.getUserOrganizations(userId, false);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("organizations.size():" + organizations.size());
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					return org.getOrganizationId();
				}
			}
		}
		return 0;
	}

	public long getUserLocationId() throws SystemException {
		List<Organization> organizations = null;
		try {
			organizations = organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (org.getType().equalsIgnoreCase("Location")) {
					return org.getOrganizationId();
				}
			}
		}
		return 0;
	}

	public Organization getUserOrganization() throws SystemException {
		List<Organization> organizations = null;
		try {
			organizations = organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					return org;
				}
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void setPermissions(long companyId, String className, String role, String columnName, String[] actions)
			throws PortalException, SystemException {
		Role member = roleLocalService.getRole(companyId, role);
		ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(companyId, className,
				ExpandoTableConstants.DEFAULT_TABLE_NAME, columnName);
		resourcePermissionLocalService.setResourcePermissions(companyId, ExpandoColumn.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(column.getColumnId()), member.getRoleId(), actions);
	}

	public AssetVocabulary getVocabularyByUserAssociateOrg()
			throws NoSuchVocabularyException, PortalException, SystemException {
		AssetVocabulary assetVocabulary = null;

		String orgName = getUserOrganizationName();
		// System.out.println("orgName:" + orgName);
		assetVocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(getServiceScopeGroupId(), orgName);

		return assetVocabulary;
	}

	public String getLocale(Locale locale) {

		String locale1 = locale + "";
		String correctlocale = locale1.replace('_', '-');

		return correctlocale;

	}

	public String getRandomColorHexString() {

		return String.format("#%06x", new Random().nextInt(256 * 256 * 256));
	}

	public String ordinal(int i) {
		String[] sufixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
		switch (i % 100) {
		case 11:
		case 12:
		case 13:
			return i + "th";
		default:
			return i + sufixes[i % 10];

		}
	}

	// Created by Jitesh Saxena
	public long getUserOrganizationGroupId() throws SystemException {
		List<Organization> organizations = null;
		try {
			organizations = organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (organizations != null && organizations.size() > 0) {
			for (Organization org : organizations) {
				if (!org.getType().equalsIgnoreCase("Location")) {
					return org.getGroupId();
				}
			}
		}
		return 0;
	}

	public enum STATUS {
		UNAPPROVED(0), APPROVED(1);

		private final int status;

		STATUS(int status) {
			this.status = status;
		}

		public int getStatus() {
			return this.status;
		}

	}

	public int getApprovedStatus() {

		return STATUS.APPROVED.getStatus();
	}

	public int getUnapprovedStatus() {

		return STATUS.UNAPPROVED.getStatus();
	}

	public String getUserOrganizationNameByOrgId(long[] orgId) throws SystemException {
		Organization organization = null;
		try {
			for (int i = 0; i < orgId.length; i++) {
				organization = organizationLocalService.getOrganization(orgId[i]);
				if (organization != null) {
					return organization.getName();
				}
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public String getWorkWorkFlowStatus(int status) {
		String result = null;
		if (WorkflowConstants.STATUS_DRAFT == status) {
			result = "Draft";
		} else if (WorkflowConstants.STATUS_APPROVED == status) {
			result = "Approved";
		} else if (WorkflowConstants.ACTION_PUBLISH == status) {
			result = "Pending";
		} else if (WorkflowConstants.STATUS_DENIED == status) {
			result = "Rejected";
		} else {
			result = "Unknown";
		}
		return result;
	}

	public User getCurrentOrganizationAdminWithPermissionChecker() throws PortalException, SystemException {
		long companyId = CompanyThreadLocal.getCompanyId();

		if (companyId == 0) {
			companyId = getCompanyId();
		}
		Role adminRole = roleLocalService.getRole(companyId, "Administrator");

		List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());

		User currUser = null;
		if (adminUsers != null && !adminUsers.isEmpty()) {
			currUser = adminUsers.get(0);
		}
		PermissionChecker permissionChecker = null;
		try {
			permissionChecker = permissionCheckerFactory.create(currUser);
		} catch (Exception e) {
			// System.out.println("userIduserIduserIdex:" + e.getMessage());
		}
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		return currUser;
	}

	public void getPermissionCheckerAdmin() throws PortalException, SystemException {
		long companyId = CompanyThreadLocal.getCompanyId();

		if (companyId == 0) {
			companyId = getCompanyId();
		}
		Role adminRole = roleLocalService.getRole(companyId, "Administrator");

		List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());

		long userId = 20161;
		if (adminUsers != null && !adminUsers.isEmpty()) {
			userId = adminUsers.get(0).getUserId();
		}
		User user1 = UserLocalServiceUtil.getUser(userId);
		PermissionChecker permissionChecker = null;
		try {
			permissionChecker = permissionCheckerFactory.create(user1);
		} catch (Exception e) {

			// System.out.println("userIduserIduserIdex:" + e.getMessage());
		}
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
	}

	public String getUserOrganizationName() throws SystemException {
		List<Organization> organizations = null;
		List<Organization> filteredOrganizations = new ArrayList<Organization>();
		try {
			organizations = organizationLocalService.getUserOrganizations(PrincipalThreadLocal.getUserId(), false);
		} catch (PortalException e) {

			e.printStackTrace();
		}
		// System.out.println("organizations" + organizations.toString());

		for (Organization org : organizations) {
			if (!org.getType().equalsIgnoreCase("Location")) {
				filteredOrganizations.add(org);
				// System.out.println("organizations:" + org.getName());
			}
		}
		if (filteredOrganizations != null && filteredOrganizations.size() > 0) {
			if (filteredOrganizations.size() == 1) {
				return filteredOrganizations.get(0).getName();
			}
			if (filteredOrganizations.size() > 1) {
				throw new SecurityException("Current User is associated with more than one organization.");
			}

		}
		throw new SecurityException("No organization is associated with current user.");
	}

	public static enum ASSESSMENT_ATTEMPT_STATE {
		ASSESSMENT_DEFAULT(0), ASSESSMENT_SUBMIT(1), ASSESSMENT_ABORT(2), ASSESSMENT_INCOMPLETE(3);

		private final int state;

		ASSESSMENT_ATTEMPT_STATE(int state) {
			this.state = state;
		}

		public int getState() {
			return this.state;
		}

		public static String getStatus(int state) {
			switch (state) {

			case 1:
				// return "Completed";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "completed", "Completed");
			case 2:
				// return "Abort";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "abort", "Abort");
			case 3:
				// return "Incomplete";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "incomplete", "Incomplete");
			default:
				// return "Started";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "started", "Started");

			}
		}

		@Override
		public String toString() {
			switch (this.state) {

			case 1:
				// return "Completed";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "completed", "Completed");
			case 2:
				// return "Abort";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "abort", "Abort");
			case 3:
				// return "Incomplete";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "incomplete", "Incomplete");
			default:
				// return "Default";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "default", "Default");

			}
		}

	}

	public int getAssessmentSubmitState() {

		return ASSESSMENT_ATTEMPT_STATE.ASSESSMENT_SUBMIT.getState();
	}

	public int getAssessmentAbortState() {

		return ASSESSMENT_ATTEMPT_STATE.ASSESSMENT_ABORT.getState();
	}

	public int getAssessmentDefaultState() {

		return ASSESSMENT_ATTEMPT_STATE.ASSESSMENT_DEFAULT.getState();
	}

	public int getAssessmentIncompleteState() {

		return ASSESSMENT_ATTEMPT_STATE.ASSESSMENT_INCOMPLETE.getState();
	}

	public String getAssessmentAttemptState(int status) {

		return ASSESSMENT_ATTEMPT_STATE.getStatus(status);
	}

	public DLFolder createFolder(String folderName) throws PortalException, SystemException {
		DLFolder folder = null;
		Role userRole = null;

		try {

			long companyId = CompanyThreadLocal.getCompanyId();
			long groupId = GroupLocalServiceUtil.getGroup(companyId, "GUEST").getGroupId();
			long guestUserId = UserLocalServiceUtil.getDefaultUser(companyId).getUserId();
			ClassLoader classLoader = getClass().getClassLoader();
			@SuppressWarnings("unchecked")

			List<DLFolder> dlFolders = dlFolderLocalService
					.dynamicQuery(DynamicQueryFactoryUtil.getDynamicQueryFactory().forClass(DLFolder.class, classLoader)
							.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("groupId", groupId),
									RestrictionsFactoryUtil.eq("name", folderName)))
							.add(RestrictionsFactoryUtil.eq("parentFolderId", new Long(0))));
			if (dlFolders == null || dlFolders.size() == 0) {
				folder = dlFolderLocalService.addFolder(guestUserId, groupId, groupId, false, 0, folderName, "", false,
						getServiceContext());

			} else {
				folder = dlFolders.get(0);
			}

			if (userRole == null) {
				userRole = roleLocalService.getRole(CompanyThreadLocal.getCompanyId(), "Document Manager");
			}

			resourcePermissionLocalService.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folder.getFolderId(),
					userRole.getRoleId(), new String[] { "ACCESS", "ADD_DOCUMENT", "ADD_SHORTCUT", "ADD_SUBFOLDER",
							"UPDATE", "VIEW", "PERMISSIONS" });
			userRole = roleLocalService.getRole(CompanyThreadLocal.getCompanyId(), "Student");
			resourcePermissionLocalService.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folder.getFolderId(),
					userRole.getRoleId(), new String[] { "ACCESS", "VIEW" });

		} catch (Exception e) {
			e.printStackTrace();
		}
		return folder;

	}

	public String getFileEntryUrl(DLFileEntry entry) throws SystemException {
		try {

			Role userRole = roleLocalService.getRole(CompanyThreadLocal.getCompanyId(), "Document Manager");
			resourcePermissionLocalService.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + entry.getFileEntryId(),
					userRole.getRoleId(), new String[] { "UPDATE", "VIEW", "PERMISSIONS" });

			userRole = roleLocalService.getRole(CompanyThreadLocal.getCompanyId(), "Student");
			resourcePermissionLocalService.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + entry.getFileEntryId(),
					userRole.getRoleId(), new String[] { "VIEW" });
			return "/documents/" + entry.getGroupId() + "/" + entry.getFolderId() + "/"
					+ HttpUtil.URLtoString(HtmlUtil.unescape(entry.getTitle()));
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

	public List<User> getUserListByRole(String roleArray[]) throws SystemException {
		List<User> users = new ArrayList<User>();
		long companyId = CompanyThreadLocal.getCompanyId();
		if (companyId == 0) {
			companyId = getCompanyId();
		}
		for (String role : roleArray) {
		try {
				Role selectedRole = roleLocalService.getRole(companyId, role);
	
				List<User> userList = UserLocalServiceUtil.getRoleUsers(selectedRole.getRoleId());

				for (User user : userList) {
						for (long orgId : user.getOrganizationIds()) {
							if (orgId == getUserOrganizationId()) {
								users.add(user);
								break;
							}

						}
			
				}
			} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		}
		return users;
	}
	
	

	public void throwException(Exception e) throws SystemException {
		String msg = "";
		if (e != null) {
			msg = e.getMessage();
		}
		throw new SystemException(msg);
	}

	public String getMultilingualTextByPortletKey(String key, String defaultValue) {
		// System.out.println("key:" + key + ":defaultValue:" + defaultValue);
		// System.out.println("theme:" + LocaleThreadLocal.getThemeDisplayLocale());
		// System.out.println("--" +
		// LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), key,
		// defaultValue));
		// System.out.println("----"
		// + HtmlUtil.escape(LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(),
		// key, defaultValue)));
		
		return HtmlUtil.escape(LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), key, defaultValue));
	}

	public String getMultilingualTextByKey(String key, String defaultValue) {
		// System.out.println("key:" + key + ":defaultValue:" + defaultValue);
		// System.out.println("theme:" + LocaleThreadLocal.getThemeDisplayLocale());
		// System.out.println("--" +
		// LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), key,
		// defaultValue));
		// System.out.println("----"
		// + HtmlUtil.escape(LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(),
		// key, defaultValue)));
		return HtmlUtil.escape(LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), key, defaultValue));
	}

	

	public enum LAB_PRACTICE_ANSWER_TYPE {
		UNKNOWN(0), CORRECT(1), INCORRECT(2), UNANSWERED(3);

		private final int answerType;

		LAB_PRACTICE_ANSWER_TYPE(int answerType) {
			this.answerType = answerType;
		}

		public int getAnswerType() {
			return this.answerType;
		}

		public String getStatus(int answerType) {
			switch (answerType) {

			case 1:
				// return "Correct";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "correct", "Correct");

			case 2:
				// return "Incorrect";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "incorrect", "Incorrect");
			case 3:
				// return "Unanswered";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "unanswered", "Unanswered");
			default:
				// return "Unknown";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "unknown", "Unknown");

			}
		}

		@Override
		public String toString() {
			switch (this.answerType) {
			case 1:
				// return "Correct";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "correct", "Correct");

			case 2:
				// return "Incorrect";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "incorrect", "Incorrect");
			case 3:
				// return "Unanswered";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "unanswered", "Unanswered");
			default:
				// return "Unknown";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "unknown", "Unknown");

			}
		}

	}

	public int getLabPracticeAnsTypeUnknownStatus() {

		return LAB_PRACTICE_ANSWER_TYPE.UNKNOWN.getAnswerType();

	}

	public int getLabPracticeAnsTypeCorrectStatus() {

		return LAB_PRACTICE_ANSWER_TYPE.CORRECT.getAnswerType();

	}

	public int getLabPracticeAnsTypeIncorrectStatus() {

		return LAB_PRACTICE_ANSWER_TYPE.INCORRECT.getAnswerType();

	}

	public int getLabPracticeAnsTypeUnanswredStatus() {

		return LAB_PRACTICE_ANSWER_TYPE.UNANSWERED.getAnswerType();

	}

	public void printLog(String str) {
		// System.out.println(str);
	}

	public enum LAB_PRACTICE_STATUS {
		STARTED(0), PROGRESS(1), COMPLETED(2), INCOMPLETE(3), CANCEL(4), ERROR(5);

		private final int state;

		LAB_PRACTICE_STATUS(int state) {
			this.state = state;
		}

		public int getState() {
			return this.state;
		}

		public String getStatus(int state) {
			switch (state) {

			case 1:
				// return "Progress";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "progress", "Progress");
			case 2:
				// return "Completed";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "completed", "Completed");
			case 3:
				// return "Incomplete";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "incomplete", "Incomplete");
			case 4:
				// return "Cancel";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "cancel", "Cancel");
			case 5:
				// return "Error";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "error", "Error");
			default:
				// return "started";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "started", "Started");

			}
		}

		@Override
		public String toString() {
			switch (this.state) {
			case 1:
				// return "Progress";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "progress", "Progress");
			case 2:
				// return "Completed";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "completed", "Completed");
			case 3:
				// return "Incomplete";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "incomplete", "Incomplete");
			case 4:
				// return "Cancel";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "cancel", "Cancel");
			case 5:
				// return "Error";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "error", "Error");
			default:
				// return "started";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "started", "Started");

			}
		}

	}

	public int getLabPracticeStartedStatus() {

		return LAB_PRACTICE_STATUS.STARTED.getState();

	}

	public int getLabPracticeStartedPrgress() {

		return LAB_PRACTICE_STATUS.PROGRESS.getState();

	}

	public int getLabPracticeCompletedStatus() {

		return LAB_PRACTICE_STATUS.COMPLETED.getState();

	}

	public int getLabPracticeCancelStatus() {

		return LAB_PRACTICE_STATUS.CANCEL.getState();

	}

	public int getLabPracticeErrorStatus() {

		return LAB_PRACTICE_STATUS.ERROR.getState();

	}

	public int getLabPracticeIncompleteStatus() {

		return LAB_PRACTICE_STATUS.INCOMPLETE.getState();

	}

	private Folder createFolder(long userId, long groupId, long parentFolderId, String folderName,
			ServiceContext context) {

		Folder folder = null;
		Role userRole = null;
		try {
			User user = UserLocalServiceUtil.fetchUser(userId);

			// printLog("Repository ID = " + getServiceScopeGroupId());
			try {
				folder = dlAppLocalService.getFolder(getServiceScopeGroupId(), parentFolderId, folderName);
			} catch (Exception ex) {
				ex.printStackTrace();

			}
			if (folder == null) {
				folder = dlAppLocalService.addFolder(user.getUserId(), getServiceScopeGroupId(), parentFolderId,
						folderName, folderName + " description", context);

			}

			if (userRole == null) {
				userRole = roleLocalService.getRole(CompanyThreadLocal.getCompanyId(), "Document Manager");
			}

			resourcePermissionLocalService.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folder.getFolderId(),
					userRole.getRoleId(), new String[] { "ACCESS", "ADD_DOCUMENT", "ADD_SHORTCUT", "ADD_SUBFOLDER",
							"UPDATE", "VIEW", "PERMISSIONS" });
			userRole = roleLocalService.getRole(CompanyThreadLocal.getCompanyId(), "Student");
			resourcePermissionLocalService.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folder.getFolderId(),
					userRole.getRoleId(), new String[] { "ACCESS", "VIEW", "ADD_DOCUMENT" });
		} catch (PortalException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return folder;

	}

	public String getFileUrl(File file, String folderName, ServiceContext serviceContext, String uniqueName,
			String defaultUrl) throws PortalException, SystemException {

		// printLog("File Name = " + file.getName());
		if (file == null || !file.exists() || !file.isFile() || file.getName().endsWith(".")
				|| file.getName().endsWith(".tmp")) {
			return defaultUrl;
		}

		User currUser = getCurrentUser();

		Folder folder = createFolder(currUser.getUserId(), getServiceScopeGroupId(), 0, folderName,
				ServiceContextThreadLocal.getServiceContext());

		// printLog("Folder = " + folder);

		String imageName = uniqueName + "-" + file.getName();
		try {
			FileEntry entry = dlAppLocalService.addFileEntry(currUser.getUserId(), getServiceScopeGroupId(),
					folder.getFolderId(), imageName, MimeTypesUtil.getContentType(imageName), imageName, "", "", file,
					serviceContext);
			Role userRole = roleLocalService.getRole(CompanyThreadLocal.getCompanyId(), "Document Manager");
			resourcePermissionLocalService.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + entry.getFileEntryId(),
					userRole.getRoleId(), new String[] { "UPDATE", "VIEW", "PERMISSIONS" });
			userRole = roleLocalService.getRole(CompanyThreadLocal.getCompanyId(), "Student");
			resourcePermissionLocalService.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + entry.getFileEntryId(),
					userRole.getRoleId(), new String[] { "VIEW" });

			return "/documents/" + entry.getGroupId() + "/" + folder.getFolderId() + "/" + entry.getTitle() + "/"
					+ entry.getUuid() + "/" + entry.getFileEntryId();
		} catch (Exception ex) {
			ex.printStackTrace();
			return defaultUrl;
		}

	}

	public HashSet<Integer> getDuplicateKeys(HashMap<Integer, String> optionMap) {
		// System.out.println("optionMap size\t" + optionMap.size());
		HashSet<Integer> duplicateKeys = new HashSet<Integer>();
		for (Object key1 : optionMap.keySet()) {
			// System.out.println("Key1\t" + key1);
			for (Object key2 : optionMap.keySet()) {
				if (!key1.toString().equals(key2.toString())) {
					String x = optionMap.get(key1);
					String y = optionMap.get(key2);
					if (x.equalsIgnoreCase(y)) {
						// System.out.println("Duplicate Data Key for option\t" + key2);
						duplicateKeys.add(Integer.parseInt(key2.toString()));

					}
				}

			}
		}
		return duplicateKeys;
	}

	public HashSet<Integer> getColRWList(HashMap<Integer, String> optionMap) {
		HashSet<Integer> duplicateRW = new HashSet<Integer>();
		for (Object key : optionMap.keySet()) {
			String val = optionMap.get(key);

			if (!val.equalsIgnoreCase("R") && !val.equalsIgnoreCase("W")) {
				duplicateRW.add(Integer.parseInt(key.toString()));
			}

		}
		return duplicateRW;
	}

	public int getTotalRightOption(ArrayList<String> list) {
		int tot = 0;
		for (String key : list) {
			if (key.equalsIgnoreCase("R")) {
				tot++;
			}

		}
		return tot;
	}

	public String UTCtoIST(Date date) {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdfDate.setTimeZone(TimeZone.getTimeZone("IST"));
		String strDate = sdfDate.format(date);
		return strDate;
	}

	public String ISTtoUTC(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		// Will print in UTC
		return sdf.format(date);
	}

	public enum EXERCISE_TYPE {
		LABS(0), SECURITY_CHALLENGE(1), DYNAMIC_EXERCISES(2);

		private final int type;

		EXERCISE_TYPE(int type) {
			this.type = type;
		}

		public int getType() {
			return this.type;
		}

		public String getType(int type) {
			switch (type) {
			case 1:
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "labs", "Labs");
			case 2:
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "security_challenge",
						"Security Challenge");
			default:
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "dynamic_exercises",
						"Dynamic Exercises");
			}
		}

		@Override
		public String toString() {
			switch (this.type) {
			case 1:
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "labs", "Labs");
			case 2:
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "security_challenge",
						"Security Challenge");
			default:
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "dynamic_exercises",
						"Dynamic Exercises");
			}
		}
	}

	public int getExerciseTypeLabType() {

		return EXERCISE_TYPE.LABS.getType();
	}

	public int getExerciseTypeSecurityChangesType() {

		return EXERCISE_TYPE.SECURITY_CHALLENGE.getType();
	}

	public int getExerciseTypeDynamicExcType() {

		return EXERCISE_TYPE.DYNAMIC_EXERCISES.getType();
	}

	public AssetVocabulary createVocabularyWithOrgName(String orgName) throws SystemException, PortalException {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(LocaleUtil.getDefault(), orgName);
		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		descriptionMap.put(LocaleUtil.getDefault(), orgName);
		String settings = "";
		String name = titleMap.get(LocaleUtil.getDefault());
		AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.addVocabulary(
				PrincipalThreadLocal.getUserId(), getServiceScopeGroupId(), orgName, titleMap, descriptionMap, settings,
				getServiceContext(true));
		return assetVocabulary;

	}

	public String addTextAsPerLangCode(String multiLingualText, String columnName, String modelName, long recordId,
			String localeCode) throws PortalException, SystemException {
		String defaultLangCode = translationLocalService.getDefault();
		String defaultLangText = "";

		try {
			if (localeCode.trim().equals(defaultLangCode)) {
				defaultLangText = multiLingualText;

			}
			Translation translation = translationPersistence
					.create(counterLocalService.increment(Translation.class.getClass().getName()));

			translation.setCreateDate(new Date());
			translation.setUserName(getCurrentUser().getFullName());
			translation.setModifiedDate(new Date());
			translation.setModifiedBy(PrincipalThreadLocal.getUserId());
			translation.setModifiedByName(getCurrentUser().getFullName());
			translation.setUserId(PrincipalThreadLocal.getUserId());
			translation.setUuid(PortalUUIDUtil.generate());
			translation.setGroupId(getUserOrganizationId());
			translation.setLanguageCode(localeCode.trim());
			translation.setText(multiLingualText);
			translation.setColumnName(columnName);
			translation.setModelName(modelName);
			translation.setRecordId(recordId);
			// System.out.println("translation----------Data" + translation);
			translationPersistence.update(translation);
		} catch (Exception e) {
			// //System.out.println("createTranslationFromJson");
			throwException(e);
		}
		return defaultLangText;
	}

	public void deleteModelRecordMultilingualText(String modelName, long recordId)
			throws PortalException, SystemException {
		// CommonUtilServiceLocalServiceImpl CommonUtilServiceLocalServiceImpl=new
		// CommonUtilServiceLocalServiceImpl();
		List<Translation> translationList = translationPersistence.findByGroupModelNameRecordId(getUserOrganizationId(),
				false, modelName, recordId);
		for (Translation translation : translationList) {
			try {
				translation.setDeleted(true);
				translationPersistence.update(translation);
			} catch (Exception e) {
				// System.out.println("createTranslationFromJson");
				throwException(e);
			}
		}
	}

	public boolean sendStudentExpiryMail(String toAddress, String subject, Map variables) throws Exception {
		try {
			String emailTemplate = ContentUtil.get(CommonUtilServiceLocalServiceImpl.class.getClassLoader(),
					"/content/student_license_expire_email.tmpl");
			String mailBody = evaluateVelocityTemplate(emailTemplate, variables);
			// String senderMailAddress = CommonUtilServiceLocalServiceImpl.getSenderMail();
			// //System.out.println(mailBody);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(mailBody);
			mailMessage.setSubject(subject);
			mailMessage.setHTMLFormat(true);
			// mailMessage.setFrom(new InternetAddress(senderMailAddress, "Portal System"));
			mailMessage.setTo(new InternetAddress(toAddress));
			MailServiceUtil.sendEmail(mailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public enum IMPORT_EXPORT_STATUS {
		QUEUE(0), STARTED(1), COMPLETED(2), INCOMPLETE(3), CANCEL(4), ERROR(5);

		private final int state;

		IMPORT_EXPORT_STATUS(int state) {
			this.state = state;
		}

		public int getState() {
			return this.state;
		}

		public String getStatus(int state) {
			switch (state) {

			case 1:
				// return "Started";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "started", "Started");
			case 2:
				// return "Completed";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "completed", "Completed");
			case 3:
				// return "Incomplete";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "incomplete", "Incomplete");
			case 4:
				// return "Cancel";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "cancel", "Cancel");
			case 5:
				// return "Error";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "error", "Error");
			default:
				// return "Queue";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "queue", "Queue");

			}
		}

		@Override
		public String toString() {
			switch (this.state) {
			case 1:
				// return "Started";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "started", "Started");
			case 2:
				// return "Completed";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "completed", "Completed");
			case 3:
				// return "Incomplete";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "incomplete", "Incomplete");
			case 4:
				// return "Cancel";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "cancel", "Cancel");
			case 5:
				// return "Error";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "error", "Error");
			default:
				// return "Queue";
				return LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "queue", "Queue");

			}
		}

	}

	
	public String getImportExportStatus(int state) {
		    if(IMPORT_EXPORT_STATUS.STARTED.getState() == state) {
			      return IMPORT_EXPORT_STATUS.STARTED.toString();
			}else if(IMPORT_EXPORT_STATUS.COMPLETED.getState() == state){
			      return IMPORT_EXPORT_STATUS.COMPLETED.toString();
			}else if(IMPORT_EXPORT_STATUS.QUEUE.getState() == state) {
			      return IMPORT_EXPORT_STATUS.QUEUE.toString();
			}else if(IMPORT_EXPORT_STATUS.ERROR.getState() == state){	    	  
				  return IMPORT_EXPORT_STATUS.ERROR.toString();
			}else{
				  return IMPORT_EXPORT_STATUS.CANCEL.toString();
		    }
	}

	public int getImportExportStartedStatus() {

		return IMPORT_EXPORT_STATUS.STARTED.getState();
	}

	public int getImportExportCompletedStatus() {

		return IMPORT_EXPORT_STATUS.COMPLETED.getState();
	}

	public int getImportExportQueueStatus() {

		return IMPORT_EXPORT_STATUS.QUEUE.getState();
	}

	public int getImportExportErrorStatus() {

		return IMPORT_EXPORT_STATUS.ERROR.getState();
	}

	public int getImportExportCancelStatus() {

		return IMPORT_EXPORT_STATUS.CANCEL.getState();
	}

	public static int totalRowcount(HSSFSheet sheet) {
		HSSFRow row;
		HSSFCell cell;

		long rows = 0l; // No of rows
		int cols = 0;
		int tot = 0;
		rows = sheet.getPhysicalNumberOfRows();
		for (int j = 0; j < rows; j++) {
			row = sheet.getRow(j);
			if (row != null) {
				cols = row.getPhysicalNumberOfCells();
				for (int c = 0; c <= cols; c++) {
					cell = row.getCell((short) c);
					if (cell != null) {
						if (row.getCell(c).getCellTypeEnum() == CellType.NUMERIC) {
							// if (cell.getCellTypeEnum() != CellType.BLANK) {
							// if (cell.getNumericCellValue() != Cell.CELL_TYPE_BLANK) {
							// System.out.println("Row Number\t" + j);
							break;
						}
					}
				}
			}
		}
		return tot;
	}

	public String assessmentHistoryListTextAsPerLangCodeRecordId(String columnName, String modelName, long recordId,
			String localeCode) throws PortalException, SystemException {
		Translation translation = null;

		try {
			translation = translationPersistence.findByAssessmentHistoryUseOnly(getUserOrganizationId(), modelName,
					columnName, localeCode, recordId);

		} catch (NoSuchTranslationException e) {
			String defaultLangCode = translationLocalService.getDefault();

			translation = translationPersistence.findByAssessmentHistoryUseOnly(getUserOrganizationId(), modelName,
					columnName, defaultLangCode, recordId);

		}
		return translation.getText();
	}

	public String listTextAsPerLangCodeRecordIdAssessment(String columnName, String modelName, long recordId,
			String localeCode) throws PortalException, SystemException, NoSuchTranslationException {

		Translation translation = translationPersistence.findByGroupModelNameColumnNameLangCodeRecordId(
				getUserOrganizationId(), false, modelName, columnName, localeCode, recordId);
		return translation.getText();
	}

	public long FileUpload(ServiceContext serviceContext, File file, long parentFolderId, long folderId,
			String folderName, String fieldName, long maxFileSize, String newFileName) {
		String fileName = file.getName();
		InputStream is = null;
		String fileExtension = FileUtil.getExtension(file.getName());
		String title = folderName + "_" + System.currentTimeMillis() + "." + fileExtension;
		fileName = title;
		if (file.length() <= maxFileSize) {
			try {
				Folder folder = getFolder(serviceContext, parentFolderId, folderName);
				is = new FileInputStream(file);
				// get list of files in the folder
				List<FileEntry> fileEntrys = null;
				fileEntrys = DLAppServiceUtil.getFileEntries(serviceContext.getScopeGroupId(), folderId);
				/* Checking if new uploaded file already exist in folder */
				FileEntry fileEntry = isFileExist(serviceContext, folderId, title);
				if (Validator.isNull(fileEntry)) {

					fileEntry = DLAppServiceUtil.addFileEntry(title, serviceContext.getScopeGroupId(), folder.getFolderId(),
							fileName, MimeTypesUtil.getContentType(file.getName()), title, null, "", title, is, file.length(),
							null, null, serviceContext);
					// System.out.println("fileEntry---190--------" + fileEntry.getCompanyId());

					Role guestRole = RoleLocalServiceUtil.getRole(fileEntry.getCompanyId(), RoleConstants.GUEST);
					ResourcePermissionServiceUtil.setIndividualResourcePermissions(fileEntry.getGroupId(),
							fileEntry.getCompanyId(), DLFileEntry.class.getName(),
							String.valueOf(fileEntry.getFileEntryId()), guestRole.getRoleId(), new String[] { "VIEW" });
					// System.out.println("fileEntry.getGroupId()---195--------" +
					// fileEntry.getGroupId());
					// Delete all old files from the folder
					if (Validator.isNotNull(fileEntrys)) {
						for (FileEntry fileDetails : fileEntrys) {
							DLAppServiceUtil.deleteFileEntry(fileDetails.getFileEntryId());
						}
					}
					is.close();
					// System.out.println("fileEntry.getFileEntryId()==205======" +
					// fileEntry.getFileEntryId());
					return fileEntry.getFileEntryId();
				} else {
					is.close();
					return 0;
				}

			} catch (Exception e) {
				e.printStackTrace();
				if (is != null) {
					try {
						is.close();
					} catch (IOException e1) {
					}
				}
			}
		} else {
			return 0;
		}

		return 0;

	}

	/**
	 * This method is used to create a Folder
	 * 
	 * @param ServiceContext : holds Object of ServiceContext and provides scope
	 *                       group id in long value
	 * @param parentFolderId : holds the long value for parent Folder ID of the
	 *                       child folder
	 * @param folderName     : holds the string value for Folder Name of the folder
	 * @return Folder : holds the details of particular created folder with the
	 *         folderName value
	 */
	public Folder createFolder(ServiceContext serviceContext, User user, long parentFolderId, String folderName,
			String fileType) {
		Folder folder = isFolderExist(serviceContext, parentFolderId, folderName);
		if (Validator.isNull(folder)) {
			try {
				long repositoryId = serviceContext.getScopeGroupId();
				folder = DLAppServiceUtil.addFolder(repositoryId, parentFolderId, folderName, folderName,
						serviceContext);
				Map<Long, String[]> roleIdsToActionIds = new HashMap<Long, String[]>();
				if (fileType == FileConstants.FILE_TYPE_ASSIGNMENT) {
					Role lmsStudentRole = RoleLocalServiceUtil.getRole(folder.getCompanyId(),
							com.armantec.lms.constants.RoleConstants.LMS_STUDENT);
					roleIdsToActionIds.put(lmsStudentRole.getRoleId(),
							new String[] { ActionKeys.VIEW, ActionKeys.ACCESS, ActionKeys.ADD_SUBFOLDER });
				} else if (fileType == FileConstants.FILE_TYPE_SUMISSION || fileType == FileConstants.FILE_TYPE_INCIDENT) {
					Role lmsStudentRole = RoleLocalServiceUtil.getRole(folder.getCompanyId(),
							com.armantec.lms.constants.RoleConstants.LMS_STUDENT);
					roleIdsToActionIds.put(lmsStudentRole.getRoleId(), new String[] { ActionKeys.VIEW,
							ActionKeys.UPDATE, ActionKeys.ADD_SUBFOLDER, ActionKeys.DELETE, ActionKeys.ACCESS,ActionKeys.ADD_DOCUMENT });

				}
				ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
						DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folder.getFolderId(),
						roleIdsToActionIds);
				Role documentManager = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(),
						com.armantec.lms.constants.RoleConstants.LMS_DOCUMENT_MANAGER);
				ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
						DLFolder.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, "" + folder.getFolderId(),
						documentManager.getRoleId(),
						new String[] { ActionKeys.ACCESS, ActionKeys.ADD_DOCUMENT, ActionKeys.ADD_SHORTCUT,
								ActionKeys.ADD_SUBFOLDER, ActionKeys.DELETE, ActionKeys.UPDATE, ActionKeys.VIEW,
								ActionKeys.PERMISSIONS });

			} catch (PortalException e) {
			}
		}
		return folder;
	}

	public Folder isFolderExist(ServiceContext serviceContext, long parentFolderId, String folderName) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName);
		} catch (Exception e) {
			return null;
		}
		return folder;
	}

	public Folder getFolder(ServiceContext serviceContext, long parentFolderId, String folderName) {
		Folder folder = null;
		try {
			folder = DLAppServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName);
		} catch (Exception e) {
			// System.out.println("catch 281" + e.getMessage());
		}
		return folder;
	}

	public FileEntry isFileExist(ServiceContext serviceContext, long parentFolderId, String title) {
		FileEntry fileEntry = null;
		try {
			fileEntry = DLAppServiceUtil.getFileEntry(serviceContext.getScopeGroupId(), parentFolderId, title);
		} catch (Exception e) {
			// System.out.println("catch 291" + e.getMessage());
			return null;
		}
		return fileEntry;
	}

	public void createDirectory(long companyId, String folderPath) {

		String rootPath = System.getProperty("catalina.home");
		// System.out.println("rootPath-55-:" + rootPath + File.separator + "lms-data" +
		// File.separator + folderPath);
		File directory = new File(rootPath + File.separator + "lms-data" + File.separator + folderPath);
		if (!directory.exists()) {
			try {
				FileUtils.forceMkdir(directory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// System.out.println("Files.exists--(path:" + directory.exists());
	}

	public String copyFile(File srcFile, String folderPath, String fileName, long companyId) {
		String rootPath = System.getProperty("catalina.home");

		String path = rootPath + File.separator + "lms-data" + File.separator + folderPath + File.separator + fileName;
		// System.out.println("rootPath:" + path);
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "/lms-data/" + folderPath + File.separator + fileName;
		url = url.replace(File.separator, "/");
		// System.out.println("url:" + url);
		return url;
	}

	public File getFile(String url, long companyId) {
		String path = url.replace("/", File.separator);
		// System.out.println("getFile:" + path);
		String rootPath = com.liferay.portal.util.PropsUtil.get("lms-data");
		path = rootPath + path;
		// System.out.println("rootPath:" + path);
		return new File(path);
	}

	public boolean getLMSAuth(long candidateId) {
		/*
		 * try { candidateLocalService.convertCandidateToStudent(candidateId); } catch
		 * (NoSuchCandidateException | SystemException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); return false; }
		 */
		return true;
	}

	public String getUsageFile(long scopeGroupId, String usage) {

		
		if (Validator.isNotNull(usage)) {
			AssetTag assetTag = AssetTagLocalServiceUtil.fetchTag(scopeGroupId, usage);
		

			if (Validator.isNotNull(assetTag)) {
				List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil
						.getAssetTagAssetEntries(assetTag.getTagId());
				if (Validator.isNotNull(assetEntryList) && !assetEntryList.isEmpty()) {
					AssetEntry assetEntry = assetEntryList.get(0);
					if (Validator.isNotNull(assetEntry)) {
						DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(assetEntry.getClassPK());
						return getDLFileEntryURL(dlFileEntry);
					}
				}

			}
		}

		return "#";
	}

	public File getUsageFileV2(long scopeGroupId, String usage) throws PortalException, IOException {

		if (Validator.isNotNull(usage)) {
			AssetTag assetTag = AssetTagLocalServiceUtil.fetchTag(scopeGroupId, usage);
			if (Validator.isNotNull(assetTag)) {
				List<AssetEntry> assetEntryList = AssetEntryLocalServiceUtil
						.getAssetTagAssetEntries(assetTag.getTagId());
				if (Validator.isNotNull(assetEntryList) && !assetEntryList.isEmpty()) {
					AssetEntry assetEntry = assetEntryList.get(0);
					if (Validator.isNotNull(assetEntry)) {
						DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.fetchDLFileEntry(assetEntry.getClassPK());
						 File file =new File("data");
						 FileUtils.copyInputStreamToFile(DLFileEntryLocalServiceUtil.getFileAsStream(dlFileEntry.getFileEntryId(),
									dlFileEntry.getVersion(), false), file);
							return file	;
					}
				}

			}
		}

		return null;
	}

	public String getDLFileEntryURL(DLFileEntry entry) {
		if (Validator.isNotNull(entry)) {
			try {
				return "/documents/" + entry.getGroupId() + "/" + entry.getFolderId() + "/"
						+ HttpUtil.URLtoString(HtmlUtil.unescape(entry.getTitle()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return StringPool.BLANK;
	}

	public boolean sendAccountActivationMail(String toAddress, String subject, Map variables, String senderMailAddress,
			String senderName) throws Exception {

		try {
			String emailTemplate = ContentUtil.get(CommonUtilServiceLocalServiceImpl.class.getClassLoader(),
					  "/content/user_account_activation_email.tmpl");
			String mailBody = evaluateVelocityTemplate(emailTemplate, variables);
			// System.out.println("mailBody:["+mailBody+"]");
			// String senderMailAddress = CommonUtilServiceLocalServiceImpl.getSenderMail();
			// //System.out.println(mailBody);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(mailBody);
			System.out.println("subject:" + subject);
			mailMessage.setSubject(subject);
			mailMessage.setHTMLFormat(true);
			mailMessage.setFrom(new InternetAddress(senderMailAddress, senderName));
			mailMessage.setTo(new InternetAddress(toAddress));
			MailServiceUtil.sendEmail(mailMessage);

			// send("sonam.tsering001@gmail.com","123",toAddress,subject,mailBody,"465","smtp.gmail.com");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean send(String from, String password, String to, String sub, String msg, String port, String smtpHost) { // Get
																															// properties
																															// object
		// System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHH 11111111111111");
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHH333333333333");
		try {
			MimeMessage message = new MimeMessage(session);

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHH44444444444"); //send
			// message
			Transport.send(message);
			System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHH55555555");
			System.out.println("message sent successfully");
			System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHH6666666666");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return false;
	}

	public boolean sendMail(String toAddress, String subject, Map variables, String senderMailAddress,
			String senderName, String mailTemplate) throws Exception {

		try {
			String emailTemplate = ContentUtil.get(CommonUtilServiceLocalServiceImpl.class.getClassLoader(),
					"/content/" + mailTemplate);
			String mailBody = evaluateVelocityTemplate(emailTemplate, variables);
			// System.out.println("mailBody:["+mailBody+"]");
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(mailBody);
			mailMessage.setSubject(subject);
			mailMessage.setHTMLFormat(true);
			mailMessage.setFrom(new InternetAddress(senderMailAddress, senderName));
			mailMessage.setTo(new InternetAddress(toAddress));
			MailServiceUtil.sendEmail(mailMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public String getExternalCode() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 20;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}

	public long documentUpload(ServiceContext serviceContext, long parentFolderId, long folderId, File file,
			String fileName, long maxFileSize, Boolean deleteAllFiles, String fileType) {
		fileName = fileName + "-" + System.currentTimeMillis();
		InputStream is = null;
		if (maxFileSize == 0) {
			maxFileSize = file.length();
		}
		if (file.length() <= maxFileSize) {
			try {
				Folder folder = DLAppServiceUtil.getFolder(folderId);
				is = new FileInputStream(file);

				// get list of files in the folder
				List<FileEntry> fileEntrys = null;
				if (deleteAllFiles) {
					fileEntrys = DLAppServiceUtil.getFileEntries(serviceContext.getScopeGroupId(), folderId);
				}
				
				System.out.println("file name before="+fileName);

				/* Checking if new uploaded file already exist in folder */
				String fileExtension = FileUtil.getExtension(file.getName());
				System.out.println(fileExtension);
				fileExtension = FilenameUtils.getExtension(file.getName());
				System.out.println(fileExtension);
				fileName = fileName + "." + fileExtension;
				System.out.println("file name with generated extension="+fileName);
				FileEntry fileEntry = isFileExist(serviceContext, folderId, fileName);
				
				
				if (Validator.isNull(fileEntry)) {
					//System.out.println("line____________________1992"+ fileEntry);
					fileEntry = DLAppServiceUtil.addFileEntry(getExternalCode(), serviceContext.getScopeGroupId(), folder.getFolderId(),
							fileName, MimeTypesUtil.getContentType(file), fileName, null, "", fileExtension, is, file.length(),
							new Date(), null, serviceContext);
				
					
				//	System.out.println("line____________________1997"+ fileEntry);
					
					
					Map<Long, String[]> roleIdsToActionIds = new HashMap<Long, String[]>();
					if (fileType == FileConstants.FILE_TYPE_ASSIGNMENT) {
						Role lmsStudentRole = RoleLocalServiceUtil.getRole(folder.getCompanyId(),
								com.armantec.lms.constants.RoleConstants.LMS_STUDENT);
						roleIdsToActionIds.put(lmsStudentRole.getRoleId(), new String[] { ActionKeys.VIEW });
					} else if (fileType == FileConstants.FILE_TYPE_SUMISSION || fileType == FileConstants.FILE_TYPE_INCIDENT) {
						Role lmsStudentRole = RoleLocalServiceUtil.getRole(folder.getCompanyId(),
								com.armantec.lms.constants.RoleConstants.LMS_STUDENT);
						roleIdsToActionIds.put(lmsStudentRole.getRoleId(),
								new String[] { ActionKeys.VIEW, ActionKeys.UPDATE, ActionKeys.DELETE });

					}
					ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
							DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
							"" + fileEntry.getFileEntryId(), roleIdsToActionIds);

					Role documentManager = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(),
							com.armantec.lms.constants.RoleConstants.LMS_DOCUMENT_MANAGER);
					ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(),
							DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
							"" + fileEntry.getFileEntryId(), documentManager.getRoleId(), new String[] {
									ActionKeys.DELETE, ActionKeys.UPDATE, ActionKeys.VIEW, ActionKeys.PERMISSIONS });
					System.out.println("file uploaded..." + fileName);

					// Delete all old files from the folder

					if (Validator.isNotNull(fileEntrys)) {
						for (FileEntry fileDetails : fileEntrys) {
							System.out.println("Deleting old files from folder.... " + fileDetails.getTitle());
							DLAppServiceUtil.deleteFileEntry(fileDetails.getFileEntryId());
						}
					}

					is.close();
					return fileEntry.getFileEntryId();
				} else {
					System.out.println("File already available in folder with same name...");
					is.close();
					throw new SystemException(LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(),
							"File already available in folder with same name..."));
				}

			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				if (is != null) {
					try {
						is.close();
					} catch (IOException e1) {
						System.out.println(e1);
					}
				}
				throw new SystemException(
						LanguageUtil.get(LocaleThreadLocal.getThemeDisplayLocale(), "fileUploadError"));
			}
		} else {
			System.out.println("unable to upload file, size is greater than ..." + maxFileSize);
			throw new SystemException(LanguageUtil.format(LocaleThreadLocal.getThemeDisplayLocale(),
					"unable to upload file, size is greater than ...", maxFileSize));
		}
	}

	public User setPermissonCheckerByUserId(long userId) {
		long companyId = CompanyThreadLocal.getCompanyId();
		if (companyId == 0) {
			companyId = getCompanyId();
		}
		User currUser = null;
		try {
			currUser = UserLocalServiceUtil.getUser(userId);

			PermissionChecker permissionChecker = null;
			try {
				permissionChecker = permissionCheckerFactory.create(currUser);
			} catch (Exception e) {
				// System.out.println("userIduserIduserIdex:" + e.getMessage());
			}
			PermissionThreadLocal.setPermissionChecker(permissionChecker);
			return currUser;
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public List<User> getUserListByRole(String roleArray[],String invalidUserRole) throws SystemException {
		List<User> users = new ArrayList<User>();
		long companyId = CompanyThreadLocal.getCompanyId();
		if (companyId == 0) {
			companyId = getCompanyId();
		}
		for (String role : roleArray) {
		try {
				Role selectedRole = roleLocalService.getRole(companyId, role);
	
				List<User> userList = UserLocalServiceUtil.getRoleUsers(selectedRole.getRoleId());
                if(invalidUserRole == null) {
				for (User user : userList) {
						for (long orgId : user.getOrganizationIds()) {
							if (orgId == getUserOrganizationId()) {
								users.add(user);
								break;
							}

						}
			
				}
               } else {
            	   for (User user : userList) {
            		   if (!hasRole(user, invalidUserRole)) {
						for (long orgId : user.getOrganizationIds()) {
							if (orgId == getUserOrganizationId()) {
								users.add(user);
								break;
							}

						}
            		 }
				}   
               }
			} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		}
		return users;
	}
	
	public List<User> setPermissonCheckerByRole(String roleName, String invalidUserRole, String[] organizationNames) {
		long companyId = CompanyThreadLocal.getCompanyId();
		if (companyId == 0) {
			companyId = getCompanyId();
		}
		List<User> users = new ArrayList<User>();
		try {
			Role selectedRole;

			selectedRole = roleLocalService.getRole(companyId, roleName);

			if (invalidUserRole == null) {

				List<User> userList = UserLocalServiceUtil.getRoleUsers(selectedRole.getRoleId());

				User currUser = null;
				for (User user : userList) {
					List<Organization> orgList = OrganizationLocalServiceUtil
							.getOrganizations(user.getOrganizationIds());
					for (Organization organization : orgList) {
						System.out.println("organization.getName():" + organization.getName());
						for (String organizationName : organizationNames) {
							if (organization.getName().equalsIgnoreCase(organizationName)) {
								users.add(user);
							}

						}
					}
				}
				PermissionChecker permissionChecker = null;
				try {
					permissionChecker = permissionCheckerFactory.create(currUser);
				} catch (Exception e) {
					// System.out.println("userIduserIduserIdex:" + e.getMessage());
				}
				PermissionThreadLocal.setPermissionChecker(permissionChecker);
			} else {
				List<User> userList = UserLocalServiceUtil.getRoleUsers(selectedRole.getRoleId());

				User currUser = null;
				for (User user : userList) {
					if (!hasRole(user, invalidUserRole)) {
						List<Organization> orgList = OrganizationLocalServiceUtil
								.getOrganizations(user.getOrganizationIds());
						for (Organization organization : orgList) {
							System.out.println("organization.getName():" + organization.getName());
							for (String organizationName : organizationNames) {
								if (organization.getName().equalsIgnoreCase(organizationName)) {
									currUser = user;
									users.add(user);
								}

							}
						}
					}
				}
				PermissionChecker permissionChecker = null;
				try {
					permissionChecker = permissionCheckerFactory.create(currUser);
				} catch (Exception e) {
					// System.out.println("userIduserIduserIdex:" + e.getMessage());
				}
				PermissionThreadLocal.setPermissionChecker(permissionChecker);
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
	public String getPassword() {
		String firstComb = PwdGenerator.getPassword(2,new String[]{"0","1","2","3","4","5","6","7","8","9"});
		String secondComb = PwdGenerator.getPassword(2,new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"});
		String thirdComb = PwdGenerator.getPassword(2,new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});
		String forthComb = PwdGenerator.getPassword(2,new String[]{"!","@","#","$","%","&","*"});
		ArrayList<String> pswdComb = new ArrayList<String>();
		for(String key : firstComb.split(",")) {
			pswdComb.add(key);	
		}
		for(String key : secondComb.split(",")) {
			pswdComb.add(key);	
		}
		for(String key : thirdComb.split(",")) {
			pswdComb.add(key);	
		}
		for(String key : forthComb.split(",")) {
			pswdComb.add(key);	
		}
		Collections.shuffle(pswdComb);
		String pswd = "";
		for(String key : pswdComb) {
			pswd += key;
		}
		return pswd;
	}
	
	

	public   void sendLiferayNotification(String title, String body, long userId, String receiverName, String notificationType, String link) throws SystemException, PortalException{
		JSONObject payload = JSONFactoryUtil.createJSONObject();
		payload.put("userId", userId);
		payload.put("notificationText", body);
		payload.put("title", title);
		payload.put("userName", receiverName);
		
		payload.put("senderName", commonUtilServiceLocalService.getCurrentUser().getFullName());
		
		if(link!=null) {
			payload.put("link", link);
		}else {
			payload.put("link", "/");
		}
		
		UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId, notificationType, (new Date()).getTime(), UserNotificationDeliveryConstants.TYPE_WEBSITE, userId, payload.toString(), false, new ServiceContext());
	}
	

	public boolean sendAccountEmailIdPassMail(String toAddress, String subject, Map variables, String senderMailAddress,
			String senderName) throws Exception {

		try {
			String emailTemplate = ContentUtil.get(CommonUtilServiceLocalServiceImpl.class.getClassLoader(),
					   "/content/user_new_account_email_pass.tmpl");
			String mailBody = evaluateVelocityTemplate(emailTemplate, variables);
			// System.out.println("mailBody:["+mailBody+"]");
			// String senderMailAddress = CommonUtilServiceLocalServiceImpl.getSenderMail();
			//System.out.println("mailBody.."+mailBody);
			//System.out.println("mailBody.."+variables);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setBody(mailBody);
			System.out.println("subject:" + subject);
			mailMessage.setSubject(subject);
			mailMessage.setHTMLFormat(true);
			mailMessage.setFrom(new InternetAddress(senderMailAddress, senderName));
			mailMessage.setTo(new InternetAddress(toAddress));
			MailServiceUtil.sendEmail(mailMessage);

			// send("sonam.tsering001@gmail.com","123",toAddress,subject,mailBody,"465","smtp.gmail.com");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	  public String sendSms(String mobileNo, String message) throws SystemException {
	    return SMSUtil.send(mobileNo, message);
	  }
	  
	  public int randomOtp(int len) {
		    StringBuilder sb = new StringBuilder(len);
		    for (int i = 0; i < len; i++)
		      sb.append("12345678901234567890123456789".charAt(rnd.nextInt("12345678901234567890123456789".length()))); 
		    return Integer.parseInt(sb.toString());
		  }

	
	  
		public String getUserOrganizationNameByUserId(long userId) throws SystemException {
			List<Organization> organizations = null;
			try {
				organizations = organizationLocalService.getUserOrganizations(userId, false);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println("organizations.size():" + organizations.size());
			if (organizations != null && organizations.size() > 0) {
				for (Organization org : organizations) {
					if (!org.getType().equalsIgnoreCase("Location")) {
						return org.getName();
					}
				}
			}
			return "";
		}
	  
	  

		public  JSONObject getJSONObject(Map <String, Object>modelAttributes){
			Iterator<String> iter = modelAttributes.keySet().iterator();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			
			while(iter.hasNext()){
				String key = iter.next();
				Object value = modelAttributes.get(key);
				if(value  == null){
					//jsonObject.put(key, null);
				}else if(value instanceof Date){
					jsonObject.put(key, ((Date)value).getTime());
				}else if(value instanceof Integer){
					jsonObject.put(key, (Integer)value);
				}else if(value instanceof Long){
					jsonObject.put(key, (Long)value);
				}else if(value instanceof Boolean){
					jsonObject.put(key, (Boolean)value);
				}else{
					jsonObject.put(key, String.valueOf(value));
				}
			}
			
			return jsonObject;
		}
		
		
		public  boolean containsIllegals(String toExamine) throws PortalException {
			if(toExamine==null) {
				return false;
			}
			Pattern pattern =Pattern.compile("[-+=@<>]");
			//Pattern pattern = Pattern.compile("[<>+-@=]");
		   // Pattern pattern = Pattern.compile("[<>]");
		    Matcher matcher = pattern.matcher(toExamine.toString());
		    if(matcher.find()) {
		    	System.out.println("Invalid input - " + toExamine);
		    	throw new PortalException("Invalid characters are not allowed.");
		    }
		    
		    return false;
		}

		
	@Reference
	protected com.armantec.lms.common.util.services.service.TranslationLocalService translationLocalService;

	@Reference
	protected com.liferay.document.library.kernel.service.DLAppLocalService dlAppLocalService;

	@Reference
	protected com.liferay.document.library.kernel.service.DLFolderLocalService dlFolderLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.RoleLocalService roleLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.OrganizationLocalService organizationLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourcePermissionLocalService resourcePermissionLocalService;

	@Reference
	protected PermissionCheckerFactory permissionCheckerFactory;

	/*
	 * @Reference protected
	 * com.armantec.lms.assignment.service.AssignmentLocalService
	 * assignmentLocalService;
	 */

}