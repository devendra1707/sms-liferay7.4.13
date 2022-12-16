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

package com.armantec.sms.branch.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Branch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Branch
 * @generated
 */
public class BranchWrapper
	extends BaseModelWrapper<Branch> implements Branch, ModelWrapper<Branch> {

	public BranchWrapper(Branch branch) {
		super(branch);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", isDeleted());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("numberOfSeat", getNumberOfSeat());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer numberOfSeat = (Integer)attributes.get("numberOfSeat");

		if (numberOfSeat != null) {
			setNumberOfSeat(numberOfSeat);
		}
	}

	@Override
	public Branch cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this branch.
	 *
	 * @return the code of this branch
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this branch.
	 *
	 * @return the company ID of this branch
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this branch.
	 *
	 * @return the create date of this branch
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this branch.
	 *
	 * @return the deleted of this branch
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this branch.
	 *
	 * @return the group ID of this branch
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this branch.
	 *
	 * @return the ID of this branch
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this branch.
	 *
	 * @return the modified date of this branch
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this branch.
	 *
	 * @return the name of this branch
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the number of seat of this branch.
	 *
	 * @return the number of seat of this branch
	 */
	@Override
	public int getNumberOfSeat() {
		return model.getNumberOfSeat();
	}

	/**
	 * Returns the primary key of this branch.
	 *
	 * @return the primary key of this branch
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this branch.
	 *
	 * @return the user ID of this branch
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this branch.
	 *
	 * @return the user name of this branch
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this branch.
	 *
	 * @return the user uuid of this branch
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this branch.
	 *
	 * @return the uuid of this branch
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this branch is deleted.
	 *
	 * @return <code>true</code> if this branch is deleted; <code>false</code> otherwise
	 */
	@Override
	public boolean isDeleted() {
		return model.isDeleted();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this branch.
	 *
	 * @param code the code of this branch
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this branch.
	 *
	 * @param companyId the company ID of this branch
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this branch.
	 *
	 * @param createDate the create date of this branch
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this branch is deleted.
	 *
	 * @param deleted the deleted of this branch
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this branch.
	 *
	 * @param groupId the group ID of this branch
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this branch.
	 *
	 * @param id the ID of this branch
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this branch.
	 *
	 * @param modifiedDate the modified date of this branch
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this branch.
	 *
	 * @param name the name of this branch
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the number of seat of this branch.
	 *
	 * @param numberOfSeat the number of seat of this branch
	 */
	@Override
	public void setNumberOfSeat(int numberOfSeat) {
		model.setNumberOfSeat(numberOfSeat);
	}

	/**
	 * Sets the primary key of this branch.
	 *
	 * @param primaryKey the primary key of this branch
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this branch.
	 *
	 * @param userId the user ID of this branch
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this branch.
	 *
	 * @param userName the user name of this branch
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this branch.
	 *
	 * @param userUuid the user uuid of this branch
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this branch.
	 *
	 * @param uuid the uuid of this branch
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected BranchWrapper wrap(Branch branch) {
		return new BranchWrapper(branch);
	}

}