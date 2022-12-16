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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;lms_common_Translation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Translation
 * @generated
 */
public class TranslationTable extends BaseTable<TranslationTable> {

	public static final TranslationTable INSTANCE = new TranslationTable();

	public final Column<TranslationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TranslationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, String> modifiedByName = createColumn(
		"modifiedByName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, Boolean> deleted = createColumn(
		"deleted", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, String> languageCode = createColumn(
		"languageCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, String> modelName = createColumn(
		"modelName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, String> columnName = createColumn(
		"columnName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, String> text = createColumn(
		"text_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TranslationTable, Long> recordId = createColumn(
		"recordId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TranslationTable() {
		super("lms_common_Translation", TranslationTable::new);
	}

}