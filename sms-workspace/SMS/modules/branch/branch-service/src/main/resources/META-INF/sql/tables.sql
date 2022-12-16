create table sms_Branch (
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
	code_ VARCHAR(75) null,
	numberOfSeat INTEGER
);