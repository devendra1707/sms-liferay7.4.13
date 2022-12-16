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

package com.armantec.lms.common.util.services.service.impl;

import com.armantec.lms.common.util.services.model.Translation;
import com.armantec.lms.common.util.services.service.base.TranslationServiceBaseImpl;
import com.armantec.lms.constants.SearchConstants;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;
import java.util.Locale;
/**
 * The implementation of the translation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.armantec.lms.common.util.services.service.TranslationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TranslationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=lms",
		"json.web.service.context.path=Translation"
	},
	service = AopService.class
)
public class TranslationServiceImpl extends TranslationServiceBaseImpl {
	
	public JSONArray getSupportedLocales() throws SystemException, PortalException{
		return  translationLocalService.getSupportedLocales();
	}
	
	public JSONObject getDefaultJson() throws SystemException, PortalException{
		return  translationLocalService.getDefaultJson();
	}
	public String getDefault() throws SystemException, PortalException{
		return  translationLocalService.getDefault();
	}
	public Locale getDefaultLocale() {
		return  translationLocalService.getDefaultLocale();
	}
	public JSONArray searchTopics(String searchKey,ServiceContext serviceContext) {
		return translationLocalService.searchTopics(searchKey,serviceContext);
	}
	
	public String backgroundTaskCleanUp() throws PortalException {
		return translationLocalService.backgroundTaskCleanUp();
	}
	
	public String backgroundTaskCleanUp(long backgroundTaskId) throws PortalException {
		return translationLocalService.backgroundTaskCleanUp(backgroundTaskId);
	}

	public String backgroundTaskUnLock(String taskExecutorClassName) throws PortalException {
		return translationLocalService.backgroundTaskUnLock(taskExecutorClassName);
	}
}