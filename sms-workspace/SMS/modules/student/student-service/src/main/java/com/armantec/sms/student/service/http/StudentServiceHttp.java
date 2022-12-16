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

package com.armantec.sms.student.service.http;

import com.armantec.sms.student.service.StudentServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>StudentServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentServiceHttp {

	public static com.armantec.sms.student.model.Student create(
		HttpPrincipal httpPrincipal, String name, String email, String address,
		long branchId, int semester, java.util.Date doj) {

		try {
			MethodKey methodKey = new MethodKey(
				StudentServiceUtil.class, "create", _createParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, name, email, address, branchId, semester, doj);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.armantec.sms.student.model.Student)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.armantec.sms.student.model.Student update(
			HttpPrincipal httpPrincipal, long id, String name, String email,
			String address, long branchId, int semester, java.util.Date doj)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		try {
			MethodKey methodKey = new MethodKey(
				StudentServiceUtil.class, "update", _updateParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, name, email, address, branchId, semester, doj);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.armantec.sms.student.exception.
							NoSuchStudentException) {

					throw (com.armantec.sms.student.exception.
						NoSuchStudentException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.armantec.sms.student.model.Student)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.armantec.sms.student.model.Student> find(
			HttpPrincipal httpPrincipal, long branchId)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		try {
			MethodKey methodKey = new MethodKey(
				StudentServiceUtil.class, "find", _findParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, branchId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.armantec.sms.student.exception.
							NoSuchStudentException) {

					throw (com.armantec.sms.student.exception.
						NoSuchStudentException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.armantec.sms.student.model.Student>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.armantec.sms.student.model.Student>
		findAll(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				StudentServiceUtil.class, "findAll", _findAllParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.armantec.sms.student.model.Student>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.armantec.sms.student.model.Student delete(
			HttpPrincipal httpPrincipal, long id)
		throws com.armantec.sms.student.exception.NoSuchStudentException {

		try {
			MethodKey methodKey = new MethodKey(
				StudentServiceUtil.class, "delete", _deleteParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.armantec.sms.student.exception.
							NoSuchStudentException) {

					throw (com.armantec.sms.student.exception.
						NoSuchStudentException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.armantec.sms.student.model.Student)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(StudentServiceHttp.class);

	private static final Class<?>[] _createParameterTypes0 = new Class[] {
		String.class, String.class, String.class, long.class, int.class,
		java.util.Date.class
	};
	private static final Class<?>[] _updateParameterTypes1 = new Class[] {
		long.class, String.class, String.class, String.class, long.class,
		int.class, java.util.Date.class
	};
	private static final Class<?>[] _findParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findAllParameterTypes3 = new Class[] {};
	private static final Class<?>[] _deleteParameterTypes4 = new Class[] {
		long.class
	};

}