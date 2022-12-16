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

import com.armantec.lms.common.util.services.exception.NoSuchTranslationException;
import com.armantec.lms.common.util.services.model.Translation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the translation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TranslationUtil
 * @generated
 */
@ProviderType
public interface TranslationPersistence extends BasePersistence<Translation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TranslationUtil} to access the translation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the translations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching translations
	 */
	public java.util.List<Translation> findByUuid(String uuid);

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
	public java.util.List<Translation> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Translation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the first translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

	/**
	 * Returns the last translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the last translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

	/**
	 * Returns the translations before and after the current translation in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current translation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public Translation[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Removes all the translations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of translations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching translations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByUUID_G(String uuid, long groupId)
		throws NoSuchTranslationException;

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the translation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the translation that was removed
	 */
	public Translation removeByUUID_G(String uuid, long groupId)
		throws NoSuchTranslationException;

	/**
	 * Returns the number of translations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching translations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the translations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching translations
	 */
	public java.util.List<Translation> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the first translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

	/**
	 * Returns the last translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the last translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Removes all the translations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of translations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching translations
	 */
	public int countByUuid_C(String uuid, long companyId);

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
	public Translation findByGroupModelNameColumnNameLangCode(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode)
		throws NoSuchTranslationException;

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
	public Translation fetchByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode);

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
	public Translation fetchByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, boolean useFinderCache);

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
	public Translation removeByGroupModelNameColumnNameLangCode(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode)
		throws NoSuchTranslationException;

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
	public int countByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode);

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
	public Translation findByGroupModelNameColumnNameLangCodeRecordId(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode, long recordId)
		throws NoSuchTranslationException;

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
	public Translation fetchByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId);

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
	public Translation fetchByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId, boolean useFinderCache);

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
	public Translation removeByGroupModelNameColumnNameLangCodeRecordId(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode, long recordId)
		throws NoSuchTranslationException;

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
	public int countByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId);

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
	public Translation findByAssessmentHistoryUseOnly(
			long groupId, String modelName, String columnName,
			String languageCode, long recordId)
		throws NoSuchTranslationException;

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
	public Translation fetchByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId);

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
	public Translation fetchByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId, boolean useFinderCache);

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
	public Translation removeByAssessmentHistoryUseOnly(
			long groupId, String modelName, String columnName,
			String languageCode, long recordId)
		throws NoSuchTranslationException;

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
	public int countByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId);

	/**
	 * Returns all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @return the matching translations
	 */
	public java.util.List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId);

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
	public java.util.List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end);

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
	public java.util.List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

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
	public Translation findByGroupModelNameRecordId_First(
			long groupId, boolean deleted, String modelName, long recordId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

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
	public Translation fetchByGroupModelNameRecordId_First(
		long groupId, boolean deleted, String modelName, long recordId,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation findByGroupModelNameRecordId_Last(
			long groupId, boolean deleted, String modelName, long recordId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

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
	public Translation fetchByGroupModelNameRecordId_Last(
		long groupId, boolean deleted, String modelName, long recordId,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation[] findByGroupModelNameRecordId_PrevAndNext(
			long id, long groupId, boolean deleted, String modelName,
			long recordId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Removes all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 */
	public void removeByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId);

	/**
	 * Returns the number of translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @return the number of matching translations
	 */
	public int countByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId);

	/**
	 * Caches the translation in the entity cache if it is enabled.
	 *
	 * @param translation the translation
	 */
	public void cacheResult(Translation translation);

	/**
	 * Caches the translations in the entity cache if it is enabled.
	 *
	 * @param translations the translations
	 */
	public void cacheResult(java.util.List<Translation> translations);

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param id the primary key for the new translation
	 * @return the new translation
	 */
	public Translation create(long id);

	/**
	 * Removes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the translation
	 * @return the translation that was removed
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public Translation remove(long id) throws NoSuchTranslationException;

	public Translation updateImpl(Translation translation);

	/**
	 * Returns the translation with the primary key or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param id the primary key of the translation
	 * @return the translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public Translation findByPrimaryKey(long id)
		throws NoSuchTranslationException;

	/**
	 * Returns the translation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the translation
	 * @return the translation, or <code>null</code> if a translation with the primary key could not be found
	 */
	public Translation fetchByPrimaryKey(long id);

	/**
	 * Returns all the translations.
	 *
	 * @return the translations
	 */
	public java.util.List<Translation> findAll();

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
	public java.util.List<Translation> findAll(int start, int end);

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
	public java.util.List<Translation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the translations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	public int countAll();

}