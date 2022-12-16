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

package com.armantec.sms.branch.service.impl;

import com.armantec.sms.branch.exception.NoSuchBranchException;
import com.armantec.sms.branch.model.Branch;
import com.armantec.sms.branch.service.base.BranchServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=sms",
		"json.web.service.context.path=Branch" }, service = AopService.class)
public class BranchServiceImpl extends BranchServiceBaseImpl {

	// Create Branch

	public Branch create(String name, String code, int numberOfSeat) {
		return branchLocalService.create(name, code, numberOfSeat);
	}

	// Update Branch

	public Branch update(long id, String name, String code, int numberOfSeat) throws NoSuchBranchException {
		return branchLocalService.update(id, name, code, numberOfSeat);
	}

	// Find All Branch

	public List<Branch> findAll() {
		return branchLocalService.findAll();
	}

	// delete Branch 

	public Branch delete(long id) throws NoSuchBranchException {
		return branchLocalService.delete(id);
	}
}