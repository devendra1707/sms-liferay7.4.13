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
 * Provides a wrapper for {@link ZipUtilsServiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ZipUtilsServiceLocalService
 * @generated
 */
public class ZipUtilsServiceLocalServiceWrapper
	implements ServiceWrapper<ZipUtilsServiceLocalService>,
			   ZipUtilsServiceLocalService {

	public ZipUtilsServiceLocalServiceWrapper() {
		this(null);
	}

	public ZipUtilsServiceLocalServiceWrapper(
		ZipUtilsServiceLocalService zipUtilsServiceLocalService) {

		_zipUtilsServiceLocalService = zipUtilsServiceLocalService;
	}

	@Override
	public java.util.ArrayList<java.io.File> extractZip(
		String fileName, String outputDir) {

		return _zipUtilsServiceLocalService.extractZip(fileName, outputDir);
	}

	@Override
	public void generateFileList(java.io.File node, String sourseFolder) {
		_zipUtilsServiceLocalService.generateFileList(node, sourseFolder);
	}

	@Override
	public String getAssessmentZipPath() {
		return _zipUtilsServiceLocalService.getAssessmentZipPath();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _zipUtilsServiceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public String unzip(String zipFilePath, String destDir)
		throws java.io.IOException {

		return _zipUtilsServiceLocalService.unzip(zipFilePath, destDir);
	}

	@Override
	public void zipIt(String zipFile, String sourceFolder)
		throws java.io.IOException {

		_zipUtilsServiceLocalService.zipIt(zipFile, sourceFolder);
	}

	@Override
	public ZipUtilsServiceLocalService getWrappedService() {
		return _zipUtilsServiceLocalService;
	}

	@Override
	public void setWrappedService(
		ZipUtilsServiceLocalService zipUtilsServiceLocalService) {

		_zipUtilsServiceLocalService = zipUtilsServiceLocalService;
	}

	private ZipUtilsServiceLocalService _zipUtilsServiceLocalService;

}