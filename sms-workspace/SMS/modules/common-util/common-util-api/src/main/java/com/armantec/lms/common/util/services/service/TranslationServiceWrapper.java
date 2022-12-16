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
 * Provides a wrapper for {@link TranslationService}.
 *
 * @author Brian Wing Shun Chan
 * @see TranslationService
 * @generated
 */
public class TranslationServiceWrapper
	implements ServiceWrapper<TranslationService>, TranslationService {

	public TranslationServiceWrapper() {
		this(null);
	}

	public TranslationServiceWrapper(TranslationService translationService) {
		_translationService = translationService;
	}

	@Override
	public String backgroundTaskCleanUp()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationService.backgroundTaskCleanUp();
	}

	@Override
	public String backgroundTaskCleanUp(long backgroundTaskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationService.backgroundTaskCleanUp(backgroundTaskId);
	}

	@Override
	public String backgroundTaskUnLock(String taskExecutorClassName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationService.backgroundTaskUnLock(taskExecutorClassName);
	}

	@Override
	public String getDefault()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _translationService.getDefault();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getDefaultJson()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _translationService.getDefaultJson();
	}

	@Override
	public java.util.Locale getDefaultLocale() {
		return _translationService.getDefaultLocale();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _translationService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getSupportedLocales()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return _translationService.getSupportedLocales();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray searchTopics(
		String searchKey,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _translationService.searchTopics(searchKey, serviceContext);
	}

	@Override
	public TranslationService getWrappedService() {
		return _translationService;
	}

	@Override
	public void setWrappedService(TranslationService translationService) {
		_translationService = translationService;
	}

	private TranslationService _translationService;

}