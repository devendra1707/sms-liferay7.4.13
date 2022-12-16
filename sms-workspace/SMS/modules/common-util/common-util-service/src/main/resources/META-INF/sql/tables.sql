create table lms_common_Translation (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	modifiedBy LONG,
	modifiedByName VARCHAR(75) null,
	deleted BOOLEAN,
	languageCode VARCHAR(2048) null,
	modelName VARCHAR(75) null,
	columnName VARCHAR(75) null,
	text_ TEXT null,
	recordId LONG
);