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

package com.armantec.lms.common.util.services.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Translation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Translation
 * @generated
 */
public class TranslationWrapper
	extends BaseModelWrapper<Translation>
	implements ModelWrapper<Translation>, Translation {

	public TranslationWrapper(Translation translation) {
		super(translation);
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
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedByName", getModifiedByName());
		attributes.put("deleted", isDeleted());
		attributes.put("languageCode", getLanguageCode());
		attributes.put("modelName", getModelName());
		attributes.put("columnName", getColumnName());
		attributes.put("text", getText());
		attributes.put("recordId", getRecordId());

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

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		String modifiedByName = (String)attributes.get("modifiedByName");

		if (modifiedByName != null) {
			setModifiedByName(modifiedByName);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		String languageCode = (String)attributes.get("languageCode");

		if (languageCode != null) {
			setLanguageCode(languageCode);
		}

		String modelName = (String)attributes.get("modelName");

		if (modelName != null) {
			setModelName(modelName);
		}

		String columnName = (String)attributes.get("columnName");

		if (columnName != null) {
			setColumnName(columnName);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		Long recordId = (Long)attributes.get("recordId");

		if (recordId != null) {
			setRecordId(recordId);
		}
	}

	@Override
	public Translation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the column name of this translation.
	 *
	 * @return the column name of this translation
	 */
	@Override
	public String getColumnName() {
		return model.getColumnName();
	}

	/**
	 * Returns the company ID of this translation.
	 *
	 * @return the company ID of this translation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this translation.
	 *
	 * @return the create date of this translation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deleted of this translation.
	 *
	 * @return the deleted of this translation
	 */
	@Override
	public boolean getDeleted() {
		return model.getDeleted();
	}

	/**
	 * Returns the group ID of this translation.
	 *
	 * @return the group ID of this translation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this translation.
	 *
	 * @return the ID of this translation
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the language code of this translation.
	 *
	 * @return the language code of this translation
	 */
	@Override
	public String getLanguageCode() {
		return model.getLanguageCode();
	}

	/**
	 * Returns the model name of this translation.
	 *
	 * @return the model name of this translation
	 */
	@Override
	public String getModelName() {
		return model.getModelName();
	}

	/**
	 * Returns the modified by of this translation.
	 *
	 * @return the modified by of this translation
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified by name of this translation.
	 *
	 * @return the modified by name of this translation
	 */
	@Override
	public String getModifiedByName() {
		return model.getModifiedByName();
	}

	/**
	 * Returns the modified date of this translation.
	 *
	 * @return the modified date of this translation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this translation.
	 *
	 * @return the primary key of this translation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the record ID of this translation.
	 *
	 * @return the record ID of this translation
	 */
	@Override
	public long getRecordId() {
		return model.getRecordId();
	}

	/**
	 * Returns the text of this translation.
	 *
	 * @return the text of this translation
	 */
	@Override
	public String getText() {
		return model.getText();
	}

	/**
	 * Returns the user ID of this translation.
	 *
	 * @return the user ID of this translation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this translation.
	 *
	 * @return the user name of this translation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this translation.
	 *
	 * @return the user uuid of this translation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this translation.
	 *
	 * @return the uuid of this translation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this translation is deleted.
	 *
	 * @return <code>true</code> if this translation is deleted; <code>false</code> otherwise
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
	 * Sets the column name of this translation.
	 *
	 * @param columnName the column name of this translation
	 */
	@Override
	public void setColumnName(String columnName) {
		model.setColumnName(columnName);
	}

	/**
	 * Sets the company ID of this translation.
	 *
	 * @param companyId the company ID of this translation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this translation.
	 *
	 * @param createDate the create date of this translation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this translation is deleted.
	 *
	 * @param deleted the deleted of this translation
	 */
	@Override
	public void setDeleted(boolean deleted) {
		model.setDeleted(deleted);
	}

	/**
	 * Sets the group ID of this translation.
	 *
	 * @param groupId the group ID of this translation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this translation.
	 *
	 * @param id the ID of this translation
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the language code of this translation.
	 *
	 * @param languageCode the language code of this translation
	 */
	@Override
	public void setLanguageCode(String languageCode) {
		model.setLanguageCode(languageCode);
	}

	/**
	 * Sets the model name of this translation.
	 *
	 * @param modelName the model name of this translation
	 */
	@Override
	public void setModelName(String modelName) {
		model.setModelName(modelName);
	}

	/**
	 * Sets the modified by of this translation.
	 *
	 * @param modifiedBy the modified by of this translation
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified by name of this translation.
	 *
	 * @param modifiedByName the modified by name of this translation
	 */
	@Override
	public void setModifiedByName(String modifiedByName) {
		model.setModifiedByName(modifiedByName);
	}

	/**
	 * Sets the modified date of this translation.
	 *
	 * @param modifiedDate the modified date of this translation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this translation.
	 *
	 * @param primaryKey the primary key of this translation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the record ID of this translation.
	 *
	 * @param recordId the record ID of this translation
	 */
	@Override
	public void setRecordId(long recordId) {
		model.setRecordId(recordId);
	}

	/**
	 * Sets the text of this translation.
	 *
	 * @param text the text of this translation
	 */
	@Override
	public void setText(String text) {
		model.setText(text);
	}

	/**
	 * Sets the user ID of this translation.
	 *
	 * @param userId the user ID of this translation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this translation.
	 *
	 * @param userName the user name of this translation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this translation.
	 *
	 * @param userUuid the user uuid of this translation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this translation.
	 *
	 * @param uuid the uuid of this translation
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
	protected TranslationWrapper wrap(Translation translation) {
		return new TranslationWrapper(translation);
	}

}