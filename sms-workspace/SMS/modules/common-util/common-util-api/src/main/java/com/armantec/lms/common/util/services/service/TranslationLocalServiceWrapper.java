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
 * Provides a wrapper for {@link TranslationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TranslationLocalService
 * @generated
 */
public class TranslationLocalServiceWrapper
	implements ServiceWrapper<TranslationLocalService>,
			   TranslationLocalService {

	public TranslationLocalServiceWrapper() {
		this(null);
	}

	public TranslationLocalServiceWrapper(
		TranslationLocalService translationLocalService) {

		_translationLocalService = translationLocalService;
	}

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
	@Override
	public com.armantec.lms.common.util.services.model.Translation
		addTranslation(
			com.armantec.lms.common.util.services.model.Translation
				translation) {

		return _translationLocalService.addTranslation(translation);
	}

	@Override
	public String backgroundTaskCleanUp()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.backgroundTaskCleanUp();
	}

	@Override
	public String backgroundTaskCleanUp(long backgroundTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.backgroundTaskCleanUp(backgroundTaskId);
	}

	@Override
	public String backgroundTaskUnLock(String taskExecutorClassName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.backgroundTaskUnLock(
			taskExecutorClassName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param id the primary key for the new translation
	 * @return the new translation
	 */
	@Override
	public com.armantec.lms.common.util.services.model.Translation
		createTranslation(long id) {

		return _translationLocalService.createTranslation(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.armantec.lms.common.util.services.model.Translation
			deleteTranslation(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.deleteTranslation(id);
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
	@Override
	public com.armantec.lms.common.util.services.model.Translation
		deleteTranslation(
			com.armantec.lms.common.util.services.model.Translation
				translation) {

		return _translationLocalService.deleteTranslation(translation);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _translationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _translationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _translationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _translationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _translationLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _translationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _translationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _translationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.armantec.lms.common.util.services.model.Translation
		fetchTranslation(long id) {

		return _translationLocalService.fetchTranslation(id);
	}

	/**
	 * Returns the translation matching the UUID and group.
	 *
	 * @param uuid the translation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public com.armantec.lms.common.util.services.model.Translation
		fetchTranslationByUuidAndGroupId(String uuid, long groupId) {

		return _translationLocalService.fetchTranslationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.armantec.lms.common.util.services.model.Translation
			findByGroupModelNameColumnNameLangCodeRecordId(
				long groupId, String modelName, String columnName,
				String languageCode, long recordId)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return _translationLocalService.
			findByGroupModelNameColumnNameLangCodeRecordId(
				groupId, modelName, columnName, languageCode, recordId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _translationLocalService.getActionableDynamicQuery();
	}

	@Override
	public String getDefault() {
		return _translationLocalService.getDefault();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getDefaultJson() {
		return _translationLocalService.getDefaultJson();
	}

	@Override
	public java.util.Locale getDefaultLocale() {
		return _translationLocalService.getDefaultLocale();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _translationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _translationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _translationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.Set<java.util.Locale> getSiteSupportedLocales()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _translationLocalService.getSiteSupportedLocales();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getSupportedLocales()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _translationLocalService.getSupportedLocales();
	}

	/**
	 * Returns the translation with the primary key.
	 *
	 * @param id the primary key of the translation
	 * @return the translation
	 * @throws PortalException if a translation with the primary key could not be found
	 */
	@Override
	public com.armantec.lms.common.util.services.model.Translation
			getTranslation(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.getTranslation(id);
	}

	/**
	 * Returns the translation matching the UUID and group.
	 *
	 * @param uuid the translation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching translation
	 * @throws PortalException if a matching translation could not be found
	 */
	@Override
	public com.armantec.lms.common.util.services.model.Translation
			getTranslationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.getTranslationByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List
		<com.armantec.lms.common.util.services.model.Translation>
			getTranslations(int start, int end) {

		return _translationLocalService.getTranslations(start, end);
	}

	/**
	 * Returns all the translations matching the UUID and company.
	 *
	 * @param uuid the UUID of the translations
	 * @param companyId the primary key of the company
	 * @return the matching translations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.armantec.lms.common.util.services.model.Translation>
			getTranslationsByUuidAndCompanyId(String uuid, long companyId) {

		return _translationLocalService.getTranslationsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List
		<com.armantec.lms.common.util.services.model.Translation>
			getTranslationsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.armantec.lms.common.util.services.model.Translation>
						orderByComparator) {

		return _translationLocalService.getTranslationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	@Override
	public int getTranslationsCount() {
		return _translationLocalService.getTranslationsCount();
	}

	@Override
	public java.util.List
		<com.armantec.lms.common.util.services.model.Translation> search(
			long entryId, String columnName, String modelName) {

		return _translationLocalService.search(entryId, columnName, modelName);
	}

	@Override
	public java.util.List
		<com.armantec.lms.common.util.services.model.Translation> search(
			long entryId, String columnName, String modelName, long groupId) {

		return _translationLocalService.search(
			entryId, columnName, modelName, groupId);
	}

	@Override
	public java.util.List<String> search(
		String searchKey, String columnName, String modelName,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _translationLocalService.search(
			searchKey, columnName, modelName, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray searchTopics(
		String searchKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _translationLocalService.searchTopics(searchKey, serviceContext);
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
	@Override
	public com.armantec.lms.common.util.services.model.Translation
		updateTranslation(
			com.armantec.lms.common.util.services.model.Translation
				translation) {

		return _translationLocalService.updateTranslation(translation);
	}

	@Override
	public TranslationLocalService getWrappedService() {
		return _translationLocalService;
	}

	@Override
	public void setWrappedService(
		TranslationLocalService translationLocalService) {

		_translationLocalService = translationLocalService;
	}

	private TranslationLocalService _translationLocalService;

}