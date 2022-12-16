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

package com.armantec.lms.common.util.services.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for CommonUtilService. This utility wraps
 * <code>com.armantec.lms.common.util.services.service.impl.CommonUtilServiceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CommonUtilServiceLocalService
 * @generated
 */
public class CommonUtilServiceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.armantec.lms.common.util.services.service.impl.CommonUtilServiceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User addRole(
			com.liferay.portal.kernel.model.User user, String roleName)
		throws PortalException, SystemException {

		return getService().addRole(user, roleName);
	}

	public static String addTextAsPerLangCode(
			String multiLingualText, String columnName, String modelName,
			long recordId, String localeCode)
		throws PortalException, SystemException {

		return getService().addTextAsPerLangCode(
			multiLingualText, columnName, modelName, recordId, localeCode);
	}

	public static String assessmentHistoryListTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws PortalException, SystemException {

		return getService().assessmentHistoryListTextAsPerLangCodeRecordId(
			columnName, modelName, recordId, localeCode);
	}

	public static void assignUserGroup(
			long userId, long companyId, String groupName)
		throws PortalException, SystemException {

		getService().assignUserGroup(userId, companyId, groupName);
	}

	public static boolean containsIllegals(String toExamine)
		throws PortalException {

		return getService().containsIllegals(toExamine);
	}

	public static String copyFile(
		java.io.File srcFile, String folderPath, String fileName,
		long companyId) {

		return getService().copyFile(srcFile, folderPath, fileName, companyId);
	}

	public static void createDirectory(long companyId, String folderPath) {
		getService().createDirectory(companyId, folderPath);
	}

	/**
	 * This method is used to create a Folder
	 *
	 * @param ServiceContext : holds Object of ServiceContext and provides scope
	 group id in long value
	 * @param parentFolderId : holds the long value for parent Folder ID of the
	 child folder
	 * @param folderName     : holds the string value for Folder Name of the folder
	 * @return Folder : holds the details of particular created folder with the
	 folderName value
	 */
	public static com.liferay.portal.kernel.repository.model.Folder
		createFolder(
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			com.liferay.portal.kernel.model.User user, long parentFolderId,
			String folderName, String fileType) {

		return getService().createFolder(
			serviceContext, user, parentFolderId, folderName, fileType);
	}

	public static com.liferay.document.library.kernel.model.DLFolder
			createFolder(String folderName)
		throws PortalException, SystemException {

		return getService().createFolder(folderName);
	}

	public static com.liferay.asset.kernel.model.AssetVocabulary
			createVocabularyWithOrgName(String orgName)
		throws PortalException, SystemException {

		return getService().createVocabularyWithOrgName(orgName);
	}

	public static void deleteModelRecordMultilingualText(
			String modelName, long recordId)
		throws PortalException, SystemException {

		getService().deleteModelRecordMultilingualText(modelName, recordId);
	}

	public static com.liferay.portal.kernel.model.User deleteUserRole(
			com.liferay.portal.kernel.model.User user, String roleName)
		throws PortalException, SystemException {

		return getService().deleteUserRole(user, roleName);
	}

	public static long documentUpload(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long parentFolderId, long folderId, java.io.File file, String fileName,
		long maxFileSize, Boolean deleteAllFiles, String fileType) {

		return getService().documentUpload(
			serviceContext, parentFolderId, folderId, file, fileName,
			maxFileSize, deleteAllFiles, fileType);
	}

	public static String evaluateVelocityTemplate(
		String templateContent, Map variable) {

		return getService().evaluateVelocityTemplate(templateContent, variable);
	}

	public static long FileUpload(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		java.io.File file, long parentFolderId, long folderId,
		String folderName, String fieldName, long maxFileSize,
		String newFileName) {

		return getService().FileUpload(
			serviceContext, file, parentFolderId, folderId, folderName,
			fieldName, maxFileSize, newFileName);
	}

	public static int getApprovedStatus() {
		return getService().getApprovedStatus();
	}

	public static int getAssessmentAbortState() {
		return getService().getAssessmentAbortState();
	}

	public static String getAssessmentAttemptState(int status) {
		return getService().getAssessmentAttemptState(status);
	}

	public static int getAssessmentDefaultState() {
		return getService().getAssessmentDefaultState();
	}

	public static int getAssessmentIncompleteState() {
		return getService().getAssessmentIncompleteState();
	}

	public static int getAssessmentSubmitState() {
		return getService().getAssessmentSubmitState();
	}

	public static java.util.HashSet<Integer> getColRWList(
		java.util.HashMap<Integer, String> optionMap) {

		return getService().getColRWList(optionMap);
	}

	public static long getCompanyId() {
		return getService().getCompanyId();
	}

	public static com.liferay.portal.kernel.model.User
			getCurrentOrganizationAdminWithPermissionChecker()
		throws PortalException, SystemException {

		return getService().getCurrentOrganizationAdminWithPermissionChecker();
	}

	public static com.liferay.portal.kernel.model.User getCurrentUser()
		throws PortalException, SystemException {

		return getService().getCurrentUser();
	}

	public static String getDLFileEntryURL(
		com.liferay.document.library.kernel.model.DLFileEntry entry) {

		return getService().getDLFileEntryURL(entry);
	}

	public static java.util.HashSet<Integer> getDuplicateKeys(
		java.util.HashMap<Integer, String> optionMap) {

		return getService().getDuplicateKeys(optionMap);
	}

	public static int getExerciseTypeDynamicExcType() {
		return getService().getExerciseTypeDynamicExcType();
	}

	public static int getExerciseTypeLabType() {
		return getService().getExerciseTypeLabType();
	}

	public static int getExerciseTypeSecurityChangesType() {
		return getService().getExerciseTypeSecurityChangesType();
	}

	public static String getExternalCode() {
		return getService().getExternalCode();
	}

	public static java.io.File getFile(String url, long companyId) {
		return getService().getFile(url, companyId);
	}

	public static String getFileEntryUrl(
			com.liferay.document.library.kernel.model.DLFileEntry entry)
		throws SystemException {

		return getService().getFileEntryUrl(entry);
	}

	public static String getFileUrl(
			java.io.File file, String folderName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String uniqueName, String defaultUrl)
		throws PortalException, SystemException {

		return getService().getFileUrl(
			file, folderName, serviceContext, uniqueName, defaultUrl);
	}

	public static com.liferay.portal.kernel.repository.model.Folder getFolder(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long parentFolderId, String folderName) {

		return getService().getFolder(
			serviceContext, parentFolderId, folderName);
	}

	public static long getGroupId(String name) {
		return getService().getGroupId(name);
	}

	public static int getImportExportCancelStatus() {
		return getService().getImportExportCancelStatus();
	}

	public static int getImportExportCompletedStatus() {
		return getService().getImportExportCompletedStatus();
	}

	public static int getImportExportErrorStatus() {
		return getService().getImportExportErrorStatus();
	}

	public static int getImportExportQueueStatus() {
		return getService().getImportExportQueueStatus();
	}

	public static int getImportExportStartedStatus() {
		return getService().getImportExportStartedStatus();
	}

	public static String getImportExportStatus(int state) {
		return getService().getImportExportStatus(state);
	}

	public static com.liferay.portal.kernel.json.JSONObject getJSONObject(
		Map<String, Object> modelAttributes) {

		return getService().getJSONObject(modelAttributes);
	}

	public static int getLabPracticeAnsTypeCorrectStatus() {
		return getService().getLabPracticeAnsTypeCorrectStatus();
	}

	public static int getLabPracticeAnsTypeIncorrectStatus() {
		return getService().getLabPracticeAnsTypeIncorrectStatus();
	}

	public static int getLabPracticeAnsTypeUnanswredStatus() {
		return getService().getLabPracticeAnsTypeUnanswredStatus();
	}

	public static int getLabPracticeAnsTypeUnknownStatus() {
		return getService().getLabPracticeAnsTypeUnknownStatus();
	}

	public static int getLabPracticeCancelStatus() {
		return getService().getLabPracticeCancelStatus();
	}

	public static int getLabPracticeCompletedStatus() {
		return getService().getLabPracticeCompletedStatus();
	}

	public static int getLabPracticeErrorStatus() {
		return getService().getLabPracticeErrorStatus();
	}

	public static int getLabPracticeIncompleteStatus() {
		return getService().getLabPracticeIncompleteStatus();
	}

	public static int getLabPracticeStartedPrgress() {
		return getService().getLabPracticeStartedPrgress();
	}

	public static int getLabPracticeStartedStatus() {
		return getService().getLabPracticeStartedStatus();
	}

	public static String getLabStatusError() {
		return getService().getLabStatusError();
	}

	public static String getLabStatusStarted() {
		return getService().getLabStatusStarted();
	}

	public static String getLabStatusStoped() {
		return getService().getLabStatusStoped();
	}

	public static boolean getLMSAuth(long candidateId) {
		return getService().getLMSAuth(candidateId);
	}

	public static String getLocale(java.util.Locale locale) {
		return getService().getLocale(locale);
	}

	public static int getMinut() {
		return getService().getMinut();
	}

	public static String getMultilingualTextByKey(
		String key, String defaultValue) {

		return getService().getMultilingualTextByKey(key, defaultValue);
	}

	public static String getMultilingualTextByPortletKey(
		String key, String defaultValue) {

		return getService().getMultilingualTextByPortletKey(key, defaultValue);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static String getPassword() {
		return getService().getPassword();
	}

	public static void getPermissionCheckerAdmin()
		throws PortalException, SystemException {

		getService().getPermissionCheckerAdmin();
	}

	public static String getRandomColorHexString() {
		return getService().getRandomColorHexString();
	}

	public static String getRandomString(int len) {
		return getService().getRandomString(len);
	}

	public static com.liferay.portal.kernel.service.ServiceContext
		getServiceContext() {

		return getService().getServiceContext();
	}

	public static com.liferay.portal.kernel.service.ServiceContext
		getServiceContext(boolean scopeGroup) {

		return getService().getServiceContext(scopeGroup);
	}

	public static long getServiceScopeGroupId() {
		return getService().getServiceScopeGroupId();
	}

	public static long getServiceScopeGroupIdBySiteName()
		throws PortalException {

		return getService().getServiceScopeGroupIdBySiteName();
	}

	public static int getTotalRightOption(java.util.ArrayList<String> list) {
		return getService().getTotalRightOption(list);
	}

	public static int getUnapprovedStatus() {
		return getService().getUnapprovedStatus();
	}

	public static String getUsageFile(long scopeGroupId, String usage) {
		return getService().getUsageFile(scopeGroupId, usage);
	}

	public static java.io.File getUsageFileV2(long scopeGroupId, String usage)
		throws java.io.IOException, PortalException {

		return getService().getUsageFileV2(scopeGroupId, usage);
	}

	public static long getUserGroupId(long userId, String name) {
		return getService().getUserGroupId(userId, name);
	}

	public static long getUserGroupId(
		long userId, String userGroupName, String defaultUserGroupName) {

		return getService().getUserGroupId(
			userId, userGroupName, defaultUserGroupName);
	}

	public static List<com.liferay.portal.kernel.model.User> getUserListByRole(
			String[] roleArray)
		throws SystemException {

		return getService().getUserListByRole(roleArray);
	}

	public static List<com.liferay.portal.kernel.model.User> getUserListByRole(
			String[] roleArray, String invalidUserRole)
		throws SystemException {

		return getService().getUserListByRole(roleArray, invalidUserRole);
	}

	public static long getUserLocationId() throws SystemException {
		return getService().getUserLocationId();
	}

	public static com.liferay.portal.kernel.model.Organization
			getUserOrganization()
		throws SystemException {

		return getService().getUserOrganization();
	}

	public static long getUserOrganizationGroupId() throws SystemException {
		return getService().getUserOrganizationGroupId();
	}

	public static long getUserOrganizationId() throws SystemException {
		return getService().getUserOrganizationId();
	}

	public static long getUserOrganizationId(long userId)
		throws SystemException {

		return getService().getUserOrganizationId(userId);
	}

	public static long getUserOrganizationLogoId() throws SystemException {
		return getService().getUserOrganizationLogoId();
	}

	public static String getUserOrganizationName() throws SystemException {
		return getService().getUserOrganizationName();
	}

	public static String getUserOrganizationNameByOrgId(long[] orgId)
		throws SystemException {

		return getService().getUserOrganizationNameByOrgId(orgId);
	}

	public static String getUserOrganizationNameByUserId(long userId)
		throws SystemException {

		return getService().getUserOrganizationNameByUserId(userId);
	}

	public static com.liferay.asset.kernel.model.AssetVocabulary
			getVocabularyByUserAssociateOrg()
		throws com.liferay.asset.kernel.exception.NoSuchVocabularyException,
			   PortalException, SystemException {

		return getService().getVocabularyByUserAssociateOrg();
	}

	public static String getWorkWorkFlowStatus(int status) {
		return getService().getWorkWorkFlowStatus(status);
	}

	public static boolean hasAllRoles(
		java.util.ArrayList<String> userRoles, String[] roleNames) {

		return getService().hasAllRoles(userRoles, roleNames);
	}

	public static boolean hasAnyRole(
		java.util.ArrayList<String> userRoles, String[] roleNames) {

		return getService().hasAnyRole(userRoles, roleNames);
	}

	public static boolean hasRole(
		com.liferay.portal.kernel.model.User user, String roleName) {

		return getService().hasRole(user, roleName);
	}

	public static java.util.ArrayList hasRole(
		com.liferay.portal.kernel.model.User user, String[] roleNames) {

		return getService().hasRole(user, roleNames);
	}

	public static boolean hasUserGroup(
		com.liferay.portal.kernel.model.User user, String userGroupName) {

		return getService().hasUserGroup(user, userGroupName);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry
		isFileExist(
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			long parentFolderId, String title) {

		return getService().isFileExist(serviceContext, parentFolderId, title);
	}

	public static com.liferay.portal.kernel.repository.model.Folder
		isFolderExist(
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			long parentFolderId, String folderName) {

		return getService().isFolderExist(
			serviceContext, parentFolderId, folderName);
	}

	public static String ISTtoUTC(java.util.Date date) {
		return getService().ISTtoUTC(date);
	}

	public static String listTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws PortalException, SystemException {

		return getService().listTextAsPerLangCodeRecordId(
			columnName, modelName, recordId, localeCode);
	}

	public static String listTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode, long groupId)
		throws PortalException, SystemException {

		return getService().listTextAsPerLangCodeRecordId(
			columnName, modelName, recordId, localeCode, groupId);
	}

	public static String listTextAsPerLangCodeRecordIdAssessment(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException,
			   PortalException, SystemException {

		return getService().listTextAsPerLangCodeRecordIdAssessment(
			columnName, modelName, recordId, localeCode);
	}

	public static String ordinal(int i) {
		return getService().ordinal(i);
	}

	public static void printLog(String str) {
		getService().printLog(str);
	}

	public static int randomOtp(int len) {
		return getService().randomOtp(len);
	}

	public static boolean send(
		String from, String password, String to, String sub, String msg,
		String port, String smtpHost) {

		return getService().send(from, password, to, sub, msg, port, smtpHost);
	}

	public static boolean sendAccountActivationMail(
			String toAddress, String subject, Map variables,
			String senderMailAddress, String senderName)
		throws Exception {

		return getService().sendAccountActivationMail(
			toAddress, subject, variables, senderMailAddress, senderName);
	}

	public static boolean sendAccountEmailIdPassMail(
			String toAddress, String subject, Map variables,
			String senderMailAddress, String senderName)
		throws Exception {

		return getService().sendAccountEmailIdPassMail(
			toAddress, subject, variables, senderMailAddress, senderName);
	}

	public static void sendLiferayNotification(
			String title, String body, long userId, String receiverName,
			String notificationType, String link)
		throws PortalException, SystemException {

		getService().sendLiferayNotification(
			title, body, userId, receiverName, notificationType, link);
	}

	public static boolean sendMail(
			String toAddress, String subject, Map variables,
			String senderMailAddress, String senderName, String mailTemplate)
		throws Exception {

		return getService().sendMail(
			toAddress, subject, variables, senderMailAddress, senderName,
			mailTemplate);
	}

	public static String sendSms(String mobileNo, String message)
		throws SystemException {

		return getService().sendSms(mobileNo, message);
	}

	public static boolean sendStudentExpiryMail(
			String toAddress, String subject, Map variables)
		throws Exception {

		return getService().sendStudentExpiryMail(
			toAddress, subject, variables);
	}

	public static void setPermissions(
			long companyId, String className, String role, String columnName,
			String[] actions)
		throws PortalException, SystemException {

		getService().setPermissions(
			companyId, className, role, columnName, actions);
	}

	public static List<com.liferay.portal.kernel.model.User>
		setPermissonCheckerByRole(
			String roleName, String invalidUserRole,
			String[] organizationNames) {

		return getService().setPermissonCheckerByRole(
			roleName, invalidUserRole, organizationNames);
	}

	public static com.liferay.portal.kernel.model.User
		setPermissonCheckerByUserId(long userId) {

		return getService().setPermissonCheckerByUserId(userId);
	}

	public static void throwException(Exception e) throws SystemException {
		getService().throwException(e);
	}

	public static String updateTextAsPerLangCode(
			String multiLingualText, String columnName, String modelName,
			long recordId, String localeCode)
		throws PortalException, SystemException {

		return getService().updateTextAsPerLangCode(
			multiLingualText, columnName, modelName, recordId, localeCode);
	}

	public static String UTCtoIST(java.util.Date date) {
		return getService().UTCtoIST(date);
	}

	public static CommonUtilServiceLocalService getService() {
		return _service;
	}

	private static volatile CommonUtilServiceLocalService _service;

}