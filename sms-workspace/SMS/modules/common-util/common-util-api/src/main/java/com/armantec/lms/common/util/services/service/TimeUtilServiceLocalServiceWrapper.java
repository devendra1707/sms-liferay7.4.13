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
 * Provides a wrapper for {@link TimeUtilServiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TimeUtilServiceLocalService
 * @generated
 */
public class TimeUtilServiceLocalServiceWrapper
	implements ServiceWrapper<TimeUtilServiceLocalService>,
			   TimeUtilServiceLocalService {

	public TimeUtilServiceLocalServiceWrapper() {
		this(null);
	}

	public TimeUtilServiceLocalServiceWrapper(
		TimeUtilServiceLocalService timeUtilServiceLocalService) {

		_timeUtilServiceLocalService = timeUtilServiceLocalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _timeUtilServiceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public String getTime(long remainingTrial) {
		return _timeUtilServiceLocalService.getTime(remainingTrial);
	}

	@Override
	public TimeUtilServiceLocalService getWrappedService() {
		return _timeUtilServiceLocalService;
	}

	@Override
	public void setWrappedService(
		TimeUtilServiceLocalService timeUtilServiceLocalService) {

		_timeUtilServiceLocalService = timeUtilServiceLocalService;
	}

	private TimeUtilServiceLocalService _timeUtilServiceLocalService;

}