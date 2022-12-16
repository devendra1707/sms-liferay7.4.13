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

package com.armantec.sms.branch.service.http;

import com.armantec.sms.branch.service.BranchServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>BranchServiceUtil</code> service
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
public class BranchServiceHttp {

	public static com.armantec.sms.branch.model.Branch create(
		HttpPrincipal httpPrincipal, String name, String code,
		int numberOfSeat) {

		try {
			MethodKey methodKey = new MethodKey(
				BranchServiceUtil.class, "create", _createParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, name, code, numberOfSeat);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.armantec.sms.branch.model.Branch)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.armantec.sms.branch.model.Branch update(
			HttpPrincipal httpPrincipal, long id, String name, String code,
			int numberOfSeat)
		throws com.armantec.sms.branch.exception.NoSuchBranchException {

		try {
			MethodKey methodKey = new MethodKey(
				BranchServiceUtil.class, "update", _updateParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, name, code, numberOfSeat);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.armantec.sms.branch.exception.
							NoSuchBranchException) {

					throw (com.armantec.sms.branch.exception.
						NoSuchBranchException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.armantec.sms.branch.model.Branch)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.armantec.sms.branch.model.Branch> findAll(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				BranchServiceUtil.class, "findAll", _findAllParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.armantec.sms.branch.model.Branch>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.armantec.sms.branch.model.Branch delete(
			HttpPrincipal httpPrincipal, long id)
		throws com.armantec.sms.branch.exception.NoSuchBranchException {

		try {
			MethodKey methodKey = new MethodKey(
				BranchServiceUtil.class, "delete", _deleteParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.armantec.sms.branch.exception.
							NoSuchBranchException) {

					throw (com.armantec.sms.branch.exception.
						NoSuchBranchException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.armantec.sms.branch.model.Branch)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BranchServiceHttp.class);

	private static final Class<?>[] _createParameterTypes0 = new Class[] {
		String.class, String.class, int.class
	};
	private static final Class<?>[] _updateParameterTypes1 = new Class[] {
		long.class, String.class, String.class, int.class
	};
	private static final Class<?>[] _findAllParameterTypes2 = new Class[] {};
	private static final Class<?>[] _deleteParameterTypes3 = new Class[] {
		long.class
	};

}