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
import com.armantec.sms.branch.service.base.BranchLocalServiceBaseImpl;
import com.armantec.sms.branch.service.persistence.BranchUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.armantec.sms.branch.model.Branch", service = AopService.class)
public class BranchLocalServiceImpl extends BranchLocalServiceBaseImpl {

	// Create Branch

	public Branch create(String name, String code, int numberOfSeat) {
		long id = CounterLocalServiceUtil.increment(this.getClass().getName());

		Branch branch = BranchUtil.create(id);
		branch.setName(name);
		branch.setCode(code);
		branch.setNumberOfSeat(numberOfSeat);
		return BranchUtil.update(branch);
	}

	// Update Branch

	public Branch update(long id, String name, String code, int numberOfSeat) throws NoSuchBranchException {

		Branch branch = BranchUtil.findByPrimaryKey(id);
		branch.setName(name);
		branch.setCode(code);
		branch.setNumberOfSeat(numberOfSeat);
		return BranchUtil.update(branch);

	}

	// Find All Branch

	public List<Branch> findAll() {
		List<Branch> branchList = BranchUtil.findAll();

		return branchList;
	}

	// Delete Branch

	public Branch delete(long id) throws NoSuchBranchException  {
		
		Branch branch = BranchUtil.findByPrimaryKey(id);
		branch.setDeleted(true);;
		return BranchUtil.update(branch);
	}

}