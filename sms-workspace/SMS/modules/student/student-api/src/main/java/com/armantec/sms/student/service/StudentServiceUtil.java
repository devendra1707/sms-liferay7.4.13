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

package com.armantec.sms.student.service;

import com.armantec.sms.student.model.Student;

import java.util.List;

/**
 * Provides the remote service utility for Student. This utility wraps
 * <code>com.armantec.sms.student.service.impl.StudentServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StudentService
 * @generated
 */
public class StudentServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.armantec.sms.student.service.impl.StudentServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Student create(
		String name, String email, String address, long branchId, int semester,
		java.util.Date doj) {

		return getService().create(
			name, email, address, branchId, semester, doj);
	}

	public static Student delete(long id)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		return getService().delete(id);
	}

	public static List<Student> find(long branchId)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		return getService().find(branchId);
	}

	public static List<Student> findAll() {
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

	public static Student update(
			long id, String name, String email, String address, long branchId,
			int semester, java.util.Date doj)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		return getService().update(
			id, name, email, address, branchId, semester, doj);
	}

	public static StudentService getService() {
		return _service;
	}

	private static volatile StudentService _service;

}