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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudentService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentService
 * @generated
 */
public class StudentServiceWrapper
	implements ServiceWrapper<StudentService>, StudentService {

	public StudentServiceWrapper() {
		this(null);
	}

	public StudentServiceWrapper(StudentService studentService) {
		_studentService = studentService;
	}

	@Override
	public com.armantec.sms.student.model.Student create(
		String name, String email, String address, long branchId, int semester,
		java.util.Date doj) {

		return _studentService.create(
			name, email, address, branchId, semester, doj);
	}

	@Override
	public com.armantec.sms.student.model.Student delete(long id)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		return _studentService.delete(id);
	}

	@Override
	public java.util.List<com.armantec.sms.student.model.Student> find(
			long branchId)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		return _studentService.find(branchId);
	}

	@Override
	public java.util.List<com.armantec.sms.student.model.Student> findAll() {
		return _studentService.findAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentService.getOSGiServiceIdentifier();
	}

	@Override
	public com.armantec.sms.student.model.Student update(
			long id, String name, String email, String address, long branchId,
			int semester, java.util.Date doj)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		return _studentService.update(
			id, name, email, address, branchId, semester, doj);
	}

	@Override
	public StudentService getWrappedService() {
		return _studentService;
	}

	@Override
	public void setWrappedService(StudentService studentService) {
		_studentService = studentService;
	}

	private StudentService _studentService;

}