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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommonUtilServiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CommonUtilServiceLocalService
 * @generated
 */
public class CommonUtilServiceLocalServiceWrapper
	implements CommonUtilServiceLocalService,
			   ServiceWrapper<CommonUtilServiceLocalService> {

	public CommonUtilServiceLocalServiceWrapper() {
		this(null);
	}

	public CommonUtilServiceLocalServiceWrapper(
		CommonUtilServiceLocalService commonUtilServiceLocalService) {

		_commonUtilServiceLocalService = commonUtilServiceLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User addRole(
			com.liferay.portal.kernel.model.User user, String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.addRole(user, roleName);
	}

	@Override
	public String addTextAsPerLangCode(
			String multiLingualText, String columnName, String modelName,
			long recordId, String localeCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.addTextAsPerLangCode(
			multiLingualText, columnName, modelName, recordId, localeCode);
	}

	@Override
	public String assessmentHistoryListTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.
			assessmentHistoryListTextAsPerLangCodeRecordId(
				columnName, modelName, recordId, localeCode);
	}

	@Override
	public void assignUserGroup(long userId, long companyId, String groupName)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_commonUtilServiceLocalService.assignUserGroup(
			userId, companyId, groupName);
	}

	@Override
	public boolean containsIllegals(String toExamine)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commonUtilServiceLocalService.containsIllegals(toExamine);
	}

	@Override
	public String copyFile(
		java.io.File srcFile, String folderPath, String fileName,
		long companyId) {

		return _commonUtilServiceLocalService.copyFile(
			srcFile, folderPath, fileName, companyId);
	}

	@Override
	public void createDirectory(long companyId, String folderPath) {
		_commonUtilServiceLocalService.createDirectory(companyId, folderPath);
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
	@Override
	public com.liferay.portal.kernel.repository.model.Folder createFolder(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		com.liferay.portal.kernel.model.User user, long parentFolderId,
		String folderName, String fileType) {

		return _commonUtilServiceLocalService.createFolder(
			serviceContext, user, parentFolderId, folderName, fileType);
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFolder createFolder(
			String folderName)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.createFolder(folderName);
	}

	@Override
	public com.liferay.asset.kernel.model.AssetVocabulary
			createVocabularyWithOrgName(String orgName)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.createVocabularyWithOrgName(
			orgName);
	}

	@Override
	public void deleteModelRecordMultilingualText(
			String modelName, long recordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_commonUtilServiceLocalService.deleteModelRecordMultilingualText(
			modelName, recordId);
	}

	@Override
	public com.liferay.portal.kernel.model.User deleteUserRole(
			com.liferay.portal.kernel.model.User user, String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.deleteUserRole(user, roleName);
	}

	@Override
	public long documentUpload(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long parentFolderId, long folderId, java.io.File file, String fileName,
		long maxFileSize, Boolean deleteAllFiles, String fileType) {

		return _commonUtilServiceLocalService.documentUpload(
			serviceContext, parentFolderId, folderId, file, fileName,
			maxFileSize, deleteAllFiles, fileType);
	}

	@Override
	public String evaluateVelocityTemplate(
		String templateContent, java.util.Map variable) {

		return _commonUtilServiceLocalService.evaluateVelocityTemplate(
			templateContent, variable);
	}

	@Override
	public long FileUpload(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		java.io.File file, long parentFolderId, long folderId,
		String folderName, String fieldName, long maxFileSize,
		String newFileName) {

		return _commonUtilServiceLocalService.FileUpload(
			serviceContext, file, parentFolderId, folderId, folderName,
			fieldName, maxFileSize, newFileName);
	}

	@Override
	public int getApprovedStatus() {
		return _commonUtilServiceLocalService.getApprovedStatus();
	}

	@Override
	public int getAssessmentAbortState() {
		return _commonUtilServiceLocalService.getAssessmentAbortState();
	}

	@Override
	public String getAssessmentAttemptState(int status) {
		return _commonUtilServiceLocalService.getAssessmentAttemptState(status);
	}

	@Override
	public int getAssessmentDefaultState() {
		return _commonUtilServiceLocalService.getAssessmentDefaultState();
	}

	@Override
	public int getAssessmentIncompleteState() {
		return _commonUtilServiceLocalService.getAssessmentIncompleteState();
	}

	@Override
	public int getAssessmentSubmitState() {
		return _commonUtilServiceLocalService.getAssessmentSubmitState();
	}

	@Override
	public java.util.HashSet<Integer> getColRWList(
		java.util.HashMap<Integer, String> optionMap) {

		return _commonUtilServiceLocalService.getColRWList(optionMap);
	}

	@Override
	public long getCompanyId() {
		return _commonUtilServiceLocalService.getCompanyId();
	}

	@Override
	public com.liferay.portal.kernel.model.User
			getCurrentOrganizationAdminWithPermissionChecker()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.
			getCurrentOrganizationAdminWithPermissionChecker();
	}

	@Override
	public com.liferay.portal.kernel.model.User getCurrentUser()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getCurrentUser();
	}

	@Override
	public String getDLFileEntryURL(
		com.liferay.document.library.kernel.model.DLFileEntry entry) {

		return _commonUtilServiceLocalService.getDLFileEntryURL(entry);
	}

	@Override
	public java.util.HashSet<Integer> getDuplicateKeys(
		java.util.HashMap<Integer, String> optionMap) {

		return _commonUtilServiceLocalService.getDuplicateKeys(optionMap);
	}

	@Override
	public int getExerciseTypeDynamicExcType() {
		return _commonUtilServiceLocalService.getExerciseTypeDynamicExcType();
	}

	@Override
	public int getExerciseTypeLabType() {
		return _commonUtilServiceLocalService.getExerciseTypeLabType();
	}

	@Override
	public int getExerciseTypeSecurityChangesType() {
		return _commonUtilServiceLocalService.
			getExerciseTypeSecurityChangesType();
	}

	@Override
	public String getExternalCode() {
		return _commonUtilServiceLocalService.getExternalCode();
	}

	@Override
	public java.io.File getFile(String url, long companyId) {
		return _commonUtilServiceLocalService.getFile(url, companyId);
	}

	@Override
	public String getFileEntryUrl(
			com.liferay.document.library.kernel.model.DLFileEntry entry)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getFileEntryUrl(entry);
	}

	@Override
	public String getFileUrl(
			java.io.File file, String folderName,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String uniqueName, String defaultUrl)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getFileUrl(
			file, folderName, serviceContext, uniqueName, defaultUrl);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder getFolder(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long parentFolderId, String folderName) {

		return _commonUtilServiceLocalService.getFolder(
			serviceContext, parentFolderId, folderName);
	}

	@Override
	public long getGroupId(String name) {
		return _commonUtilServiceLocalService.getGroupId(name);
	}

	@Override
	public int getImportExportCancelStatus() {
		return _commonUtilServiceLocalService.getImportExportCancelStatus();
	}

	@Override
	public int getImportExportCompletedStatus() {
		return _commonUtilServiceLocalService.getImportExportCompletedStatus();
	}

	@Override
	public int getImportExportErrorStatus() {
		return _commonUtilServiceLocalService.getImportExportErrorStatus();
	}

	@Override
	public int getImportExportQueueStatus() {
		return _commonUtilServiceLocalService.getImportExportQueueStatus();
	}

	@Override
	public int getImportExportStartedStatus() {
		return _commonUtilServiceLocalService.getImportExportStartedStatus();
	}

	@Override
	public String getImportExportStatus(int state) {
		return _commonUtilServiceLocalService.getImportExportStatus(state);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getJSONObject(
		java.util.Map<String, Object> modelAttributes) {

		return _commonUtilServiceLocalService.getJSONObject(modelAttributes);
	}

	@Override
	public int getLabPracticeAnsTypeCorrectStatus() {
		return _commonUtilServiceLocalService.
			getLabPracticeAnsTypeCorrectStatus();
	}

	@Override
	public int getLabPracticeAnsTypeIncorrectStatus() {
		return _commonUtilServiceLocalService.
			getLabPracticeAnsTypeIncorrectStatus();
	}

	@Override
	public int getLabPracticeAnsTypeUnanswredStatus() {
		return _commonUtilServiceLocalService.
			getLabPracticeAnsTypeUnanswredStatus();
	}

	@Override
	public int getLabPracticeAnsTypeUnknownStatus() {
		return _commonUtilServiceLocalService.
			getLabPracticeAnsTypeUnknownStatus();
	}

	@Override
	public int getLabPracticeCancelStatus() {
		return _commonUtilServiceLocalService.getLabPracticeCancelStatus();
	}

	@Override
	public int getLabPracticeCompletedStatus() {
		return _commonUtilServiceLocalService.getLabPracticeCompletedStatus();
	}

	@Override
	public int getLabPracticeErrorStatus() {
		return _commonUtilServiceLocalService.getLabPracticeErrorStatus();
	}

	@Override
	public int getLabPracticeIncompleteStatus() {
		return _commonUtilServiceLocalService.getLabPracticeIncompleteStatus();
	}

	@Override
	public int getLabPracticeStartedPrgress() {
		return _commonUtilServiceLocalService.getLabPracticeStartedPrgress();
	}

	@Override
	public int getLabPracticeStartedStatus() {
		return _commonUtilServiceLocalService.getLabPracticeStartedStatus();
	}

	@Override
	public String getLabStatusError() {
		return _commonUtilServiceLocalService.getLabStatusError();
	}

	@Override
	public String getLabStatusStarted() {
		return _commonUtilServiceLocalService.getLabStatusStarted();
	}

	@Override
	public String getLabStatusStoped() {
		return _commonUtilServiceLocalService.getLabStatusStoped();
	}

	@Override
	public boolean getLMSAuth(long candidateId) {
		return _commonUtilServiceLocalService.getLMSAuth(candidateId);
	}

	@Override
	public String getLocale(java.util.Locale locale) {
		return _commonUtilServiceLocalService.getLocale(locale);
	}

	@Override
	public int getMinut() {
		return _commonUtilServiceLocalService.getMinut();
	}

	@Override
	public String getMultilingualTextByKey(String key, String defaultValue) {
		return _commonUtilServiceLocalService.getMultilingualTextByKey(
			key, defaultValue);
	}

	@Override
	public String getMultilingualTextByPortletKey(
		String key, String defaultValue) {

		return _commonUtilServiceLocalService.getMultilingualTextByPortletKey(
			key, defaultValue);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commonUtilServiceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public String getPassword() {
		return _commonUtilServiceLocalService.getPassword();
	}

	@Override
	public void getPermissionCheckerAdmin()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_commonUtilServiceLocalService.getPermissionCheckerAdmin();
	}

	@Override
	public String getRandomColorHexString() {
		return _commonUtilServiceLocalService.getRandomColorHexString();
	}

	@Override
	public String getRandomString(int len) {
		return _commonUtilServiceLocalService.getRandomString(len);
	}

	@Override
	public com.liferay.portal.kernel.service.ServiceContext
		getServiceContext() {

		return _commonUtilServiceLocalService.getServiceContext();
	}

	@Override
	public com.liferay.portal.kernel.service.ServiceContext getServiceContext(
		boolean scopeGroup) {

		return _commonUtilServiceLocalService.getServiceContext(scopeGroup);
	}

	@Override
	public long getServiceScopeGroupId() {
		return _commonUtilServiceLocalService.getServiceScopeGroupId();
	}

	@Override
	public long getServiceScopeGroupIdBySiteName()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commonUtilServiceLocalService.
			getServiceScopeGroupIdBySiteName();
	}

	@Override
	public int getTotalRightOption(java.util.ArrayList<String> list) {
		return _commonUtilServiceLocalService.getTotalRightOption(list);
	}

	@Override
	public int getUnapprovedStatus() {
		return _commonUtilServiceLocalService.getUnapprovedStatus();
	}

	@Override
	public String getUsageFile(long scopeGroupId, String usage) {
		return _commonUtilServiceLocalService.getUsageFile(scopeGroupId, usage);
	}

	@Override
	public java.io.File getUsageFileV2(long scopeGroupId, String usage)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.io.IOException {

		return _commonUtilServiceLocalService.getUsageFileV2(
			scopeGroupId, usage);
	}

	@Override
	public long getUserGroupId(long userId, String name) {
		return _commonUtilServiceLocalService.getUserGroupId(userId, name);
	}

	@Override
	public long getUserGroupId(
		long userId, String userGroupName, String defaultUserGroupName) {

		return _commonUtilServiceLocalService.getUserGroupId(
			userId, userGroupName, defaultUserGroupName);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User>
			getUserListByRole(String[] roleArray)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserListByRole(roleArray);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User>
			getUserListByRole(String[] roleArray, String invalidUserRole)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserListByRole(
			roleArray, invalidUserRole);
	}

	@Override
	public long getUserLocationId()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserLocationId();
	}

	@Override
	public com.liferay.portal.kernel.model.Organization getUserOrganization()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserOrganization();
	}

	@Override
	public long getUserOrganizationGroupId()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserOrganizationGroupId();
	}

	@Override
	public long getUserOrganizationId()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserOrganizationId();
	}

	@Override
	public long getUserOrganizationId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserOrganizationId(userId);
	}

	@Override
	public long getUserOrganizationLogoId()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserOrganizationLogoId();
	}

	@Override
	public String getUserOrganizationName()
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserOrganizationName();
	}

	@Override
	public String getUserOrganizationNameByOrgId(long[] orgId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserOrganizationNameByOrgId(
			orgId);
	}

	@Override
	public String getUserOrganizationNameByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getUserOrganizationNameByUserId(
			userId);
	}

	@Override
	public com.liferay.asset.kernel.model.AssetVocabulary
			getVocabularyByUserAssociateOrg()
		throws com.liferay.asset.kernel.exception.NoSuchVocabularyException,
			   com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.getVocabularyByUserAssociateOrg();
	}

	@Override
	public String getWorkWorkFlowStatus(int status) {
		return _commonUtilServiceLocalService.getWorkWorkFlowStatus(status);
	}

	@Override
	public boolean hasAllRoles(
		java.util.ArrayList<String> userRoles, String[] roleNames) {

		return _commonUtilServiceLocalService.hasAllRoles(userRoles, roleNames);
	}

	@Override
	public boolean hasAnyRole(
		java.util.ArrayList<String> userRoles, String[] roleNames) {

		return _commonUtilServiceLocalService.hasAnyRole(userRoles, roleNames);
	}

	@Override
	public boolean hasRole(
		com.liferay.portal.kernel.model.User user, String roleName) {

		return _commonUtilServiceLocalService.hasRole(user, roleName);
	}

	@Override
	public java.util.ArrayList hasRole(
		com.liferay.portal.kernel.model.User user, String[] roleNames) {

		return _commonUtilServiceLocalService.hasRole(user, roleNames);
	}

	@Override
	public boolean hasUserGroup(
		com.liferay.portal.kernel.model.User user, String userGroupName) {

		return _commonUtilServiceLocalService.hasUserGroup(user, userGroupName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry isFileExist(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long parentFolderId, String title) {

		return _commonUtilServiceLocalService.isFileExist(
			serviceContext, parentFolderId, title);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder isFolderExist(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		long parentFolderId, String folderName) {

		return _commonUtilServiceLocalService.isFolderExist(
			serviceContext, parentFolderId, folderName);
	}

	@Override
	public String ISTtoUTC(java.util.Date date) {
		return _commonUtilServiceLocalService.ISTtoUTC(date);
	}

	@Override
	public String listTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.listTextAsPerLangCodeRecordId(
			columnName, modelName, recordId, localeCode);
	}

	@Override
	public String listTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.listTextAsPerLangCodeRecordId(
			columnName, modelName, recordId, localeCode, groupId);
	}

	@Override
	public String listTextAsPerLangCodeRecordIdAssessment(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException,
			   com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.
			listTextAsPerLangCodeRecordIdAssessment(
				columnName, modelName, recordId, localeCode);
	}

	@Override
	public String ordinal(int i) {
		return _commonUtilServiceLocalService.ordinal(i);
	}

	@Override
	public void printLog(String str) {
		_commonUtilServiceLocalService.printLog(str);
	}

	@Override
	public int randomOtp(int len) {
		return _commonUtilServiceLocalService.randomOtp(len);
	}

	@Override
	public boolean send(
		String from, String password, String to, String sub, String msg,
		String port, String smtpHost) {

		return _commonUtilServiceLocalService.send(
			from, password, to, sub, msg, port, smtpHost);
	}

	@Override
	public boolean sendAccountActivationMail(
			String toAddress, String subject, java.util.Map variables,
			String senderMailAddress, String senderName)
		throws Exception {

		return _commonUtilServiceLocalService.sendAccountActivationMail(
			toAddress, subject, variables, senderMailAddress, senderName);
	}

	@Override
	public boolean sendAccountEmailIdPassMail(
			String toAddress, String subject, java.util.Map variables,
			String senderMailAddress, String senderName)
		throws Exception {

		return _commonUtilServiceLocalService.sendAccountEmailIdPassMail(
			toAddress, subject, variables, senderMailAddress, senderName);
	}

	@Override
	public void sendLiferayNotification(
			String title, String body, long userId, String receiverName,
			String notificationType, String link)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_commonUtilServiceLocalService.sendLiferayNotification(
			title, body, userId, receiverName, notificationType, link);
	}

	@Override
	public boolean sendMail(
			String toAddress, String subject, java.util.Map variables,
			String senderMailAddress, String senderName, String mailTemplate)
		throws Exception {

		return _commonUtilServiceLocalService.sendMail(
			toAddress, subject, variables, senderMailAddress, senderName,
			mailTemplate);
	}

	@Override
	public String sendSms(String mobileNo, String message)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.sendSms(mobileNo, message);
	}

	@Override
	public boolean sendStudentExpiryMail(
			String toAddress, String subject, java.util.Map variables)
		throws Exception {

		return _commonUtilServiceLocalService.sendStudentExpiryMail(
			toAddress, subject, variables);
	}

	@Override
	public void setPermissions(
			long companyId, String className, String role, String columnName,
			String[] actions)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		_commonUtilServiceLocalService.setPermissions(
			companyId, className, role, columnName, actions);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User>
		setPermissonCheckerByRole(
			String roleName, String invalidUserRole,
			String[] organizationNames) {

		return _commonUtilServiceLocalService.setPermissonCheckerByRole(
			roleName, invalidUserRole, organizationNames);
	}

	@Override
	public com.liferay.portal.kernel.model.User setPermissonCheckerByUserId(
		long userId) {

		return _commonUtilServiceLocalService.setPermissonCheckerByUserId(
			userId);
	}

	@Override
	public void throwException(Exception e)
		throws com.liferay.portal.kernel.exception.SystemException {

		_commonUtilServiceLocalService.throwException(e);
	}

	@Override
	public String updateTextAsPerLangCode(
			String multiLingualText, String columnName, String modelName,
			long recordId, String localeCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _commonUtilServiceLocalService.updateTextAsPerLangCode(
			multiLingualText, columnName, modelName, recordId, localeCode);
	}

	@Override
	public String UTCtoIST(java.util.Date date) {
		return _commonUtilServiceLocalService.UTCtoIST(date);
	}

	@Override
	public CommonUtilServiceLocalService getWrappedService() {
		return _commonUtilServiceLocalService;
	}

	@Override
	public void setWrappedService(
		CommonUtilServiceLocalService commonUtilServiceLocalService) {

		_commonUtilServiceLocalService = commonUtilServiceLocalService;
	}

	private CommonUtilServiceLocalService _commonUtilServiceLocalService;

}