create table sms_Student (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deleted BOOLEAN,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	semester INTEGER,
	branchId LONG,
	doj DATE null
);