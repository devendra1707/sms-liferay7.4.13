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

package com.armantec.lms.common.util.services.service.persistence.impl;

import com.armantec.lms.common.util.services.exception.NoSuchTranslationException;
import com.armantec.lms.common.util.services.model.Translation;
import com.armantec.lms.common.util.services.model.TranslationTable;
import com.armantec.lms.common.util.services.model.impl.TranslationImpl;
import com.armantec.lms.common.util.services.model.impl.TranslationModelImpl;
import com.armantec.lms.common.util.services.service.persistence.TranslationPersistence;
import com.armantec.lms.common.util.services.service.persistence.TranslationUtil;
import com.armantec.lms.common.util.services.service.persistence.impl.constants.lms_commonPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the translation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {TranslationPersistence.class, BasePersistence.class})
public class TranslationPersistenceImpl
	extends BasePersistenceImpl<Translation> implements TranslationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TranslationUtil</code> to access the translation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TranslationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the translations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching translations
	 */
	@Override
	public List<Translation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Translation> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Translation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Translation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Translation translation : list) {
					if (!uuid.equals(translation.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByUuid_First(
			String uuid, OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByUuid_First(uuid, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the first translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByUuid_First(
		String uuid, OrderByComparator<Translation> orderByComparator) {

		List<Translation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByUuid_Last(
			String uuid, OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByUuid_Last(uuid, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the last translation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByUuid_Last(
		String uuid, OrderByComparator<Translation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Translation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Translation[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		uuid = Objects.toString(uuid, "");

		Translation translation = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, translation, uuid, orderByComparator, true);

			array[1] = translation;

			array[2] = getByUuid_PrevAndNext(
				session, translation, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation getByUuid_PrevAndNext(
		Session session, Translation translation, String uuid,
		OrderByComparator<Translation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRANSLATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TranslationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the translations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Translation translation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(translation);
		}
	}

	/**
	 * Returns the number of translations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching translations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"translation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(translation.uuid IS NULL OR translation.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByUUID_G(String uuid, long groupId)
		throws NoSuchTranslationException {

		Translation translation = fetchByUUID_G(uuid, groupId);

		if (translation == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTranslationException(sb.toString());
		}

		return translation;
	}

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the translation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof Translation) {
			Translation translation = (Translation)result;

			if (!Objects.equals(uuid, translation.getUuid()) ||
				(groupId != translation.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Translation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Translation translation = list.get(0);

					result = translation;

					cacheResult(translation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Translation)result;
		}
	}

	/**
	 * Removes the translation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the translation that was removed
	 */
	@Override
	public Translation removeByUUID_G(String uuid, long groupId)
		throws NoSuchTranslationException {

		Translation translation = findByUUID_G(uuid, groupId);

		return remove(translation);
	}

	/**
	 * Returns the number of translations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching translations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"translation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(translation.uuid IS NULL OR translation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"translation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the translations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching translations
	 */
	@Override
	public List<Translation> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Translation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Translation translation : list) {
					if (!uuid.equals(translation.getUuid()) ||
						(companyId != translation.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Translation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the first translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Translation> orderByComparator) {

		List<Translation> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Translation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the last translation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Translation> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Translation> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Translation[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		uuid = Objects.toString(uuid, "");

		Translation translation = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, translation, uuid, companyId, orderByComparator, true);

			array[1] = translation;

			array[2] = getByUuid_C_PrevAndNext(
				session, translation, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation getByUuid_C_PrevAndNext(
		Session session, Translation translation, String uuid, long companyId,
		OrderByComparator<Translation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRANSLATION_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TranslationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the translations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Translation translation :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(translation);
		}
	}

	/**
	 * Returns the number of translations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching translations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"translation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(translation.uuid IS NULL OR translation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"translation.companyId = ?";

	private FinderPath _finderPathFetchByGroupModelNameColumnNameLangCode;
	private FinderPath _finderPathCountByGroupModelNameColumnNameLangCode;

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
	@Override
	public Translation findByGroupModelNameColumnNameLangCode(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode)
		throws NoSuchTranslationException {

		Translation translation = fetchByGroupModelNameColumnNameLangCode(
			groupId, deleted, modelName, columnName, languageCode);

		if (translation == null) {
			StringBundler sb = new StringBundler(12);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", deleted=");
			sb.append(deleted);

			sb.append(", modelName=");
			sb.append(modelName);

			sb.append(", columnName=");
			sb.append(columnName);

			sb.append(", languageCode=");
			sb.append(languageCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTranslationException(sb.toString());
		}

		return translation;
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
	@Override
	public Translation fetchByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode) {

		return fetchByGroupModelNameColumnNameLangCode(
			groupId, deleted, modelName, columnName, languageCode, true);
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
	@Override
	public Translation fetchByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, boolean useFinderCache) {

		modelName = Objects.toString(modelName, "");
		columnName = Objects.toString(columnName, "");
		languageCode = Objects.toString(languageCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, deleted, modelName, columnName, languageCode
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGroupModelNameColumnNameLangCode, finderArgs);
		}

		if (result instanceof Translation) {
			Translation translation = (Translation)result;

			if ((groupId != translation.getGroupId()) ||
				(deleted != translation.isDeleted()) ||
				!Objects.equals(modelName, translation.getModelName()) ||
				!Objects.equals(columnName, translation.getColumnName()) ||
				!Objects.equals(languageCode, translation.getLanguageCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(7);

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_GROUPID_2);

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_DELETED_2);

			boolean bindModelName = false;

			if (modelName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_MODELNAME_3);
			}
			else {
				bindModelName = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_MODELNAME_2);
			}

			boolean bindColumnName = false;

			if (columnName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_COLUMNNAME_3);
			}
			else {
				bindColumnName = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_COLUMNNAME_2);
			}

			boolean bindLanguageCode = false;

			if (languageCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_LANGUAGECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deleted);

				if (bindModelName) {
					queryPos.add(modelName);
				}

				if (bindColumnName) {
					queryPos.add(columnName);
				}

				if (bindLanguageCode) {
					queryPos.add(languageCode);
				}

				List<Translation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGroupModelNameColumnNameLangCode,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, deleted, modelName, columnName,
									languageCode
								};
							}

							_log.warn(
								"TranslationPersistenceImpl.fetchByGroupModelNameColumnNameLangCode(long, boolean, String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Translation translation = list.get(0);

					result = translation;

					cacheResult(translation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Translation)result;
		}
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
	@Override
	public Translation removeByGroupModelNameColumnNameLangCode(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode)
		throws NoSuchTranslationException {

		Translation translation = findByGroupModelNameColumnNameLangCode(
			groupId, deleted, modelName, columnName, languageCode);

		return remove(translation);
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
	@Override
	public int countByGroupModelNameColumnNameLangCode(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode) {

		modelName = Objects.toString(modelName, "");
		columnName = Objects.toString(columnName, "");
		languageCode = Objects.toString(languageCode, "");

		FinderPath finderPath =
			_finderPathCountByGroupModelNameColumnNameLangCode;

		Object[] finderArgs = new Object[] {
			groupId, deleted, modelName, columnName, languageCode
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_GROUPID_2);

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_DELETED_2);

			boolean bindModelName = false;

			if (modelName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_MODELNAME_3);
			}
			else {
				bindModelName = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_MODELNAME_2);
			}

			boolean bindColumnName = false;

			if (columnName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_COLUMNNAME_3);
			}
			else {
				bindColumnName = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_COLUMNNAME_2);
			}

			boolean bindLanguageCode = false;

			if (languageCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_LANGUAGECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deleted);

				if (bindModelName) {
					queryPos.add(modelName);
				}

				if (bindColumnName) {
					queryPos.add(columnName);
				}

				if (bindLanguageCode) {
					queryPos.add(languageCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_GROUPID_2 =
			"translation.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_DELETED_2 =
			"translation.deleted = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_MODELNAME_2 =
			"translation.modelName = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_MODELNAME_3 =
			"(translation.modelName IS NULL OR translation.modelName = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_COLUMNNAME_2 =
			"translation.columnName = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_COLUMNNAME_3 =
			"(translation.columnName IS NULL OR translation.columnName = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_LANGUAGECODE_2 =
			"translation.languageCode = ?";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODE_LANGUAGECODE_3 =
			"(translation.languageCode IS NULL OR translation.languageCode = '')";

	private FinderPath
		_finderPathFetchByGroupModelNameColumnNameLangCodeRecordId;
	private FinderPath
		_finderPathCountByGroupModelNameColumnNameLangCodeRecordId;

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
	@Override
	public Translation findByGroupModelNameColumnNameLangCodeRecordId(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode, long recordId)
		throws NoSuchTranslationException {

		Translation translation =
			fetchByGroupModelNameColumnNameLangCodeRecordId(
				groupId, deleted, modelName, columnName, languageCode,
				recordId);

		if (translation == null) {
			StringBundler sb = new StringBundler(14);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", deleted=");
			sb.append(deleted);

			sb.append(", modelName=");
			sb.append(modelName);

			sb.append(", columnName=");
			sb.append(columnName);

			sb.append(", languageCode=");
			sb.append(languageCode);

			sb.append(", recordId=");
			sb.append(recordId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTranslationException(sb.toString());
		}

		return translation;
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
	@Override
	public Translation fetchByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId) {

		return fetchByGroupModelNameColumnNameLangCodeRecordId(
			groupId, deleted, modelName, columnName, languageCode, recordId,
			true);
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
	@Override
	public Translation fetchByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId, boolean useFinderCache) {

		modelName = Objects.toString(modelName, "");
		columnName = Objects.toString(columnName, "");
		languageCode = Objects.toString(languageCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, deleted, modelName, columnName, languageCode, recordId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGroupModelNameColumnNameLangCodeRecordId,
				finderArgs);
		}

		if (result instanceof Translation) {
			Translation translation = (Translation)result;

			if ((groupId != translation.getGroupId()) ||
				(deleted != translation.isDeleted()) ||
				!Objects.equals(modelName, translation.getModelName()) ||
				!Objects.equals(columnName, translation.getColumnName()) ||
				!Objects.equals(languageCode, translation.getLanguageCode()) ||
				(recordId != translation.getRecordId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_GROUPID_2);

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_DELETED_2);

			boolean bindModelName = false;

			if (modelName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_MODELNAME_3);
			}
			else {
				bindModelName = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_MODELNAME_2);
			}

			boolean bindColumnName = false;

			if (columnName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_COLUMNNAME_3);
			}
			else {
				bindColumnName = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_COLUMNNAME_2);
			}

			boolean bindLanguageCode = false;

			if (languageCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_LANGUAGECODE_2);
			}

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_RECORDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deleted);

				if (bindModelName) {
					queryPos.add(modelName);
				}

				if (bindColumnName) {
					queryPos.add(columnName);
				}

				if (bindLanguageCode) {
					queryPos.add(languageCode);
				}

				queryPos.add(recordId);

				List<Translation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGroupModelNameColumnNameLangCodeRecordId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, deleted, modelName, columnName,
									languageCode, recordId
								};
							}

							_log.warn(
								"TranslationPersistenceImpl.fetchByGroupModelNameColumnNameLangCodeRecordId(long, boolean, String, String, String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Translation translation = list.get(0);

					result = translation;

					cacheResult(translation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Translation)result;
		}
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
	@Override
	public Translation removeByGroupModelNameColumnNameLangCodeRecordId(
			long groupId, boolean deleted, String modelName, String columnName,
			String languageCode, long recordId)
		throws NoSuchTranslationException {

		Translation translation =
			findByGroupModelNameColumnNameLangCodeRecordId(
				groupId, deleted, modelName, columnName, languageCode,
				recordId);

		return remove(translation);
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
	@Override
	public int countByGroupModelNameColumnNameLangCodeRecordId(
		long groupId, boolean deleted, String modelName, String columnName,
		String languageCode, long recordId) {

		modelName = Objects.toString(modelName, "");
		columnName = Objects.toString(columnName, "");
		languageCode = Objects.toString(languageCode, "");

		FinderPath finderPath =
			_finderPathCountByGroupModelNameColumnNameLangCodeRecordId;

		Object[] finderArgs = new Object[] {
			groupId, deleted, modelName, columnName, languageCode, recordId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(7);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_GROUPID_2);

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_DELETED_2);

			boolean bindModelName = false;

			if (modelName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_MODELNAME_3);
			}
			else {
				bindModelName = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_MODELNAME_2);
			}

			boolean bindColumnName = false;

			if (columnName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_COLUMNNAME_3);
			}
			else {
				bindColumnName = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_COLUMNNAME_2);
			}

			boolean bindLanguageCode = false;

			if (languageCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				sb.append(
					_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_LANGUAGECODE_2);
			}

			sb.append(
				_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_RECORDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deleted);

				if (bindModelName) {
					queryPos.add(modelName);
				}

				if (bindColumnName) {
					queryPos.add(columnName);
				}

				if (bindLanguageCode) {
					queryPos.add(languageCode);
				}

				queryPos.add(recordId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_GROUPID_2 =
			"translation.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_DELETED_2 =
			"translation.deleted = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_MODELNAME_2 =
			"translation.modelName = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_MODELNAME_3 =
			"(translation.modelName IS NULL OR translation.modelName = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_COLUMNNAME_2 =
			"translation.columnName = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_COLUMNNAME_3 =
			"(translation.columnName IS NULL OR translation.columnName = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_LANGUAGECODE_2 =
			"translation.languageCode = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_LANGUAGECODE_3 =
			"(translation.languageCode IS NULL OR translation.languageCode = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMECOLUMNNAMELANGCODERECORDID_RECORDID_2 =
			"translation.recordId = ?";

	private FinderPath _finderPathFetchByAssessmentHistoryUseOnly;
	private FinderPath _finderPathCountByAssessmentHistoryUseOnly;

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
	@Override
	public Translation findByAssessmentHistoryUseOnly(
			long groupId, String modelName, String columnName,
			String languageCode, long recordId)
		throws NoSuchTranslationException {

		Translation translation = fetchByAssessmentHistoryUseOnly(
			groupId, modelName, columnName, languageCode, recordId);

		if (translation == null) {
			StringBundler sb = new StringBundler(12);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("groupId=");
			sb.append(groupId);

			sb.append(", modelName=");
			sb.append(modelName);

			sb.append(", columnName=");
			sb.append(columnName);

			sb.append(", languageCode=");
			sb.append(languageCode);

			sb.append(", recordId=");
			sb.append(recordId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTranslationException(sb.toString());
		}

		return translation;
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
	@Override
	public Translation fetchByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId) {

		return fetchByAssessmentHistoryUseOnly(
			groupId, modelName, columnName, languageCode, recordId, true);
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
	@Override
	public Translation fetchByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId, boolean useFinderCache) {

		modelName = Objects.toString(modelName, "");
		columnName = Objects.toString(columnName, "");
		languageCode = Objects.toString(languageCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				groupId, modelName, columnName, languageCode, recordId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByAssessmentHistoryUseOnly, finderArgs);
		}

		if (result instanceof Translation) {
			Translation translation = (Translation)result;

			if ((groupId != translation.getGroupId()) ||
				!Objects.equals(modelName, translation.getModelName()) ||
				!Objects.equals(columnName, translation.getColumnName()) ||
				!Objects.equals(languageCode, translation.getLanguageCode()) ||
				(recordId != translation.getRecordId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(7);

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_GROUPID_2);

			boolean bindModelName = false;

			if (modelName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_MODELNAME_3);
			}
			else {
				bindModelName = true;

				sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_MODELNAME_2);
			}

			boolean bindColumnName = false;

			if (columnName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_COLUMNNAME_3);
			}
			else {
				bindColumnName = true;

				sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_COLUMNNAME_2);
			}

			boolean bindLanguageCode = false;

			if (languageCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				sb.append(
					_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_LANGUAGECODE_2);
			}

			sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_RECORDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindModelName) {
					queryPos.add(modelName);
				}

				if (bindColumnName) {
					queryPos.add(columnName);
				}

				if (bindLanguageCode) {
					queryPos.add(languageCode);
				}

				queryPos.add(recordId);

				List<Translation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByAssessmentHistoryUseOnly,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									groupId, modelName, columnName,
									languageCode, recordId
								};
							}

							_log.warn(
								"TranslationPersistenceImpl.fetchByAssessmentHistoryUseOnly(long, String, String, String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Translation translation = list.get(0);

					result = translation;

					cacheResult(translation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Translation)result;
		}
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
	@Override
	public Translation removeByAssessmentHistoryUseOnly(
			long groupId, String modelName, String columnName,
			String languageCode, long recordId)
		throws NoSuchTranslationException {

		Translation translation = findByAssessmentHistoryUseOnly(
			groupId, modelName, columnName, languageCode, recordId);

		return remove(translation);
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
	@Override
	public int countByAssessmentHistoryUseOnly(
		long groupId, String modelName, String columnName, String languageCode,
		long recordId) {

		modelName = Objects.toString(modelName, "");
		columnName = Objects.toString(columnName, "");
		languageCode = Objects.toString(languageCode, "");

		FinderPath finderPath = _finderPathCountByAssessmentHistoryUseOnly;

		Object[] finderArgs = new Object[] {
			groupId, modelName, columnName, languageCode, recordId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_GROUPID_2);

			boolean bindModelName = false;

			if (modelName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_MODELNAME_3);
			}
			else {
				bindModelName = true;

				sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_MODELNAME_2);
			}

			boolean bindColumnName = false;

			if (columnName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_COLUMNNAME_3);
			}
			else {
				bindColumnName = true;

				sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_COLUMNNAME_2);
			}

			boolean bindLanguageCode = false;

			if (languageCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				sb.append(
					_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_LANGUAGECODE_2);
			}

			sb.append(_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_RECORDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindModelName) {
					queryPos.add(modelName);
				}

				if (bindColumnName) {
					queryPos.add(columnName);
				}

				if (bindLanguageCode) {
					queryPos.add(languageCode);
				}

				queryPos.add(recordId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_GROUPID_2 =
			"translation.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_MODELNAME_2 =
			"translation.modelName = ? AND ";

	private static final String
		_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_MODELNAME_3 =
			"(translation.modelName IS NULL OR translation.modelName = '') AND ";

	private static final String
		_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_COLUMNNAME_2 =
			"translation.columnName = ? AND ";

	private static final String
		_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_COLUMNNAME_3 =
			"(translation.columnName IS NULL OR translation.columnName = '') AND ";

	private static final String
		_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_LANGUAGECODE_2 =
			"translation.languageCode = ? AND ";

	private static final String
		_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_LANGUAGECODE_3 =
			"(translation.languageCode IS NULL OR translation.languageCode = '') AND ";

	private static final String
		_FINDER_COLUMN_ASSESSMENTHISTORYUSEONLY_RECORDID_2 =
			"translation.recordId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupModelNameRecordId;
	private FinderPath _finderPathWithoutPaginationFindByGroupModelNameRecordId;
	private FinderPath _finderPathCountByGroupModelNameRecordId;

	/**
	 * Returns all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 * @return the matching translations
	 */
	@Override
	public List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId) {

		return findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end) {

		return findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId, start, end, null);
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
	@Override
	public List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Translation> findByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId,
		int start, int end, OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		modelName = Objects.toString(modelName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupModelNameRecordId;
				finderArgs = new Object[] {
					groupId, deleted, modelName, recordId
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupModelNameRecordId;
			finderArgs = new Object[] {
				groupId, deleted, modelName, recordId, start, end,
				orderByComparator
			};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Translation translation : list) {
					if ((groupId != translation.getGroupId()) ||
						(deleted != translation.isDeleted()) ||
						!modelName.equals(translation.getModelName()) ||
						(recordId != translation.getRecordId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_DELETED_2);

			boolean bindModelName = false;

			if (modelName.isEmpty()) {
				sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_MODELNAME_3);
			}
			else {
				bindModelName = true;

				sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_MODELNAME_2);
			}

			sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_RECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deleted);

				if (bindModelName) {
					queryPos.add(modelName);
				}

				queryPos.add(recordId);

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Translation findByGroupModelNameRecordId_First(
			long groupId, boolean deleted, String modelName, long recordId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByGroupModelNameRecordId_First(
			groupId, deleted, modelName, recordId, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append(", modelName=");
		sb.append(modelName);

		sb.append(", recordId=");
		sb.append(recordId);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
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
	@Override
	public Translation fetchByGroupModelNameRecordId_First(
		long groupId, boolean deleted, String modelName, long recordId,
		OrderByComparator<Translation> orderByComparator) {

		List<Translation> list = findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Translation findByGroupModelNameRecordId_Last(
			long groupId, boolean deleted, String modelName, long recordId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByGroupModelNameRecordId_Last(
			groupId, deleted, modelName, recordId, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", deleted=");
		sb.append(deleted);

		sb.append(", modelName=");
		sb.append(modelName);

		sb.append(", recordId=");
		sb.append(recordId);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
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
	@Override
	public Translation fetchByGroupModelNameRecordId_Last(
		long groupId, boolean deleted, String modelName, long recordId,
		OrderByComparator<Translation> orderByComparator) {

		int count = countByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId);

		if (count == 0) {
			return null;
		}

		List<Translation> list = findByGroupModelNameRecordId(
			groupId, deleted, modelName, recordId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Translation[] findByGroupModelNameRecordId_PrevAndNext(
			long id, long groupId, boolean deleted, String modelName,
			long recordId, OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		modelName = Objects.toString(modelName, "");

		Translation translation = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = getByGroupModelNameRecordId_PrevAndNext(
				session, translation, groupId, deleted, modelName, recordId,
				orderByComparator, true);

			array[1] = translation;

			array[2] = getByGroupModelNameRecordId_PrevAndNext(
				session, translation, groupId, deleted, modelName, recordId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation getByGroupModelNameRecordId_PrevAndNext(
		Session session, Translation translation, long groupId, boolean deleted,
		String modelName, long recordId,
		OrderByComparator<Translation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_DELETED_2);

		boolean bindModelName = false;

		if (modelName.isEmpty()) {
			sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_MODELNAME_3);
		}
		else {
			bindModelName = true;

			sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_MODELNAME_2);
		}

		sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_RECORDID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TranslationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(deleted);

		if (bindModelName) {
			queryPos.add(modelName);
		}

		queryPos.add(recordId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the translations where groupId = &#63; and deleted = &#63; and modelName = &#63; and recordId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param deleted the deleted
	 * @param modelName the model name
	 * @param recordId the record ID
	 */
	@Override
	public void removeByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId) {

		for (Translation translation :
				findByGroupModelNameRecordId(
					groupId, deleted, modelName, recordId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(translation);
		}
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
	@Override
	public int countByGroupModelNameRecordId(
		long groupId, boolean deleted, String modelName, long recordId) {

		modelName = Objects.toString(modelName, "");

		FinderPath finderPath = _finderPathCountByGroupModelNameRecordId;

		Object[] finderArgs = new Object[] {
			groupId, deleted, modelName, recordId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_DELETED_2);

			boolean bindModelName = false;

			if (modelName.isEmpty()) {
				sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_MODELNAME_3);
			}
			else {
				bindModelName = true;

				sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_MODELNAME_2);
			}

			sb.append(_FINDER_COLUMN_GROUPMODELNAMERECORDID_RECORDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(deleted);

				if (bindModelName) {
					queryPos.add(modelName);
				}

				queryPos.add(recordId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMERECORDID_GROUPID_2 =
			"translation.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMERECORDID_DELETED_2 =
			"translation.deleted = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMERECORDID_MODELNAME_2 =
			"translation.modelName = ? AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMERECORDID_MODELNAME_3 =
			"(translation.modelName IS NULL OR translation.modelName = '') AND ";

	private static final String
		_FINDER_COLUMN_GROUPMODELNAMERECORDID_RECORDID_2 =
			"translation.recordId = ?";

	public TranslationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");
		dbColumnNames.put("text", "text_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Translation.class);

		setModelImplClass(TranslationImpl.class);
		setModelPKClass(long.class);

		setTable(TranslationTable.INSTANCE);
	}

	/**
	 * Caches the translation in the entity cache if it is enabled.
	 *
	 * @param translation the translation
	 */
	@Override
	public void cacheResult(Translation translation) {
		entityCache.putResult(
			TranslationImpl.class, translation.getPrimaryKey(), translation);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {translation.getUuid(), translation.getGroupId()},
			translation);

		finderCache.putResult(
			_finderPathFetchByGroupModelNameColumnNameLangCode,
			new Object[] {
				translation.getGroupId(), translation.isDeleted(),
				translation.getModelName(), translation.getColumnName(),
				translation.getLanguageCode()
			},
			translation);

		finderCache.putResult(
			_finderPathFetchByGroupModelNameColumnNameLangCodeRecordId,
			new Object[] {
				translation.getGroupId(), translation.isDeleted(),
				translation.getModelName(), translation.getColumnName(),
				translation.getLanguageCode(), translation.getRecordId()
			},
			translation);

		finderCache.putResult(
			_finderPathFetchByAssessmentHistoryUseOnly,
			new Object[] {
				translation.getGroupId(), translation.getModelName(),
				translation.getColumnName(), translation.getLanguageCode(),
				translation.getRecordId()
			},
			translation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the translations in the entity cache if it is enabled.
	 *
	 * @param translations the translations
	 */
	@Override
	public void cacheResult(List<Translation> translations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (translations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Translation translation : translations) {
			if (entityCache.getResult(
					TranslationImpl.class, translation.getPrimaryKey()) ==
						null) {

				cacheResult(translation);
			}
		}
	}

	/**
	 * Clears the cache for all translations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TranslationImpl.class);

		finderCache.clearCache(TranslationImpl.class);
	}

	/**
	 * Clears the cache for the translation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Translation translation) {
		entityCache.removeResult(TranslationImpl.class, translation);
	}

	@Override
	public void clearCache(List<Translation> translations) {
		for (Translation translation : translations) {
			entityCache.removeResult(TranslationImpl.class, translation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TranslationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TranslationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TranslationModelImpl translationModelImpl) {

		Object[] args = new Object[] {
			translationModelImpl.getUuid(), translationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, translationModelImpl);

		args = new Object[] {
			translationModelImpl.getGroupId(), translationModelImpl.isDeleted(),
			translationModelImpl.getModelName(),
			translationModelImpl.getColumnName(),
			translationModelImpl.getLanguageCode()
		};

		finderCache.putResult(
			_finderPathCountByGroupModelNameColumnNameLangCode, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByGroupModelNameColumnNameLangCode, args,
			translationModelImpl);

		args = new Object[] {
			translationModelImpl.getGroupId(), translationModelImpl.isDeleted(),
			translationModelImpl.getModelName(),
			translationModelImpl.getColumnName(),
			translationModelImpl.getLanguageCode(),
			translationModelImpl.getRecordId()
		};

		finderCache.putResult(
			_finderPathCountByGroupModelNameColumnNameLangCodeRecordId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByGroupModelNameColumnNameLangCodeRecordId, args,
			translationModelImpl);

		args = new Object[] {
			translationModelImpl.getGroupId(),
			translationModelImpl.getModelName(),
			translationModelImpl.getColumnName(),
			translationModelImpl.getLanguageCode(),
			translationModelImpl.getRecordId()
		};

		finderCache.putResult(
			_finderPathCountByAssessmentHistoryUseOnly, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByAssessmentHistoryUseOnly, args,
			translationModelImpl);
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param id the primary key for the new translation
	 * @return the new translation
	 */
	@Override
	public Translation create(long id) {
		Translation translation = new TranslationImpl();

		translation.setNew(true);
		translation.setPrimaryKey(id);

		String uuid = _portalUUID.generate();

		translation.setUuid(uuid);

		translation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return translation;
	}

	/**
	 * Removes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the translation
	 * @return the translation that was removed
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation remove(long id) throws NoSuchTranslationException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the translation
	 * @return the translation that was removed
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation remove(Serializable primaryKey)
		throws NoSuchTranslationException {

		Session session = null;

		try {
			session = openSession();

			Translation translation = (Translation)session.get(
				TranslationImpl.class, primaryKey);

			if (translation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTranslationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(translation);
		}
		catch (NoSuchTranslationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Translation removeImpl(Translation translation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(translation)) {
				translation = (Translation)session.get(
					TranslationImpl.class, translation.getPrimaryKeyObj());
			}

			if (translation != null) {
				session.delete(translation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (translation != null) {
			clearCache(translation);
		}

		return translation;
	}

	@Override
	public Translation updateImpl(Translation translation) {
		boolean isNew = translation.isNew();

		if (!(translation instanceof TranslationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(translation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(translation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in translation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Translation implementation " +
					translation.getClass());
		}

		TranslationModelImpl translationModelImpl =
			(TranslationModelImpl)translation;

		if (Validator.isNull(translation.getUuid())) {
			String uuid = _portalUUID.generate();

			translation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (translation.getCreateDate() == null)) {
			if (serviceContext == null) {
				translation.setCreateDate(date);
			}
			else {
				translation.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!translationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				translation.setModifiedDate(date);
			}
			else {
				translation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(translation);
			}
			else {
				translation = (Translation)session.merge(translation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TranslationImpl.class, translationModelImpl, false, true);

		cacheUniqueFindersCache(translationModelImpl);

		if (isNew) {
			translation.setNew(false);
		}

		translation.resetOriginalValues();

		return translation;
	}

	/**
	 * Returns the translation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the translation
	 * @return the translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTranslationException {

		Translation translation = fetchByPrimaryKey(primaryKey);

		if (translation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTranslationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return translation;
	}

	/**
	 * Returns the translation with the primary key or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param id the primary key of the translation
	 * @return the translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation findByPrimaryKey(long id)
		throws NoSuchTranslationException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the translation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the translation
	 * @return the translation, or <code>null</code> if a translation with the primary key could not be found
	 */
	@Override
	public Translation fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the translations.
	 *
	 * @return the translations
	 */
	@Override
	public List<Translation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Translation> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Translation> findAll(
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Translation> findAll(
		int start, int end, OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRANSLATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSLATION;

				sql = sql.concat(TranslationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the translations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Translation translation : findAll()) {
			remove(translation);
		}
	}

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TRANSLATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRANSLATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TranslationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the translation persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByGroupModelNameColumnNameLangCode = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGroupModelNameColumnNameLangCode",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {
				"groupId", "deleted", "modelName", "columnName", "languageCode"
			},
			true);

		_finderPathCountByGroupModelNameColumnNameLangCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupModelNameColumnNameLangCode",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {
				"groupId", "deleted", "modelName", "columnName", "languageCode"
			},
			false);

		_finderPathFetchByGroupModelNameColumnNameLangCodeRecordId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByGroupModelNameColumnNameLangCodeRecordId",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					String.class.getName(), String.class.getName(),
					String.class.getName(), Long.class.getName()
				},
				new String[] {
					"groupId", "deleted", "modelName", "columnName",
					"languageCode", "recordId"
				},
				true);

		_finderPathCountByGroupModelNameColumnNameLangCodeRecordId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByGroupModelNameColumnNameLangCodeRecordId",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					String.class.getName(), String.class.getName(),
					String.class.getName(), Long.class.getName()
				},
				new String[] {
					"groupId", "deleted", "modelName", "columnName",
					"languageCode", "recordId"
				},
				false);

		_finderPathFetchByAssessmentHistoryUseOnly = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAssessmentHistoryUseOnly",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {
				"groupId", "modelName", "columnName", "languageCode", "recordId"
			},
			true);

		_finderPathCountByAssessmentHistoryUseOnly = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAssessmentHistoryUseOnly",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			new String[] {
				"groupId", "modelName", "columnName", "languageCode", "recordId"
			},
			false);

		_finderPathWithPaginationFindByGroupModelNameRecordId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupModelNameRecordId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "deleted", "modelName", "recordId"}, true);

		_finderPathWithoutPaginationFindByGroupModelNameRecordId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroupModelNameRecordId",
				new String[] {
					Long.class.getName(), Boolean.class.getName(),
					String.class.getName(), Long.class.getName()
				},
				new String[] {"groupId", "deleted", "modelName", "recordId"},
				true);

		_finderPathCountByGroupModelNameRecordId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupModelNameRecordId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				String.class.getName(), Long.class.getName()
			},
			new String[] {"groupId", "deleted", "modelName", "recordId"},
			false);

		_setTranslationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTranslationUtilPersistence(null);

		entityCache.removeCache(TranslationImpl.class.getName());
	}

	private void _setTranslationUtilPersistence(
		TranslationPersistence translationPersistence) {

		try {
			Field field = TranslationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, translationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = lms_commonPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = lms_commonPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = lms_commonPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TRANSLATION =
		"SELECT translation FROM Translation translation";

	private static final String _SQL_SELECT_TRANSLATION_WHERE =
		"SELECT translation FROM Translation translation WHERE ";

	private static final String _SQL_COUNT_TRANSLATION =
		"SELECT COUNT(translation) FROM Translation translation";

	private static final String _SQL_COUNT_TRANSLATION_WHERE =
		"SELECT COUNT(translation) FROM Translation translation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "translation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Translation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Translation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TranslationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id", "text"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private TranslationModelArgumentsResolver
		_translationModelArgumentsResolver;

}