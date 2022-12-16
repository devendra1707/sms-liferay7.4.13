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

package com.armantec.lms.common.util.services.model.impl;

import com.armantec.lms.common.util.services.model.Translation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Translation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TranslationCacheModel
	implements CacheModel<Translation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TranslationCacheModel)) {
			return false;
		}

		TranslationCacheModel translationCacheModel =
			(TranslationCacheModel)object;

		if (id == translationCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedByName=");
		sb.append(modifiedByName);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", languageCode=");
		sb.append(languageCode);
		sb.append(", modelName=");
		sb.append(modelName);
		sb.append(", columnName=");
		sb.append(columnName);
		sb.append(", text=");
		sb.append(text);
		sb.append(", recordId=");
		sb.append(recordId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Translation toEntityModel() {
		TranslationImpl translationImpl = new TranslationImpl();

		if (uuid == null) {
			translationImpl.setUuid("");
		}
		else {
			translationImpl.setUuid(uuid);
		}

		translationImpl.setId(id);
		translationImpl.setGroupId(groupId);
		translationImpl.setCompanyId(companyId);
		translationImpl.setUserId(userId);

		if (userName == null) {
			translationImpl.setUserName("");
		}
		else {
			translationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			translationImpl.setCreateDate(null);
		}
		else {
			translationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			translationImpl.setModifiedDate(null);
		}
		else {
			translationImpl.setModifiedDate(new Date(modifiedDate));
		}

		translationImpl.setModifiedBy(modifiedBy);

		if (modifiedByName == null) {
			translationImpl.setModifiedByName("");
		}
		else {
			translationImpl.setModifiedByName(modifiedByName);
		}

		translationImpl.setDeleted(deleted);

		if (languageCode == null) {
			translationImpl.setLanguageCode("");
		}
		else {
			translationImpl.setLanguageCode(languageCode);
		}

		if (modelName == null) {
			translationImpl.setModelName("");
		}
		else {
			translationImpl.setModelName(modelName);
		}

		if (columnName == null) {
			translationImpl.setColumnName("");
		}
		else {
			translationImpl.setColumnName(columnName);
		}

		if (text == null) {
			translationImpl.setText("");
		}
		else {
			translationImpl.setText(text);
		}

		translationImpl.setRecordId(recordId);

		translationImpl.resetOriginalValues();

		return translationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
		modifiedByName = objectInput.readUTF();

		deleted = objectInput.readBoolean();
		languageCode = objectInput.readUTF();
		modelName = objectInput.readUTF();
		columnName = objectInput.readUTF();
		text = objectInput.readUTF();

		recordId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);

		if (modifiedByName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedByName);
		}

		objectOutput.writeBoolean(deleted);

		if (languageCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languageCode);
		}

		if (modelName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modelName);
		}

		if (columnName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(columnName);
		}

		if (text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(text);
		}

		objectOutput.writeLong(recordId);
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long modifiedBy;
	public String modifiedByName;
	public boolean deleted;
	public String languageCode;
	public String modelName;
	public String columnName;
	public String text;
	public long recordId;

}