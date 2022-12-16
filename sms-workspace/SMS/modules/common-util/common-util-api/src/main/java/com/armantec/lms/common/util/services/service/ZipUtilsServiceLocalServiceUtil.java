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

/**
 * Provides the local service utility for ZipUtilsService. This utility wraps
 * <code>com.armantec.lms.common.util.services.service.impl.ZipUtilsServiceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ZipUtilsServiceLocalService
 * @generated
 */
public class ZipUtilsServiceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.armantec.lms.common.util.services.service.impl.ZipUtilsServiceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.ArrayList<java.io.File> extractZip(
		java.lang.String fileName, java.lang.String outputDir) {

		return getService().extractZip(fileName, outputDir);
	}

	public static void generateFileList(
		java.io.File node, java.lang.String sourseFolder) {

		getService().generateFileList(node, sourseFolder);
	}

	public static java.lang.String getAssessmentZipPath() {
		return getService().getAssessmentZipPath();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String unzip(
			java.lang.String zipFilePath, java.lang.String destDir)
		throws java.io.IOException {

		return getService().unzip(zipFilePath, destDir);
	}

	public static void zipIt(
			java.lang.String zipFile, java.lang.String sourceFolder)
		throws java.io.IOException {

		getService().zipIt(zipFile, sourceFolder);
	}

	public static ZipUtilsServiceLocalService getService() {
		return _service;
	}

	private static volatile ZipUtilsServiceLocalService _service;

}