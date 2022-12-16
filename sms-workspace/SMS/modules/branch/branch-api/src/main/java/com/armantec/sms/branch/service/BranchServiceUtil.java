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

package com.armantec.sms.branch.service;

import com.armantec.sms.branch.model.Branch;

import java.util.List;

/**
 * Provides the remote service utility for Branch. This utility wraps
 * <code>com.armantec.sms.branch.service.impl.BranchServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see BranchService
 * @generated
 */
public class BranchServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.armantec.sms.branch.service.impl.BranchServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Branch create(String name, String code, int numberOfSeat) {
		return getService().create(name, code, numberOfSeat);
	}

	public static Branch delete(long id)
		throws com.armantec.sms.branch.exception.NoSuchBranchException {

		return getService().delete(id);
	}

	public static List<Branch> findAll() {
		return getService().findAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Branch update(
			long id, String name, String code, int numberOfSeat)
		throws com.armantec.sms.branch.exception.NoSuchBranchException {

		return getService().update(id, name, code, numberOfSeat);
	}

	public static BranchService getService() {
		return _service;
	}

	private static volatile BranchService _service;

}