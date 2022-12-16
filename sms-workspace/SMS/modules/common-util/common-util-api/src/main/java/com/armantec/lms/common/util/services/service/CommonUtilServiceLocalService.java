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

import com.armantec.lms.common.util.services.exception.NoSuchTranslationException;

import com.liferay.asset.kernel.exception.NoSuchVocabularyException;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for CommonUtilService. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CommonUtilServiceLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CommonUtilServiceLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.armantec.lms.common.util.services.service.impl.CommonUtilServiceLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the common util service local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CommonUtilServiceLocalServiceUtil} if injection and service tracking are not available.
	 */
	public User addRole(User user, String roleName)
		throws PortalException, SystemException;

	public String addTextAsPerLangCode(
			String multiLingualText, String columnName, String modelName,
			long recordId, String localeCode)
		throws PortalException, SystemException;

	public String assessmentHistoryListTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws PortalException, SystemException;

	public void assignUserGroup(long userId, long companyId, String groupName)
		throws PortalException, SystemException;

	public boolean containsIllegals(String toExamine) throws PortalException;

	public String copyFile(
		File srcFile, String folderPath, String fileName, long companyId);

	public void createDirectory(long companyId, String folderPath);

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
	public Folder createFolder(
		ServiceContext serviceContext, User user, long parentFolderId,
		String folderName, String fileType);

	public DLFolder createFolder(String folderName)
		throws PortalException, SystemException;

	public AssetVocabulary createVocabularyWithOrgName(String orgName)
		throws PortalException, SystemException;

	public void deleteModelRecordMultilingualText(
			String modelName, long recordId)
		throws PortalException, SystemException;

	public User deleteUserRole(User user, String roleName)
		throws PortalException, SystemException;

	public long documentUpload(
		ServiceContext serviceContext, long parentFolderId, long folderId,
		File file, String fileName, long maxFileSize, Boolean deleteAllFiles,
		String fileType);

	public String evaluateVelocityTemplate(
		String templateContent, Map variable);

	public long FileUpload(
		ServiceContext serviceContext, File file, long parentFolderId,
		long folderId, String folderName, String fieldName, long maxFileSize,
		String newFileName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getApprovedStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAssessmentAbortState();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getAssessmentAttemptState(int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAssessmentDefaultState();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAssessmentIncompleteState();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAssessmentSubmitState();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HashSet<Integer> getColRWList(HashMap<Integer, String> optionMap);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getCompanyId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User getCurrentOrganizationAdminWithPermissionChecker()
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User getCurrentUser() throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getDLFileEntryURL(DLFileEntry entry);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HashSet<Integer> getDuplicateKeys(
		HashMap<Integer, String> optionMap);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getExerciseTypeDynamicExcType();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getExerciseTypeLabType();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getExerciseTypeSecurityChangesType();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getExternalCode();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public File getFile(String url, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getFileEntryUrl(DLFileEntry entry) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getFileUrl(
			File file, String folderName, ServiceContext serviceContext,
			String uniqueName, String defaultUrl)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Folder getFolder(
		ServiceContext serviceContext, long parentFolderId, String folderName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getGroupId(String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportExportCancelStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportExportCompletedStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportExportErrorStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportExportQueueStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getImportExportStartedStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getImportExportStatus(int state);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getJSONObject(Map<String, Object> modelAttributes);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeAnsTypeCorrectStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeAnsTypeIncorrectStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeAnsTypeUnanswredStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeAnsTypeUnknownStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeCancelStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeCompletedStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeErrorStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeIncompleteStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeStartedPrgress();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabPracticeStartedStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getLabStatusError();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getLabStatusStarted();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getLabStatusStoped();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean getLMSAuth(long candidateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getLocale(Locale locale);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMinut();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getMultilingualTextByKey(String key, String defaultValue);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getMultilingualTextByPortletKey(
		String key, String defaultValue);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getPassword();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void getPermissionCheckerAdmin()
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getRandomColorHexString();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getRandomString(int len);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceContext getServiceContext();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceContext getServiceContext(boolean scopeGroup);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getServiceScopeGroupId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getServiceScopeGroupIdBySiteName() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTotalRightOption(ArrayList<String> list);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUnapprovedStatus();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getUsageFile(long scopeGroupId, String usage);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public File getUsageFileV2(long scopeGroupId, String usage)
		throws IOException, PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUserGroupId(long userId, String name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUserGroupId(
		long userId, String userGroupName, String defaultUserGroupName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> getUserListByRole(String[] roleArray)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> getUserListByRole(
			String[] roleArray, String invalidUserRole)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUserLocationId() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Organization getUserOrganization() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUserOrganizationGroupId() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUserOrganizationId() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUserOrganizationId(long userId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUserOrganizationLogoId() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getUserOrganizationName() throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getUserOrganizationNameByOrgId(long[] orgId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getUserOrganizationNameByUserId(long userId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AssetVocabulary getVocabularyByUserAssociateOrg()
		throws NoSuchVocabularyException, PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getWorkWorkFlowStatus(int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAllRoles(ArrayList<String> userRoles, String[] roleNames);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAnyRole(ArrayList<String> userRoles, String[] roleNames);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasRole(User user, String roleName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList hasRole(User user, String[] roleNames);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasUserGroup(User user, String userGroupName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public FileEntry isFileExist(
		ServiceContext serviceContext, long parentFolderId, String title);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Folder isFolderExist(
		ServiceContext serviceContext, long parentFolderId, String folderName);

	public String ISTtoUTC(Date date);

	public String listTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws PortalException, SystemException;

	public String listTextAsPerLangCodeRecordId(
			String columnName, String modelName, long recordId,
			String localeCode, long groupId)
		throws PortalException, SystemException;

	public String listTextAsPerLangCodeRecordIdAssessment(
			String columnName, String modelName, long recordId,
			String localeCode)
		throws NoSuchTranslationException, PortalException, SystemException;

	public String ordinal(int i);

	public void printLog(String str);

	public int randomOtp(int len);

	public boolean send(
		String from, String password, String to, String sub, String msg,
		String port, String smtpHost);

	public boolean sendAccountActivationMail(
			String toAddress, String subject, Map variables,
			String senderMailAddress, String senderName)
		throws Exception;

	public boolean sendAccountEmailIdPassMail(
			String toAddress, String subject, Map variables,
			String senderMailAddress, String senderName)
		throws Exception;

	public void sendLiferayNotification(
			String title, String body, long userId, String receiverName,
			String notificationType, String link)
		throws PortalException, SystemException;

	public boolean sendMail(
			String toAddress, String subject, Map variables,
			String senderMailAddress, String senderName, String mailTemplate)
		throws Exception;

	public String sendSms(String mobileNo, String message)
		throws SystemException;

	public boolean sendStudentExpiryMail(
			String toAddress, String subject, Map variables)
		throws Exception;

	public void setPermissions(
			long companyId, String className, String role, String columnName,
			String[] actions)
		throws PortalException, SystemException;

	public List<User> setPermissonCheckerByRole(
		String roleName, String invalidUserRole, String[] organizationNames);

	public User setPermissonCheckerByUserId(long userId);

	public void throwException(Exception e) throws SystemException;

	public String updateTextAsPerLangCode(
			String multiLingualText, String columnName, String modelName,
			long recordId, String localeCode)
		throws PortalException, SystemException;

	public String UTCtoIST(Date date);

}