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

package com.armantec.sms.branch.model.impl;

import com.armantec.sms.branch.model.Branch;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Branch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BranchCacheModel implements CacheModel<Branch>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BranchCacheModel)) {
			return false;
		}

		BranchCacheModel branchCacheModel = (BranchCacheModel)object;

		if (id == branchCacheModel.id) {
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
		StringBundler sb = new StringBundler(25);

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
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", numberOfSeat=");
		sb.append(numberOfSeat);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Branch toEntityModel() {
		BranchImpl branchImpl = new BranchImpl();

		if (uuid == null) {
			branchImpl.setUuid("");
		}
		else {
			branchImpl.setUuid(uuid);
		}

		branchImpl.setId(id);
		branchImpl.setGroupId(groupId);
		branchImpl.setCompanyId(companyId);
		branchImpl.setUserId(userId);

		if (userName == null) {
			branchImpl.setUserName("");
		}
		else {
			branchImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			branchImpl.setCreateDate(null);
		}
		else {
			branchImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			branchImpl.setModifiedDate(null);
		}
		else {
			branchImpl.setModifiedDate(new Date(modifiedDate));
		}

		branchImpl.setDeleted(deleted);

		if (name == null) {
			branchImpl.setName("");
		}
		else {
			branchImpl.setName(name);
		}

		if (code == null) {
			branchImpl.setCode("");
		}
		else {
			branchImpl.setCode(code);
		}

		branchImpl.setNumberOfSeat(numberOfSeat);

		branchImpl.resetOriginalValues();

		return branchImpl;
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

		deleted = objectInput.readBoolean();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		numberOfSeat = objectInput.readInt();
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

		objectOutput.writeBoolean(deleted);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeInt(numberOfSeat);
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean deleted;
	public String name;
	public String code;
	public int numberOfSeat;

}