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

/**
 * Provides the remote service utility for Translation. This utility wraps
 * <code>com.armantec.lms.common.util.services.service.impl.TranslationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TranslationService
 * @generated
 */
public class TranslationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.armantec.lms.common.util.services.service.impl.TranslationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
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

	public static String getDefault() throws PortalException, SystemException {
		return getService().getDefault();
	}

	public static com.liferay.portal.kernel.json.JSONObject getDefaultJson()
		throws PortalException, SystemException {

		return getService().getDefaultJson();
	}

	public static java.util.Locale getDefaultLocale() {
		return getService().getDefaultLocale();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONArray getSupportedLocales()
		throws PortalException, SystemException {

		return getService().getSupportedLocales();
	}

	public static com.liferay.portal.kernel.json.JSONArray searchTopics(
		String searchKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().searchTopics(searchKey, serviceContext);
	}

	public static TranslationService getService() {
		return _service;
	}

	private static volatile TranslationService _service;

}