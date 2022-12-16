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

package com.armantec.lms.common.util.services.service.persistence;

import com.armantec.lms.common.util.services.model.Translation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the translation service. This utility wraps <code>com.armantec.lms.common.util.services.service.persistence.impl.TranslationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TranslationPersistence
 * @generated
 */
public class TranslationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Translation translation) {
		getPersistence().clearCache(translation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Translation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Translation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Translation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Translation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Translation update(Translation translation) {
		return getPersistence().update(translation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Translation update(
		Translation translation, ServiceContext serviceContext) {

		return getPersistence().update(translation, serviceContext);
	}

	/**
	 * Returns all the translations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching translations
	 */
	public static List<Translation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the translations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	public static List<Translation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the translations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByUuid_First(
			String uuid, OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByUuid_First(
		String uuid, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByUuid_Last(
			String uuid, OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByUuid_Last(
		String uuid, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current translation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the translations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of translations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching translations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByUUID_G(String uuid, long groupId)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the translation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the translation that was removed
	 */
	public static Translation removeByUUID_G(String uuid, long groupId)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of translations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching translations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the translations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching translations
	 */
	public static List<Translation> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the translations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	public static List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the translations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current translation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the translations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of translations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching translations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the translation where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByGroupModelNameColumnNameLangCode(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupModelNameColumnNameLangCode(
			groupId, deleted, modelName, columnName, languageCode);
	}

	/**
	 * Returns the translation where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode) {

		return getPersistence().fetchByGroupModelNameColumnNameLangCode(
			groupId, deleted, modelName, columnName, languageCode);
	}

	/**
	 * Returns the translation where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, boolean useFinderCache) {

		return getPersistence().fetchByGroupModelNameColumnNameLangCode(
			groupId, deleted, modelName, columnName, languageCode,
			useFinderCache);
	}

	/**
	 * Removes the translation where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @return the translation that was removed
	 */
	public static Translation removeByGroupModelNameColumnNameLangCode(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().removeByGroupModelNameColumnNameLangCode(
			groupId, deleted, modelName, columnName, languageCode);
	}

	/**
	 * Returns the number of translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @return the number of matching translations
	 */
	public static int countByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode) {

		return getPersistence().countByGroupModelNameColumnNameLangCode(
			groupId, deleted, modelName, columnName, languageCode);
	}

	/**
	 * Returns the translation where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByGroupModelNameColumnNameLangCodeRecordId(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode, long recordId)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupModelNameColumnNameLangCodeRecordId(
			groupId, deleted, modelName, columnName, languageCode, recordId);
	}

	/**
	 * Returns the translation where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId) {

		return getPersistence().fetchByGroupModelNameColumnNameLangCodeRecordId(
			groupId, deleted, modelName, columnName, languageCode, recordId);
	}

	/**
	 * Returns the translation where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId, boolean useFinderCache) {

		return getPersistence().fetchByGroupModelNameColumnNameLangCodeRecordId(
			groupId, deleted, modelName, columnName, languageCode, recordId,
			useFinderCache);
	}

	/**
	 * Removes the translation where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @return the translation that was removed
	 */
	public static Translation removeByGroupModelNameColumnNameLangCodeRecordId(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode, long recordId)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().
			removeByGroupModelNameColumnNameLangCodeRecordId(
				groupId, deleted, modelName, columnName, languageCode,
				recordId);
	}

	/**
	 * Returns the number of translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @return the number of matching translations
	 */
	public static int countByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId) {

		return getPersistence().countByGroupModelNameColumnNameLangCodeRecordId(
			groupId, deleted, modelName, columnName, languageCode, recordId);
	}

	/**
	 * Returns the translation where groupId = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByAssessmentHistoryUseOnly(
			long groupId, String modelName, String columnName,
			String languageCode, long recordId)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByAssessmentHistoryUseOnly(
			groupId, modelName, columnName, languageCode, recordId);
	}

	/**
	 * Returns the translation where groupId = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId) {

		return getPersistence().fetchByAssessmentHistoryUseOnly(
			groupId, modelName, columnName, languageCode, recordId);
	}

	/**
	 * Returns the translation where groupId = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId, boolean useFinderCache) {

		return getPersistence().fetchByAssessmentHistoryUseOnly(
			groupId, modelName, columnName, languageCode, recordId,
			useFinderCache);
	}

	/**
	 * Removes the translation where groupId = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @return the translation that was removed
	 */
	public static Translation removeByAssessmentHistoryUseOnly(
			long groupId, String modelName, String columnName,
			String languageCode, long recordId)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().removeByAssessmentHistoryUseOnly(
			groupId, modelName, columnName, languageCode, recordId);
	}

	/**
	 * Returns the number of translations where groupId = &#63; and modelName = &#63; and columnName = &#63; and languageCode = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param modelName the model name
	 * @param columnName the column name
	 * @param languageCode the language code
	 * @param recordId the record ID
	 * @return the number of matching translations
	 */
	public static int countByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId) {

		return getPersistence().countByAssessmentHistoryUseOnly(
			groupId, modelName, columnName, languageCode, recordId);
	}

	/**
	 * Returns all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @return the matching translations
	 */
	public static List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId) {

		return getPersistence().findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	public static List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end) {

		return getPersistence().findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId, start, end);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end, OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByGroupModelNameRecordId_First(
			long groupId, boolean deleted, String modelName, long recordId,
			OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupModelNameRecordId_First(
			groupId, deleted, modelName, recordId, orderByComparator);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupModelNameRecordId_First(
		long groupId, boolean deleted, String modelName, long recordId,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByGroupModelNameRecordId_First(
			groupId, deleted, modelName, recordId, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByGroupModelNameRecordId_Last(
			long groupId, boolean deleted, String modelName, long recordId,
			OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupModelNameRecordId_Last(
			groupId, deleted, modelName, recordId, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupModelNameRecordId_Last(
		long groupId, boolean deleted, String modelName, long recordId,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByGroupModelNameRecordId_Last(
			groupId, deleted, modelName, recordId, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param id the primary key of the current translation
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] findByGroupModelNameRecordId_PrevAndNext(
			long id, long groupId, boolean deleted, String modelName,
			long recordId, OrderByComparator<Translation> orderByComparator)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupModelNameRecordId_PrevAndNext(
			id, groupId, deleted, modelName, recordId, orderByComparator);
	}

	/**
	 * Removes all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 */
	public static void removeByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId) {

		getPersistence().removeByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId);
	}

	/**
	 * Returns the number of translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @return the number of matching translations
	 */
	public static int countByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId) {

		return getPersistence().countByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId);
	}

	/**
	 * Caches the translation in the entity cache if it is enabled.
	 *
	 * @param translation the translation
	 */
	public static void cacheResult(Translation translation) {
		getPersistence().cacheResult(translation);
	}

	/**
	 * Caches the translations in the entity cache if it is enabled.
	 *
	 * @param translations the translations
	 */
	public static void cacheResult(List<Translation> translations) {
		getPersistence().cacheResult(translations);
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param id the primary key for the new translation
	 * @return the new translation
	 */
	public static Translation create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the translation
	 * @return the translation that was removed
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation remove(long id)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().remove(id);
	}

	public static Translation updateImpl(Translation translation) {
		return getPersistence().updateImpl(translation);
	}

	/**
	 * Returns the translation with the primary key or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param id the primary key of the translation
	 * @return the translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation findByPrimaryKey(long id)
		throws com.armantec.lms.common.util.services.exception.
			NoSuchTranslationException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the translation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the translation
	 * @return the translation, or <code>null</code> if a translation with the primary key could not be found
	 */
	public static Translation fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the translations.
	 *
	 * @return the translations
	 */
	public static List<Translation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of translations
	 */
	public static List<Translation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of translations
	 */
	public static List<Translation> findAll(
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of translations
	 */
	public static List<Translation> findAll(
		int start, int end, OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the translations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TranslationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TranslationPersistence _persistence;

}