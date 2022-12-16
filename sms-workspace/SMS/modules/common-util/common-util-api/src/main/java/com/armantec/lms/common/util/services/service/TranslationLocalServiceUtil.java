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

import com.armantec.lms.common.util.services.model.Translation;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Set;

/**
 * Provides the local service utility for Translation. This utility wraps
 * <code>com.armantec.lms.common.util.services.service.impl.TranslationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TranslationLocalService
 * @generated
 */
public class TranslationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.armantec.lms.common.util.services.service.impl.TranslationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the translation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TranslationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param translation the translation
	 * @return the translation that was added
	 */
	public static Translation addTranslation(Translation translation) {
		return getService().addTranslation(translation);
	}

	public static String backgroundTaskCleanUp() throws PortalException {
		return getService().backgroundTaskCleanUp();
	}

	public static String backgroundTaskCleanUp(long backgroundTaskId)
		throws PortalException {

		return getService().backgroundTaskCleanUp(backgroundTaskId);
	}

	public static String backgroundTaskUnLock(String taskExecutorClassName)
		throws PortalException {

		return getService().backgroundTaskUnLock(taskExecutorClassName);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param id the primary key for the new translation
	 * @return the new translation
	 */
	public static Translation createTranslation(long id) {
		return getService().createTranslation(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TranslationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the translation
	 * @return the translation that was removed
	 * @throws PortalException if a translation with the primary key could not be found
	 */
	public static Translation deleteTranslation(long id)
		throws PortalException {

		return getService().deleteTranslation(id);
	}

	/**
	 * Deletes the translation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TranslationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param translation the translation
	 * @return the translation that was removed
	 */
	public static Translation deleteTranslation(Translation translation) {
		return getService().deleteTranslation(translation);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.armantec.lms.common.util.services.model.impl.TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.armantec.lms.common.util.services.model.impl.TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Translation fetchTranslation(long id) {
		return getService().fetchTranslation(id);
	}

	/**
	 * Returns the translation matching the UUID and group.
	 *
	 * @param uuid the translation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchTranslationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchTranslationByUuidAndGroupId(uuid, groupId);
	}

	public static Translation findByGroupModelNameColumnNameLangCodeRecordId(
			long groupId, String modelName, String columnName,
			String languageCode, long recordId)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getService().findByGroupModelNameColumnNameLangCodeRecordId(
			groupId, modelName, columnName, languageCode, recordId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static String getDefault() {
		return getService().getDefault();
	}

	public static com.liferay.portal.kernel.json.JSONObject getDefaultJson() {
		return getService().getDefaultJson();
	}

	public static java.util.Locale getDefaultLocale() {
		return getService().getDefaultLocale();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static Set<java.util.Locale> getSiteSupportedLocales()
		throws PortalException, SystemException {

		return getService().getSiteSupportedLocales();
	}

	public static com.liferay.portal.kernel.json.JSONArray getSupportedLocales()
		throws PortalException, SystemException {

		return getService().getSupportedLocales();
	}

	/**
	 * Returns the translation with the primary key.
	 *
	 * @param id the primary key of the translation
	 * @return the translation
	 * @throws PortalException if a translation with the primary key could not be found
	 */
	public static Translation getTranslation(long id) throws PortalException {
		return getService().getTranslation(id);
	}

	/**
	 * Returns the translation matching the UUID and group.
	 *
	 * @param uuid the translation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching translation
	 * @throws PortalException if a matching translation could not be found
	 */
	public static Translation getTranslationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getTranslationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.armantec.lms.common.util.services.model.impl.TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of translations
	 */
	public static List<Translation> getTranslations(int start, int end) {
		return getService().getTranslations(start, end);
	}

	/**
	 * Returns all the translations matching the UUID and company.
	 *
	 * @param uuid the UUID of the translations
	 * @param companyId the primary key of the company
	 * @return the matching translations, or an empty list if no matches were found
	 */
	public static List<Translation> getTranslationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getTranslationsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of translations matching the UUID and company.
	 *
	 * @param uuid the UUID of the translations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching translations, or an empty list if no matches were found
	 */
	public static List<Translation> getTranslationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getService().getTranslationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	public static int getTranslationsCount() {
		return getService().getTranslationsCount();
	}

	public static List<Translation> search(
		long entryId, String columnName, String modelName) {

		return getService().search(entryId, columnName, modelName);
	}

	public static List<Translation> search(
		long entryId, String columnName, String modelName, long groupId) {

		return getService().search(entryId, columnName, modelName, groupId);
	}

	public static List<String> search(
		String searchKey, String columnName, String modelName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().search(
			searchKey, columnName, modelName, serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONArray searchTopics(
		String searchKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().searchTopics(searchKey, serviceContext);
	}

	/**
	 * Updates the translation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TranslationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param translation the translation
	 * @return the translation that was updated
	 */
	public static Translation updateTranslation(Translation translation) {
		return getService().updateTranslation(translation);
	}

	public static TranslationLocalService getService() {
		return _service;
	}

	private static volatile TranslationLocalService _service;

}